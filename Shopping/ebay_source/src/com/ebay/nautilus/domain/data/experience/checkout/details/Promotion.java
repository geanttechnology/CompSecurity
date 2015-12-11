// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;

import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.details:
//            PromotionType

public class Promotion
{

    public boolean applied;
    public TextualDisplayValue discount;
    public String message;
    public PromotionType type;

    public Promotion()
    {
    }
}
