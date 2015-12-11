// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Price

public class Amount
{

    BigDecimal val;

    public Amount()
    {
    }

    public void copy(Price price)
    {
        val = price.val;
    }
}
