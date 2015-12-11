// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;

// Referenced classes of package com.google.android.gms.drive.query:
//            Query, SortOrder

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(Query query, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1000, query.mVersionCode);
        zzb.zza(parcel, 1, query.zzanK, i, false);
        zzb.zza(parcel, 3, query.zzanL, false);
        zzb.zza(parcel, 4, query.zzanM, i, false);
        zzb.zzb(parcel, 5, query.zzanN, false);
        zzb.zza(parcel, 6, query.zzanO);
        zzb.zzc(parcel, 7, query.zzajA, false);
        zzb.zza(parcel, 8, query.zzalC);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzca(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdM(i);
    }

    public Query zzca(Parcel parcel)
    {
        boolean flag = false;
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        boolean flag1 = false;
        java.util.ArrayList arraylist1 = null;
        SortOrder sortorder = null;
        String s = null;
        LogicalFilter logicalfilter = null;
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

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 1: // '\001'
                    logicalfilter = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, LogicalFilter.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    sortorder = (SortOrder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, SortOrder.CREATOR);
                    break;

                case 5: // '\005'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 7: // '\007'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DriveSpace.CREATOR);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Query(i, logicalfilter, s, sortorder, arraylist1, flag1, arraylist, flag);
            }
        } while (true);
    }

    public Query[] zzdM(int i)
    {
        return new Query[i];
    }
}
