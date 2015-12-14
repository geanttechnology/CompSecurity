// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;

public class k
{

    private String a;
    private String b;
    private String c;

    public k(String s, String s1, String s2)
    {
        a = s;
        b = s1;
        c = s2;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public ContentValues d()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MessageId", a());
        contentvalues.put("ReceiptId", b());
        contentvalues.put("Status", c());
        return contentvalues;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(b).append(", ").append(c).append(":").append(s).toString();
    }
}
