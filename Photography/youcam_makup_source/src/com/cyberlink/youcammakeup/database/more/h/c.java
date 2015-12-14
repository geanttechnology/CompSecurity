// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;

public class c
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final float g;
    private final String h;
    private final String i;
    private final boolean j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final int p;
    private final int q;
    private final int r;

    public c(String s, String s1, String s2, String s3, String s4, String s5, float f1, 
            String s6, String s7, boolean flag, String s8, String s9, String s10, String s11, 
            String s12, int i1, int j1, int k1)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = f1;
        h = s6;
        i = s7;
        j = flag;
        k = s8;
        l = s9;
        m = s10;
        n = s11;
        o = s12;
        p = i1;
        q = j1;
        r = k1;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public float f()
    {
        return g;
    }

    public String g()
    {
        return h;
    }

    public String h()
    {
        return i;
    }

    public String i()
    {
        return l;
    }

    public boolean j()
    {
        return j;
    }

    public String k()
    {
        return k;
    }

    public ContentValues l()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("PatternType", b);
        contentvalues.put("Name", c);
        contentvalues.put("ThumbPath", d);
        contentvalues.put("Source", e);
        contentvalues.put("SupportMode", f);
        contentvalues.put("Version", Float.valueOf(g));
        contentvalues.put("ColorImagePath", h);
        contentvalues.put("ToolImagePath", i);
        contentvalues.put("IsNew", Boolean.valueOf(j));
        contentvalues.put("SkuGUID", k);
        contentvalues.put("ExtraData", l);
        contentvalues.put("ExtStr1", m);
        contentvalues.put("ExtStr2", n);
        contentvalues.put("ExtStr3", o);
        contentvalues.put("ExtInt1", Integer.valueOf(p));
        contentvalues.put("ExtInt2", Integer.valueOf(q));
        contentvalues.put("ExtInt3", Integer.valueOf(r));
        return contentvalues;
    }
}
