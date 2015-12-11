// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.livechat;

import android.app.Application;
import android.content.res.Resources;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.FormField;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.util.LoggingUtils;
import roboguice.util.Strings;

public class LiveChatPreFormListener
    implements com.boldchat.sdk.BoldChatSession.ChatFormListener
{

    private static final String PAGE_ID_LIVE_CHAT_PRE_LIVE_CHAT_FORM = "pre_live_chat_form";
    private Application application;
    private String dealId;
    private String dealUrl;
    private String email;
    private LoggingUtils loggingUtils;
    private String name;
    private String pageId;

    public LiveChatPreFormListener(Application application1, LoggingUtils loggingutils, String s, String s1, String s2, String s3, String s4)
    {
        application = application1;
        loggingUtils = loggingutils;
        name = s;
        email = s1;
        pageId = s2;
        dealId = s3;
        dealUrl = s4;
    }

    public boolean onFormShow(Form form)
    {
        FormField formfield = form.getFormField("name");
        FormField formfield1 = form.getFormField("email");
        form = form.getFormField("initial_question");
        if (formfield != null)
        {
            formfield.setValue(name);
        }
        if (formfield1 != null)
        {
            formfield1.setValue(email);
        }
        if (form != null && Strings.notEmpty(dealUrl))
        {
            form.setValue(application.getResources().getString(0x7f080255, new Object[] {
                dealUrl
            }));
        }
        loggingUtils.logPageView("", "pre_live_chat_form", new LiveChatExtraInfo(pageId, dealId));
        return true;
    }
}
