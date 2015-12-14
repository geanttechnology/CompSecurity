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

public class zzbw
    implements android.os.Parcelable.Creator
{

    public zzbw()
    {
    }

    static void zza(UpdatePermissionRequest updatepermissionrequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, updatepermissionrequest.mVersionCode);
        zzb.zza(parcel, 2, updatepermissionrequest.zzags, i, false);
        zzb.zza(parcel, 3, updatepermissionrequest.zzagY, false);
        zzb.zzc(parcel, 4, updatepermissionrequest.zzakb);
        zzb.zza(parcel, 5, updatepermissionrequest.zzahM);
        zzb.zza(parcel, 6, updatepermissionrequest.zzagM, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdw(i);
    }

    public UpdatePermissionRequest zzbI(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s1 = null;
        DriveId driveid = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
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
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
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

    public UpdatePermissionRequest[] zzdw(int i)
    {
        return new UpdatePermissionRequest[i];
    }
}
