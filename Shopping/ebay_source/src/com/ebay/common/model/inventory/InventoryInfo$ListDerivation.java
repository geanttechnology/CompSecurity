// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;


// Referenced classes of package com.ebay.common.model.inventory:
//            InventoryInfo

public static final class value extends Enum
{

    private static final SEARCH_POSTAL_CODE $VALUES[];
    public static final SEARCH_POSTAL_CODE LATLNG;
    public static final SEARCH_POSTAL_CODE POSTAL_CODE;
    public static final SEARCH_POSTAL_CODE SEARCH_POSTAL_CODE;
    public static final SEARCH_POSTAL_CODE UNKNOWN;
    private int value;

    public static value getFromValue(int i)
    {
        value avalue[] = values();
        int k = avalue.length;
        for (int j = 0; j < k; j++)
        {
            value value1 = avalue[j];
            if (value1.getValue() == i)
            {
                return value1;
            }
        }

        return UNKNOWN;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/ebay/common/model/inventory/InventoryInfo$ListDerivation, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, 0);
        LATLNG = new <init>("LATLNG", 1, 1);
        POSTAL_CODE = new <init>("POSTAL_CODE", 2, 2);
        SEARCH_POSTAL_CODE = new <init>("SEARCH_POSTAL_CODE", 3, 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, LATLNG, POSTAL_CODE, SEARCH_POSTAL_CODE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
