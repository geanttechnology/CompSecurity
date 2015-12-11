// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.location:
//            RegionEvent

public class ProximityRegion
{

    private static final int MAX_MAJOR_MINOR_VALUE = 65535;
    private static final int MAX_RSSI = 100;
    private static final int MIN_RSSI = -100;
    private Double latitude;
    private Double longitude;
    private final int major;
    private final int minor;
    private final String proximityId;
    private Integer rssi;

    public ProximityRegion(String s, int i, int j)
    {
        proximityId = s;
        major = i;
        minor = j;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public int getMajor()
    {
        return major;
    }

    public int getMinor()
    {
        return minor;
    }

    public String getProximityId()
    {
        return proximityId;
    }

    public Integer getRssi()
    {
        return rssi;
    }

    public boolean isValid()
    {
        if (proximityId == null)
        {
            Logger.error("The proximity ID must not be null.");
            return false;
        }
        if (!RegionEvent.regionEventCharacterCountIsValid(proximityId))
        {
            Logger.error("The proximity ID must not be greater than 255 or less than 1 characters in length.");
            return false;
        }
        if (major > 65535 || major < 0)
        {
            Logger.error("The major must not be greater than 65535 or less than 0.");
            return false;
        }
        if (minor > 65535 || minor < 0)
        {
            Logger.error("The minor must not be greater than 65535 or less than 0.");
            return false;
        } else
        {
            return true;
        }
    }

    public void setCoordinates(Double double1, Double double2)
    {
        if (double1 == null || double2 == null)
        {
            latitude = null;
            longitude = null;
            return;
        }
        if (!RegionEvent.regionEventLatitudeIsValid(double1))
        {
            Logger.error("The latitude must be greater than or equal to -90.0 and less than or equal to 90.0 degrees.");
            latitude = null;
            return;
        }
        if (!RegionEvent.regionEventLongitudeIsValid(double2))
        {
            Logger.error("The longitude must be greater than or equal to -180.0 and less than or equal to 180.0 degrees.");
            longitude = null;
            return;
        } else
        {
            latitude = double1;
            longitude = double2;
            return;
        }
    }

    public void setRssi(Integer integer)
    {
        if (integer == null)
        {
            rssi = null;
            return;
        }
        if (integer.intValue() > 100 || integer.intValue() < -100)
        {
            Logger.error("The rssi must be greater than or equal to -100 and less than or equal to 100 dBm.");
            rssi = null;
            return;
        } else
        {
            rssi = integer;
            return;
        }
    }
}
