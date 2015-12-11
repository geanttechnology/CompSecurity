// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class bk extends Enum
{

    public static final bk a;
    public static final bk b;
    public static final bk c;
    public static final bk d;
    private static final bk e[];

    private bk(String s, int i)
    {
        super(s, i);
    }

    public static bk valueOf(String s)
    {
        return (bk)Enum.valueOf(com/paypal/android/sdk/bk, s);
    }

    public static bk[] values()
    {
        return (bk[])e.clone();
    }

    static 
    {
        a = new bk("INTERNAL_SERVER_ERROR", 0);
        b = new bk("SERVER_COMMUNICATION_ERROR", 1);
        c = new bk("PARSE_RESPONSE_ERROR", 2);
        d = new bk("INTERNAL_ERROR", 3);
        e = (new bk[] {
            a, b, c, d
        });
    }
}
