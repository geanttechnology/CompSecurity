// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Locations;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class LocationsEntity extends RetailSearchEntity
    implements Locations
{

    private List domains;
    private String headerLabel;
    private List locationSelectionLabels;

    public LocationsEntity()
    {
    }

    public List getDomains()
    {
        return domains;
    }

    public String getHeaderLabel()
    {
        return headerLabel;
    }

    public List getLocationSelectionLabels()
    {
        return locationSelectionLabels;
    }

    public void setDomains(List list)
    {
        domains = list;
    }

    public void setHeaderLabel(String s)
    {
        headerLabel = s;
    }

    public void setLocationSelectionLabels(List list)
    {
        locationSelectionLabels = list;
    }
}
