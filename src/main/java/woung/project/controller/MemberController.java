package woung.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import woung.project.domain.Member;
import woung.project.repository.MemberRepository;
import woung.project.repository.MemoryMemberRepository;
import woung.project.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")//메인페이지
    public String Hello(){
        return "home";
    }

    @GetMapping("/member/join") // 회원가입
    public String createForm(){
        return "member/createMemberForm";
    }

    @PostMapping(value = "/member/join")
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        member.setPwd(form.getPassword());
        member.setAddr(form.getAddr());

        memberService.join(member);
        return "redirect:/member/welcome";
    }

    @GetMapping("/member/welcome")
    public String welcome(Model model){

        model.addAttribute("user",memberRepository.findAll());
        return "member/welcome";
    }

    @GetMapping("/member/find") // 회원조회
    public String find(){
        return "member/find";
    }

    @GetMapping("/member/modify") // 회원정보수정
    public String modify(){
        return "member/modify";
    }

    @GetMapping("/member/out") // 회원탈퇴
    public String out(){
        return "member/out";
    }
}
