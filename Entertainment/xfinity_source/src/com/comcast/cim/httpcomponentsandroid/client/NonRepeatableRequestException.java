// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.ProtocolException;

public class NonRepeatableRequestException extends ProtocolException
{

    public NonRepeatableRequestException()
    {
    }

    public NonRepeatableRequestException(String s)
    {
        super(s);
    }

    public NonRepeatableRequestException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
