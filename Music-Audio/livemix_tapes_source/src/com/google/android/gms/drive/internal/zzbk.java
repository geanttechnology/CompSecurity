// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OpenFileIntentSenderRequest

public class zzbk
    implements android.os.Parcelable.Creator
{

    public zzbk()
    {
    }

    static void zza(OpenFileIntentSenderRequest openfileintentsenderrequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openfileintentsenderrequest.mVersionCode);
        zzb.zza(parcel, 2, openfileintentsenderrequest.zzagU, false);
        zzb.zza(parcel, 3, openfileintentsenderrequest.zzagV, false);
        zzb.zza(parcel, 4, openfileintentsenderrequest.zzagX, i, false);
        zzb.zza(parcel, 5, openfileintentsenderrequest.zzajX, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbx(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdl(i);
    }

    public OpenFileIntentSenderRequest zzbx(Parcel parcel)
    {
        FilterHolder filterholder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        DriveId driveid = null;
        String as[] = null;
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

                case 3: // '\003'
                    as = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, k);
                    break;

                case 4: // '\004'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
                    break;

                case 5: // '\005'
                    filterholder = (FilterHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, FilterHolder.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OpenFileIntentSenderRequest(i, s, as, driveid, filterholder);
            }
        } while (true);
    }

    public OpenFileIntentSenderRequest[] zzdl(int i)
    {
        return new OpenFileIntentSenderRequest[i];
    }
}
