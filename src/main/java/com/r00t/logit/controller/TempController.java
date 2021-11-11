package com.r00t.logit.controller;

import com.r00t.logit.aspect.log.LoggerRules;
import com.r00t.logit.payload.Payload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@LoggerRules(
        logBefore = true,
        excludeBody = false,

        logAfter = true,
        excludeResponseBody = false,

        // for java 2 byte for 1 character
        // totalByteSize = text.length() * 2
        bodiesCharLimit = 50,
        disableDynamicLogging = false
)
public class TempController {

    @PostMapping("/method")
    public ResponseEntity<?> temp(@RequestBody Payload request) {
        Payload response = new Payload();
        response.setSmallText("Sed ante purus, volutpat id ex at, dapibus malesuada velit");
        response.setLongText("Sed euismod ac nunc non hendrerit. Duis eget auctor nisi. " +
                                     "Maecenas velit massa, imperdiet a massa eu, mollis accumsan tortor. " +
                                     "Integer at nibh felis. Suspendisse semper diam eget urna lacinia volutpat.");
        return ResponseEntity.ok(response);
    }
}
