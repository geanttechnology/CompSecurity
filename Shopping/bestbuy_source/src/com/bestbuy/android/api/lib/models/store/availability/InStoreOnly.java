// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store.availability:
//            InStoreAvailability

public class InStoreOnly
    implements gu, Serializable
{

    private String available;
    private InStoreAvailability inStoreAvailability;

    public InStoreOnly()
    {
    }

    public String getAvailable()
    {
        return available;
    }

    public InStoreAvailability getInStoreAvailability()
    {
        return inStoreAvailability;
    }

    public void setAvailable(String s)
    {
        available = s;
    }

    public void setInStoreAvailability(InStoreAvailability instoreavailability)
    {
        inStoreAvailability = instoreavailability;
    }
}
