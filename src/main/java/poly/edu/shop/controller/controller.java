package poly.edu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("quenmatkhau")
    public String qmk(){
        return "quenmatkhau";
    }
    
        @RequestMapping("trangchu")
        public String trangchu(){
            return "trangchuadmin";
        }
}
