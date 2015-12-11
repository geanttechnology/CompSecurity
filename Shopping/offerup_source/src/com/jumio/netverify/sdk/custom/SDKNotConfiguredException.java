// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;


public class SDKNotConfiguredException extends Exception
{

    private static final long serialVersionUID = 0x92cb333ac9cd1462L;

    public SDKNotConfiguredException()
    {
    }

    public SDKNotConfiguredException(String s)
    {
        super(s);
    }

    public SDKNotConfiguredException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public SDKNotConfiguredException(Throwable throwable)
    {
        super(throwable);
    }
}
