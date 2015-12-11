// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import java.util.ArrayList;

// Referenced classes of package com.ebay.common.model.mdns:
//            NotificationPreference

public static final class name extends Enum
{

    private static final BucksExpiringSoon $VALUES[];
    public static final BucksExpiringSoon AskSellerQuestion;
    public static final BucksExpiringSoon AuctionCheckoutComplete;
    public static final BucksExpiringSoon BestOffer;
    public static final BucksExpiringSoon BestOfferDeclined;
    public static final BucksExpiringSoon BidItemEndingSoon;
    public static final BucksExpiringSoon BidReceived;
    public static final BucksExpiringSoon BucksExpiringSoon;
    public static final BucksExpiringSoon CounterOfferReceived;
    public static final BucksExpiringSoon CouponAvailable;
    public static final BucksExpiringSoon ItemMarkedPaid;
    public static final BucksExpiringSoon ItemMarkedShipped;
    public static final BucksExpiringSoon ItemSold;
    public static final BucksExpiringSoon ItemWon;
    public static final BucksExpiringSoon OutBid;
    public static final BucksExpiringSoon WatchedItemEndingSoon;
    public static final BucksExpiringSoon WebnextMobilePhotoSync;
    public final boolean defaultValue;
    public final int id;
    public final boolean supported;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$AlertType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        OutBid = new <init>("OutBid", 0, 0, true, true);
        WatchedItemEndingSoon = new <init>("WatchedItemEndingSoon", 1, 1, true, true);
        BestOffer = new <init>("BestOffer", 2, 3, true, true);
        BestOfferDeclined = new <init>("BestOfferDeclined", 3, 4, true, true);
        CounterOfferReceived = new <init>("CounterOfferReceived", 4, 5, true, true);
        ItemWon = new <init>("ItemWon", 5, 6, true, true);
        ItemSold = new <init>("ItemSold", 6, 7, true, true);
        ItemMarkedPaid = new <init>("ItemMarkedPaid", 7, 8, true, false);
        ItemMarkedShipped = new <init>("ItemMarkedShipped", 8, 9, true, true);
        BidReceived = new <init>("BidReceived", 9, 10, true, false);
        AskSellerQuestion = new <init>("AskSellerQuestion", 10, 12, false, true);
        AuctionCheckoutComplete = new <init>("AuctionCheckoutComplete", 11, 13, false, false);
        BidItemEndingSoon = new <init>("BidItemEndingSoon", 12, 17, false, false);
        CouponAvailable = new <init>("CouponAvailable", 13, 18, false, false);
        WebnextMobilePhotoSync = new <init>("WebnextMobilePhotoSync", 14, 19, false, false);
        BucksExpiringSoon = new <init>("BucksExpiringSoon", 15, 20, false, false);
        $VALUES = (new .VALUES[] {
            OutBid, WatchedItemEndingSoon, BestOffer, BestOfferDeclined, CounterOfferReceived, ItemWon, ItemSold, ItemMarkedPaid, ItemMarkedShipped, BidReceived, 
            AskSellerQuestion, AuctionCheckoutComplete, BidItemEndingSoon, CouponAvailable, WebnextMobilePhotoSync, BucksExpiringSoon
        });
    }

    private A(String s, int i, int j, boolean flag, boolean flag1)
    {
        super(s, i);
        id = j;
        supported = flag;
        defaultValue = flag1;
        if (flag)
        {
            NotificationPreference.supportedPollEventNames.add(name());
        }
    }
}
