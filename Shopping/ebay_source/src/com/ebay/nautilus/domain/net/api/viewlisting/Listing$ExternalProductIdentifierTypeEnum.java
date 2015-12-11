// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final GTIN $VALUES[];
    public static final GTIN ASIN;
    public static final GTIN BUY;
    public static final GTIN GOOG;
    public static final GTIN GTIN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ExternalProductIdentifierTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ASIN = new <init>("ASIN", 0);
        GOOG = new <init>("GOOG", 1);
        BUY = new <init>("BUY", 2);
        GTIN = new <init>("GTIN", 3);
        $VALUES = (new .VALUES[] {
            ASIN, GOOG, BUY, GTIN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
