// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import java.io.IOException;

public class ClientProtocolException extends IOException
{

    public ClientProtocolException()
    {
    }

    public ClientProtocolException(String s)
    {
        super(s);
    }

    public ClientProtocolException(Throwable throwable)
    {
        initCause(throwable);
    }
}
