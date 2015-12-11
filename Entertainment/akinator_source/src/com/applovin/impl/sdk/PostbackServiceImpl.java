// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, cd, bl, ck, 
//            cj

public class PostbackServiceImpl
    implements AppLovinPostbackService
{

    private final AppLovinSdkImpl a;

    PostbackServiceImpl(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
    }

    static AppLovinSdkImpl a(PostbackServiceImpl postbackserviceimpl)
    {
        return postbackserviceimpl.a;
    }

    public void dispatchPostbackAsync(String s, AppLovinPostbackListener applovinpostbacklistener)
    {
        if (!AppLovinSdkUtils.isValidString(s))
        {
            a.getLogger().d("PostbackService", "Ignoring enqueued postback request to invalid URL");
            return;
        } else
        {
            s = new cd(a, s, new bl(this, applovinpostbacklistener));
            a.a().a(s, ck.c);
            return;
        }
    }
}
