// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;


public final class l extends Enum
{

    public static final l a;
    public static final l b;
    private static final l c[];

    private l(String s, int i)
    {
        super(s, i);
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/smule/pianoandroid/utils/l, s);
    }

    public static l[] values()
    {
        return (l[])c.clone();
    }

    static 
    {
        a = new l("GOOGLE", 0);
        b = new l("AMAZON", 1);
        c = (new l[] {
            a, b
        });
    }
}
