// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;

public class i
{

    private String a;
    private String b;

    public i(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public ContentValues c()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MessageId", a());
        contentvalues.put("UserId", b());
        return contentvalues;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(b).append(":").append(s).toString();
    }
}
