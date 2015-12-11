// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.ProtocolException;

public class MalformedCookieException extends ProtocolException
{

    private static final long serialVersionUID = 0xa314efed1ef72bf7L;

    public MalformedCookieException()
    {
    }

    public MalformedCookieException(String s)
    {
        super(s);
    }

    public MalformedCookieException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
