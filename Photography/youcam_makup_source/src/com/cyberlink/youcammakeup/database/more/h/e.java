// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.h;

import android.content.ContentValues;

public class e
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final String g;

    public e(String s, String s1, String s2, String s3, String s4, int i, String s5)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = i;
        g = s5;
    }

    public ContentValues a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("PatternGUID", a);
        contentvalues.put("PaletteGUID", b);
        contentvalues.put("Source", c);
        contentvalues.put("Purpose", d);
        contentvalues.put("Type", e);
        contentvalues.put("ColorCount", Integer.valueOf(f));
        contentvalues.put("ColorIntensities", g);
        return contentvalues;
    }
}
