package com.r00t.logit.controller;

import com.r00t.logit.aspect.extra.AppKey;
import com.r00t.logit.aspect.extra.SessionHolder;
import com.r00t.logit.payload.request.*;
import com.r00t.logit.payload.response.BusinessUnit;
import com.r00t.logit.payload.response.ResponseCondition;
import com.r00t.logit.payload.response.SaveMessageResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "message")
public class MessageController extends BaseMessageController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<?> getMessages(@AppKey String appKey, @RequestBody ListMessagesRequest request) {
        System.out.println(appKey);
        /*
        logUserAction(httpRequest, "GetMessages", false);
        logger.debug("getMessages::request::{}", request);

        int firstResults = request.getFirstResult();
        firstResults = (firstResults < 0) ? 0 : firstResults;
        int maxResults = request.getMaxResults();
        maxResults = (maxResults < 0 || maxResults > 100) ? 100 : maxResults;

        Map<Integer, TriggerModel> triggers = new HashMap<>();
        List<Message> messages = messageConfigurationService.getMessages(getAppKey(), request.getMsgMethodList(), request.getMsgSendStatusList(), firstResults, maxResults,
                getBusinessUnitId());
        for (Message message : messages) {
            if (message.getMsgMethod() == MsgMethod.AUTOMATED && message.getTriggerId() != null) {
                TriggerModel trigger = triggerService.getTriggerModel(getAppKey(), message.getTriggerId().intValue());
                triggers.put(message.getId(), trigger);
            }
        }

        return new ResponseEntity<>(new ListMessagesResponse(messages, triggers), HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "list-latest", method = RequestMethod.GET)
    public ResponseEntity<?> getLastMessageNames(Authentication authentication, @AppKey String appKey) {
        /*
        logUserAction(request, "GetLastMessages", false);

        List<Message> messageList = messageConfigurationService.getLastMessages(getAppKey(), getBusinessUnitId());
        List<Map> list = new ArrayList<>();

        for (Message m : messageList) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", m.getTitle());
            map.put("id", m.getId());
            list.add(map);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "sms-header-list", method = RequestMethod.GET)
    public ResponseEntity<?> getSmsHeaderList(SessionHolder sessionHolder) {
        /*
        logUserAction(request, "GetSmsHeaderList", false);

        SmscConfig smscConfig = appService.getSmscConfig(getAppKey());
        if (smscConfig == null) {
            smscConfig = new SmscConfig();
        }

        MobildevConfig mobildevConfig = appService.getMobildevConfig(getAppKey());
        if (mobildevConfig != null) {
            smscConfig.getSmsHeaderList().addAll(mobildevConfig.getSenderList());
        }

        JetSMSConfig jetSMSConfig = appService.getJetSMSConfig(getAppKey());
        if (jetSMSConfig != null) {
            smscConfig.getSmsHeaderList().addAll(jetSMSConfig.getSenderList());
        }

        TwilioConfig twilioConfig = appService.getTwilioConfig(getAppKey());
        if (twilioConfig != null && twilioConfig.getFromAddresses() != null) {
            smscConfig.getSmsHeaderList().addAll(twilioConfig.getFromAddresses());
        }

        return new ResponseEntity<>(smscConfig.getSmsHeaderList(), HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseEntity<?> getMessage(SessionHolder sessionHolder, MessageIdRequest request) {
        /*
        logUserAction(httpRequest, "GetMessage", request.getMessageId(), false);
        if (request.getMessageId() == 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Long businessUnitId = getBusinessUnitId();

        Message message = messageConfigurationService.getMessageByBusinessUnitId(getAppKey(), request.getMessageId(), businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MESSAGE_NOT_FOUND);
        }

        validateBusinessUnit(message.getBusinessUnitId());

        GetMessageResponse response = new GetMessageResponse(message);
        if (message.getMsgMethod().isAutomatedOrCatalog() && message.getTriggerId() != null) {
            TriggerModel trigger = triggerService.getTriggerModel(getAppKey(), message.getTriggerId().intValue());
            response.setTrigger(trigger);
        }

        if (message.getMsgMethod() == MsgMethod.AB_PARENT) {
            if (message.getFirstChildId() > 0) {
                Message child = messageConfigurationService.getMessageByBusinessUnitId(getAppKey(), message.getFirstChildId(), businessUnitId);
                response.setFirstChild(child);
            }

            if (message.getSecondChildId() > 0) {
                Message child = messageConfigurationService.getMessageByBusinessUnitId(getAppKey(), message.getSecondChildId(), businessUnitId);
                response.setSecondChild(child);
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<?> saveMessage(@RequestBody SaveMessageRequest request) {
        /*
        String appKey = getAppKey();
        int messageId = request.getMessageId();
        Message message = convertRequestToMessage(request);

        validateMessage(request, appKey, messageId, message, getBusinessUnitId());

        SaveMessageResponse response = constructSaveMessageResponseEntity(httpRequest, request, appKey, messageId, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "saveMessageCopsReportInput", method = RequestMethod.POST)
    public ResponseEntity<?> saveMessageCopsReportInput(@RequestBody SaveMessageRequest request) {
        /*
        String appKey = getAppKey();
        int messageId = request.getMessageId();

        Message message = convertRequestToMessage(request);

        SaveMessageResponse response = constructSaveMessageResponseEntity(httpRequest, request, appKey, messageId, message);
        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "getCustomProfileAttributes", method = RequestMethod.POST)
    public ResponseEntity<?> getCustomProfileAttributes(@RequestBody GetCustomProfileAttributesRequest request) {
        /*
        logUserAction(httpServletRequest, "GetCustomProfileAttributes", false);

        List<String> response = ftpMessageSenderService.getCustomProfileAttributeListFromEndpoint(request.getCampaignUniqueId());

        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "getCustomCategories", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomCategories(HttpServletRequest httpServletRequest) {
        /*
        logUserAction(httpServletRequest, "GetCustomCategories", false);

        List<String> response = ftpMessageSenderService.getCustomCategoriesFromEndpoint();

        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "sendToApproval", method = RequestMethod.POST)
    public ResponseEntity<?> sendToApproval(@RequestBody MessageIdRequest approvalRequest) {
        /*
        Integer messageId = approvalRequest.getMessageId();
        if (messageId == null || messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();
        Application currentApp = appService.getApplicationByAppKey(appKey);
        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);

        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MESSAGE_NOT_FOUND, "Message with given id not found!");
        }

        logUserAction(request, "SendToApproval", "Message with message id '" + messageId + "' and title '" + message.getTitle() + "' is sent to approval", messageId);
        Boolean messageApprovalActive = appService.isMessageApprovalActive(appKey);
        if (BooleanUtils.isFalse(messageApprovalActive)) {
            throw new NetmeraRuntimeException(NetmeraError.EC_APP_NOT_CONFIGURED_FOR_APPROVAL);
        }

        messageConfigurationService.handleApprovalSending(appKey, messageId);

        String privilegeToApproveMessage = systemPropertyHolder.getProperty(PRIVILEGE_APPROVE_MESSAGE);
        if (StringUtils.isNotBlank(privilegeToApproveMessage)) {
            Collection<String> emailsToSendMail = adminUserService.getUserEmailsByPrivilege(currentApp.getId(), privilegeToApproveMessage, businessUnitId);
            logger.info("sendToApproval::messageId::{}::emailsToSendMail::{}::businessUnitId::{}", messageId, emailsToSendMail, businessUnitId);

            if (!CollectionUtils.isEmpty(emailsToSendMail)) {
                String approvalLinkFormat = systemPropertyHolder.getProperty(MSG_URL_APPROVAL);
                if (StringUtils.isNotBlank(approvalLinkFormat)) {
                    String approvalLink = MessageFormat.format(approvalLinkFormat, netmeraDomainUrl, appKey, messageId.toString());

                    Map<String, Object> params = new HashMap<>();
                    params.put("title", message.getTitle());
                    params.put("sender", getAdminUserNameSurname());
                    params.put("appTitle", currentApp.getTitle());
                    params.put("pushLink", approvalLink);

                    List<String> bcc = systemPropertyHolder.getStringListProperty(MSG_MAIL_APPROVAL_BCC);
                    netmeraMailSender.sendEmail(appKey, SEND_APPROVAL_MAIL_TEMPLATE, emailsToSendMail, "Push Notification Approval Required", params, bcc);
                } else {
                    logger.info("sendToApproval::Message approval url is not configured. Skipping email.");
                }
            } else {
                logger.info("sendToApproval::no emails found to send approval email! Skipping email.");
            }

            List<String> userIdsToSendApprovalPush = adminUserService.getUserIdsByPrivilege(currentApp, privilegeToApproveMessage, businessUnitId);
            for (Platform platform : message.getPlatforms()) {
                messageTestService.sendTestMessageForApprovers(appKey, messageId, platform, userIdsToSendApprovalPush);
            }
        }

        return createBooleanResponse(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "approve", method = RequestMethod.POST)
    public ResponseEntity<?> approveMessage(@RequestBody MessageIdRequest request) {
        /*
        Integer messageId = request.getMessageId();
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        new TryUnderLockTask("Approve Message - " + appKey + " - " + messageId, logger, appKey + messageId) {
            @Override
            protected void executeTask() {
                if (messageId == null || messageId <= 0) {
                    throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
                }

                Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
                if (message == null) {
                    throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
                }

                if (message.getMsgType() == MsgType.EMAIL //
                        && !message.isFtpPush() //
                        && hasSetRowMailService(appKey)) {
                    String uniqueTemplateName = SetRowService.TEMPLATE_NAME_GENERATOR.get();
                    ((EmailMessage) message).setTemplateName(uniqueTemplateName);

                    String transcode = mailService.saveMailTemplateToSetRow( //
                            appKey, ((EmailMessage) message).getMailTemplateId(), uniqueTemplateName);
                    ((EmailMessage) message).setTranscode(transcode);

                    logger.info("updating message's transcode::{} and templateName::{}", //
                            ((EmailMessage) message).getTranscode(), ((EmailMessage) message).getTemplateName());
                    messageConfigurationService.updateMessage(appKey, messageId, message);
                }

                if (message.getMsgType() == MsgType.EMAIL) {
                    mailService.setCompressedHtmlContentToMessage((EmailMessage) message);
                }

                messageValidator.validateSendMessage(message);
                messageConfigurationService.approveMessage(appKey, messageId);

                String messageTitle = message.getTitle();
                logUserAction(httpRequest, "ApproveMessage", "Message with message id '" + messageId + "' and title '" + messageTitle + "' is approved", messageId);

                SendMessageCmd sendMessageCmd = new SendMessageCmd();
                sendMessageCmd.setAppKey(appKey);
                sendMessageCmd.setMessageId(messageId);

                requestPublisher.publish(sendMessageCmd);
            }
        }.run();
        return createBooleanResponse(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "reject", method = RequestMethod.POST)
    public ResponseEntity<?> rejectMessage(@RequestBody MessageIdRequest request) {
        /*
        Integer messageId = request.getMessageId();
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId == null || messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        String messageTitle = message.getTitle();
        messageConfigurationService.rejectMessage(appKey, messageId);
        logUserAction(httpRequest, "RejectMessage", "Message with message id '" + messageId + "' and title '" + messageTitle + "' is rejected", messageId);

        return createBooleanResponse(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage(@RequestBody MessageIdRequest request) {
        /*
        String appKey = getAppKey();
        Integer messageId = request.getMessageId();
        Long businessUnitId = getBusinessUnitId();

        if (messageId == null || messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        if (message.getMsgType() == MsgType.EMAIL //
                && !message.isFtpPush() //
                && hasSetRowMailService(appKey)) {
            String uniqueTemplateName = SetRowService.TEMPLATE_NAME_GENERATOR.get();
            ((EmailMessage) message).setTemplateName(uniqueTemplateName);

            String transcode = mailService.saveMailTemplateToSetRow( //
                    appKey, ((EmailMessage) message).getMailTemplateId(), uniqueTemplateName);
            ((EmailMessage) message).setTranscode(transcode);

            logger.info("updating message's transcode::{} and templateName::{}", //
                    ((EmailMessage) message).getTranscode(), ((EmailMessage) message).getTemplateName());
            messageConfigurationService.updateMessage(appKey, messageId, message);
        }

        messageValidator.validateSendMessage(message);

        new TryUnderLockTask("Send Message - " + appKey + " - " + messageId, logger, appKey + messageId) {
            @Override
            protected void executeTask() {
                if (message.getMsgType() == MsgType.EMAIL) {
                    mailService.setCompressedHtmlContentToMessage((EmailMessage) message);
                }

                messageConfigurationService.setMessageReadyToSend(appKey, messageId);

                String messageText = message.getTitle();
                logUserAction(httpRequest, "SendMessage", "Message with message id '" + messageId + "' and title '" + messageText + "' is sent", messageId);

                SendMessageCmd sendMessageCmd = new SendMessageCmd();
                sendMessageCmd.setAppKey(appKey);
                sendMessageCmd.setMessageId(messageId);

                requestPublisher.publish(sendMessageCmd);
            }

        }.run();

        return createBooleanResponse(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "send-the-rest", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessageToTheRestOfRecipients(@RequestBody MessageIdRequest request) {
        /*
        logUserAction(httpRequest, "SendMessageToTheRest", "Send A/B parent to the rest of the users");
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        Integer messageId = request.getMessageId();
        Integer parentMsgId = request.getParentMsgId();

        if (messageId == null || messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        if (parentMsgId == null || parentMsgId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        if (message.getMsgMethod() != MsgMethod.AB_CHILD) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message should be an A-B group!");
        }

        Message parentMsg = messageConfigurationService.getMessageByBusinessUnitId(appKey, parentMsgId, businessUnitId);
        if (parentMsg == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        if (parentMsg.getMsgMethod() != MsgMethod.AB_PARENT || (parentMsg.getFirstChildId() != messageId && parentMsg.getSecondChildId() != messageId)) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Parent and child message ids do not match!");
        }

        if (parentMsg.getSendStatus() != MsgSendStatus.READY_TO_SEND) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_MESSAGE_STATE, "A/B test message should be in 'ready to send' status!");
        }

        int otherChildId = parentMsg.getFirstChildId() == messageId ? parentMsg.getSecondChildId() : messageId;
        Message theOtherChild = messageConfigurationService.getMessageByBusinessUnitId(appKey, otherChildId, businessUnitId);

        // parent.audience - (child1.audience + child2.audience)
        int newTargetAudience = Math.max(parentMsg.getTargetAudience() - theOtherChild.getTargetAudience() - message.getTargetAudience(), 0);
        int newTargetUsers = Math.max(parentMsg.getTargetUsers() - theOtherChild.getTargetUsers() - message.getTargetUsers(), 0);

        // Copy child group's WHAT step to parent message
        MessageConverter.copyWhatStepToParent(parentMsg, message);
        messageConfigurationService.updateMessage(appKey, parentMsgId, parentMsg);

        // This also updates sendToRest flag to true
        messageConfigurationService.setSelectedChildId(appKey, parentMsg, messageId);
        messageConfigurationService.updateTargetAudience(appKey, parentMsgId, newTargetAudience, newTargetUsers);

        SendMessageCmd cmd = new SendMessageCmd();
        cmd.setAppKey(appKey);
        cmd.setMessageId(parentMsgId);
        requestPublisher.publish(cmd);

        return createBooleanResponse(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "getDefaultRichPushMessageTemplates", method = RequestMethod.GET)
    public ResponseEntity<?> getDefaultRichPushMessageTemplates(GetRichPushMessageTemplateRequest request) {
        /*
        logUserAction(httpRequest, "GetDefaultRichPushMessageTemplates");

        GetRichPushMessageTemplateResponse response = new GetRichPushMessageTemplateResponse();
        List<RichPushMessageTemplate> defaultRichPushMessageTemplates = dynamicPageService.getDefaultRichPushMessageTemplates(getAppKey(), 0, 20);
        defaultRichPushMessageTemplates = defaultRichPushMessageTemplates.stream().filter(RichPushMessageTemplate::isShowInPanel).collect(Collectors.toList());
        response.setRichPushMessageTemplates(defaultRichPushMessageTemplates);

        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "getRichPushMessageTemplate", method = RequestMethod.GET)
    public ResponseEntity<?> getRichPushMessageTemplate(GetRichPushMessageTemplateRequest request) {
        /*
        logUserAction(httpRequest, "GetRichPushMessageTemplate", false);

        GetRichPushMessageTemplateResponse response = new GetRichPushMessageTemplateResponse();
        List<RichPushMessageTemplate> richPushMessageTemplates = dynamicPageService.getRichPushMessageTemplates(getAppKey(), 0, 20);
        richPushMessageTemplates = richPushMessageTemplates.stream().filter(RichPushMessageTemplate::isShowInPanel).collect(Collectors.toList());
        response.setRichPushMessageTemplates(richPushMessageTemplates);
        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "recipient-count", method = RequestMethod.POST)
    public ResponseEntity<?> getRecipientCount(@RequestBody SaveMessageRequest request) {
        /*
        logUserAction(httpRequest, "GetRecipientCount");

        String appKey = getAppKey();

        Message message = convertRequestToMessage(request);

        GetRecipientCountResponse response = new GetRecipientCountResponse();
        PushMsgUserCount pushMsgUserCount = null;
        Integer targetAudience;
        Integer targetUsers;

        if (request.getMsgType() == MsgType.SMS) {
            SmsMsgUserCount smsMsgUserCount = peopleService.getSmsMsgUserCount(getAppKey(), message);
            response.setOptInPushUsers(smsMsgUserCount.getNumberOfOptInPushUsers());
            response.setSelectedSmsUsers(smsMsgUserCount.getNumberOfSelectedUsers());
            response.setTotalUsers(smsMsgUserCount.getNumberOfSmsUsers());
            response.setTotalSmsUsers(smsMsgUserCount.getNumberOfSmsUsers());
            response.setTotalDevices(smsMsgUserCount.getNumberOfDevices());
            response.setAndroid(smsMsgUserCount.getNumberOfAndroidDevices());
            response.setIos(smsMsgUserCount.getNumberOfIosDevices());
            response.setChrome(smsMsgUserCount.getNumberOfChromeDevices());
            response.setMacos(smsMsgUserCount.getNumberOfMacosDevices());
            response.setFirefox(smsMsgUserCount.getNumberOfFireFoxDevices());
            response.setOpera(smsMsgUserCount.getNumberOfOperaDevices());
            response.setEdge(smsMsgUserCount.getNumberOfEdgeDevices());
            response.setYandex(smsMsgUserCount.getNumberOfYandexDevices());
            response.setSms(smsMsgUserCount.getNumberOfSmsUsers());
            targetAudience = response.getSelectedSmsUsers();
            targetUsers = response.getSelectedSmsUsers();
        } else if (request.getMsgType() == MsgType.EMAIL) {
            pushMsgUserCount = peopleService.getPushMsgUserCount(appKey, message);
            response.setAndroid(pushMsgUserCount.getNumberOfAndroidDevices());
            response.setIos(pushMsgUserCount.getNumberOfIosDevices());
            response.setChrome(pushMsgUserCount.getNumberOfChromeDevices());
            response.setFirefox(pushMsgUserCount.getNumberOfFireFoxDevices());
            response.setMacos(pushMsgUserCount.getNumberOfMacosDevices());
            response.setOpera(pushMsgUserCount.getNumberOfOperaDevices());
            response.setEdge(pushMsgUserCount.getNumberOfEdgeDevices());
            response.setYandex(pushMsgUserCount.getNumberOfYandexDevices());
            response.setTotalUsers(pushMsgUserCount.getNumberOfUsers());
            response.setTotalDevices(pushMsgUserCount.getNumberOfDevices());
            response.setTotalEmailUsers(pushMsgUserCount.getNumberOfUsers());
            response.setSms(pushMsgUserCount.getNumberOfUsers());
            targetAudience = response.getTotalEmailUsers();
            targetUsers = response.getTotalEmailUsers();
        } else {
            pushMsgUserCount = peopleService.getPushMsgUserCount(appKey, message);
            response.setAndroid(pushMsgUserCount.getNumberOfAndroidDevices());
            response.setIos(pushMsgUserCount.getNumberOfIosDevices());
            response.setChrome(pushMsgUserCount.getNumberOfChromeDevices());
            response.setFirefox(pushMsgUserCount.getNumberOfFireFoxDevices());
            response.setMacos(pushMsgUserCount.getNumberOfMacosDevices());
            response.setOpera(pushMsgUserCount.getNumberOfOperaDevices());
            response.setEdge(pushMsgUserCount.getNumberOfEdgeDevices());
            response.setYandex(pushMsgUserCount.getNumberOfYandexDevices());
            response.setTotalUsers(pushMsgUserCount.getNumberOfUsers());
            response.setTotalDevices(pushMsgUserCount.getNumberOfDevices());
            response.setOptOutUsers(pushMsgUserCount.getNumberOfOptOutUsers());
            targetAudience = pushMsgUserCount.getTargetAudience();
            targetUsers = pushMsgUserCount.getNumberOfUsers();
        }

        targetAudience = targetAudience == null ? 0 : targetAudience;
        targetUsers = targetUsers == null ? 0 : targetUsers;

        int messageId = request.getMessageId();

        if (messageId > 0) {
            validateBusinessUnit(message.getBusinessUnitId());
            messageConfigurationService.updateTargetAudience(appKey, messageId, targetAudience, targetUsers);

            if (message.getMsgMethod() == MsgMethod.AB_PARENT && pushMsgUserCount != null) {
                SaveMessageRequest firstChild = request.getFirstChild();
                SaveMessageRequest secondChild = request.getSecondChild();

                if (firstChild != null && firstChild.getMessageId() > 0 && firstChild.getSampleRate() > 0) {
                    int sampleCount = calculateSampleDeviceCount(pushMsgUserCount, firstChild.getSampleRate());
                    int userSampleCount = calculateSampleUserCount(pushMsgUserCount.getNumberOfUsers(), firstChild.getSampleRate());
                    messageConfigurationService.updateTargetAudience(appKey, firstChild.getMessageId(), sampleCount, userSampleCount);
                }

                if (secondChild != null && secondChild.getMessageId() > 0 && secondChild.getSampleRate() > 0) {
                    int sampleCount = calculateSampleDeviceCount(pushMsgUserCount, secondChild.getSampleRate());
                    int userSampleCount = calculateSampleUserCount(pushMsgUserCount.getNumberOfUsers(), secondChild.getSampleRate());
                    messageConfigurationService.updateTargetAudience(appKey, secondChild.getMessageId(), sampleCount, userSampleCount);
                }
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "campaigns/appStatsDaily", method = RequestMethod.GET)
    public ResponseEntity<?> getAppStatsDaily(GetUserAnalyticsRequest request) {
        /*
        logUserAction(httpRequest, "GetUserAnalytics");
        AppStatsDaily appStatsDaily = appStatsService.getAppStatDaily(getAppKey(), new Date());
        return new ResponseEntity<>(new GetAppStatsDailyResponse(appStatsDaily), HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "create-for-target", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessageToTarget(@RequestBody SendMessageToTargetRequest request) {
        /*
        logUserAction(httpServletRequest, "CreateMessageForTarget");

        MsgTarget target = new MsgTarget();
        target.setSendToAll(false);
        if (request.getDlsId() != null && request.getDlsId() > 0) {
            target.setDistributionListId(request.getDlsId());
        } else if (request.getTagId() != null && request.getTagId() > 0) {
            TagCondition tagCondition = new TagCondition(request.getTagId());
            target.setTags(tagCondition);
        } else if (request.getSegmentId() != null && request.getSegmentId() > 0) {
            SegmentCondition segmentCondition = new SegmentCondition(request.getSegmentId());
            target.setSegments(segmentCondition);
        } else {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Please select at least one criteria!");
        }

        Message message = new PushMessage();
        message.setMsgType(MsgType.PUSH);
        message.setMsgMethod(MsgMethod.CAMPAIGN);
        message.setSendStatus(MsgSendStatus.DRAFT);
        message.setTargeting(target);
        message.setCreator(getAdminUserNameSurname());
        message.setCreateDate(new Date());

        Integer messageId = messageConfigurationService.saveMessage(getAppKey(), message);

        return new ResponseEntity<>(messageId, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public ResponseEntity<?> getMsgCategories() {
        /*
        // dont use this method when you are creating gui pages for listing msg
        // categories...
        // Only create campaign screen will use this.
        logUserAction(request, "GetMsgCategories", false);

        List<MsgCategory> msgCategories = appService.getMsgCategories(getAppKey());
        return new ResponseEntity<>(msgCategories, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "labels", method = RequestMethod.GET)
    public ResponseEntity<?> getMsgLabels() {
        /*
        logUserAction(request, "GetMsgLabels", false);
        List<MsgLabel> msgLabels = messageLabelService.getMsgLabels(getAppKey());
        return new ResponseEntity<>(msgLabels, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "active-scenarios", method = RequestMethod.GET)
    public ResponseEntity<?> getActiveAutomatedScenarios(@RequestParam String triggerGoal) {
        /*
        logUserAction(request, "GetActiveAutomatedScenarios", false);

        List<Map<String, Object>> response = Lists.newArrayList();

        TriggerGoal goal = TriggerGoal.getTriggerGoal(triggerGoal);
        List<MsgInfo> activeScenarios = messageStatsService.getRunningAutomatedScenarios(getAppKey(), goal, getBusinessUnitId());
        if (CollectionUtils.isEmpty(activeScenarios)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        Map<Integer, TriggerModel> triggerMap = triggerService.getTriggerModels(getAppKey(), getTriggerIdsOfMessageInfoList(activeScenarios));

        for (MsgInfo msgInfo : activeScenarios) {
            Message msg = msgInfo.getMsg();
            MessageStats stats = msgInfo.getStats();
            Long triggerId = msg.getTriggerId();

            Map<String, Object> scenario1 = Maps.newHashMap();
            if (triggerId != null && triggerMap.containsKey(triggerId.intValue())) {
                scenario1.put("trigger", triggerMap.get(triggerId.intValue()));
            }
            scenario1.put("title", msg.getTitle());
            scenario1.put("message", msg.getMessage());
            scenario1.put("clicks", stats.getClickStats().getTotalStat());
            scenario1.put("duration", calculateMessageDuration(msg));

            response.add(scenario1);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "createWithCondition", method = RequestMethod.GET)
    public ResponseEntity<?> createCampaign(@RequestParam String uuid) {
        /*
        logUserAction(request, "CreateCampaignWithCondition");

        String appKey = getAppKey();

        Long businessUnitId = getBusinessUnitId();

        Conditions conditions = (Conditions) guiSessionMap.get(uuid);
        if (conditions == null || conditions.asList().size() == 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Empty criteria! Select one or more criteria");
        }

        Message message = new PushMessage();
        message.setMsgType(MsgType.PUSH);
        message.setMsgMethod(MsgMethod.CAMPAIGN);
        message.setSendStatus(MsgSendStatus.DRAFT);
        message.setTargeting(new MsgTarget(conditions));
        message.setCreator(getAdminUserNameSurname());
        message.setCreateDate(new Date());
        message.setBusinessUnitId(businessUnitId);

        if (businessUnitId != null) {
            // Do not set business unit of message by using BusinessUnit object
            BusinessUnit businessUnit = getBusinessUnit(businessUnitId, appKey);
            if (businessUnit == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_BUSINESS_UNIT_ID_NOT_SPECIFIED, "Business unit could not be found!");
            } else {
                message.setCategory(Lists.newArrayList(businessUnit.getId()));
            }
        }

        Integer messageId = messageConfigurationService.saveMessage(appKey, message);

        return new ResponseEntity<>(messageId, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "retarget", method = RequestMethod.GET)
    public ResponseEntity<?> retarget(RetargetMessageRequest retargetReq) {
        /*
        logUserAction(request, "Retarget", retargetReq.getMessageId());

        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, retargetReq.getMessageId(), businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This message does not exist");
        }

        if (retargetReq.getResponseCondType() == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This is not an available option. Please retry later");
        }

        MsgTarget msgTarget = new MsgTarget();
        Conditions retargetConditions = new Conditions();

        String dynamicComponentText = retargetReq.getDynamicComponentText();
        List<String> dynamicComponentTexts = new ArrayList<>();

        if (StringUtils.isNotBlank(dynamicComponentText)) {
            dynamicComponentTexts = Arrays.asList(dynamicComponentText.split(","));
        }

        if (dynamicComponentTexts.size() > 1) {
            OrCondition responseOrCondition = new OrCondition();
            for (String text : dynamicComponentTexts) {
                ResponseCondition responseCondition = createResponseCondition(retargetReq, message, text);
                responseOrCondition.addCondition(responseCondition);
            }
            retargetConditions.setResponse(responseOrCondition);
            msgTarget.setResponse(responseOrCondition);
        } else {
            ResponseCondition responseCondition = createResponseCondition(retargetReq, message, dynamicComponentText);
            retargetConditions.setResponse(responseCondition);
            msgTarget.setResponse(responseCondition);
        }

        if (retargetReq.getType() == RetargetType.PLATFORM) {
            if (retargetReq.getPlatform() != null && !NetmeraConstants.DB_KEY_STATS_TOTAL.equals(retargetReq.getPlatform())) {
                PlatformCondition platformCondition = new PlatformCondition(Platform.getPlatform(retargetReq.getPlatform()));
                msgTarget.setPlatform(platformCondition);
                retargetConditions.setPlatform(platformCondition);
            }

            // else all platforms
        } else if (retargetReq.getType() == RetargetType.SEGMENT) {
            Segment segment = segmentService.getSegmentById(appKey, retargetReq.getSegmentId(), getBusinessUnitId());
            if (segment == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This segment does not exist");
            }
            SegmentCondition segmentCondition = new SegmentCondition(segment.getSegmentId());
            msgTarget.setSegments(segmentCondition);
            retargetConditions.setSegments(segmentCondition);
        } else if (retargetReq.getType() == RetargetType.PROFILE) {
            String attributeCode = retargetReq.getProfileAttributeCode();
            String attributeValue = retargetReq.getProfileAttributeValue();

            if (attributeCode == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This profile does not exist");
            }

            AttributeDefinition attributeDefinition = appService.cacheable().getAppSchema(appKey).getProfileAttrByCode(attributeCode);
            if (attributeDefinition == null || StringUtils.isEmpty(retargetReq.getProfileAttributeValue())) {
                throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This profile does not exist");
            }

            AttrDataType dataType = attributeDefinition.getDataType();

            AttributeExpression exp = new AttributeExpression();
            exp.setCode(attributeDefinition.getCode());

            if (attributeValue.contains(" - ")) {
                String[] splitValues = attributeValue.split(" - ");

                if (EnmProfileAttr.BIRTH_DATE.equals(attributeDefinition.getCode())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.valueOf(splitValues[1]));
                    exp.addValue(DateUtils.getBeginDate(calendar.getTime()).getTime());

                    calendar = Calendar.getInstance();
                    calendar.add(Calendar.YEAR, -Integer.valueOf(splitValues[0]));
                    exp.addValue(DateUtils.getEndDate(calendar.getTime()).getTime());

                } else if (dataType == AttrDataType.DATE) {
                    exp.addValue(DateUtils.getBeginDate(DateUtils.formatDate(dateFormat, splitValues[0])).getTime());
                    exp.addValue(DateUtils.getEndDate(DateUtils.formatDate(dateFormat, splitValues[1])).getTime());

                } else if (dataType == AttrDataType.DOUBLE || dataType == AttrDataType.INT || dataType == AttrDataType.LONG) {
                    exp.addValue(splitValues[0]);
                    exp.addValue(splitValues[1]);
                }

                exp.setOperator(ConditionOperator.BETWEEN);
            } else {
                if (attributeDefinition.getOptions() != null) {
                    for (AttrOption option : attributeDefinition.getOptions()) {
                        if (attributeValue.equals(option.getLabel())) {
                            exp.addValue(option.getValue());
                            break;
                        }
                    }
                } else {
                    exp.addValue(attributeValue);
                }

                exp.setOperator(ConditionOperator.EQUALS);
            }

            ProfileCondition profileCondition = new ProfileCondition();
            profileCondition.setExpression(exp);

            msgTarget.setProfile(profileCondition);
            retargetConditions.setSegments(profileCondition);
        }

        RetargetMessageResponse response = new RetargetMessageResponse();
        guiSessionMap.put(response.getUuid(), new Conditions(msgTarget));

        String humCond = condHumanizer.humanize(retargetConditions.asList(), new HumanizerContext(appKey));
        response.setFilterQueryText(humCond);

        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "send-test", method = RequestMethod.POST)
    public ResponseEntity<?> sendTestMessage(@RequestBody SendTestMsgRequest sendTestMsgRequest) {
        /*
        int messageId = sendTestMsgRequest.getMessageId();
        Platform platform = sendTestMsgRequest.getPlatform();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        String appKey = getAppKey();
        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        validateBusinessUnit(message.getBusinessUnitId());

        if (businessUnitId != null) {
            BusinessUnit businessUnit = getBusinessUnit(businessUnitId, appKey);

            if (businessUnit == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_BUSINESS_UNIT_ID_NOT_SPECIFIED, "Business unit could not be found!");
            }
        }

        new TryUnderLockTask("Send Test Message - " + appKey + " - " + messageId, logger, appKey + messageId) {
            @Override
            protected void executeTask() {

                if (message.getMsgType() == MsgType.EMAIL && StringUtils.isEmpty(((EmailMessage) message).getHtmlBody())) {
                    String htmlBody = mailService.getCompressedHtmlContent((EmailMessage) message);
                    ((EmailMessage) message).setHtmlBody(htmlBody);
                    messageConfigurationService.updateMessage(appKey, message.getId(), message);
                }

                logUserAction(request, "SendTestMessage", "Send test message to " + platform + " platform for message with id " + messageId + " and title " + message.getTitle(),
                        true);
                messageTestService.sendTestMessage(appKey, messageId, platform);
            }

        }.run();

        Map<String, Object> response = Maps.newHashMap();
        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "test-stats", method = RequestMethod.GET)
    public ResponseEntity<?> getTestMessageStats(@RequestParam int messageId) {
        /*
        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        logUserAction(request, "GetTestMessageStats", messageId, false);

        String appKey = getAppKey();

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, getBusinessUnitId());
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        MessageStats messageStats = messageStatsService.getMessageStats(appKey, messageId);

        if (messageStats == null) {
            // Everything will be returned as zero
            messageStats = new MessageStats();
        }

        Map<String, Object> response = Maps.newHashMap();

        logger.info("testMessageStats::{}", messageStats);

        IntegerPlatformStats testSentStats = messageStats.getTestSentStats();
        IntegerPlatformStats testFailedStats = messageStats.getTestFailedStats();

        response.put(Platform.ANDROID.name(), getSuccessFailMap(testSentStats.getAndroidStat(), testFailedStats.getAndroidStat()));
        response.put(Platform.IOS.name(), getSuccessFailMap(testSentStats.getIosStat(), testFailedStats.getIosStat()));
        response.put(Platform.CHROME.name(), getSuccessFailMap(testSentStats.getChromeStat(), testFailedStats.getChromeStat()));
        response.put(Platform.FIREFOX.name(), getSuccessFailMap(testSentStats.getFirefoxStat(), testFailedStats.getFirefoxStat()));
        response.put(Platform.OPERA.name(), getSuccessFailMap(testSentStats.getOperaStat(), testFailedStats.getOperaStat()));
        response.put(Platform.EDGE.name(), getSuccessFailMap(testSentStats.getEdgeStat(), testFailedStats.getEdgeStat()));
        response.put(Platform.YANDEX.name(), getSuccessFailMap(testSentStats.getYandexStat(), testFailedStats.getYandexStat()));
        response.put(Platform.MACOS.name(), getSuccessFailMap(testSentStats.getMacosStat(), testFailedStats.getMacosStat()));
        response.put(Platform.EMAIL.name(), getSuccessFailMap(testSentStats.getEmailStat(), testFailedStats.getEmailStat()));

        return new ResponseEntity<>(response, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteMessage(@RequestParam int messageId) {
        /*
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        logUserAction(request, "DeleteMessage", messageId);

        boolean isDeleted = messageConfigurationService.deleteMessage(appKey, messageId);
        return createBooleanResponse(isDeleted, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "archive", method = RequestMethod.POST)
    public ResponseEntity<?> archiveMessage(@RequestParam int messageId) {
        /*
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        logUserAction(request, "ArchiveMessage", messageId);

        boolean isArchived = messageConfigurationService.archiveMessage(appKey, messageId);
        return createBooleanResponse(isArchived, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "deactive", method = RequestMethod.POST)
    public ResponseEntity<?> deactivateMessage(@RequestParam int messageId) {
        /*
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        logUserAction(request, "DeactiveMessage", messageId);

        boolean isDeactivated = messageConfigurationService.deactivateMessage(appKey, messageId);
        return createBooleanResponse(isDeactivated, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "stop", method = RequestMethod.POST)
    public ResponseEntity<?> stopMessage(@RequestParam int messageId) {
        /*
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        logUserAction(request, "StopMessage", messageId);

        boolean isCancelled = messageConfigurationService.stopMessage(appKey, messageId);
        return createBooleanResponse(isCancelled, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "recall", method = RequestMethod.GET)
    public ResponseEntity<?> recallMessage(@RequestParam int messageId) {
        /*
        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        logUserAction(request, "recallMessage", messageId);

        String appKey = getAppKey();
        String adminUserNameSurname = getAdminUserNameSurname();
        if (!messageConfigurationService.recallMessage(appKey, messageId)) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        recallMessageService.sendRecallMessage(appKey, adminUserNameSurname, messageId);

        return new ResponseEntity<>(true, HttpStatus.OK);
         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    public ResponseEntity<?> cancelMessage(@RequestParam int messageId) {
        /*
        String appKey = getAppKey();
        Long businessUnitId = getBusinessUnitId();

        if (messageId <= 0) {
            throw new NetmeraRuntimeException(NetmeraError.EC_MISSING_REQUIRED_PARAMETER, "messageId parameter is required!");
        }

        Message message = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (message == null) {
            throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "Message with given messageId could not be found");
        }

        logUserAction(request, "CancelMessage", messageId);

        boolean isCancelled = messageConfigurationService.cancelMessage(appKey, messageId);
        return createBooleanResponse(isCancelled, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "platform-availability", method = RequestMethod.GET)
    public ResponseEntity<?> getPlatformAvailability() {
        /*
        logUserAction(request, "GetPlatformAvailability", false);

        EmspConfig emspConfig = emspConfigService.getAppEmspConfig(getAppKey());
        if (emspConfig == null) {
            emspConfig = new EmspConfig();
        }

        ApplicationSettingsModel appSettings = appService.getApplicationSettings(getAppKey());

        Map<String, Object> response = Maps.newHashMap();
        boolean isIosValid = emspConfig.isIosConfigValid();
        response.put(Platform.IOS.name(), isIosValid);
        response.put(Platform.ANDROID.name(), emspConfig.isGcmConfigValid());
        response.put(Platform.CHROME.name(), emspConfig.isChromeGcmConfigValid());
        response.put(Platform.MACOS.name(), emspConfig.isMacosApnsConfigValid());
        response.put(Platform.FIREFOX.name(), emspConfig.isVapidKeyConfigValid());
        response.put(Platform.OPERA.name(), emspConfig.isVapidKeyConfigValid());
        response.put(Platform.EDGE.name(), emspConfig.isVapidKeyConfigValid());
        response.put(Platform.YANDEX.name(), emspConfig.isVapidKeyConfigValid());

        // TODO those platforms are not implemented yet.
        response.put(Platform.WINDOWS.name(), emspConfig.isWindowsConfigValid());

        // Put other message settings to this response for request optimization.
        response.put("appSettings", appSettings);

        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "msgCategoryList", method = RequestMethod.GET)
    public ResponseEntity<?> getMessageCategoryList(ListRequest listRequest) {
        /*
        logUserAction(request, "GetMessageCategoryList", false);
        String appKey = getAppKey();
        List<MsgCategory> msgCategoryList = appService.getMsgCategories(appKey, listRequest.getPage() * listRequest.getMax(), listRequest.getMax());
        Map<Integer, CategoryUserCount> categoryIdUserCountMap = new HashMap<>();
        long totalUsers = appStatsService.getAppStatDaily(appKey, DateUtils.yesterday(new Date())).getTotalUsers();
        for (MsgCategory msgCategory : msgCategoryList) {
            int optOutUserCount = assignService.countOptOutUsersInCategory(appKey, msgCategory.getId());
            CategoryUserCount userCounts = new CategoryUserCount(totalUsers - optOutUserCount, optOutUserCount);
            categoryIdUserCountMap.put(msgCategory.getId(), userCounts);
        }

        MsgCategoryResponse response = new MsgCategoryResponse();
        response.setMsgCategoryList(msgCategoryList);
        response.setCategoryIdUserCountMap(categoryIdUserCountMap);
        response.setTotal(appService.getMsgCategories(appKey).size());

        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "createMsgCategory", method = RequestMethod.POST)
    public ResponseEntity<?> createMessageCategory(@RequestBody CreateMessageCategoryRequest request) {
        /*
        if (!request.isUpdate()) {
            logUserAction(httpRequest, "CreateMessageCategory", request.getMsgCategory().getId());
        } else {
            logUserAction(httpRequest, "CreateMessageCategory", request.getPreviousCategoryId());
        }
        String appKey = getAppKey();
        MsgCategory categoryFound = appService.getMsgCategory(appKey, request.getMsgCategory());
        if (categoryFound != null) {
            if (!request.isUpdate() || (request.isUpdate() && categoryFound.getId() != request.getPreviousCategoryId())) {
                return createBooleanResponse(false, HttpStatus.OK);
            }
        }
        appService.saveMsgCategory(appKey, request.getPreviousCategoryId(), request.getMsgCategory());
        return createBooleanResponse(true, HttpStatus.OK);
        */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "msgCategory", method = RequestMethod.GET)
    public ResponseEntity<?> getMessageCategory(int id) {
        /*
        logUserAction(request, "GetMessageCategory", false);
        String appKey = getAppKey();
        MsgCategory msgCategory = new MsgCategory(id);
        return new ResponseEntity<>(appService.getMsgCategory(appKey, msgCategory), HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "deleteMsgCategory", method = RequestMethod.POST)
    public ResponseEntity<?> deleteMessageCategory(@RequestBody int id) {
        /*
        logUserAction(request, "DeleteMessageCategory", "categoryId=" + id);
        appService.deleteMsgCategory(getAppKey(), id);
        return createBooleanResponse(true, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "msgLabel", method = RequestMethod.GET)
    public ResponseEntity<?> getMsgLabel(int id) {
        /*
        logUserAction(request, "GetMsgLabel", false);
        String appKey = getAppKey();
        MsgLabel msgLabel = new MsgLabel(id);
        return new ResponseEntity<>(messageLabelService.getMsgLabel(appKey, msgLabel), HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "msgLabelList", method = RequestMethod.GET)
    public ResponseEntity<?> getMsgLabelList(ListRequest listRequest) {
        /*
        logUserAction(request, "GetMsgLabelList", false);
        MessageLabelResponse response = new MessageLabelResponse();
        String appKey = getAppKey();
        List<MsgLabel> msgLabelList = messageLabelService.getMsgLabels(appKey, listRequest.getPage() * listRequest.getMax(), listRequest.getMax());
        Integer count = messageLabelService.getMsgLabelCount(appKey);
        response.setMsgLabelList(msgLabelList);
        response.setCount(count);
        return new ResponseEntity<>(response, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "createMsgLabel", method = RequestMethod.POST)
    public ResponseEntity<?> createMessageLabel(@RequestBody CreateMessageLabelRequest request) {
        /*
        if (request.isUpdate()) {
            logUserAction(httpServletRequest, "CreateMessageLabel", request.getMsgLabel().getId());
        } else {
            logUserAction(httpServletRequest, "CreateMessageLabel", request.getPreviousLabelId());
        }
        String appKey = getAppKey();
        MsgLabel msgLabel = messageLabelService.getMsgLabel(appKey, request.getMsgLabel());
        if (msgLabel != null) {
            if (!request.isUpdate() || (request.isUpdate() && msgLabel.getId() != request.getPreviousLabelId())) {
                return createBooleanResponse(false, HttpStatus.OK);
            }
        }
        messageLabelService.saveMsgLabel(appKey, request.getPreviousLabelId(), request.getMsgLabel());
        return createBooleanResponse(true, HttpStatus.OK);
        */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "deleteMsgLabel", method = RequestMethod.POST)
    public ResponseEntity<?> deleteMessageLabel(@RequestBody int id) {
        /*
        logUserAction(request, "DeleteMessageLabel", "labelId=" + id);
        messageLabelService.deleteMsgLabel(getAppKey(), id);
        return createBooleanResponse(true, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "get-from-addresses", method = RequestMethod.GET)
    public ResponseEntity<?> getFromAddresses() {
        /*
        logUserAction(httpRequest, "GetFromAddresses", false);

        List<String> fromAddresses = appService.getFromAddresses(getAppKey());
        return new ResponseEntity<>(fromAddresses, HttpStatus.OK);

         */
        return ResponseEntity.ok(null);
    }

    private Map<String, Integer> getSuccessFailMap(Integer total,
                                                   Integer fail) {
    /*
        total = total == null ? 0 : total;
        fail = fail == null ? 0 : fail;

        Map<String, Integer> map = Maps.newHashMap();
        map.put("success", total - fail);
        map.put("fail", fail);
        return map;
        */
        return null;
    }

    private ResponseCondition createResponseCondition(RetargetMessageRequest retargetReq,
                                                      Message message,
                                                      String dynamicComponentText) {
    /*
        ResponseCondition responseCondition = new ResponseCondition();
        responseCondition.setMessageId(message.getId());
        responseCondition.setResponseType(retargetReq.getResponseCondType());
        responseCondition.setMsgCriteriaType(ResponseCondMsgCriteriaType.MESSAGE);
        responseCondition.setLanguageLabel(retargetReq.getLanguageLabel());

        if (retargetReq.getSelectedDate() != null) {
            responseCondition.setSelectedDate(DateUtils.formatDate(dateFormat, retargetReq.getSelectedDate()));
        } else if (retargetReq.isDateRangeValid()) {
            Date startDate = DateUtils.getBeginDate(DateUtils.formatDate(dateFormat, retargetReq.getStartDate()));
            Date endDate = DateUtils.getEndDate(DateUtils.formatDate(dateFormat, retargetReq.getEndDate()));
            responseCondition.setDateInterval(new DateInterval(startDate, endDate));
        }

        String buttonText = retargetReq.getButtonText();
        if (StringUtils.isNotBlank(buttonText)) {
            responseCondition.setButtonText(buttonText);

            PushButtonSet buttonSet = ((InteractivePushMessage) message).getButtonSet();
            for (PushButton button : buttonSet.getButtons()) {
                if (buttonText.equals(button.getName())) {
                    responseCondition.setButtonId(button.getId());
                    break;
                }
            }

            if (responseCondition.getButtonId() == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This button does not exist");
            }
        }

        if (StringUtils.isNotBlank(dynamicComponentText)) {
            responseCondition.setDynamicComponentText(dynamicComponentText);

            if (message.getPushClickAction() != null && message.getPushClickAction().getAction() == PushClickActionType.DYNAMIC_PAGE) {
                for (DynamicTemplateComponent component : message.getPushClickAction().getTemplateComponents()) {
                    if (component.getKey().equals("RADIO")) {
                        String radioButtonName = getNameOfRadioButton(dynamicComponentText, component.getArgumentValue(component.getKey()), ", ");
                        if (null != radioButtonName) {
                            responseCondition.setDynamicComponentId(radioButtonName);
                            break;
                        }
                    }
                    if (component.getKey().equals("QUESTION_ITEMS")) {
                        for (List<SurveyQuestionItem> surveyQuestionItems : component.getSurveyQuestions()) {
                            for (SurveyQuestionItem surveyQuestionItem : surveyQuestionItems) {
                                if (surveyQuestionItem.getKey().equals("SURVEY_ITEM_RADIO_LIST")) {
                                    String radioButtonName = getNameOfRadioButton(dynamicComponentText, surveyQuestionItem.getValue(), ",");
                                    if (null != radioButtonName) {
                                        responseCondition.setDynamicComponentId(radioButtonName);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (component.getType().equals("BUTTON")) {
                        responseCondition.setDynamicComponentId(dynamicComponentText);
                        break;
                    }
                }

                if (responseCondition.getDynamicComponentId() == null) {
                    for (DynamicTemplateComponent component : message.getPushClickAction().getTemplateComponents()) {
                        if (dynamicComponentText.equals(component.getPanelLabel())) {
                            responseCondition.setDynamicComponentId(component.getKey());
                            break;
                        }
                    }
                }
            }

            if (responseCondition.getDynamicComponentId() == null) {
                responseCondition.setDynamicComponentId(dynamicComponentText);
            }

            if (responseCondition.getDynamicComponentId() == null) {
                throw new NetmeraRuntimeException(NetmeraError.EC_INVALID_PARAMETER, "This dynamic component does not exist");
            }
        }

        final String longUrl = retargetReq.getLongUrl();
        if (StringUtils.isNotEmpty(longUrl)) {
            responseCondition.setLongUrl(longUrl);
        }

        return responseCondition;
     */
        return null;
    }

    private SaveMessageResponse constructSaveMessageResponseEntity(@RequestBody SaveMessageRequest request,
                                                                   String appKey,
                                                                   int messageId,
                                                                   Message message) {
        /*
        if (message instanceof PushMessage && !messageConfigurationService.hasMessageUnlimitedSurveyTemplateAction(message)
                && !messageConfigurationService.hasUnlimitedPopup(message)) {
            payloadService.checkPayloadSize(appKey, (PushMessage) message);
        }

        if (message instanceof EmailMessage) {
            if (((EmailMessage) message).getHtml() != null) {
                String htmlBody = mailService.getCompressedHtmlContent((EmailMessage) message);
                ((EmailMessage) message).setHtmlBody(htmlBody);
            }

            if (!message.isFtpPush()) {
                // Set delivery speed for throttling
                int packSize = systemPropertyHolder.getIntegerProperty("email.msg.packing.size", 1);
                int packInterval = systemPropertyHolder.getIntegerProperty("email.msg.packing.interval", 1000);
                message.setDeliverySpeed(new MsgDeliverySpeed(packInterval, packSize));
            }

            if (((EmailMessage) message).getMailTemplateId() != null) {
                MailTemplate mailTemplate = convertRequestToMailTemplate(request);
                mailService.saveMailTemplate(appKey, mailTemplate);
            }
        }

        int firstChildMsgId = 0;
        int secondChildMsgId = 0;

        String adminUserNameSurname = getAdminUserNameSurname();

        int triggerId = 0;
        TriggerModel triggerModel = request.getTriggerModel();
        if (message.getMsgMethod().isAutomatedOrCatalog() && triggerModel != null && triggerModel.getType() != null) {
            if (isAlarmActive(triggerModel) && (triggerModel.getId() == null || isAlarmIdNotGeneratedBefore(appKey, triggerModel))) {
                Message alarmMessage = createMessageDefiniton(appKey, message.getTitle(), triggerModel.getAlarmMessage(), triggerModel.getAlarmMsgType());
                Integer alarmMsgId = messageConfigurationService.saveMessage(appKey, alarmMessage);
                triggerModel.setAlarmMsgId(alarmMsgId);
            }

            triggerId = triggerService.saveOrUpdateTriggerModel(appKey, triggerModel);
            message.setTriggerId((long) triggerId);
        }

        if (message.getMsgMethod() == MsgMethod.AB_PARENT) {
            // AB_CHILD must be explicitly created
            firstChildMsgId = saveChildMessage(message, request.getFirstChild());
            message.setFirstChildId(firstChildMsgId);

            secondChildMsgId = saveChildMessage(message, request.getSecondChild());
            message.setSecondChildId(secondChildMsgId);
        }

        if (message.getMsgMethod() == MsgMethod.GEOFENCE) {
            TriggerModel geofenceTrigger = createGeofenceTrigger(message);
            if (geofenceTrigger != null) {
                triggerId = triggerService.saveOrUpdateTriggerModel(appKey, geofenceTrigger);
                message.setTriggerId((long) triggerId);
            }
        }

        if (messageId > 0) {
            message.setUpdater(adminUserNameSurname);
            logUserAction(httpRequest, "SaveMessage", "Message with message id '" + request.getMessageId() + "' and title '" + request.getTitle() + "' is saved",
                    request.getMessageId());
            messageConfigurationService.updateMessage(appKey, messageId, message);
        } else {
            message.setCreator(adminUserNameSurname);
            message.setUpdater(adminUserNameSurname);
            messageId = messageConfigurationService.saveMessage(appKey, message);
            logUserAction(httpRequest, "SaveMessage", "Message with message id '" + messageId + "' and title '" + request.getTitle() + "' is created", request.getMessageId());
        }

        if (messageId > 0 && (firstChildMsgId > 0 || secondChildMsgId > 0)) {
            // Child messages need parent message id
            messageConfigurationService.setParentMessageId(appKey, firstChildMsgId, secondChildMsgId, messageId);
        }

        SaveMessageResponse response = new SaveMessageResponse(messageId);
        response.setTriggerId((long) triggerId);
        response.setFirstChildId(message.getFirstChildId());
        response.setSecondChildId(message.getSecondChildId());
        return response;
         */
        return null;
    }

    private void validateMessage(@RequestBody SaveMessageRequest request,
                                 String appKey,
                                 int messageId,
                                 Message message,
                                 Long businessUnitId) {
        /*
        if (messageId <= 0) {
            return;

        }
        Message messageInDB = messageConfigurationService.getMessageByBusinessUnitId(appKey, messageId, businessUnitId);
        if (messageInDB != null) {
            messageValidator.validateSaveMessage(messageInDB);
            if (!request.isConfirmedDraft() && messageInDB.getSendStatus() != message.getSendStatus()) {
                throw new NetmeraRuntimeException(NetmeraError.EC_MESSAGE_STATUS_NOT_MATCH, NetmeraError.EC_MESSAGE_STATUS_NOT_MATCH.getErrorMsg());
            }
        }
         */
    }

    private boolean isAlarmIdNotGeneratedBefore(String appKey,
                                                TriggerModel triggerModel) {
    /*
        TriggerModel triggerModelInDb = triggerService.getTriggerModel(appKey, triggerModel.getId());
        return triggerModelInDb == null || triggerModelInDb.getAlarmMsgId() == null;
     */
        return false;
    }

    private boolean isAlarmActive(TriggerModel triggerModel) {
    /*
        return triggerModel.isAlarmActive() && StringUtils.isNotBlank(triggerModel.getAlarmMessage()) && triggerModel.getAlarmMsgType() != null;
     */
        return false;
    }

    private Message createMessageDefiniton(String appKey,
                                           String title,
                                           String notificationMessage,
                                           MsgType msgType) {
    /*
        Message message = null;
        switch (msgType) {
            case PUSH:
                message = new PushMessage();
                message.setMsgType(MsgType.PUSH);
                break;
            case SMS:
                message = new SmsMessage();
                message.setMsgType(MsgType.SMS);
                break;
        }
        message.setAppKey(appKey);
        message.setTitle(title);
        message.setMessage(notificationMessage);
        message.setMsgMethod(MsgMethod.TRANSACTIONAL);
        message.setSendStatus(MsgSendStatus.ACTIVE);
        message.setPlatforms(Sets.newHashSet(Platform.IOS, Platform.ANDROID));
        message.setCreator(getAdminUserNameSurname());
        message.setUpdater(getAdminUserNameSurname());
        message.setCreateDate(new Date());
        message.setPushClickAction(PushClickAction.getStandardPushClickAction());

        return message;
     */
        return null;
    }

    private Integer saveChildMessage(Message parentMsg,
                                     SaveMessageRequest child) {
        /*
        if (parentMsg.getMsgMethod() != MsgMethod.AB_PARENT || child == null) {
            return 0;
        }

        Message childMsg = parentMsg.createCopy();
        childMsg.setMsgMethod(MsgMethod.AB_CHILD);
        childMsg.setCategory(child.getCategory());
        childMsg.setMessage(child.getMessage());
        childMsg.setRichSubText(child.getRichSubText());
        childMsg.setRichTitle(child.getRichTitle());
        childMsg.setPersonalizedTitle(child.getPersonalizedTitle());
        childMsg.setPersonalizedMessage(child.getPersonalizedMessage());
        childMsg.setPushClickAction(child.getPushClickAction());
        childMsg.setSampleRate(child.getSampleRate());
        childMsg.setLabel(child.getLabel());
        childMsg.setChannelId(child.getChannelId());
        childMsg.setOptimoveChannelId(child.getOptimoveChannelId());
        childMsg.setDefaultMessageActive(child.isDefaultMessageActive());
        childMsg.setDefaultTitleActive(child.isDefaultTitleActive());
        childMsg.setThumbnailUrl(child.getThumbnailUrl());

        if (childMsg instanceof PushMessage) {
            PushMessage push = (PushMessage) childMsg;
            push.setAndroidPushStyle(child.getAndroidPushStyle());
            push.setIosPushStyle(child.getIosPushStyle());
            push.setVibration(child.getVibration());
            push.setPushInbox(child.getPushInbox());
            push.setDoNotShowOnNotificationCenter(child.getDoNotShowOnNotificationCenter());
            push.setPushInboxOptOut(child.getPushInboxOptOut());
            push.setPushSound(child.getPushSound());
            push.setConversionAnalytics(child.getConversionAnalytics());
            push.setIosCarouselType(child.getIosCarouselType());
            push.setCustomJson(child.getCustomJson());
        }

        if (childMsg instanceof InteractivePushMessage) {
            InteractivePushMessage interactivePush = (InteractivePushMessage) childMsg;
            interactivePush.setButtonSet(child.getButtonSet());
            interactivePush.setTrackInteractiveUsers(child.getTrackInteractiveUsers());
        }

        if (childMsg instanceof PopupMessage) {
            PopupMessage popup = (PopupMessage) childMsg;
            popup.setPopupTracking(child.getPopupTracking());
        }

        if (childMsg instanceof SmsMessage) {
            SmsMessage sms = (SmsMessage) childMsg;
            sms.setSendPushIfUserHasApp(child.getSendPushIfUserHasApp());
        }

        if (childMsg instanceof WebpushMessage) {
            WebpushMessage webPush = (WebpushMessage) childMsg;
            webPush.setWpTitle(child.getWpTitle());
            webPush.setWpImage(child.getWpImage());
            webPush.setWpImageUrl(child.getWpImageUrl());
        }

        if (child.getMessageId() > 0) {
            messageConfigurationService.updateMessage(getAppKey(), child.getMessageId(), childMsg);
            return child.getMessageId();

        } else {
            childMsg.setCreator(getAdminUserNameSurname());
            childMsg.setCreateDate(new Date());
            return messageConfigurationService.saveMessage(getAppKey(), childMsg);

        }

         */
        return null;
    }

    private Set<Integer> getTriggerIdsOfMessageInfoList(List<MsgInfo> messageInfoList) {
        /*
        Set<Integer> ids = Sets.newHashSet();

        if (CollectionUtils.isNotEmpty(messageInfoList)) {
            for (MsgInfo info : messageInfoList) {
                Message msg = info.getMsg();
                if (msg != null && msg.getTriggerId() != null) {
                    ids.add(msg.getTriggerId().intValue());
                }
            }
        }

        return ids;

         */
        return null;
    }

    private long calculateMessageDuration(Message message) {
        /*
        MsgExpiration expiration = message.getMsgExpiration();
        if (expiration == null || expiration.getExpirationType() != MsgExpirationType.SPECIFIC_TIME) {
            return -1;
        }

        Date startDate = new Date();
        MsgSchedule schedule = message.getSchedule();
        if (schedule != null && schedule.getScheduleType() == MsgScheduleType.SPECIFIC_TIME) {
            startDate = schedule.getStartDate();
        }

        Date endDate = expiration.getExpirationDate();
        return endDate.getTime() - startDate.getTime();
        */
        return -1;
    }

    private TriggerModel createGeofenceTrigger(Message message) {
        /*
        MsgGeofence geofence = message.getGeofence();
        if (geofence == null) {
            return null;
        }

        TriggerModel model = new TriggerModel();
        model.setType(TriggerType.GEOFENCE);
        model.setMultiTriggerOption(geofence.getMultiTriggerOption());
        model.setTimeRestriction(message.getTimeRestriction());

        TriggerGeofenceCondition geofenceCondition = new TriggerGeofenceCondition();
        if (geofence.getGeofenceType() == MsgGeofenceType.SPECIFIC) {
            geofenceCondition.setGeofenceId(geofence.getGeofenceId());
        } else {
            geofenceCondition.setGroups(geofence.getGeofenceGroups());
        }
        geofenceCondition.setTriggerOption(geofence.getLocationTriggerOption());
        model.setGeofenceCondition(geofenceCondition);

        if (message.getTriggerId() != null) {
            model.setId(message.getTriggerId().intValue());
        }

        return model;
         */
        return null;
    }

    private int calculateSampleUserCount(int totalUserCount,
                                         int sampleRate) {
        /*
        return (int) Math.ceil((double) totalUserCount * sampleRate / 100);

         */
        return -1;
    }

    private int calculateSampleDeviceCount(PushMsgUserCount totalCounts,
                                           int sampleRate) {
        /*
        int android = (int) Math.ceil((double) totalCounts.getNumberOfAndroidDevices() * sampleRate / 100);
        int ios = (int) Math.ceil((double) totalCounts.getNumberOfIosDevices() * sampleRate / 100);
        int chr = (int) Math.ceil((double) totalCounts.getNumberOfChromeDevices() * sampleRate / 100);
        int ff = (int) Math.ceil((double) totalCounts.getNumberOfFireFoxDevices() * sampleRate / 100);
        int mac = (int) Math.ceil((double) totalCounts.getNumberOfMacosDevices() * sampleRate / 100);
        int opera = (int) Math.ceil((double) totalCounts.getNumberOfOperaDevices() * sampleRate / 100);
        int yandex = (int) Math.ceil((double) totalCounts.getNumberOfYandexDevices() * sampleRate / 100);
        int edge = (int) Math.ceil((double) totalCounts.getNumberOfEdgeDevices() * sampleRate / 100);

        return android + ios + chr + ff + mac + opera + yandex + edge;

         */
        return -1;
    }

    private String getNameOfRadioButton(String dynamicComponentText,
                                        String buttonNameStr,
                                        String regex) {
        /*
        String[] buttonNames = buttonNameStr.split(regex);
        for (String button : buttonNames) {
            if (null != dynamicComponentText && dynamicComponentText.trim().equals(button)) {
                return button;
            }
        }
        return null;
        */
        return null;
    }

    private BusinessUnit getBusinessUnit(Long businessUnitId,
                                         String appKey) {
        /*
        // Check if user has business unit. If not, get default business unit.
        return appService.getBusinessUnitById(appKey, businessUnitId.intValue());

         */
        return null;
    }

    private boolean hasSetRowMailService(String appKey) {
        /*
        boolean hasPermission = subscriptionService.cacheable() //
                .hasServicePermission(appKey, ServiceDef.SERVICE_NAME_SETROW_MAIL_SERVICE);
        if (!hasPermission)
            return false;
        SetRowConfig config = appService.cacheable() //
                .getSetRowConfig(appKey);
        return config != null && config.getConfigStatus() == ConfigStatus.ACTIVE;
        */
        return false;
    }
}
