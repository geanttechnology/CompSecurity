// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            ck, AppLovinSdkImpl, cr, cq, 
//            bp

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
        dispatchPostbackAsync(s, null, applovinpostbacklistener);
    }

    public void dispatchPostbackAsync(String s, Map map, int i, int j, int k, AppLovinPostbackListener applovinpostbacklistener)
    {
        if (AppLovinSdkUtils.isValidString(s))
        {
            s = new ck(a, s, map, applovinpostbacklistener);
            s.b(j);
            s.a(i);
            s.c(k);
            a.a().a(s, cr.c);
        } else
        {
            a.getLogger().e("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
            if (applovinpostbacklistener != null)
            {
                applovinpostbacklistener.onPostbackFailure(s, -900);
                return;
            }
        }
    }

    public void dispatchPostbackAsync(String s, Map map, AppLovinPostbackListener applovinpostbacklistener)
    {
        if (!AppLovinSdkUtils.isValidString(s))
        {
            a.getLogger().d("PostbackService", "Ignoring enqueued postback request to invalid URL");
            return;
        } else
        {
            s = new ck(a, s, map, new bp(this, applovinpostbacklistener));
            a.a().a(s, cr.c);
            return;
        }
    }
}
