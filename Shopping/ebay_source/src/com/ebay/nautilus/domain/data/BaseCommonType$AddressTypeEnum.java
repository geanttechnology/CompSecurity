// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class  extends Enum
{

    private static final BUSINESS $VALUES[];
    public static final BUSINESS BUSINESS;
    public static final BUSINESS PO_BOX;
    public static final BUSINESS RESIDENCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$AddressTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PO_BOX = new <init>("PO_BOX", 0);
        RESIDENCE = new <init>("RESIDENCE", 1);
        BUSINESS = new <init>("BUSINESS", 2);
        $VALUES = (new .VALUES[] {
            PO_BOX, RESIDENCE, BUSINESS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
