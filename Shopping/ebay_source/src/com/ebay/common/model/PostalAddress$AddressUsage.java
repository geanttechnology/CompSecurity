// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;


// Referenced classes of package com.ebay.common.model:
//            PostalAddress

public static final class id extends Enum
{

    private static final kAddressUsageShipping $VALUES[];
    public static final kAddressUsageShipping kAddressUsageDefaultShipping;
    public static final kAddressUsageShipping kAddressUsageInvalid;
    public static final kAddressUsageShipping kAddressUsageShipping;
    public static final kAddressUsageShipping kAddressUsageUnknown;
    public final int id;

    public static id enumFromID(int i)
    {
        id aid[] = values();
        int k = aid.length;
        for (int j = 0; j < k; j++)
        {
            id id1 = aid[j];
            if (id1.id == i)
            {
                return id1;
            }
        }

        return kAddressUsageUnknown;
    }

    public static kAddressUsageUnknown valueOf(String s)
    {
        return (kAddressUsageUnknown)Enum.valueOf(com/ebay/common/model/PostalAddress$AddressUsage, s);
    }

    public static kAddressUsageUnknown[] values()
    {
        return (kAddressUsageUnknown[])$VALUES.clone();
    }

    static 
    {
        kAddressUsageUnknown = new <init>("kAddressUsageUnknown", 0, 0);
        kAddressUsageDefaultShipping = new <init>("kAddressUsageDefaultShipping", 1, 1001);
        kAddressUsageInvalid = new <init>("kAddressUsageInvalid", 2, 1002);
        kAddressUsageShipping = new <init>("kAddressUsageShipping", 3, 1003);
        $VALUES = (new .VALUES[] {
            kAddressUsageUnknown, kAddressUsageDefaultShipping, kAddressUsageInvalid, kAddressUsageShipping
        });
    }

    private (String s, int i)
    {
        super(s, i);
        id = 0;
    }

    private id(String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}
