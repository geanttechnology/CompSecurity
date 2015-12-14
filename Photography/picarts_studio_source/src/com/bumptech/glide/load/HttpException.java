// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException
{

    public static final int UNKNOWN = -1;
    private final int statusCode;

    public HttpException(int i)
    {
        this((new StringBuilder("Http request failed with status code: ")).append(i).toString(), i);
    }

    public HttpException(String s)
    {
        this(s, -1);
    }

    public HttpException(String s, int i)
    {
        this(s, i, null);
    }

    public HttpException(String s, int i, Throwable throwable)
    {
        super(s, throwable);
        statusCode = i;
    }

    public final int getStatusCode()
    {
        return statusCode;
    }
}
