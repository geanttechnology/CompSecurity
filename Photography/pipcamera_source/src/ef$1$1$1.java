// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.StaticFlurryEvent;
import java.util.Date;

class .Object
    implements Runnable
{

    final Ad a;
    final ook.ads.Ad b;

    public void run()
    {
        b.b.b.a = false;
        if (FotoAdFactory.needShowInterstitialAd)
        {
            if (ef.a(b.b.b) != null && a == ef.a(b.b.b) && ef.a(b.b.b).isAdLoaded())
            {
                ef.a(b.b.b).show();
                ef.a(b.b.b).destroy();
                ef.a(b.b.b, null);
                b.b.b.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("InterstitialDisplayTime", (new Date()).getTime()).apply();
                return;
            } else
            {
                a.destroy();
                return;
            }
        } else
        {
            ef.a(b.b.b, null);
            return;
        }
    }

    ook.ads.Ad(d d, Ad ad)
    {
        b = d;
        a = ad;
        super();
    }

    // Unreferenced inner class ef$1

/* anonymous class */
    class ef._cls1
        implements Runnable
    {

        final Context a;
        final String b;
        final boolean c;
        final ef d;

        public void run()
        {
            Looper.prepare();
            if (ef.a(d) == null)
            {
                ef.a(d, new InterstitialAd(a, b));
            }
            ef.a(d).setAdListener(new ef._cls1._cls1(this));
            ef.a(d).loadAd();
            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adRequest);
            Looper.loop();
        }

            
            {
                d = ef1;
                a = context;
                b = s;
                c = flag;
                super();
            }
    }


    // Unreferenced inner class ef$1$1

/* anonymous class */
    class ef._cls1._cls1
        implements InterstitialAdListener
    {

        final ef._cls1 a;

        public void onAdClicked(Ad ad)
        {
            Log.d(ef.b(a.d), (new StringBuilder()).append(ef.b(a.d)).append("onAdClicked").toString());
            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adClicked);
        }

        public void onAdLoaded(Ad ad)
        {
            Log.d(ef.b(a.d), (new StringBuilder()).append(ef.b(a.d)).append(" onAdLoaded ").toString());
            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adLoaded);
            if (a.c)
            {
                (new Handler(a.a.getMainLooper())).postDelayed(new ef._cls1._cls1._cls1(this, ad), 5000L);
            }
        }

        public void onError(Ad ad, AdError aderror)
        {
            a.d.a = false;
            Log.d(ef.b(a.d), (new StringBuilder()).append(ef.b(a.d)).append(" onError:").toString());
            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adLoadedFailed);
        }

        public void onInterstitialDismissed(Ad ad)
        {
            Log.d(ef.b(a.d), (new StringBuilder()).append(ef.b(a.d)).append(" onInterstitialDismissed").toString());
        }

        public void onInterstitialDisplayed(Ad ad)
        {
            Log.d(ef.b(a.d), (new StringBuilder()).append(ef.b(a.d)).append(" onIterstitialDisplayed").toString());
            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adShown);
        }

            
            {
                a = _pcls1;
                super();
            }
    }

}
