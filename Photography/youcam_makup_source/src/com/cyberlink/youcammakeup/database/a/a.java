// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.a;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.a:
//            b, c

public class a
{

    private static String a = "AdUnitContent";
    private b b;
    private List c;

    public a(JSONObject jsonobject)
    {
        b = new b(this, jsonobject.getJSONObject("adUnit"));
        c = new LinkedList();
        jsonobject = jsonobject.getJSONArray("adUnitItems");
        int i = 0;
        while (i < jsonobject.length()) 
        {
            try
            {
                c c1 = new c(this, jsonobject.getJSONObject(i));
                c.add(c1);
            }
            catch (JSONException jsonexception) { }
            i++;
        }
    }

    public b a()
    {
        return b;
    }

    public List b()
    {
        return c;
    }

    public boolean c()
    {
        if (c.size() > 0)
        {
            String s = ((c)c.get(0)).c();
            if (s != null && s.length() > 0)
            {
                return true;
            }
        }
        return false;
    }

    public String d()
    {
        return ((c)c.get(0)).c();
    }

}
