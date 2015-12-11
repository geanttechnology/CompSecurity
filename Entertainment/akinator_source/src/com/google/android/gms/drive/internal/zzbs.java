// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            SetResourceParentsRequest

public class zzbs
    implements android.os.Parcelable.Creator
{

    public zzbs()
    {
    }

    static void zza(SetResourceParentsRequest setresourceparentsrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, setresourceparentsrequest.mVersionCode);
        zzb.zza(parcel, 2, setresourceparentsrequest.zzajY, i, false);
        zzb.zzc(parcel, 3, setresourceparentsrequest.zzams, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbM(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdy(i);
    }

    public SetResourceParentsRequest zzbM(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DriveId driveid = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DriveId.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SetResourceParentsRequest(i, driveid, arraylist);
            }
        } while (true);
    }

    public SetResourceParentsRequest[] zzdy(int i)
    {
        return new SetResourceParentsRequest[i];
    }
}
