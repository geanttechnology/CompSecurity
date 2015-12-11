// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e;


public final class i extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static final i j;
    public static final i k;
    public static final i l;
    private static final i m[];

    private i(String s, int i1)
    {
        super(s, i1);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/google/api/a/e/i, s);
    }

    public static i[] values()
    {
        return (i[])m.clone();
    }

    static 
    {
        a = new i("START_ARRAY", 0);
        b = new i("END_ARRAY", 1);
        c = new i("START_OBJECT", 2);
        d = new i("END_OBJECT", 3);
        e = new i("FIELD_NAME", 4);
        f = new i("VALUE_STRING", 5);
        g = new i("VALUE_NUMBER_INT", 6);
        h = new i("VALUE_NUMBER_FLOAT", 7);
        i = new i("VALUE_TRUE", 8);
        j = new i("VALUE_FALSE", 9);
        k = new i("VALUE_NULL", 10);
        l = new i("NOT_AVAILABLE", 11);
        m = (new i[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
