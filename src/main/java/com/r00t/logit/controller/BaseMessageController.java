package com.r00t.logit.controller;

import com.r00t.logit.model.*;
import com.r00t.logit.payload.request.Message;
import com.r00t.logit.payload.request.SaveMessageRequest;

public abstract class BaseMessageController extends BaseGUIController {

    protected Message convertRequestToMessage(SaveMessageRequest request) {
        /*
        Message message;

        if (request.getMsgType() == MsgType.PUSH) {
            message = convertRequestToPushMessage(request);
        } else if (request.getMsgType() == MsgType.POPUP) {
            message = convertRequestToPopupMessage(request);
        } else if (request.getMsgType() == MsgType.IN_APP_MESSAGE) {
            message = convertRequestToInAppMessage(request);
        } else if (request.getMsgType() == MsgType.INTERACTIVE_PUSH) {
            message = convertRequestToInteractivePushMessage(request);
        } else if (request.getMsgType() == MsgType.SMS) {
            message = convertRequestToSmsMessage(request);
        } else if (request.getMsgType() == MsgType.WEB_PUSH) {
            message = convertRequestToWebPushMessage(request);
        } else if (request.getMsgType() == MsgType.EMAIL) {
            message = convertRequestToEmailMessage(request);
        } else {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message type could not be recognized!");
        }

        message.setAppKey(getAppKey());
        message.setCategory(request.getCategory());
        message.setTitle(request.getTitle());
        message.setSmsHeader(request.getSmsHeader());
        message.setMessage(request.getMessage());
        message.setTranslatableFieldsMap(request.getTranslatableFieldsMap());
        message.setRichTitle(request.getRichTitle());
        message.setPersonalizedTitle(request.getPersonalizedTitle());
        message.setRichSubText(request.getRichSubText());
        message.setPersonalizedMessage(request.getPersonalizedMessage());
        message.setMsgType(request.getMsgType());
        message.setCampaignStyle(request.getCampaignStyle());
        message.setMsgMethod(request.getMsgMethod());
        message.setPlatforms(request.getPlatforms());
        message.setSendStatus(request.getSendStatus());
        message.setTargeting(convertRequestToMsgTarget(request));
        message.setTracking(request.getTracking());
        message.setDeliverySpeed(request.getDeliverySpeed());
        message.setSchedule(request.getMsgSchedule());
        message.setCopsReportInput(request.getCopsReportInput());
        message.setFtpPush(request.isFtpPush());
        message.setIysCheckActive(request.isIysCheckActive());
        message.setCampaignUniqueId(request.getCampaignUniqueId());
        PushClickAction pushClickAction = request.getPushClickAction();
        if (pushClickAction != null && pushClickAction.getTemplateComponents() != null) {
            for (DynamicTemplateComponent comp : pushClickAction.getTemplateComponents()) {
                if ("TEXT".equals(comp.getType()) && comp.getArgs().size() == 0) {
                    Map<String, String> arg = new HashMap<>();
                    arg.put(comp.getKey(), "");
                    comp.setArgs(arg);
                }
            }
        }

        message.setPushClickAction(request.getPushClickAction());
        message.setLimitAware(BooleanUtils.isNotFalse(request.getLimitAware()));
        message.setGeofence(request.getGeofence());
        message.setTimeRestriction(request.getTimeRestriction());
        message.setAllowApiOverride(BooleanUtils.isTrue(request.getAllowApiOverride()));
        message.setTriggerGoal(request.getTriggerGoal());
        message.setConversionAnalytics(request.getConversionAnalytics());
        message.setSampleRate(request.getSampleRate());
        message.setMsgFallback(request.getMsgFallback());
        message.setLimitNotifs(request.getLimitNotifs());
        message.setTotalLimit(request.getTotalLimit());
        message.setDeviceSpecific(BooleanUtils.isTrue(request.getDeviceSpecific()));
        message.setProductId(request.getProductId());
        message.setMessageLabelActive(request.isMessageLabelActive());
        message.setLabel(request.getLabel());
        message.setContextParams(request.getContextParams());
        message.setDefaultMessageActive(request.isDefaultMessageActive());
        message.setDefaultTitleActive(request.isDefaultTitleActive());
        message.setChannelId(request.getChannelId());
        message.setOptimoveChannelId(request.getOptimoveChannelId());
        message.setThumbnailUrl(request.getThumbnailUrl());
        message.setPriority(request.getPriority());
        message.setTestPrefixHidden(request.isTestPrefixHidden());
        message.setBusinessUnitIdIfUserIsBusinessUnit(getBusinessUnitId());
        message.setWebhooksDisabled(request.isWebhooksDisabled());
        message.setConvertShortUrl(request.isConvertShortUrl());
        message.setTtlString(request.getTtlString());

        if (request.getTriggerId() != null) {
            message.setTriggerId(request.getTriggerId().longValue());
        }

        return message;

         */
        return null;
    }

