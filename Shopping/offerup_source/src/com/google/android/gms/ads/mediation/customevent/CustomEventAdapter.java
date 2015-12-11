// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

// Referenced classes of package com.google.android.gms.ads.mediation.customevent:
//            CustomEventBanner, CustomEventInterstitial, CustomEventNative

public final class CustomEventAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{

    CustomEventBanner zzKL;
    CustomEventInterstitial zzKM;
    CustomEventNative zzKN;
    private View zzaY;

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
            zzb.zzaH((new StringBuilder("Could not instantiate custom event adapter: ")).append(s).append(". ").append(throwable.getMessage()).toString());
            return null;
        }
        return obj;
    }

    public final View getBannerView()
    {
        return zzaY;
    }

    public final void onDestroy()
    {
        if (zzKL != null)
        {
            zzKL.onDestroy();
        }
        if (zzKM != null)
        {
            zzKM.onDestroy();
        }
        if (zzKN != null)
        {
            zzKN.onDestroy();
        }
    }

    public final void onPause()
    {
        if (zzKL != null)
        {
            zzKL.onPause();
        }
        if (zzKM != null)
        {
            zzKM.onPause();
        }
        if (zzKN != null)
        {
            zzKN.onPause();
        }
    }

    public final void onResume()
    {
        if (zzKL != null)
        {
            zzKL.onResume();
        }
        if (zzKM != null)
        {
            zzKM.onResume();
        }
        if (zzKN != null)
        {
            zzKN.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationbannerlistener, Bundle bundle, AdSize adsize, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        zzKL = (CustomEventBanner)zzj(bundle.getString("class_name"));
        if (zzKL == null)
        {
            mediationbannerlistener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle1 == null)
        {
            bundle1 = null;
        } else
        {
            bundle1 = bundle1.getBundle(bundle.getString("class_name"));
        }
        zzKL.requestBannerAd(context, new zza(mediationbannerlistener), bundle.getString("parameter"), adsize, mediationadrequest, bundle1);
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationinterstitiallistener, Bundle bundle, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        zzKM = (CustomEventInterstitial)zzj(bundle.getString("class_name"));
        if (zzKM == null)
        {
            mediationinterstitiallistener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle1 == null)
        {
            bundle1 = null;
        } else
        {
            bundle1 = bundle1.getBundle(bundle.getString("class_name"));
        }
        zzKM.requestInterstitialAd(context, zza(mediationinterstitiallistener), bundle.getString("parameter"), mediationadrequest, bundle1);
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationnativelistener, Bundle bundle, NativeMediationAdRequest nativemediationadrequest, Bundle bundle1)
    {
        zzKN = (CustomEventNative)zzj(bundle.getString("class_name"));
        if (zzKN == null)
        {
            mediationnativelistener.onAdFailedToLoad(this, 0);
            return;
        }
        if (bundle1 == null)
        {
            bundle1 = null;
        } else
        {
            bundle1 = bundle1.getBundle(bundle.getString("class_name"));
        }
        zzKN.requestNativeAd(context, new zzc(mediationnativelistener), bundle.getString("parameter"), nativemediationadrequest, bundle1);
    }

    public final void showInterstitial()
    {
        zzKM.showInterstitial();
    }

    final zzb zza(MediationInterstitialListener mediationinterstitiallistener)
    {
        return new zzb(this, mediationinterstitiallistener);
    }

    private class zza
        implements CustomEventBannerListener
    {

        private final CustomEventAdapter zzKO;
        private final MediationBannerListener zzaQ;

        public final void onAdClicked()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            zzaQ.onAdClicked(zzKO);
        }

        public final void onAdClosed()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            zzaQ.onAdClosed(zzKO);
        }

        public final void onAdFailedToLoad(int i)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
            zzaQ.onAdFailedToLoad(zzKO, i);
        }

        public final void onAdLeftApplication()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            zzaQ.onAdLeftApplication(zzKO);
        }

        public final void onAdLoaded(View view)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLoaded.");
            CustomEventAdapter.zza(zzKO, view);
            zzaQ.onAdLoaded(zzKO);
        }

        public final void onAdOpened()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            zzaQ.onAdOpened(zzKO);
        }

        public zza(MediationBannerListener mediationbannerlistener)
        {
            zzKO = CustomEventAdapter.this;
            zzaQ = mediationbannerlistener;
        }
    }


    private class zzc
        implements CustomEventNativeListener
    {

        private final CustomEventAdapter zzKO;
        private final MediationNativeListener zzaS;

        public void onAdClicked()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            zzaS.onAdClicked(zzKO);
        }

        public void onAdClosed()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            zzaS.onAdClosed(zzKO);
        }

        public void onAdFailedToLoad(int i)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
            zzaS.onAdFailedToLoad(zzKO, i);
        }

        public void onAdLeftApplication()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            zzaS.onAdLeftApplication(zzKO);
        }

        public void onAdLoaded(NativeAdMapper nativeadmapper)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLoaded.");
            zzaS.onAdLoaded(zzKO, nativeadmapper);
        }

        public void onAdOpened()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            zzaS.onAdOpened(zzKO);
        }

        public zzc(MediationNativeListener mediationnativelistener)
        {
            zzKO = CustomEventAdapter.this;
            zzaS = mediationnativelistener;
        }
    }


    private class zzb
        implements CustomEventInterstitialListener
    {

        private final CustomEventAdapter zzKO;
        final CustomEventAdapter zzKP;
        private final MediationInterstitialListener zzaR;

        public void onAdClicked()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            zzaR.onAdClicked(zzKO);
        }

        public void onAdClosed()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            zzaR.onAdClosed(zzKO);
        }

        public void onAdFailedToLoad(int i)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            zzaR.onAdFailedToLoad(zzKO, i);
        }

        public void onAdLeftApplication()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            zzaR.onAdLeftApplication(zzKO);
        }

        public void onAdLoaded()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onReceivedAd.");
            zzaR.onAdLoaded(zzKP);
        }

        public void onAdOpened()
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            zzaR.onAdOpened(zzKO);
        }

        public zzb(CustomEventAdapter customeventadapter1, MediationInterstitialListener mediationinterstitiallistener)
        {
            zzKP = CustomEventAdapter.this;
            super();
            zzKO = customeventadapter1;
            zzaR = mediationinterstitiallistener;
        }
    }

}
