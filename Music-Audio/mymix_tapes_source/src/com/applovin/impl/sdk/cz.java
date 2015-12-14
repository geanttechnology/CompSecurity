// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bt, AppLovinAdImpl, z, bl, 
//            da, AppLovinSdkImpl

class cz extends bt
{

    private final AppLovinAdImpl a;

    public cz(AppLovinSdkImpl applovinsdkimpl, AppLovinAd applovinad)
    {
        super("TaskReportReward", applovinsdkimpl);
        a = (AppLovinAdImpl)applovinad;
    }

    static AppLovinAdImpl a(cz cz1)
    {
        return cz1.a;
    }

    public void run()
    {
        Object obj = z.b();
        String s = a.getClCode();
        HashMap hashmap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(s))
        {
            hashmap.put("clcode", s);
        } else
        {
            hashmap.put("clcode", "NO_CLCODE");
        }
        if (obj != null)
        {
            hashmap.put("user_id", obj);
        }
        obj = bl.a();
        s = ((bl) (obj)).b(a);
        if (s != null)
        {
            hashmap.put("result", s);
            obj = ((bl) (obj)).a(a);
            if (obj != null)
            {
                hashmap.put("params", obj);
            }
            a("cr", new JSONObject(hashmap), new da(this));
            return;
        } else
        {
            g.d("TaskReportReward", (new StringBuilder()).append("No reward result was found for ad: ").append(a).toString());
            return;
        }
    }
}
