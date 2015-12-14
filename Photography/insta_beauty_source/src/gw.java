// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAd;
import com.fotoable.ad.FotoAdFactory;
import java.util.Date;

class gw
    implements Runnable
{

    final Ad a;
    final gv b;

    gw(gv gv1, Ad ad)
    {
        b = gv1;
        a = ad;
        super();
    }

    public void run()
    {
        b.a.d.a = false;
        if (FotoAdFactory.needShowInterstitialAd)
        {
            if (gt.a(b.a.d) != null && a == gt.a(b.a.d) && gt.a(b.a.d).isAdLoaded())
            {
                gt.a(b.a.d).show();
                gt.a(b.a.d).destroy();
                gt.a(b.a.d, null);
                b.a.a.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("InterstitialDisplayTime", (new Date()).getTime()).apply();
                return;
            } else
            {
                a.destroy();
                return;
            }
        } else
        {
            gt.a(b.a.d, null);
            return;
        }
    }
}
