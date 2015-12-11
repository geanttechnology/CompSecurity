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

public class zzbm
    implements android.os.Parcelable.Creator
{

    public zzbm()
    {
    }

    static void zza(OpenFileIntentSenderRequest openfileintentsenderrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, openfileintentsenderrequest.mVersionCode);
        zzb.zza(parcel, 2, openfileintentsenderrequest.zzajf, false);
        zzb.zza(parcel, 3, openfileintentsenderrequest.zzajg, false);
        zzb.zza(parcel, 4, openfileintentsenderrequest.zzaji, i, false);
        zzb.zza(parcel, 5, openfileintentsenderrequest.zzamq, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbG(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzds(i);
    }

    public OpenFileIntentSenderRequest zzbG(Parcel parcel)
    {
        FilterHolder filterholder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DriveId driveid = null;
        String as[] = null;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    as = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, k);
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

    public OpenFileIntentSenderRequest[] zzds(int i)
    {
        return new OpenFileIntentSenderRequest[i];
    }
}
