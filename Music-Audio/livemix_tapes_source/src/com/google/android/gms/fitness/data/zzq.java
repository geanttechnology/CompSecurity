// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            SessionDataSet, Session, DataSet

public class zzq
    implements android.os.Parcelable.Creator
{

    public zzq()
    {
    }

    static void zza(SessionDataSet sessiondataset, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessiondataset.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessiondataset.mVersionCode);
        zzb.zza(parcel, 2, sessiondataset.zzrO(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcH(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeA(i);
    }

    public SessionDataSet zzcH(Parcel parcel)
    {
        DataSet dataset = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Session session = null;
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

                case 1: // '\001'
                    session = (Session)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Session.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    dataset = (DataSet)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataSet.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SessionDataSet(i, session, dataset);
            }
        } while (true);
    }

    public SessionDataSet[] zzeA(int i)
    {
        return new SessionDataSet[i];
    }
}
