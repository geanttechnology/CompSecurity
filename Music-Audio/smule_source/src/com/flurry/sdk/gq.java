// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.UUID;

public class gq
{

    private static final String b = com/flurry/sdk/gq.getSimpleName();
    String a;
    private byte c[];

    private gq()
    {
        a = null;
        c = null;
    }


    public gq(byte abyte0[])
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

    static byte[] a(gq gq1)
    {
        return gq1.c;
    }

    static byte[] a(gq gq1, byte abyte0[])
    {
        gq1.c = abyte0;
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