    protected MailTemplate convertRequestToMailTemplate(SaveMessageRequest request) {
        /*
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setReplyTo(request.getReplyTo());
        mailTemplate.setSubject(request.getSubject());
        mailTemplate.setFrom(request.getFrom());
        mailTemplate.setSenderName(request.getSenderName());
        mailTemplate.setCss(request.getCss());
        mailTemplate.setHtml(request.getHtml());
        mailTemplate.setLabel(request.getMailLabel());
        mailTemplate.setId(request.getMailTemplateId());

        return mailTemplate;

         */
        return null;
    }

    protected PushMessage convertRequestToPushMessage(SaveMessageRequest request) {
        /*
        PushMessage pushMessage = new PushMessage();
        convertRequestToPushMessage(pushMessage, request);
        return pushMessage;

         */
        return null;
    }

    protected PopupMessage convertRequestToPopupMessage(SaveMessageRequest request) {
        /*
        PopupMessage popupMessage = new PopupMessage();
        popupMessage.setPopupTracking(request.getPopupTracking());
        convertRequestToPushMessage(popupMessage, request);
        return popupMessage;

         */
        return null;
    }

    protected InAppMessage convertRequestToInAppMessage(SaveMessageRequest request) {
        /*
        InAppMessage inAppMessage = new InAppMessage();

        if (request.getTemplateId() != null) {
            switch (request.getTemplateId()) {
                case NO_IMAGE:
                    inAppMessage.setTemplateId(InAppMsgTemplateType.NO_IMAGE.getIntValue());
                    break;
                case IMAGE_AND_TEXT:
                    inAppMessage.setTemplateId(InAppMsgTemplateType.IMAGE_AND_TEXT.getIntValue());
                    break;
                case FULL_IMAGE:
                    inAppMessage.setTemplateId(InAppMsgTemplateType.FULL_IMAGE.getIntValue());
                    break;
            }
        }

        if (request.getDirection() != null) {
            switch (request.getDirection()) {
                case DIRECTION_LEFT:
                    inAppMessage.setDirection(InAppDirectionType.DIRECTION_LEFT.getByteValue());
                    break;
                case DIRECTION_RIGHT:
                    inAppMessage.setDirection(InAppDirectionType.DIRECTION_RIGHT.getByteValue());
                    break;
            }
        }

        inAppMessage.setInAppText(request.getInAppText());
        inAppMessage.setInAppTitle(request.getInAppTitle());
        inAppMessage.setImageUrl(request.getInAppImageUrl());
        inAppMessage.setTimeToLive(request.getTimeToLive());
        inAppMessage.setPersonalizedInAppText(request.getPersonalizedInAppText());
        inAppMessage.setDefaultPersonalizedInAppTextActive(request.isDefaultPersonalizedInAppTextActive());
        inAppMessage.setFontSize(request.getFontSize());
        inAppMessage.setFontColor(request.getFontColor());
        inAppMessage.setFontType(request.getFontType());
        inAppMessage.setBorderRadius(request.getBorderRadius());
        inAppMessage.setPaddingTop(request.getPaddingTop());
        inAppMessage.setPaddingBottom(request.getPaddingBottom());
        inAppMessage.setPaddingLeft(request.getPaddingLeft());
        inAppMessage.setPaddingRight(request.getPaddingRight());
        inAppMessage.setBackgroundColor(request.getBackgroundColor());
        inAppMessage.setOverrideMobileConfig(request.isOverrideMobileConfig());

        convertRequestToPushMessage(inAppMessage, request);
        return inAppMessage;

         */
        return null;
    }

    protected InteractivePushMessage convertRequestToInteractivePushMessage(SaveMessageRequest request) {
        /*
        InteractivePushMessage interactivePushMessage = new InteractivePushMessage();
        interactivePushMessage.setButtonSet(request.getButtonSet());
        interactivePushMessage.setTrackInteractiveUsers(request.getTrackInteractiveUsers());
        convertRequestToPushMessage(interactivePushMessage, request);
        return interactivePushMessage;
    }

    protected SmsMessage convertRequestToSmsMessage(SaveMessageRequest request) {
        /*
        SmsMessage smsMessage = new SmsMessage();
        smsMessage.setSendPushIfUserHasApp(request.getSendPushIfUserHasApp());
        if (request.getSmsIysMessageType() != null) {
            smsMessage.setSmsIysMessageType(request.getSmsIysMessageType());
        }

        if (request.getSmsIysRecipientType() != null) {
            smsMessage.setSmsIysRecipientType(request.getSmsIysRecipientType());
        }
        smsMessage.setMsgExpiration(request.getMsgExpiration());
        return smsMessage;

         */
        return null;
    }

