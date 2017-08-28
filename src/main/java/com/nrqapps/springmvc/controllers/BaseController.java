package com.nrqapps.springmvc.controllers;

import com.nrqapps.springmvc.pojos.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mauricio Enriquez on 8/28/17.
 * NrqApps © 2017
 */
public class BaseController {

    private ResourceBundleMessageSource messageSource;

    void sendUserNotification(HttpServletRequest request, Notification notification) {
        request.getSession().setAttribute(Notification.USER_NOTIFICATION, notification);
    }

    String getMessage(String key, String... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    @Autowired
    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
