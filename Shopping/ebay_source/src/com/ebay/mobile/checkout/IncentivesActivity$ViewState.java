// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            IncentivesActivity

private static final class  extends Enum
{

    private static final INCENTIVE_LIST $VALUES[];
    public static final INCENTIVE_LIST INCENTIVE_INPUT;
    public static final INCENTIVE_LIST INCENTIVE_LIST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/checkout/IncentivesActivity$ViewState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INCENTIVE_INPUT = new <init>("INCENTIVE_INPUT", 0);
        INCENTIVE_LIST = new <init>("INCENTIVE_LIST", 1);
        $VALUES = (new .VALUES[] {
            INCENTIVE_INPUT, INCENTIVE_LIST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
