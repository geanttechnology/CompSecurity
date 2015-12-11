// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Price;
import com.groupon.db.models.PricingMetadata;
import java.util.Date;
import roboguice.util.Strings;

public class UrgencyPricingUtils
{
    public static final class UrgencyPricingType extends Enum
    {

        private static final UrgencyPricingType $VALUES[];
        public static final UrgencyPricingType CLEARANCE;
        public static final UrgencyPricingType INTRODUCTORY_PRICE;
        public static final UrgencyPricingType SALE;

        public static UrgencyPricingType safeValueOf(String s)
        {
            if (Strings.notEmpty(s))
            {
                UrgencyPricingType aurgencypricingtype[] = values();
                int j = aurgencypricingtype.length;
                for (int i = 0; i < j; i++)
                {
                    UrgencyPricingType urgencypricingtype = aurgencypricingtype[i];
                    if (Strings.equals(urgencypricingtype.name(), s))
                    {
                        return urgencypricingtype;
                    }
                }

            }
            return null;
        }

        public static UrgencyPricingType valueOf(String s)
        {
            return (UrgencyPricingType)Enum.valueOf(com/groupon/util/UrgencyPricingUtils$UrgencyPricingType, s);
        }

        public static UrgencyPricingType[] values()
        {
            return (UrgencyPricingType[])$VALUES.clone();
        }

        static 
        {
            SALE = new UrgencyPricingType("SALE", 0);
            INTRODUCTORY_PRICE = new UrgencyPricingType("INTRODUCTORY_PRICE", 1);
            CLEARANCE = new UrgencyPricingType("CLEARANCE", 2);
            $VALUES = (new UrgencyPricingType[] {
                SALE, INTRODUCTORY_PRICE, CLEARANCE
            });
        }

        private UrgencyPricingType(String s, int i)
        {
            super(s, i);
        }
    }


    public UrgencyPricingUtils()
    {
    }

    public static UrgencyPricingType getUrgencyPricingAvailability(DealSummary dealsummary)
    {
        return getUrgencyPricingAvailability(dealsummary.derivedPricingMetadataOfferType, dealsummary.derivedPricingMetadataOfferLabelDescriptive, dealsummary.derivedPricingMetadataOfferBeginsAt, dealsummary.derivedPricingMetadataOfferEndsAt);
    }

    public static UrgencyPricingType getUrgencyPricingAvailability(Price price, PricingMetadata pricingmetadata)
    {
        if (price == null || pricingmetadata == null || price.amount == 0)
        {
            return null;
        } else
        {
            return getUrgencyPricingAvailability(pricingmetadata.offerType, pricingmetadata.offerLabelDescriptive, pricingmetadata.offerBeginsAt, pricingmetadata.offerEndsAt);
        }
    }

    public static UrgencyPricingType getUrgencyPricingAvailability(String s, String s1, Date date, Date date1)
    {
        if (!Strings.isEmpty(s) && date != null && !Strings.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((s1 = UrgencyPricingType.safeValueOf(s.toUpperCase())) == null) goto _L1; else goto _L3
_L3:
        Date date2 = new Date();
        if (!date2.after(date)) goto _L5; else goto _L4
_L4:
        s = s1;
        if (date1 == null) goto _L7; else goto _L6
_L6:
        if (!date2.before(date1)) goto _L5; else goto _L8
_L8:
        s = s1;
_L7:
        return s;
_L5:
        s = null;
        if (true) goto _L7; else goto _L9
_L9:
    }

    public static boolean isUrgencyPricingAvailable(UrgencyPricingType urgencypricingtype, boolean flag)
    {
        return flag && urgencypricingtype != null;
    }
}
