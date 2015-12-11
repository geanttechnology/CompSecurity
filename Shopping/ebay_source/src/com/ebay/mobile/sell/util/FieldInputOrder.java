// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.util;

import com.ebay.nautilus.domain.data.LdsError;
import java.util.ArrayList;
import java.util.Iterator;

public class FieldInputOrder
{

    private static ArrayList order;

    public FieldInputOrder()
    {
    }

    public static LdsError getFirstError(ArrayList arraylist)
    {
        if (arraylist != null && !arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((LdsError) (obj));
_L2:
        obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = ((ArrayList) (obj));
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (LdsError)iterator.next();
            if (arraylist == null)
            {
                arraylist = ((ArrayList) (obj));
            } else
            {
                String s1 = ((LdsError) (arraylist)).inputRefId;
                String s = s1;
                if (s1 != null)
                {
                    s = s1;
                    if (s1.contains("Listing.Item.Picture"))
                    {
                        s = "Listing.Item.Picture";
                    }
                }
                String s2 = ((LdsError) (obj)).inputRefId;
                s1 = s2;
                if (s2 != null)
                {
                    s1 = s2;
                    if (s2.contains("Listing.Item.Picture"))
                    {
                        s1 = "Listing.Item.Picture";
                    }
                }
                int i = order.indexOf(s);
                int j = order.indexOf(s1);
                if (i != -1 || j != -1)
                {
                    if (i == -1 && j != -1)
                    {
                        arraylist = ((ArrayList) (obj));
                    } else
                    if (j != -1 && j < i)
                    {
                        arraylist = ((ArrayList) (obj));
                    }
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        order = new ArrayList();
        order.add("Listing.Item.ProductInfo.StockPhoto");
        order.add("Listing.Item.Picture");
        order.add("Listing.Item.Title");
        order.add("Listing.EnhancementInfo.SubTitle");
        order.add("Listing.CategoryInfo[0].Id");
        order.add("Listing.Condition");
        order.add("Listing.Item.ItemSpecific");
        order.add("Listing.Item.Description");
        order.add("Listing.Item.AddToDescription");
        order.add("Listing.Format");
        order.add("Listing.StartPrice");
        order.add("Listing.Price");
        order.add("Listing.AuctionReservePrice");
        order.add("Listing.Quantity");
        order.add("Listing.BestOffer.BestOfferEnabled");
        order.add("Listing.BestOffer.AutoAccept");
        order.add("Listing.BestOffer.AutoAcceptAmount");
        order.add("Listing.BestOffer.AutoDecline");
        order.add("Listing.BestOffer.AutodeclineAmount");
        order.add("Listing.Duration");
        order.add("Listing.ScheduledListing");
        order.add("Listing.StartDate");
        order.add("Listing.StartDateDay");
        order.add("Listing.ShippingInfo.DomesticShippingType");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.PackageType");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value");
        order.add("shippingDimension");
        order.add("Listing.ShippingInfo.IrregularPackage");
        order.add("Listing.ShippingPackageDetails.EstimatedWeight");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value");
        order.add("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee");
        order.add("Listing.ShippingInfo.IntlShippingType");
        order.add("Listing.ShippingInfo.GlobalShipping");
        order.add("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee");
        order.add("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee");
        order.add("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee");
        order.add("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee");
        order.add("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode");
        order.add("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee");
        order.add("Listing.ShippingInfo.ShipToLocation");
        order.add("Listing.PaymentInfo.AcceptedPaymentMethod");
        order.add("Listing.PaymentInfo.ImmediatePay");
        order.add("Listing.PaymentInfo.PaypalEmailAddress");
        order.add("Listing.ShippingInfo.HandlingDuration");
        order.add("Listing.ItemLocation.CountryCode");
        order.add("Listing.ItemLocation.ZipCode");
        order.add("Listing.ItemLocation.CityState");
        order.add("Listing.ReturnPolicy.ReturnsAccepted");
        order.add("Listing.ReturnPolicy.ReturnPeriod");
        order.add("Listing.ReturnPolicy.RefundMethod");
        order.add("Listing.ReturnPolicy.RefundShipmentPayee");
        order.add("Listing.ReturnPolicy.PolicyDetails");
    }
}
