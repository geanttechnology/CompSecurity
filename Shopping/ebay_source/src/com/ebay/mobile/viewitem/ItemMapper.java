// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.ItemCompatibilty;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.ProductListingDetails;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.api.viewlisting.Listing;
import com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext;
import com.ebay.nautilus.domain.net.api.viewlisting.ListingDetails;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemViewData, ViewItemShippingInfo

public class ItemMapper
{
    private class VariationDetails
    {

        final ItemMapper this$0;
        ArrayList variationIds;
        ArrayList variationPictureSets;
        String variationPicturesSpecificName;
        ArrayList variations;

        private VariationDetails()
        {
            this$0 = ItemMapper.this;
            super();
        }

    }


    private static final String URL_REPLACEMENT = "/\\$_7.";
    private static HashMap VLSPaymentMethodMappings;
    private static final Pattern ZOOM_PATTERN_FOR_PRODUCT_URL = Pattern.compile("\\/\\$_6\\.");

    public ItemMapper()
    {
    }

    private static String convertListingStatus(com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum listingstatusenum)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$WarrantyTypeEnum[];
            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.ALMOST_GONE_SIGNAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.LAST_ONE_SIGNAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.DEAL_TIMER_SIGNAL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.OVER_X_SOLD_SIGNAL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.AUTO_IDENTIFIED_DEAL_SIGNAL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.COUNTDOWN_URGENCY_SIGNAL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.CHARITY_DONATION_SIGNAL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_1_HOUR_SIGNAL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_24_HOUR_SIGNAL.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$ListingBuyingContext$ListingHotnessEnum[com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_TOTAL_SIGNAL.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MARK_DOWN_MANAGER_PRICE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.STRIKE_THROUGH_PRICE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.DAILY_DEALS_PRICE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.ORIGINAL_PRICE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MADE_FOR_OUTLET_PRICE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.CATEGORY_DEALS_PRICE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$DiscountPriceTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MINIMUM_ADVERTISED_PRICE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$WarrantyTypeEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$WarrantyTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum.ReplacementWarranty.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$WarrantyTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum.DealerWarranty.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$WarrantyTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum.ManufacturerWarranty.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.BUYER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.SELLER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.BUYER_PAYS_CONDITIONALLY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.SELLER_RIGHT_TO_CANCEL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$ReturnShipmentPayeeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum.SELLER_RIGHT_TO_RETURN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.MONEY_BACK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.EXCHANGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.MERCHANDISE_CREDIT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.REPLACEMENT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$RefundMethodEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum.MONEY_BACK_OR_EXCHANGE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum = new int[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.PENDING_REVIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.PENDING_CS_REVIEW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.SELLER_ON_VACATION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ON_HOLD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ACTIVE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.SOLD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED_BY_SELLER.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED_BY_EBAY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingStatusEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.SCHEDULED.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum = new int[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.CLASSIFIED_AD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.ADFORMAT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.HALF.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$ListingFormatEnum[com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.SECOND_CHANCE_OFFER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum[listingstatusenum.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return "Active";

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            return "Completed";

        case 9: // '\t'
            return "Ended";
        }
    }

    private static String convertListingType(com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum listingformatenum)
    {
        if (listingformatenum == null) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum[listingformatenum.ordinal()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 55
    //                   2 58
    //                   3 61
    //                   4 64
    //                   5 67
    //                   6 70;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        return "Unknown";
_L3:
        return "Chinese";
_L4:
        return "FixedPriceItem";
_L5:
        return "LeadGeneration";
_L6:
        return "AdType";
_L7:
        return "Half";
_L8:
        return "PersonalOffer";
    }

    private static String convertPaymentMethod(String s)
    {
        if (VLSPaymentMethodMappings.containsKey(s))
        {
            return (String)VLSPaymentMethodMappings.get(s);
        } else
        {
            return s;
        }
    }

    private static String convertRefundMethod(Resources resources, com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum refundmethodenum)
    {
        if (resources != null)
        {
            switch (_cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum[refundmethodenum.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return resources.getString(0x7f0708f7);

            case 2: // '\002'
                return resources.getString(0x7f0708f4);

            case 3: // '\003'
                return resources.getString(0x7f0708f6);

            case 4: // '\004'
                return resources.getString(0x7f0708f8);

            case 5: // '\005'
                return resources.getString(0x7f07063d);
            }
        } else
        {
            return refundmethodenum.name();
        }
    }

    private static String convertReturnShipmentPayee(Resources resources, com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum returnshipmentpayeeenum)
    {
        if (resources != null)
        {
            switch (_cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.ReturnShipmentPayeeEnum[returnshipmentpayeeenum.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return resources.getString(0x7f070922);

            case 2: // '\002'
                return resources.getString(0x7f070924);

            case 3: // '\003'
                return resources.getString(0x7f070923);

            case 4: // '\004'
                return resources.getString(0x7f070925);

            case 5: // '\005'
                return resources.getString(0x7f070926);
            }
        } else
        {
            return returnshipmentpayeeenum.name();
        }
    }

    private static ArrayList convertToNameValues(List list)
    {
        ArrayList arraylist = new ArrayList();
        com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect rankedselleraspect;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new NameValue(rankedselleraspect.name.decode(), rankedselleraspect.getValuesAsString())))
        {
            rankedselleraspect = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect)list.next();
        }

        return arraylist;
    }

    private static String convertToRefundMethod(Resources resources, List list)
    {
        DelimitedStringBuilder delimitedstringbuilder = new DelimitedStringBuilder(", ");
        for (int i = 0; i < list.size(); i++)
        {
            delimitedstringbuilder.append(convertRefundMethod(resources, (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RefundMethodEnum)list.get(i)));
        }

        return delimitedstringbuilder.toString();
    }

    private static VariationDetails convertToVariations(List list)
    {
        Object obj = new ItemMapper();
        obj.getClass();
        obj = ((VariationDetails) (obj)). new VariationDetails(null);
        obj.variations = new ArrayList();
        obj.variationPictureSets = new ArrayList();
        obj.variationIds = new ArrayList();
        if (list != null)
        {
            HashSet hashset = new HashSet();
            list = list.iterator();
            while (list.hasNext()) 
            {
                Object obj1 = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation)list.next();
                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).priceSettings != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).priceSettings.price != null)
                {
                    Variation variation = new Variation();
                    variation.setSKU(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).sellerProvidedSKU);
                    variation.setQuantitySold(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).getQuantitySold());
                    variation.setQuantity(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).getQuantityAvailable() + ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).getQuantitySold());
                    variation.setStartPrice(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).priceSettings.price.getAmount());
                    variation.setNameValueList(convertToNameValues(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).aspects));
                    ((VariationDetails) (obj)).variations.add(variation);
                    ((VariationDetails) (obj)).variationIds.add(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).variationId);
                    obj1 = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj1)).aspects.iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect rankedselleraspect = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect)((Iterator) (obj1)).next();
                        Iterator iterator = rankedselleraspect.aspectValues.iterator();
                        while (iterator.hasNext()) 
                        {
                            com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspectValue rankedselleraspectvalue = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspectValue)iterator.next();
                            if (!hashset.contains(rankedselleraspectvalue.value.decode()) && rankedselleraspectvalue.images != null && rankedselleraspectvalue.images.size() > 0)
                            {
                                VariationPictureSet variationpictureset = new VariationPictureSet();
                                variationpictureset.specificName = rankedselleraspectvalue.value.decode();
                                variationpictureset.pictureUrls = new ArrayList();
                                Iterator iterator1 = rankedselleraspectvalue.images.iterator();
                                do
                                {
                                    if (!iterator1.hasNext())
                                    {
                                        break;
                                    }
                                    com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image image = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image)iterator1.next();
                                    if (!TextUtils.isEmpty(image.imageURL))
                                    {
                                        variationpictureset.pictureUrls.add(image.imageURL);
                                    }
                                } while (true);
                                ((VariationDetails) (obj)).variationPictureSets.add(variationpictureset);
                                hashset.add(rankedselleraspectvalue.value.decode());
                                if (((VariationDetails) (obj)).variationPicturesSpecificName == null)
                                {
                                    obj.variationPicturesSpecificName = rankedselleraspect.name.decode();
                                }
                            }
                        }
                    }
                }
            }
        }
        return ((VariationDetails) (obj));
    }

    private static String convertWarrantyType(Resources resources, com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum warrantytypeenum)
    {
        if (resources != null)
        {
            switch (_cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.WarrantyTypeEnum[warrantytypeenum.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return resources.getString(0x7f070bb9);

            case 2: // '\002'
                return resources.getString(0x7f070bb7);

            case 3: // '\003'
                return resources.getString(0x7f070bb8);
            }
        } else
        {
            return warrantytypeenum.name();
        }
    }

    private static long getCategoryId(List list)
    {
        return ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategoryIdentifier)list.get(list.size() - 1)).categoryId;
    }

    private static String getCategoryIdPath(List list)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (list != null)
        {
            obj = obj1;
            if (list.size() > 0)
            {
                obj = new DelimitedStringBuilder(":");
                com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategoryIdentifier categoryidentifier;
                for (list = list.iterator(); list.hasNext(); ((DelimitedStringBuilder) (obj)).appendDelimiterExceptFirstTime().append(categoryidentifier.categoryId))
                {
                    categoryidentifier = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategoryIdentifier)list.next();
                }

                obj = ((DelimitedStringBuilder) (obj)).toString();
            }
        }
        return ((String) (obj));
    }

    private static String getCategoryName(List list)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (list != null)
        {
            obj = obj1;
            if (list.size() > 0)
            {
                obj = new DelimitedStringBuilder(":");
                for (list = list.iterator(); list.hasNext(); ((DelimitedStringBuilder) (obj)).append(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategoryIdentifier)list.next()).name.decode())) { }
                obj = ((DelimitedStringBuilder) (obj)).toString();
            }
        }
        return ((String) (obj));
    }

    private static Integer getQuantityCount(com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail listinghotnessdetail)
    {
        Object obj = null;
        Object obj1 = listinghotnessdetail.getPropertyMap();
        listinghotnessdetail = obj;
        if (obj1 != null)
        {
            listinghotnessdetail = obj;
            if (((Map) (obj1)).size() > 0)
            {
                obj1 = (List)((Map) (obj1)).get("count");
                listinghotnessdetail = obj;
                if (obj1 != null)
                {
                    listinghotnessdetail = obj;
                    if (((List) (obj1)).size() > 0)
                    {
                        obj1 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((List) (obj1)).get(0);
                        Integer integer = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj1)).intValue;
                        listinghotnessdetail = integer;
                        if (integer == null)
                        {
                            listinghotnessdetail = integer;
                            if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj1)).longValue != null)
                            {
                                listinghotnessdetail = Integer.valueOf(((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj1)).longValue.intValue());
                            }
                        }
                    }
                }
            }
        }
        return listinghotnessdetail;
    }

    private static boolean isFinalized(com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum listingstatusenum)
    {
        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum[listingstatusenum.ordinal()])
        {
        default:
            return false;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            return true;
        }
    }

    public static void mapGetViewListingToItem(Context context, ListingDetails listingdetails, Item item, ViewItemViewData viewitemviewdata)
    {
        Resources resources = null;
        if (context != null)
        {
            resources = context.getResources();
        }
        Listing listing = listingdetails.listing;
        ListingBuyingContext listingbuyingcontext = listingdetails.buyingContext;
        com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation itemvariation = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation)listing.itemVariations.get(0);
        item.id = Long.parseLong(listing.listingId);
        EbaySite ebaysite = EbaySite.getInstanceFromMarketplaceId(listing.marketplaceListedOn, listing.listingLocale, EbaySite.US);
        item.site = ebaysite.name;
        item.country = ebaysite.localeCountry;
        item.version = String.valueOf(listing.version);
        item.sku = listing.sellerSKU;
        item.listingStatus = convertListingStatus(listing.listingLifecycle.listingStatus);
        item.listingType = convertListingType(listing.format);
        item.vlsResponseTrackingData = listingdetails.trackingData;
        item.vlsResponseTrackingCorrelationId = listingdetails.trackingCorrelationId;
        item.finalized = isFinalized(listing.listingLifecycle.listingStatus);
        item.title = listing.title;
        item.subTitle = listing.subtitle;
        if (listing.shortDescription != null)
        {
            item.shortDescription = listing.shortDescription.decode();
        }
        if (listing.description != null)
        {
            item.description = listing.description.getSourceContent();
        }
        int i;
        if (listing.tradingSummary.purchaseOptions != null)
        {
            item.bestOfferEnabled = listing.tradingSummary.purchaseOptions.contains(com.ebay.nautilus.domain.net.api.viewlisting.Listing.PurchaseOptionEnum.BEST_OFFER);
            com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image image;
            String s;
            boolean flag1;
            if (MyApp.getDeviceConfiguration().isShoppingCartEnabled() && listing.tradingSummary.purchaseOptions.contains(com.ebay.nautilus.domain.net.api.viewlisting.Listing.PurchaseOptionEnum.ADD_TO_CART))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            item.isCartable = flag1;
        }
        if (itemvariation.bestOfferSettings != null)
        {
            i = itemvariation.bestOfferSettings.bestOfferCount;
        } else
        {
            i = 0;
        }
        item.bestOfferCount = i;
        if (listing.listingClassification != null)
        {
            if (listing.listingClassification.leafCategories != null && listing.listingClassification.leafCategories.size() > 0)
            {
                listingdetails = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingRankedCategory)listing.listingClassification.leafCategories.get(0)).categoryPathFromRoot.categoryIdentifier;
                item.primaryCategoryId = getCategoryId(listingdetails);
                item.primaryCategoryIdPath = getCategoryIdPath(listingdetails);
                item.primaryCategoryName = getCategoryName(listingdetails);
                if (listing.listingClassification.leafCategories.size() > 1)
                {
                    listingdetails = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingRankedCategory)listing.listingClassification.leafCategories.get(1)).categoryPathFromRoot.categoryIdentifier;
                    item.secondaryCategoryId = getCategoryId(listingdetails);
                    item.secondaryCategoryIdPath = getCategoryIdPath(listingdetails);
                    item.secondaryCategoryName = getCategoryName(listingdetails);
                }
            }
            if (listing.listingClassification.product != null)
            {
                if (!TextUtils.isEmpty(listing.listingClassification.product.epId))
                {
                    item.productId = listing.listingClassification.product.epId;
                    item.productIdType = "Reference";
                } else
                if (listing.listingClassification.product.externalIdentities != null)
                {
                    listingdetails = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity)listing.listingClassification.product.externalIdentities.get(0);
                    item.productId = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity) (listingdetails)).externalProductId;
                    if (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentifierTypeEnum.GTIN.equals(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity) (listingdetails)).externalProductIdentifierType))
                    {
                        item.productIdType = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity) (listingdetails)).globalTradeItemNumberType.name();
                    } else
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity) (listingdetails)).externalProductIdentifierType != null)
                    {
                        item.productIdType = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ExternalProductIdentity) (listingdetails)).externalProductIdentifierType.name();
                    }
                }
                item.productRefId = listing.listingClassification.product.epId;
                if (listing.listingClassification.product.description != null)
                {
                    item.productDescription = listing.listingClassification.product.description.getSourceContent();
                }
                if (TextUtils.isEmpty(item.productDescription))
                {
                    item.productListingDetails = new ProductListingDetails();
                    item.productListingDetails.includePrefilledItemInformation = false;
                }
                if (listing.listingClassification.product.images != null && !listing.listingClassification.product.images.isEmpty())
                {
                    for (listingdetails = listing.listingClassification.product.images.iterator(); listingdetails.hasNext(); item.pictureZoomIds.add(image.getZoomImageId()))
                    {
                        image = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image)listingdetails.next();
                        s = ZOOM_PATTERN_FOR_PRODUCT_URL.matcher(image.imageURL).replaceFirst("/\\$_7.");
                        item.pictureUrls.add(s);
                    }

                    item.imageUrl = (String)item.pictureUrls.get(0);
                    Object obj;
                    Object obj1;
                    Object obj2;
                    Iterator iterator;
                    Object obj3;
                    boolean flag;
                    boolean flag2;
                    try
                    {
                        item.thumbnailImage = new URL(item.imageUrl);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ListingDetails listingdetails) { }
                }
                if (listing.listingClassification.product.category != null && listing.listingClassification.product.category.categorySpecificAspect != null)
                {
                    listingdetails = listing.listingClassification.product.category.categorySpecificAspect.iterator();
                    do
                    {
                        if (!listingdetails.hasNext())
                        {
                            break;
                        }
                        obj = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect)listingdetails.next();
                        if (TextUtils.equals(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).globalIdentifier, "Energy Efficiency Rating") && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).categorySpecificAspectValue != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).categorySpecificAspectValue.size() > 0)
                        {
                            obj = new EnergyEfficiencyRating(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).name, ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).abbreviatedName, ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspectValue)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CategorySpecificAspect) (obj)).categorySpecificAspectValue.get(0)).value);
                            if ((!TextUtils.isEmpty(((EnergyEfficiencyRating) (obj)).name.getSourceContent()) || !TextUtils.isEmpty(((EnergyEfficiencyRating) (obj)).abbreviatedName.getSourceContent())) && !TextUtils.isEmpty(((EnergyEfficiencyRating) (obj)).value.getSourceContent()))
                            {
                                item.productEnergyEfficiencyRating = ((EnergyEfficiencyRating) (obj));
                            }
                        }
                    } while (true);
                }
            }
            if (listing.listingClassification.generalCondition != null)
            {
                if (listing.listingClassification.generalCondition.condition != null)
                {
                    try
                    {
                        item.conditionId = Long.valueOf(listing.listingClassification.generalCondition.condition.conditionId).longValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (ListingDetails listingdetails) { }
                }
                if (listing.listingClassification.generalCondition.condition != null && listing.listingClassification.generalCondition.condition.name != null)
                {
                    item.conditionDisplayName = listing.listingClassification.generalCondition.condition.name.decode();
                }
                if (listing.listingClassification.generalCondition.sellerProvidedDescription != null)
                {
                    item.conditionDescription = listing.listingClassification.generalCondition.sellerProvidedDescription.decode();
                }
            }
        }
        if (itemvariation.itemVariationTradingSummary == null) goto _L2; else goto _L1
