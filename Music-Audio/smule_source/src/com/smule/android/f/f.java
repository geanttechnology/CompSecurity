// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;

public class f
{

    public static Location a(Context context)
    {
        LocationManager locationmanager;
        Iterator iterator;
        Object obj = null;
        locationmanager = (LocationManager)context.getApplicationContext().getSystemService("location");
        if (locationmanager == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        context = locationmanager.getAllProviders();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        iterator = context.iterator();
        context = obj;
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1 = (String)iterator.next();
        Location location = locationmanager.getLastKnownLocation(((String) (obj1)));
        if (location == null) goto _L4; else goto _L3
_L3:
        obj1 = location;
        if (context == null) goto _L6; else goto _L5
_L5:
        long l;
        long l1;
        l = context.getTime();
        l1 = location.getTime();
        if (l >= l1) goto _L4; else goto _L7
_L7:
        obj1 = location;
_L6:
        context = ((Context) (obj1));
          goto _L8
        obj1;
        obj1 = context;
          goto _L6
_L2:
        obj1 = context;
        if (context == null)
        {
            obj1 = new Location("dummy");
        }
        if (((Location) (obj1)).getLatitude() == 0.0D && ((Location) (obj1)).getLongitude() == 0.0D)
        {
            ((Location) (obj1)).setLatitude(37.780000000000001D);
            ((Location) (obj1)).setLongitude(-122.39100000000001D);
        }
        return ((Location) (obj1));
_L4:
        obj1 = context;
          goto _L6
        context = null;
          goto _L2
    }

    public static boolean a(float f1, float f2)
    {
        return !Float.isNaN(f1) && !Float.isNaN(f2) && ((double)f1 != 0.0D || (double)f2 != 0.0D);
    }
}
