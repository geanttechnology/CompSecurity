// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;


// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackRequest

public static final class name extends Enum
{

    private static final RECEIVED_AS_SELLER $VALUES[];
    public static final RECEIVED_AS_SELLER RECEIVED_AS_BUYER;
    public static final RECEIVED_AS_SELLER RECEIVED_AS_SELLER;
    protected String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/ebay/common/net/api/trading/GetFeedbackRequest$FeedbackType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        RECEIVED_AS_BUYER = new <init>("RECEIVED_AS_BUYER", 0, "FeedbackReceivedAsBuyer");
        RECEIVED_AS_SELLER = new <init>("RECEIVED_AS_SELLER", 1, "FeedbackReceivedAsSeller");
        $VALUES = (new .VALUES[] {
            RECEIVED_AS_BUYER, RECEIVED_AS_SELLER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
