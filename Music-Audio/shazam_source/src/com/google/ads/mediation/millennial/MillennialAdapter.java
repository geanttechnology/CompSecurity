// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.millennialmedia.android.aa;
import com.millennialmedia.android.ab;
import com.millennialmedia.android.ad;
import com.millennialmedia.android.ag;
import com.millennialmedia.android.ah;
import com.millennialmedia.android.am;
import com.millennialmedia.android.at;

// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras, MillennialAdapterServerParameters

public final class MillennialAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{
    private class BannerListener
        implements at
    {

        final MillennialAdapter this$0;

        public void MMAdOverlayClosed(aa aa)
        {
            bannerListener.onDismissScreen(MillennialAdapter.this);
        }

        public void MMAdOverlayLaunched(aa aa)
        {
            bannerListener.onPresentScreen(MillennialAdapter.this);
        }

        public void MMAdRequestIsCaching(aa aa)
        {
        }

        public void onSingleTap(aa aa)
        {
            bannerListener.onClick(MillennialAdapter.this);
        }

        public void requestCompleted(aa aa)
        {
            bannerListener.onReceivedAd(MillennialAdapter.this);
        }

        public void requestFailed(aa aa, ag ag)
        {
            bannerListener.onFailedToReceiveAd(MillennialAdapter.this, com.google.ads.AdRequest.ErrorCode.NO_FILL);
        }

        private BannerListener()
        {
            this$0 = MillennialAdapter.this;
            super();
        }

    }

    private class InterstitialListener
        implements at
    {

        final MillennialAdapter this$0;

        public void MMAdOverlayClosed(aa aa)
        {
            interstitialListener.onDismissScreen(MillennialAdapter.this);
        }

        public void MMAdOverlayLaunched(aa aa)
        {
            interstitialListener.onPresentScreen(MillennialAdapter.this);
        }

        public void MMAdRequestIsCaching(aa aa)
        {
        }

        public void onSingleTap(aa aa)
        {
        }

        public void requestCompleted(aa aa)
        {
            interstitialListener.onReceivedAd(MillennialAdapter.this);
        }

        public void requestFailed(aa aa, ag ag1)
        {
            if (ag1.a == 17)
            {
                interstitialListener.onReceivedAd(MillennialAdapter.this);
                return;
            } else
            {
                interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, com.google.ads.AdRequest.ErrorCode.NO_FILL);
                return;
            }
        }

