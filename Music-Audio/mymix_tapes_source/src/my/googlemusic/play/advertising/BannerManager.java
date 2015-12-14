// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.advertising;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.millennialmedia.InlineAd;
import com.millennialmedia.MMException;
import com.millennialmedia.MMSDK;
import com.mopub.mobileads.MoPubView;

public class BannerManager
{

    public BannerManager()
    {
    }

    public static void loadadmobbanner(RelativeLayout relativelayout)
    {
        try
        {
            AdView adview = new AdView(relativelayout.getContext());
            adview.setAdSize(AdSize.BANNER);
            adview.setAdUnitId("ca-app-pub-5647466170085021/1870725391");
            relativelayout.addView(adview);
            adview.setAdListener(new _cls4());
            adview.loadAd((new com.google.android.gms.ads.AdRequest.Builder()).build());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RelativeLayout relativelayout)
        {
            relativelayout.printStackTrace();
        }
    }

    public static void loadinmob(RelativeLayout relativelayout)
    {
        Activity activity = (Activity)relativelayout.getContext();
        activity.runOnUiThread(new _cls2(activity, relativelayout));
    }

    public static void loadmmdevbanner(RelativeLayout relativelayout)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        relativelayout.setVisibility(0);
        Activity activity = (Activity)relativelayout.getContext();
        MMSDK.initialize(activity);
        InlineAd inlinead = InlineAd.createInstance("57700", relativelayout);
        inlinead.setListener(new _cls1(activity, relativelayout));
        inlinead.request((new com.millennialmedia.InlineAd.InlineAdMetadata()).setAdSize(com.millennialmedia.InlineAd.AdSize.BANNER));
        return;
        relativelayout;
        relativelayout.printStackTrace();
        return;
    }

    public static void loadmopubbanner(RelativeLayout relativelayout)
    {
        try
        {
            Activity activity = (Activity)relativelayout.getContext();
            MoPubView mopubview = new MoPubView(activity);
            mopubview.setAdUnitId("d4bd16ab2fc14d6fb4306ad35a03ef4d");
            mopubview.loadAd();
            mopubview.setBannerAdListener(new _cls3(activity, relativelayout));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RelativeLayout relativelayout)
        {
            relativelayout.printStackTrace();
        }
    }

    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}

}
