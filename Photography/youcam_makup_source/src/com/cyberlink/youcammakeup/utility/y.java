// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Pair;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            z

public class y
{

    public static final Pair a = Pair.create(Double.valueOf(0.0D), Double.valueOf(0.0D));
    private Location b;

    public y()
    {
        b = null;
    }

    public static y a()
    {
        return z.a();
    }

    protected static boolean a(Location location, Location location1)
    {
        if (location1 != null)
        {
            long l = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l > 0x1d4c0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l < 0xfffffffffffe2b40L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return false;
                }
                int i = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag3;
                boolean flag4;
                if (i > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (i < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (i > 200)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                flag4 = a(location.getProvider(), location1.getProvider());
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean a(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null;
        } else
        {
            return s.equals(s1);
        }
    }

    public Location a(Context context)
    {
        LocationManager locationmanager;
        locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null)
        {
            return c();
        }
        context = null;
        Location location = locationmanager.getLastKnownLocation("gps");
        context = location;
_L2:
        if (context != null && a(((Location) (context)), b))
        {
            b = context;
            return c();
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        m.b("GpsUtils", "GPS", exception);
        if (true) goto _L2; else goto _L1
_L1:
        exception = locationmanager.getLastKnownLocation("network");
        context = exception;
_L4:
        if (context != null && a(((Location) (context)), b))
        {
            b = context;
            return c();
        }
        break; /* Loop/switch isn't completed */
        exception;
        m.b("GpsUtils", "NETWORK", exception);
        if (true) goto _L4; else goto _L3
_L3:
        exception = locationmanager.getLastKnownLocation("passive");
        context = exception;
_L5:
        if (context != null && a(((Location) (context)), b))
        {
            b = context;
            return c();
        } else
        {
            return c();
        }
        exception;
        m.b("GpsUtils", "PASSIVE", exception);
          goto _L5
    }

    public void a(Location location)
    {
        if (location == null)
        {
            b = null;
            return;
        } else
        {
            b = new Location(location);
            return;
        }
    }

    public Pair b()
    {
        if (b == null)
        {
            return a;
        } else
        {
            return Pair.create(Double.valueOf(b.getLatitude()), Double.valueOf(b.getLongitude()));
        }
    }

    public Location c()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return new Location(b);
        }
    }

}
