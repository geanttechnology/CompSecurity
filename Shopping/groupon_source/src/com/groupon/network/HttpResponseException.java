// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.network;

import java.io.IOException;

public class HttpResponseException extends IOException
{

    public static final int STATUS_CODE_INVALID = 0;
    protected int statusCode;

    public HttpResponseException(int i, String s)
    {
        super(s);
        statusCode = 0;
        statusCode = i;
    }

    public HttpResponseException(Throwable throwable)
    {
        statusCode = 0;
        initCause(throwable);
    }

    public int getStatusCode()
    {
        return statusCode;
    }
}
