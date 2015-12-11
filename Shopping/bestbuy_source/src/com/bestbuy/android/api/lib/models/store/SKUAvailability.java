// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            Sku

public class SKUAvailability
    implements gu, Serializable
{

    private Sku sku;

    public SKUAvailability()
    {
    }

    public Sku getSku()
    {
        return sku;
    }

    public void setSku(Sku sku1)
    {
        sku = sku1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [sku = ").append(sku).append("]").toString();
    }
}
