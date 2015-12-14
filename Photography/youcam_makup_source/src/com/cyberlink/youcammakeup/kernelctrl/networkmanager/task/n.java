// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.makeup.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class n extends b
{

    List d;
    private final String e;

    public n()
    {
        e = "GetCategoryResponse";
    }

    public n(HttpEntity httpentity, Map map, List list)
    {
        boolean flag = false;
        super(httpentity);
        e = "GetCategoryResponse";
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = null;
        } else
        {
            JSONArray jsonarray = b.getJSONArray("categoryList");
            int j = jsonarray.length();
            HashMap hashmap = new HashMap();
            int i = 0;
            while (i < j) 
            {
                try
                {
                    httpentity = new a(jsonarray.getJSONObject(i));
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    httpentity = null;
                }
                hashmap.put(Long.valueOf(httpentity.a()), httpentity);
                i++;
            }
            d = new ArrayList(list.size());
            i = ((flag) ? 1 : 0);
            while (i < list.size()) 
            {
                long l = ((Long)list.get(i)).longValue();
                if (map != null && map.containsKey(Long.valueOf(l)))
                {
                    httpentity = (a)map.get(Long.valueOf(l));
                } else
                if (hashmap.containsKey(Long.valueOf(l)))
                {
                    httpentity = (a)hashmap.get(Long.valueOf(l));
                } else
                {
                    httpentity = null;
                }
                d.add(httpentity);
                i++;
            }
        }
    }

    public List a()
    {
        return d;
    }
}
