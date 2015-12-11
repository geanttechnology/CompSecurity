// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

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
    int mPriority;
    private final int mVersionCode;
    long zzaEE;
    long zzaEF;
    int zzaEG;
    float zzaEH;
    long zzaEI;
    long zzaEj;
    boolean zzasP;

    public LocationRequest()
    {
        mVersionCode = 1;
        mPriority = 102;
        zzaEE = 0x36ee80L;
        zzaEF = 0x927c0L;
        zzasP = false;
        zzaEj = 0x7fffffffffffffffL;
        zzaEG = 0x7fffffff;
        zzaEH = 0.0F;
        zzaEI = 0L;
    }

    LocationRequest(int i, int j, long l, long l1, boolean flag, 
            long l2, int k, float f, long l3)
    {
        mVersionCode = i;
        mPriority = j;
        zzaEE = l;
        zzaEF = l1;
        zzasP = flag;
        zzaEj = l2;
        zzaEG = k;
        zzaEH = f;
        zzaEI = l3;
    }

    public static LocationRequest create()
    {
        return new LocationRequest();
    }

    private static void zzK(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid interval: ")).append(l).toString());
        } else
        {
            return;
        }
    }

    private static void zzd(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid displacement: ")).append(f).toString());
        } else
        {
            return;
        }
    }

    private static void zzgP(int i)
    {
        switch (i)
        {
        case 101: // 'e'
        case 103: // 'g'
        default:
            throw new IllegalArgumentException((new StringBuilder("invalid quality: ")).append(i).toString());

        case 100: // 'd'
        case 102: // 'f'
        case 104: // 'h'
        case 105: // 'i'
            return;
        }
    }

    public static String zzgQ(int i)
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

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LocationRequest))
            {
                return false;
            }
            obj = (LocationRequest)obj;
            if (mPriority != ((LocationRequest) (obj)).mPriority || zzaEE != ((LocationRequest) (obj)).zzaEE || zzaEF != ((LocationRequest) (obj)).zzaEF || zzasP != ((LocationRequest) (obj)).zzasP || zzaEj != ((LocationRequest) (obj)).zzaEj || zzaEG != ((LocationRequest) (obj)).zzaEG || zzaEH != ((LocationRequest) (obj)).zzaEH)
            {
                return false;
            }
        }
        return true;
    }

    public final long getExpirationTime()
    {
        return zzaEj;
    }

    public final long getFastestInterval()
    {
        return zzaEF;
    }

    public final long getInterval()
    {
        return zzaEE;
    }

    public final long getMaxWaitTime()
    {
        long l1 = zzaEI;
        long l = l1;
        if (l1 < zzaEE)
        {
            l = zzaEE;
        }
        return l;
    }

    public final int getNumUpdates()
    {
        return zzaEG;
    }

    public final int getPriority()
    {
        return mPriority;
    }

    public final float getSmallestDisplacement()
    {
        return zzaEH;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(mPriority), Long.valueOf(zzaEE), Long.valueOf(zzaEF), Boolean.valueOf(zzasP), Long.valueOf(zzaEj), Integer.valueOf(zzaEG), Float.valueOf(zzaEH)
        });
    }

    public final LocationRequest setExpirationDuration(long l)
    {
        long l1 = SystemClock.elapsedRealtime();
        if (l > 0x7fffffffffffffffL - l1)
        {
            zzaEj = 0x7fffffffffffffffL;
        } else
        {
            zzaEj = l1 + l;
        }
        if (zzaEj < 0L)
        {
            zzaEj = 0L;
        }
        return this;
    }

    public final LocationRequest setExpirationTime(long l)
    {
        zzaEj = l;
        if (zzaEj < 0L)
        {
            zzaEj = 0L;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long l)
    {
        zzK(l);
        zzasP = true;
        zzaEF = l;
        return this;
    }

    public final LocationRequest setInterval(long l)
    {
        zzK(l);
        zzaEE = l;
        if (!zzasP)
        {
            zzaEF = (long)((double)zzaEE / 6D);
        }
        return this;
    }

    public final LocationRequest setMaxWaitTime(long l)
    {
        zzK(l);
        zzaEI = l;
        return this;
    }

    public final LocationRequest setNumUpdates(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid numUpdates: ")).append(i).toString());
        } else
        {
            zzaEG = i;
            return this;
        }
    }

    public final LocationRequest setPriority(int i)
    {
        zzgP(i);
        mPriority = i;
        return this;
    }

    public final LocationRequest setSmallestDisplacement(float f)
    {
        zzd(f);
        zzaEH = f;
        return this;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Request[").append(zzgQ(mPriority));
        if (mPriority != 105)
        {
            stringbuilder.append(" requested=");
            stringbuilder.append(zzaEE).append("ms");
        }
        stringbuilder.append(" fastest=");
        stringbuilder.append(zzaEF).append("ms");
        if (zzaEI > zzaEE)
        {
            stringbuilder.append(" maxWait=");
            stringbuilder.append(zzaEI).append("ms");
        }
        if (zzaEj != 0x7fffffffffffffffL)
        {
            long l = zzaEj;
            long l1 = SystemClock.elapsedRealtime();
            stringbuilder.append(" expireIn=");
            stringbuilder.append(l - l1).append("ms");
        }
        if (zzaEG != 0x7fffffff)
        {
            stringbuilder.append(" num=").append(zzaEG);
        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        LocationRequestCreator.zza(this, parcel, i);
    }

}
