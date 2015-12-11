// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;


// Referenced classes of package com.ebay.mobile.bestoffer:
//            BuyerRespondToCounterofferActivity

public static final class  extends Enum
{

    private static final COMPLETE_COUNTER_ERROR $VALUES[];
    public static final COMPLETE_COUNTER_ERROR COMPLETE_ACCEPT;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_AUTO_ACCEPTED;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_AUTO_DECLINED;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_ERROR;
    public static final COMPLETE_COUNTER_ERROR COMPLETE_COUNTER_SENT;
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
        return ()Enum.valueOf(com/ebay/mobile/bestoffer/BuyerRespondToCounterofferActivity$BuyerRespondStage, s);
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
        COMPLETE_RESPOND_ERROR = new <init>("COMPLETE_RESPOND_ERROR", 7);
        INPUT_COUNTER = new <init>("INPUT_COUNTER", 8);
        REVIEW_COUNTER = new <init>("REVIEW_COUNTER", 9);
        REVIEW_COUNTER_RETRYABLE_ERROR = new <init>("REVIEW_COUNTER_RETRYABLE_ERROR", 10);
        COMPLETE_COUNTER_SENT = new <init>("COMPLETE_COUNTER_SENT", 11);
        COMPLETE_COUNTER_AUTO_ACCEPTED = new <init>("COMPLETE_COUNTER_AUTO_ACCEPTED", 12);
        COMPLETE_COUNTER_AUTO_DECLINED = new <init>("COMPLETE_COUNTER_AUTO_DECLINED", 13);
        COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE = new <init>("COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE", 14);
        COMPLETE_COUNTER_ERROR = new <init>("COMPLETE_COUNTER_ERROR", 15);
        $VALUES = (new .VALUES[] {
            VIEW_OFFER, REVIEW_FOR_ACCEPT, REVIEW_FOR_ACCEPT_NETWORK_ERROR, COMPLETE_ACCEPT, INPUT_DECLINE, INPUT_DECLINE_NETWORK_ERROR, COMPLETE_DECLINE, COMPLETE_RESPOND_ERROR, INPUT_COUNTER, REVIEW_COUNTER, 
            REVIEW_COUNTER_RETRYABLE_ERROR, COMPLETE_COUNTER_SENT, COMPLETE_COUNTER_AUTO_ACCEPTED, COMPLETE_COUNTER_AUTO_DECLINED, COMPLETE_COUNTER_AUTO_DECLINED_RETRY_AVAILABLE, COMPLETE_COUNTER_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
