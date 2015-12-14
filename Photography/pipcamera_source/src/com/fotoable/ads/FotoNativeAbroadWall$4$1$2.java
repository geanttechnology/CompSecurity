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
//            fbnativeadsubview, FotoNativeAbroadWall

class a
    implements Runnable
{

    final Ad a;
    final eraction b;

    public void run()
    {
        new HashMap();
        if (b.b == null || b.b != a)
        {
            return;
        }
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adLoaded);
        fbnativeadsubview fbnativeadsubview1 = new fbnativeadsubview(b.b.b);
        fbnativeadsubview1.loadViewWithAd(b.b);
        float f = b.b.b.getResources().getDisplayMetrics().widthPixels;
        f -= f / 8F;
        float f1 = (207F * f) / 300F;
        fbnativeadsubview1.setLayoutParams(new android.view.t>((int)f, (int)f1));
        if (fbnativeadsubview1.getParent() != null)
        {
            ((ViewGroup)fbnativeadsubview1.getParent()).removeView(fbnativeadsubview1);
        }
        b.b.b.addView(fbnativeadsubview1, -2, -2);
        if (b.b.b != null)
        {
            b.b.b.adLoaded(b.b.b);
            b.b.registerViewForInteraction(fbnativeadsubview1);
        }
        Log.d("NativeAbroadWall", "load native ad succeed!");
    }

    a(a a1, Ad ad)
    {
        b = a1;
        a = ad;
        super();
    }

    // Unreferenced inner class com/fotoable/ads/FotoNativeAbroadWall$4

/* anonymous class */
    class FotoNativeAbroadWall._cls4
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
                nativead.setAdListener(new FotoNativeAbroadWall._cls4._cls1(this, nativead));
                nativead.loadAd();
                StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adRequest);
                StaticFlurryEvent.recordNativeAdRequestTimes(d.getContext(), false, true);
            }
            catch (Exception exception) { }
            Looper.loop();
        }

            
            {
                d = fotonativeabroadwall;
                a = context;
                b = s;
                c = iz1;
                super();
            }
    }


    // Unreferenced inner class com/fotoable/ads/FotoNativeAbroadWall$4$1

/* anonymous class */
    class FotoNativeAbroadWall._cls4._cls1
        implements AdListener
    {

        final NativeAd a;
        final FotoNativeAbroadWall._cls4 b;

        public void onAdClicked(Ad ad)
        {
            if (b.a != null)
            {
                (new Handler(b.a.getMainLooper())).post(new FotoNativeAbroadWall._cls4._cls1._cls1());
            }
        }

        public void onAdLoaded(Ad ad)
        {
            if (b.a != null)
            {
                (new Handler(b.a.getMainLooper())).post(new FotoNativeAbroadWall._cls4._cls1._cls2(this, ad));
            }
        }

        public void onError(Ad ad, AdError aderror)
        {
            if (b.a != null)
            {
                (new Handler(b.a.getMainLooper())).post(new FotoNativeAbroadWall._cls4._cls1._cls3());
            }
        }

            
            {
                b = _pcls4;
                a = nativead;
                super();
            }

        // Unreferenced inner class com/fotoable/ads/FotoNativeAbroadWall$4$1$1

/* anonymous class */
        class FotoNativeAbroadWall._cls4._cls1._cls1
            implements Runnable
        {

            final FotoNativeAbroadWall._cls4._cls1 a;

            public void run()
            {
                StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adClicked);
                StaticFlurryEvent.logADClickedEvent(a.b.a, StaticFlurryEvent.FBNativeAD_Click);
            }

                    
                    {
                        a = FotoNativeAbroadWall._cls4._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/fotoable/ads/FotoNativeAbroadWall$4$1$3

/* anonymous class */
        class FotoNativeAbroadWall._cls4._cls1._cls3
            implements Runnable
        {

            final FotoNativeAbroadWall._cls4._cls1 a;

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
                        a = FotoNativeAbroadWall._cls4._cls1.this;
                        super();
                    }
        }

    }

}
