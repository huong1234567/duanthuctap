package poly.edu.shop.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class Mailer {
    String from;
    String to;
    String[] cc;
    String[] bcc;
    String subject;
    String body;
    String[] attachments;

    public Mailer(String to, String subject, String body) {
        this.from = "poly@fpt.edu.vn";
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
