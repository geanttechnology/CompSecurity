// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class t> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static t> valueOf(String s)
    {
        return (t>)Enum.valueOf(com/flurry/sdk/t$a, s);
    }

    public static eOf[] values()
    {
        return (eOf[])e.clone();
    }

    static 
    {
        a = new <init>("INIT", 0);
        b = new <init>("READY", 1);
        c = new <init>("DISPLAY", 2);
        d = new <init>("NEXT", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
