// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;

// Referenced classes of package com.google.android.gms.fitness.result:
//            SessionReadResult

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(SessionReadResult sessionreadresult, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, sessionreadresult.getSessions(), false);
        zzb.zzc(parcel, 1000, sessionreadresult.getVersionCode());
        zzb.zzc(parcel, 2, sessionreadresult.zzsG(), false);
        zzb.zza(parcel, 3, sessionreadresult.getStatus(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdy(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfs(i);
    }

    public SessionReadResult zzdy(Parcel parcel)
    {
        Status status = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        java.util.ArrayList arraylist1 = null;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, Session.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, SessionDataSet.CREATOR);
                    break;

                case 3: // '\003'
                    status = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Status.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SessionReadResult(i, arraylist, arraylist1, status);
            }
        } while (true);
    }

    public SessionReadResult[] zzfs(int i)
    {
        return new SessionReadResult[i];
    }
}
