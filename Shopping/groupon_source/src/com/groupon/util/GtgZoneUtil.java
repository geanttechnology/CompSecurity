// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Location;
import com.groupon.models.gdt.GtgZone;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            Dates, LocationsUtil

public class GtgZoneUtil
{

    private static final String GTG_ZONES_POINTS_SEPARATOR = ";";
    private static final String GTG_ZONE_AB_TEST_NAME_PATTERN = "GTGZone%s1511US";
    private static final String GTG_ZONE_COORDINATES_SEPARATOR = ",";
    private AbTestService abTestService;
    private LocationService locationService;

    public GtgZoneUtil()
    {
    }

    private List getGtgZonesFromAbTests(int i)
    {
        ArrayList arraylist;
        int j;
        arraylist = new ArrayList(i);
        j = 1;
_L2:
        String as[];
        if (j > i)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        as = abTestService.getVariant(String.format("GTGZone%s1511US", new Object[] {
            String.valueOf(j)
        })).split(";");
        if (as.length == 4)
        {
            break; /* Loop/switch isn't completed */
        }
_L6:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        ArrayList arraylist1;
        int k;
        int l;
        arraylist1 = new ArrayList(4);
        l = as.length;
        k = 0;
_L7:
        if (k >= l) goto _L4; else goto _L3
_L3:
        String as1[] = as[k].split(",");
        if (as1.length == 2) goto _L5; else goto _L4
_L4:
        if (arraylist1.size() == 4)
        {
            GtgZone gtgzone = new GtgZone();
            gtgzone.locationPoints = arraylist1;
            arraylist.add(gtgzone);
        }
          goto _L6
_L5:
        double d;
        double d1;
        d = Double.parseDouble(as1[0]);
        d1 = Double.parseDouble(as1[1]);
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d1);
        arraylist1.add(location);
        k++;
          goto _L7
        NumberFormatException numberformatexception;
        numberformatexception;
        Ln.v(numberformatexception);
          goto _L4
        return arraylist;
          goto _L6
    }

    public boolean isCurrentLocationInValidZone()
    {
        int i = abTestService.getVariantAsInt("GTGNumberOfZones1511US");
        Location location = locationService.getLocation();
        if (i > 0 && location != null && !Dates.isOlderThanADay(location.getTime()))
        {
            Iterator iterator = getGtgZonesFromAbTests(i).iterator();
            while (iterator.hasNext()) 
            {
                if (LocationsUtil.isPointContainedInPolygon(((GtgZone)iterator.next()).locationPoints, location))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
