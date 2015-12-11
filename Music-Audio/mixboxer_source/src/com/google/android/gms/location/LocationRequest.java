// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;

// Referenced classes of package com.google.android.gms.location:
//            LocationRequestCreator

public final class LocationRequest
    implements SafeParcelable
{

    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private final int kg;
    int mPriority;
    long xB;
    long xC;
    boolean xD;
    int xE;
    float xF;
    long xu;

    public LocationRequest()
    {
        kg = 1;
        mPriority = 102;
        xB = 0x36ee80L;
        xC = 0x927c0L;
        xD = false;
        xu = 0x7fffffffffffffffL;
        xE = 0x7fffffff;
        xF = 0.0F;
    }

    LocationRequest(int i, int j, long l, long l1, boolean flag, 
            long l2, int k, float f)
    {
        kg = i;
        mPriority = j;
        xB = l;
        xC = l1;
        xD = flag;
        xu = l2;
        xE = k;
        xF = f;
    }

    private static void a(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid displacement: ").append(f).toString());
        } else
        {
            return;
        }
    }

    private static void aO(int i)
    {
        switch (i)
        {
        case 101: // 'e'
        case 103: // 'g'
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("invalid quality: ").append(i).toString());

        case 100: // 'd'
        case 102: // 'f'
        case 104: // 'h'
        case 105: // 'i'
            return;
        }
    }

    public static String aP(int i)
    {
        switch (i)
        {
        case 101: // 'e'
        case 103: // 'g'
        default:
            return "???";

        case 100: // 'd'
            return "PRIORITY_HIGH_ACCURACY";

        case 102: // 'f'
            return "PRIORITY_BALANCED_POWER_ACCURACY";

        case 104: // 'h'
            return "PRIORITY_LOW_POWER";

        case 105: // 'i'
            return "PRIORITY_NO_POWER";
        }
    }

    public static LocationRequest create()
    {
        return new LocationRequest();
    }

    private static void m(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid interval: ").append(l).toString());
        } else
        {
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LocationRequest))
            {
                return false;
            }
            obj = (LocationRequest)obj;
            if (mPriority != ((LocationRequest) (obj)).mPriority || xB != ((LocationRequest) (obj)).xB || xC != ((LocationRequest) (obj)).xC || xD != ((LocationRequest) (obj)).xD || xu != ((LocationRequest) (obj)).xu || xE != ((LocationRequest) (obj)).xE || xF != ((LocationRequest) (obj)).xF)
            {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime()
    {
        return xu;
    }

    public long getFastestInterval()
    {
        return xC;
    }

    public long getInterval()
    {
        return xB;
    }

    public int getNumUpdates()
    {
        return xE;
    }

    public int getPriority()
    {
        return mPriority;
    }

    public float getSmallestDisplacement()
    {
        return xF;
    }

    int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(mPriority), Long.valueOf(xB), Long.valueOf(xC), Boolean.valueOf(xD), Long.valueOf(xu), Integer.valueOf(xE), Float.valueOf(xF)
        });
    }

    public LocationRequest setExpirationDuration(long l)
    {
        long l1 = SystemClock.elapsedRealtime();
        if (l > 0x7fffffffffffffffL - l1)
        {
            xu = 0x7fffffffffffffffL;
        } else
        {
            xu = l1 + l;
        }
        if (xu < 0L)
        {
            xu = 0L;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long l)
    {
        xu = l;
        if (xu < 0L)
        {
            xu = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long l)
    {
        m(l);
        xD = true;
        xC = l;
        return this;
    }

    public LocationRequest setInterval(long l)
    {
        m(l);
        xB = l;
        if (!xD)
        {
            xC = (long)((double)xB / 6D);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid numUpdates: ").append(i).toString());
        } else
        {
            xE = i;
            return this;
        }
    }

    public LocationRequest setPriority(int i)
    {
        aO(i);
        mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f)
    {
        a(f);
        xF = f;
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Request[").append(aP(mPriority));
        if (mPriority != 105)
        {
            stringbuilder.append(" requested=");
            stringbuilder.append((new StringBuilder()).append(xB).append("ms").toString());
        }
        stringbuilder.append(" fastest=");
        stringbuilder.append((new StringBuilder()).append(xC).append("ms").toString());
        if (xu != 0x7fffffffffffffffL)
        {
            long l = xu;
            long l1 = SystemClock.elapsedRealtime();
            stringbuilder.append(" expireIn=");
            stringbuilder.append((new StringBuilder()).append(l - l1).append("ms").toString());
        }
        if (xE != 0x7fffffff)
        {
            stringbuilder.append(" num=").append(xE);
        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LocationRequestCreator.a(this, parcel, i);
    }

}
