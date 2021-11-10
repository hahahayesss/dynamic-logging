package com.r00t.logit.aspect.extra;

import com.r00t.logit.model.AdminUser;
import lombok.Data;

@Data
public class SessionHolder {
    private AdminUser adminUser;
    private String appKey;
}
