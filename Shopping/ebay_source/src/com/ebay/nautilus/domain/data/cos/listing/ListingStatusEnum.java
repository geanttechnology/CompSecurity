// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.listing;


public final class ListingStatusEnum extends Enum
{

    private static final ListingStatusEnum $VALUES[];
    public static final ListingStatusEnum ACTIVE;
    public static final ListingStatusEnum ENDED;
    public static final ListingStatusEnum ON_HOLD;
    public static final ListingStatusEnum PENDING_REVIEW;
    public static final ListingStatusEnum SCHEDULED;
    public static final ListingStatusEnum UNKNOWN;

    private ListingStatusEnum(String s, int i)
    {
        super(s, i);
    }

    public static ListingStatusEnum valueOf(String s)
    {
        return (ListingStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/listing/ListingStatusEnum, s);
    }

    public static ListingStatusEnum[] values()
    {
        return (ListingStatusEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new ListingStatusEnum("UNKNOWN", 0);
        ACTIVE = new ListingStatusEnum("ACTIVE", 1);
        SCHEDULED = new ListingStatusEnum("SCHEDULED", 2);
        ENDED = new ListingStatusEnum("ENDED", 3);
        ON_HOLD = new ListingStatusEnum("ON_HOLD", 4);
        PENDING_REVIEW = new ListingStatusEnum("PENDING_REVIEW", 5);
        $VALUES = (new ListingStatusEnum[] {
            UNKNOWN, ACTIVE, SCHEDULED, ENDED, ON_HOLD, PENDING_REVIEW
        });
    }
}
