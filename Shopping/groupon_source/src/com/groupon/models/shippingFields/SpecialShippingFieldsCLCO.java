// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shippingFields;

import java.util.HashMap;
import java.util.List;

public class SpecialShippingFieldsCLCO
{

    private HashMap availableLocationsForCurrentDeal;
    private List availableRegionsForCurrentDeal;

    public SpecialShippingFieldsCLCO(List list, HashMap hashmap)
    {
        availableRegionsForCurrentDeal = list;
        availableLocationsForCurrentDeal = hashmap;
    }

    public HashMap getAvailableLocationsForCurrentDeal()
    {
        return availableLocationsForCurrentDeal;
    }

    public List getAvailableRegionsForCurrentDeal()
    {
        return availableRegionsForCurrentDeal;
    }
}
