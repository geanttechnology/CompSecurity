// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public class ip
{

    private byte a[];

    public ip()
    {
    }

    public ip(byte abyte0[])
    {
        a = abyte0;
    }

    static byte[] a(ip ip1)
    {
        return ip1.a;
    }

    static byte[] a(ip ip1, byte abyte0[])
    {
        ip1.a = abyte0;
        return abyte0;
    }

    public byte[] a()
    {
        return a;
    }
}
