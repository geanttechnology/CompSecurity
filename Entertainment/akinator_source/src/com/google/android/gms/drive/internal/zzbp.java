// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            RemovePermissionRequest

public class zzbp
    implements android.os.Parcelable.Creator
{

    public zzbp()
    {
    }

    static void zza(RemovePermissionRequest removepermissionrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, removepermissionrequest.mVersionCode);
        zzb.zza(parcel, 2, removepermissionrequest.zzaiA, i, false);
        zzb.zza(parcel, 3, removepermissionrequest.zzajj, false);
        zzb.zza(parcel, 4, removepermissionrequest.zzajW);
        zzb.zza(parcel, 5, removepermissionrequest.zzaiX, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbJ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdv(i);
    }

    public RemovePermissionRequest zzbJ(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s1 = null;
        DriveId driveid = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new RemovePermissionRequest(i, driveid, s1, flag, s);
            }
        } while (true);
    }

    public RemovePermissionRequest[] zzdv(int i)
    {
        return new RemovePermissionRequest[i];
    }
}
