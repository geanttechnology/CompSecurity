// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ToggleMarketplaceNotificationsResponse
{

    private String marketplaceId;
    private Boolean marketplaceSupportsNotifications;

    public ToggleMarketplaceNotificationsResponse()
    {
    }

    public String getMarketplaceId()
    {
        return marketplaceId;
    }

    public Boolean getMarketplaceSupportsNotifications()
    {
        return marketplaceSupportsNotifications;
    }

    public void setMarketplaceId(String s)
    {
        marketplaceId = s;
    }

    public void setMarketplaceSupportsNotifications(Boolean boolean1)
    {
        marketplaceSupportsNotifications = boolean1;
    }
}
