// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

// Referenced classes of package com.google.android.gms.drive.internal:
//            SetDrivePreferencesRequest

public class zzbq
    implements android.os.Parcelable.Creator
{

    public zzbq()
    {
    }

    static void zza(SetDrivePreferencesRequest setdrivepreferencesrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, setdrivepreferencesrequest.mVersionCode);
        zzb.zza(parcel, 2, setdrivepreferencesrequest.zzamd, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdw(i);
    }

    public SetDrivePreferencesRequest zzbK(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DrivePreferences drivepreferences = null;
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
                    drivepreferences = (DrivePreferences)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DrivePreferences.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SetDrivePreferencesRequest(i, drivepreferences);
            }
        } while (true);
    }

    public SetDrivePreferencesRequest[] zzdw(int i)
    {
        return new SetDrivePreferencesRequest[i];
    }
}
