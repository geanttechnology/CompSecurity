// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;


// Referenced classes of package com.ebay.mobile.bestoffer:
//            BuyerMakeOfferActivity

public static final class  extends Enum
{

    private static final COMPLETE_ERROR_RETRY_AVAILABLE $VALUES[];
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_AUTO_ACCEPTED;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_AUTO_DECLINED;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_ERROR;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_ERROR_RETRY_AVAILABLE;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE COMPLETE_SENT;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE INPUT;
    public static final COMPLETE_ERROR_RETRY_AVAILABLE REVIEW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/bestoffer/BuyerMakeOfferActivity$BuyerOfferStage, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INPUT = new <init>("INPUT", 0);
        REVIEW = new <init>("REVIEW", 1);
        COMPLETE_SENT = new <init>("COMPLETE_SENT", 2);
        COMPLETE_AUTO_ACCEPTED = new <init>("COMPLETE_AUTO_ACCEPTED", 3);
        COMPLETE_AUTO_DECLINED = new <init>("COMPLETE_AUTO_DECLINED", 4);
        COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE = new <init>("COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE", 5);
        COMPLETE_ERROR = new <init>("COMPLETE_ERROR", 6);
        COMPLETE_ERROR_RETRY_AVAILABLE = new <init>("COMPLETE_ERROR_RETRY_AVAILABLE", 7);
        $VALUES = (new .VALUES[] {
            INPUT, REVIEW, COMPLETE_SENT, COMPLETE_AUTO_ACCEPTED, COMPLETE_AUTO_DECLINED, COMPLETE_AUTO_DECLINED_RETRY_AVAILABLE, COMPLETE_ERROR, COMPLETE_ERROR_RETRY_AVAILABLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