_L1:
        if (itemvariation.itemVariationTradingSummary.watchCount != null)
        {
            item.watchCount = itemvariation.itemVariationTradingSummary.watchCount.intValue();
        }
        if (!com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(listing.format)) goto _L4; else goto _L3
_L3:
        if (itemvariation.itemVariationTradingSummary.bidCount != null)
        {
            item.bidCount = itemvariation.itemVariationTradingSummary.bidCount.intValue();
        }
        if (itemvariation.itemVariationTradingSummary.reservePriceMet != null)
        {
            flag2 = itemvariation.itemVariationTradingSummary.reservePriceMet.booleanValue();
        } else
        {
            flag2 = true;
        }
        item.isReserveMet = flag2;
        if (itemvariation.itemVariationTradingSummary.reservePriceMet != null)
        {
            item.hasReservePrice = true;
        }
        if (item.bidCount > 0)
        {
            listingdetails = itemvariation.itemVariationTradingSummary.currentBidPrice;
        } else
        {
            listingdetails = itemvariation.priceSettings.startingBidPrice;
        }
        if (listingdetails == null) goto _L6; else goto _L5
_L5:
        item.currentPrice = listingdetails.getAmount();
        item.convertedCurrentPrice = listingdetails.getConvertedAmount();
_L7:
        if (itemvariation.itemVariationTradingSummary.minNextBidPrice != null)
        {
            item.minimumToBid.lowerBound = new CurrencyAmount(itemvariation.itemVariationTradingSummary.minNextBidPrice.value, itemvariation.itemVariationTradingSummary.minNextBidPrice.currency);
            item.minimumToBid.allowLowerBound = true;
        }
