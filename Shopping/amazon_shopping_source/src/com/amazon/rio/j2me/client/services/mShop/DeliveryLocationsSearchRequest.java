// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Coordinates

public class DeliveryLocationsSearchRequest
{

    private Coordinates coordinates;
    private Integer page;
    private String query;
    private String radiusKm;
    private Integer size;
    private String state;
    private int type;

    public DeliveryLocationsSearchRequest()
    {
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public Integer getPage()
    {
        return page;
    }

    public String getQuery()
    {
        return query;
    }

    public String getRadiusKm()
    {
        return radiusKm;
    }

    public Integer getSize()
    {
        return size;
    }

    public String getState()
    {
        return state;
    }

    public int getType()
    {
        return type;
    }

    public void setCoordinates(Coordinates coordinates1)
    {
        coordinates = coordinates1;
    }

    public void setPage(Integer integer)
    {
        page = integer;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setSize(Integer integer)
    {
        size = integer;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setType(int i)
    {
        type = i;
    }
}
