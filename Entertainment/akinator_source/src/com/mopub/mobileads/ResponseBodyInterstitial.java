// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode, EventForwardingBroadcastReceiver

public abstract class ResponseBodyInterstitial extends CustomEventInterstitial
{

    protected AdReport mAdReport;
    protected long mBroadcastIdentifier;
    private EventForwardingBroadcastReceiver mBroadcastReceiver;
    protected Context mContext;

    public ResponseBodyInterstitial()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("Html-Response-Body");
    }

    protected abstract void extractExtras(Map map);

    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        mContext = context;
        if (!extrasAreValid(map1))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        extractExtras(map1);
        mAdReport = (AdReport)map.get("mopub-intent-ad-report");
        map = (Long)map.get("broadcastIdentifier");
        if (map == null)
        {
            try
            {
                MoPubLog.e("Broadcast Identifier was not set in localExtras");
                customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MoPubLog.e("LocalExtras contained an incorrect type.");
            }
            break MISSING_BLOCK_LABEL_120;
        }
        break MISSING_BLOCK_LABEL_76;
        customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        return;
        mBroadcastIdentifier = map.longValue();
        mBroadcastReceiver = new EventForwardingBroadcastReceiver(customeventinterstitiallistener, mBroadcastIdentifier);
        mBroadcastReceiver.register(context);
        preRenderHtml(customeventinterstitiallistener);
        return;
        customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        return;
    }

    public void onInvalidate()
    {
        if (mBroadcastReceiver != null)
        {
            mBroadcastReceiver.unregister();
        }
    }

    protected abstract void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener);

    public abstract void showInterstitial();
}
