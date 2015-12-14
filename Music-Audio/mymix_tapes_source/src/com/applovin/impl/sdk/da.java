// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            p, cz, AppLovinAdImpl

class da
    implements p
{

    final cz a;

    da(cz cz1)
    {
        a = cz1;
        super();
    }

    public void a(int i)
    {
        a.g.d("TaskReportReward", (new StringBuilder()).append("Failed to report reward for ad: ").append(cz.a(a).getAdIdNumber()).append(" - error code: ").append(i).toString());
    }

    public void a(JSONObject jsonobject, int i)
    {
        a.g.d("TaskReportReward", (new StringBuilder()).append("Reported reward successfully for ad: ").append(cz.a(a).getAdIdNumber()).toString());
    }
}
