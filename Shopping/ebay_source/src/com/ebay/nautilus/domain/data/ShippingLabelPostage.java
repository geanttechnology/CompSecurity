// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CurrencyAmount

public class ShippingLabelPostage extends BaseDataMapped
{

    public CurrencyAmount amount;
    public String label;

    public ShippingLabelPostage()
    {
    }
}
