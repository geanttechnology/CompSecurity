// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class > extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/ea$a, s);
    }

    public static Of[] values()
    {
        return (Of[])c.clone();
    }

    static 
    {
        a = new <init>("RELOAD_ACTIVITY", 0);
        b = new <init>("CLOSE_ACTIVITY", 1);
        c = (new c[] {
            a, b
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
