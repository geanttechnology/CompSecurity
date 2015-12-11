// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.net.EndpointType;
import java.util.HashMap;

// Referenced classes of package com.pointinside.net.url:
//            FeedsURLBuilder

public class FeedsVenueLocationURLBuilder extends FeedsURLBuilder
{

    public static final String KEY_IS_ACTIVE = "isActive".intern();
    public static final String KEY_LAT_LON = "location".intern();
    public static final String KEY_RADIUS = "radius".intern();
    public Boolean isActive;
    public double latitude;
    public double longitude;
    public Integer radius;

    public FeedsVenueLocationURLBuilder()
    {
        super(EndpointType.FEED_LOCATION, null);
        isActive = null;
    }

    public FeedsVenueLocationURLBuilder(String s)
    {
        super(s);
        isActive = null;
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        setQualifiers("lookup");
        setParameterOrClear(KEY_IS_ACTIVE, isActive);
        setParameterOrClear(KEY_LAT_LON, String.format("%f,%f", new Object[] {
            Double.valueOf(latitude), Double.valueOf(longitude)
        }));
        if (radius != null && radius.intValue() > 0)
        {
            parameters.put(KEY_RADIUS, radius.toString());
        }
    }

}