        private InterstitialListener()
        {
            this$0 = MillennialAdapter.this;
            super();
        }

    }


    public static final int ID_BANNER = 0x31d1a90a;
    private ad adView;
    private MediationBannerListener bannerListener;
    private ah interstitial;
    private MediationInterstitialListener interstitialListener;
    private FrameLayout wrappedAdView;

    public MillennialAdapter()
    {
    }

    private am createMMRequest(MediationAdRequest mediationadrequest, MillennialAdapterExtras millennialadapterextras)
    {
        am am1;
        am1 = new am();
        MillennialAdapterExtras millennialadapterextras1 = millennialadapterextras;
        if (millennialadapterextras == null)
        {
            millennialadapterextras1 = new MillennialAdapterExtras();
        }
        String s = null;
        millennialadapterextras = s;
        if (mediationadrequest != null)
        {
            millennialadapterextras = s;
            if (mediationadrequest.getKeywords() != null)
            {
                millennialadapterextras = TextUtils.join(",", mediationadrequest.getKeywords());
                am1.g = millennialadapterextras;
            }
        }
        s = millennialadapterextras1.getKeywords();
        if (s != null && !TextUtils.isEmpty(s))
        {
            static class _cls1
            {

                static final int $SwitchMap$com$google$ads$AdRequest$Gender[];

                static 
                {
                    $SwitchMap$com$google$ads$AdRequest$Gender = new int[com.google.ads.AdRequest.Gender.values().length];
                    try
                    {
                        $SwitchMap$com$google$ads$AdRequest$Gender[com.google.ads.AdRequest.Gender.MALE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$google$ads$AdRequest$Gender[com.google.ads.AdRequest.Gender.FEMALE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$google$ads$AdRequest$Gender[com.google.ads.AdRequest.Gender.UNKNOWN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if (TextUtils.isEmpty(millennialadapterextras))
            {
                millennialadapterextras = s;
            } else
            {
                millennialadapterextras = (new StringBuilder()).append(millennialadapterextras).append(",").append(s).toString();
            }
            am1.g = millennialadapterextras;
        }
        if (millennialadapterextras1.getChildren() != null)
        {
            am1.b = millennialadapterextras1.getChildren().getDescription();
        }
        if (mediationadrequest != null && mediationadrequest.getAgeInYears() != null)
        {
            am1.a = mediationadrequest.getAgeInYears().toString();
        }
        if (millennialadapterextras1.getAge() != -1)
        {
            am1.a = Integer.toString(millennialadapterextras1.getAge());
        }
        if (mediationadrequest == null || mediationadrequest.getGender() == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.google.ads.AdRequest.Gender[mediationadrequest.getGender().ordinal()];
        JVM INSTR tableswitch 1 3: default 204
    //                   1 397
    //                   2 407
    //                   3 417;
           goto _L2 _L3 _L4 _L5
_L2:
        if (millennialadapterextras1.getGender() != null)
        {
            am1.e = millennialadapterextras1.getGender().getDescription();
        }
        if (millennialadapterextras1.getIncomeInUsDollars() != null)
        {
            am1.f = millennialadapterextras1.getIncomeInUsDollars().toString();
        }
        if (mediationadrequest != null && mediationadrequest.getLocation() != null)
        {
            am.a(mediationadrequest.getLocation());
        }
        if (millennialadapterextras1.getLocation() != null)
        {
            am.a(millennialadapterextras1.getLocation());
        }
        if (millennialadapterextras1.getPostalCode() != null)
        {
            am1.k = millennialadapterextras1.getPostalCode();
        }
        if (millennialadapterextras1.getMaritalStatus() != null)
        {
            am1.h = millennialadapterextras1.getMaritalStatus().getDescription();
        }
        if (millennialadapterextras1.getEthnicity() != null)
        {
            am1.d = millennialadapterextras1.getEthnicity().getDescription();
        }
        if (millennialadapterextras1.getPolitics() != null)
        {
            am1.i = millennialadapterextras1.getPolitics().getDescription();
        }
        if (millennialadapterextras1.getEducation() != null)
        {
            am1.c = millennialadapterextras1.getEducation().getDescription();
        }
        return am1;
_L3:
        am1.e = "male";
        continue; /* Loop/switch isn't completed */
_L4:
        am1.e = "female";
        continue; /* Loop/switch isn't completed */
_L5:
        am1.e = "unknown";
        if (true) goto _L2; else goto _L6
_L6:
    }

    private static int dip(int i, Context context)
    {
        return (int)TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public final void destroy()
    {
    }

    public final Class getAdditionalParametersType()
    {
        return com/google/ads/mediation/millennial/MillennialAdapterExtras;
    }

    public final View getBannerView()
    {
        return wrappedAdView;
    }

    public final Class getServerParametersType()
    {
        return com/google/ads/mediation/millennial/MillennialAdapterServerParameters;
    }

    public final volatile void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MediationServerParameters mediationserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestBannerAd(mediationbannerlistener, activity, (MillennialAdapterServerParameters)mediationserverparameters, adsize, mediationadrequest, (MillennialAdapterExtras)networkextras);
    }

    public final void requestBannerAd(MediationBannerListener mediationbannerlistener, Activity activity, MillennialAdapterServerParameters millennialadapterserverparameters, AdSize adsize, MediationAdRequest mediationadrequest, MillennialAdapterExtras millennialadapterextras)
    {
        bannerListener = mediationbannerlistener;
        adView = new ad(activity);
        if (adsize.isSizeAppropriate(320, 53))
        {
            adView.setWidth(320);
            adView.setHeight(53);
            mediationbannerlistener = new android.widget.FrameLayout.LayoutParams(dip(320, activity), dip(53, activity));
        } else
        {
            adView.setWidth(adsize.getWidth());
            adView.setHeight(adsize.getHeight());
            mediationbannerlistener = new android.widget.FrameLayout.LayoutParams(dip(adsize.getWidth(), activity), dip(adsize.getHeight(), activity));
        }
        adView.setApid(millennialadapterserverparameters.apid);
        adView.setMMRequest(createMMRequest(mediationadrequest, millennialadapterextras));
        adView.setListener(new BannerListener(null));
        wrappedAdView = new FrameLayout(activity);
        wrappedAdView.setLayoutParams(mediationbannerlistener);
        wrappedAdView.addView(adView);
        adView.setId(0x31d1a90a);
        adView.getAd();
    }

    public final volatile void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MediationServerParameters mediationserverparameters, MediationAdRequest mediationadrequest, NetworkExtras networkextras)
    {
        requestInterstitialAd(mediationinterstitiallistener, activity, (MillennialAdapterServerParameters)mediationserverparameters, mediationadrequest, (MillennialAdapterExtras)networkextras);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationinterstitiallistener, Activity activity, MillennialAdapterServerParameters millennialadapterserverparameters, MediationAdRequest mediationadrequest, MillennialAdapterExtras millennialadapterextras)
    {
        interstitialListener = mediationinterstitiallistener;
        interstitial = new ah(activity);
        interstitial.a(millennialadapterserverparameters.apid);
        mediationinterstitiallistener = interstitial;
        activity = createMMRequest(mediationadrequest, millennialadapterextras);
        ((ah) (mediationinterstitiallistener)).a.a(activity);
        interstitial.a(new InterstitialListener(null));
        interstitial.a();
    }

    public final void showInterstitial()
    {
        interstitial.d();
    }


}
