// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final ISBN $VALUES[];
    public static final ISBN EAN;
    public static final ISBN GTIN;
    public static final ISBN ISBN;
    public static final ISBN UPC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$GTINTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GTIN = new <init>("GTIN", 0);
        UPC = new <init>("UPC", 1);
        EAN = new <init>("EAN", 2);
        ISBN = new <init>("ISBN", 3);
        $VALUES = (new .VALUES[] {
            GTIN, UPC, EAN, ISBN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
