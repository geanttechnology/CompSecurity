// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            GetDriveIdFromUniqueIdentifierRequest

public class zzah
    implements android.os.Parcelable.Creator
{

    public zzah()
    {
    }

    static void zza(GetDriveIdFromUniqueIdentifierRequest getdriveidfromuniqueidentifierrequest, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getdriveidfromuniqueidentifierrequest.mVersionCode);
        zzb.zza(parcel, 2, getdriveidfromuniqueidentifierrequest.zzajo, false);
        zzb.zza(parcel, 3, getdriveidfromuniqueidentifierrequest.zzajp);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbc(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcQ(i);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzbc(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new GetDriveIdFromUniqueIdentifierRequest(i, s, flag);
            }
        } while (true);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] zzcQ(int i)
    {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
