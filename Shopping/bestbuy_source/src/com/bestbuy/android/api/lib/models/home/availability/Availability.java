// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.availability:
//            Delivery, Download, Pickup, Ship

public class Availability
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Delivery delivery;
    private Download download;
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
