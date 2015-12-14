// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.net.Uri;
import android.os.Handler;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinPostbackListener;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinAdServiceImpl, g, f, AppLovinAdImpl

class e
    implements AppLovinPostbackListener
{

    final AdViewControllerImpl a;
    final Uri b;
    final AppLovinAdImpl c;
    final AppLovinAdView d;
    final AppLovinAdServiceImpl e;

    e(AppLovinAdServiceImpl applovinadserviceimpl, AdViewControllerImpl adviewcontrollerimpl, Uri uri, AppLovinAdImpl applovinadimpl, AppLovinAdView applovinadview)
    {
        e = applovinadserviceimpl;
        a = adviewcontrollerimpl;
        b = uri;
        c = applovinadimpl;
        d = applovinadview;
        super();
    }

    public void onPostbackFailure(String s, int i)
    {
        AppLovinAdServiceImpl.a(e).post(new g(this));
    }

    public void onPostbackSuccess(String s)
    {
        AppLovinAdServiceImpl.a(e).post(new f(this));
    }
}
