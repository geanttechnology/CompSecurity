// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b, ac

public class ab extends b
{

    private Map d;

    public ab(HttpEntity httpentity)
    {
        int i;
        i = 0;
        super(httpentity);
        if (c == com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a) goto _L2; else goto _L1
_L1:
        d = new HashMap(0);
_L4:
        return;
_L2:
        httpentity = b.optJSONArray("pages");
        if (httpentity != null)
        {
            d = new HashMap(httpentity.length());
            while (i < httpentity.length()) 
            {
                JSONObject jsonobject = httpentity.optJSONObject(i);
                if (jsonobject != null)
                {
                    ac ac1 = new ac(jsonobject.optString("id"), jsonobject.optString("pageURL"));
                    d.put(jsonobject.optString("id"), ac1);
                }
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ac a(String s)
    {
        if (!d.containsKey(s))
        {
            return ac.a;
        } else
        {
            return (ac)d.get(s);
        }
    }
}
