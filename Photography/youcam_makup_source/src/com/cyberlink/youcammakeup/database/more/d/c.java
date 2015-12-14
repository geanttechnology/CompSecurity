// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.d;

import android.content.ContentValues;

public class c
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final Integer f;
    private final Integer g;

    public c(String s, String s1, String s2, String s3, String s4, Integer integer, Integer integer1)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = integer;
        g = integer1;
    }

    public String a()
    {
        return a;
    }

    protected ContentValues b()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("Type", b);
        contentvalues.put("Category", c);
        contentvalues.put("ExtStr1", d);
        contentvalues.put("ExtStr2", e);
        contentvalues.put("ExtInt1", f);
        contentvalues.put("ExtInt2", g);
        return contentvalues;
    }
}
