// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final EBAY_CATALOG $VALUES[];
    public static final EBAY_CATALOG EBAY_CATALOG;
    public static final EBAY_CATALOG SELLER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ImageOriginEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SELLER = new <init>("SELLER", 0);
        EBAY_CATALOG = new <init>("EBAY_CATALOG", 1);
        $VALUES = (new .VALUES[] {
            SELLER, EBAY_CATALOG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
