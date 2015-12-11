// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class  extends Enum
{

    private static final TargetedOffer $VALUES[];
    public static final TargetedOffer BundleOffer;
    public static final TargetedOffer MarkDownSale;
    public static final TargetedOffer None;
    public static final TargetedOffer OrderSubTotalOffer;
    public static final TargetedOffer PromotionalShipping;
    public static final TargetedOffer RebateOffer;
    public static final TargetedOffer SaleAndClearence;
    public static final TargetedOffer SaleEvent;
    public static final TargetedOffer TargetedOffer;
    public static final TargetedOffer VerticalOffer;

    public static  from(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return None;
        }
        return s;
    }

    public static None valueOf(String s)
    {
        return (None)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$OfferType, s);
    }

    public static None[] values()
    {
        return (None[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        BundleOffer = new <init>("BundleOffer", 1);
        OrderSubTotalOffer = new <init>("OrderSubTotalOffer", 2);
        SaleEvent = new <init>("SaleEvent", 3);
        PromotionalShipping = new <init>("PromotionalShipping", 4);
        SaleAndClearence = new <init>("SaleAndClearence", 5);
        VerticalOffer = new <init>("VerticalOffer", 6);
        RebateOffer = new <init>("RebateOffer", 7);
        MarkDownSale = new <init>("MarkDownSale", 8);
        TargetedOffer = new <init>("TargetedOffer", 9);
        $VALUES = (new .VALUES[] {
            None, BundleOffer, OrderSubTotalOffer, SaleEvent, PromotionalShipping, SaleAndClearence, VerticalOffer, RebateOffer, MarkDownSale, TargetedOffer
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
