// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import android.util.Pair;
import java.util.HashMap;

public class LdsConstants
{

    public static final String BMODE_DISABLED = "DISABLE";
    public static final String BMODE_ENABLED = "ENABLE";
    public static final String BMODE_READ_ONLY = "READ_ONLY";
    public static final String DURATION_GOOD_TIL_CANCELLED = "GTC";
    public static final String DURATION_VALUE_PREFIX = "Days_";
    public static final String ESTIMATED_WEIGHT_CUSTOM = "CUSTOM_WEIGHT";
    public static final String ESTIMATED_WEIGHT_ONE_LB_OR_LESS = "ONE_LB_OR_LESS";
    public static final String FORMAT_CHINESE = "ChineseAuction";
    public static final String FORMAT_CLASSIFIED_AD = "ClassfiedAd";
    public static final String FORMAT_FIXED = "FixedPrice";
    public static final String FORMAT_STORES_FIXED = "StoresFixedPrice";
    public static final int HANDLING_TIME_SAME_DAY = 0;
    public static final String INTL_SHIP_LOCATION_CANADA = "CA";
    public static final String INTL_SHIP_LOCATION_GERMANY = "DE";
    public static final String INTL_SHIP_LOCATION_UK = "GB";
    public static final String INTL_SHIP_LOCATION_WORLDWIDE = "Worldwide";
    public static final int INTL_SHIP_REGION_CANADA = 3;
    public static final int INTL_SHIP_REGION_CUSTOM_LOCATION = 2;
    public static final int INTL_SHIP_REGION_GERMANY = 4;
    public static final int INTL_SHIP_REGION_NOT_SELECTED = 0;
    public static final int INTL_SHIP_REGION_UK = 5;
    public static final int INTL_SHIP_REGION_WORLDWIDE = 1;
    public static final int MAX_PICTURES_ALLOWED_DEFAULT = 12;
    public static final String MODE_ADD_ITEM = "AddItem";
    public static final String MODE_RELIST_ITEM = "RelistItem";
    public static final String MODE_REVISE_ITEM = "ReviseItem";
    public static final String MODE_SELL_LIKE_ITEM = "SellLikeItem";
    public static final String MODE_SELL_SIMILAR_ITEM = "SellSimilarItem";
    public static final String NOT_SELECTED = "NotSelected";
    public static final String PACKAGE_DIMENSIONS = "shippingDimension";
    public static final String PAYPAL = "PayPal";
    public static final String RETURNS_ARE_ACCEPTED = "ReturnsAccepted";
    public static final String RETURNS_NOT_ACCEPTED = "ReturnsNotAccepted";
    public static final String SHIPPING_DOMESTIC_ES_PICKUP = "ES_PickUp";
    public static final String SHIPPING_DOMESTIC_FR_PICKUP = "FR_RemiseEnMainPropre";
    public static final String SHIPPING_DOMESTIC_IE_PICKUP = "IE_CollectionInPersonInternational";
    public static final String SHIPPING_DOMESTIC_IN_PICKUP = "IN_FlatRateCOD";
    public static final String SHIPPING_DOMESTIC_LOCAL_PICKUP = "Pickup";
    public static final String SHIPPING_DOMESTIC_LOCAL_PICKUP_ONLY = "LocalPickUpOnly";
    public static final String SHIPPING_DOMESTIC_UK_PICKUP = "UK_CollectInPerson";
    public static final String SHIPPING_TYPE_CALCULATED = "ACTUAL_RATE";
    public static final String SHIPPING_TYPE_FLAT = "FLAT_RATE";
    public static final String SHIPPING_TYPE_LOCAL_PICKUP = "NOT_SPECIFIED";
    public static final String SHIPPING_TYPE_NOT_SPECIFIED = "NOT_SPECIFIED";
    public static final String UNIT_OF_MEASURE_IMPERIAL = "IMPERIAL";
    public static final HashMap estimatedWeightMap;

    public LdsConstants()
    {
    }

