// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionStopRequest

public class zzy
    implements android.os.Parcelable.Creator
{

    public zzy()
    {
    }

    static void zza(SessionStopRequest sessionstoprequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sessionstoprequest.getName(), false);
        zzb.zzc(parcel, 1000, sessionstoprequest.getVersionCode());
        zzb.zza(parcel, 2, sessionstoprequest.getIdentifier(), false);
        zzb.zza(parcel, 3, sessionstoprequest.zzsO(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdt(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfl(i);
    }

    public SessionStopRequest zzdt(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SessionStopRequest(i, s, s1, ibinder);
            }
        } while (true);
    }

    public SessionStopRequest[] zzfl(int i)
    {
        return new SessionStopRequest[i];
    }
}
