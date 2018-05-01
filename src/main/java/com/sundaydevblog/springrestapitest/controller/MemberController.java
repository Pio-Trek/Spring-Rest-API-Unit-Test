package com.sundaydevblog.springrestapitest.controller;

import com.sundaydevblog.springrestapitest.entity.Member;
import com.sundaydevblog.springrestapitest.exception.CustomException;
import com.sundaydevblog.springrestapitest.exception.CustomResponse;
import com.sundaydevblog.springrestapitest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    static String URI = "/api/members/";

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> fetchAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Member> findMemberById(@PathVariable("id") Long id) throws CustomException {
        return Optional.of(memberService.getMemberById(id)
                .orElseThrow(() -> new CustomException("Member with ID: '" + id + "' not found.")));
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Member saveMember(@RequestBody @Validated Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Member updateMember(@RequestBody @Validated Member member) throws CustomException {
        if (memberService.getMemberById(member.getId()).isPresent()) {
            return memberService.saveMember(member);
        } else {
            throw new CustomException("Member with ID: '" + member.getId() + "' not found.");
        }
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> removeMember(@PathVariable("id") long id) {
        if (memberService.getMemberById(id).isPresent()) {
            this.memberService.removeMember(id);
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.OK.value(),
                            "Member with ID: '" + id + "' deleted."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new CustomResponse(HttpStatus.NOT_FOUND.value(),
                            "Member with ID: '" + id + "' not found."), HttpStatus.NOT_FOUND);
        }
    }
}
