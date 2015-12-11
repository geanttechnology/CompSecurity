// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionUnregistrationRequest

public class zzz
    implements android.os.Parcelable.Creator
{

    public zzz()
    {
    }

    static void zza(SessionUnregistrationRequest sessionunregistrationrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sessionunregistrationrequest.zzta(), i, false);
        zzb.zzc(parcel, 1000, sessionunregistrationrequest.getVersionCode());
        zzb.zza(parcel, 2, sessionunregistrationrequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdu(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfm(i);
    }

    public SessionUnregistrationRequest zzdu(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        PendingIntent pendingintent = null;
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
                    pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, PendingIntent.CREATOR);
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
                return new SessionUnregistrationRequest(i, pendingintent, ibinder);
            }
        } while (true);
    }

    public SessionUnregistrationRequest[] zzfm(int i)
    {
        return new SessionUnregistrationRequest[i];
    }
}
