// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.a;

import com.cyberlink.youcammakeup.utility.ad;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.a:
//            d, a

public class c
{

    final a a;
    private String b;
    private int c;
    private long d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private d k;
    private long l;

    public c(a a1, JSONObject jsonobject)
    {
        a = a1;
        super();
        b = jsonobject.optString("adUnitItemID");
        c = ad.b(jsonobject, "weight");
        d = ad.c(jsonobject, "endDate");
        e = jsonobject.optInt("order", 0);
        f = jsonobject.optString("DFPAdUnitID");
        g = jsonobject.optString("title");
        h = jsonobject.optString("description");
        i = jsonobject.optString("type");
        j = jsonobject.optString("adImageURL");
        try
        {
            k = new d(this, jsonobject.getJSONObject("weekStarPage"));
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            a1.printStackTrace();
        }
        l = jsonobject.optLong("lastModified", 0L);
    }

    public String a()
    {
        return b;
    }

    public long b()
    {
        return d;
    }

    public String c()
    {
        return f;
    }

    public String d()
    {
        return g;
    }

    public String e()
    {
        return h;
    }

    public String f()
    {
        return j;
    }

    public d g()
    {
        return k;
    }

    public long h()
    {
        return l;
    }

    public String i()
    {
        return i;
    }
}
