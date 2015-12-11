// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final EBAY_CATALOG_REFERENCE $VALUES[];
    public static final EBAY_CATALOG_REFERENCE COPIED_FROM_SELLER_HOSTING;
    public static final EBAY_CATALOG_REFERENCE EBAY_CATALOG_REFERENCE;
    public static final EBAY_CATALOG_REFERENCE SELLER_UPLOADED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$UploadMethodEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SELLER_UPLOADED = new <init>("SELLER_UPLOADED", 0);
        COPIED_FROM_SELLER_HOSTING = new <init>("COPIED_FROM_SELLER_HOSTING", 1);
        EBAY_CATALOG_REFERENCE = new <init>("EBAY_CATALOG_REFERENCE", 2);
        $VALUES = (new .VALUES[] {
            SELLER_UPLOADED, COPIED_FROM_SELLER_HOSTING, EBAY_CATALOG_REFERENCE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
