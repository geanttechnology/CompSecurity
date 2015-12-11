// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import com.comcast.cim.httpcomponentsandroid.util.ExceptionUtils;

public class HttpException extends Exception
{

    public HttpException()
    {
    }

    public HttpException(String s)
    {
        super(s);
    }

    public HttpException(String s, Throwable throwable)
    {
        super(s);
        ExceptionUtils.initCause(this, throwable);
    }
}
