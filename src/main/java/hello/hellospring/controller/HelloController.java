package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controller를 사용할때는 항상 써주자
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //resources에 있는 templates 안에 있는 hello.html의 부분을 연결 시켜줌
    }
}