_L4:
        if (itemvariation.itemVariationTradingSummary.quickBidOptions != null)
        {
            if (item.powerBidValues == null)
            {
                item.powerBidValues = new ArrayList();
            } else
            {
                item.powerBidValues.clear();
            }
            for (listingdetails = itemvariation.itemVariationTradingSummary.quickBidOptions.iterator(); listingdetails.hasNext(); item.powerBidValues.add(((com.ebay.nautilus.domain.data.BaseCommonType.Amount) (obj)).getAmount()))
            {
                obj = (com.ebay.nautilus.domain.data.BaseCommonType.Amount)listingdetails.next();
            }

        }
        break; /* Loop/switch isn't completed */
_L6:
        if (itemvariation.priceSettings.buyItNowPrice != null)
        {
            item.currentPrice = itemvariation.priceSettings.buyItNowPrice.getAmount();
            item.convertedCurrentPrice = itemvariation.priceSettings.buyItNowPrice.getConvertedAmount();
        }
        if (true) goto _L7; else goto _L2
_L2:
        if (itemvariation.purchasingQuantityTerms != null)
        {
            item.lotSize = itemvariation.purchasingQuantityTerms.lotSize;
        }
        if (listing.userToListingRelationshipSummary != null && com.ebay.nautilus.domain.net.api.viewlisting.Listing.UserToListingRelationshipEnum.HIGH_BIDDER.equals(listing.userToListingRelationshipSummary.userToListingRelationship))
        {
            item.highBidderUserId = MyApp.getPrefs().getCurrentUser();
        }
        if (listing.tradingSummary.purchaseOptions == null || !listing.tradingSummary.purchaseOptions.contains(com.ebay.nautilus.domain.net.api.viewlisting.Listing.PurchaseOptionEnum.BUY_IT_NOW)) goto _L9; else goto _L8
_L8:
        if (viewitemviewdata == null) goto _L11; else goto _L10
_L10:
        flag2 = "STP".equals(viewitemviewdata.pricingTreatment);
        item.isStp = flag2;
        if (!flag2) goto _L13; else goto _L12
_L12:
        item.pricingTreatment = "STP";
        item.originalRetailPrice = viewitemviewdata.originalRetailPrice;
_L11:
        if (itemvariation.priceSettings == null || itemvariation.priceSettings.discountPrice == null) goto _L15; else goto _L14
_L14:
        flag = false;
        listingdetails = itemvariation.priceSettings.discountPrice.iterator();
_L22:
        if (!listingdetails.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice)listingdetails.next();
        i = ((flag) ? 1 : 0);
        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).discountPriceType == null) goto _L17; else goto _L16
_L16:
        _cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum[((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).discountPriceType.ordinal()];
        JVM INSTR tableswitch 1 7: default 1784
    //                   1 2501
    //                   2 2506
    //                   3 2506
    //                   4 2506
    //                   5 2506
    //                   6 2506
    //                   7 2572;
           goto _L18 _L19 _L20 _L20 _L20 _L20 _L20 _L21
_L18:
        i = ((flag) ? 1 : 0);
_L17:
label0:
        {
label1:
            {
                obj = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).getDiscountProperties();
                if (obj == null)
                {
                    break label0;
                }
                obj1 = (List)((Map) (obj)).get("isSoldOneBay");
                if (obj1 == null || ((List) (obj1)).size() <= 0)
                {
                    break label1;
                }
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break label1;
                    }
                    obj2 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((Iterator) (obj1)).next();
                } while (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj2)).booleanValue == null);
                item.dpiSoldOnEbay = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj2)).booleanValue.booleanValue();
            }
