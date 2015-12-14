// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.g;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b;
    private final int c;
    private final String d;
    private final String e;
    private final String f;
    private final float g;
    private final int h;
    private final boolean i;
    private final String j;
    private final String k = "";
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;

    public a(String s, String s1, int i1, String s2, String s3, String s4, float f1, 
            int j1, boolean flag, String s5, String s6, String s7, String s8, String s9, 
            String s10, String s11)
    {
        a = s;
        b = s1;
        c = i1;
        d = s2;
        e = s3;
        f = s4;
        g = f1;
        h = j1;
        i = flag;
        j = s5;
        l = s7;
        m = s8;
        n = s9;
        o = s10;
        p = s11;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public int c()
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

    public String f()
    {
        return f;
    }

    public String g()
    {
        return l;
    }

    public String h()
    {
        return m;
    }

    public float i()
    {
        return g;
    }

    public boolean j()
    {
        return i;
    }

    public String k()
    {
        return j;
    }

    public ContentValues l()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("ColorSetGUID", b);
        contentvalues.put("ColorCount", Integer.valueOf(c));
        contentvalues.put("Name", d);
        contentvalues.put("Thumbnail", e);
        contentvalues.put("Source", f);
        contentvalues.put("Version", Float.valueOf(g));
        contentvalues.put("PaletteOrder", Integer.valueOf(h));
        contentvalues.put("isNew", Boolean.valueOf(i));
        contentvalues.put("SkuGUID", j);
        contentvalues.put("ExtraData", k);
        contentvalues.put("Ext1", l);
        contentvalues.put("Ext2", m);
        contentvalues.put("Ext3", n);
        contentvalues.put("Ext4", o);
        contentvalues.put("Ext5", p);
        return contentvalues;
    }
}
