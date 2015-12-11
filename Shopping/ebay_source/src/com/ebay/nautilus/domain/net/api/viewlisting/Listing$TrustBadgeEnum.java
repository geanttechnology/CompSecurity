// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class I extends Enum
{

    private static final TOP_RATED_PLUS_LISTING $VALUES[];
    public static final TOP_RATED_PLUS_LISTING TOP_RATED_PLUS_LISTING;
    public static final TOP_RATED_PLUS_LISTING TOP_RATED_SELLER;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$TrustBadgeEnum, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        TOP_RATED_SELLER = new <init>("TOP_RATED_SELLER", 0);
        TOP_RATED_PLUS_LISTING = new <init>("TOP_RATED_PLUS_LISTING", 1);
        $VALUES = (new .VALUES[] {
            TOP_RATED_SELLER, TOP_RATED_PLUS_LISTING
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
