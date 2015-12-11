// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Fragment;
import android.content.Intent;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.bestoffer.BestOfferInput;
import com.ebay.mobile.bestoffer.BuyerMakeOfferActivity;
import com.ebay.mobile.bestoffer.BuyerRespondToCounterofferActivity;
import com.ebay.mobile.bestoffer.SellerRespondToOfferActivity;
import com.ebay.mobile.bestoffer.SellerReviewOffersActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.BestOffer;
import java.util.ArrayList;

public class ViewItemFragmentBestOfferUtil
{

    private ViewItemFragmentBestOfferUtil()
    {
    }

    public static void makeBestOffer(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, Double double1, int i, String s, String s1)
    {
        BestOfferInput bestofferinput = new BestOfferInput();
        if (double1 != null && double1.doubleValue() > 0.0D)
        {
            bestofferinput.bidAmount = double1;
        }
        double1 = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        bestofferinput.quantity = ((BestOffer) (double1)).quantity;
        bestofferinput.terms = ((BestOffer) (double1)).buyerMessage;
        if (item.isSeller)
        {
            bestofferinput.terms = ((BestOffer) (double1)).sellerMessage;
        }
        double1 = new Intent(fragment.getActivity(), com/ebay/mobile/bestoffer/BuyerMakeOfferActivity);
        double1.putExtra("item_view_id", item.id);
        double1.putExtra("item_view_tx_id", item.transactionId);
        double1.putExtra("view_item_view_data", viewitemviewdata);
        double1.putExtra("input", bestofferinput);
        double1.putExtra("com.ebay.mobile.tracking.BidSource", s);
        double1.putExtra("com.ebay.mobile.tracking.Referrer", s1);
        fragment.startActivityForResult(double1, i);
    }

    public static void reviewOffer(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, boolean flag, int i, String s, String s1)
    {
        String s2 = com.ebay.mobile.bestoffer.BuyerRespondToCounterofferActivity.BuyerRespondStage.VIEW_OFFER.toString();
        if (flag)
        {
            s2 = com.ebay.mobile.bestoffer.SellerRespondToOfferActivity.SellerRespondStage.VIEW_OFFER.toString();
        }
        setupAndStartActivity(fragment, item, viewitemviewdata, flag, s, s1, s2, i);
    }

    private static void setupAndStartActivity(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, boolean flag, String s, String s1, String s2, int i)
    {
        BestOffer bestoffer = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        Object obj = com/ebay/mobile/bestoffer/BuyerRespondToCounterofferActivity;
        if (flag && item.offers.size() > 1)
        {
            SellerReviewOffersActivity.StartActivity(fragment.getActivity(), viewitemviewdata, i);
            return;
        }
        if (flag)
        {
            obj = com/ebay/mobile/bestoffer/SellerRespondToOfferActivity;
        }
        obj = new Intent(fragment.getActivity(), ((Class) (obj)));
        ((Intent) (obj)).putExtra("item_view_id", item.id);
        ((Intent) (obj)).putExtra("item_view_tx_id", item.transactionId);
        ((Intent) (obj)).putExtra("view_item_view_data", viewitemviewdata);
        ((Intent) (obj)).putExtra("offer", bestoffer);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s1);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.BidSource", s);
        ((Intent) (obj)).putExtra("stage", s2);
        fragment.startActivityForResult(((Intent) (obj)), i);
    }
}
