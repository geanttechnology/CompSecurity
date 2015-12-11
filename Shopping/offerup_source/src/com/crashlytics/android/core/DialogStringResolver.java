// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.Context;
import c.a.a.a.a.b.l;

class DialogStringResolver
{

    private static final String PROMPT_MESSAGE_RES_NAME = "com.crashlytics.CrashSubmissionPromptMessage";
    private static final String PROMPT_TITLE_RES_NAME = "com.crashlytics.CrashSubmissionPromptTitle";
    private static final String SUBMISSION_ALWAYS_SEND_RES_NAME = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
    private static final String SUBMISSION_CANCEL_RES_NAME = "com.crashlytics.CrashSubmissionCancelTitle";
    private static final String SUBMISSION_SEND_RES_NAME = "com.crashlytics.CrashSubmissionSendTitle";
    private final Context context;
    private final c.a.a.a.a.g.l promptData;

    public DialogStringResolver(Context context1, c.a.a.a.a.g.l l1)
    {
        context = context1;
        promptData = l1;
    }

    private boolean isNullOrEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    private String resourceOrFallbackValue(String s, String s1)
    {
        return stringOrFallback(l.c(context, s), s1);
    }

    private String stringOrFallback(String s, String s1)
    {
        if (isNullOrEmpty(s))
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public String getAlwaysSendButtonTitle()
    {
        return resourceOrFallbackValue("com.crashlytics.CrashSubmissionAlwaysSendTitle", promptData.g);
    }

    public String getCancelButtonTitle()
    {
        return resourceOrFallbackValue("com.crashlytics.CrashSubmissionCancelTitle", promptData.e);
    }

    public String getMessage()
    {
        return resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptMessage", promptData.b);
    }

    public String getSendButtonTitle()
    {
        return resourceOrFallbackValue("com.crashlytics.CrashSubmissionSendTitle", promptData.c);
    }

    public String getTitle()
    {
        return resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptTitle", promptData.a);
    }
}
