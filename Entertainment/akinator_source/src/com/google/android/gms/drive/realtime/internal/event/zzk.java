// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            ValuesSetDetails

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(ValuesSetDetails valuessetdetails, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, valuessetdetails.mVersionCode);
        zzb.zzc(parcel, 2, valuessetdetails.mIndex);
        zzb.zzc(parcel, 3, valuessetdetails.zzaoF);
        zzb.zzc(parcel, 4, valuessetdetails.zzaoG);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcD(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeq(i);
    }

    public ValuesSetDetails zzcD(Parcel parcel)
    {
        int l = 0;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new ValuesSetDetails(i, j, k, l);
            }
        } while (true);
    }

    public ValuesSetDetails[] zzeq(int i)
    {
        return new ValuesSetDetails[i];
    }
}
