// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.util.ArrayList;
import java.util.List;

public class LocationsContainer
{

    private List locations;

    public LocationsContainer()
    {
        locations = new ArrayList();
    }

    public List getLocations()
    {
        return locations;
    }

    public void setLocations(List list)
    {
        locations = list;
    }
}
