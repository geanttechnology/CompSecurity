// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            ControlProgressRequest

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(ControlProgressRequest controlprogressrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, controlprogressrequest.mVersionCode);
        zzb.zzc(parcel, 2, controlprogressrequest.zzakj);
        zzb.zzc(parcel, 3, controlprogressrequest.zzakk);
        zzb.zza(parcel, 4, controlprogressrequest.zzaiA, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaZ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcG(i);
    }

    public ControlProgressRequest zzaZ(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveid = null;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, DriveId.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new ControlProgressRequest(i, j, k, driveid);
            }
        } while (true);
    }

    public ControlProgressRequest[] zzcG(int i)
    {
        return new ControlProgressRequest[i];
    }
}
