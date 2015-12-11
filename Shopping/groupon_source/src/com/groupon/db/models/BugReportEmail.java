// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class BugReportEmail
{

    public String emailBody;
    public String emailRecipient;
    public String emailSubject;
    public Long primaryKey;
    public String screenshotFileName;
    public int sendCount;

    public BugReportEmail()
    {
        emailSubject = "";
        emailRecipient = "";
        emailBody = "";
        screenshotFileName = "";
        sendCount = 0;
    }
}
