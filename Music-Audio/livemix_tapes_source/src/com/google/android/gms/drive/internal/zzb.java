// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

// Referenced classes of package com.google.android.gms.drive.internal:
//            AddPermissionRequest

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(AddPermissionRequest addpermissionrequest, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addpermissionrequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addpermissionrequest.zzags, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addpermissionrequest.zzahJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addpermissionrequest.zzahK);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addpermissionrequest.zzahL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addpermissionrequest.zzahM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addpermissionrequest.zzagM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaL(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcu(i);
    }

    public AddPermissionRequest zzaL(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s1 = null;
        boolean flag1 = false;
        Permission permission = null;
        DriveId driveid = null;
        int i = 0;
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
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    permission = (Permission)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Permission.CREATOR);
                    break;

                case 4: // '\004'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 6: // '\006'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new AddPermissionRequest(i, driveid, permission, flag1, s1, flag, s);
            }
        } while (true);
    }

    public AddPermissionRequest[] zzcu(int i)
    {
        return new AddPermissionRequest[i];
    }
}
