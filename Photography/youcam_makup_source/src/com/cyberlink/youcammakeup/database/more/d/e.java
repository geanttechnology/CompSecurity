// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;

public class e
{

    private final String a;
    private final float b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final int n;
    private final int o;
    private final int p;

    public e(String s, float f1, String s1, String s2, String s3, String s4, String s5, 
            String s6, boolean flag, String s7, String s8, String s9, String s10, int i1, 
            int j1, int k1)
    {
        a = s;
        b = f1;
        c = s1;
        d = s2;
        e = s3;
        f = s4;
        g = s5;
        h = s6;
        i = flag;
        j = s7;
        k = s8;
        l = s9;
        m = s10;
        n = i1;
        o = j1;
        p = k1;
    }

    public String a()
    {
        return a;
    }

    public float b()
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

    public String f()
    {
        return f;
    }

    public String g()
    {
        return g;
    }

    public String h()
    {
        return h;
    }

    public boolean i()
    {
        return i;
    }

    public String j()
    {
        return j;
    }

    public ContentValues k()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("Version", Float.valueOf(b));
        contentvalues.put("Name", c);
        contentvalues.put("Description", d);
        contentvalues.put("ThumbImage", e);
        contentvalues.put("PreviewImage", f);
        contentvalues.put("Source", g);
        contentvalues.put("SupportMode", h);
        contentvalues.put("IsNew", Boolean.valueOf(i));
        contentvalues.put("ExtraData", j);
        contentvalues.put("ExtStr1", k);
        contentvalues.put("ExtStr2", l);
        contentvalues.put("ExtStr3", m);
        contentvalues.put("ExtInt1", Integer.valueOf(n));
        contentvalues.put("ExtInt2", Integer.valueOf(o));
        contentvalues.put("ExtInt3", Integer.valueOf(p));
        return contentvalues;
    }
}
