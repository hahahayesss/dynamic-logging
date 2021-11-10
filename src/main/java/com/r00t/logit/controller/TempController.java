package com.r00t.logit.controller;

import com.r00t.logit.aspect.extra.AdminUser;
import com.r00t.logit.aspect.extra.AppKey;
import com.r00t.logit.model.SessionHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp")
public class TempController {

    @GetMapping("/one")
    public ResponseEntity<?> getOne() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/two")
    public ResponseEntity<?> getTwo(@AppKey String appKey,
                                 @AdminUser Object adminUser) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/three")
    public ResponseEntity<?> getThree(SessionHolder sessionHolder) {
        System.out.println(sessionHolder.getAppKey());
        System.out.println(sessionHolder.getAdminUser());
        return ResponseEntity.ok(null);
    }
}
