// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.intentsoftware.addapptr.PlacementSize;
import com.intentsoftware.addapptr.ad.FullscreenAd;
import com.intentsoftware.addapptr.module.Logger;
import com.smartadserver.android.library.SASBannerView;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            SmartAdServerFullscreenActivity

public class SmartAdServerFullscreen extends FullscreenAd
{

    static SASBannerView interstitialView;
    private Activity activity;
    private BroadcastReceiver broadcastReceiver;

    public SmartAdServerFullscreen()
    {
    }

    private BroadcastReceiver createBroadcastReceiver()
    {
        return new _cls2();
    }

    private com.smartadserver.android.library.ui.SASAdView.AdResponseHandler createResponseHandler()
    {
        return new _cls1();
    }

    public void load(Activity activity1, String s, PlacementSize placementsize)
    {
        super.load(activity1, s, placementsize);
        activity = activity1;
        placementsize = s.split(":");
        if (placementsize.length < 3)
        {
            if (Logger.isLoggable(5))
            {
                Logger.w(this, "not enough arguments for SmartAdServer config");
            }
            notifyListenerThatAdFailedToLoad("not enough arguments in adId.");
            return;
        }
        int i;
        int j;
        try
        {
            i = Integer.parseInt(placementsize[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity1)
        {
            if (Logger.isLoggable(5))
            {
                Logger.w(this, "cannot parse integers for SmartAdServer config");
            }
            notifyListenerThatAdFailedToLoad("cannot parse adId.");
            return;
        }
        s = placementsize[1];
        j = Integer.parseInt(placementsize[2]);
        interstitialView = new SASBannerView(activity1);
        activity1 = getLocation();
        if (activity1 != null)
        {
            interstitialView.setLocation(activity1);
        }
        interstitialView.loadAd(j, s, i, true, "", createResponseHandler());
        return;
    }

    public boolean show()
    {
        broadcastReceiver = createBroadcastReceiver();
        Object obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("SMART_AD_SERVER_CLICKED");
        ((IntentFilter) (obj)).addAction("SMART_AD_SERVER_FAILED");
        ((IntentFilter) (obj)).addAction("SMART_AD_SERVER_FINISH");
        activity.registerReceiver(broadcastReceiver, ((IntentFilter) (obj)));
        notifyListenerThatAdIsShown();
        obj = new Intent(activity, com/intentsoftware/addapptr/fullscreens/SmartAdServerFullscreenActivity);
        activity.startActivity(((Intent) (obj)));
        return true;
    }

    public void unload()
    {
        if (interstitialView != null)
        {
            interstitialView.onDestroy();
            interstitialView = null;
        }
    }





/*
    static BroadcastReceiver access$202(SmartAdServerFullscreen smartadserverfullscreen, BroadcastReceiver broadcastreceiver)
    {
        smartadserverfullscreen.broadcastReceiver = broadcastreceiver;
        return broadcastreceiver;
    }

*/




    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
