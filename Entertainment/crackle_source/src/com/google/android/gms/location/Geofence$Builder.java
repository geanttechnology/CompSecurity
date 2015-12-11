// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.go;

// Referenced classes of package com.google.android.gms.location:
//            Geofence

public static final class xA
{

    private int xA;
    private String xs;
    private int xt;
    private long xu;
    private short xv;
    private double xw;
    private double xx;
    private float xy;
    private int xz;

    public Geofence build()
    {
        if (xs == null)
        {
            throw new IllegalArgumentException("Request ID not set.");
        }
        if (xt == 0)
        {
            throw new IllegalArgumentException("Transitions types not set.");
        }
        if ((xt & 4) != 0 && xA < 0)
        {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
        if (xu == 0x8000000000000000L)
        {
            throw new IllegalArgumentException("Expiration not set.");
        }
        if (xv == -1)
        {
            throw new IllegalArgumentException("Geofence region not set.");
        }
        if (xz < 0)
        {
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        } else
        {
            return new go(xs, xt, (short)1, xw, xx, xy, xu, xz, xA);
        }
    }

    public xA setCircularRegion(double d, double d1, float f)
    {
        xv = 1;
        xw = d;
        xx = d1;
        xy = f;
        return this;
    }

    public xy setExpirationDuration(long l)
    {
        if (l < 0L)
        {
            xu = -1L;
            return this;
        } else
        {
            xu = SystemClock.elapsedRealtime() + l;
            return this;
        }
    }

    public xu setLoiteringDelay(int i)
    {
        xA = i;
        return this;
    }

    public xA setNotificationResponsiveness(int i)
    {
        xz = i;
        return this;
    }

    public xz setRequestId(String s)
    {
        xs = s;
        return this;
    }

    public xs setTransitionTypes(int i)
    {
        xt = i;
        return this;
    }

    public ()
    {
        xs = null;
        xt = 0;
        xu = 0x8000000000000000L;
        xv = -1;
        xz = 0;
        xA = -1;
    }
}
