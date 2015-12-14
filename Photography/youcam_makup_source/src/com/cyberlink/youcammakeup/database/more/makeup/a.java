// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import android.content.ContentValues;
import com.cyberlink.youcammakeup.pages.moreview.j;
import com.cyberlink.youcammakeup.pages.moreview.k;
import java.net.URI;
import org.json.JSONObject;

public class a
{

    private String a;
    private long b;
    private String c;
    private String d;
    private URI e;
    private long f;
    private JSONObject g;
    private j h;
    private boolean i;

    public a(JSONObject jsonobject)
    {
        a = "CategoryMetadata";
        d = "";
        g = jsonobject;
        b = jsonobject.getLong("categoryId");
        c = jsonobject.getString("name");
        d = jsonobject.getString("internalName");
        i = false;
        String s = jsonobject.getString("coverImgURL");
        try
        {
            e = URI.create(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            e = null;
        }
        f = jsonobject.getLong("lastModified");
        h = new j(new k(jsonobject.optInt("x", -1), jsonobject.optInt("y", -1), jsonobject.optInt("w", -1), jsonobject.optInt("h", -1)), new k(jsonobject.optInt("textX", -1), jsonobject.optInt("textY", -1), jsonobject.optInt("textW", -1), jsonobject.optInt("textH", -1)), jsonobject.optString("name"), null);
    }

    public long a()
    {
        return b;
    }

    public void a(boolean flag)
    {
        i = flag;
    }

    public String b()
    {
        return c;
    }

    public URI c()
    {
        return e;
    }

    public long d()
    {
        return f;
    }

    public ContentValues e()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("JsonString", g.toString());
        return contentvalues;
    }

    public ContentValues f()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MCid", Long.valueOf(b));
        contentvalues.put("JsonString", g.toString());
        return contentvalues;
    }
}
