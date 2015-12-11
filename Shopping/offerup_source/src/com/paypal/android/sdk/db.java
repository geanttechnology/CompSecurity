// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class db extends Enum
{

    public static final db a;
    private static db b;
    private static final db c[];

    private db(String s, int i)
    {
        super(s, i);
    }

    public static db valueOf(String s)
    {
        return (db)Enum.valueOf(com/paypal/android/sdk/db, s);
    }

    public static db[] values()
    {
        return (db[])c.clone();
    }

    static 
    {
        b = new db("token", 0);
        a = new db("code", 1);
        c = (new db[] {
            b, a
        });
    }
}
