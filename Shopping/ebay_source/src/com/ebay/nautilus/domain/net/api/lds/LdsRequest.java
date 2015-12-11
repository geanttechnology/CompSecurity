// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsRequestParams

abstract class LdsRequest extends EbayCosRequest
{

    static final String directive = "directive";
    static final String namespace = "http://www.ebay.com/marketplace/listing/v1/services";
    final LdsRequestParams params;

    LdsRequest(String s, LdsRequestParams ldsrequestparams)
    {
        super("ListingDraftService", s);
        iafToken = ldsrequestparams.iafToken;
        marketPlaceId = ldsrequestparams.site.idString;
        params = ldsrequestparams;
    }

    void appendNewDraftValues(XmlSerializer xmlserializer, LdsRequestParams ldsrequestparams)
        throws IOException
    {
        HashMap hashmap;
        hashmap = ldsrequestparams.values;
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "listing");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "Item");
        if (hashmap.containsKey("Listing.Item.Title"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "title", (String)hashmap.get("Listing.Item.Title"));
        }
        if (hashmap.containsKey("Listing.Item.Description"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "description", (String)hashmap.get("Listing.Item.Description"));
        }
        if (hashmap.containsKey("Listing.Item.AddToDescription"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "addToDescription", (String)hashmap.get("Listing.Item.AddToDescription"));
        }
        if (hashmap.containsKey("Listing.Item.ProductInfo.ProductId"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "productInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "productReferenceId", (String)hashmap.get("Listing.Item.ProductInfo.ProductId"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "productInfo");
        }
        for (Iterator iterator = ldsrequestparams.pictureUrls.iterator(); iterator.hasNext(); xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "picture"))
        {
            String s1 = (String)iterator.next();
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "picture");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "url", s1);
        }

        for (Iterator iterator1 = ldsrequestparams.itemSpecifics.iterator(); iterator1.hasNext(); xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "itemSpecific"))
        {
            Object obj1 = (LdsField)iterator1.next();
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "itemSpecific");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", ((LdsField) (obj1)).getIdIndex());
            for (obj1 = ((LdsField) (obj1)).getSelectedValues().iterator(); ((Iterator) (obj1)).hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "value", (String)((Iterator) (obj1)).next())) { }
        }

        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "Item");
        if (hashmap.containsKey("Listing.ConditionDescription"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "conditionDescription", (String)hashmap.get("Listing.ConditionDescription"));
        }
        if (!EbaySite.AU.idString.equals(marketPlaceId) || !ldsrequestparams.listingMode.equals("AddItem") && !ldsrequestparams.listingMode.equals("SellLikeItem")) goto _L2; else goto _L1