label2:
            {
                obj1 = (List)((Map) (obj)).get("isSoldOffeBay");
                if (obj1 == null || ((List) (obj1)).size() <= 0)
                {
                    break label2;
                }
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break label2;
                    }
                    obj2 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((Iterator) (obj1)).next();
                } while (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj2)).booleanValue == null);
                item.dpiSoldOffEbay = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj2)).booleanValue.booleanValue();
            }
            obj = (List)((Map) (obj)).get("TimeLeft");
            if (obj == null || ((List) (obj)).size() <= 0)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                obj1 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((Iterator) (obj)).next();
            } while (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj1)).longValue == null);
            item.hotnessTimeLeft = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj1)).longValue.longValue() * 1000L;
            item.hotnessEndTime = EbayResponse.currentHostTime() + item.hotnessTimeLeft;
        }
        flag = i;
        if (!i) goto _L22; else goto _L15
_L15:
        if (itemvariation.priceSettings != null && itemvariation.priceSettings.buyItNowPrice != null)
        {
            item.buyItNowAvailable = true;
            obj = itemvariation.priceSettings.buyItNowPrice;
            listingdetails = ((ListingDetails) (obj));
            if (itemvariation.priceSettings.price != null)
            {
                listingdetails = ((ListingDetails) (obj));
                if (item.isStp)
                {
                    listingdetails = itemvariation.priceSettings.price;
                }
            }
            item.buyItNowPrice = listingdetails.getAmount();
            item.convertedBuyItNowPrice = listingdetails.getConvertedAmount();
            if (itemvariation.priceSettings.unitPrice != null && ((com.ebay.nautilus.domain.data.BaseCommonType.Amount) (listingdetails)).value > 0.0D)
            {
                item.unitPriceType = itemvariation.priceSettings.unitOfMeasure;
                item.unitPriceQuantity = Double.toString(((com.ebay.nautilus.domain.data.BaseCommonType.Amount) (listingdetails)).value / itemvariation.priceSettings.unitPrice.value);
            }
        }
        if (item.buyItNowPrice != null)
        {
            listingdetails = item.buyItNowPrice;
        } else
        {
            listingdetails = item.currentPrice;
        }
        item.buyItNowPrice = listingdetails;
        if (item.buyItNowPrice != null)
        {
            listingdetails = item.convertedBuyItNowPrice;
        } else
        {
            listingdetails = item.convertedCurrentPrice;
        }
        item.convertedBuyItNowPrice = listingdetails;
          goto _L9
_L13:
        flag2 = "MAP".equals(viewitemviewdata.pricingTreatment);
        item.isMap = flag2;
        if (flag2)
        {
            item.pricingTreatment = "MAP";
            item.dpiMinimumAdvertisedPrice = viewitemviewdata.originalRetailPrice;
        }
        continue; /* Loop/switch isn't completed */
_L19:
        item.isStpButMarkdown = true;
_L20:
        flag = true;
        item.isStp = true;
        item.pricingTreatment = "STP";
        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).discountAmount != null)
        {
            item.dpiMinimumAdvertisedPrice = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).discountAmount.getAmount();
        }
        i = ((flag) ? 1 : 0);
        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).suggestedRetailPrice != null)
        {
            item.originalRetailPrice = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).suggestedRetailPrice.getAmount();
            i = ((flag) ? 1 : 0);
        }
          goto _L17
_L21:
        i = 1;
        item.isMap = true;
        item.pricingTreatment = "MAP";
        item.originalRetailPrice = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice) (obj)).suggestedRetailPrice.getAmount();
          goto _L17
_L9:
        if (listing.tradingSummary.purchaseOptions != null && listing.tradingSummary.purchaseOptions.contains(com.ebay.nautilus.domain.net.api.viewlisting.Listing.PurchaseOptionEnum.ADD_TO_CART))
        {
            item.isListingCartable = true;
        }
        if (itemvariation.priceSettings != null && itemvariation.priceSettings.startingBidPrice != null)
        {
            item.startPrice = itemvariation.priceSettings.startingBidPrice.getAmount();
            item.convertedStartPrice = itemvariation.priceSettings.startingBidPrice.getConvertedAmount();
        }
        if (listing.format == com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.CLASSIFIED_AD && itemvariation.priceSettings.buyItNowPrice != null)
        {
            item.buyItNowPrice = itemvariation.priceSettings.buyItNowPrice.getAmount();
            item.currentPrice = item.buyItNowPrice;
            item.convertedBuyItNowPrice = itemvariation.priceSettings.buyItNowPrice.getConvertedAmount();
            item.convertedCurrentPrice = item.convertedBuyItNowPrice;
        }
        for (listingdetails = listing.itemVariations.iterator(); listingdetails.hasNext();)
        {
            obj = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation)listingdetails.next();
            item.quantitySold = item.quantitySold + ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj)).getQuantitySold();
            item.quantity = item.quantity + (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj)).getQuantityAvailable() + ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ItemVariation) (obj)).getQuantitySold());
        }

