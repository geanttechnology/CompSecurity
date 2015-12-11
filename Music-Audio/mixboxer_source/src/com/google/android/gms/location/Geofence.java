// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.go;

public interface Geofence
{
    public static final class Builder
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

        public Builder setCircularRegion(double d, double d1, float f)
        {
            xv = 1;
            xw = d;
            xx = d1;
            xy = f;
            return this;
        }

        public Builder setExpirationDuration(long l)
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

        public Builder setLoiteringDelay(int i)
        {
            xA = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i)
        {
            xz = i;
            return this;
        }

        public Builder setRequestId(String s)
        {
            xs = s;
            return this;
        }

        public Builder setTransitionTypes(int i)
        {
            xt = i;
            return this;
        }

        public Builder()
        {
            xs = null;
            xt = 0;
            xu = 0x8000000000000000L;
            xv = -1;
            xz = 0;
            xA = -1;
        }
    }


    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1L;

    public abstract String getRequestId();
}
