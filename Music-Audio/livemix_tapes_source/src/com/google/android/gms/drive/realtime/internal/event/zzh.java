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
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, valuechangeddetails.mVersionCode);
        zzb.zzc(parcel, 2, valuechangeddetails.zzame);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzee(i);
    }

    public ValueChangedDetails zzcp(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
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

    public ValueChangedDetails[] zzee(int i)
    {
        return new ValueChangedDetails[i];
    }
}
