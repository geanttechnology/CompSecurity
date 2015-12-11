// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.unity;

import android.text.TextUtils;

public class UnityException extends RuntimeException
{

    private String sourceExceptionType;

    public UnityException()
    {
        sourceExceptionType = null;
    }

    public UnityException(String s)
    {
        super(s);
        sourceExceptionType = null;
    }

    public UnityException(String s, String s1)
    {
        super(s1);
        sourceExceptionType = null;
        sourceExceptionType = s;
    }

    public UnityException(String s, StackTraceElement astacktraceelement[])
    {
        super(s);
        sourceExceptionType = null;
        setStackTrace(astacktraceelement);
    }

    public void appendStackFrame(StackTraceElement stacktraceelement)
    {
        StackTraceElement astacktraceelement[] = getStackTrace();
        StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length + 1];
        for (int i = 0; i < astacktraceelement.length; i++)
        {
            astacktraceelement1[i] = astacktraceelement[i];
        }

        astacktraceelement1[astacktraceelement.length] = stacktraceelement;
        setStackTrace(astacktraceelement1);
    }

    public void appendStackFrame(String s, String s1, String s2, int i)
    {
        s = new StackTraceElement(s, s1, s2, i);
        s1 = getStackTrace();
        s2 = new StackTraceElement[s1.length + 1];
        for (i = 0; i < s1.length; i++)
        {
            s2[i] = s1[i];
        }

        s2[s1.length] = s;
        setStackTrace(s2);
    }

    public void setSourceExceptionType(String s)
    {
        sourceExceptionType = s;
    }

    public String toString()
    {
        if (TextUtils.isEmpty(sourceExceptionType))
        {
            return getClass().getName();
        } else
        {
            return sourceExceptionType;
        }
    }
}
