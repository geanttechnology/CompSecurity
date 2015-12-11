// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store.availability:
//            CheckStoresLink, InStoreAvailability

public class Pickup
    implements gu, Serializable
{

    private String available;
    private CheckStoresLink checkStoresLink;
    private String displayMessage;
    private InStoreAvailability inStoreAvailability;

    public Pickup()
    {
    }

    public String getAvailable()
    {
        return available;
    }

    public CheckStoresLink getCheckStoresLink()
    {
        return checkStoresLink;
    }

    public String getDisplayMessage()
    {
        return displayMessage;
    }

    public InStoreAvailability getInStoreAvailability()
    {
        return inStoreAvailability;
    }

    public void setAvailable(String s)
    {
        available = s;
    }

    public void setCheckStoresLink(CheckStoresLink checkstoreslink)
    {
        checkStoresLink = checkstoreslink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }

    public void setInStoreAvailability(InStoreAvailability instoreavailability)
    {
        inStoreAvailability = instoreavailability;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [inStoreAvailability = ").append(inStoreAvailability).append(", displayMessage = ").append(displayMessage).append(", checkStoresLink = ").append(checkStoresLink).append(", available = ").append(available).append("]").toString();
    }
}
