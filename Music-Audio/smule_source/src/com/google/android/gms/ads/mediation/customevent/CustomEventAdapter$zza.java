// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerListener;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventBannerListener, CustomEventAdapter

final class zzg
    implements CustomEventBannerListener
{

    private final CustomEventAdapter zzDK;
    private final MediationBannerListener zzg;

    public void onAdClicked()
    {
        zzb.zzaj("Custom event adapter called onAdClicked.");
        zzg.onAdClicked(zzDK);
    }

    public void onAdClosed()
    {
        zzb.zzaj("Custom event adapter called onAdClosed.");
        zzg.onAdClosed(zzDK);
    }

    public void onAdFailedToLoad(int i)
    {
        zzb.zzaj("Custom event adapter called onAdFailedToLoad.");
        zzg.onAdFailedToLoad(zzDK, i);
    }

    public void onAdLeftApplication()
    {
        zzb.zzaj("Custom event adapter called onAdLeftApplication.");
        zzg.onAdLeftApplication(zzDK);
    }

    public void onAdLoaded(View view)
    {
        zzb.zzaj("Custom event adapter called onAdLoaded.");
        CustomEventAdapter.zza(zzDK, view);
        zzg.onAdLoaded(zzDK);
    }

    public void onAdOpened()
    {
        zzb.zzaj("Custom event adapter called onAdOpened.");
        zzg.onAdOpened(zzDK);
    }

    public er(CustomEventAdapter customeventadapter, MediationBannerListener mediationbannerlistener)
    {
        zzDK = customeventadapter;
        zzg = mediationbannerlistener;
    }
}
