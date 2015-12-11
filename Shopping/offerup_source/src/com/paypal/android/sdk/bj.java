// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public abstract class bj
{

    private String a;
    private String b;

    private bj()
    {
    }

    protected bj(String s, String s1)
    {
        this();
        a = s1;
        b = null;
    }

    protected bj(String s, String s1, String s2)
    {
        this();
        a = s1;
        b = s2;
    }

    public final String a()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder("ErrorBase[mErrorCode=")).append(a).append(" mErrorMsgShort=").append(b).append("]").toString();
    }
}
