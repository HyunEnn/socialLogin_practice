package social.logintest.oauth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import social.logintest.domain.Member;
import social.logintest.oauth.repository.MemberRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> members() {
        List<Member> result = memberRepository.findAll();
        return ResponseEntity.ok().body(result);
    }
}
