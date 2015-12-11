// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public final class EbayDetail
    implements Serializable
{
    public static final class ListingPriceDetails
        implements Serializable
    {

        public CurrencyAmount startPrice;

        public String toString()
        {
            return startPrice.toString();
        }

        public ListingPriceDetails()
        {
        }
    }

    public static final class ReturnPolicyDetails
        implements Serializable
    {

        public ArrayList refund;
        public ArrayList returnsAccepted;
        public ArrayList returnsWithin;
        public ArrayList shippingCostPaidBy;

        public static CharSequence[] getEntries(ArrayList arraylist)
        {
            CharSequence acharsequence[] = new CharSequence[arraylist.size()];
            for (int i = 0; i < arraylist.size(); i++)
            {
                acharsequence[i] = ((ReturnPolicyOption)arraylist.get(i)).description;
            }

            return acharsequence;
        }

        public static CharSequence[] getEntryValues(ArrayList arraylist)
        {
            CharSequence acharsequence[] = new CharSequence[arraylist.size()];
            for (int i = 0; i < arraylist.size(); i++)
            {
                acharsequence[i] = ((ReturnPolicyOption)arraylist.get(i)).token;
            }

            return acharsequence;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder("Return Policy\n");
            stringbuilder.append("Refunds").append("\n");
            for (Iterator iterator = refund.iterator(); iterator.hasNext(); stringbuilder.append((ReturnPolicyOption)iterator.next())) { }
            stringbuilder.append("ReturnsAccepted").append("\n");
            for (Iterator iterator1 = returnsAccepted.iterator(); iterator1.hasNext(); stringbuilder.append((ReturnPolicyOption)iterator1.next())) { }
            stringbuilder.append("ReturnsWithin").append("\n");
            for (Iterator iterator2 = returnsWithin.iterator(); iterator2.hasNext(); stringbuilder.append((ReturnPolicyOption)iterator2.next())) { }
            stringbuilder.append("ShippingCostPaidBy").append("\n");
            for (Iterator iterator3 = shippingCostPaidBy.iterator(); iterator3.hasNext(); stringbuilder.append((ReturnPolicyOption)iterator3.next())) { }
            return stringbuilder.toString();
        }

        public ReturnPolicyDetails()
        {
            refund = new ArrayList();
            returnsAccepted = new ArrayList();
            returnsWithin = new ArrayList();
            shippingCostPaidBy = new ArrayList();
        }
    }

    public static final class ReturnPolicyOption
        implements Serializable
    {

        public String description;
        public String token;

        public String toString()
        {
            return (new StringBuilder(description)).append(":").append(token).append("\n").toString();
        }

        public ReturnPolicyOption()
        {
        }
    }

    public static final class ShippingServiceDetail
        implements Serializable
    {

        public String description;
        public String shippingCarrier;
        public String shippingCategory;
        public String shippingService;

        public ShippingServiceDetail()
        {
        }
    }


    public ListingPriceDetails auctionDetails;
    public ListingPriceDetails fixedPriceDetails;
    public ReturnPolicyDetails returnPolicyDetails;
    public ArrayList shippingServiceDetails;

    public EbayDetail()
    {
        shippingServiceDetails = new ArrayList();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("auctionDetails: ").append(auctionDetails).append("\n");
        stringbuilder.append("fixedPriceDetails: ").append(fixedPriceDetails).append("\n");
        stringbuilder.append("returnPolicyDetails: ").append(returnPolicyDetails).append("\n");
        stringbuilder.append("shippingServiceDetails: ").append(shippingServiceDetails).append("\n");
        return stringbuilder.toString();
    }
}
