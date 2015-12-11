// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.List;

public final class PlaceOfferResult
{

    public static final String ACTION_BID = "Bid";
    public static final String ACTION_OFFER_ACCEPT = "Accept";
    public static final String ACTION_OFFER_COUNTER = "Counter";
    public static final String ACTION_OFFER_DECLINE = "Decline";
    public static final String ACTION_OFFER_MAKE = "Offer";
    public static final String ACTION_PURCHASE = "Purchase";
    public String bestOfferId;
    public String bestOfferStatus;
    public String bidTransactionId;
    public ItemCurrency convertedCurrentPrice;
    public ItemCurrency currentPrice;
    public String highBidder;
    public ItemCurrency minimumToBid;
    public boolean reserveMet;
    public String roiUrl;
    public List suggestedBidValues;
    public String transactionId;

    public PlaceOfferResult()
    {
        currentPrice = null;
        convertedCurrentPrice = null;
        minimumToBid = null;
        highBidder = null;
        bidTransactionId = null;
        transactionId = null;
        reserveMet = true;
        roiUrl = null;
        bestOfferId = null;
        bestOfferStatus = null;
        suggestedBidValues = null;
    }
}
