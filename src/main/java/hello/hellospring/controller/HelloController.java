package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //controller를 사용할때는 항상 써주자
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //resources에 있는 templates 안에 있는 hello.html의 부분을 연결 시켜줌
    }

    //localhost:9090/hello-mvc?name=yuchan 이런 형식으로 해야 한다
   @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //@RequestParam 오노테이션은 URL의 쿼리 파라미터에 대한 값을 받아오는 기능을 하고 있다
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
