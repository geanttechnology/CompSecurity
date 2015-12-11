// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.app.Activity;
import android.text.TextUtils;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.kernel.content.EbayContext;

public class BestOfferTracking
{

    private BestOfferTracking()
    {
    }

    public static void trackPage(Activity activity, String s)
    {
        (new TrackingData(s, TrackingType.PAGE_IMPRESSION)).send(activity);
    }

    public static void trackState(Activity activity, String s, Long long1, Long long2, String s1)
    {
        if (activity == null || TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("context and state are required");
        } else
        {
            trackState(new com.ebay.mobile.analytics.model.TrackingData.SendHelper(activity), s, long1, long2, s1);
            return;
        }
    }

    private static void trackState(com.ebay.mobile.analytics.model.TrackingData.SendHelper sendhelper, String s, Long long1, Long long2, String s1)
    {
        TrackingData trackingdata = new TrackingData("BestOfferEvents", TrackingType.EVENT);
        trackingdata.addKeyValuePair("mfls", s);
        if (long1 != null)
        {
            trackingdata.addKeyValuePair("itm", String.valueOf(long1.longValue()));
        }
        if (long2 != null)
        {
            trackingdata.addKeyValuePair("bti", String.valueOf(long2.longValue()));
        }
        trackingdata.addKeyValuePair("ofid", s1);
        sendhelper.send(trackingdata);
    }

    public static void trackState(EbayContext ebaycontext, String s, Long long1, Long long2, String s1)
    {
        if (ebaycontext == null || TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("context and state are required");
        } else
        {
            trackState(new com.ebay.mobile.analytics.model.TrackingData.SendHelper(ebaycontext), s, long1, long2, s1);
            return;
        }
    }
}
