// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.b;

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
    private final String h;

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = s7;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public String d()
    {
        return f;
    }

    public String e()
    {
        return g;
    }

    public ContentValues f()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Set_GUID", a);
        contentvalues.put("PatternType", b);
        contentvalues.put("Color", c);
        contentvalues.put("Intensity", d);
        contentvalues.put("Source", e);
        contentvalues.put("ExtraData", f);
        contentvalues.put("Ext_1", g);
        contentvalues.put("Ext_2", h);
        return contentvalues;
    }
}
