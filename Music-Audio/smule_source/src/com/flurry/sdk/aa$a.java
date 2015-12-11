// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class > extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/aa$a, s);
    }

    public static Of[] values()
    {
        return (Of[])e.clone();
    }

    static 
    {
        a = new <init>("NONE", 0);
        b = new <init>("INIT", 1);
        c = new <init>("ACTIVE", 2);
        d = new <init>("PAUSED", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
