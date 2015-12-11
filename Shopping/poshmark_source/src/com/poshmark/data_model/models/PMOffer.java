// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models:
//            PMOrder

public class PMOffer extends PMOrder
{

    public BigDecimal offer_price;

    public PMOffer()
    {
    }

    public BigDecimal getBasePrice()
    {
        return offer_price;
    }
}
