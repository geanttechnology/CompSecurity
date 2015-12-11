// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.listing;


public final class ListingFormatEnum extends Enum
{

    private static final ListingFormatEnum $VALUES[];
    public static final ListingFormatEnum AD_FORMAT;
    public static final ListingFormatEnum AUCTION;
    public static final ListingFormatEnum CLASSIFIED_AD;
    public static final ListingFormatEnum FIXED_PRICE;
    public static final ListingFormatEnum HALF;
    public static final ListingFormatEnum SECOND_CHANCE_OFFER;
    public static final ListingFormatEnum UNKNOWN;

    private ListingFormatEnum(String s, int i)
    {
        super(s, i);
    }

    public static ListingFormatEnum valueOf(String s)
    {
        return (ListingFormatEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/listing/ListingFormatEnum, s);
    }

    public static ListingFormatEnum[] values()
    {
        return (ListingFormatEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new ListingFormatEnum("UNKNOWN", 0);
        AUCTION = new ListingFormatEnum("AUCTION", 1);
        FIXED_PRICE = new ListingFormatEnum("FIXED_PRICE", 2);
        CLASSIFIED_AD = new ListingFormatEnum("CLASSIFIED_AD", 3);
        HALF = new ListingFormatEnum("HALF", 4);
        SECOND_CHANCE_OFFER = new ListingFormatEnum("SECOND_CHANCE_OFFER", 5);
        AD_FORMAT = new ListingFormatEnum("AD_FORMAT", 6);
        $VALUES = (new ListingFormatEnum[] {
            UNKNOWN, AUCTION, FIXED_PRICE, CLASSIFIED_AD, HALF, SECOND_CHANCE_OFFER, AD_FORMAT
        });
    }
}
