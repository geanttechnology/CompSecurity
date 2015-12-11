// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import java.util.HashMap;
import java.util.Map;

public final class BadgeType extends Enum
{

    private static final BadgeType $VALUES[];
    public static final BadgeType ADD_ON;
    public static final BadgeType APPS_PROGRAM;
    public static final BadgeType AUTO_RIP;
    public static final BadgeType BEST_SELLER;
    public static final BadgeType CASH_ON_DELIVERY;
    public static final BadgeType FULFILL_BY_AMAZON;
    public static final BadgeType PRIME;
    public static final BadgeType PRIME_FRESH;
    public static final BadgeType PRIME_ONE_DAY;
    public static final BadgeType PRIME_PANTRY;
    public static final BadgeType PRIME_STANDARD;
    public static final BadgeType STARS1;
    public static final BadgeType STARS2;
    public static final BadgeType STARS3;
    public static final BadgeType STARS4;
    private static Map badgeTypes;
    private Integer badgeDescriptionResource;
    private String badgeId;

    private BadgeType(String s, int i, String s1)
    {
        super(s, i);
        badgeId = s1;
        badgeDescriptionResource = null;
    }

    private BadgeType(String s, int i, String s1, int j)
    {
        super(s, i);
        badgeId = s1;
        badgeDescriptionResource = Integer.valueOf(j);
    }

    public static BadgeType getBadgeType(String s)
    {
        return (BadgeType)badgeTypes.get(s);
    }

    public static BadgeType valueOf(String s)
    {
        return (BadgeType)Enum.valueOf(com/amazon/retailsearch/data/BadgeType, s);
    }

    public static BadgeType[] values()
    {
        return (BadgeType[])$VALUES.clone();
    }

    public String getBadgeId()
    {
        return badgeId;
    }

    public Integer getDescriptionResource()
    {
        return badgeDescriptionResource;
    }

    static 
    {
        PRIME = new BadgeType("PRIME", 0, "primeBadge", com.amazon.retailsearch.R.string.prime_eligible);
        PRIME_FRESH = new BadgeType("PRIME_FRESH", 1, "primeFreshBadge", com.amazon.retailsearch.R.string.prime_fresh_eligible);
        PRIME_ONE_DAY = new BadgeType("PRIME_ONE_DAY", 2, "primeOneDayBadge", com.amazon.retailsearch.R.string.prime_one_day_eligible);
        PRIME_PANTRY = new BadgeType("PRIME_PANTRY", 3, "primePantryBadge", com.amazon.retailsearch.R.string.prime_pantry_eligible);
        PRIME_STANDARD = new BadgeType("PRIME_STANDARD", 4, "primeStandardBadge", com.amazon.retailsearch.R.string.prime_standard_eligible);
        ADD_ON = new BadgeType("ADD_ON", 5, "addOnBadge", com.amazon.retailsearch.R.string.addon);
        AUTO_RIP = new BadgeType("AUTO_RIP", 6, "autoRipBadge", com.amazon.retailsearch.R.string.auto_rip_eligible);
        APPS_PROGRAM = new BadgeType("APPS_PROGRAM", 7, "appsProgramBadge", com.amazon.retailsearch.R.string.apps_program_eligible);
        BEST_SELLER = new BadgeType("BEST_SELLER", 8, "bestSellerBadge", com.amazon.retailsearch.R.string.rs_results_best_seller_description);
        STARS1 = new BadgeType("STARS1", 9, "stars1Image");
        STARS2 = new BadgeType("STARS2", 10, "stars2Image");
        STARS3 = new BadgeType("STARS3", 11, "stars3Image");
        STARS4 = new BadgeType("STARS4", 12, "stars4Image");
        FULFILL_BY_AMAZON = new BadgeType("FULFILL_BY_AMAZON", 13, "fbaBadge", com.amazon.retailsearch.R.string.fulfilled_by_amazon);
        CASH_ON_DELIVERY = new BadgeType("CASH_ON_DELIVERY", 14, "codBadge", com.amazon.retailsearch.R.string.cash_on_delivery);
        $VALUES = (new BadgeType[] {
            PRIME, PRIME_FRESH, PRIME_ONE_DAY, PRIME_PANTRY, PRIME_STANDARD, ADD_ON, AUTO_RIP, APPS_PROGRAM, BEST_SELLER, STARS1, 
            STARS2, STARS3, STARS4, FULFILL_BY_AMAZON, CASH_ON_DELIVERY
        });
        badgeTypes = new HashMap();
        BadgeType abadgetype[] = values();
        int j = abadgetype.length;
        for (int i = 0; i < j; i++)
        {
            BadgeType badgetype = abadgetype[i];
            badgeTypes.put(badgetype.getBadgeId(), badgetype);
        }

    }
}
