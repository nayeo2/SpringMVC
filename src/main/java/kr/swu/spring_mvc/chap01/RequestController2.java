package kr.swu.spring_mvc.chap01;

import kr.swu.spring_mvc.chap01.domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    //@RequestMapping(value="login", method= RequestMethod.POST)
    @PostMapping("login")
    public String checkLoginReq( // id, pw 라는 변수에 담겨오는값 처리
            @RequestParam(value = "id", defaultValue = "아이디없음") String id,
            @RequestParam(value = "pw", defaultValue = "비번없음") String pw,
            Model model){
        System.out.println("로그인 요청 아이디 : " + id);
        System.out.println("로그인 요청 비번 : " + pw);
        // 자바 내부에 들어온 데이터를 화면(loginresult.jsp)으로 보내기 위해서는
        // addAttribute("보낼이름", 자료)가 필요합니다.
        model.addAttribute("uid", id); //id 변수에 든 값을 "uid"라는 이름으로 전달
        model.addAttribute("upw", pw);
        return "reqres/loginresult";
    }

    // /reqres/human
    @GetMapping("human") // get방식만 허용하는 컨트롤러
    public String showHuman(Human human, Model model){// 화면으로 자료보내줌
        System.out.println(human);
        // 커맨드 객체의 경우는 객체 째로 보냅니다.
        model.addAttribute("human", human);
        return "reqres/human-result";
    }

    // human-form 주소로 접속했을때 human에 해당하는 데이터들을
    // 화면에 보여줄 수 있는 .jsp파일을 직접 작성해주세요.
    // 해당 주소로 접속하면 form페이지가 나오고 여기서 제출버튼을 누르면
    // 커맨드객체 human이 해당 페이지에서 보낸 자료를 받습니다.
    @GetMapping("human-form")
    public String goHumanForm(){
        return "reqres/human-form";
    }

    @GetMapping("book/{page}")
    public String digitalBook(@PathVariable int page, Model model){
        model.addAttribute("page", page);
        return "digital-book";
    }

    @GetMapping("naver")
    public String goNaver(){
        // 네이버로 강제로 이동시키기
        return "redirect:https://www.naver.com";
    }

    // 서울여대 홈페이지로 리다이렉트 되는 엔드포인트를 직접 설정해주세요.
    @GetMapping("swu")
    public String goSWU(){
        return "redirect:http://www.swu.ac.kr/index.do";
    }


}
