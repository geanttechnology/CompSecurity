// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class Q extends Enum
{

    private static final OUT_OF_STOCK $VALUES[];
    public static final OUT_OF_STOCK IN_STOCK;
    public static final OUT_OF_STOCK LIMITED_STOCK;
    public static final OUT_OF_STOCK OUT_OF_STOCK;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$AvailabilityStatusEnum, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        IN_STOCK = new <init>("IN_STOCK", 0);
        LIMITED_STOCK = new <init>("LIMITED_STOCK", 1);
        OUT_OF_STOCK = new <init>("OUT_OF_STOCK", 2);
        $VALUES = (new .VALUES[] {
            IN_STOCK, LIMITED_STOCK, OUT_OF_STOCK
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
