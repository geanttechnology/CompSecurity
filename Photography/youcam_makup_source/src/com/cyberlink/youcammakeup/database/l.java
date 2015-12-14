// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentValues;

public class l
{

    private int a;
    private int b;
    private long c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public l(int k, int i1, long l1, String s, String s1, String s2, 
            String s3, String s4)
    {
        a = k;
        b = i1;
        c = l1;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        h = s4;
    }

    public l(l l1)
    {
        this(l1.b(), l1.c(), l1.d(), l1.e(), l1.f(), l1.g(), l1.h(), l1.i());
    }

    public int b()
    {
        return a;
    }

    public int c()
    {
        return b;
    }

    public long d()
    {
        return c;
    }

    public String e()
    {
        return d;
    }

    public String f()
    {
        return e;
    }

    public String g()
    {
        return f;
    }

    public String h()
    {
        return g;
    }

    public String i()
    {
        return h;
    }

    protected ContentValues j()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("HasDevelopAdjustments", Integer.valueOf(b()));
        contentvalues.put("IsBlackWhite", Integer.valueOf(c()));
        contentvalues.put("ImageID", Long.valueOf(d()));
        contentvalues.put("Formating", e());
        contentvalues.put("Name", f());
        contentvalues.put("RelValueString", g());
        contentvalues.put("TEXT", h());
        contentvalues.put("ValueString", i());
        return contentvalues;
    }

    public String toString()
    {
        return j().toString();
    }
}
