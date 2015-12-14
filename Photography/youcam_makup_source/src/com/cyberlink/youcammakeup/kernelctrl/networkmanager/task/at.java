// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            as

public class at
{

    private static String a = "MakeupItemCategory";
    private long b;
    private long c;
    private String d;
    private List e;
    private List f;

    public at()
    {
        b = -1L;
        c = -1L;
        d = "";
        e = new ArrayList();
        f = new ArrayList();
    }

    public at(JSONObject jsonobject)
    {
        boolean flag = false;
        super();
        b = Long.parseLong(jsonobject.getString("categoryId"));
        c = Long.parseLong(jsonobject.getString("lastModified"));
        d = jsonobject.getString("internalName");
        if (jsonobject.has("makeupItems"))
        {
            JSONArray jsonarray1 = jsonobject.getJSONArray("makeupItems");
            int k = jsonarray1.length();
            e = new ArrayList(k);
            int i = 0;
            while (i < k) 
            {
                as as1;
                try
                {
                    as1 = new as(jsonarray1.getJSONObject(i));
                }
                catch (Exception exception)
                {
                    exception = null;
                }
                e.add(as1);
                i++;
            }
        }
        if (jsonobject.has("subCategoryList"))
        {
            JSONArray jsonarray = jsonobject.getJSONArray("subCategoryList");
            int l = jsonarray.length();
            f = new ArrayList(l);
            int j = ((flag) ? 1 : 0);
            while (j < l) 
            {
                try
                {
                    jsonobject = new at(jsonarray.getJSONObject(j));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    jsonobject = null;
                }
                f.add(jsonobject);
                j++;
            }
        }
    }

    public long a()
    {
        return b;
    }

    public void a(List list)
    {
        f = list;
    }

    public long b()
    {
        return c;
    }

    public List c()
    {
        return e;
    }

    public List d()
    {
        return f;
    }

}
