// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            cj, EventServiceImpl, AppLovinSdkImpl, bs, 
//            bm, s

class v
    implements cj
{

    final bs a;
    final EventServiceImpl b;

    v(EventServiceImpl eventserviceimpl, bs bs1)
    {
        b = eventserviceimpl;
        a = bs1;
        super();
    }

    public void a(s s)
    {
        try
        {
            s = EventServiceImpl.a(b, a, s);
            EventServiceImpl.a(b).getPersistentPostbackManager().a(s.toString(), a.b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (s s)
        {
            EventServiceImpl.a(b).getLogger().e("EventServiceImpl", (new StringBuilder()).append("Unable to track event due to failure to convert event parameters into JSONObject for event: ").append(a).toString(), s);
        }
    }
}