_L1:
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "enhancementInfo");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "galleryType", "Gallery");
        if (hashmap.containsKey("Listing.EnhancementInfo.SubTitle"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "subTitle", (String)hashmap.get("Listing.EnhancementInfo.SubTitle"));
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "enhancementInfo");
_L4:
        if (hashmap.containsKey("Listing.Condition"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "condition", (String)hashmap.get("Listing.Condition"));
        }
        if (hashmap.containsKey("Listing.Duration"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "duration", (String)hashmap.get("Listing.Duration"));
        }
        if (hashmap.containsKey("Listing.StartDate"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "startDate", (String)hashmap.get("Listing.StartDate"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "scheduledListing", "true");
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "paymentInfo");
        if (hashmap.containsKey("Listing.PaymentInfo.AcceptedPaymentMethod"))
        {
            String as[] = ((String)hashmap.get("Listing.PaymentInfo.AcceptedPaymentMethod")).split(":");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "acceptedPaymentMethod", as[i]);
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (hashmap.containsKey("Listing.EnhancementInfo.SubTitle"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "enhancementInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "subTitle", (String)hashmap.get("Listing.EnhancementInfo.SubTitle"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "enhancementInfo");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (hashmap.containsKey("Listing.PaymentInfo.PaypalEmailAddress"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "paypalEmailAddress", (String)hashmap.get("Listing.PaymentInfo.PaypalEmailAddress"));
        }
        if (hashmap.containsKey("Listing.PaymentInfo.ImmediatePay"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "immediatePay", (String)hashmap.get("Listing.PaymentInfo.ImmediatePay"));
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "paymentInfo");
        if (hashmap.containsKey("Listing.StartPrice"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "startPrice", (String)hashmap.get("Listing.StartPrice"));
        }
        if (hashmap.containsKey("Listing.Price"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "price", (String)hashmap.get("Listing.Price"));
        }
        if (hashmap.containsKey("Listing.AuctionReservePrice"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "auctionReservePrice", (String)hashmap.get("Listing.AuctionReservePrice"));
        }
        if (hashmap.containsKey("Listing.Quantity"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "quantity", (String)hashmap.get("Listing.Quantity"));
        }
        if (hashmap.containsKey("Listing.BestOffer.BestOfferEnabled") || hashmap.containsKey("Listing.BestOffer.AutoAccept") || hashmap.containsKey("Listing.BestOffer.AutoAcceptAmount") || hashmap.containsKey("Listing.BestOffer.AutoDecline") || hashmap.containsKey("Listing.BestOffer.AutodeclineAmount"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "bestOffer");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "bestOfferEnabled", (String)hashmap.get("Listing.BestOffer.BestOfferEnabled"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autoAccept", (String)hashmap.get("Listing.BestOffer.AutoAccept"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autoAcceptAmount", (String)hashmap.get("Listing.BestOffer.AutoAcceptAmount"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autoDecline", (String)hashmap.get("Listing.BestOffer.AutoDecline"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autodeclineAmount", (String)hashmap.get("Listing.BestOffer.AutodeclineAmount"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "bestOffer");
        }
        if (hashmap.containsKey("Listing.AutoRelistInfo.AutoRelistEnabled"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "autoRelistInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autoRelistEnabled", (String)hashmap.get("Listing.AutoRelistInfo.AutoRelistEnabled"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "autoRelistInfo");
        }
        if (hashmap.containsKey("Listing.CharityInfo.CharityId") || hashmap.containsKey("Listing.CharityInfo.DonationPercent"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "charityInfo");
            if (hashmap.containsKey("Listing.CharityInfo.DonationPercent"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "donationPercent", (String)hashmap.get("Listing.CharityInfo.DonationPercent"));
            }
            if (hashmap.containsKey("Listing.CharityInfo.CharityId"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "charityId", (String)hashmap.get("Listing.CharityInfo.CharityId"));
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "charityInfo");
        }
        if (ldsrequestparams.values.containsKey("Listing.ReturnPolicy.PolicyDetails") || ldsrequestparams.values.containsKey("Listing.ReturnPolicy.ReturnsAccepted") || ldsrequestparams.values.containsKey("Listing.ReturnPolicy.RefundMethod") || ldsrequestparams.values.containsKey("Listing.ReturnPolicy.RefundShipmentPayee") || ldsrequestparams.values.containsKey("Listing.ReturnPolicy.ReturnPeriod") || ldsrequestparams.values.containsKey("Listing.ReturnPolicy.RestockingFeeValue"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "returnPolicy");
            if (hashmap.containsKey("Listing.ReturnPolicy.PolicyDetails"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "policyDetails", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.PolicyDetails"));
            }
            if (hashmap.containsKey("Listing.ReturnPolicy.ReturnsAccepted"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "returnsAccepted", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.ReturnsAccepted"));
            }
            if (hashmap.containsKey("Listing.ReturnPolicy.RefundMethod"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "refundMethod", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.RefundMethod"));
            }
            if (hashmap.containsKey("Listing.ReturnPolicy.RefundShipmentPayee"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "refundShipmentPayee", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.RefundShipmentPayee"));
            }
            if (hashmap.containsKey("Listing.ReturnPolicy.ReturnPeriod"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "returnPeriod", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.ReturnPeriod"));
            }
            if (hashmap.containsKey("Listing.ReturnPolicy.RestockingFeeValue"))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "restockingFeeValue", (String)ldsrequestparams.values.get("Listing.ReturnPolicy.RestockingFeeValue"));
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "returnPolicy");
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "itemLocation");
        if (hashmap.containsKey("Listing.ItemLocation.CountryCode"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "countryCode", (String)ldsrequestparams.values.get("Listing.ItemLocation.CountryCode"));
        }
        if (hashmap.containsKey("Listing.ItemLocation.ZipCode"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "zipCode", (String)ldsrequestparams.values.get("Listing.ItemLocation.ZipCode"));
        }
        if (hashmap.containsKey("Listing.ItemLocation.CityState"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "cityState", (String)ldsrequestparams.values.get("Listing.ItemLocation.CityState"));
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "itemLocation");
        if (hashmap.containsKey("Listing.ListingCurrency"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "listingCurrency", (String)ldsrequestparams.values.get("Listing.ListingCurrency"));
        }
        if (hashmap.containsKey("Listing.Format") && hashmap.get("Listing.Format") != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "format", (String)hashmap.get("Listing.Format"));
        }
        if (hashmap.containsKey("Listing.CategoryInfo[0].Id"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "categoryInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "id", (String)hashmap.get("Listing.CategoryInfo[0].Id"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "type", "primary");
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "categoryInfo");
        }
        if (hashmap.containsKey("Listing.LocalPickupInfo.LocalPickup"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "localPickupInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "localPickup", (String)hashmap.get("Listing.LocalPickupInfo.LocalPickup"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "localPickupInfo");
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "shippingInfo");
        if (hashmap.containsKey("Listing.ShippingInfo.HandlingDuration"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "handlingDuration", (String)hashmap.get("Listing.ShippingInfo.HandlingDuration"));
        }
        if (hashmap.containsKey("Listing.ShippingInfo.DomesticShippingType"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "domesticShippingType", (String)hashmap.get("Listing.ShippingInfo.DomesticShippingType"));
        }
        if (hashmap.containsKey("Listing.ShippingInfo.GlobalShipping"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "globalShipping", (String)hashmap.get("Listing.ShippingInfo.GlobalShipping"));
        }
        Object obj = (String)hashmap.get("Listing.ListingCurrency");
        boolean flag;
        if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "1");
            if (!((String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode")).equals("NotSelected"))
            {
                if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee"))
                {
                    Object obj2 = (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee");
                    XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", ((String) (obj2)), "currencyId", ((String) (obj)));
                    String s3;
                    if (Float.parseFloat(((String) (obj2))) == 0.0F)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "freeShipping", String.valueOf(flag));
                }
                if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping"))
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "freeShipping", (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping"));
                }
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "2");
            if (!((String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee"))
            {
                obj2 = (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee");
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", ((String) (obj2)), "currencyId", ((String) (obj)));
                if (Float.parseFloat(((String) (obj2))) == 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "freeShipping", String.valueOf(flag));
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "3");
            if (!((String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee"))
            {
                obj2 = (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee");
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", ((String) (obj2)), "currencyId", ((String) (obj)));
                if (Float.parseFloat(((String) (obj2))) == 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "freeShipping", String.valueOf(flag));
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "4");
            if (!((String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee"))
            {
                obj2 = (String)hashmap.get("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee");
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", ((String) (obj2)), "currencyId", ((String) (obj)));
                if (Float.parseFloat(((String) (obj2))) == 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "freeShipping", String.valueOf(flag));
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "domesticItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlShippingType"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "intlShippingType", (String)hashmap.get("Listing.ShippingInfo.IntlShippingType"));
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "1");
            if (!((String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee"))
            {
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee"), "currencyId", ((String) (obj)));
            }
            obj2 = ldsrequestparams.intlShipLocations1.iterator();
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                s3 = (String)((Iterator) (obj2)).next();
                if (s3 != null)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "shipToLocation", s3);
                }
            } while (true);
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "2");
            if (!((String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee"))
            {
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee"), "currencyId", ((String) (obj)));
            }
            Iterator iterator2 = ldsrequestparams.intlShipLocations2.iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                String s4 = (String)iterator2.next();
                if (s4 != null)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "shipToLocation", s4);
                }
            } while (true);
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "3");
            if (!((String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee"))
            {
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee"), "currencyId", ((String) (obj)));
            }
            Iterator iterator3 = ldsrequestparams.intlShipLocations3.iterator();
            do
            {
                if (!iterator3.hasNext())
                {
                    break;
                }
                String s5 = (String)iterator3.next();
                if (s5 != null)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "shipToLocation", s5);
                }
            } while (true);
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "4");
            if (!((String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee"))
            {
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee"), "currencyId", ((String) (obj)));
            }
            Iterator iterator4 = ldsrequestparams.intlShipLocations4.iterator();
            do
            {
                if (!iterator4.hasNext())
                {
                    break;
                }
                String s6 = (String)iterator4.next();
                if (s6 != null)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "shipToLocation", s6);
                }
            } while (true);
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "eBayAPISoapServiceCode", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "sortOrderId", "5");
            if (!((String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode")).equals("NotSelected") && hashmap.containsKey("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee"))
            {
                XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "shippingFee", (String)hashmap.get("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee"), "currencyId", ((String) (obj)));
            }
            obj = ldsrequestparams.intlShipLocations5.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s2 = (String)((Iterator) (obj)).next();
                if (s2 != null)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "shipToLocation", s2);
                }
            } while (true);
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "intlItemShippingService");
        }
        if (hashmap.containsKey("Listing.ShippingInfo.ShippingPackageDetails.PackageType"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "irregularPackage", (String)hashmap.get("Listing.ShippingInfo.IrregularPackage"));
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "shippingPackageDetails");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "packageType", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.PackageType"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "packageLength", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "packageWidth", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value"));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "packageDepth", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value"));
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "majorWeight");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "value", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "majorWeight");
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "minorWeight");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "value", (String)hashmap.get("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "minorWeight");
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "shippingPackageDetails");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "shippingInfo");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "listing");
        for (ldsrequestparams = ldsrequestparams.deletedValues.iterator(); ldsrequestparams.hasNext(); xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "deletedField"))
        {
            String s = (String)ldsrequestparams.next();
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "deletedField");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "xPath", s);
        }

        return;
    }

    public URL getRequestUrl()
    {
        Object obj = new StringBuilder(ApiSettings.getUrl(ApiSettings.ldsApi).toString());
        ((StringBuilder) (obj)).append("/").append(getOperationName());
        try
        {
            obj = new URL(((StringBuilder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
    }

    void retrieveMetaData(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "METADATA_FIELDS");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "COMPLETE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
    }
}
