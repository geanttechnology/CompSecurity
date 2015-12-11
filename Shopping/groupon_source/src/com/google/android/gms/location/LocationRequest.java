// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

// Referenced classes of package com.google.android.gms.location:
//            LocationRequestCreator

public final class LocationRequest
    implements SafeParcelable
{

    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    int mPriority;
    private final int zzCY;
    boolean zzamB;
    long zzaxU;
    long zzaxV;
    int zzaxW;
    float zzaxX;
    long zzaxY;
    long zzaxz;

    public LocationRequest()
    {
        zzCY = 1;
        mPriority = 102;
        zzaxU = 0x36ee80L;
        zzaxV = 0x927c0L;
        zzamB = false;
        zzaxz = 0x7fffffffffffffffL;
        zzaxW = 0x7fffffff;
        zzaxX = 0.0F;
        zzaxY = 0L;
    }

    LocationRequest(int i, int j, long l, long l1, boolean flag, 
            long l2, int k, float f, long l3)
    {
        zzCY = i;
        mPriority = j;
        zzaxU = l;
        zzaxV = l1;
        zzamB = flag;
        zzaxz = l2;
        zzaxW = k;
        zzaxX = f;
        zzaxY = l3;
    }

    public static String zzgv(int i)
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
            if (mPriority != ((LocationRequest) (obj)).mPriority || zzaxU != ((LocationRequest) (obj)).zzaxU || zzaxV != ((LocationRequest) (obj)).zzaxV || zzamB != ((LocationRequest) (obj)).zzamB || zzaxz != ((LocationRequest) (obj)).zzaxz || zzaxW != ((LocationRequest) (obj)).zzaxW || zzaxX != ((LocationRequest) (obj)).zzaxX)
            {
                return false;
            }
        }
        return true;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            Integer.valueOf(mPriority), Long.valueOf(zzaxU), Long.valueOf(zzaxV), Boolean.valueOf(zzamB), Long.valueOf(zzaxz), Integer.valueOf(zzaxW), Float.valueOf(zzaxX)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Request[").append(zzgv(mPriority));
        if (mPriority != 105)
        {
            stringbuilder.append(" requested=");
            stringbuilder.append((new StringBuilder()).append(zzaxU).append("ms").toString());
        }
        stringbuilder.append(" fastest=");
        stringbuilder.append((new StringBuilder()).append(zzaxV).append("ms").toString());
        if (zzaxY > zzaxU)
        {
            stringbuilder.append(" maxWait=");
            stringbuilder.append((new StringBuilder()).append(zzaxY).append("ms").toString());
        }
        if (zzaxz != 0x7fffffffffffffffL)
        {
            long l = zzaxz;
            long l1 = SystemClock.elapsedRealtime();
            stringbuilder.append(" expireIn=");
            stringbuilder.append((new StringBuilder()).append(l - l1).append("ms").toString());
        }
        if (zzaxW != 0x7fffffff)
        {
            stringbuilder.append(" num=").append(zzaxW);
        }
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LocationRequestCreator.zza(this, parcel, i);
    }

}
