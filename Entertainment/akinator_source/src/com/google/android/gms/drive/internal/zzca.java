// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            UpdatePermissionRequest

public class zzca
    implements android.os.Parcelable.Creator
{

    public zzca()
    {
    }

    static void zza(UpdatePermissionRequest updatepermissionrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, updatepermissionrequest.mVersionCode);
        zzb.zza(parcel, 2, updatepermissionrequest.zzaiA, i, false);
        zzb.zza(parcel, 3, updatepermissionrequest.zzajj, false);
        zzb.zzc(parcel, 4, updatepermissionrequest.zzamu);
        zzb.zza(parcel, 5, updatepermissionrequest.zzajW);
        zzb.zza(parcel, 6, updatepermissionrequest.zzaiX, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbT(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdF(i);
    }

    public UpdatePermissionRequest zzbT(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s1 = null;
        DriveId driveid = null;
        int j = 0;
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
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new UpdatePermissionRequest(j, driveid, s1, i, flag, s);
            }
        } while (true);
    }

    public UpdatePermissionRequest[] zzdF(int i)
    {
        return new UpdatePermissionRequest[i];
    }
}
