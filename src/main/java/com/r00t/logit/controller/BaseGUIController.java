package com.r00t.logit.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.r00t.logit.model.AdminUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public abstract class BaseGUIController {

    protected AdminUser getAdminUser() {
        /*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof AdminUser)) {
            return null;
        }

        return (AdminUser) principal;

         */
        return null;
    }

    protected String getAppKey() {
        /*
        NmRequestContext context = NmThreadLocal.get();
        if (context == null) {
            return null;
        }
        return context.getAppKey();

         */
        return null;
    }

    protected double getClientTimeZoneOffSet() {
        /*
        final NmRequestContext context = NmThreadLocal.get();
        if (context == null) {
            return 0;
        }
        return context.getTimezoneHourOffset();

         */
        return -1.0;
    }

    protected Long getAppId() {
        /*
        NmRequestContext context = NmThreadLocal.get();
        if (context == null) {
            return null;
        }
        return context.getNumericId();

         */
        return null;
    }

    protected Long getBusinessUnitId() {
        /*
        NmRequestContext context = NmThreadLocal.get();
        if (context == null) {
            return null;
        }
        return context.getBusinessUnitId();

         */
        return null;
    }

    protected void logUserAction(HttpServletRequest request, String action) {
        logUserAction(request, action, null, null, true, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, boolean persist) {
        logUserAction(request, action, null, null, persist, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, Object key) {
        logUserAction(request, action, null, key, true, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, String description) {
        logUserAction(request, action, description, null, true, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, Object key, boolean persist) {
        logUserAction(request, action, null, key, persist, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, Object key, boolean persist, boolean qRadar) {
        logUserAction(request, action, null, key, persist, qRadar);
    }

    protected void logUserAction(HttpServletRequest request, String action, String description, Object key) {
        logUserAction(request, action, description, key, true, false);
    }

    protected void logUserAction(HttpServletRequest request, String action, String description, Object key, boolean persist, boolean qRadar) {
        /*
        AdminUser user = getAdminUser();
        String date = LOG_DATE_FORMAT.format(getDate());
        String username = user != null ? user.getUsername() : "Anonymous";
        String ip = WebUtils.getClientIP(request);
        String appKey = getAppKey();
        Locale locale = request.getLocale();
        String country = locale != null ? locale.getCountry() : null;

        if (qRadar) {
            try {
                String serverIp = InetAddress.getLocalHost().getHostAddress();
                logger.info("ACCESS_LOG|Date:{}|appKey:{}|user:{}|CLIENT_IP:{}|SERVER_IP:{}|action:{}|key:{}", date, appKey, username, ip, serverIp, action, key);
            } catch (Exception e) {
                logger.error(e, "An error occurred when writing qRadar log to audit file");
            }
        } else {
            logger.info("ACCESS_LOG|Date:{}|appKey:{}|user:{}|IP:{}|country:{}|action:{}|key:{}", date, appKey, username, ip, country, action, key, description);
        }

        if (user != null && persist) {
            String userFullName = user.getName() + " " + user.getSurname();
            logService.addAuditLog(appKey, user.getAppUserId(), userFullName, action, description, ip);
        }

         */
    }

    protected Date getDate() {
        /*
        return new Date();
         */
        return null;
    }

    protected String getAdminUserNameSurname() {
        /*
        AdminUser user = getAdminUser();
        if (user == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.isBlank(user.getName()) ? "" : user.getName());
        sb.append(StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getSurname()) ? "" : " ");
        sb.append(StringUtils.isBlank(user.getSurname()) ? "" : user.getSurname());

        String nameSurname = sb.toString().trim();
        if (nameSurname.length() == 0) {
            return user.getUsername();
        }

        return nameSurname;

         */
        return null;
    }

    protected ResponseEntity<Object> createBooleanResponse(Boolean result, HttpStatus httpStatus) {
        /*
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", result);
        return new ResponseEntity<>(map, httpStatus);

         */
        return ResponseEntity.ok(null);
    }

    protected boolean autoLogin(AdminUser adminUser, HttpServletRequest req, HttpServletResponse res) {
        /*
        boolean otpRequired = adminUserService.isTwoFaceAuthenticationRequired(adminUser.getAppUserId());

        if (otpRequired) {
            return false;
        } else {
            adminUser.setLastLoginTime(new Date());
            adminUser.setLastHostAddress(req.getRemoteAddr());
            ESAPI.authenticator().setCurrentUser(adminUser);
            rememberMeServices.loginSuccess(req, res, SecurityContextHolder.getContext().getAuthentication());
            return true;
        }

         */
        return false;
    }

    protected Object redirectTo(String url) {
        /*
        return "redirect:" + url;

         */
        return null;
    }

    protected void checkServiceLimit(String serviceName, int currentUsage) {
        /*
        String appKey = getAppKey();
        if (appKey == null || StringUtils.equals(NetmeraConstants.GLOBAL_DATA_APP_KEY, appKey)) {
            throw new NetmeraRuntimeException(NetmeraError.EC_SERVICE_USAGE_NOT_ALLOWED);
        }

        Application app = appService.cacheable().getApplicationByAppKey(appKey);
        if (app == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_SERVICE_USAGE_NOT_ALLOWED);
        }

        OfferSO offer = subscriptionService.cacheable().getOfferById(app.getCurrentOfferId());
        if (offer == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_SERVICE_USAGE_NOT_ALLOWED);
        }

        PricingPlanSO plan = offer.getPricingPlanByService(serviceName);
        if (plan == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_SERVICE_USAGE_NOT_ALLOWED);
        }

        if (plan.getUsageLimit() <= currentUsage) {
            throw new NetmeraRuntimeException(NetmeraError.EC_SERVICE_QUOTA_EXCEEDED);
        }

         */
    }

    protected JsonNode parseJsonString(String data) {
        /*
        try {
            return mapper.readTree(data);
        } catch (IOException e) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_JSON);
        }

         */
        return null;
    }

    protected void validateBusinessUnit(Long id) {
        /*
        Long businessUnitId = getBusinessUnitId();
        if (businessUnitId != null && id != null) {
            if (id.intValue() != businessUnitId.intValue()) {
                throw new NetmeraRuntimeException(EC_SERVICE_NO_PERMISSION);
            }
        }

         */
    }
}
