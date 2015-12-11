// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBidTracking

public static class RTB_SPECIFIC_BID_AMT
{

    private static final RTB_SPECIFIC_BID_AMT BROWSE_CATEGORIES = new <init>("BHN", "BNN", "BUB", "BHB");
    private static final <init> COUNTEROFFER = new <init>("CHN", "CNN", "CUB", "CHB");
    private static final <init> ENDING_SOON_NOTIFICATION = new <init>("EHN", "ENN", "EUB", "EHB");
    private static final <init> ORGANIC = new <init>("NHN", "NNN", "NUB", "NHB");
    private static final <init> OUTBID_NOTIFICATION = new <init>("OHN", "ONN", "OUB", "OHB");
    private static final <init> SAVED_SEARCH_NOTIFICATION = new <init>("SHN", "SNN", "SUB", "SHB");
    private static final <init> SHOPPING_CART = new <init>("XHN", "XNN", "XUB", "XHB");
    private final String NON_RTB_INC;
    private final String RTB_INC;
    private final String RTB_SPECIFIC_BID_AMT;
    private final String SPECIFIC_BID_AMT;

    public static RTB_SPECIFIC_BID_AMT getTypeForBidSource(String s)
    {
        RTB_SPECIFIC_BID_AMT rtb_specific_bid_amt1 = ORGANIC;
        RTB_SPECIFIC_BID_AMT rtb_specific_bid_amt = rtb_specific_bid_amt1;
        if (s != null)
        {
            if (s.equals(ItemViewBidTracking.BID_SOURCE_OUTBID_NOTIFICATION))
            {
                rtb_specific_bid_amt = OUTBID_NOTIFICATION;
            } else
            {
                if (s.equals(ItemViewBidTracking.BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION))
                {
                    return ENDING_SOON_NOTIFICATION;
                }
                if (s.equals(ItemViewBidTracking.BID_SOURCE_SVDSRCH_NOTIFICATION))
                {
                    return SAVED_SEARCH_NOTIFICATION;
                }
                if (s.equals("browse_categories"))
                {
                    return BROWSE_CATEGORIES;
                }
                if (s.equals(ItemViewBidTracking.BID_SOURCE_COUNTEROFFER))
                {
                    return COUNTEROFFER;
                }
                rtb_specific_bid_amt = rtb_specific_bid_amt1;
                if (s.equals("shopping_cart"))
                {
                    return SHOPPING_CART;
                }
            }
        }
        return rtb_specific_bid_amt;
    }

    public String getTrackingCode(boolean flag, boolean flag1)
    {
        if (flag1 && flag)
        {
            return RTB_INC;
        }
        if (!flag1 && flag)
        {
            return NON_RTB_INC;
        }
        if (!flag1 && !flag)
        {
            return SPECIFIC_BID_AMT;
        }
        if (flag1 && !flag)
        {
            return RTB_SPECIFIC_BID_AMT;
        } else
        {
            return null;
        }
    }


    public (String s, String s1, String s2, String s3)
    {
        RTB_INC = s;
        NON_RTB_INC = s1;
        SPECIFIC_BID_AMT = s2;
        RTB_SPECIFIC_BID_AMT = s3;
    }
}
