// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final Integer e;

    public a(String s, String s1, String s2, String s3, Integer integer)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = integer;
    }

    protected ContentValues a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("PatternGUID", a);
        contentvalues.put("ColorGUID", b);
        contentvalues.put("Source", c);
        contentvalues.put("ExtStr", d);
        contentvalues.put("ExtInt", e);
        return contentvalues;
    }
}
