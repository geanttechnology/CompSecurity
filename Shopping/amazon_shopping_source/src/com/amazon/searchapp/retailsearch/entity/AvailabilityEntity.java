// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Availability;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AvailabilityEntity extends RetailSearchEntity
    implements Availability
{

    private List fastTrack;
    private String generalAvailability;
    private String lowStockMessage;
    private String secondaryAvailability;

    public AvailabilityEntity()
    {
    }

    public List getFastTrack()
    {
        return fastTrack;
    }

    public String getGeneralAvailability()
    {
        return generalAvailability;
    }

    public String getLowStockMessage()
    {
        return lowStockMessage;
    }

    public String getSecondaryAvailability()
    {
        return secondaryAvailability;
    }

    public void setFastTrack(List list)
    {
        fastTrack = list;
    }

    public void setGeneralAvailability(String s)
    {
        generalAvailability = s;
    }

    public void setLowStockMessage(String s)
    {
        lowStockMessage = s;
    }

    public void setSecondaryAvailability(String s)
    {
        secondaryAvailability = s;
    }
}