    private void convertRequestToPushMessage(PushMessage pushMessage, SaveMessageRequest request) {
        /*
        pushMessage.setAndroidPushStyle(request.getAndroidPushStyle());
        pushMessage.setIosPushStyle(request.getIosPushStyle());
        pushMessage.setPushTile(request.getPushTile());
        pushMessage.setVibration(request.getVibration());
        pushMessage.setPushInbox(request.getPushInbox());
        pushMessage.setDoNotShowOnNotificationCenter(request.getDoNotShowOnNotificationCenter());
        pushMessage.setPushInboxOptOut(request.getPushInboxOptOut());
        pushMessage.setPushSound(request.getPushSound());
        pushMessage.setPushClickAction(request.getPushClickAction());
        pushMessage.setMsgExpiration(request.getMsgExpiration());
        pushMessage.setIosCarouselType(request.getIosCarouselType());
        pushMessage.setIosSliderType(request.getIosSliderType());
        pushMessage.setCustomJson(request.getCustomJson());

         */
    }

    private WebpushMessage convertRequestToWebPushMessage(SaveMessageRequest request) {
        /*
        WebpushMessage webpushMessage = new WebpushMessage();
        webpushMessage.setWpTitle(request.getWpTitle());

        String pushIconUrl = request.getWpImage();
        if (StringUtils.isEmpty(pushIconUrl)) {
            EmspConfig config = emspConfigService.getAppEmspConfig(getAppKey());
            if (config != null && StringUtils.isNotEmpty(config.getChromeDefaultPushIconUrl())) {
                pushIconUrl = config.getChromeDefaultPushIconUrl();
            }
        }

        webpushMessage.setWpImage(pushIconUrl);
        webpushMessage.setWpImageUrl(request.getWpImageUrl());
        webpushMessage.setWpButtonActive(request.isWpButtonActive());
        webpushMessage.setUserInteractionReq(request.isUserInteractionReq());
        webpushMessage.setButtonSet(request.getButtonSet());
        webpushMessage.setMsgExpiration(request.getMsgExpiration());
        webpushMessage.setDeliverySpeed(request.getDeliverySpeed());

        return webpushMessage;

         */
        return null;
    }

    private EmailMessage convertRequestToEmailMessage(SaveMessageRequest request) {
        /*
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom(request.getFrom());
        emailMessage.setSubject(request.getSubject());
        emailMessage.setHtml(request.getHtml());
        emailMessage.setHtmlBody(request.getHtmlBody());
        emailMessage.setCss(request.getCss());
        emailMessage.setMailTemplateId(request.getMailTemplateId());
        emailMessage.setSenderName(request.getSenderName());
        emailMessage.setReplyTo(request.getReplyTo());
        emailMessage.setMsgExpiration(request.getMsgExpiration());
        return emailMessage;
         */
        return null;
    }

