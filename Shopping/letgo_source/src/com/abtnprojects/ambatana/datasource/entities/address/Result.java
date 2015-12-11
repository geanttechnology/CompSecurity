// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.datasource.entities.address:
//            Geometry

public class Result
{

    private List addressComponents;
    private String formattedAddress;
    private Geometry geometry;
    private String placeId;
    private List types;

    public Result()
    {
        addressComponents = new ArrayList();
        types = new ArrayList();
    }

    public List getAddressComponents()
    {
        return addressComponents;
    }

    public String getFormattedAddress()
    {
        return formattedAddress;
    }

    public Geometry getGeometry()
    {
        return geometry;
    }

    public String getPlaceId()
    {
        return placeId;
    }

    public List getTypes()
    {
        return types;
    }

    public void setAddressComponents(List list)
    {
        addressComponents = list;
    }

    public void setFormattedAddress(String s)
    {
        formattedAddress = s;
    }

    public void setGeometry(Geometry geometry1)
    {
        geometry = geometry1;
    }

    public void setPlaceId(String s)
    {
        placeId = s;
    }

    public void setTypes(List list)
    {
        types = list;
    }
}
