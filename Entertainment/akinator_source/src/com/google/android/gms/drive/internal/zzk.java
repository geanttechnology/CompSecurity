// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateContentsRequest

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(CreateContentsRequest createcontentsrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createcontentsrequest.mVersionCode);
        zzb.zzc(parcel, 2, createcontentsrequest.zzaiz);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzba(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcH(i);
    }

    public CreateContentsRequest zzba(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        int j = 0x20000000;
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

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new CreateContentsRequest(i, j);
            }
        } while (true);
    }

    public CreateContentsRequest[] zzcH(int i)
    {
        return new CreateContentsRequest[i];
    }
}
