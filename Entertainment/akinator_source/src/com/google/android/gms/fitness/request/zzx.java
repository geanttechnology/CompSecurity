// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionStartRequest

public class zzx
    implements android.os.Parcelable.Creator
{

    public zzx()
    {
    }

    static void zza(SessionStartRequest sessionstartrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sessionstartrequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionstartrequest.getVersionCode());
        zzb.zza(parcel, 2, sessionstartrequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzds(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfk(i);
    }

    public SessionStartRequest zzds(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        Session session = null;
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
                    session = (Session)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Session.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SessionStartRequest(i, session, ibinder);
            }
        } while (true);
    }

    public SessionStartRequest[] zzfk(int i)
    {
        return new SessionStartRequest[i];
    }
}
