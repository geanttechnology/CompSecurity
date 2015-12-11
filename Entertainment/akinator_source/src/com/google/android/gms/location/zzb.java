// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.location:
//            GestureRequest

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(GestureRequest gesturerequest, Parcel parcel, int i)
    {
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, gesturerequest.zzww(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, gesturerequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgO(i);
    }

    public GestureRequest zzeA(Parcel parcel)
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new GestureRequest(i, arraylist);
            }
        } while (true);
    }

    public GestureRequest[] zzgO(int i)
    {
        return new GestureRequest[i];
    }
}