label3:
        {
label4:
            {
label5:
                {
                    if (itemvariation.quantityAndAvailabilityByLogisticsPlans != null && itemvariation.quantityAndAvailabilityByLogisticsPlans.size() == 1)
                    {
                        listingdetails = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAndAvailabilityByLogisticsPlans)itemvariation.quantityAndAvailabilityByLogisticsPlans.get(0);
                        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAndAvailabilityByLogisticsPlans) (listingdetails)).quantityAndAvailability != null && com.ebay.nautilus.domain.net.api.viewlisting.Listing.AvailabilityStatusEnum.IN_STOCK.equals(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAndAvailabilityByLogisticsPlans) (listingdetails)).quantityAndAvailability.availabilityStatus) && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAndAvailabilityByLogisticsPlans) (listingdetails)).quantityAndAvailability.availableQuantity == null)
                        {
                            item.ignoreQuantity = true;
                        }
                    }
                    if (listing.listingProperties != null)
                    {
                        listingdetails = (List)listing.getListingProperties().get("IS_PRIVATE_SALE");
                        if (listingdetails != null && listingdetails.size() > 0)
                        {
                            listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.get(0);
                            if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue != null)
                            {
                                item.privateListing = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue.booleanValue();
                            }
                        }
                        listingdetails = (List)listing.getListingProperties().get("IS_MSKU_ITEM");
                        if (listingdetails != null && listingdetails.size() > 0)
                        {
                            listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.get(0);
                            if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue != null)
                            {
                                item.isMultiSku = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue.booleanValue();
                            }
                        }
                        listingdetails = (List)listing.getListingProperties().get("SELLER_PREFERENCE_OF_AVAILABILITY_MESSAGE");
                        if (listingdetails != null && listingdetails.size() > 0)
                        {
                            listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.get(0);
                            if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).stringValue))
                            {
                                if (TextUtils.equals("MORE_THAN_THRESHOLD", ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).stringValue))
                                {
                                    item.quantityAvailableHint = com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint.MORE_THAN;
                                    item.quantityAvailableThreshold = Integer.valueOf(10);
                                    listingdetails = (List)listing.getListingProperties().get("THRESHOLD_FOR_MORETHAN_QUANTITY");
                                    if (listingdetails != null && listingdetails.size() > 0)
                                    {
                                        listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.get(0);
                                        if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).intValue.intValue() != 0)
                                        {
                                            item.quantityAvailableThreshold = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).intValue;
                                        }
                                    }
                                } else
                                if (TextUtils.equals("LIMITED", ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).stringValue))
                                {
                                    item.quantityAvailableHint = com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint.LIMITED;
                                }
                            }
                        }
                        listingdetails = (List)listing.getListingProperties().get("IS_LIVE_AUCTION");
                        if (listingdetails != null && listingdetails.size() > 0)
                        {
                            listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.get(0);
                            if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue != null)
                            {
                                item.isLiveAuction = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (listingdetails)).booleanValue.booleanValue();
                            }
                        }
                    }
                    if (listing.tradingSummary != null)
                    {
                        if (listing.tradingSummary.visitCount != null)
                        {
                            item.hitCount = listing.tradingSummary.visitCount.intValue();
                        }
                        if (listing.tradingSummary.watchCount != null)
                        {
                            item.watchCount = listing.tradingSummary.watchCount.intValue();
                        }
                    }
                    if (listing.listingLifecycle != null)
                    {
                        item.startDate = listing.listingLifecycle.scheduledStartDate.value;
                        if (listing.listingLifecycle.scheduledEndDate != null)
                        {
                            item.endDate = listing.listingLifecycle.scheduledEndDate.value;
                        }
                        item.isActive = com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ACTIVE.equals(listing.listingLifecycle.listingStatus);
                        if (listing.listingLifecycle.timeRemaining != null)
                        {
                            item.timeLeft = Duration.parse(listing.listingLifecycle.timeRemaining.toIso8601());
                        }
                        if (listing.listingLifecycle.listingDuration != null)
                        {
                            item.listingDuration = listing.listingLifecycle.listingDuration.name();
                        }
                        if (listing.listingLifecycle.ancestry != null && listing.listingLifecycle.ancestry.size() > 0)
                        {
                            listingdetails = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingAncestry)listing.listingLifecycle.ancestry.get(0);
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingAncestry) (listingdetails)).childrenListingIds != null && !((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingAncestry) (listingdetails)).childrenListingIds.isEmpty())
                            {
                                item.relistedId = (String)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingAncestry) (listingdetails)).childrenListingIds.get(0);
                            }
                        }
                    }
                    if (listing.compatibilityDetails != null && listing.compatibilityDetails.compatibilityProperties != null)
                    {
                        obj = null;
                        for (obj1 = listing.compatibilityDetails.compatibilityProperties.iterator(); ((Iterator) (obj1)).hasNext();)
                        {
                            obj2 = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem)((Iterator) (obj1)).next();
                            listingdetails = ((ListingDetails) (obj));
                            if (obj == null)
                            {
                                listingdetails = new ArrayList();
                            }
                            obj = new ItemCompatibilty();
                            for (iterator = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem) (obj2)).keySet().iterator(); iterator.hasNext();)
                            {
                                obj3 = (String)iterator.next();
                                if ("FitmentComments".equals(obj3))
                                {
                                    obj3 = (List)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem) (obj2)).get(obj3);
                                    if (obj3 != null && ((List) (obj3)).size() > 0)
                                    {
                                        obj.compatibilityNotes = (String)((List) (obj3)).get(0);
                                    }
                                } else
                                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem) (obj2)).get(obj3) != null && ((List)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem) (obj2)).get(obj3)).size() > 0)
                                {
                                    ((ItemCompatibilty) (obj)).nameValueList.add(new NameValue(((String) (obj3)), (String)((List)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.CompatibilityItem) (obj2)).get(obj3)).get(0)));
                                }
                            }

                            listingdetails.add(obj);
                            obj = listingdetails;
                        }

                        if (obj != null)
                        {
                            item.itemCompatibiltyList = Collections.unmodifiableList(((List) (obj)));
                        }
                    }
                    item.shippingCostsPostalCode = viewitemviewdata.shippingCostsPostalCode;
                    mapShipping(context, listing, item);
                    if (listing.userToListingRelationshipSummary == null);
                    if (listing.termsAndPolicies.trustBadges != null)
                    {
                        listingdetails = listing.termsAndPolicies.trustBadges;
                        item.topRatedListing = com.ebay.nautilus.domain.net.api.viewlisting.Listing.TrustBadgeEnum.TOP_RATED_PLUS_LISTING.equals(listingdetails);
                        item.topRatedSeller = com.ebay.nautilus.domain.net.api.viewlisting.Listing.TrustBadgeEnum.TOP_RATED_SELLER.equals(listingdetails);
                    }
                    if (listing.termsAndPolicies != null && listing.termsAndPolicies.buyerProtectionPolicy != null && listing.termsAndPolicies.buyerProtectionPolicy.buyerProtectionProgram == com.ebay.nautilus.domain.net.api.viewlisting.Listing.BuyerProtectionProgramEnum.EBAY_BUYER_PROTECTION && listing.termsAndPolicies.buyerProtectionPolicy.buyerProtectionStatus == com.ebay.nautilus.domain.net.api.viewlisting.Listing.BuyerProtectionStatusEnum.ELIGIBLE)
                    {
                        item.isBuyerProtectionEligible = true;
                    }
                    if (item.isMultiSku && listing.itemVariations.size() > 0)
                    {
                        listingdetails = convertToVariations(listing.itemVariations);
                        item.variations = ((VariationDetails) (listingdetails)).variations;
                        item.variationPictureSets = ((VariationDetails) (listingdetails)).variationPictureSets;
                        item.variationIds = ((VariationDetails) (listingdetails)).variationIds;
                        item.variationPicturesSpecificName = ((VariationDetails) (listingdetails)).variationPicturesSpecificName;
                    }
                    if (listing.listingClassification.sellerSpecifiedAspect != null)
                    {
                        for (listingdetails = listing.listingClassification.sellerSpecifiedAspect.iterator(); listingdetails.hasNext();)
                        {
                            viewitemviewdata = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect)listingdetails.next();
                            obj = new NameValue();
                            ((NameValue) (obj)).setName(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect) (viewitemviewdata)).name.decode());
                            for (obj1 = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect) (viewitemviewdata)).aspectValues.iterator(); ((Iterator) (obj1)).hasNext(); ((NameValue) (obj)).addValue(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspectValue)((Iterator) (obj1)).next()).value.decode())) { }
                            if (!((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedSellerAspect) (viewitemviewdata)).sameValueForAllItemVariations)
                            {
                                item.variationSpecifics.add(obj);
                            } else
                            {
                                item.itemSpecifics.add(obj);
                            }
                        }

                    }
                    if (listing.images != null && listing.images.size() > 0)
                    {
                        item.pictureUrls.clear();
                        item.pictureZoomIds.clear();
                        for (listingdetails = listing.images.iterator(); listingdetails.hasNext(); item.pictureZoomIds.add(viewitemviewdata.getZoomImageId()))
                        {
                            viewitemviewdata = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image)listingdetails.next();
                            item.pictureUrls.add(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.Image) (viewitemviewdata)).imageURL);
                        }

                        item.imageUrl = (String)item.pictureUrls.get(0);
                        try
                        {
                            item.thumbnailImage = new URL(item.imageUrl);
                        }
                        // Misplaced declaration of an exception variable
                        catch (ListingDetails listingdetails) { }
                    }
                    if (listing.inventoryLocations != null && listing.inventoryLocations.size() > 0)
                    {
                        listingdetails = (com.ebay.nautilus.domain.data.BaseCommonType.Location)listing.inventoryLocations.get(0);
                        if (((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address != null)
                        {
                            viewitemviewdata = new StringBuilder();
                            if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.city))
                            {
                                viewitemviewdata.append(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.city);
                            }
                            if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.stateOrProvince))
                            {
                                if (viewitemviewdata.length() > 0)
                                {
                                    viewitemviewdata.append(", ");
                                }
                                viewitemviewdata.append(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.stateOrProvince);
                            }
                            if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.country))
                            {
                                if (viewitemviewdata.length() > 0)
                                {
                                    viewitemviewdata.append(' ');
                                }
                                viewitemviewdata.append(((com.ebay.nautilus.domain.data.BaseCommonType.Location) (listingdetails)).address.country);
                            }
                            if (viewitemviewdata.length() > 0)
                            {
                                item.location = viewitemviewdata.toString();
                            }
                        }
                    }
                    item.sellerUserId = listing.seller.userIdentifier.username;
                    if (listing.seller.feedbackScore != null)
                    {
                        item.sellerFeedbackScore = listing.seller.feedbackScore.intValue();
                    }
                    if (listing.seller.positiveFeedbackPercentage != null)
                    {
                        item.sellerPositiveFeedbackPercent = listing.seller.positiveFeedbackPercentage.floatValue();
                    }
                    if (listing.seller.hasImage)
                    {
                        item.sellerAvatarUrl = listing.seller.avatarImage.imageURL;
                    } else
                    {
                        item.sellerAvatarUrl = null;
                    }
                    if (listing.seller.businessUser && listing.seller.businessUserExtension != null)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    item.bsDetailsExists = flag2;
                    if (item.bsDetailsExists)
                    {
                        if (listing.seller.firstname != null)
                        {
                            item.bsFirstName = listing.seller.firstname.decode();
                        }
                        if (listing.seller.lastname != null)
                        {
                            item.bsLastName = listing.seller.lastname.decode();
                        }
                        if (listing.seller.businessUserExtension.additionalContactInformation != null)
                        {
                            item.bsAdditionalContactInformation = listing.seller.businessUserExtension.additionalContactInformation.decode();
                        }
                        if (listing.seller.businessUserExtension.businessName != null)
                        {
                            item.bsCompanyName = listing.seller.businessUserExtension.businessName.decode();
                        }
                        if (listing.seller.businessUserExtension.registeredPhone != null)
                        {
                            item.bsPhone = listing.seller.businessUserExtension.registeredPhone.phoneNumber;
                        }
                        item.bsVatId = listing.seller.businessUserExtension.vatId;
                        item.bsFax = listing.seller.businessUserExtension.fax;
                        if (listing.seller.businessUserExtension.legalInvoiceAvailable != null)
                        {
                            item.bsLegalInvoice = listing.seller.businessUserExtension.legalInvoiceAvailable.booleanValue();
                        }
                        if (listing.seller.businessUserExtension.termsAndConditions != null)
                        {
                            item.bsTermsAndConditions = listing.seller.businessUserExtension.termsAndConditions.decode();
                        }
                        item.bsTradeRegistrationNumber = listing.seller.businessUserExtension.tradeRegistrationNumber;
                        item.bsEmail = listing.seller.businessUserExtension.additionalEmailAddress;
                        if (listing.seller.businessUserExtension.vatPercent != null && listing.seller.businessUserExtension.vatPercent.doubleValue() > 0.0D)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        item.isVatIncludedInPrice = flag2;
                        if (listing.seller.businessUserExtension.registeredAddress != null)
                        {
                            item.bsCityName = listing.seller.businessUserExtension.registeredAddress.city;
                            item.bsPostalCode = listing.seller.businessUserExtension.registeredAddress.postalCode;
                            item.bsStateOrProvince = listing.seller.businessUserExtension.registeredAddress.stateOrProvince;
                            item.bsCountryName = listing.seller.businessUserExtension.registeredAddress.country;
                            item.bsStreet1 = listing.seller.businessUserExtension.registeredAddress.addressLine1;
                            item.bsStreet2 = listing.seller.businessUserExtension.registeredAddress.addressLine2;
                        }
                    }
                    if (listing.termsAndPolicies == null)
                    {
                        break label3;
                    }
                    if (listing.termsAndPolicies.returnTerms == null)
                    {
                        break label4;
                    }
                    if (listing.termsAndPolicies.returnTerms.returnInstructions != null)
                    {
                        item.rpDescription = listing.termsAndPolicies.returnTerms.returnInstructions.decode();
                    }
                    if (listing.termsAndPolicies.returnTerms.restockingFeePercent != null)
                    {
                        item.rpRestockingFee = resources.getString(0x7f07091f, new Object[] {
                            String.valueOf(listing.termsAndPolicies.returnTerms.restockingFeePercent)
                        });
                    }
                    if (listing.termsAndPolicies.returnTerms.refundMethod != null && listing.termsAndPolicies.returnTerms.refundMethod.size() > 0)
                    {
                        item.rpRefund = convertToRefundMethod(resources, listing.termsAndPolicies.returnTerms.refundMethod);
                    }
                    item.rpAccepted = Boolean.valueOf(listing.termsAndPolicies.returnTerms.returnsAccepted);
                    if (listing.termsAndPolicies.returnTerms.returnInstructions != null)
                    {
                        item.rpReturnsAccepted = listing.termsAndPolicies.returnTerms.returnInstructions.decode();
                    } else
                    if (item.rpAccepted.booleanValue())
                    {
                        item.rpReturnsAccepted = "ReturnsAccepted";
                    }
                    if (listing.termsAndPolicies.returnTerms.returnPeriod != null)
                    {
                        item.rpReturnsWithin = listing.termsAndPolicies.returnTerms.returnPeriod.toString(resources);
                    }
                    if (listing.termsAndPolicies.returnTerms.returnShipmentPayee != null)
                    {
                        item.rpShippingCostPaidBy = convertReturnShipmentPayee(resources, listing.termsAndPolicies.returnTerms.returnShipmentPayee);
                    }
                    item.isReturnsAccepted = listing.termsAndPolicies.returnTerms.returnsAccepted;
                    if (!item.isReturnsAccepted)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    item.isReturnsNotAccepted = flag2;
                    if (listing.termsAndPolicies.returnTerms.properties == null)
                    {
                        break label4;
                    }
                    listingdetails = (List)listing.termsAndPolicies.returnTerms.getProperties().get("EXTENDED_HOLIDAY_RETURNS");
                    if (listingdetails == null || listingdetails.size() <= 0)
                    {
                        break label5;
                    }
                    listingdetails = listingdetails.iterator();
                    do
                    {
                        if (!listingdetails.hasNext())
                        {
                            break label5;
                        }
                        viewitemviewdata = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.next();
                    } while (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (viewitemviewdata)).booleanValue == null);
                    item.isHolidayReturns = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (viewitemviewdata)).booleanValue.booleanValue();
                }
                if (!item.isHolidayReturns)
                {
                    break label4;
                }
                listingdetails = (List)listing.termsAndPolicies.returnTerms.getProperties().get("EXTENDED_HOLIDAY_RETURNS_DATE");
                if (listingdetails == null || listingdetails.size() <= 0)
                {
                    break label4;
                }
                listingdetails = listingdetails.iterator();
                do
                {
                    if (!listingdetails.hasNext())
                    {
                        break label4;
                    }
                    viewitemviewdata = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)listingdetails.next();
                } while (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (viewitemviewdata)).dateValue == null);
                listingdetails = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (viewitemviewdata)).dateValue;
                if (listingdetails != null && listingdetails.after(new Date(EbayResponse.currentHostTime())))
                {
                    viewitemviewdata = new GregorianCalendar();
                    i = viewitemviewdata.getTimeZone().getRawOffset();
                    viewitemviewdata.setTime(listingdetails);
                    viewitemviewdata.add(14, i * -1);
                    item.holidayReturnsDate = viewitemviewdata.getTime();
                } else
                {
                    item.isHolidayReturns = false;
                }
            }
            if (listing.termsAndPolicies.warrantyTerms != null)
            {
                item.rpWarrantyDuration = listing.termsAndPolicies.warrantyTerms.duration.toString(resources);
                item.rpWarrantyType = convertWarrantyType(resources, listing.termsAndPolicies.warrantyTerms.type);
            }
            if (listing.termsAndPolicies.charityTerms != null)
            {
                item.charity = listing.termsAndPolicies.charityTerms;
            }
            if (listing.termsAndPolicies.paymentTerms != null)
            {
                item.autoPay = listing.termsAndPolicies.paymentTerms.immediatePay;
                item.embeddedMobileCheckoutEnabled = listing.termsAndPolicies.paymentTerms.payPalAccepted;
                if (listing.termsAndPolicies.paymentTerms.paymentMethods != null && listing.termsAndPolicies.paymentTerms.paymentMethods.size() > 0)
                {
                    item.paymentMethods = new ArrayList();
                    for (listingdetails = listing.termsAndPolicies.paymentTerms.paymentMethods.iterator(); listingdetails.hasNext();)
                    {
                        viewitemviewdata = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedPaymentMethod)listingdetails.next();
                        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedPaymentMethod) (viewitemviewdata)).paymentMethodDetail != null && !TextUtils.isEmpty(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedPaymentMethod) (viewitemviewdata)).paymentMethodDetail.paymentMethod))
                        {
                            item.paymentMethods.add(convertPaymentMethod(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.RankedPaymentMethod) (viewitemviewdata)).paymentMethodDetail.paymentMethod));
                        }
                    }

                }
                if (listing.termsAndPolicies.paymentTerms.depositAmount != null)
                {
                    item.depositAmount = listing.termsAndPolicies.paymentTerms.depositAmount.getAmount();
                }
                if (listing.termsAndPolicies.paymentTerms.paymentInstructions != null)
                {
                    item.paymentInstructions = listing.termsAndPolicies.paymentTerms.paymentInstructions.decode();
                }
            }
        }
        if (listing.seller != null && listing.seller.eBayStore != null && listing.seller.eBayStore.onVacation)
        {
            if (listing.seller.eBayStore.vacationMessage != null)
            {
                item.sellerVacationNote = listing.seller.eBayStore.vacationMessage.decode();
            }
            if (TextUtils.isEmpty(item.sellerVacationNote) && resources != null)
            {
                listingdetails = resources.getString(0x7f0709f4);
                if (listing.seller.eBayStore.vacationReturnDate != null)
                {
                    listingdetails = resources.getString(0x7f0709f3, new Object[] {
                        DateFormat.getMediumDateFormat(context).format(listing.seller.eBayStore.vacationReturnDate.value)
                    });
                }
                item.sellerVacationNote = listingdetails;
            }
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.smeSupport) && listing.offers != null && listing.offers.size() > 0)
        {
            listingdetails = null;
            viewitemviewdata = listing.offers.iterator();
            do
            {
                context = listingdetails;
                if (!viewitemviewdata.hasNext())
                {
                    break;
                }
                context = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer)viewitemviewdata.next();
            } while (com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOfferTypeEnum.Unknown.equals(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).type) || TextUtils.isEmpty(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).id) || ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).offerMessageDetail == null || TextUtils.isEmpty(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).offerMessageDetail.textMessage));
            if (context != null)
            {
                item.isSmeOfferAvailable = true;
                item.smeOfferId = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).id;
                item.smeSellerName = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).offerSellerName;
                item.smeOfferMsg = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).offerMessageDetail.textMessage;
                item.smeOfferType = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.SellerOffer) (context)).type.toString();
            }
        }
        if (listing.review != null && listing.review.showReviews && listing.review.reviewCount > 0L && !TextUtils.isEmpty(listing.review.subjectReferenceId))
        {
            item.isProductReviewsAvailable = true;
            item.productReviewCount = listing.review.reviewCount;
            item.productReviewAverageRating = listing.review.averageRating;
            item.productReviewSubjectReferenceId = listing.review.subjectReferenceId;
        }
        if (itemvariation.userToItemVariationRelationshipSummary != null)
        {
            item.watched = itemvariation.userToItemVariationRelationshipSummary.watching;
        }
        if (listingbuyingcontext != null && listingbuyingcontext.signals != null && listingbuyingcontext.signals.size() > 0)
        {
            processHotnessSignals(listingbuyingcontext, item);
        }
        item.isGTC = com.ebay.nautilus.domain.net.api.viewlisting.Listing.ListingDurationEnum.GTC.equals(listing.listingLifecycle.listingDuration);
        if (!item.isGTC && listing.listingLifecycle.timeRemaining != null && listing.listingLifecycle.timeRemaining.value <= 0L || com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED.equals(listing.listingLifecycle.listingStatus) || com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED_BY_EBAY.equals(listing.listingLifecycle.listingStatus) || com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ENDED_BY_SELLER.equals(listing.listingLifecycle.listingStatus))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        item.isAuctionEnded = flag2;
        if (com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE.equals(listing.format) || com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.SECOND_CHANCE_OFFER.equals(listing.format))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        item.isListingTypeBin = flag2;
        item.isListingTypeBid = com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(listing.format);
        if (listing.isBuyItNowOnly() || com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.SECOND_CHANCE_OFFER.equals(listing.format))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        item.isBinOnly = flag2;
        item.isBidOnly = listing.isAuctionOnly();
        item.isBidWithBin = listing.isAuctionWithBuyItNow();
        if (com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.HALF.equals(listing.format) || com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.HALF.equals(listing.format) || item.isGTC || listing.listingLifecycle.scheduledStartDate == null || item.isBinOnly && item.endDate != null && item.endDate.getTime() - EbayResponse.currentHostTime() > 0x5265c00L)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        item.isHideTimeLeft = flag2;
        if ("PersonalOffer".equals(item.listingType) && item.secondChanceOriginalItemId != null)
        {
            context = item.secondChanceOriginalItemId;
        } else
        {
            context = listing.listingId;
        }
        item.idForDraftSource = context;
        if (item.buyerResponsibleForLogistics && item.isLiveAuction && item.shippingInfo != null && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_liveAuctionsShipping))
        {
            item.shippingInfo.orderedOptions = null;
            item.shippingInfo.shipToHomeOptions = null;
            item.shippingInfo.isShipToHomeAvailable = false;
        }
        return;
        if (true) goto _L11; else goto _L23
