// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store.availability:
//            Delivery, Download, InStoreOnly, Pickup, 
//            Ship

public class Availability
    implements gu, Serializable
{

    private Delivery delivery;
    private Download download;
    private InStoreOnly inStoreOnly;
    private Pickup pickup;
    private Ship ship;

    public Availability()
    {
    }

    public Delivery getDelivery()
    {
        return delivery;
    }

    public Download getDownload()
    {
        return download;
    }

    public InStoreOnly getInStoreOnly()
    {
        return inStoreOnly;
    }

    public Pickup getPickup()
    {
        return pickup;
    }

    public Ship getShip()
    {
        return ship;
    }

    public void setDelivery(Delivery delivery1)
    {
        delivery = delivery1;
    }

    public void setDownload(Download download1)
    {
        download = download1;
    }

    public void setInStoreOnly(InStoreOnly instoreonly)
    {
        inStoreOnly = instoreonly;
    }

    public void setPickup(Pickup pickup1)
    {
        pickup = pickup1;
    }

    public void setShip(Ship ship1)
    {
        ship = ship1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [pickup = ").append(pickup).append(", ship = ").append(ship).append("]").toString();
    }
}
