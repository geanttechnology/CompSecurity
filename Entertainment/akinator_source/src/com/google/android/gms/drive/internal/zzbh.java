// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnResourceIdSetResponse

public class zzbh
    implements android.os.Parcelable.Creator
{

    public zzbh()
    {
    }

    static void zza(OnResourceIdSetResponse onresourceidsetresponse, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onresourceidsetresponse.getVersionCode());
        zzb.zzb(parcel, 2, onresourceidsetresponse.zzrk(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbC(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdo(i);
    }

    public OnResourceIdSetResponse zzbC(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnResourceIdSetResponse(i, arraylist);
            }
        } while (true);
    }

    public OnResourceIdSetResponse[] zzdo(int i)
    {
        return new OnResourceIdSetResponse[i];
    }
}
