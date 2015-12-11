// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionRegistrationRequest

public class zzw
    implements android.os.Parcelable.Creator
{

    public zzw()
    {
    }

    static void zza(SessionRegistrationRequest sessionregistrationrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sessionregistrationrequest.zzta(), i, false);
        zzb.zzc(parcel, 1000, sessionregistrationrequest.getVersionCode());
        zzb.zza(parcel, 2, sessionregistrationrequest.zzsO(), false);
        zzb.zzc(parcel, 4, sessionregistrationrequest.zztj());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfj(i);
    }

    public SessionRegistrationRequest zzdr(Parcel parcel)
    {
        Object obj;
        Object obj1;
        int i;
        int j;
        int k;
        obj1 = null;
        i = 0;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        obj = null;
        j = 0;
_L7:
        int l;
        if (parcel.dataPosition() >= k)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzbM(l);
        JVM INSTR lookupswitch 4: default 80
    //                   1: 105
    //                   2: 146
    //                   4: 162
    //                   1000: 127;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_162;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L8:
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        PendingIntent pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PendingIntent.CREATOR);
        obj = obj1;
        obj1 = pendingintent;
          goto _L8
_L5:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        android.os.IBinder ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
        obj1 = obj;
        obj = ibinder;
          goto _L8
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != k)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
        } else
        {
            return new SessionRegistrationRequest(j, ((PendingIntent) (obj)), ((android.os.IBinder) (obj1)), i);
        }
    }

    public SessionRegistrationRequest[] zzfj(int i)
    {
        return new SessionRegistrationRequest[i];
    }
}
