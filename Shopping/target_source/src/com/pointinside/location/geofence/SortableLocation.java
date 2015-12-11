// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;

class SortableLocation
    implements Comparable
{

    final Location location;

    SortableLocation(Location location1)
    {
        if (location1 == null)
        {
            location1 = null;
        } else
        {
            location1 = new Location(location1);
        }
        location = location1;
    }

    private int compareMoreRecent(long l, long l1)
    {
        l -= l1;
        if (l < 0L)
        {
            return -1;
        }
        return l <= 0L ? 0 : 1;
    }

    public int compareTo(SortableLocation sortablelocation)
    {
        if (location != null && sortablelocation.location != null) goto _L2; else goto _L1
_L1:
        if (location != null) goto _L4; else goto _L3
_L3:
        int i = -1;
_L6:
        return i;
_L4:
        return 1;
_L2:
        int k = compareMoreRecent(location.getTime(), sortablelocation.location.getTime());
        int j = Float.compare(sortablelocation.location.getAccuracy(), location.getAccuracy());
        i = j;
        if (j == 0)
        {
            return k;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SortableLocation)obj);
    }
}
