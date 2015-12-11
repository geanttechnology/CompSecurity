// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class t> extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static t> valueOf(String s)
    {
        return (t>)Enum.valueOf(com/flurry/sdk/w$a, s);
    }

    public static eOf[] values()
    {
        return (eOf[])c.clone();
    }

    static 
    {
        a = new <init>("INIT", 0);
        b = new <init>("READY", 1);
        c = (new c[] {
            a, b
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
