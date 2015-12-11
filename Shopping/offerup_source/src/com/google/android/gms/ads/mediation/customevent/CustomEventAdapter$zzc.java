// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventNativeListener, CustomEventAdapter

class zzaS
    implements CustomEventNativeListener
{

    private final CustomEventAdapter zzKO;
    private final MediationNativeListener zzaS;

    public void onAdClicked()
    {
        zzb.zzaF("Custom event adapter called onAdClicked.");
        zzaS.onAdClicked(zzKO);
    }

    public void onAdClosed()
    {
        zzb.zzaF("Custom event adapter called onAdClosed.");
        zzaS.onAdClosed(zzKO);
    }

    public void onAdFailedToLoad(int i)
    {
        zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
        zzaS.onAdFailedToLoad(zzKO, i);
    }

    public void onAdLeftApplication()
    {
        zzb.zzaF("Custom event adapter called onAdLeftApplication.");
        zzaS.onAdLeftApplication(zzKO);
    }

    public void onAdLoaded(NativeAdMapper nativeadmapper)
    {
        zzb.zzaF("Custom event adapter called onAdLoaded.");
        zzaS.onAdLoaded(zzKO, nativeadmapper);
    }

    public void onAdOpened()
    {
        zzb.zzaF("Custom event adapter called onAdOpened.");
        zzaS.onAdOpened(zzKO);
    }

    public er(CustomEventAdapter customeventadapter, MediationNativeListener mediationnativelistener)
    {
        zzKO = customeventadapter;
        zzaS = mediationnativelistener;
    }
}
