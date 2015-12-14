// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import android.content.ContentValues;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.i:
//            e

public class d
{

    private long a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;
    private long i;
    private URI j;
    private URI k;
    private URI l;
    private long m;
    private List n;
    private JSONObject o;
    private String p;
    private String q;
    private String r;

    public d(JSONObject jsonobject)
    {
        o = jsonobject;
        a = Long.parseLong(jsonobject.getString("skuId"));
        b = jsonobject.getString("type");
        c = jsonobject.getBoolean("default");
        d = jsonobject.getString("skuName");
        e = jsonobject.getString("skuGUID");
        f = jsonobject.getString("vendor");
        g = jsonobject.optString("vendorGUID", "");
        h = Long.parseLong(jsonobject.getString("startDate"));
        i = Long.parseLong(jsonobject.getString("endDate"));
        int j1;
        try
        {
            j = b(jsonobject.getString("content_zip"));
        }
        catch (Exception exception)
        {
            j = URI.create("");
        }
        try
        {
            k = b(jsonobject.getString("sku_images_room_zip"));
        }
        catch (Exception exception1)
        {
            k = URI.create("");
        }
        try
        {
            l = b(jsonobject.getString("sku_images_dfp_zip"));
        }
        catch (Exception exception2)
        {
            l = URI.create("");
        }
        try
        {
            p = jsonobject.getString("content_zip_md5");
        }
        catch (Exception exception3)
        {
            p = "";
        }
        try
        {
            q = jsonobject.getString("sku_images_room_zip_md5");
        }
        catch (Exception exception4)
        {
            q = "";
        }
        try
        {
            r = jsonobject.getString("sku_images_dfp_zip_md5");
        }
        catch (Exception exception5)
        {
            r = "";
        }
        m = Long.parseLong(jsonobject.getString("lastModified"));
        jsonobject = jsonobject.getJSONArray("items");
        j1 = jsonobject.length();
        n = new ArrayList(j1);
        for (int i1 = 0; i1 < j1; i1++)
        {
            e e1 = new e(this, jsonobject.getJSONObject(i1));
            n.add(e1);
        }

    }

    private URI b(String s)
    {
        try
        {
            s = URI.create(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public long a()
    {
        return a;
    }

    public String a(String s)
    {
        if (o != null)
        {
            return o.optString(s, "");
        } else
        {
            return "";
        }
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return d;
    }

    public String d()
    {
        return e;
    }

    public String e()
    {
        return f;
    }

    public long f()
    {
        return h;
    }

    public long g()
    {
        return i;
    }

    public URI h()
    {
        return j;
    }

    public URI i()
    {
        return k;
    }

    public URI j()
    {
        return l;
    }

    public long k()
    {
        return m;
    }

    public List l()
    {
        return n;
    }

    public String m()
    {
        return g;
    }

    public String n()
    {
        return p;
    }

    public String o()
    {
        return q;
    }

    public String p()
    {
        return r;
    }

    public ContentValues q()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Skuid", Long.valueOf(a));
        contentvalues.put("SkuType", b);
        contentvalues.put("SkuStartDate", Long.valueOf(h));
        contentvalues.put("SkuEndDate", Long.valueOf(i));
        contentvalues.put("JsonString", o.toString());
        contentvalues.put("Ext_1", "");
        contentvalues.put("Ext_2", "");
        return contentvalues;
    }
}
