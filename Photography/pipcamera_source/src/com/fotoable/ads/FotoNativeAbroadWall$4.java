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
import android.view.ViewGroup;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.NativeAd;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import iz;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.fotoable.ads:
//            FotoNativeAbroadWall, fbnativeadsubview

class c
    implements Runnable
{

    final Context a;
    final String b;
    final iz c;
    final FotoNativeAbroadWall d;

    public void run()
    {
        Looper.prepare();
        try
        {
            FotoNativeAbroadWall.access$002(d, new Handler());
            NativeAd nativead = new NativeAd(a, b);
            AdSettings.addTestDevice("016a0279b084789242a778031e29285e");
            AdSettings.addTestDevice("d590623f0b352e2ea94dc0a41365d8ef");
            AdSettings.addTestDevice("3909cdec8a6015f686178e83f17287d4");
            nativead.setAdListener(new AdListener(nativead) {

                final NativeAd a;
                final FotoNativeAbroadWall._cls4 b;

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
                                a.b.d.createAdmobNativeView(true, true, a.b.d.getContext(), (iz)FotoNativeAbroadWall.access$100(a.b.d).get());
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
                b = FotoNativeAbroadWall._cls4.this;
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

    _cls1.a(FotoNativeAbroadWall fotonativeabroadwall, Context context, String s, iz iz)
    {
        d = fotonativeabroadwall;
        a = context;
        b = s;
        c = iz;
        super();
    }
}
