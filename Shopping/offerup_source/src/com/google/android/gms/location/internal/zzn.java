// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location.internal:
//            LocationRequestUpdateData, LocationRequestInternal

public class zzn
    implements android.os.Parcelable.Creator
{

    public zzn()
    {
    }

    static void zza(LocationRequestUpdateData locationrequestupdatedata, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, locationrequestupdatedata.zzaFJ);
        zzb.zzc(parcel, 1000, locationrequestupdatedata.getVersionCode());
        zzb.zza(parcel, 2, locationrequestupdatedata.zzaFK, i, false);
        zzb.zza(parcel, 3, locationrequestupdatedata.zzwF(), false);
        zzb.zza(parcel, 4, locationrequestupdatedata.mPendingIntent, i, false);
        zzb.zza(parcel, 5, locationrequestupdatedata.zzwG(), false);
        zzb.zza(parcel, 6, locationrequestupdatedata.zzwH(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhb(i);
    }

    public LocationRequestUpdateData zzeI(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = 0;
        int i = 1;
        android.os.IBinder ibinder1 = null;
        PendingIntent pendingintent = null;
        android.os.IBinder ibinder2 = null;
        LocationRequestInternal locationrequestinternal = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    locationrequestinternal = (LocationRequestInternal)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, LocationRequestInternal.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
                    break;

                case 4: // '\004'
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PendingIntent.CREATOR);
                    break;

                case 5: // '\005'
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
                    break;

                case 6: // '\006'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new LocationRequestUpdateData(j, i, locationrequestinternal, ibinder2, pendingintent, ibinder1, ibinder);
            }
        } while (true);
    }

    public LocationRequestUpdateData[] zzhb(int i)
    {
        return new LocationRequestUpdateData[i];
    }
}
