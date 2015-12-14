// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.g;

import android.content.ContentValues;

public class c
{

    private final String a;
    private final String b;
    private final int c;
    private final int d;
    private final int e;

    public c(String s, String s1, int i, int j, int k)
    {
        a = s;
        b = s1;
        c = i;
        d = j;
        e = k;
    }

    public String a()
    {
        return a;
    }

    public int b()
    {
        return c;
    }

    public int c()
    {
        return d;
    }

    public int d()
    {
        return e;
    }

    public ContentValues e()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("palette_guid", a);
        contentvalues.put("style_guid", b);
        contentvalues.put("inner_ratio", Integer.valueOf(c));
        contentvalues.put("feather_strength", Integer.valueOf(d));
        contentvalues.put("intensity", Integer.valueOf(e));
        return contentvalues;
    }
}
