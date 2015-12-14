// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import com.facebook.ads.InterstitialAd;
import com.fotoable.ad.StaticFlurryEvent;

class gu
    implements Runnable
{

    final Context a;
    final String b;
    final boolean c;
    final gt d;

    gu(gt gt1, Context context, String s, boolean flag)
    {
        d = gt1;
        a = context;
        b = s;
        c = flag;
        super();
    }

    public void run()
    {
        Looper.prepare();
        if (gt.a(d) == null)
        {
            gt.a(d, new InterstitialAd(a, b));
        }
        gt.a(d).setAdListener(new gv(this));
        gt.a(d).loadAd();
        StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adRequest);
        Looper.loop();
    }
}
