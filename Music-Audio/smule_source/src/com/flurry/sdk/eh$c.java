// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class > extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/eh$c, s);
    }

    public static Of[] values()
    {
        return (Of[])d.clone();
    }

    static 
    {
        a = new <init>("WEB_RESULT_UNKNOWN", 0);
        b = new <init>("WEB_RESULT_BACK", 1);
        c = new <init>("WEB_RESULT_CLOSE", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
