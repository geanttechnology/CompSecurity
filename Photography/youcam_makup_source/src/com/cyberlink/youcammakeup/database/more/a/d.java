// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.a;

import android.content.ContentValues;
import com.cyberlink.youcammakeup.pages.moreview.k;
import java.net.URI;
import org.json.JSONObject;

public class d
{

    private final long a;
    private final String b;
    private final k c;
    private final k d;
    private URI e;
    private final JSONObject f;
    private final String g;

    public d(JSONObject jsonobject)
    {
        f = jsonobject;
        a = jsonobject.getLong("categoryId");
        b = jsonobject.getString("name");
        g = jsonobject.getString("longName");
        e = URI.create(jsonobject.getString("coverImgURL"));
        int i = jsonobject.getInt("x");
        int j = jsonobject.getInt("y");
        int l = jsonobject.getInt("w");
        int i1 = jsonobject.getInt("h");
        c = new k(i, j, l, i1);
        i = jsonobject.getInt("textX");
        j = jsonobject.getInt("textY");
        l = jsonobject.getInt("textW");
        i1 = jsonobject.getInt("textH");
        d = new k(i, j, l, i1);
    }

    public long a()
    {
        return a;
    }

    public ContentValues a(long l)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("BCid", Long.valueOf(l));
        contentvalues.put("JsonString", f.toString());
        contentvalues.put("Ext_1", "");
        contentvalues.put("Ext_2", "");
        return contentvalues;
    }

    public String b()
    {
        return b;
    }

    public k c()
    {
        return c;
    }

    public URI d()
    {
        return e;
    }

    public k e()
    {
        return d;
    }

    public String f()
    {
        return g;
    }
}
