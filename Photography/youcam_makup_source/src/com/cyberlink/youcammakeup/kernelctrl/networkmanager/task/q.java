// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, r

public class q extends b
{

    private List d;
    private Map e;

    public q(HttpEntity httpentity)
    {
        int i;
        i = 0;
        super(httpentity);
        if (c == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a) goto _L2; else goto _L1
_L1:
        d = new ArrayList(0);
        e = new HashMap();
_L4:
        return;
_L2:
        JSONArray jsonarray = b.optJSONArray("items");
        if (jsonarray != null)
        {
            d = new ArrayList(jsonarray.length());
            e = new HashMap();
            while (i < jsonarray.length()) 
            {
                httpentity = jsonarray.optJSONObject(i);
                if (httpentity != null)
                {
                    r r1 = new r(this);
                    r1.a = httpentity.optString("name");
                    httpentity = httpentity.optString("url");
                    if (httpentity != null)
                    {
                        httpentity = URI.create(httpentity);
                    } else
                    {
                        httpentity = null;
                    }
                    r1.b = httpentity;
                    d.add(r1);
                    e.put(r1.a, r1);
                }
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List a()
    {
        return d;
    }

    public Map b()
    {
        return e;
    }
}