_L23:
    }

    public static void mapShipping(Context context, Listing listing, Item item)
    {
        if (listing.termsAndPolicies.logisticsTerms != null)
        {
            if (listing.termsAndPolicies.logisticsTerms.supportedLogisticsRegions != null)
            {
                if (listing.termsAndPolicies.logisticsTerms.supportedLogisticsRegions.regionIncluded != null)
                {
                    for (Iterator iterator = listing.termsAndPolicies.logisticsTerms.supportedLogisticsRegions.regionIncluded.iterator(); iterator.hasNext(); item.addShipToOrExclusion((com.ebay.nautilus.domain.data.BaseCommonType.Region)iterator.next(), false)) { }
                }
                if (listing.termsAndPolicies.logisticsTerms.supportedLogisticsRegions.regionExcluded != null)
                {
                    for (Iterator iterator1 = listing.termsAndPolicies.logisticsTerms.supportedLogisticsRegions.regionExcluded.iterator(); iterator1.hasNext(); item.addShipToOrExclusion((com.ebay.nautilus.domain.data.BaseCommonType.Region)iterator1.next(), true)) { }
                }
            }
            if (listing.termsAndPolicies.logisticsTerms.logisticsPlan != null && listing.termsAndPolicies.logisticsTerms.logisticsPlan.size() > 0)
            {
                item.mapLogistics(context, listing.termsAndPolicies.logisticsTerms.logisticsPlan);
                item.shippingInfo.setupTaxTable(listing.termsAndPolicies.applicableTax);
            }
        }
        if (listing.termsAndPolicies != null && listing.termsAndPolicies.logisticsTerms != null)
        {
            if (listing.termsAndPolicies.logisticsTerms.ispuLogisticsPlanOnly != null)
            {
                item.isIspuOnly = listing.termsAndPolicies.logisticsTerms.ispuLogisticsPlanOnly.booleanValue();
            }
            if (listing.termsAndPolicies.logisticsTerms.ebnLogisticsPlanOnly != null)
            {
                item.isEbnOnly = listing.termsAndPolicies.logisticsTerms.ebnLogisticsPlanOnly.booleanValue();
            }
        }
        if (listing.termsAndPolicies != null && listing.termsAndPolicies.logisticsTerms != null && listing.termsAndPolicies.logisticsTerms.buyerResponsibleForLogistics != null)
        {
            item.buyerResponsibleForLogistics = listing.termsAndPolicies.logisticsTerms.buyerResponsibleForLogistics.booleanValue();
        }
    }

    public static void processHotnessSignals(ListingBuyingContext listingbuyingcontext, Item item)
    {
        Object obj;
        com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum alistinghotnessenum[];
        Iterator iterator;
        obj = listingbuyingcontext.signals.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail)((Iterator) (obj)).next();
            if (obj1 != null && !com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.UNKNOWN.equals(((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).signal))
            {
label0:
                switch (_cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum[((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).signal.ordinal()])
                {
                default:
                    break;

                case 1: // '\001'
                    item.isHotnessAlmostGone = true;
                    break;

                case 2: // '\002'
                    item.isHotnessLastOne = true;
                    break;

                case 3: // '\003'
                    item.isHotnessDealTimer = true;
                    break;

                case 4: // '\004'
                    item.isHotnessOverXSold = true;
                    break;

                case 5: // '\005'
                    item.isHotnessAutoIdentified = true;
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).getPropertyMap() == null)
                    {
                        break;
                    }
                    obj1 = (List)((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).getPropertyMap().get("medianPrice");
                    if (obj1 == null || ((List) (obj1)).size() <= 0)
                    {
                        break;
                    }
                    obj1 = ((List) (obj1)).iterator();
                    com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue propertyvalue;
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break label0;
                        }
                        propertyvalue = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((Iterator) (obj1)).next();
                    } while (propertyvalue.amountValue == null);
                    item.hotnessMeanPrice = propertyvalue.amountValue.getAmount();
                    item.hotnessMeanPriceConverted = propertyvalue.amountValue.getConvertedAmount();
                    break;

                case 6: // '\006'
                    item.isHotnessCountdownUrgency = true;
                    break;

                case 7: // '\007'
                    item.isHotnessCharity = true;
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).getPropertyMap() == null)
                    {
                        break;
                    }
                    obj1 = (List)((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj1)).getPropertyMap().get("percent");
                    if (obj1 == null || ((List) (obj1)).size() <= 0)
                    {
                        break;
                    }
                    obj1 = ((List) (obj1)).iterator();
                    com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue propertyvalue1;
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break label0;
                        }
                        propertyvalue1 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((Iterator) (obj1)).next();
                    } while (propertyvalue1.stringValue == null);
                    item.isHotnessCharityAll = propertyvalue1.stringValue.equals("100%");
                    break;
                }
            }
        } while (true);
        obj = null;
        alistinghotnessenum = new com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum[3];
        alistinghotnessenum[0] = com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_1_HOUR_SIGNAL;
        alistinghotnessenum[1] = com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_24_HOUR_SIGNAL;
        alistinghotnessenum[2] = com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.QTY_SOLD_TOTAL_SIGNAL;
        Object obj2 = null;
        iterator = listingbuyingcontext.signals.iterator();
        listingbuyingcontext = obj2;
