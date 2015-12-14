// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.advertising;

import android.app.Activity;
import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.inmobi.ads.InMobiInterstitial;
import com.millennialmedia.InterstitialAd;
import com.millennialmedia.MMException;
import com.millennialmedia.MMSDK;
import com.mopub.mobileads.MoPubInterstitial;

public class InterstitialManager
{

    public InterstitialManager()
    {
    }

    public static void loadLovin(Context context, boolean flag)
    {
        com.applovin.adview.AppLovinInterstitialAdDialog applovininterstitialaddialog = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(context), (Activity)context);
        AppLovinSdk.getInstance(context).getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new _cls1(applovininterstitialaddialog, context, flag));
    }

    public static void loadinmob(Context context)
    {
        (new InMobiInterstitial(context, 0x5165fa9f9b015L, new _cls3(context))).load();
    }

    public static void loadmmdev(Context context, boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        MMSDK.initialize((Activity)context);
        Object obj;
        if (flag)
        {
            obj = "174462";
        } else
        {
            obj = "61629";
        }
        try
        {
            obj = InterstitialAd.createInstance(((String) (obj)));
            ((InterstitialAd) (obj)).load(context, new com.millennialmedia.InterstitialAd.InterstitialAdMetadata());
            ((InterstitialAd) (obj)).setListener(new _cls2(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
        loadinmob(context);
        return;
    }

    public static void loadmopub(Context context)
    {
        context = new MoPubInterstitial((Activity)context, "92d468ccb8c148a18dddd1f7f2d6c0c2");
        context.setInterstitialAdListener(new _cls4());
        context.load();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}

}
