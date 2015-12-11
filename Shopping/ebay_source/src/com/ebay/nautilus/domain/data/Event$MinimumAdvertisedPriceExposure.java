// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            Event

public static final class  extends Enum
{

    private static final DuringCheckout $VALUES[];
    public static final DuringCheckout DuringCheckout;
    public static final DuringCheckout None;
    public static final DuringCheckout PreCheckout;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/Event$MinimumAdvertisedPriceExposure, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        PreCheckout = new <init>("PreCheckout", 1);
        DuringCheckout = new <init>("DuringCheckout", 2);
        $VALUES = (new .VALUES[] {
            None, PreCheckout, DuringCheckout
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
