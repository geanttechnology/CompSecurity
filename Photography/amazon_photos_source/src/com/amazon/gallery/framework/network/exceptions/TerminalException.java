// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.exceptions;

import org.apache.http.StatusLine;

public class TerminalException extends Exception
{

    private int statusCode;

    public TerminalException()
    {
    }

    public TerminalException(String s)
    {
        super(s);
    }

    public TerminalException(String s, Exception exception)
    {
        super(s, exception);
    }

    public TerminalException(String s, StatusLine statusline)
    {
        super((new StringBuilder()).append("HTTP request [").append(s).append("] returned ").append(statusline.getStatusCode()).append(" ").append(statusline.getReasonPhrase()).toString());
        statusCode = statusline.getStatusCode();
    }

    public TerminalException(Throwable throwable)
    {
        super(throwable);
    }
}
