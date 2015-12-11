// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import java.util.HashMap;

public class LogisticsUtil
{

    public static final HashMap sPlanOptionTokenMap;

    private LogisticsUtil()
    {
    }

    static 
    {
        sPlanOptionTokenMap = new HashMap();
        sPlanOptionTokenMap.put("eBayNowImmediateDelivery", "EBN-US-IMMEDIATE");
        sPlanOptionTokenMap.put("eBayNowSameDayDelivery", "EBN-US-SAME-DAY");
        sPlanOptionTokenMap.put("eBayNowNextDayDelivery", "EBN-US-NEXT-DAY");
        sPlanOptionTokenMap.put("eBayNowImmediateShippingClubDelivery", "EBN-US-IMMEDIATE-SC");
        sPlanOptionTokenMap.put("eBayNowSameDayShippingClubDelivery", "EBN-US-SAME-DAY-SC");
        sPlanOptionTokenMap.put("eBayNowNextDayShippingClubDelivery", "EBN-US-NEXT-DAY-SC");
        sPlanOptionTokenMap.put("UK_eBayNowImmediateDelivery", "EBN-UK-IMMEDIATE");
        sPlanOptionTokenMap.put("UK_eBayNowSameDayDelivery", "EBN-UK-SAME-DAY");
        sPlanOptionTokenMap.put("UK_eBayNowNextDayDelivery", "EBN-UK-NEXT-DAY");
        sPlanOptionTokenMap.put("AU_eBayNowImmediateDelivery", "EBN-AU-IMMEDIATE");
        sPlanOptionTokenMap.put("AU_eBayNowSameDayDelivery", "EBN-AU-SAME-DAY");
        sPlanOptionTokenMap.put("AU_eBayNowNextDayDelivery", "EBN-AU-NEXT-DAY");
    }
}
