// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.makeup:
//            c, b

public class MKCategoryV2Status
{

    private long a;
    private List b;
    private List c;
    private JSONObject d;
    private Map e;

    public MKCategoryV2Status(JSONObject jsonobject)
    {
        boolean flag = false;
        super();
        d = jsonobject;
        a = Long.parseLong(jsonobject.getString("lastModified"));
        Object obj = jsonobject.getJSONArray("categoryList");
        if (obj != null && ((JSONArray) (obj)).length() > 0)
        {
            b = new ArrayList(((JSONArray) (obj)).length());
            int i = 0;
            while (i < ((JSONArray) (obj)).length()) 
            {
                Exception exception;
                try
                {
                    c c1 = new c(((JSONArray) (obj)).getJSONObject(i));
                    b.add(c1);
                }
                catch (Exception exception1) { }
                i++;
            }
        }
        jsonobject = jsonobject.getJSONArray("category");
        if (jsonobject != null && jsonobject.length() > 0)
        {
            c = new ArrayList(jsonobject.length());
            e = new HashMap(jsonobject.length());
            i = ((flag) ? 1 : 0);
            while (i < jsonobject.length()) 
            {
                try
                {
                    obj = new b(jsonobject.getJSONObject(i));
                    c.add(obj);
                    e.put(Long.valueOf(((b) (obj)).a()), obj);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
                i++;
            }
        }
    }

    public long a()
    {
        return a;
    }

    public List b()
    {
        return c;
    }

    public Map c()
    {
        return e;
    }

    public JSONObject d()
    {
        return d;
    }
}
