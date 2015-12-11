// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class > extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/ci$a, s);
    }

    public static Of[] values()
    {
        return (Of[])f.clone();
    }

    static 
    {
        a = new <init>("NONE", 0);
        b = new <init>("WAIT_FOR_REPORTED_IDS", 1);
        c = new <init>("BUILD_REQUEST", 2);
        d = new <init>("REQUEST", 3);
        e = new <init>("PREPROCESS", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
