// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;


public final class ay extends Enum
{

    public static final ay a;
    public static final ay b;
    public static final ay c;
    private static final ay d[];

    private ay(String s, int i)
    {
        super(s, i);
    }

    public static ay valueOf(String s)
    {
        return (ay)Enum.valueOf(com/smule/pianoandroid/magicpiano/ay, s);
    }

    public static ay[] values()
    {
        return (ay[])d.clone();
    }

    static 
    {
        a = new ay("PERFORMANCE", 0);
        b = new ay("ACHIEVEMENT", 1);
        c = new ay("LEVEL_UP", 2);
        d = (new ay[] {
            a, b, c
        });
    }
}
