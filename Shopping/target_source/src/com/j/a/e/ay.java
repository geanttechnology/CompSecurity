// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;


public final class ay extends Enum
{

    public static final ay a;
    public static final ay b;
    public static final ay c;
    public static final ay d;
    private static final ay e[];

    private ay(String s, int i)
    {
        super(s, i);
    }

    public static ay valueOf(String s)
    {
        return (ay)Enum.valueOf(com/j/a/e/ay, s);
    }

    public static ay[] values()
    {
        return (ay[])e.clone();
    }

    static 
    {
        a = new ay("TLDEV", 0);
        b = new ay("TLPRODUCTION", 1);
        c = new ay("TLSTAGING", 2);
        d = new ay("TLLOCALHOST", 3);
        e = (new ay[] {
            a, b, c, d
        });
    }
}
