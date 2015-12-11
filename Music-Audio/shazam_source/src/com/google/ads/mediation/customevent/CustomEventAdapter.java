// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventBanner, CustomEventInterstitial, CustomEventServerParameters, CustomEventBannerListener, 
//            CustomEventInterstitialListener

public final class CustomEventAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{
    static final class zza
        implements CustomEventBannerListener
    {

        private final CustomEventAdapter zzbb;
        private final MediationBannerListener zzbc;

        public final void onClick()
        {
            b.a(3);
            zzbc.onClick(zzbb);
        }

        public final void onDismissScreen()
        {
            b.a(3);
            zzbc.onDismissScreen(zzbb);
        }

        public final void onFailedToReceiveAd()
        {
            b.a(3);
            zzbc.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication()
        {
            b.a(3);
            zzbc.onLeaveApplication(zzbb);
        }

        public final void onPresentScreen()
        {
            b.a(3);
            zzbc.onPresentScreen(zzbb);
        }

        public final void onReceivedAd(View view)
        {
            b.a(3);
            CustomEventAdapter.zza(zzbb, view);
            zzbc.onReceivedAd(zzbb);
        }

        public zza(CustomEventAdapter customeventadapter, MediationBannerListener mediationbannerlistener)
        {
            zzbb = customeventadapter;
            zzbc = mediationbannerlistener;
        }
    }

    class zzb
        implements CustomEventInterstitialListener
    {

        private final CustomEventAdapter zzbb;
        private final MediationInterstitialListener zzbd;
        final CustomEventAdapter zzbe;

        public void onDismissScreen()
        {
            b.a(3);
            zzbd.onDismissScreen(zzbb);
        }

        public void onFailedToReceiveAd()
        {
            b.a(3);
            zzbd.onFailedToReceiveAd(zzbb, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication()
        {
            b.a(3);
            zzbd.onLeaveApplication(zzbb);
        }

        public void onPresentScreen()
        {
            b.a(3);
            zzbd.onPresentScreen(zzbb);
        }

        public void onReceivedAd()
        {
            b.a(3);
            zzbd.onReceivedAd(zzbe);
        }

        public zzb(CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
        {
            zzbe = CustomEventAdapter.this;
            super();
            zzbb = customeventadapter1;
            zzbd = mediationinterstitiallistener;
        }
    }


    private View zzaY;
    CustomEventBanner zzaZ;
    CustomEventInterstitial zzba;

    public CustomEventAdapter()
    {
    }

    private void zza(View view)
    {
        zzaY = view;
    }

    static void zza(CustomEventAdapter customeventadapter, View view)
    {
        customeventadapter.zza(view);
    }

    private static Object zzj(String s)
    {
        Object obj;
        try
        {
            obj = Class.forName(s).newInstance();
        }
        catch (Throwable throwable)
        {
            (new StringBuilder("Could not instantiate custom event adapter: ")).append(s).append(". ").append(throwable.getMessage());
            b.a(5);
            return null;
        }
        return obj;
    }

    public final void destroy()
    {
        if (zzaZ != null)
        {
            zzaZ.destroy();
        }
        if (zzba != null)
        {
            zzba.destroy();
        }
    }

    public final Class getAdditionalParametersType()
    {
        return com/google/android/gms/ads/c/b/b;
    }

    public final View getBannerView()
    {
        return zzaY;
    }

    public final Class getServerParametersType()
    {
        return com/google/ads/mediation/customevent/CustomEventServerParameters;
    }

    public final volatile void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MediationServerParameters mediationserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestBannerAd(mediationbannerlistener, activity, (CustomEventServerParameters)mediationserverparameters, adsize, mediationadrequest, (com.google.android.gms.ads.c.b.b)networkextras);
    }

    public final void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, CustomEventServerParameters customeventserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, com.google.android.gms.ads.c.b.b b1)
    {
        zzaZ = (CustomEventBanner)zzj(customeventserverparameters.className);
        if (zzaZ == null)
        {
            mediationbannerlistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (b1 == null)
        {
            b1 = null;
        } else
        {
            b1 = ((com.google.android.gms.ads.c.b.b) (b1.a(customeventserverparameters.label)));
        }
        zzaZ.requestBannerAd(new zza(this, mediationbannerlistener), activity, customeventserverparameters.label, customeventserverparameters.parameter, adsize, mediationadrequest, b1);
    }

    public final volatile void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MediationServerParameters mediationserverparameters, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestInterstitialAd(mediationinterstitiallistener, activity, (CustomEventServerParameters)mediationserverparameters, mediationadrequest, (com.google.android.gms.ads.c.b.b)networkextras);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, CustomEventServerParameters customeventserverparameters, MediationAdRequest mediationadrequest, com.google.android.gms.ads.c.b.b b1)
    {
        zzba = (CustomEventInterstitial)zzj(customeventserverparameters.className);
        if (zzba == null)
        {
            mediationinterstitiallistener.onFailedToReceiveAd(this, com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (b1 == null)
        {
            b1 = null;
        } else
        {
            b1 = ((com.google.android.gms.ads.c.b.b) (b1.a(customeventserverparameters.label)));
        }
        zzba.requestInterstitialAd(zza(mediationinterstitiallistener), activity, customeventserverparameters.label, customeventserverparameters.parameter, mediationadrequest, b1);
    }

    public final void showInterstitial()
    {
        zzba.showInterstitial();
    }

    final zzb zza(MediationInterstitialListener mediationinterstitiallistener)
    {
        return new zzb(this, mediationinterstitiallistener);
    }
}
