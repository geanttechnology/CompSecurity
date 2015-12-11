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
    private double zzWA;
    private boolean zzWB;
    private int zzYO;
    private int zzYP;
    private ApplicationMetadata zzYZ;

    public DeviceStatus()
    {
        this(3, (0.0D / 0.0D), false, -1, null, -1);
    }

    DeviceStatus(int i, double d, boolean flag, int j, ApplicationMetadata applicationmetadata, int k)
    {
        mVersionCode = i;
        zzWA = d;
        zzWB = flag;
        zzYO = j;
        zzYZ = applicationmetadata;
        zzYP = k;
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
            if (zzWA != ((DeviceStatus) (obj)).zzWA || zzWB != ((DeviceStatus) (obj)).zzWB || zzYO != ((DeviceStatus) (obj)).zzYO || !zzf.zza(zzYZ, ((DeviceStatus) (obj)).zzYZ) || zzYP != ((DeviceStatus) (obj)).zzYP)
            {
                return false;
            }
        }
        return true;
    }

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzYZ;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Double.valueOf(zzWA), Boolean.valueOf(zzWB), Integer.valueOf(zzYO), zzYZ, Integer.valueOf(zzYP)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

    public double zzmU()
    {
        return zzWA;
    }

    public int zzmV()
    {
        return zzYO;
    }

    public int zzmW()
    {
        return zzYP;
    }

    public boolean zznd()
    {
        return zzWB;
    }

}
