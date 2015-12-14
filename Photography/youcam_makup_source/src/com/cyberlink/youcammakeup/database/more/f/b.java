// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.f;

import android.content.ContentValues;
import org.json.JSONObject;

public class b
{

    private final long a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final JSONObject h;

    public b(JSONObject jsonobject)
    {
        h = jsonobject;
        a = jsonobject.getLong("nid");
        b = jsonobject.getString("shortdesc");
        c = jsonobject.getString("desc");
        d = jsonobject.getString("noticedate");
        e = jsonobject.getString("thumbnail");
        f = jsonobject.getString("actionname");
        g = jsonobject.getString("actionurl");
    }

    public long a()
    {
        return a;
    }

    protected ContentValues a(long l)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Nindex", Long.valueOf(l));
        contentvalues.put("JsonString", h.toString());
        return contentvalues;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return f;
    }

    public String f()
    {
        return g;
    }
}
