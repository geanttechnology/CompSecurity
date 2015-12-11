// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            ValueChangedDetails

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(ValueChangedDetails valuechangeddetails, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, valuechangeddetails.mVersionCode);
        zzb.zzc(parcel, 2, valuechangeddetails.zzaoE);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzen(i);
    }

    public ValueChangedDetails zzcA(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
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
                return new ValueChangedDetails(i, j);
            }
        } while (true);
    }

    public ValueChangedDetails[] zzen(int i)
    {
        return new ValueChangedDetails[i];
    }
}
