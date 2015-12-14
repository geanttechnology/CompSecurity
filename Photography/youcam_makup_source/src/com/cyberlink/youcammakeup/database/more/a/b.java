// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.a;

import android.content.ContentValues;
import java.net.URI;
import org.json.JSONObject;

public class b
{

    private final long a;
    private final String b;
    private final String c;
    private final int d;
    private final URI e;
    private final URI f = null;
    private final URI g = null;
    private final URI h;
    private final String i;
    private final String j;
    private final String k;
    private final JSONObject l;

    public b(JSONObject jsonobject)
    {
        l = jsonobject;
        a = jsonobject.getLong("filmId");
        b = jsonobject.getString("name");
        c = jsonobject.getString("description");
        d = jsonobject.getInt("duration");
        e = URI.create(jsonobject.getString("pageURL"));
        jsonobject.getString("streamSDURL");
        jsonobject.getString("streamHDURL");
        h = URI.create(jsonobject.getString("thumbnailURL"));
        i = jsonobject.getString("uploader");
        j = jsonobject.getString("createDate");
        k = jsonobject.getString("source");
    }

    public long a()
    {
        return a;
    }

    public ContentValues a(long l1, long l2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Cid", Long.valueOf(l2));
        contentvalues.put("Findex", Long.valueOf(l1));
        contentvalues.put("JsonString", l.toString());
        contentvalues.put("Ext_1", "");
        contentvalues.put("Ext_2", "");
        return contentvalues;
    }

    public String b()
    {
        return k;
    }

    public String c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public URI e()
    {
        return e;
    }

    public URI f()
    {
        return h;
    }

    public String g()
    {
        return i;
    }
}
