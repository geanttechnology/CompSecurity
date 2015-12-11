// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDrivePreferencesResponse

public class zzba
    implements android.os.Parcelable.Creator
{

    public zzba()
    {
    }

    static void zza(OnDrivePreferencesResponse ondrivepreferencesresponse, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, ondrivepreferencesresponse.mVersionCode);
        zzb.zza(parcel, 2, ondrivepreferencesresponse.zzamd, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbv(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdh(i);
    }

    public OnDrivePreferencesResponse zzbv(Parcel parcel)
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
                return new OnDrivePreferencesResponse(i, drivepreferences);
            }
        } while (true);
    }

    public OnDrivePreferencesResponse[] zzdh(int i)
    {
        return new OnDrivePreferencesResponse[i];
    }
}
