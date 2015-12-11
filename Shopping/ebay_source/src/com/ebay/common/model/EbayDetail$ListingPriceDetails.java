// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;

// Referenced classes of package com.ebay.common.model:
//            EbayDetail

public static final class 
    implements Serializable
{

    public CurrencyAmount startPrice;

    public String toString()
    {
        return startPrice.toString();
    }

    public ()
    {
    }
}