    protected MsgTarget convertRequestToMsgTarget(SaveMessageRequest request) {
        /*
        MsgTarget target = new MsgTarget();

        HashMap<String, Object> categoryCondition = request.getCategories();
        if (MapUtils.isNotEmpty(categoryCondition)) {
            target.setCategory(GuiConverter.convertMapToCondition(categoryCondition));
        }

        if (BooleanUtils.isTrue(request.getSendToAll())) {
            target.setSendToAll(true);
        } else if (request.getGroup() != null) {
            target.setGroupCondition(GuiConverter.convertMapToRawConditions(request.getGroup()));
        } else {
            target.setSendToAll(false);
            if (request.getDistributionListId() == null) {
                HashMap<String, Object> tagsCondition = request.getTags();
                if (MapUtils.isNotEmpty(tagsCondition)) {
                    target.setTags(GuiConverter.convertMapToCondition(tagsCondition));
                }

                HashMap<String, Object> serviceProviderCondition = request.getServiceProvider();
                if (MapUtils.isNotEmpty(serviceProviderCondition)) {
                    target.setServiceProvider(GuiConverter.convertMapToCondition(serviceProviderCondition));
                }

                HashMap<String, Object> segmentsCondition = request.getSegments();
                if (MapUtils.isNotEmpty(segmentsCondition)) {
                    target.setSegments(GuiConverter.convertMapToCondition(segmentsCondition));
                }

                HashMap<String, Object> profileCondition = request.getProfile();
                if (MapUtils.isNotEmpty(profileCondition)) {
                    target.setProfile(GuiConverter.convertMapToCondition(profileCondition));
                }

                HashMap<String, Object> behaviorCondition = request.getBehaviors();
                if (MapUtils.isNotEmpty(behaviorCondition)) {
                    target.setBehavior(GuiConverter.convertMapToCondition(behaviorCondition));
                }

                HashMap<String, Object> locationCondition = request.getLocation();
                if (MapUtils.isNotEmpty(locationCondition)) {
                    target.setLocation(GuiConverter.convertMapToCondition(locationCondition));
                }

                HashMap<String, Object> deviceModelCondition = request.getDeviceModel();
                if (MapUtils.isNotEmpty(deviceModelCondition)) {
                    target.setDeviceModel(GuiConverter.convertMapToCondition(deviceModelCondition));
                }

                HashMap<String, Object> appVersionCondition = request.getAppVersion();
                if (MapUtils.isNotEmpty(appVersionCondition)) {
                    target.setAppVersion(GuiConverter.convertMapToCondition(appVersionCondition));
                }

                HashMap<String, Object> operatingSystemCondition = request.getOperatingSystem();
                if (MapUtils.isNotEmpty(operatingSystemCondition)) {
                    target.setOperatingSystem(GuiConverter.convertMapToCondition(operatingSystemCondition));
                }

                HashMap<String, Object> telcoOperatorCondition = request.getTelcoOperator();
                if (MapUtils.isNotEmpty(telcoOperatorCondition)) {
                    target.setTelcoOperator(GuiConverter.convertMapToCondition(telcoOperatorCondition));
                }

                HashMap<String, Object> appTrackCondition = request.getAppTracking();
                if (MapUtils.isNotEmpty(appTrackCondition)) {
                    target.setAppTracking(GuiConverter.convertMapToCondition(appTrackCondition));
                }

                Map<String, Object> groupCondition = request.getGroup();
                if (MapUtils.isNotEmpty(groupCondition)) {
                    target.setGroupCondition(GuiConverter.convertMapToCondition(groupCondition));
                }

                Map<String, Object> sourceCondition = request.getSources();
                if (MapUtils.isNotEmpty(sourceCondition)) {
                    target.setSource(GuiConverter.convertMapToCondition(sourceCondition));
                }

                ResponseCondType responseCondType = request.getResponseCondType();
                Integer responseCondMsgId = request.getResponseCondMsgId();
                Integer responseCondLabelId = request.getResponseCondLabelId();
                ResponseCondMsgCriteriaType condMsgCriteriaType = request.getResponseCondMsgCriteriaType();
                if (responseCondType != null && condMsgCriteriaType != null && (responseCondMsgId != null || responseCondLabelId != null)) {
                    ResponseCondition respCond = new ResponseCondition();
                    switch (condMsgCriteriaType) {
                        case MESSAGE:
                            respCond.setMessageId(responseCondMsgId);
                            break;
                        case LABEL:
                            respCond.setLabelId(responseCondLabelId);
                            break;
                    }
                    respCond.setMsgCriteriaType(condMsgCriteriaType);
                    respCond.setResponseType(responseCondType);
                    target.setResponse(respCond);
                }

                Boolean pushEnabled = request.getPushEnabled();
                if (pushEnabled != null) {
                    if (MessageUtil.isNotOptOutFallBack(request.getMsgFallback())) {
                        target.setPermission(new PermissionCondition(pushEnabled));
                    }
                }

                Boolean lastDeviceEnabled = request.getLastDeviceEnabled();
                if (lastDeviceEnabled != null) {
                    target.setLastDevice(new LastDeviceCondition(lastDeviceEnabled));
                }

                Boolean appInstallationEnabled = request.getAppInstallationEnabled();
                if (appInstallationEnabled != null) {
                    target.setAppInstallation(new AppInstallationCondition(appInstallationEnabled));
                }

                Boolean adidEnabled = request.getAdidEnabled();
                if (adidEnabled != null) {
                    target.setAdidEnabled(new AdIdEnabledCondition(adidEnabled));
                }

                final HashMap<String, Object> promotionsCondition = request.getPromotions();
                if (MapUtils.isNotEmpty(promotionsCondition)) {
                    target.setPromotions(GuiConverter.convertMapToCondition(promotionsCondition));
                }

                final HashMap<String, Object> locationAuthorizationCondition = request.getLocationAuthorizations();
                if (MapUtils.isNotEmpty(locationAuthorizationCondition)) {
                    target.setLocationAuthorizations(GuiConverter.convertMapToCondition(locationAuthorizationCondition));
                }

                target.setTotalUserLimit(request.getTotalUserLimit());
            } else {
                target.setDistributionListIdLong(request.getDistributionListId());
            }
        }

        target.setPlatformLimit(request.getPlatformLimit());
        return target;

         */
        return null;
    }
}
