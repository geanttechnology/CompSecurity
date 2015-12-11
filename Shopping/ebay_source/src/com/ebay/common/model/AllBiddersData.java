// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AllBiddersData extends BaseApiResponse
    implements Parcelable
{
    public static class Offer
    {

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

        public Offer()
        {
            user = new User();
        }
    }

    public static class Offer.BiddingSummary
    {

        public int bidActivityWithSeller;
        public int bidRetractions;
        public int bidsToUniqueCategories;
        public int bidsToUniqueSellers;
        public List itemBidDetails;
        public String summaryDays;
        public int totalBids;

        public Offer.BiddingSummary()
        {
            itemBidDetails = new ArrayList();
        }
    }

    public static class Offer.BuyerInfo
    {

        public Offer.ShippingAddress shippingAddress;

        public Offer.BuyerInfo()
        {
            shippingAddress = new Offer.ShippingAddress();
        }
    }

    public static class Offer.ItemBidDetail
    {

        public int bidCount;
        public String categoryId;
        public String itemId;
        public Date lastBidTime;
        public String sellerId;

        public Offer.ItemBidDetail()
        {
        }
    }

    public static class Offer.ShippingAddress
    {

        public String country;
        public String postalCode;

        public Offer.ShippingAddress()
        {
        }
    }

    public static class Offer.User
    {

        public boolean IdVerified;
        public boolean aboutMePage;
        public Offer.BiddingSummary biddingSummary;
        public Offer.BuyerInfo buyerInfo;
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

        public Offer.User()
        {
            biddingSummary = new Offer.BiddingSummary();
            buyerInfo = new Offer.BuyerInfo();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AllBiddersData createFromParcel(Parcel parcel)
        {
            return (AllBiddersData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/AllBiddersData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AllBiddersData[] newArray(int i)
        {
            return new AllBiddersData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String highBidder;
    public ItemCurrency highestBid;
    public String listingStatus;
    public final List offers = new ArrayList();

    public AllBiddersData()
    {
    }

    public int countBidders()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = offers.iterator(); iterator.hasNext(); hashset.add(((Offer)iterator.next()).user.userId)) { }
        return hashset.size();
    }

}
