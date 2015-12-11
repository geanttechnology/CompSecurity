// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            GetDriveIdFromUniqueIdentifierRequest

public class zzai
    implements android.os.Parcelable.Creator
{

    public zzai()
    {
    }

    static void zza(GetDriveIdFromUniqueIdentifierRequest getdriveidfromuniqueidentifierrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getdriveidfromuniqueidentifierrequest.mVersionCode);
        zzb.zza(parcel, 2, getdriveidfromuniqueidentifierrequest.zzalD, false);
        zzb.zza(parcel, 3, getdriveidfromuniqueidentifierrequest.zzalE);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbk(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcW(i);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzbk(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
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

    public GetDriveIdFromUniqueIdentifierRequest[] zzcW(int i)
    {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
