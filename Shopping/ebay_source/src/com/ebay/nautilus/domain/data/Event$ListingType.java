// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            Event

public static final class  extends Enum
{

    private static final EBAY_AD $VALUES[];
    public static final EBAY_AD AD;
    public static final EBAY_AD CHINESE_AUCTION;
    public static final EBAY_AD CLASSIFIED_AD;
    public static final EBAY_AD DUTCH_AUCTION;
    public static final EBAY_AD EBAY_AD;
    public static final EBAY_AD EBX_ONLY;
    public static final EBAY_AD FIXED_PRICE;
    public static final EBAY_AD HALF_SALE;
    public static final EBAY_AD LIVE_AUCTION;
    public static final EBAY_AD PERSONAL_OFFER;
    public static final EBAY_AD SDC_SALE;
    public static final EBAY_AD WANTED_ITEM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/Event$ListingType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CHINESE_AUCTION = new <init>("CHINESE_AUCTION", 0);
        DUTCH_AUCTION = new <init>("DUTCH_AUCTION", 1);
        LIVE_AUCTION = new <init>("LIVE_AUCTION", 2);
        AD = new <init>("AD", 3);
        FIXED_PRICE = new <init>("FIXED_PRICE", 4);
        PERSONAL_OFFER = new <init>("PERSONAL_OFFER", 5);
        WANTED_ITEM = new <init>("WANTED_ITEM", 6);
        HALF_SALE = new <init>("HALF_SALE", 7);
        CLASSIFIED_AD = new <init>("CLASSIFIED_AD", 8);
        EBX_ONLY = new <init>("EBX_ONLY", 9);
        SDC_SALE = new <init>("SDC_SALE", 10);
        EBAY_AD = new <init>("EBAY_AD", 11);
        $VALUES = (new .VALUES[] {
            CHINESE_AUCTION, DUTCH_AUCTION, LIVE_AUCTION, AD, FIXED_PRICE, PERSONAL_OFFER, WANTED_ITEM, HALF_SALE, CLASSIFIED_AD, EBX_ONLY, 
            SDC_SALE, EBAY_AD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
