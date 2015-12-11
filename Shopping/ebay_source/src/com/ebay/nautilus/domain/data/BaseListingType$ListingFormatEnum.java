// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseListingType

public static final class  extends Enum
{

    private static final ADFORMAT $VALUES[];
    public static final ADFORMAT ADFORMAT;
    public static final ADFORMAT AUCTION;
    public static final ADFORMAT CLASSIFIED_AD;
    public static final ADFORMAT FIXED_PRICE;
    public static final ADFORMAT HALF;
    public static final ADFORMAT SECOND_CHANCE_OFFER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseListingType$ListingFormatEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUCTION = new <init>("AUCTION", 0);
        FIXED_PRICE = new <init>("FIXED_PRICE", 1);
        CLASSIFIED_AD = new <init>("CLASSIFIED_AD", 2);
        HALF = new <init>("HALF", 3);
        SECOND_CHANCE_OFFER = new <init>("SECOND_CHANCE_OFFER", 4);
        ADFORMAT = new <init>("ADFORMAT", 5);
        $VALUES = (new .VALUES[] {
            AUCTION, FIXED_PRICE, CLASSIFIED_AD, HALF, SECOND_CHANCE_OFFER, ADFORMAT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
