// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class jy extends Enum
{

    public static final jy a;
    public static final jy b;
    public static final jy c;
    public static final jy d;
    public static final jy e;
    public static final jy f;
    public static final jy g;
    public static final jy h;
    public static final jy i;
    public static final jy j;
    private static final jy k[];

    private jy(String s, int l)
    {
        super(s, l);
    }

    public static jy valueOf(String s)
    {
        return (jy)Enum.valueOf(com/flurry/sdk/jy, s);
    }

    public static jy[] values()
    {
        return (jy[])k.clone();
    }

    static 
    {
        a = new jy("BEGIN_ARRAY", 0);
        b = new jy("END_ARRAY", 1);
        c = new jy("BEGIN_OBJECT", 2);
        d = new jy("END_OBJECT", 3);
        e = new jy("NAME", 4);
        f = new jy("STRING", 5);
        g = new jy("NUMBER", 6);
        h = new jy("BOOLEAN", 7);
        i = new jy("NULL", 8);
        j = new jy("END_DOCUMENT", 9);
        k = (new jy[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
