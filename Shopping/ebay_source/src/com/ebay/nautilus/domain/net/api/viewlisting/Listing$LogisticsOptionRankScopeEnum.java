// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final ALL_PLANS $VALUES[];
    public static final ALL_PLANS ALL_PLANS;
    public static final ALL_PLANS STEP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$LogisticsOptionRankScopeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STEP = new <init>("STEP", 0);
        ALL_PLANS = new <init>("ALL_PLANS", 1);
        $VALUES = (new .VALUES[] {
            STEP, ALL_PLANS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
