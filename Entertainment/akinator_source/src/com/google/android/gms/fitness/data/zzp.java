// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            Session, Application

public class zzp
    implements android.os.Parcelable.Creator
{

    public zzp()
    {
    }

    static void zza(Session session, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, session.zzkX());
        zzb.zzc(parcel, 1000, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzsi());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzsg());
        zzb.zza(parcel, 8, session.zzsr(), i, false);
        zzb.zza(parcel, 9, session.zzsz(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcR(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeI(i);
    }

    public Session zzcR(Parcel parcel)
    {
        long l1 = 0L;
        int i = 0;
        Long long1 = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        Application application = null;
        String s = null;
        String s1 = null;
        String s2 = null;
        long l2 = 0L;
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
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 3: // '\003'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 8: // '\b'
                    application = (Application)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, Application.CREATOR);
                    break;

                case 9: // '\t'
                    long1 = com.google.android.gms.common.internal.safeparcel.zza.zzj(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new Session(j, l2, l1, s2, s1, s, i, application, long1);
            }
        } while (true);
    }

    public Session[] zzeI(int i)
    {
        return new Session[i];
    }
}
