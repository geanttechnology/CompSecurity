// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            ListingFeature

class this._cls0
{

    BigDecimal commission;
    BigDecimal minimum_fee;
    final ListingFeature this$0;

    BigDecimal getCommission()
    {
        if (commission == null)
        {
            return new BigDecimal(20D);
        } else
        {
            return commission;
        }
    }

    BigDecimal getMinimumFee()
    {
        if (minimum_fee == null)
        {
            return new BigDecimal(0);
        } else
        {
            return minimum_fee;
        }
    }

    ()
    {
        this$0 = ListingFeature.this;
        super();
    }
}
