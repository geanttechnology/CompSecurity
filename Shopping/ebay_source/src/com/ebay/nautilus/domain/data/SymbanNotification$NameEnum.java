// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SymbanNotification

public static final class  extends Enum
{

    private static final UPDATE_YOUR_INFO $VALUES[];
    public static final UPDATE_YOUR_INFO BEST_OFFER_ACCEPTED;
    public static final UPDATE_YOUR_INFO BEST_OFFER_DECLINED;
    public static final UPDATE_YOUR_INFO BEST_OFFER_RECEIVED;
    public static final UPDATE_YOUR_INFO BID_ITEM_ENDING_SOON;
    public static final UPDATE_YOUR_INFO BUYER_PAID;
    public static final UPDATE_YOUR_INFO CART_ITEM_ENDING_SOON;
    public static final UPDATE_YOUR_INFO COMPETING_BEST_OFFER_ACCEPTED;
    public static final UPDATE_YOUR_INFO COUNTER_OFFER_ACCEPTED;
    public static final UPDATE_YOUR_INFO COUNTER_OFFER_DECLINED;
    public static final UPDATE_YOUR_INFO COUNTER_OFFER_RECEIVED;
    public static final UPDATE_YOUR_INFO ITEM_SHIPPED;
    public static final UPDATE_YOUR_INFO ITEM_SOLD;
    public static final UPDATE_YOUR_INFO ITEM_WON;
    public static final UPDATE_YOUR_INFO MESSAGE_RECEIVED;
    public static final UPDATE_YOUR_INFO OFFER_EXPIRED;
    public static final UPDATE_YOUR_INFO OFFER_RETRACTED;
    public static final UPDATE_YOUR_INFO OUTBID;
    public static final UPDATE_YOUR_INFO UPDATE_YOUR_INFO;
    public static final UPDATE_YOUR_INFO WATCH_ITEM_ENDING_SOON;

    public static  factory(String s)
    {
         a[] = values();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
              = a[i];
            if (TextUtils.equals(.name(), s))
            {
                return ;
            }
        }

        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/nautilus/domain/data/SymbanNotification$NameEnum, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        OUTBID = new <init>("OUTBID", 0);
        BID_ITEM_ENDING_SOON = new <init>("BID_ITEM_ENDING_SOON", 1);
        WATCH_ITEM_ENDING_SOON = new <init>("WATCH_ITEM_ENDING_SOON", 2);
        CART_ITEM_ENDING_SOON = new <init>("CART_ITEM_ENDING_SOON", 3);
        ITEM_WON = new <init>("ITEM_WON", 4);
        ITEM_SOLD = new <init>("ITEM_SOLD", 5);
        BUYER_PAID = new <init>("BUYER_PAID", 6);
        ITEM_SHIPPED = new <init>("ITEM_SHIPPED", 7);
        BEST_OFFER_RECEIVED = new <init>("BEST_OFFER_RECEIVED", 8);
        BEST_OFFER_DECLINED = new <init>("BEST_OFFER_DECLINED", 9);
        COUNTER_OFFER_RECEIVED = new <init>("COUNTER_OFFER_RECEIVED", 10);
        BEST_OFFER_ACCEPTED = new <init>("BEST_OFFER_ACCEPTED", 11);
        COUNTER_OFFER_ACCEPTED = new <init>("COUNTER_OFFER_ACCEPTED", 12);
        COUNTER_OFFER_DECLINED = new <init>("COUNTER_OFFER_DECLINED", 13);
        OFFER_EXPIRED = new <init>("OFFER_EXPIRED", 14);
        COMPETING_BEST_OFFER_ACCEPTED = new <init>("COMPETING_BEST_OFFER_ACCEPTED", 15);
        OFFER_RETRACTED = new <init>("OFFER_RETRACTED", 16);
        MESSAGE_RECEIVED = new <init>("MESSAGE_RECEIVED", 17);
        UPDATE_YOUR_INFO = new <init>("UPDATE_YOUR_INFO", 18);
        $VALUES = (new .VALUES[] {
            OUTBID, BID_ITEM_ENDING_SOON, WATCH_ITEM_ENDING_SOON, CART_ITEM_ENDING_SOON, ITEM_WON, ITEM_SOLD, BUYER_PAID, ITEM_SHIPPED, BEST_OFFER_RECEIVED, BEST_OFFER_DECLINED, 
            COUNTER_OFFER_RECEIVED, BEST_OFFER_ACCEPTED, COUNTER_OFFER_ACCEPTED, COUNTER_OFFER_DECLINED, OFFER_EXPIRED, COMPETING_BEST_OFFER_ACCEPTED, OFFER_RETRACTED, MESSAGE_RECEIVED, UPDATE_YOUR_INFO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
