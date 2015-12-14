// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.picsart.studio.ads.c;
import com.picsart.studio.ads.h;
import com.picsart.studio.ads.i;
import com.socialin.android.NoProGuard;
import java.util.HashMap;
import java.util.Map;

public class AdsFactoryImpl
    implements c, NoProGuard
{

    private static final int BANNER_AD_HEIGHT = 50;
    private static final int BANNER_AD_WIDTH = 320;
    private i adMobViewFactory;

    public AdsFactoryImpl()
    {
        adMobViewFactory = null;
    }

    public static float convertDpToPixel(float f, Context context)
    {
        return ((float)context.getResources().getDisplayMetrics().densityDpi / 160F) * f;
    }

    private h createAdMobInterstitial(Context context, String s)
    {
        context = new InterstitialAd(context);
        context.setAdUnitId(s);
        context.loadAd((new com.google.android.gms.ads.AdRequest.Builder()).build());
        return new h(context) {

            private InterstitialAd a;

            public final boolean a()
            {
                Log.i("ads-AdMob", " AdMob ad initialized");
                return a.isLoaded();
            }

            public final void b()
            {
                a.show();
            }

            public final void c()
            {
            }

            
            {
                a = interstitialad;
                super();
            }
        };
    }

    private i createAdMobView(Context context, String s)
    {
        AdView adview = new AdView(context);
        adview.setAdUnitId(s);
        adview.setAdSize(AdSize.BANNER);
        s = new com.google.android.gms.ads.AdRequest.Builder();
        s.setLocation(com.picsart.studio.utils.c.a(context, null));
        s.addKeyword("photo editing");
        adview.loadAd(s.build());
        return new i(adview) {

            private AdView a;

            public final View a()
            {
                return a;
            }

            public final void b()
            {
            }

            
            {
                a = adview;
                super();
            }
        };
    }

    private i createFacebookAdView(Context context, String s)
    {
        context = new com.facebook.ads.AdView(context, s, com.facebook.ads.AdSize.BANNER_320_50);
        context.loadAd();
        return new i(context) {

            private com.facebook.ads.AdView a;

            public final View a()
            {
                return a;
            }

            public final void b()
            {
                a.destroy();
            }

            
            {
                a = adview;
                super();
            }
        };
    }

    private i createInmobiView(Context context, String s)
    {
        InMobi.setLogLevel(com.inmobi.commons.InMobi.LOG_LEVEL.DEBUG);
        InMobi.initialize((Activity)context, s);
        context = new IMBanner((Activity)context, s, 15);
        context.setIMBannerListener(new IMBannerListener() {

            public final void onBannerInteraction(IMBanner imbanner, Map map)
            {
                Log.i("createInmobiView", " BannerInteraction ");
            }

            public final void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode)
            {
                Log.i("createInmobiView", (new StringBuilder(" BannerRequestFailed - errorCode:")).append(imerrorcode).toString());
            }

            public final void onBannerRequestSucceeded(IMBanner imbanner)
            {
                Log.i("createInmobiView", " BannerRequestSucceeded ");
            }

            public final void onDismissBannerScreen(IMBanner imbanner)
            {
                Log.i("createInmobiView", " DismissBannerScreen");
            }

            public final void onLeaveApplication(IMBanner imbanner)
            {
                Log.i("createInmobiView", " LeaveApplication");
            }

            public final void onShowBannerScreen(IMBanner imbanner)
            {
                Log.i("createInmobiView", " ShowBannerScreen");
            }

        });
        context.loadBanner();
        return new i(context) {

            private IMBanner a;

            public final View a()
            {
                return a;
            }

            public final void b()
            {
                a.destroy();
            }

            
            {
                a = imbanner;
                super();
            }
        };
    }

    private i createMmediaVew(Context context, String s)
    {
        context = new MMAdView(context);
        context.setApid(s);
        context.setId(MMSDK.getDefaultAdId());
        context.setWidth(320);
        context.setHeight(50);
        context.setListener(new RequestListener() {

            public final void MMAdOverlayClosed(MMAd mmad)
            {
            }

            public final void MMAdOverlayLaunched(MMAd mmad)
            {
            }

            public final void MMAdRequestIsCaching(MMAd mmad)
            {
            }

            public final void onSingleTap(MMAd mmad)
            {
            }

            public final void requestCompleted(MMAd mmad)
            {
                Log.i("ads", "MMAd::requestCompleted");
            }

            public final void requestFailed(MMAd mmad, MMException mmexception)
            {
                Log.i("ads", "-MMAd::requestFailed");
            }

        });
        context.getAd();
        return new i(context) {

            private MMAdView a;

            public final View a()
            {
                return a;
            }

            public final void b()
            {
                a.destroyDrawingCache();
            }

            
            {
                a = mmadview;
                super();
            }
        };
    }

    private h createMopubInterstitial(Context context, String s)
    {
        try
        {
            context = new MoPubInterstitial((Activity)context, s);
            context.setInterstitialAdListener(new com.mopub.mobileads.MoPubInterstitial.InterstitialAdListener() {

                public final void onInterstitialClicked(MoPubInterstitial mopubinterstitial)
                {
                    Log.i("MopubInterstitial", " Mopub Interstitial clicked");
                }

                public final void onInterstitialDismissed(MoPubInterstitial mopubinterstitial)
                {
                    Log.i("MopubInterstitial", " Mopub Interstitial Dismissed");
                    mopubinterstitial.destroy();
                }

                public final void onInterstitialFailed(MoPubInterstitial mopubinterstitial, MoPubErrorCode mopuberrorcode)
                {
                    Log.i("MopubInterstitial", (new StringBuilder(" Mopub Interstitial Load failed errorCode = ")).append(mopuberrorcode).toString());
                    mopubinterstitial.destroy();
                }

                public final void onInterstitialLoaded(MoPubInterstitial mopubinterstitial)
                {
                    Log.i("MopubInterstitial", " Mopub Interstitial Loaded");
                }

                public final void onInterstitialShown(MoPubInterstitial mopubinterstitial)
                {
                    Log.i("MopubInterstitial", " Mopub Interstitial shown");
                }

            });
            context.load();
            context = new h(context) {

                private MoPubInterstitial a;

                public final boolean a()
                {
                    return a.isReady();
                }

                public final void b()
                {
                    a.show();
                }

                public final void c()
                {
                    a.destroy();
                }

            
            {
                a = mopubinterstitial;
                super();
            }
            };
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    private i createdMoPubVew(Context context, String s)
    {
        MoPubView mopubview = new MoPubView(context);
        mopubview.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)convertDpToPixel(320F, context), (int)convertDpToPixel(50F, context)));
        mopubview.setAdUnitId(s);
        mopubview.loadAd();
        context = new HashMap();
        context.put("pafactory", this);
        context.put("property_id", s);
        mopubview.setLocalExtras(context);
        return new i(mopubview) {

            private MoPubView a;

            public final View a()
            {
                return a;
            }

            public final void b()
            {
                a.destroy();
            }

            
            {
                a = mopubview;
                super();
            }
        };
    }

    public i fetchAd(Context context, String s, String s1, HashMap hashmap)
    {
        Log.i("ads", (new StringBuilder("AdsFactoryImpl.fetchAd() - provider:")).append(s).append(" propertyId:").append(s1).toString());
        final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[AdsProvilders.values().length];
                try
                {
                    a[AdsProvilders.INMOBI.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[AdsProvilders.MMEDIA3.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[AdsProvilders.MOPUB2.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdsProvilders.ADMOB.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdsProvilders.FBAD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[AdsProvilders.valueOf(s).ordinal()])
        {
        default:
            return createAdMobView(context, s1);

        case 1: // '\001'
            return createInmobiView(context, s1);

        case 2: // '\002'
            return createMmediaVew(context, s1);

        case 3: // '\003'
            return createdMoPubVew(context, s1);

        case 4: // '\004'
            return createAdMobView(context, s1);

        case 5: // '\005'
            return createFacebookAdView(context, s1);
        }
    }

    public h fetchInterstitialAd(Context context, String s, String s1, HashMap hashmap)
    {
        Log.i("ads", (new StringBuilder("AdsFactoryImpl.fetchInterstitialAd() - provider:")).append(s).append(" propertyId:").append(s1).toString());
        _cls3.a[AdsProvilders.valueOf(s).ordinal()];
        JVM INSTR tableswitch 3 4: default 68
    //                   3 110
    //                   4 121;
           goto _L1 _L2 _L3
_L1:
        hashmap = createAdMobInterstitial(context, s1);
_L5:
        Object obj = hashmap;
        if (hashmap == null)
        {
            obj = hashmap;
            if (AdsProvilders.valueOf(s) != AdsProvilders.ADMOB)
            {
                obj = createAdMobInterstitial(context, s1);
            }
        }
        return ((h) (obj));
_L2:
        hashmap = createMopubInterstitial(context, s1);
        continue; /* Loop/switch isn't completed */
_L3:
        hashmap = createAdMobInterstitial(context, s1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setAdMobViewFactory(i i)
    {
        adMobViewFactory = i;
    }

    public void setParentViewContainer(ViewGroup viewgroup)
    {
    }

    private class AdsProvilders extends Enum
    {

        private static final AdsProvilders $VALUES[];
        public static final AdsProvilders ADMOB;
        public static final AdsProvilders AMAZON;
        public static final AdsProvilders FBAD;
        public static final AdsProvilders INMOBI;
        public static final AdsProvilders MMEDIA3;
        public static final AdsProvilders MOPUB2;
        public static final AdsProvilders NONE;
        public static final AdsProvilders SOCIALIN;
        public static final AdsProvilders TEST;

        public static AdsProvilders valueOf(String s)
        {
            return (AdsProvilders)Enum.valueOf(com/picsart/studio/ads/lib/AdsFactoryImpl$AdsProvilders, s);
        }

        public static AdsProvilders[] values()
        {
            return (AdsProvilders[])$VALUES.clone();
        }

        static 
        {
            NONE = new AdsProvilders("NONE", 0);
            SOCIALIN = new AdsProvilders("SOCIALIN", 1);
            ADMOB = new AdsProvilders("ADMOB", 2);
            MMEDIA3 = new AdsProvilders("MMEDIA3", 3);
            AMAZON = new AdsProvilders("AMAZON", 4);
            INMOBI = new AdsProvilders("INMOBI", 5);
            MOPUB2 = new AdsProvilders("MOPUB2", 6);
            TEST = new AdsProvilders("TEST", 7);
            FBAD = new AdsProvilders("FBAD", 8);
            $VALUES = (new AdsProvilders[] {
                NONE, SOCIALIN, ADMOB, MMEDIA3, AMAZON, INMOBI, MOPUB2, TEST, FBAD
            });
        }

        private AdsProvilders(String s, int i)
        {
            super(s, i);
        }
    }

}
