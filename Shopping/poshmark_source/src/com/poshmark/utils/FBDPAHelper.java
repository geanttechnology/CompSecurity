// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMBundle;
import java.math.BigDecimal;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            CheckoutFlowHandler

public class FBDPAHelper
{

    public static String CONTENT_TYPE_PRODUCT = "product";
    public static String PM_EVENT_NAME_COMMENT = "Comment";
    public static String PURCHASE_TYPE_BUNDLE = "bundle";
    public static String PURCHASE_TYPE_OFFER = "offer";
    public static String PURCHASE_TYPE_SINGLE_LISTING = "single";

    public FBDPAHelper()
    {
    }

    private static Bundle getBundleForTracking(ListingSummary listingsummary)
    {
        Bundle bundle = new Bundle();
        bundle.putString("brand", listingsummary.getBrand());
        bundle.putString("category", listingsummary.getCategoryLabel());
        List list = listingsummary.getSubCategoryList();
        if (list != null && list.size() > 0)
        {
            bundle.putString("subcategory", ((MetaItem)list.get(0)).getDisplay());
        }
        bundle.putString("fb_content_type", CONTENT_TYPE_PRODUCT);
        bundle.putString("fb_content_id", listingsummary.getIdAsString());
        bundle.putString("fb_currency", "USD");
        return bundle;
    }

    public static void trackAddToCart(ListingSummary listingsummary, String s)
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
        Bundle bundle = getBundleForTracking(listingsummary);
        bundle.putString("type", s);
        ((AppEventsLogger) (obj)).logEvent("fb_mobile_add_to_cart", listingsummary.getPrice().floatValue(), bundle);
    }

    public static void trackBundlePurchaseInitiated(PMBundle pmbundle)
    {
        if (pmbundle != null)
        {
            pmbundle = pmbundle.getList();
            if (pmbundle != null && pmbundle.size() > 0)
            {
                trackListingPurchaseInitiated((ListingSummary)pmbundle.get(0), PURCHASE_TYPE_BUNDLE);
            }
        }
    }

    public static void trackComment(ListingSummary listingsummary)
    {
        if (listingsummary != null && !PMApplicationSession.GetPMSession().getUserId().equals(listingsummary.getUserId()))
        {
            Object obj = PMApplication.getApplicationObject().getTopActivity();
            obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
            listingsummary = getBundleForTracking(listingsummary);
            ((AppEventsLogger) (obj)).logEvent(PM_EVENT_NAME_COMMENT, listingsummary);
        }
    }

    public static void trackListingLike(ListingSummary listingsummary)
    {
        if (listingsummary != null && !PMApplicationSession.GetPMSession().getUserId().equals(listingsummary.getUserId()))
        {
            Object obj = PMApplication.getApplicationObject().getTopActivity();
            obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
            Bundle bundle = getBundleForTracking(listingsummary);
            ((AppEventsLogger) (obj)).logEvent("fb_mobile_add_to_wishlist", listingsummary.getPrice().floatValue(), bundle);
        }
    }

    public static void trackListingPurchaseInitiated(ListingSummary listingsummary, String s)
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
        Bundle bundle = getBundleForTracking(listingsummary);
        bundle.putString("type", s);
        ((AppEventsLogger) (obj)).logEvent("fb_mobile_initiated_checkout", listingsummary.getPrice().floatValue(), bundle);
    }

    public static void trackListingView(ListingDetails listingdetails, List list)
    {
        if (listingdetails != null && !PMApplicationSession.GetPMSession().getUserId().equals(listingdetails.getUserId()))
        {
            Object obj = PMApplication.getApplicationObject().getTopActivity();
            obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
            Bundle bundle = getBundleForTracking(listingdetails);
            if (list != null && list.size() > 1)
            {
                bundle.putString("vector", (String)list.get(1));
            }
            ((AppEventsLogger) (obj)).logEvent("fb_mobile_content_view", listingdetails.getPrice().floatValue(), bundle);
        }
    }

    public static void trackPurchase(CheckoutFlowHandler checkoutflowhandler, BigDecimal bigdecimal)
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
        checkoutflowhandler = getBundleForTracking(checkoutflowhandler.getListingDetails());
        ((AppEventsLogger) (obj)).logEvent("fb_mobile_purchase", bigdecimal.doubleValue(), checkoutflowhandler);
    }

    public static void trackSearch(String s)
    {
        Object obj = PMApplication.getApplicationObject().getTopActivity();
        obj = AppEventsLogger.newLogger(((Context) (obj)), ((Context) (obj)).getString(0x7f06010b));
        Bundle bundle = new Bundle();
        bundle.putString("fb_content_type", CONTENT_TYPE_PRODUCT);
        bundle.putString("fb_search_string", s);
        ((AppEventsLogger) (obj)).logEvent("fb_mobile_search", bundle);
    }

}
