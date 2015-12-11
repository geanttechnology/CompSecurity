// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class db extends Enum
{

    public static final db a;
    public static final db b;
    public static final db c;
    private static final db e[];
    private int d;

    private db(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static db valueOf(String s)
    {
        return (db)Enum.valueOf(com/flurry/sdk/db, s);
    }

    public static db[] values()
    {
        return (db[])e.clone();
    }

    static 
    {
        a = new db("Unknown", 0, 0);
        b = new db("InLine", 1, 1);
        c = new db("Wrapper", 2, 2);
        e = (new db[] {
            a, b, c
        });
    }
}
