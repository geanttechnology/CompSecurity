// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;


// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellActivity

public static final class  extends Enum
{

    private static final RESULT_LOAD_PAGE_ERROR $VALUES[];
    public static final RESULT_LOAD_PAGE_ERROR RESULT_LOAD_PAGE_ERROR;
    public static final RESULT_LOAD_PAGE_ERROR RESULT_OFFER_PAGE_NOT_DISPLAYED;
    public static final RESULT_LOAD_PAGE_ERROR RESULT_SIGNUP_FAILURE;
    public static final RESULT_LOAD_PAGE_ERROR RESULT_SIGNUP_SUCCESS;
    public static final RESULT_LOAD_PAGE_ERROR RESULT_USER_CANCELLED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RESULT_USER_CANCELLED = new <init>("RESULT_USER_CANCELLED", 0);
        RESULT_SIGNUP_SUCCESS = new <init>("RESULT_SIGNUP_SUCCESS", 1);
        RESULT_SIGNUP_FAILURE = new <init>("RESULT_SIGNUP_FAILURE", 2);
        RESULT_OFFER_PAGE_NOT_DISPLAYED = new <init>("RESULT_OFFER_PAGE_NOT_DISPLAYED", 3);
        RESULT_LOAD_PAGE_ERROR = new <init>("RESULT_LOAD_PAGE_ERROR", 4);
        $VALUES = (new .VALUES[] {
            RESULT_USER_CANCELLED, RESULT_SIGNUP_SUCCESS, RESULT_SIGNUP_FAILURE, RESULT_OFFER_PAGE_NOT_DISPLAYED, RESULT_LOAD_PAGE_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
