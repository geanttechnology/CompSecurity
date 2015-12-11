// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;


public class UserFeedbackCrashData
{

    public String exceptionClassName;
    public String exceptionMessage;
    public String stackTrace;
    public String throwClassName;
    public String throwFileName;
    public int throwLineNumber;
    public String throwMethodName;

    UserFeedbackCrashData(UserFeedbackCrashData userfeedbackcrashdata)
    {
        this(userfeedbackcrashdata.exceptionClassName, userfeedbackcrashdata.throwFileName, userfeedbackcrashdata.throwLineNumber, userfeedbackcrashdata.throwClassName, userfeedbackcrashdata.throwMethodName, userfeedbackcrashdata.stackTrace, userfeedbackcrashdata.exceptionMessage);
    }

    UserFeedbackCrashData(String s, String s1, int i, String s2, String s3, String s4, String s5)
    {
        exceptionClassName = s;
        throwFileName = s1;
        throwLineNumber = i;
        throwClassName = s2;
        throwMethodName = s3;
        stackTrace = s4;
        exceptionMessage = s5;
    }
}
