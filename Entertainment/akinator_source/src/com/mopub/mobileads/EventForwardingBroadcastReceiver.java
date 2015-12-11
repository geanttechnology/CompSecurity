// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

// Referenced classes of package com.mopub.mobileads:
//            MoPubErrorCode

public class EventForwardingBroadcastReceiver extends BroadcastReceiver
{

    public static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
    public static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
    public static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
    public static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
    private static IntentFilter sIntentFilter;
    private final long mBroadcastIdentifier;
    private Context mContext;
    private final CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;

    public EventForwardingBroadcastReceiver(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, long l)
    {
        mCustomEventInterstitialListener = customeventinterstitiallistener;
        mBroadcastIdentifier = l;
        sIntentFilter = getHtmlInterstitialIntentFilter();
    }

    static void broadcastAction(Context context, long l, String s)
    {
        s = new Intent(s);
        s.putExtra("broadcastIdentifier", l);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(s);
    }

    public static IntentFilter getHtmlInterstitialIntentFilter()
    {
        if (sIntentFilter == null)
        {
            sIntentFilter = new IntentFilter();
            sIntentFilter.addAction("com.mopub.action.interstitial.fail");
            sIntentFilter.addAction("com.mopub.action.interstitial.show");
            sIntentFilter.addAction("com.mopub.action.interstitial.dismiss");
            sIntentFilter.addAction("com.mopub.action.interstitial.click");
        }
        return sIntentFilter;
    }

    public void onReceive(Context context, Intent intent)
    {
        long l;
        if (mCustomEventInterstitialListener != null)
        {
            if (mBroadcastIdentifier == (l = intent.getLongExtra("broadcastIdentifier", -1L)))
            {
                context = intent.getAction();
                if ("com.mopub.action.interstitial.fail".equals(context))
                {
                    mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                    return;
                }
                if ("com.mopub.action.interstitial.show".equals(context))
                {
                    mCustomEventInterstitialListener.onInterstitialShown();
                    return;
                }
                if ("com.mopub.action.interstitial.dismiss".equals(context))
                {
                    mCustomEventInterstitialListener.onInterstitialDismissed();
                    unregister();
                    return;
                }
                if ("com.mopub.action.interstitial.click".equals(context))
                {
                    mCustomEventInterstitialListener.onInterstitialClicked();
                    return;
                }
            }
        }
    }

    public void register(Context context)
    {
        mContext = context;
        LocalBroadcastManager.getInstance(mContext).registerReceiver(this, sIntentFilter);
    }

    public void unregister()
    {
        if (mContext != null)
        {
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(this);
            mContext = null;
        }
    }
}
