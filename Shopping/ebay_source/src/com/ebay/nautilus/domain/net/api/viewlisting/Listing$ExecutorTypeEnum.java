// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final EBAY $VALUES[];
    public static final EBAY BUYER;
    public static final EBAY EBAY;
    public static final EBAY SELLER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ExecutorTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BUYER = new <init>("BUYER", 0);
        SELLER = new <init>("SELLER", 1);
        EBAY = new <init>("EBAY", 2);
        $VALUES = (new .VALUES[] {
            BUYER, SELLER, EBAY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
