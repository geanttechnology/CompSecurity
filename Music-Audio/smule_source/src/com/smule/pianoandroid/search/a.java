// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.search;


public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    private static final a f[];

    private a(String s, int i)
    {
        super(s, i);
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/smule/pianoandroid/search/a, s);
    }

    public static a[] values()
    {
        return (a[])f.clone();
    }

    static 
    {
        a = new a("EXACT", 0);
        b = new a("DICE", 1);
        c = new a("COSINE", 2);
        d = new a("JACCARD", 3);
        e = new a("OVERLAP", 4);
        f = (new a[] {
            a, b, c, d, e
        });
    }
}
