// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.util;

import android.content.Context;
import java.util.HashMap;

public class ListingFees
{

    private static final HashMap LISTING_FEES;

    public ListingFees()
    {
    }

    public static String getCaption(Context context, String s)
    {
        Integer integer = (Integer)LISTING_FEES.get(s);
        if (integer == null)
        {
            return s;
        } else
        {
            return context.getString(integer.intValue());
        }
    }

    static 
    {
        LISTING_FEES = new HashMap();
        LISTING_FEES.put("GalleryFee", Integer.valueOf(0x7f0703fa));
        LISTING_FEES.put("GalleryPlusFee", Integer.valueOf(0x7f0703fb));
        LISTING_FEES.put("FeaturedGalleryFee", Integer.valueOf(0x7f0703f8));
        LISTING_FEES.put("PhotoFee", Integer.valueOf(0x7f070402));
        LISTING_FEES.put("ReserveFee", Integer.valueOf(0x7f070407));
        LISTING_FEES.put("HighLightFee", Integer.valueOf(0x7f0703fe));
        LISTING_FEES.put("BuyItNowFee", Integer.valueOf(0x7f0703f3));
        LISTING_FEES.put("ListingDesignerFee", Integer.valueOf(0x7f070401));
        LISTING_FEES.put("FeaturedFee", Integer.valueOf(0x7f0703f7));
        LISTING_FEES.put("BoldFee", Integer.valueOf(0x7f0703f1));
        LISTING_FEES.put("CategoryFeaturedFee", Integer.valueOf(0x7f0703f4));
        LISTING_FEES.put("InsertionFee", Integer.valueOf(0x7f0703ff));
        LISTING_FEES.put("InternationalInsertionFee", Integer.valueOf(0x7f070400));
        LISTING_FEES.put("AuctionLengthFee", Integer.valueOf(0x7f0703f0));
        LISTING_FEES.put("GiftIconFee", Integer.valueOf(0x7f0703fc));
        LISTING_FEES.put("SubtitleFee", Integer.valueOf(0x7f07040a));
        LISTING_FEES.put("SchedulingFee", Integer.valueOf(0x7f070408));
        LISTING_FEES.put("ProPackBundleFee", Integer.valueOf(0x7f070405));
        LISTING_FEES.put("ValuePackBundleFee", Integer.valueOf(0x7f07040c));
        LISTING_FEES.put("ProPackPlusBundleFee", Integer.valueOf(0x7f070406));
        LISTING_FEES.put("GreaterChinaListingFee", Integer.valueOf(0x7f0703fd));
        LISTING_FEES.put("PrivateListingFee", Integer.valueOf(0x7f070404));
        LISTING_FEES.put("ExtendedDurationFee", Integer.valueOf(0x7f0703f6));
        LISTING_FEES.put("BorderFee", Integer.valueOf(0x7f0703f2));
        LISTING_FEES.put("MotorsGermanySearchFee", Integer.valueOf(0x7f070409));
        LISTING_FEES.put("CrossBorderTradeNorthAmericaFee", Integer.valueOf(0x7f0703f5));
        LISTING_FEES.put("PicturePackFee", Integer.valueOf(0x7f070403));
        LISTING_FEES.put("FinalValueFee", Integer.valueOf(0x7f0703f9));
        LISTING_FEES.put("SuperSizeFee", Integer.valueOf(0x7f07040b));
    }
}
