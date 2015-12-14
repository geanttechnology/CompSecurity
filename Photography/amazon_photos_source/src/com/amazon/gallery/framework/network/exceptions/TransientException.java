// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.exceptions;

import org.apache.http.StatusLine;

public class TransientException extends Exception
{

    private int statusCode;

    public TransientException()
    {
    }

    public TransientException(Exception exception)
    {
        super(exception);
    }

    public TransientException(String s)
    {
        super(s);
    }

    public TransientException(String s, StatusLine statusline)
    {
        super((new StringBuilder()).append("HTTP request [").append(s).append("] returned ").append(statusline.getStatusCode()).append(" ").append(statusline.getReasonPhrase()).toString());
        statusCode = statusline.getStatusCode();
    }

    public int getStatusCode()
    {
        return statusCode;
    }
}
