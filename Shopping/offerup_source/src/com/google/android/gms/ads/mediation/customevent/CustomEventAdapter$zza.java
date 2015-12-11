// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerListener;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventBannerListener, CustomEventAdapter

final class zzaQ
    implements CustomEventBannerListener
{

    private final CustomEventAdapter zzKO;
    private final MediationBannerListener zzaQ;

    public final void onAdClicked()
    {
        zzb.zzaF("Custom event adapter called onAdClicked.");
        zzaQ.onAdClicked(zzKO);
    }

    public final void onAdClosed()
    {
        zzb.zzaF("Custom event adapter called onAdClosed.");
        zzaQ.onAdClosed(zzKO);
    }

    public final void onAdFailedToLoad(int i)
    {
        zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
        zzaQ.onAdFailedToLoad(zzKO, i);
    }

    public final void onAdLeftApplication()
    {
        zzb.zzaF("Custom event adapter called onAdLeftApplication.");
        zzaQ.onAdLeftApplication(zzKO);
    }

    public final void onAdLoaded(View view)
    {
        zzb.zzaF("Custom event adapter called onAdLoaded.");
        CustomEventAdapter.zza(zzKO, view);
        zzaQ.onAdLoaded(zzKO);
    }

    public final void onAdOpened()
    {
        zzb.zzaF("Custom event adapter called onAdOpened.");
        zzaQ.onAdOpened(zzKO);
    }

    public er(CustomEventAdapter customeventadapter, MediationBannerListener mediationbannerlistener)
    {
        zzKO = customeventadapter;
        zzaQ = mediationbannerlistener;
    }
}
