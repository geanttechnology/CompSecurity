// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.j;

import android.content.ContentValues;

public class a
{

    private final String a;
    private final String b = "";
    private final String c;
    private final String d;
    private final String e = "";
    private final String f = "";
    private final String g = "";

    public a(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        a = s;
        c = s2;
        d = s3;
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

    public ContentValues d()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("GUID", a);
        contentvalues.put("ExtraData", b);
        contentvalues.put("Ext1", c);
        contentvalues.put("Ext2", d);
        contentvalues.put("Ext3", e);
        contentvalues.put("Ext4", f);
        contentvalues.put("Ext5", g);
        return contentvalues;
    }
}
