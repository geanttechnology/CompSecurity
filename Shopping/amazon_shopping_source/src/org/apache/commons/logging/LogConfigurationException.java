// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;


public class LogConfigurationException extends RuntimeException
{

    protected Throwable cause;

    public LogConfigurationException()
    {
        cause = null;
    }

    public LogConfigurationException(String s, Throwable throwable)
    {
        super(s + " (Caused by " + throwable + ")");
        cause = null;
        cause = throwable;
    }

    public LogConfigurationException(Throwable throwable)
    {
        String s;
        if (throwable == null)
        {
            s = null;
        } else
        {
            s = throwable.toString();
        }
        this(s, throwable);
    }

    public Throwable getCause()
    {
        return cause;
    }
}
