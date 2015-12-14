// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.Timer;

// Referenced classes of package com.applovin.impl.sdk:
//            z, ar, AppLovinSdkImpl

class aq
{

    private final AppLovinSdkImpl a;
    private final z b;
    private Activity c;
    private AppLovinAdDisplayListener d;
    private AppLovinAdVideoPlaybackListener e;
    private AppLovinAdClickListener f;
    private AppLovinAdRewardListener g;
    private final Timer h = new Timer("IncentivizedAdLauncher");

    aq(AppLovinSdkImpl applovinsdkimpl, z z1)
    {
        a = applovinsdkimpl;
        b = z1;
    }

    static Activity a(aq aq1)
    {
        return aq1.c;
    }

    static AppLovinSdkImpl b(aq aq1)
    {
        return aq1.a;
    }

    private void b()
    {
        b.b(c, g, e, d, f);
    }

    static void c(aq aq1)
    {
        aq1.b();
    }

    static Timer d(aq aq1)
    {
        return aq1.h;
    }

    static AppLovinAdRewardListener e(aq aq1)
    {
        return aq1.g;
    }

    static z f(aq aq1)
    {
        return aq1.b;
    }

    void a()
    {
        c.runOnUiThread(new ar(this));
    }

    public void a(Activity activity)
    {
        c = activity;
    }

    public void a(AppLovinAdClickListener applovinadclicklistener)
    {
        f = applovinadclicklistener;
    }

    public void a(AppLovinAdDisplayListener applovinaddisplaylistener)
    {
        d = applovinaddisplaylistener;
    }

    public void a(AppLovinAdRewardListener applovinadrewardlistener)
    {
        g = applovinadrewardlistener;
    }

    public void a(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener)
    {
        e = applovinadvideoplaybacklistener;
    }
}
