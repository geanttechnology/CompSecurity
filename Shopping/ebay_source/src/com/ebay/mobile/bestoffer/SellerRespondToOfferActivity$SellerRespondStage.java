// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;


// Referenced classes of package com.ebay.mobile.bestoffer:
//            SellerRespondToOfferActivity

public static final class  extends Enum
{

    private static final COMPLETE_COUNTER_ERROR $VALUES[];
    public static final COMPLETE_COUNTER_ERROR COMPLETE_ACCEPT;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_ERROR;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_DECLINE;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_RESPOND_ERROR;
    public static final COMPLETE_COUNTER_ERROR INPUT_COUNTER;
    public static final COMPLETE_COUNTER_ERROR INPUT_DECLINE;
    public static final COMPLETE_COUNTER_ERROR INPUT_DECLINE_NETWORK_ERROR;
    public static final COMPLETE_COUNTER_ERROR REVIEW_COUNTER;
    public static final COMPLETE_COUNTER_ERROR REVIEW_COUNTER_RETRYABLE_ERROR;
    public static final COMPLETE_COUNTER_ERROR REVIEW_FOR_ACCEPT;
    public static final COMPLETE_COUNTER_ERROR REVIEW_FOR_ACCEPT_NETWORK_ERROR;
    public static final COMPLETE_COUNTER_ERROR VIEW_OFFER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/bestoffer/SellerRespondToOfferActivity$SellerRespondStage, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VIEW_OFFER = new <init>("VIEW_OFFER", 0);
        REVIEW_FOR_ACCEPT = new <init>("REVIEW_FOR_ACCEPT", 1);
        REVIEW_FOR_ACCEPT_NETWORK_ERROR = new <init>("REVIEW_FOR_ACCEPT_NETWORK_ERROR", 2);
        COMPLETE_ACCEPT = new <init>("COMPLETE_ACCEPT", 3);
        INPUT_DECLINE = new <init>("INPUT_DECLINE", 4);
        INPUT_DECLINE_NETWORK_ERROR = new <init>("INPUT_DECLINE_NETWORK_ERROR", 5);
        COMPLETE_DECLINE = new <init>("COMPLETE_DECLINE", 6);
        INPUT_COUNTER = new <init>("INPUT_COUNTER", 7);
        REVIEW_COUNTER = new <init>("REVIEW_COUNTER", 8);
        REVIEW_COUNTER_RETRYABLE_ERROR = new <init>("REVIEW_COUNTER_RETRYABLE_ERROR", 9);
        COMPLETE_COUNTER = new <init>("COMPLETE_COUNTER", 10);
        COMPLETE_RESPOND_ERROR = new <init>("COMPLETE_RESPOND_ERROR", 11);
        COMPLETE_COUNTER_ERROR = new <init>("COMPLETE_COUNTER_ERROR", 12);
        $VALUES = (new .VALUES[] {
            VIEW_OFFER, REVIEW_FOR_ACCEPT, REVIEW_FOR_ACCEPT_NETWORK_ERROR, COMPLETE_ACCEPT, INPUT_DECLINE, INPUT_DECLINE_NETWORK_ERROR, COMPLETE_DECLINE, INPUT_COUNTER, REVIEW_COUNTER, REVIEW_COUNTER_RETRYABLE_ERROR, 
            COMPLETE_COUNTER, COMPLETE_RESPOND_ERROR, COMPLETE_COUNTER_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
