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

public class AdMobInMobiAdapter
    implements CustomEventBanner, NoProGuard
{

    private View inMobiView;
    private i viewProxy;

    public AdMobInMobiAdapter()
    {
        inMobiView = null;
    }

    public void destroy()
    {
        if (inMobiView != null && viewProxy != null)
        {
            inMobiView.setOnClickListener(null);
            inMobiView = null;
            viewProxy.b();
            viewProxy = null;
        }
    }

    public void requestBannerAd(CustomEventBannerListener customeventbannerlistener, Activity activity, String s, String s1, AdSize adsize, MediationAdRequest mediationadrequest, Object obj)
    {
        try
        {
            if (inMobiView == null)
            {
                viewProxy = m.a(activity, AdProviders.INMOBI, s1);
                inMobiView = viewProxy.a();
            }
            if (inMobiView != null)
            {
                customeventbannerlistener.onReceivedAd(inMobiView);
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
