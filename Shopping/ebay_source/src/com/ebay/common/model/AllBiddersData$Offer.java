// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.common.model:
//            AllBiddersData

public static class User
{
    public static class BiddingSummary
    {

        public int bidActivityWithSeller;
        public int bidRetractions;
        public int bidsToUniqueCategories;
        public int bidsToUniqueSellers;
        public List itemBidDetails;
        public String summaryDays;
        public int totalBids;

        public BiddingSummary()
        {
            itemBidDetails = new ArrayList();
        }
    }

    public static class BuyerInfo
    {

        public ShippingAddress shippingAddress;

        public BuyerInfo()
        {
            shippingAddress = new ShippingAddress();
        }
    }

    public static class ItemBidDetail
    {

        public int bidCount;
        public String categoryId;
        public String itemId;
        public Date lastBidTime;
        public String sellerId;

        public ItemBidDetail()
        {
        }
    }

    public static class ShippingAddress
    {

        public String country;
        public String postalCode;

        public ShippingAddress()
        {
        }
    }

    public static class User
    {

        public boolean IdVerified;
        public boolean aboutMePage;
        public BiddingSummary biddingSummary;
        public BuyerInfo buyerInfo;
        public boolean eBayGoodStanding;
        public String email;
        public boolean feedbackPrivate;
        public String feedbackRatingStar;
        public int feedbackScore;
        public boolean newUser;
        public float positiveFeedbackPercent;
        public Date registrationDate;
        public String site;
        public String status;
        public boolean userAnonymized;
        public String userId;
        public boolean userIdChanged;
        public Date userIdLastChanged;
        public String vatStatus;

        public User()
        {
            biddingSummary = new BiddingSummary();
            buyerInfo = new BuyerInfo();
        }
    }


    public String action;
    public int bidCount;
    public ItemCurrency convertedPrice;
    public String currency;
    public ItemCurrency highestBid;
    public ItemCurrency maxBid;
    public ItemCurrency myMaxBid;
    public int quantity;
    public boolean secondChanceEnabled;
    public String siteCurrency;
    public Date timeBid;
    public User user;

    public BuyerInfo()
    {
        user = new User();
    }
}
