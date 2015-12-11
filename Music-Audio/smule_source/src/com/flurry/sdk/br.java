// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            bd, gd, r

public class br extends bd
    implements InterstitialAdListener
{

    private static final String b = com/flurry/sdk/br.getSimpleName();
    private final String c;
    private final String d;
    private final boolean e;
    private InterstitialAd f;

    public br(Context context, r r, Bundle bundle)
    {
        super(context, r);
        c = bundle.getString("com.flurry.fan.MY_APP_ID");
        d = bundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        e = bundle.getBoolean("com.flurry.fan.test");
    }

    public void a()
    {
        Context context = c();
        if (e)
        {
            AdSettings.addTestDevice(d);
        }
        f = new InterstitialAd(context, c);
        f.setAdListener(this);
        f.loadAd();
    }

    public void onAdClicked(Ad ad)
    {
        gd.a(4, b, "FAN interstitial onAdClicked.");
        b(Collections.emptyMap());
    }

    public void onAdLoaded(Ad ad)
    {
        gd.a(4, b, "FAN interstitial onAdLoaded.");
        if (f != null && f.isAdLoaded())
        {
            f.show();
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
        gd.a(4, b, "FAN interstitial onError.");
        d(Collections.emptyMap());
        f.destroy();
        f = null;
    }

    public void onInterstitialDismissed(Ad ad)
    {
        gd.a(4, b, "FAN interstitial onInterstitialDismissed.");
        c(Collections.emptyMap());
    }

    public void onInterstitialDisplayed(Ad ad)
    {
        gd.a(4, b, "FAN interstitial onInterstitialDisplayed.");
        a(Collections.emptyMap());
    }

}
