// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;


public class InvalidDeepLinkException extends Exception
{

    public InvalidDeepLinkException()
    {
    }

    public InvalidDeepLinkException(String s)
    {
        super(s);
    }

    public InvalidDeepLinkException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    protected InvalidDeepLinkException(String s, Throwable throwable, boolean flag, boolean flag1)
    {
        super(s, throwable, flag, flag1);
    }

    public InvalidDeepLinkException(Throwable throwable)
    {
        super(throwable);
    }
}
