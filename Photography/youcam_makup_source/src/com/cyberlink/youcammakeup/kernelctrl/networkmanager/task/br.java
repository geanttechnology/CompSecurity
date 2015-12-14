// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class br extends b
{

    public static final String d = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/br.getName();
    private String e;
    private long f;
    private long g;
    private long h;

    public br(HttpEntity httpentity)
    {
        super(httpentity);
        g = -1L;
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            return;
        } else
        {
            httpentity = b.getJSONObject("templateStatus").getJSONArray("contentStatus").getJSONObject(0);
            e = httpentity.optString("type");
            f = httpentity.optLong("maxTid");
            e = httpentity.optString("subtype");
            g = httpentity.getLong("lastModified");
            h = httpentity.getLong("rankingLastModified");
            return;
        }
    }

    public long a()
    {
        return g;
    }

}
