// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static final class q
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public ArrayList attribute;
    public CurrencyAmount cost;
    public String type;

    public q()
    {
    }
}
