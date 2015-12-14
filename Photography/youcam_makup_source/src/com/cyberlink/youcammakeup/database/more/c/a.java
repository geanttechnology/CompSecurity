// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.c;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d = null;
    private final String e = null;
    private final Integer f = null;
    private final Integer g = null;

    public a(String s, String s1, String s2)
    {
        a = s;
        b = s1;
        c = s2;
    }

    protected ContentValues a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Lang", a);
        contentvalues.put("Name", b);
        contentvalues.put("Value", c);
        contentvalues.put("ExtStr1", d);
        contentvalues.put("ExtStr2", e);
        contentvalues.put("ExtInt1", f);
        contentvalues.put("ExtInt2", g);
        return contentvalues;
    }
}
