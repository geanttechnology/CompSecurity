// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            Location

public static class ancestry
{

    private List ancestry;
    private double lat;
    private double lng;
    private String place;
    private String storeId;
    private String venue;
    private float x;
    private float y;
    private String zone;

    public ancestry ancestry(List list)
    {
        if (list != null)
        {
            ancestry = list;
        }
        return this;
    }

    public Location build()
    {
        return new Location(this);
    }

    public ancestry lat(double d)
    {
        lat = d;
        return this;
    }

    public lat lng(double d)
    {
        lng = d;
        return this;
    }

    public lng place(String s)
    {
        place = s;
        return this;
    }

    public place storeId(String s)
    {
        storeId = s;
        return this;
    }

    public storeId venue(String s)
    {
        venue = s;
        return this;
    }

    public venue x(float f)
    {
        x = f;
        return this;
    }

    public x y(float f)
    {
        y = f;
        return this;
    }

    public y zone(String s)
    {
        zone = s;
        return this;
    }










    public ()
    {
        ancestry = new ArrayList();
    }
}
