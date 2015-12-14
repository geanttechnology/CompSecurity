// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import com.cyberlink.youcammakeup.database.more.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends a
{

    private long a;
    private long b;
    private MKCategoryV2Status.CategoryMode c;
    private boolean d;
    private List e;
    private Map f;
    private long g;

    public b(JSONObject jsonobject)
    {
        a = Long.parseLong(jsonobject.getString("categoryId"));
        b = Long.parseLong(jsonobject.getString("maxMkId"));
        Object obj = jsonobject.getString("mode");
        if (((String) (obj)).equals("New"))
        {
            c = com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status.CategoryMode.a;
        } else
        if (((String) (obj)).equals("Top"))
        {
            c = MKCategoryV2Status.CategoryMode.b;
        } else
        {
            c = MKCategoryV2Status.CategoryMode.c;
        }
        d = jsonobject.getBoolean("showNew");
        g = Long.parseLong(jsonobject.getString("lastModified"));
        jsonobject = jsonobject.getJSONArray("subCategoryList");
        if (jsonobject != null && jsonobject.length() > 0)
        {
            e = new ArrayList(jsonobject.length());
            f = new HashMap(jsonobject.length());
            for (int i = 0; i < jsonobject.length(); i++)
            {
                obj = new b(jsonobject.getJSONObject(i));
                e.add(obj);
                f.put(Long.valueOf(((b) (obj)).a()), obj);
            }

        }
    }

    public long a()
    {
        return a;
    }

    public boolean b()
    {
        return d;
    }

    public long c()
    {
        return g;
    }

    public long d()
    {
        return b;
    }

    public MKCategoryV2Status.CategoryMode e()
    {
        return c;
    }

    public List f()
    {
        return e;
    }

    public Map g()
    {
        return f;
    }
}
