package kr.swu.spring_mvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// 클래스 위에 해당 애너테이션을 붙이면, 전체 메서드에 앞서서 붙을 접두주소를 지정합니다.
@RequestMapping("reqres")
public class RequestController2 {

    @RequestMapping("login-form")
    public String goLoginForm(){
        // localhost:8080/reqres/login-form
        // /WEB-INF/views/reqres/loginform.jsp로 연결
        // 폴더를 앞에 reqres로 생성하고 거기에 loginform.jsp를 생성해야함
        return "reqres/loginform";
    }

    // @RequestMapping 애너테이션의 value(기본지정)은 주소, method는 허용메서드
    @RequestMapping(value="login", method= RequestMethod.POST)
    public String checkLoginReq( // id, pw 라는 변수에 담겨오는값 처리
            @RequestParam("id") String id,
            @RequestParam("pw") String pw){
        System.out.println("로그인 요청 아이디 : " + id);
        System.out.println("로그인 요청 비번 : " + pw);
        return "loginresult";
    }



}
