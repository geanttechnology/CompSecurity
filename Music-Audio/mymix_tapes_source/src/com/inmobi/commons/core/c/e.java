// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import android.content.ContentValues;

public class e
{

    private static final String a = com/inmobi/commons/core/c/e.getSimpleName();
    private String b;
    private String c;
    private long d;
    private String e;

    public e(String s, String s1)
    {
        c = s;
        b = s1;
        e = null;
        d = System.currentTimeMillis();
    }

    public e(String s, String s1, String s2)
    {
        c = s;
        b = s1;
        e = s2;
        d = System.currentTimeMillis();
    }

    public static e a(ContentValues contentvalues)
    {
        String s = contentvalues.getAsString("eventType");
        String s1 = contentvalues.getAsString("componentType");
        String s2 = contentvalues.getAsString("payload");
        long l = Long.valueOf(contentvalues.getAsString("ts")).longValue();
        contentvalues = new e(s1, s, s2);
        contentvalues.d = l;
        return contentvalues;
    }

    public String a()
    {
        return c;
    }

    public void a(String s)
    {
        e = s;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        if (e == null)
        {
            return "";
        } else
        {
            return e;
        }
    }

    public long d()
    {
        return d;
    }

    public ContentValues e()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("componentType", a());
        contentvalues.put("eventType", b());
        contentvalues.put("payload", c());
        contentvalues.put("ts", String.valueOf(d()));
        return contentvalues;
    }

    public String toString()
    {
        return (new StringBuilder()).append(b()).append("@").append(a()).append(" ").toString();
    }

}
