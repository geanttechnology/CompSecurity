// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            CouponMerchantWrapper

public static final class  extends Enum
{

    private static final SEARCH_AUTOCOMPLETE $VALUES[];
    public static final SEARCH_AUTOCOMPLETE SEARCH_AUTOCOMPLETE;
    public static final SEARCH_AUTOCOMPLETE SEARCH_RECOMMENDATION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/v3/view/list_view/CouponMerchantWrapper$CouponMerchantType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SEARCH_RECOMMENDATION = new <init>("SEARCH_RECOMMENDATION", 0);
        SEARCH_AUTOCOMPLETE = new <init>("SEARCH_AUTOCOMPLETE", 1);
        $VALUES = (new .VALUES[] {
            SEARCH_RECOMMENDATION, SEARCH_AUTOCOMPLETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
