// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import ee;
import iz;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.fotoable.ads:
//            fbnativeadsubview

public class FotoNativeAbroadWall extends FotoNativeBaseWall
{

    static String TAG = "FotoNativeAbroadWall";
    private WeakReference lisenterWeakReference;
    private Handler threadKillerHandler;

    public FotoNativeAbroadWall(Context context)
    {
        super(context);
    }

    private void createFbNative(Context context, String s, iz iz1)
    {
        try
        {
            (new Thread(new Runnable(context, s, iz1) {

                final Context a;
                final String b;
                final iz c;
                final FotoNativeAbroadWall d;

                public void run()
                {
                    Looper.prepare();
                    try
                    {
                        d.threadKillerHandler = new Handler();
                        NativeAd nativead = new NativeAd(a, b);
                        AdSettings.addTestDevice("016a0279b084789242a778031e29285e");
                        AdSettings.addTestDevice("d590623f0b352e2ea94dc0a41365d8ef");
                        AdSettings.addTestDevice("3909cdec8a6015f686178e83f17287d4");
                        nativead.setAdListener(new com.facebook.ads.AdListener(this, nativead) {

                            final NativeAd a;
                            final _cls4 b;

                            public void onAdClicked(Ad ad)
                            {
                                if (b.a != null)
                                {
                                    (new Handler(b.a.getMainLooper())).post(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adClicked);
                                            StaticFlurryEvent.logADClickedEvent(a.b.a, StaticFlurryEvent.FBNativeAD_Click);
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                }
                            }

                            public void onAdLoaded(Ad ad)
                            {
                                if (b.a != null)
                                {
                                    (new Handler(b.a.getMainLooper())).post(new Runnable(this, ad) {

                                        final Ad a;
                                        final _cls1 b;

                                        public void run()
                                        {
                                            new HashMap();
                                            if (b.a == null || b.a != a)
                                            {
                                                return;
                                            }
                                            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adLoaded);
                                            fbnativeadsubview fbnativeadsubview1 = new fbnativeadsubview(b.b.a);
                                            fbnativeadsubview1.loadViewWithAd(b.a);
                                            float f = b.b.a.getResources().getDisplayMetrics().widthPixels;
                                            f -= f / 8F;
                                            float f1 = (207F * f) / 300F;
                                            fbnativeadsubview1.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
                                            if (fbnativeadsubview1.getParent() != null)
                                            {
                                                ((ViewGroup)fbnativeadsubview1.getParent()).removeView(fbnativeadsubview1);
                                            }
                                            b.b.d.addView(fbnativeadsubview1, -2, -2);
                                            if (b.b.c != null)
                                            {
                                                b.b.c.adLoaded(b.b.d);
                                                b.a.registerViewForInteraction(fbnativeadsubview1);
                                            }
                                            Log.d("NativeAbroadWall", "load native ad succeed!");
                                        }

            
            {
                b = _pcls1;
                a = ad;
                super();
            }
                                    });
                                }
                            }

                            public void onError(Ad ad, AdError aderror)
                            {
                                if (b.a != null)
                                {
                                    (new Handler(b.a.getMainLooper())).post(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adLoadedFailed);
                                            if (!NativeAdWrapper.needAdmobNative(a.b.d.getContext())) goto _L2; else goto _L1
_L1:
                                            a.b.d.createAdmobNativeView(true, true, a.b.d.getContext(), (iz)a.b.d.lisenterWeakReference.get());
_L4:
                                            Log.d("NativeAbroadWall", "load native ad failed!");
                                            return;
_L2:
                                            if (a.b.c != null)
                                            {
                                                a.b.c.adFailed();
                                            }
                                            if (true) goto _L4; else goto _L3
_L3:
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                }
                            }

            
            {
                b = _pcls4;
                a = nativead;
                super();
            }
                        });
                        nativead.loadAd();
                        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adRequest);
                        StaticFlurryEvent.recordNativeAdRequestTimes(d.getContext(), false, true);
                    }
                    catch (Exception exception) { }
                    Looper.loop();
                }

            
            {
                d = FotoNativeAbroadWall.this;
                a = context;
                b = s;
                c = iz1;
                super();
            }
            })).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, context.toString());
        }
    }

    public void createAdmobNativeView(boolean flag, boolean flag1, Context context, iz iz1)
    {
        if (flag || flag1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.e(TAG, "ADMOB refresh ads");
        com.google.android.gms.ads.AdLoader.Builder builder = new com.google.android.gms.ads.AdLoader.Builder(context, FotoAdMediationDB.getAdmobUnitID(context));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        builder.forAppInstallAd(new com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener(context, iz1) {

            final Context a;
            final iz b;
            final FotoNativeAbroadWall c;

            public void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
            {
                NativeAppInstallAdView nativeappinstalladview = (NativeAppInstallAdView)LayoutInflater.from(a).inflate(com.fotoabroad.fotoabroadlib.R.layout.admob_app_install, null);
                ee.a(nativeappinstallad, nativeappinstalladview);
                ee.a(a, nativeappinstalladview);
                if (b != null)
                {
                    float f = a.getResources().getDisplayMetrics().widthPixels;
                    f -= f / 8F;
                    float f1 = (207F * f) / 300F;
                    nativeappinstalladview.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
                    if (nativeappinstalladview.getParent() != null)
                    {
                        ((ViewGroup)nativeappinstalladview.getParent()).removeView(nativeappinstalladview);
                    }
                    c.addView(nativeappinstalladview, -2, -2);
                    b.adLoaded(c);
                    StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoaded);
                    Log.e(FotoNativeAbroadWall.TAG, "APPinstalled ADMOB Request Success");
                }
_L1:
                return;
                nativeappinstallad;
                nativeappinstallad.printStackTrace();
                if (b != null)
                {
                    b.adFailed();
                    StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoadedFailed);
                    Log.e(FotoNativeAbroadWall.TAG, "APPinstalled ADMOB Set Failed");
                    return;
                }
                  goto _L1
            }

            
            {
                c = FotoNativeAbroadWall.this;
                a = context;
                b = iz1;
                super();
            }
        });
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        builder.forContentAd(new com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener(context, iz1) {

            final Context a;
            final iz b;
            final FotoNativeAbroadWall c;

            public void onContentAdLoaded(NativeContentAd nativecontentad)
            {
                NativeContentAdView nativecontentadview = (NativeContentAdView)LayoutInflater.from(a).inflate(com.fotoabroad.fotoabroadlib.R.layout.admob_content, null);
                ee.a(nativecontentad, nativecontentadview);
                ee.a(a, nativecontentadview);
                if (b != null)
                {
                    Log.e(FotoNativeAbroadWall.TAG, "Content ADMOB Request Success");
                    float f = a.getResources().getDisplayMetrics().widthPixels;
                    f -= f / 8F;
                    float f1 = (207F * f) / 300F;
                    nativecontentadview.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
                    if (nativecontentadview.getParent() != null)
                    {
                        ((ViewGroup)nativecontentadview.getParent()).removeView(nativecontentadview);
                    }
                    c.addView(nativecontentadview, -2, -2);
                    b.adLoaded(c);
                    StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoaded);
                }
_L1:
                return;
                nativecontentad;
                nativecontentad.printStackTrace();
                if (b != null)
                {
                    b.adFailed();
                    StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoadedFailed);
                    Log.e(FotoNativeAbroadWall.TAG, "Content ADMOB Set Failed");
                    return;
                }
                  goto _L1
            }

            
            {
                c = FotoNativeAbroadWall.this;
                a = context;
                b = iz1;
                super();
            }
        });
        builder.withAdListener(new AdListener(context, iz1) {

            final Context a;
            final iz b;
            final FotoNativeAbroadWall c;

            public void onAdFailedToLoad(int i)
            {
                Log.e(FotoNativeAbroadWall.TAG, (new StringBuilder()).append("ADMOB Request Failed ").append(i).toString());
                if (b != null)
                {
                    b.adFailed();
                }
            }

            public void onAdOpened()
            {
                super.onAdOpened();
                Log.e(FotoNativeAbroadWall.TAG, "ADMOB Clicked");
                StaticFlurryEvent.logADClickedEvent(a, StaticFlurryEvent.AdMobNativeAD_Click);
            }

            
            {
                c = FotoNativeAbroadWall.this;
                a = context;
                b = iz1;
                super();
            }
        }).build().loadAd((new com.google.android.gms.ads.AdRequest.Builder()).addTestDevice("215B9DDDE2A99BBA1A99320DEF55D9E9").build());
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adRequest);
        return;
        context;
        context.printStackTrace();
        if (iz1 != null)
        {
            iz1.adFailed();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void destroyAdWall()
    {
        if (threadKillerHandler != null)
        {
            threadKillerHandler.getLooper().quit();
        }
    }

    public void loadAd(Context context, iz iz1, String s)
    {
        lisenterWeakReference = new WeakReference(iz1);
        if (NativeAdWrapper.needFBNative(context))
        {
            createFbNative(context, FotoAdMediationDB.getFBNativeADID(context), (iz)lisenterWeakReference.get());
        } else
        {
            if (NativeAdWrapper.needAdmobNative(context))
            {
                createAdmobNativeView(true, true, context, (iz)lisenterWeakReference.get());
                return;
            }
            if (iz1 != null)
            {
                iz1.adFailed();
                return;
            }
        }
    }

    public void registerImpression(Context context, View view)
    {
    }



/*
    static Handler access$002(FotoNativeAbroadWall fotonativeabroadwall, Handler handler)
    {
        fotonativeabroadwall.threadKillerHandler = handler;
        return handler;
    }

*/

}
