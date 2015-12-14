// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.common.logging.MoPubLog;
import java.math.BigDecimal;

public class LocationService
{
    public static final class LocationAwareness extends Enum
    {

        private static final LocationAwareness $VALUES[];
        public static final LocationAwareness DISABLED;
        public static final LocationAwareness NORMAL;
        public static final LocationAwareness TRUNCATED;

        public static LocationAwareness fromMoPubLocationAwareness(MoPub.LocationAwareness locationawareness)
        {
            if (locationawareness == MoPub.LocationAwareness.DISABLED)
            {
                return DISABLED;
            }
            if (locationawareness == MoPub.LocationAwareness.TRUNCATED)
            {
                return TRUNCATED;
            } else
            {
                return NORMAL;
            }
        }

        public static LocationAwareness valueOf(String s)
        {
            return (LocationAwareness)Enum.valueOf(com/mopub/common/LocationService$LocationAwareness, s);
        }

        public static LocationAwareness[] values()
        {
            return (LocationAwareness[])$VALUES.clone();
        }

        public MoPub.LocationAwareness getNewLocationAwareness()
        {
            if (this == TRUNCATED)
            {
                return MoPub.LocationAwareness.TRUNCATED;
            }
            if (this == DISABLED)
            {
                return MoPub.LocationAwareness.DISABLED;
            } else
            {
                return MoPub.LocationAwareness.NORMAL;
            }
        }

        static 
        {
            NORMAL = new LocationAwareness("NORMAL", 0);
            TRUNCATED = new LocationAwareness("TRUNCATED", 1);
            DISABLED = new LocationAwareness("DISABLED", 2);
            $VALUES = (new LocationAwareness[] {
                NORMAL, TRUNCATED, DISABLED
            });
        }

        private LocationAwareness(String s, int i)
        {
            super(s, i);
        }
    }


    public LocationService()
    {
    }

    public static Location getLastKnownLocation(Context context, int i, MoPub.LocationAwareness locationawareness)
    {
        if (locationawareness != MoPub.LocationAwareness.DISABLED) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L6:
        return ((Location) (obj));
_L2:
        Object obj1;
        obj1 = (LocationManager)context.getSystemService("location");
        context = null;
        obj = ((LocationManager) (obj1)).getLastKnownLocation("gps");
        context = ((Context) (obj));
_L3:
        obj = null;
        obj1 = ((LocationManager) (obj1)).getLastKnownLocation("network");
        obj = obj1;
_L4:
        if (context == null && obj == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_115;
        obj;
        MoPubLog.d("Failed to retrieve GPS location: access appears to be disabled.");
          goto _L3
        obj;
        MoPubLog.d("Failed to retrieve GPS location: device has no GPS provider.");
          goto _L3
        obj;
        MoPubLog.d("Failed to retrieve GPS location: device has no GPS provider.");
          goto _L3
        Object obj2;
        obj2;
        MoPubLog.d("Failed to retrieve network location: access appears to be disabled.");
          goto _L4
        obj2;
        MoPubLog.d("Failed to retrieve network location: device has no network provider.");
          goto _L4
        obj2;
        MoPubLog.d("Failed to retrieve GPS location: device has no network provider.");
          goto _L4
        if (context != null && obj != null)
        {
            if (context.getTime() <= ((Location) (obj)).getTime())
            {
                context = ((Context) (obj));
            }
        } else
        if (context == null)
        {
            context = ((Context) (obj));
        }
        obj = context;
        if (locationawareness == MoPub.LocationAwareness.TRUNCATED)
        {
            context.setLatitude(BigDecimal.valueOf(context.getLatitude()).setScale(i, 5).doubleValue());
            context.setLongitude(BigDecimal.valueOf(context.getLongitude()).setScale(i, 5).doubleValue());
            return context;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
