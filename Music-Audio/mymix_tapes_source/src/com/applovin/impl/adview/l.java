// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class l
    implements AppLovinAdLoadListener, AppLovinAdUpdateListener
{

    private final WeakReference a;
    private final AppLovinAdService b;
    private final AppLovinLogger c;

    l(AdViewControllerImpl adviewcontrollerimpl, AppLovinSdk applovinsdk)
    {
        if (adviewcontrollerimpl == null)
        {
            throw new IllegalArgumentException("No view specified");
        }
        if (applovinsdk == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            a = new WeakReference(adviewcontrollerimpl);
            c = applovinsdk.getLogger();
            b = applovinsdk.getAdService();
            return;
        }
    }

    public void adReceived(AppLovinAd applovinad)
    {
        AdViewControllerImpl adviewcontrollerimpl = (AdViewControllerImpl)a.get();
        if (adviewcontrollerimpl != null)
        {
            adviewcontrollerimpl.a(applovinad);
            return;
        } else
        {
            c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was recieved");
            return;
        }
    }

    public void adUpdated(AppLovinAd applovinad)
    {
        AdViewControllerImpl adviewcontrollerimpl = (AdViewControllerImpl)a.get();
        if (adviewcontrollerimpl != null)
        {
            adviewcontrollerimpl.a(applovinad);
            return;
        } else
        {
            b.removeAdUpdateListener(this, applovinad.getSize());
            c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
            return;
        }
    }

    public void failedToReceiveAd(int i)
    {
        AdViewControllerImpl adviewcontrollerimpl = (AdViewControllerImpl)a.get();
        if (adviewcontrollerimpl != null)
        {
            adviewcontrollerimpl.a(i);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("[AdViewController listener: ").append(hashCode()).append("]").toString();
    }
}
