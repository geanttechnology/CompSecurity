// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpbuyingoptions:
//            PickUpAvailability, ShipAvailability

public class Availability
    implements gu, Serializable
{

    private static final long serialVersion = 1L;
    private PickUpAvailability pickup;
    private ShipAvailability ship;

    public Availability()
    {
    }

    public PickUpAvailability getPickup()
    {
        return pickup;
    }

    public ShipAvailability getShip()
    {
        return ship;
    }

    public void setPickup(PickUpAvailability pickupavailability)
    {
        pickup = pickupavailability;
    }

    public void setShip(ShipAvailability shipavailability)
    {
        ship = shipavailability;
    }
}
