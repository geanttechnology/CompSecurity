// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdListener, Log, AdError, Ad, 
//            AdProperties

public class DefaultAdListener
    implements AdListener
{

    final String LOG_TAG;

    public DefaultAdListener()
    {
        this(com/amazon/device/ads/DefaultAdListener.getSimpleName());
    }

    DefaultAdListener(String s)
    {
        LOG_TAG = s;
    }

    public void onAdCollapsed(Ad ad)
    {
        Log.d(LOG_TAG, "Default ad listener called - Ad Collapsed.");
    }

    public void onAdDismissed(Ad ad)
    {
        Log.d(LOG_TAG, "Default ad listener called - Ad Dismissed.");
    }

    public void onAdExpanded(Ad ad)
    {
        Log.d(LOG_TAG, "Default ad listener called - Ad Will Expand.");
    }

    public void onAdFailedToLoad(Ad ad, AdError aderror)
    {
        Log.d(LOG_TAG, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", new Object[] {
            aderror.getCode(), aderror.getMessage()
        });
    }

    public void onAdLoaded(Ad ad, AdProperties adproperties)
    {
        Log.d(LOG_TAG, "Default ad listener called - AdLoaded.");
    }
}
