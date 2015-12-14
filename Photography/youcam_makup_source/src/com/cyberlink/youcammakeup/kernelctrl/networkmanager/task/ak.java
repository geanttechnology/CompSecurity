// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import com.cyberlink.youcammakeup.database.more.i.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class ak extends b
{

    private List d;
    private Map e;

    public ak()
    {
        d = new ArrayList();
        e = new HashMap();
    }

    public ak(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = null;
            e = null;
        } else
        {
            e = new HashMap();
            httpentity = b.getJSONArray("skus");
            int j = httpentity.length();
            d = new ArrayList(j);
            int i = 0;
            while (i < j) 
            {
                try
                {
                    d d1 = new d(httpentity.getJSONObject(i));
                    d.add(d1);
                }
                catch (Exception exception) { }
                i++;
            }
        }
    }

    public Collection a()
    {
        return d;
    }

    public void a(long l, d d1)
    {
        e.put(Long.valueOf(l), d1);
    }

    public void a(List list)
    {
        d = list;
    }

    public Map b()
    {
        return e;
    }
}
