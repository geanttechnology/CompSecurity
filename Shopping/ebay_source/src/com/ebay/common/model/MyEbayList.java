// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.common.net.AsyncList;

// Referenced classes of package com.ebay.common.model:
//            ListResult

public final class MyEbayList extends ListResult
{

    public static final int TYPE_BUYING_BEST_OFFER = 4;
    public static final int TYPE_BUYING_BIDDING = 1;
    public static final int TYPE_BUYING_NOT_WON = 3;
    public static final int TYPE_BUYING_WON = 2;
    public static final int TYPE_CUSTOM_LIST = 11;
    public static final int TYPE_SELLING_ACTIVE = 5;
    public static final int TYPE_SELLING_BEST_OFFER = 9;
    public static final int TYPE_SELLING_NOT_SOLD = 7;
    public static final int TYPE_SELLING_SCHEDULED = 8;
    public static final int TYPE_SELLING_SOLD = 6;
    public static final int TYPE_WATCHING = 0;
    public static final int TYPE_WISHLIST = 10;
    public final int type;

    public MyEbayList(int i, int j, AsyncList asynclist)
    {
        super(j, asynclist);
        type = i;
    }

    public static String listNameFromType(int i)
    {
        switch (i)
        {
        default:
            return "UserDefinedList";

        case 4: // '\004'
            return "BestOfferList";

        case 1: // '\001'
            return "BidList";

        case 3: // '\003'
            return "LostList";

        case 2: // '\002'
            return "WonList";

        case 5: // '\005'
            return "ActiveList";

        case 9: // '\t'
            return "ActiveList";

        case 7: // '\007'
            return "UnsoldList";

        case 8: // '\b'
            return "ScheduledList";

        case 6: // '\006'
            return "SoldList";

        case 0: // '\0'
            return "WatchList";
        }
    }
}
