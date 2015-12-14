// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventInterstitialListener, CustomEventAdapter

final class b
    implements CustomEventInterstitialListener
{

    private final CustomEventAdapter zzbb;
    private final MediationInterstitialListener zzbd;
    final CustomEventAdapter zzbe;

    public b(CustomEventAdapter customeventadapter, CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
    {
        zzbe = customeventadapter;
        super();
        zzbb = customeventadapter1;
        zzbd = mediationinterstitiallistener;
    }

    public final void onDismissScreen()
    {
        zzb.zzaF("Custom event adapter called onDismissScreen.");
        zzbd.onDismissScreen(zzbb);
    }

    public final void onFailedToReceiveAd()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbd.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication()
    {
        zzb.zzaF("Custom event adapter called onLeaveApplication.");
        zzbd.onLeaveApplication(zzbb);
    }

    public final void onPresentScreen()
    {
        zzb.zzaF("Custom event adapter called onPresentScreen.");
        zzbd.onPresentScreen(zzbb);
    }

    public final void onReceivedAd()
    {
        zzb.zzaF("Custom event adapter called onReceivedAd.");
        zzbd.onReceivedAd(zzbe);
    }
}