_L6:
        Object obj3;
        Integer integer;
        com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail listinghotnessdetail;
        int i;
        int j;
        do
        {
            do
            {
                do
                {
                    integer = ((Integer) (obj));
                    obj3 = listingbuyingcontext;
                    if (!iterator.hasNext())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    listinghotnessdetail = (com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail)iterator.next();
                } while (listinghotnessdetail == null || com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum.UNKNOWN.equals(listinghotnessdetail.signal));
                integer = getQuantityCount(listinghotnessdetail);
                obj = integer;
            } while (integer == null);
            obj = integer;
        } while (integer.intValue() <= 0);
        j = alistinghotnessenum.length;
        i = 0;
_L12:
        obj3 = listingbuyingcontext;
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (alistinghotnessenum[i] != listinghotnessdetail.signal) goto _L4; else goto _L3
_L3:
        obj3 = listinghotnessdetail;
_L2:
        obj = integer;
        listingbuyingcontext = ((ListingBuyingContext) (obj3));
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        if (obj3 == null) goto _L8; else goto _L7
_L7:
        _cls1..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessEnum[((com.ebay.nautilus.domain.net.api.viewlisting.ListingBuyingContext.ListingHotnessDetail) (obj3)).signal.ordinal()];
        JVM INSTR tableswitch 8 10: default 540
    //                   8 550
    //                   9 562
    //                   10 574;
           goto _L8 _L9 _L10 _L11
