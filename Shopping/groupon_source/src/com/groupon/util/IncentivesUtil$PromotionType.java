// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            IncentivesUtil

public static final class name extends Enum
{

    private static final INCENTIVE $VALUES[];
    public static final INCENTIVE INCENTIVE;
    public static final INCENTIVE PROMO_CODE;
    private String name;

    public static name fromString(String s)
    {
        if (Strings.notEmpty(s))
        {
            name aname[] = values();
            int j = aname.length;
            for (int i = 0; i < j; i++)
            {
                name name1 = aname[i];
                if (Strings.equals(s, name1.name))
                {
                    return name1;
                }
            }

        }
        return null;
    }

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/groupon/util/IncentivesUtil$PromotionType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    static 
    {
        PROMO_CODE = new <init>("PROMO_CODE", 0, "promocode");
        INCENTIVE = new <init>("INCENTIVE", 1, "incentive");
        $VALUES = (new .VALUES[] {
            PROMO_CODE, INCENTIVE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
