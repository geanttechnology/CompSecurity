// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;


// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackCrashData

public class UserFeedbackCrashBuilder
{

    static final boolean $assertionsDisabled;
    private String exceptionClassName;
    private String exceptionMessage;
    private String stackTrace;
    private String throwClassName;
    private String throwFileName;
    private int throwLineNumber;
    private String throwMethodName;

    private UserFeedbackCrashBuilder()
    {
        setExceptionClassName(null);
        setThrowFileName(null);
        setThrowLineNumber(-1);
        setThrowClassName(null);
        setThrowMethodName(null);
        setStackTrace(null);
        setExceptionMessage(null);
    }

    public static UserFeedbackCrashBuilder newInstance()
    {
        return new UserFeedbackCrashBuilder();
    }

    public UserFeedbackCrashData build()
    {
        if (!$assertionsDisabled && exceptionClassName == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && throwFileName == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && throwClassName == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && throwMethodName == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && stackTrace == null)
        {
            throw new AssertionError();
        } else
        {
            return new UserFeedbackCrashData(exceptionClassName, throwFileName, throwLineNumber, throwClassName, throwMethodName, stackTrace, exceptionMessage);
        }
    }

    public UserFeedbackCrashBuilder setExceptionClassName(String s)
    {
        exceptionClassName = s;
        return this;
    }

    public UserFeedbackCrashBuilder setExceptionMessage(String s)
    {
        exceptionMessage = s;
        return this;
    }

    public UserFeedbackCrashBuilder setStackTrace(String s)
    {
        stackTrace = s;
        return this;
    }

    public UserFeedbackCrashBuilder setThrowClassName(String s)
    {
        throwClassName = s;
        return this;
    }

    public UserFeedbackCrashBuilder setThrowFileName(String s)
    {
        throwFileName = s;
        return this;
    }

    public UserFeedbackCrashBuilder setThrowLineNumber(int i)
    {
        throwLineNumber = i;
        return this;
    }

    public UserFeedbackCrashBuilder setThrowMethodName(String s)
    {
        throwMethodName = s;
        return this;
    }

    static 
    {
        boolean flag;
        if (!com/google/userfeedback/android/api/UserFeedbackCrashBuilder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
