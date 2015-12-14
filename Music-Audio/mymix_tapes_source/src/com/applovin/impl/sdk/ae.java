// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import android.os.Handler;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            z, ah, ag, cz, 
//            AppLovinSdkImpl, cr, cq, de, 
//            bl, af, al, am, 
//            ak, an, ai, aj, 
//            aa

class ae
    implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener
{

    final z a;
    private final Activity b;
    private final AppLovinAdDisplayListener c;
    private final AppLovinAdClickListener d;
    private final AppLovinAdVideoPlaybackListener e;
    private final AppLovinAdRewardListener f;

    private ae(z z1, Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener, AppLovinAdClickListener applovinadclicklistener)
    {
        a = z1;
        super();
        c = applovinaddisplaylistener;
        d = applovinadclicklistener;
        e = applovinadvideoplaybacklistener;
        f = applovinadrewardlistener;
        b = activity;
    }

    ae(z z1, Activity activity, AppLovinAdRewardListener applovinadrewardlistener, AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener, AppLovinAdDisplayListener applovinaddisplaylistener, AppLovinAdClickListener applovinadclicklistener, aa aa)
    {
        this(z1, activity, applovinadrewardlistener, applovinadvideoplaybacklistener, applovinaddisplaylistener, applovinadclicklistener);
    }

    static AppLovinAdRewardListener a(ae ae1)
    {
        return ae1.f;
    }

    static AppLovinAdDisplayListener b(ae ae1)
    {
        return ae1.c;
    }

    static AppLovinAdClickListener c(ae ae1)
    {
        return ae1.d;
    }

    static AppLovinAdVideoPlaybackListener d(ae ae1)
    {
        return ae1.e;
    }

    public void adClicked(AppLovinAd applovinad)
    {
        if (d != null)
        {
            z.c(a).post(new ah(this, applovinad));
        }
    }

    public void adDisplayed(AppLovinAd applovinad)
    {
        if (c != null)
        {
            c.adDisplayed(applovinad);
        }
    }

    public void adHidden(AppLovinAd applovinad)
    {
        String s1 = a.c();
        if (s1 != null && z.a(a))
        {
            a.a(s1, b);
        } else
        {
            z.b(a).a(true);
            String s;
            char c1;
            if (z.a(a))
            {
                s = "network_timeout";
                c1 = '\uFE0C';
            } else
            {
                s = "user_closed_video";
                c1 = '\uFDA8';
            }
            bl.a().a(applovinad, s);
            if (z.a(a))
            {
                a.a(s1, b);
            }
            z.c(a).post(new af(this, applovinad, c1));
        }
        if (c != null)
        {
            z.c(a).post(new ag(this, applovinad));
        }
        applovinad = new cz(z.d(a), applovinad);
        z.d(a).a().a(applovinad, cr.b);
        z.a(a, null);
    }

    public void userDeclinedToViewAd(AppLovinAd applovinad)
    {
    }

    public void userOverQuota(AppLovinAd applovinad, Map map)
    {
        a.b("quota_exceeded");
        if (f != null)
        {
            z.c(a).post(new al(this, applovinad, map));
        }
    }

    public void userRewardRejected(AppLovinAd applovinad, Map map)
    {
        a.b("rejected");
        if (f != null)
        {
            z.c(a).post(new am(this, applovinad, map));
        }
    }

    public void userRewardVerified(AppLovinAd applovinad, Map map)
    {
        a.b("accepted");
        if (f != null)
        {
            z.c(a).post(new ak(this, applovinad, map));
        }
    }

    public void validationRequestFailed(AppLovinAd applovinad, int i)
    {
        a.b("network_timeout");
        if (f != null)
        {
            z.c(a).post(new an(this, applovinad, i));
        }
    }

    public void videoPlaybackBegan(AppLovinAd applovinad)
    {
        if (e != null)
        {
            z.c(a).post(new ai(this, applovinad));
        }
    }

    public void videoPlaybackEnded(AppLovinAd applovinad, double d1, boolean flag)
    {
        if (e != null)
        {
            z.c(a).post(new aj(this, applovinad, d1, flag));
        }
        z.a(a, flag);
    }
}
