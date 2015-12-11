// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            QueryRequest

public class zzbn
    implements android.os.Parcelable.Creator
{

    public zzbn()
    {
    }

    static void zza(QueryRequest queryrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, queryrequest.mVersionCode);
        zzb.zza(parcel, 2, queryrequest.zzamr, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbH(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdt(i);
    }

    public QueryRequest zzbH(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        Query query = null;
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
                    query = (Query)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Query.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new QueryRequest(i, query);
            }
        } while (true);
    }

    public QueryRequest[] zzdt(int i)
    {
        return new QueryRequest[i];
    }
}
