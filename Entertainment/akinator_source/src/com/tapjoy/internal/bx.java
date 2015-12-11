// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


final class bx extends Enum
{

    public static final bx a;
    public static final bx b;
    public static final bx c;
    public static final bx d;
    public static final bx e;
    public static final bx f;
    public static final bx g;
    public static final bx h;
    private static final bx i[];

    private bx(String s, int j)
    {
        super(s, j);
    }

    public static bx valueOf(String s)
    {
        return (bx)Enum.valueOf(com/tapjoy/internal/bx, s);
    }

    public static bx[] values()
    {
        return (bx[])i.clone();
    }

    static 
    {
        a = new bx("EMPTY_ARRAY", 0);
        b = new bx("NONEMPTY_ARRAY", 1);
        c = new bx("EMPTY_OBJECT", 2);
        d = new bx("DANGLING_NAME", 3);
        e = new bx("NONEMPTY_OBJECT", 4);
        f = new bx("EMPTY_DOCUMENT", 5);
        g = new bx("NONEMPTY_DOCUMENT", 6);
        h = new bx("CLOSED", 7);
        i = (new bx[] {
            a, b, c, d, e, f, g, h
        });
    }
}
