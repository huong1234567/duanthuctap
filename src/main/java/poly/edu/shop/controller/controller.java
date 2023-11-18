package poly.edu.shop.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.shop.dao.AccountDAO;
import poly.edu.shop.model.Account;
import poly.edu.shop.model.Mailer;

@Controller
public class controller {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "quenmatkhau";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, Model model) {
        // Kiểm tra xem email có tồn tại trong cơ sở dữ liệu hay không
        Account foundAccount = accountDAO.findByEmail(email);

        if (foundAccount != null) {
            // Gán giá trị cho model attributes
            model.addAttribute("fullName", foundAccount.getFullName());
            model.addAttribute("email", foundAccount.getEmail());
            model.addAttribute("imageUrl", foundAccount.getPhoto());
            return "result";

        } else {
            model.addAttribute("message", "Email không tồn tại trong hệ thống.");
            model.addAttribute("redirectBack", true); // Cần chuyển hướng trở lại trang nhập email
            return "quenmatkhau";
        }

    }

    @GetMapping("/emailForm")
    public String showEmailForm(Model model) {
        model.addAttribute("emailForm", new Mailer());
        return "emailForm";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("emailForm") Mailer emailForm) {
        // Gửi email ở đây
        try {
            send(emailForm.getTo(), emailForm.getSubject(), emailForm.getBody());
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý lỗi gửi email
        }

        return "redirect:/emailForm";
    }

    private void send(String to, String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        javaMailSender.send(message);
    }
}
