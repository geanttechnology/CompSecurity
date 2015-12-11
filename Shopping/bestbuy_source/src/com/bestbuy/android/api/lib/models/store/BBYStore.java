// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            SKUAvailability, StoreDetails

public class BBYStore
    implements gu, Serializable
{

    private String distance;
    private SKUAvailability skuAvailability;
    private StoreDetails storeDetails;
    private String storeId;

    public BBYStore()
    {
    }

    public SKUAvailability getAvailability()
    {
        return skuAvailability;
    }

    public String getDistance()
    {
        return distance;
    }

    public StoreDetails getStoreDetails()
    {
        return storeDetails;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public void setAvailability(SKUAvailability skuavailability)
    {
        skuAvailability = skuavailability;
    }

    public void setDistance(String s)
    {
        distance = s;
    }

    public void setStoreDetails(StoreDetails storedetails)
    {
        storeDetails = storedetails;
    }

    public void setStoreId(String s)
    {
        storeId = s;
    }
}
