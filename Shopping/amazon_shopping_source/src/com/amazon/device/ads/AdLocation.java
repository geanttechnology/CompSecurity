// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

// Referenced classes of package com.amazon.device.ads:
//            InternalAdRegistration, IInternalAdRegistration, Log

class AdLocation
{
    private static final class LocationAwareness extends Enum
    {

        private static final LocationAwareness $VALUES[];
        public static final LocationAwareness LOCATION_AWARENESS_DISABLED;
        public static final LocationAwareness LOCATION_AWARENESS_NORMAL;
        public static final LocationAwareness LOCATION_AWARENESS_TRUNCATED;

        public static LocationAwareness valueOf(String s)
        {
            return (LocationAwareness)Enum.valueOf(com/amazon/device/ads/AdLocation$LocationAwareness, s);
        }

        public static LocationAwareness[] values()
        {
            return (LocationAwareness[])$VALUES.clone();
        }

        static 
        {
            LOCATION_AWARENESS_NORMAL = new LocationAwareness("LOCATION_AWARENESS_NORMAL", 0);
            LOCATION_AWARENESS_TRUNCATED = new LocationAwareness("LOCATION_AWARENESS_TRUNCATED", 1);
            LOCATION_AWARENESS_DISABLED = new LocationAwareness("LOCATION_AWARENESS_DISABLED", 2);
            $VALUES = (new LocationAwareness[] {
                LOCATION_AWARENESS_NORMAL, LOCATION_AWARENESS_TRUNCATED, LOCATION_AWARENESS_DISABLED
            });
        }

        private LocationAwareness(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String LOG_TAG = "AdLocation";
    private static final float MAX_DISTANCE_IN_KILOMETERS = 3F;
    private int arcminutePrecision;
    private LocationAwareness locationAwareness;

    public AdLocation()
    {
        locationAwareness = LocationAwareness.LOCATION_AWARENESS_TRUNCATED;
        arcminutePrecision = 6;
    }

    private static double roundToArcminutes(double d)
    {
        return (double)Math.round(d * 60D) / 60D;
    }

    public Location getLocation()
    {
        Object obj;
        Object obj1;
        obj = InternalAdRegistration.getInstance().getApplicationContext();
        if (locationAwareness == LocationAwareness.LOCATION_AWARENESS_DISABLED)
        {
            return null;
        }
        Object obj2 = (LocationManager)((Context) (obj)).getSystemService("location");
        obj = null;
        try
        {
            obj1 = ((LocationManager) (obj2)).getLastKnownLocation("gps");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Log.d("AdLocation", "Failed to retrieve GPS location: No permissions to access GPS");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            Log.d("AdLocation", "Failed to retrieve GPS location: No GPS found");
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
_L4:
        obj1 = null;
        obj2 = ((LocationManager) (obj2)).getLastKnownLocation("network");
        obj1 = obj2;
_L2:
        if (obj == null && obj1 == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        Object obj3;
        obj3;
        Log.d("AdLocation", "Failed to retrieve network location: No permissions to access network location");
        continue; /* Loop/switch isn't completed */
        obj3;
        Log.d("AdLocation", "Failed to retrieve network location: No network provider found");
        if (true) goto _L2; else goto _L1
_L1:
        if (obj != null && obj1 != null)
        {
            if (((Location) (obj)).distanceTo(((Location) (obj1))) / 1000F <= 3F)
            {
                double d;
                float f;
                float f1;
                if (((Location) (obj)).hasAccuracy())
                {
                    f = ((Location) (obj)).getAccuracy();
                } else
                {
                    f = 3.402823E+38F;
                }
                if (((Location) (obj1)).hasAccuracy())
                {
                    f1 = ((Location) (obj1)).getAccuracy();
                } else
                {
                    f1 = 3.402823E+38F;
                }
                if (f < f1)
                {
                    Log.d("AdLocation", "Setting lat/long using GPS determined by distance");
                } else
                {
                    Log.d("AdLocation", "Setting lat/long using network determined by distance");
                    obj = obj1;
                }
            } else
            if (((Location) (obj)).getTime() > ((Location) (obj1)).getTime())
            {
                Log.d("AdLocation", "Setting lat/long using GPS");
            } else
            {
                Log.d("AdLocation", "Setting lat/long using network");
                obj = obj1;
            }
        } else
        if (obj != null)
        {
            Log.d("AdLocation", "Setting lat/long using GPS, not network");
        } else
        {
            Log.d("AdLocation", "Setting lat/long using network location, not GPS");
            obj = obj1;
        }
        if (locationAwareness == LocationAwareness.LOCATION_AWARENESS_TRUNCATED)
        {
            d = roundToArcminutes(((Location) (obj)).getLatitude());
            ((Location) (obj)).setLatitude((double)Math.round(Math.pow(10D, arcminutePrecision) * d) / Math.pow(10D, arcminutePrecision));
            d = roundToArcminutes(((Location) (obj)).getLongitude());
            ((Location) (obj)).setLongitude((double)Math.round(Math.pow(10D, arcminutePrecision) * d) / Math.pow(10D, arcminutePrecision));
        }
        return ((Location) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }
}
