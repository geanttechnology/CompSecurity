// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.Location;
import java.util.List;
import oauth.signpost.OAuth;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GeoPoint, GeoUtils

public class RedemptionUtils
{

    private static final String HEIGHT_IN_PIXELS_VALUE = "48";
    private static final String XDIM_VALUE = "2";
    private GeoUtils geoUtils;

    public RedemptionUtils()
    {
    }

    public static String addBarcodeParams(String s)
    {
        if (Strings.isEmpty(s))
        {
            return s;
        } else
        {
            return OAuth.addQueryParameters(s, new String[] {
                "xdim", "2", "height_in_pixels", "48"
            });
        }
    }

    public int findClosestLocationTo(GeoPoint geopoint, List list)
    {
        boolean flag = false;
        int j = 0;
        int k = ((flag) ? 1 : 0);
        if (geopoint != null)
        {
            k = ((flag) ? 1 : 0);
            if (list != null)
            {
                k = ((flag) ? 1 : 0);
                if (list.size() > 0)
                {
                    double d = 1.7976931348623157E+308D;
                    int i = 0;
                    do
                    {
                        k = j;
                        if (i >= list.size())
                        {
                            break;
                        }
                        Location location = (Location)list.get(i);
                        double d2 = location.lat;
                        double d3 = location.lng;
                        k = j;
                        double d1 = d;
                        if (d2 != 0.0D)
                        {
                            k = j;
                            d1 = d;
                            if (d3 != 0.0D)
                            {
                                GeoPoint geopoint1 = new GeoPoint((int)(1000000D * d2), (int)(1000000D * d3));
                                d2 = geoUtils.distanceBetween(geopoint, geopoint1);
                                k = j;
                                d1 = d;
                                if (d2 < d)
                                {
                                    k = i;
                                    d1 = d2;
                                }
                            }
                        }
                        i++;
                        j = k;
                        d = d1;
                    } while (true);
                }
            }
        }
        return k;
    }
}
