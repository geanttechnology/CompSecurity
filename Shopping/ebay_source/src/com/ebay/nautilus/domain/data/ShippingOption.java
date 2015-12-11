// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ShippingOption
{
    public static class ShippingAttributes
    {

        public ShippingCostPlan.Cost carrierInsuranceLimit;
        public boolean carrierInsuranceSupported;
        public boolean carrierInsuranceSuppported;
        public boolean dimensionSupported;
        public String insMessage;
        public ShippingLabelPackage.Specs.Weight maxWeightAllowed;
        public String packageName;
        public int serviceDisplayOrder;
        public String serviceInfo;
        public String serviceLongName;
        public String serviceName;
        public String sigConMessage;
        public ArrayList sigConOptionsSupported;
        public boolean signatureConfirmationRequired;
        public boolean signatureConfirmationSupported;
        public boolean weightSupported;

        public ShippingAttributes()
        {
            sigConOptionsSupported = new ArrayList();
        }
    }

    public static class ShippingAttributes.ShippingConfirmationOptions
    {

        public String optionDisplayValue;
        public String optionToken;

        public ShippingAttributes.ShippingConfirmationOptions()
        {
        }
    }

    public static final class ShippingCarrierType extends Enum
    {

        private static final ShippingCarrierType $VALUES[];
        public static final ShippingCarrierType FEDEX;
        public static final ShippingCarrierType INVALID;
        public static final ShippingCarrierType USPS;

        public static ShippingCarrierType valueOf(String s)
        {
            return (ShippingCarrierType)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingOption$ShippingCarrierType, s);
        }

        public static ShippingCarrierType[] values()
        {
            return (ShippingCarrierType[])$VALUES.clone();
        }

        static 
        {
            USPS = new ShippingCarrierType("USPS", 0);
            FEDEX = new ShippingCarrierType("FEDEX", 1);
            INVALID = new ShippingCarrierType("INVALID", 2);
            $VALUES = (new ShippingCarrierType[] {
                USPS, FEDEX, INVALID
            });
        }

        private ShippingCarrierType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ShippingCostPlan
    {

        public Cost cost;
        public ArrayList costLineItems;
        public String type;

        public CostLineItems getPostageCostLineItem()
        {
            for (Iterator iterator = costLineItems.iterator(); iterator.hasNext();)
            {
                CostLineItems costlineitems = (CostLineItems)iterator.next();
                if (costlineitems.lineItemName.equals("POSTAGE_COST"))
                {
                    return costlineitems;
                }
            }

            return null;
        }

        public ShippingCostPlan()
        {
            costLineItems = new ArrayList();
        }
    }

    public static class ShippingCostPlan.Cost
    {

        public String currency;
        public double value;

        public ShippingCostPlan.Cost()
        {
        }
    }

    public static class ShippingCostPlan.CostLineItems
    {

        public ShippingCostPlan.Cost lineItemCost;
        public String lineItemName;

        public ShippingCostPlan.CostLineItems()
        {
        }
    }

    public static final class ShippingCostPlan.CostPlanTypes extends Enum
    {

        private static final ShippingCostPlan.CostPlanTypes $VALUES[];
        public static final ShippingCostPlan.CostPlanTypes DISCOUNTED;
        public static final ShippingCostPlan.CostPlanTypes RETAIL;

        public static ShippingCostPlan.CostPlanTypes valueOf(String s)
        {
            return (ShippingCostPlan.CostPlanTypes)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingOption$ShippingCostPlan$CostPlanTypes, s);
        }

        public static ShippingCostPlan.CostPlanTypes[] values()
        {
            return (ShippingCostPlan.CostPlanTypes[])$VALUES.clone();
        }

        static 
        {
            RETAIL = new ShippingCostPlan.CostPlanTypes("RETAIL", 0);
            DISCOUNTED = new ShippingCostPlan.CostPlanTypes("DISCOUNTED", 1);
            $VALUES = (new ShippingCostPlan.CostPlanTypes[] {
                RETAIL, DISCOUNTED
            });
        }

        private ShippingCostPlan.CostPlanTypes(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ShippingDeliveryEstimates
    {

        public String maxDate;
        public int maxDays;
        public String minDate;
        public int minDays;
        public boolean supportNonBusinessDays;

        public ShippingDeliveryEstimates()
        {
        }
    }

    public static class ShippingKey
    {

        public ShippingCarrierType carrier;
        public String packageType;
        public String service;

        public ShippingKey()
        {
        }
    }


    public ShippingAttributes attributes;
    public ArrayList availableShippingDates;
    public ArrayList costPlans;
    public ShippingDeliveryEstimates deliveryEstimate;
    public boolean selected;
    public ShippingKey shippingKey;

    public ShippingOption()
    {
        availableShippingDates = new ArrayList();
        costPlans = new ArrayList();
    }

    public String getEstimatedDeliveryDateString(Context context)
    {
        if (TextUtils.isEmpty(deliveryEstimate.minDate) && TextUtils.isEmpty(deliveryEstimate.maxDate)) goto _L2; else goto _L1
_L1:
        Object obj;
        Long long1;
        obj = null;
        long1 = null;
        long l = EbayDateUtils.parseIso8601DateTime(deliveryEstimate.minDate).getTime();
        obj = Long.valueOf(l);
_L10:
        l = EbayDateUtils.parseIso8601DateTime(deliveryEstimate.maxDate).getTime();
        long1 = Long.valueOf(l);
_L8:
        Object obj1 = null;
        if (long1 == null || obj == null) goto _L4; else goto _L3
_L3:
        obj = DateUtils.formatDateRange(context, ((Long) (obj)).longValue(), long1.longValue(), 0x10018);
_L6:
        return ((String) (obj));
_L4:
        if (obj != null)
        {
            return DateUtils.formatDateTime(context, ((Long) (obj)).longValue(), 0x10018);
        }
        obj = obj1;
        if (long1 == null) goto _L6; else goto _L5
_L5:
        return DateUtils.formatDateTime(context, long1.longValue(), 0x10018);
_L2:
        return null;
        ParseException parseexception;
        parseexception;
        if (true) goto _L8; else goto _L7
_L7:
        parseexception;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
