// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final ManufacturerWarranty $VALUES[];
    public static final ManufacturerWarranty DealerWarranty;
    public static final ManufacturerWarranty ManufacturerWarranty;
    public static final ManufacturerWarranty ReplacementWarranty;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$WarrantyTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ReplacementWarranty = new <init>("ReplacementWarranty", 0);
        DealerWarranty = new <init>("DealerWarranty", 1);
        ManufacturerWarranty = new <init>("ManufacturerWarranty", 2);
        $VALUES = (new .VALUES[] {
            ReplacementWarranty, DealerWarranty, ManufacturerWarranty
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
