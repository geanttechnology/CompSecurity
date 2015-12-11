// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;

public class UserActivitySummary
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public int buyingBestOfferCount;
    public int buyingBidEndingSoonCount;
    public int buyingBiddingCount;
    public int buyingFeedbackToSend;
    public int buyingOutbidCount;
    public int buyingPaymentToSend;
    public int buyingPickupReadyCount;
    public int buyingSecondChanceOfferCount;
    public int buyingWatchCount;
    public int buyingWatchEndingSoonCount;
    public int buyingWinningCount;
    public int buyingWonCount;
    public int buyingWonDurationInDays;
    public boolean hasMoreBestOffer;
    public int messagesNewAlertCount;
    public int messagesNewMessageCount;
    public int sellingActiveCount;
    public int sellingBestOfferCount;
    public int sellingDurationInDays;
    public int sellingFeedbackToSend;
    public int sellingPaymentToReceive;
    public int sellingScheduledCount;
    public int sellingSellEndingSoonCount;
    public int sellingShippingNeeded;
    public int sellingSoldCount;
    public int sellingUnsoldCount;
    public CurrencyAmount totalAuctionSellingValue;
    public CurrencyAmount totalSoldValue;
    public CurrencyAmount totalWinningCost;

    public UserActivitySummary()
    {
    }
}
