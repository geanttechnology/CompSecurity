// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;


// Referenced classes of package com.target.mothership.common.params:
//            ProductRecommendationsParam

public static final class mValue extends Enum
{

    private static final DEFAULT_RECOMMENDATION $VALUES[];
    public static final DEFAULT_RECOMMENDATION CART_NOT_EMPTY_RECOMMENDATIONS;
    public static final DEFAULT_RECOMMENDATION CART_RECOMMENDATIONS;
    public static final DEFAULT_RECOMMENDATION DEFAULT_RECOMMENDATION;
    public static final DEFAULT_RECOMMENDATION LIST_RECOMMENDATIONS;
    public static final DEFAULT_RECOMMENDATION PDP_RECOMMENDATIONS;
    public static final DEFAULT_RECOMMENDATION PLP_RECOMMENDATIONS;
    public static final DEFAULT_RECOMMENDATION SLP_RECOMMENDATIONS;
    private String mValue;

    public static mValue valueOf(String s)
    {
        return (mValue)Enum.valueOf(com/target/mothership/common/params/ProductRecommendationsParam$a, s);
    }

    public static mValue[] values()
    {
        return (mValue[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        PDP_RECOMMENDATIONS = new <init>("PDP_RECOMMENDATIONS", 0, "pdpdroidh1");
        PLP_RECOMMENDATIONS = new <init>("PLP_RECOMMENDATIONS", 1, "plpdroidh1");
        SLP_RECOMMENDATIONS = new <init>("SLP_RECOMMENDATIONS", 2, "slpdroidh1");
        CART_RECOMMENDATIONS = new <init>("CART_RECOMMENDATIONS", 3, "driodemptych1");
        LIST_RECOMMENDATIONS = new <init>("LIST_RECOMMENDATIONS", 4, "rlistdroidh1");
        CART_NOT_EMPTY_RECOMMENDATIONS = new <init>("CART_NOT_EMPTY_RECOMMENDATIONS", 5, "droidcarth1");
        DEFAULT_RECOMMENDATION = new <init>("DEFAULT_RECOMMENDATION", 6, "");
        $VALUES = (new .VALUES[] {
            PDP_RECOMMENDATIONS, PLP_RECOMMENDATIONS, SLP_RECOMMENDATIONS, CART_RECOMMENDATIONS, LIST_RECOMMENDATIONS, CART_NOT_EMPTY_RECOMMENDATIONS, DEFAULT_RECOMMENDATION
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
