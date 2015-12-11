// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;


// Referenced classes of package com.ebay.common.model.mdns:
//            PlatformNotificationsEvent

public static final class value extends Enum
{

    private static final BIDONLY $VALUES[];
    public static final BIDONLY BIDONLY;
    public static final BIDONLY BIDWITHBIN;
    public static final BIDONLY BINONLY;
    private final int value;

    public static value fromListingType(String s, boolean flag)
    {
        if (s != null)
        {
            if (s.equals("FixedPriceItem"))
            {
                return BINONLY;
            }
            if (s.equals("Chinese"))
            {
                if (flag)
                {
                    return BIDWITHBIN;
                } else
                {
                    return BIDONLY;
                }
            }
        }
        return null;
    }

    public static BIDONLY get(int i)
    {
        BIDONLY abidonly[] = values();
        int k = abidonly.length;
        for (int j = 0; j < k; j++)
        {
            BIDONLY bidonly = abidonly[j];
            if (i == bidonly.getValue())
            {
                return bidonly;
            }
        }

        return null;
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/ebay/common/model/mdns/PlatformNotificationsEvent$ItemListingType, s);
    }

    public static getValue[] values()
    {
        return (getValue[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        BINONLY = new <init>("BINONLY", 0, 1);
        BIDWITHBIN = new <init>("BIDWITHBIN", 1, 2);
        BIDONLY = new <init>("BIDONLY", 2, 3);
        $VALUES = (new .VALUES[] {
            BINONLY, BIDWITHBIN, BIDONLY
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
