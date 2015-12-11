// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseListingType

public static final class  extends Enum
{

    private static final PENDING_CS_REVIEW $VALUES[];
    public static final PENDING_CS_REVIEW ACTIVE;
    public static final PENDING_CS_REVIEW ENDED;
    public static final PENDING_CS_REVIEW ENDED_BY_EBAY;
    public static final PENDING_CS_REVIEW ENDED_BY_SELLER;
    public static final PENDING_CS_REVIEW ON_HOLD;
    public static final PENDING_CS_REVIEW PENDING_CS_REVIEW;
    public static final PENDING_CS_REVIEW PENDING_REVIEW;
    public static final PENDING_CS_REVIEW SCHEDULED;
    public static final PENDING_CS_REVIEW SELLER_ON_VACATION;
    public static final PENDING_CS_REVIEW SOLD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseListingType$ListingStatusEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SCHEDULED = new <init>("SCHEDULED", 0);
        ACTIVE = new <init>("ACTIVE", 1);
        ENDED = new <init>("ENDED", 2);
        PENDING_REVIEW = new <init>("PENDING_REVIEW", 3);
        ON_HOLD = new <init>("ON_HOLD", 4);
        ENDED_BY_SELLER = new <init>("ENDED_BY_SELLER", 5);
        ENDED_BY_EBAY = new <init>("ENDED_BY_EBAY", 6);
        SOLD = new <init>("SOLD", 7);
        SELLER_ON_VACATION = new <init>("SELLER_ON_VACATION", 8);
        PENDING_CS_REVIEW = new <init>("PENDING_CS_REVIEW", 9);
        $VALUES = (new .VALUES[] {
            SCHEDULED, ACTIVE, ENDED, PENDING_REVIEW, ON_HOLD, ENDED_BY_SELLER, ENDED_BY_EBAY, SOLD, SELLER_ON_VACATION, PENDING_CS_REVIEW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
