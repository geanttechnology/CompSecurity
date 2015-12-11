// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

// Referenced classes of package com.google.android.gms.location:
//            Geofence

public final class zzaEp
{

    private String zzBY;
    private int zzaEi;
    private long zzaEj;
    private short zzaEk;
    private double zzaEl;
    private double zzaEm;
    private float zzaEn;
    private int zzaEo;
    private int zzaEp;

    public final Geofence build()
    {
        if (zzBY == null)
        {
            throw new IllegalArgumentException("Request ID not set.");
        }
        if (zzaEi == 0)
        {
            throw new IllegalArgumentException("Transitions types not set.");
        }
        if ((zzaEi & 4) != 0 && zzaEp < 0)
        {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
        if (zzaEj == 0x8000000000000000L)
        {
            throw new IllegalArgumentException("Expiration not set.");
        }
        if (zzaEk == -1)
        {
            throw new IllegalArgumentException("Geofence region not set.");
        }
        if (zzaEo < 0)
        {
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        } else
        {
            return new ParcelableGeofence(zzBY, zzaEi, (short)1, zzaEl, zzaEm, zzaEn, zzaEj, zzaEo, zzaEp);
        }
    }

    public final zzaEp setCircularRegion(double d, double d1, float f)
    {
        zzaEk = 1;
        zzaEl = d;
        zzaEm = d1;
        zzaEn = f;
        return this;
    }

    public final zzaEn setExpirationDuration(long l)
    {
        if (l < 0L)
        {
            zzaEj = -1L;
            return this;
        } else
        {
            zzaEj = SystemClock.elapsedRealtime() + l;
            return this;
        }
    }

    public final zzaEj setLoiteringDelay(int i)
    {
        zzaEp = i;
        return this;
    }

    public final zzaEp setNotificationResponsiveness(int i)
    {
        zzaEo = i;
        return this;
    }

    public final zzaEo setRequestId(String s)
    {
        zzBY = s;
        return this;
    }

    public final zzBY setTransitionTypes(int i)
    {
        zzaEi = i;
        return this;
    }

    public leGeofence()
    {
        zzBY = null;
        zzaEi = 0;
        zzaEj = 0x8000000000000000L;
        zzaEk = -1;
        zzaEo = 0;
        zzaEp = -1;
    }
}
