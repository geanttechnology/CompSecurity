// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzg, zzf

public class DeviceStatus
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    private double zzUJ;
    private boolean zzUK;
    private int zzWW;
    private int zzWX;
    private ApplicationMetadata zzXh;

    public DeviceStatus()
    {
        this(3, (0.0D / 0.0D), false, -1, null, -1);
    }

    DeviceStatus(int i, double d, boolean flag, int j, ApplicationMetadata applicationmetadata, int k)
    {
        mVersionCode = i;
        zzUJ = d;
        zzUK = flag;
        zzWW = j;
        zzXh = applicationmetadata;
        zzWX = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof DeviceStatus))
            {
                return false;
            }
            obj = (DeviceStatus)obj;
            if (zzUJ != ((DeviceStatus) (obj)).zzUJ || zzUK != ((DeviceStatus) (obj)).zzUK || zzWW != ((DeviceStatus) (obj)).zzWW || !zzf.zza(zzXh, ((DeviceStatus) (obj)).zzXh) || zzWX != ((DeviceStatus) (obj)).zzWX)
            {
                return false;
            }
        }
        return true;
    }

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzXh;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Double.valueOf(zzUJ), Boolean.valueOf(zzUK), Integer.valueOf(zzWW), zzXh, Integer.valueOf(zzWX)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

    public int zzmA()
    {
        return zzWX;
    }

    public boolean zzmH()
    {
        return zzUK;
    }

    public double zzmy()
    {
        return zzUJ;
    }

    public int zzmz()
    {
        return zzWW;
    }

}
