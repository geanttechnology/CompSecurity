// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface f
{
    public static final class a
    {

        private String a;
        private int b;
        private long c;
        private short d;
        private double e;
        private double f;
        private float g;
        private int h;
        private int i;

        public a a(double d1, double d2, float f1)
        {
            d = 1;
            e = d1;
            f = d2;
            g = f1;
            return this;
        }

        public a a(int j)
        {
            b = j;
            return this;
        }

        public a a(long l)
        {
            if (l < 0L)
            {
                c = -1L;
                return this;
            } else
            {
                c = SystemClock.elapsedRealtime() + l;
                return this;
            }
        }

        public a a(String s)
        {
            a = s;
            return this;
        }

        public f a()
        {
            if (a == null)
            {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (b == 0)
            {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((b & 4) != 0 && i < 0)
            {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (c == 0x8000000000000000L)
            {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (d == -1)
            {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (h < 0)
            {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            } else
            {
                return new ParcelableGeofence(a, b, (short)1, e, f, g, c, h, i);
            }
        }

        public a()
        {
            a = null;
            b = 0;
            c = 0x8000000000000000L;
            d = -1;
            h = 0;
            i = -1;
        }
    }


    public abstract String a();
}
