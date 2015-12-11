// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class isSellerPromotion extends Enum
{

    private static final SME $VALUES[];
    public static final SME BillMeLaterPromotionalOffer;
    public static final SME None;
    public static final SME SME;
    public static final SME SellerDiscountedPromotionalOffer;
    public static final SME ShippingPromotionalOffer;
    public final boolean isSellerPromotion;

    public static isSellerPromotion from(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return None;
        }
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
        return (None)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$PromotionType, s);
    }

    public static None[] values()
    {
        return (None[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0, false);
        BillMeLaterPromotionalOffer = new <init>("BillMeLaterPromotionalOffer", 1, false);
        ShippingPromotionalOffer = new <init>("ShippingPromotionalOffer", 2, true);
        SellerDiscountedPromotionalOffer = new <init>("SellerDiscountedPromotionalOffer", 3, true);
        SME = new <init>("SME", 4, false);
        $VALUES = (new .VALUES[] {
            None, BillMeLaterPromotionalOffer, ShippingPromotionalOffer, SellerDiscountedPromotionalOffer, SME
        });
    }

    private (String s, int i, boolean flag)
    {
        super(s, i);
        isSellerPromotion = flag;
    }
}
