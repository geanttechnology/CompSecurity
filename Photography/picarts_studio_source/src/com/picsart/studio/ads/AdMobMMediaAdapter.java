// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEventBanner;
import com.google.ads.mediation.customevent.CustomEventBannerListener;
import com.socialin.android.NoProGuard;
import com.socialin.android.ads.AdProviders;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.ads:
//            i

public class AdMobMMediaAdapter
    implements CustomEventBanner, NoProGuard
{

    private View banner;
    private i viewProxy;

    public AdMobMMediaAdapter()
    {
        banner = null;
    }

    public void destroy()
    {
        if (banner != null && viewProxy != null)
        {
            banner.setOnClickListener(null);
            banner = null;
            viewProxy.b();
            viewProxy = null;
        }
    }

    public void requestBannerAd(CustomEventBannerListener customeventbannerlistener, Activity activity, String s, String s1, AdSize adsize, MediationAdRequest mediationadrequest, Object obj)
    {
        try
        {
            if (banner == null)
            {
                viewProxy = m.a(activity, AdProviders.MMEDIA3, s1);
                banner = viewProxy.a();
            }
            if (banner != null)
            {
                customeventbannerlistener.onReceivedAd(banner);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            customeventbannerlistener.onFailedToReceiveAd();
        }
    }
}
