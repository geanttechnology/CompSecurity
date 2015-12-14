// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.query.internal:
//            LogicalFilter, Operator, FilterHolder

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(LogicalFilter logicalfilter, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, logicalfilter.mVersionCode);
        zzb.zza(parcel, 1, logicalfilter.zzalv, i, false);
        zzb.zzc(parcel, 2, logicalfilter.zzalK, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbY(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdM(i);
    }

    public LogicalFilter zzbY(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Operator operator = null;
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

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 1: // '\001'
                    operator = (Operator)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Operator.CREATOR);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, FilterHolder.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LogicalFilter(i, operator, arraylist);
            }
        } while (true);
    }

    public LogicalFilter[] zzdM(int i)
    {
        return new LogicalFilter[i];
    }
}
