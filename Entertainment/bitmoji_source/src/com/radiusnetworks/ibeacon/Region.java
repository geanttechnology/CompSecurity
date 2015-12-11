// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.util.Log;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeacon, IBeaconManager

public class Region
{

    private static final String TAG = "Region";
    protected Integer major;
    protected Integer minor;
    protected String proximityUuid;
    protected String uniqueId;

    protected Region()
    {
    }

    protected Region(Region region)
    {
        major = region.major;
        minor = region.minor;
        proximityUuid = region.proximityUuid;
        uniqueId = region.uniqueId;
    }

    public Region(String s, String s1, Integer integer, Integer integer1)
    {
        major = integer;
        minor = integer1;
        proximityUuid = normalizeProximityUuid(s1);
        uniqueId = s;
        if (s == null)
        {
            throw new NullPointerException("uniqueId may not be null");
        } else
        {
            return;
        }
    }

    public static String normalizeProximityUuid(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1 = s.toLowerCase().replaceAll("[\\-\\s]", "");
        if (s1.length() != 32)
        {
            throw new RuntimeException((new StringBuilder()).append("UUID: ").append(s).append(" is too short.  Must contain exactly 32 hex digits, and there are this value has ").append(s1.length()).append(" digits.").toString());
        }
        if (!s1.matches("^[a-fA-F0-9]*$"))
        {
            throw new RuntimeException((new StringBuilder()).append("UUID: ").append(s).append(" contains invalid characters.  Must be dashes, a-f and 0-9 characters only.").toString());
        } else
        {
            s = new StringBuilder();
            s.append(s1.substring(0, 8));
            s.append('-');
            s.append(s1.substring(8, 12));
            s.append('-');
            s.append(s1.substring(12, 16));
            s.append('-');
            s.append(s1.substring(16, 20));
            s.append('-');
            s.append(s1.substring(20, 32));
            return s.toString();
        }
    }

    public Object clone()
    {
        return new Region(this);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Region)
        {
            return ((Region)obj).uniqueId.equals(uniqueId);
        } else
        {
            return false;
        }
    }

    public Integer getMajor()
    {
        return major;
    }

    public Integer getMinor()
    {
        return minor;
    }

    public String getProximityUuid()
    {
        return proximityUuid;
    }

    public String getUniqueId()
    {
        return uniqueId;
    }

    public int hashCode()
    {
        return uniqueId.hashCode();
    }

    public boolean matchesIBeacon(IBeacon ibeacon)
    {
        if (proximityUuid == null || ibeacon.getProximityUuid().equals(proximityUuid)) goto _L2; else goto _L1
_L1:
        if (IBeaconManager.debug)
        {
            Log.d("Region", (new StringBuilder()).append("unmatching proxmityUuids: ").append(ibeacon.getProximityUuid()).append(" != ").append(proximityUuid).toString());
        }
_L4:
        return false;
_L2:
        if (major == null || ibeacon.getMajor() == major.intValue())
        {
            break; /* Loop/switch isn't completed */
        }
        if (IBeaconManager.debug)
        {
            Log.d("Region", (new StringBuilder()).append("unmatching major: ").append(ibeacon.getMajor()).append(" != ").append(major).toString());
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (minor != null && ibeacon.getMinor() != minor.intValue())
        {
            if (IBeaconManager.debug)
            {
                Log.d("Region", (new StringBuilder()).append("unmatching minor: ").append(ibeacon.getMajor()).append(" != ").append(minor).toString());
                return false;
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public String toString()
    {
        return (new StringBuilder()).append("proximityUuid: ").append(proximityUuid).append(" major: ").append(major).append(" minor:").append(minor).toString();
    }
}
