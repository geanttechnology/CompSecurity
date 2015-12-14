// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventBannerListener, CustomEventAdapter

final class a
    implements CustomEventBannerListener
{

    private final CustomEventAdapter zzbb;
    private final MediationBannerListener zzbc;

    public a(CustomEventAdapter customeventadapter, MediationBannerListener mediationbannerlistener)
    {
        zzbb = customeventadapter;
        zzbc = mediationbannerlistener;
    }

    public final void onClick()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbc.onClick(zzbb);
    }

    public final void onDismissScreen()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbc.onDismissScreen(zzbb);
    }

    public final void onFailedToReceiveAd()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbc.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbc.onLeaveApplication(zzbb);
    }

    public final void onPresentScreen()
    {
        zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
        zzbc.onPresentScreen(zzbb);
    }

    public final void onReceivedAd(View view)
    {
        zzb.zzaF("Custom event adapter called onReceivedAd.");
        CustomEventAdapter.zza(zzbb, view);
        zzbc.onReceivedAd(zzbb);
    }
}
