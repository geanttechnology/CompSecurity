// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            int l, String s7, String s8, String s9)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = l;
        i = s7;
        j = s8;
        k = s9;
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
        return f;
    }

    public String f()
    {
        return g;
    }

    public int g()
    {
        return h;
    }

    public String h()
    {
        return i;
    }

    protected ContentValues i()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("SkuGUID", a);
        contentvalues.put("ItemGUID", b);
        contentvalues.put("PatternGUID", c);
        contentvalues.put("ColorNumber", d);
        contentvalues.put("ColorName", e);
        contentvalues.put("ColorType", f);
        contentvalues.put("Color", g);
        contentvalues.put("Intensity", Integer.valueOf(h));
        contentvalues.put("ExtraData", i);
        contentvalues.put("Ext_1", j);
        contentvalues.put("Ext_2", k);
        return contentvalues;
    }
}
