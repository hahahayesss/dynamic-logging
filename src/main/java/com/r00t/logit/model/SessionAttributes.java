package com.r00t.logit.model;

import lombok.Data;

@Data
public class SessionAttributes {
    private String method;
    private String requestURI;
    private String remoteAddr;
}
