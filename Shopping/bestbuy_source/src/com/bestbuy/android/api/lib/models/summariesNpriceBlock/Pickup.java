// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import com.bestbuy.android.api.lib.models.home.availability.InStoreAvailability;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            CheckShipLink

public class Pickup
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean available;
    private CheckShipLink checkStoresLink;
    private String displayMessage;
    private InStoreAvailability inStoreAvailability;

    public Pickup()
    {
    }

    public CheckShipLink getCheckStoresLink()
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

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean flag)
    {
        available = flag;
    }

    public void setCheckStoresLink(CheckShipLink checkshiplink)
    {
        checkStoresLink = checkshiplink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }

    public void setInStoreAvailability(InStoreAvailability instoreavailability)
    {
        inStoreAvailability = instoreavailability;
    }
}
