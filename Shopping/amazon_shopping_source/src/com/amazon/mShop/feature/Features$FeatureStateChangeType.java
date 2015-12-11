// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;


// Referenced classes of package com.amazon.mShop.feature:
//            Features

public static final class  extends Enum
{

    private static final NO_CHANGE $VALUES[];
    public static final NO_CHANGE CACHETIMESTAMP_CHANGE;
    public static final NO_CHANGE NO_CHANGE;
    public static final NO_CHANGE TREATMENT_CHANGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/feature/Features$FeatureStateChangeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TREATMENT_CHANGE = new <init>("TREATMENT_CHANGE", 0);
        CACHETIMESTAMP_CHANGE = new <init>("CACHETIMESTAMP_CHANGE", 1);
        NO_CHANGE = new <init>("NO_CHANGE", 2);
        $VALUES = (new .VALUES[] {
            TREATMENT_CHANGE, CACHETIMESTAMP_CHANGE, NO_CHANGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
