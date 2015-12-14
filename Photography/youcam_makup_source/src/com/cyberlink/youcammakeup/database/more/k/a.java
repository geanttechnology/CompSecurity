// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.k;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    public a(String s, String s1, String s2, String s3, String s4, String s5)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
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
        return b;
    }

    public String d()
    {
        return d;
    }

    protected ContentValues e()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("PatternId", a);
        contentvalues.put("TattooMaskOrder", b);
        contentvalues.put("TattoMaskPath", c);
        contentvalues.put("ExtraData", d);
        contentvalues.put("Ext_1", e);
        contentvalues.put("Ext_2", f);
        return contentvalues;
    }
}
