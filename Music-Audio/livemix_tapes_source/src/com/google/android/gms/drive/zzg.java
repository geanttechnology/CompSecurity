// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive:
//            DriveSpace

public class zzg
    implements android.os.Parcelable.Creator
{

    public zzg()
    {
    }

    static void zza(DriveSpace drivespace, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, drivespace.mVersionCode);
        zzb.zza(parcel, 2, drivespace.getName(), false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzce(i);
    }

    public DriveSpace zzaA(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DriveSpace(i, s);
            }
        } while (true);
    }

    public DriveSpace[] zzce(int i)
    {
        return new DriveSpace[i];
    }
}
