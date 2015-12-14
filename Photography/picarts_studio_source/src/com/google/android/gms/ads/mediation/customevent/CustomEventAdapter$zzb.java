// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventInterstitialListener, CustomEventAdapter

class zzaR
    implements CustomEventInterstitialListener
{

    private final CustomEventAdapter zzKO;
    final CustomEventAdapter zzKP;
    private final MediationInterstitialListener zzaR;

    public void onAdClicked()
    {
        zzb.zzaF("Custom event adapter called onAdClicked.");
        zzaR.onAdClicked(zzKO);
    }

    public void onAdClosed()
    {
        zzb.zzaF("Custom event adapter called onAdClosed.");
        zzaR.onAdClosed(zzKO);
    }

    public void onAdFailedToLoad(int i)
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzaR.onAdFailedToLoad(zzKO, i);
    }

    public void onAdLeftApplication()
    {
        zzb.zzaF("Custom event adapter called onAdLeftApplication.");
        zzaR.onAdLeftApplication(zzKO);
    }

    public void onAdLoaded()
    {
        zzb.zzaF("Custom event adapter called onReceivedAd.");
        zzaR.onAdLoaded(zzKP);
    }

    public void onAdOpened()
    {
        zzb.zzaF("Custom event adapter called onAdOpened.");
        zzaR.onAdOpened(zzKO);
    }

    public Listener(CustomEventAdapter customeventadapter, CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
    {
        zzKP = customeventadapter;
        super();
        zzKO = customeventadapter1;
        zzaR = mediationinterstitiallistener;
    }
}
