// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            UrgencyPricingUtils

public static final class  extends Enum
{

    private static final CLEARANCE $VALUES[];
    public static final CLEARANCE CLEARANCE;
    public static final CLEARANCE INTRODUCTORY_PRICE;
    public static final CLEARANCE SALE;

    public static  safeValueOf(String s)
    {
        if (Strings.notEmpty(s))
        {
             a[] = values();
            int j = a.length;
            for (int i = 0; i < j; i++)
            {
                  = a[i];
                if (Strings.equals(.name(), s))
                {
                    return ;
                }
            }

        }
        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/groupon/util/UrgencyPricingUtils$UrgencyPricingType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        SALE = new <init>("SALE", 0);
        INTRODUCTORY_PRICE = new <init>("INTRODUCTORY_PRICE", 1);
        CLEARANCE = new <init>("CLEARANCE", 2);
        $VALUES = (new .VALUES[] {
            SALE, INTRODUCTORY_PRICE, CLEARANCE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
