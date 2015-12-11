// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import com.pointinside.maps.Location;
import java.util.Iterator;
import java.util.List;

public class NavUtils
{

    public NavUtils()
    {
    }

    public static void checkWaypoint(Location location)
    {
        while (location == null || location.zone != null) 
        {
            return;
        }
        throw new IllegalArgumentException("In order to use the Location to create a Waypoint, the Location Zone must be specified");
    }

    public static void checkWaypoints(List list)
    {
        if (list == null)
        {
            return;
        }
        for (list = list.iterator(); list.hasNext(); checkWaypoint((Location)list.next())) { }
        new android.location.Location("asf");
    }
}
