// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

public class InStoreAvailability
    implements gu, Serializable
{

    private String pickupMessage;
    private String storeName;

    public InStoreAvailability()
    {
    }

    public String getPickupMessage()
    {
        return pickupMessage;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public void setPickupMessage(String s)
    {
        pickupMessage = s;
    }

    public void setStoreName(String s)
    {
        storeName = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [storeName = ").append(storeName).append(", pickupMessage = ").append(pickupMessage).append("]").toString();
    }
}