_L8:
        return;
_L4:
        i++;
          goto _L12
_L9:
        item.isHotnessQuantitySoldOneHour = true;
        item.hotnessQuantityCount = integer;
        return;
_L10:
        item.isHotnessQuantitySoldTwentyFourHours = true;
        item.hotnessQuantityCount = integer;
        return;
_L11:
        item.isHotnessQuantitySoldTotal = true;
        item.hotnessQuantityCount = integer;
        return;
    }

    static 
    {
        VLSPaymentMethodMappings = new HashMap();
        VLSPaymentMethodMappings.put("PAYPAL", "PayPal");
        VLSPaymentMethodMappings.put("PAYPAL_NOLINK", "PayPal");
        VLSPaymentMethodMappings.put("PAYPAL_VI", "PayPal");
        VLSPaymentMethodMappings.put("PAISAPAY", "PaisaPayAccepted");
        VLSPaymentMethodMappings.put("PAISAPAY_ESCROW", "PaisaPayEscrow");
        VLSPaymentMethodMappings.put("PAISAPAY_ESCROW_EMI", "PaisaPayEscrowEMI");
        VLSPaymentMethodMappings.put("MONEY_TRANSFER", "MoneyXferAccepted");
        VLSPaymentMethodMappings.put("CIP", "MoneyXferAcceptedInCheckout");
        VLSPaymentMethodMappings.put("CASH_ON_PICKUP", "CashOnPickup");
        VLSPaymentMethodMappings.put("AM_EX", "AmEx");
        VLSPaymentMethodMappings.put("CASH_IN_PERSON", "CashInPerson");
        VLSPaymentMethodMappings.put("GENERIC_CREDIT_CARD", "CCAccepted");
        VLSPaymentMethodMappings.put("DISCOVER", "Discover");
        VLSPaymentMethodMappings.put("INTEGRATED_MCC", "IntegratedMerchantCreditCard");
        VLSPaymentMethodMappings.put("LOAN_CHECK", "LoanCheck");
        VLSPaymentMethodMappings.put("MO_CASHIERS", "MOCC");
        VLSPaymentMethodMappings.put("MONEYBOOKERS", "Moneybookers");
        VLSPaymentMethodMappings.put("OTHER", "Other");
        VLSPaymentMethodMappings.put("OTHER_ONLINE", "OtherOnlinePayments");
        VLSPaymentMethodMappings.put("PAYMATE", "Paymate");
        VLSPaymentMethodMappings.put("SEE_DISCRIPTION", "PaymentSeeDescription");
        VLSPaymentMethodMappings.put("CHECK", "PersonalCheck");
        VLSPaymentMethodMappings.put("POSTAL_TRANSFER", "PostalTransfer");
        VLSPaymentMethodMappings.put("PROPAY", "ProPay");
        VLSPaymentMethodMappings.put("VISA_MASTER", "VisaMC");
        VLSPaymentMethodMappings.put("DIRECT_DEBIT", "ELV");
        VLSPaymentMethodMappings.put("CC", "CCAccepted");
        VLSPaymentMethodMappings.put("CASH_IN_PERSON", "CashInPerson");
        VLSPaymentMethodMappings.put("EMS_ESCROW", "Escrow");
        VLSPaymentMethodMappings.put("BML", "BillMeLater");
        VLSPaymentMethodMappings.put("EBAY_INTERMEDIATED_PAYMENT", "EbayIntermediated");
        VLSPaymentMethodMappings.put("COD_DELIVERY_AFTER_PAID", "PrePayDelivery");
        VLSPaymentMethodMappings.put("PAY_UPON_INVOICE", "PayUponInvoice");
    }
}
