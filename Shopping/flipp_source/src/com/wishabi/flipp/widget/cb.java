// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


public final class cb extends Enum
{

    public static final cb a;
    public static final cb b;
    public static final cb c;
    private static final cb d[];

    private cb(String s, int i)
    {
        super(s, i);
    }

    public static cb valueOf(String s)
    {
        return (cb)Enum.valueOf(com/wishabi/flipp/widget/cb, s);
    }

    public static cb[] values()
    {
        return (cb[])d.clone();
    }

    static 
    {
        a = new cb("FEATURED", 0);
        b = new cb("ALPHABETICAL", 1);
        c = new cb("LATEST", 2);
        d = (new cb[] {
            a, b, c
        });
    }
}
