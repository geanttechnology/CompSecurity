// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.division.Division;
import java.util.Comparator;
import java.util.HashMap;

// Referenced classes of package com.groupon.service:
//            DealIntentService

class val.lng
    implements Comparator
{

    final DealIntentService this$0;
    final double val$lat;
    final double val$lng;
    final HashMap val$minDistances;

    public int compare(Division division, Division division1)
    {
        double d1 = 1.7976931348623157E+308D;
        double d;
        double d2;
        if (val$minDistances.containsKey(division))
        {
            d = ((Double)val$minDistances.get(division)).doubleValue();
        } else
        {
            d = d1;
            if (division != null)
            {
                long l = division1.latE6;
                long l2 = division1.lngE6;
                d = d1;
                if (l != 0L)
                {
                    d = d1;
                    if (l2 != 0L)
                    {
                        d = Math.min(1.7976931348623157E+308D, Math.sqrt(((double)l - val$lat) * ((double)l - val$lat) + ((double)l2 - val$lng) * ((double)l2 - val$lng)));
                    }
                }
                val$minDistances.put(division, Double.valueOf(d));
            }
        }
        d2 = 1.7976931348623157E+308D;
        if (val$minDistances.containsKey(division1))
        {
            d1 = ((Double)val$minDistances.get(division1)).doubleValue();
        } else
        {
            d1 = d2;
            if (division1 != null)
            {
                long l1 = division1.latE6;
                long l3 = division1.lngE6;
                d1 = d2;
                if (l1 != 0L)
                {
                    d1 = d2;
                    if (l3 != 0L)
                    {
                        d1 = Math.min(1.7976931348623157E+308D, Math.sqrt(((double)l1 - val$lat) * ((double)l1 - val$lat) + ((double)l3 - val$lng) * ((double)l3 - val$lng)));
                    }
                }
                val$minDistances.put(division1, Double.valueOf(d1));
            }
        }
        return Double.compare(d, d1);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Division)obj, (Division)obj1);
    }

    ()
    {
        this$0 = final_dealintentservice;
        val$minDistances = hashmap;
        val$lat = d;
        val$lng = D.this;
        super();
    }
}