    static 
    {
        estimatedWeightMap = new HashMap();
        estimatedWeightMap.put("ONE_LB_OR_LESS", new Pair(Integer.valueOf(1), Integer.valueOf(0)));
        estimatedWeightMap.put("ONEPLUS_TO_TWO_LBS", new Pair(Integer.valueOf(2), Integer.valueOf(0)));
        estimatedWeightMap.put("TWOPLUS_TO_THREE_LBS", new Pair(Integer.valueOf(3), Integer.valueOf(0)));
        estimatedWeightMap.put("THREEPLUS_TO_FOUR_LBS", new Pair(Integer.valueOf(4), Integer.valueOf(0)));
        estimatedWeightMap.put("FOURPLUS_TO_FIVE_LBS", new Pair(Integer.valueOf(5), Integer.valueOf(0)));
        estimatedWeightMap.put("FIVEPLUS_TO_SIX_LBS", new Pair(Integer.valueOf(6), Integer.valueOf(0)));
        estimatedWeightMap.put("SIXPLUS_TO_SEVEN_LBS", new Pair(Integer.valueOf(7), Integer.valueOf(0)));
        estimatedWeightMap.put("SEVENPLUS_TO_EIGHT_LBS", new Pair(Integer.valueOf(8), Integer.valueOf(0)));
        estimatedWeightMap.put("EIGHTPLUS_TO_NINE_LBS", new Pair(Integer.valueOf(9), Integer.valueOf(0)));
        estimatedWeightMap.put("NINEPLUS_TO_TEN_LBS", new Pair(Integer.valueOf(10), Integer.valueOf(0)));
        estimatedWeightMap.put("ONEHUNDREDONE_GMS_OR_LESS", new Pair(Integer.valueOf(0), Integer.valueOf(100)));
        estimatedWeightMap.put("ONEHUNDREDONE_GMS_TO_TWOHUNDREDFIFTY_GMS", new Pair(Integer.valueOf(0), Integer.valueOf(250)));
        estimatedWeightMap.put("TWOHUNDREDFIFTYONE_GMS_TO_FIVEHUNDRED_GMS", new Pair(Integer.valueOf(0), Integer.valueOf(500)));
        estimatedWeightMap.put("FIVEHUNDRED_GMS_OR_LESS", new Pair(Integer.valueOf(0), Integer.valueOf(500)));
        estimatedWeightMap.put("FIVEHUNDRED_GMS_TO_ONE_KGS", new Pair(Integer.valueOf(1), Integer.valueOf(0)));
        estimatedWeightMap.put("FIVEHUNDREDONE_GMS_TO_ONE_KGS", new Pair(Integer.valueOf(1), Integer.valueOf(0)));
        estimatedWeightMap.put("ONEPLUS_TO_TWO_KGS", new Pair(Integer.valueOf(2), Integer.valueOf(0)));
        estimatedWeightMap.put("TWOPLUS_TO_THREE_KGS", new Pair(Integer.valueOf(3), Integer.valueOf(0)));
        estimatedWeightMap.put("THREEPLUS_TO_FOUR_KGS", new Pair(Integer.valueOf(4), Integer.valueOf(0)));
        estimatedWeightMap.put("FOURPLUS_TO_FIVE_KGS", new Pair(Integer.valueOf(5), Integer.valueOf(0)));
        estimatedWeightMap.put("FIVEPLUS_TO_SIX_KGS", new Pair(Integer.valueOf(6), Integer.valueOf(0)));
        estimatedWeightMap.put("SIXPLUS_TO_SEVEN_KGS", new Pair(Integer.valueOf(7), Integer.valueOf(0)));
        estimatedWeightMap.put("SEVENPLUS_TO_EIGHT_KGS", new Pair(Integer.valueOf(8), Integer.valueOf(0)));
        estimatedWeightMap.put("EIGHTPLUS_TO_NINE_KGS", new Pair(Integer.valueOf(9), Integer.valueOf(0)));
        estimatedWeightMap.put("NINEPLUS_TO_TEN_KGS", new Pair(Integer.valueOf(10), Integer.valueOf(0)));
    }
}
