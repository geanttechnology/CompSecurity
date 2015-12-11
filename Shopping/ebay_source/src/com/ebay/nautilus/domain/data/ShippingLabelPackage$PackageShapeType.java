// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelPackage

public static final class I extends Enum
{

    private static final IRREGULAR $VALUES[];
    public static final IRREGULAR IRREGULAR;
    public static final IRREGULAR REGULAR;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelPackage$PackageShapeType, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        REGULAR = new <init>("REGULAR", 0);
        IRREGULAR = new <init>("IRREGULAR", 1);
        $VALUES = (new .VALUES[] {
            REGULAR, IRREGULAR
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
