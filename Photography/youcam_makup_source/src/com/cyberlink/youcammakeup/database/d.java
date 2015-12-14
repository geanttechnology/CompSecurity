// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import java.util.Locale;
import java.util.TreeMap;

public class d
{

    public static final d a = new d(1, "Tiny");
    public static final d b = new d(2, "Small");
    public static final d c = new d(3, "TinyLibPhoto");
    public static final d d = new d(4, "TinyLibAlbum");
    private static final TreeMap e = new TreeMap();
    private int f;
    private String g;

    public d(int i, String s)
    {
        g = "";
        f = i;
        g = s;
        e.put(Integer.valueOf(i), this);
    }

    public static d a(Integer integer)
    {
        return (d)e.get(integer);
    }

    public int a()
    {
        return f;
    }

    public String b()
    {
        return g.toUpperCase(Locale.US);
    }

    public String toString()
    {
        return (new StringBuilder()).append("Ordinal: ").append(f).append(", Description: ").append(g).toString();
    }

}
