// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.events:
//            QueryResultEventParcelable

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(QueryResultEventParcelable queryresulteventparcelable, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, queryresulteventparcelable.mVersionCode);
        zzb.zza(parcel, 2, queryresulteventparcelable.zzabq, i, false);
        zzb.zza(parcel, 3, queryresulteventparcelable.zzajR);
        zzb.zzc(parcel, 4, queryresulteventparcelable.zzajS);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaQ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcw(i);
    }

    public QueryResultEventParcelable zzaQ(Parcel parcel)
    {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DataHolder dataholder = null;
        boolean flag = false;
        int j = 0;
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
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, DataHolder.CREATOR);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new QueryResultEventParcelable(j, dataholder, flag, i);
            }
        } while (true);
    }

    public QueryResultEventParcelable[] zzcw(int i)
    {
        return new QueryResultEventParcelable[i];
    }
}
