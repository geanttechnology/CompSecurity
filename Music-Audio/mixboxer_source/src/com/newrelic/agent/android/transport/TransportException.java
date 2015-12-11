// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport;


public class TransportException extends Exception
{

    private static final long serialVersionUID = 1L;
    private final int statusCode;

    public TransportException(int i, String s)
    {
        super(s);
        statusCode = i;
    }

    public TransportException(String s)
    {
        super(s);
        statusCode = 0;
    }

    public TransportException(Throwable throwable)
    {
        super(throwable);
        statusCode = 0;
    }

    public int getStatusCode()
    {
        return statusCode;
    }
}
