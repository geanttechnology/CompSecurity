// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;


public class UserAuthenticationException extends Exception
{

    public UserAuthenticationException(String s)
    {
        this(s, null);
    }

    public UserAuthenticationException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
