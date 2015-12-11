// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface ShippingStatus
{

    public abstract String getBadgeAssetId();

    public abstract Link getBadgeLink();

    public abstract String getFreeRentalLabel();

    public abstract boolean getHasBadge();

    public abstract boolean getHasFreeRental();

    public abstract String getMessage();

    public abstract void setBadgeAssetId(String s);

    public abstract void setBadgeLink(Link link);

    public abstract void setFreeRentalLabel(String s);

    public abstract void setHasBadge(boolean flag);

    public abstract void setHasFreeRental(boolean flag);

    public abstract void setMessage(String s);
}
