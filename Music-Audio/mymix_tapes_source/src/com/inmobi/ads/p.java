// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.ContentValues;
import java.util.Map;

public class p
{

    private static final String a = com/inmobi/ads/p.getSimpleName();
    private long b;
    private String c;
    private Map d;
    private String e;
    private String f;

    public p(long l, String s)
    {
        f = "int";
        b = l;
        c = s;
        if (c == null)
        {
            c = "";
        }
    }

    public p(ContentValues contentvalues)
    {
        f = "int";
        b = contentvalues.getAsLong("placement_id").longValue();
        c = contentvalues.getAsString("tp_key");
    }

    public Map a()
    {
        return d;
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(Map map)
    {
        d = map;
    }

    public String b()
    {
        return e;
    }

    public long c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public String e()
    {
        return f;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (p)obj;
            if (b != ((p) (obj)).b)
            {
                return false;
            }
            if (c != null || ((p) (obj)).c != null)
            {
                if (c != null && ((p) (obj)).c != null)
                {
                    return c.equals(((p) (obj)).c);
                } else
                {
                    return false;
                }
            }
        }
        return true;
    }

    public ContentValues f()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("placement_id", Long.valueOf(b));
        contentvalues.put("last_accessed_ts", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("tp_key", c);
        return contentvalues;
    }

    public int hashCode()
    {
        int j = (int)(b ^ b >>> 32);
        int i = j;
        if (c != null)
        {
            i = j * 31 + c.hashCode();
        }
        return i;
    }

}
