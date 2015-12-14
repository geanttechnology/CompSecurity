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

public class ef extends iy
{

    private String b;
    private InterstitialAd c;

    public ef()
    {
        b = "AbroadInterstitialAd";
        c = null;
    }

    static InterstitialAd a(ef ef1)
    {
        return ef1.c;
    }

    static InterstitialAd a(ef ef1, InterstitialAd interstitialad)
    {
        ef1.c = interstitialad;
        return interstitialad;
    }

    static String b(ef ef1)
    {
        return ef1.b;
    }

    private static void b(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        context.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("AbroadInterstitialAdTimeOut", (new Date()).getTime()).apply();
        return;
        context;
    }

    public void a()
    {
        if (c != null)
        {
            c.destroy();
            c = null;
        }
    }

    public void a(Context context)
    {
        long l1 = 0L;
        long l;
        long l2;
        try
        {
            l2 = (new Date()).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        l = l1;
        if (context != null)
        {
            try
            {
                l = context.getSharedPreferences("FotoAdStrategy", 0).getLong("AbroadInterstitialAdTimeOut", 0L);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                l = l1;
            }
        }
        if (!a || l2 - l < 10000L)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a = false;
        if (c != null)
        {
            c.setAdListener(null);
            c.destroy();
            c = null;
        }
    }

    public void a(Context context, String s, boolean flag)
    {
        if (context != null)
        {
            a(context);
            if (!a)
            {
                a = true;
                b(context);
                try
                {
                    (new Thread(new Runnable(context, s, flag) {

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
                            ef.a(d).setAdListener(new InterstitialAdListener(this) {

                                final _cls1 a;

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
                                        (new Handler(a.a.getMainLooper())).postDelayed(new Runnable(this, ad) {

                                            final Ad a;
                                            final _cls1 b;

                                            public void run()
                                            {
                                                b.a.d.a = false;
                                                if (FotoAdFactory.needShowInterstitialAd)
                                                {
                                                    if (ef.a(b.a.d) != null && a == ef.a(b.a.d) && ef.a(b.a.d).isAdLoaded())
                                                    {
                                                        ef.a(b.a.d).show();
                                                        ef.a(b.a.d).destroy();
                                                        ef.a(b.a.d, null);
                                                        b.a.a.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("InterstitialDisplayTime", (new Date()).getTime()).apply();
                                                        return;
                                                    } else
                                                    {
                                                        a.destroy();
                                                        return;
                                                    }
                                                } else
                                                {
                                                    ef.a(b.a.d, null);
                                                    return;
                                                }
                                            }

            
            {
                b = _pcls1;
                a = ad;
                super();
            }
                                        }, 5000L);
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
                            });
                            ef.a(d).loadAd();
                            StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adRequest);
                            Looper.loop();
                        }

            
            {
                d = ef.this;
                a = context;
                b = s;
                c = flag;
                super();
            }
                    })).start();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                }
                a = false;
                return;
            }
        }
    }

    public void a(Context context, boolean flag)
    {
        if (c != null && c.isAdLoaded())
        {
            a = false;
            c.show();
            context.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("InterstitialDisplayTime", (new Date()).getTime()).apply();
            if (flag)
            {
                c = null;
            }
        }
    }
}
