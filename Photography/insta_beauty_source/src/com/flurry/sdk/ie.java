// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public class ie
{

    private long a;
    private boolean b;
    private byte c[];

    public ie()
    {
    }

    static long a(ie ie1)
    {
        return ie1.a;
    }

    static long a(ie ie1, long l)
    {
        ie1.a = l;
        return l;
    }

    static boolean a(ie ie1, boolean flag)
    {
        ie1.b = flag;
        return flag;
    }

    static byte[] a(ie ie1, byte abyte0[])
    {
        ie1.c = abyte0;
        return abyte0;
    }

    static boolean b(ie ie1)
    {
        return ie1.b;
    }

    static byte[] c(ie ie1)
    {
        return ie1.c;
    }

    public long a()
    {
        return a;
    }

    public void a(long l)
    {
        a = l;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void a(byte abyte0[])
    {
        c = abyte0;
    }

    public boolean b()
    {
        return b;
    }

    public byte[] c()
    {
        return c;
    }
}
