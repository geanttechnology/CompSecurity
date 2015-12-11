// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ShippingStatus;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ShippingStatusEntity extends RetailSearchEntity
    implements ShippingStatus
{

    private String badgeAssetId;
    private String freeRentalLabel;
    private boolean hasBadge;
    private boolean hasFreeRental;
    private String message;

    public ShippingStatusEntity()
    {
    }

    public String getBadgeAssetId()
    {
        return badgeAssetId;
    }

    public String getFreeRentalLabel()
    {
        return freeRentalLabel;
    }

    public boolean getHasBadge()
    {
        return hasBadge;
    }

    public boolean getHasFreeRental()
    {
        return hasFreeRental;
    }

    public String getMessage()
    {
        return message;
    }

    public void setBadgeAssetId(String s)
    {
        badgeAssetId = s;
    }

    public void setFreeRentalLabel(String s)
    {
        freeRentalLabel = s;
    }

    public void setHasBadge(boolean flag)
    {
        hasBadge = flag;
    }

    public void setHasFreeRental(boolean flag)
    {
        hasFreeRental = flag;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}
