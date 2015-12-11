// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive:
//            DriveId

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(DriveId driveid, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, driveid.mVersionCode);
        zzb.zza(parcel, 2, driveid.zzaiM, false);
        zzb.zza(parcel, 3, driveid.zzaiN);
        zzb.zza(parcel, 4, driveid.zzaiv);
        zzb.zzc(parcel, 5, driveid.zzaiO);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaF(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzch(i);
    }

    public DriveId zzaF(Parcel parcel)
    {
        long l1 = 0L;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = 0;
        String s = null;
        int i = -1;
        long l2 = 0L;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 3: // '\003'
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 4: // '\004'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new DriveId(j, s, l2, l1, i);
            }
        } while (true);
    }

    public DriveId[] zzch(int i)
    {
        return new DriveId[i];
    }
}
