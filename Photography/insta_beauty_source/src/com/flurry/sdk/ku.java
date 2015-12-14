// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.UUID;

public class ku
{

    private static final String b = com/flurry/sdk/ku.getSimpleName();
    String a;
    private byte c[];

    private ku()
    {
        a = null;
        c = null;
    }

    ku(_cls1 _pcls1)
    {
        this();
    }

    public ku(byte abyte0[])
    {
        a = null;
        c = null;
        a = UUID.randomUUID().toString();
        c = abyte0;
    }

    public static String a(String s)
    {
        return (new StringBuilder()).append(".yflurrydatasenderblock.").append(s).toString();
    }

    static byte[] a(ku ku1)
    {
        return ku1.c;
    }

    static byte[] a(ku ku1, byte abyte0[])
    {
        ku1.c = abyte0;
        return abyte0;
    }

    public String a()
    {
        return a;
    }

    public byte[] b()
    {
        return c;
    }

}
