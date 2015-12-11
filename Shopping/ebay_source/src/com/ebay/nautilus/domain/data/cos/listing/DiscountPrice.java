// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.listing;

import com.ebay.nautilus.domain.data.cos.base.Amount;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.cos.listing:
//            DiscountPriceTypeEnum

public final class DiscountPrice
{

    private Amount discountAmount;
    private Double discountPercentage;
    private DiscountPriceTypeEnum discountPriceType;
    private List discountProperties;
    private Amount suggestedRetailPrice;

    public DiscountPrice()
    {
    }
}
