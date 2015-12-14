// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;

// Referenced classes of package com.applovin.impl.sdk:
//            PostbackServiceImpl, AppLovinSdkImpl

class bp
    implements AppLovinPostbackListener
{

    final AppLovinPostbackListener a;
    final PostbackServiceImpl b;

    bp(PostbackServiceImpl postbackserviceimpl, AppLovinPostbackListener applovinpostbacklistener)
    {
        b = postbackserviceimpl;
        a = applovinpostbacklistener;
        super();
    }

    public void onPostbackFailure(String s, int i)
    {
        PostbackServiceImpl.a(b).getLogger().e("PostbackService", (new StringBuilder()).append("Failed to dispatch postback to URL ").append(s).append(": ").append(i).toString());
        if (a != null)
        {
            a.onPostbackFailure(s, i);
        }
    }

    public void onPostbackSuccess(String s)
    {
        PostbackServiceImpl.a(b).getLogger().d("PostbackService", (new StringBuilder()).append("Successfully dispatched postback to URL ").append(s).toString());
        if (a != null)
        {
            a.onPostbackSuccess(s);
        }
    }
}
