// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.auth:
//            AccountChangeEvent

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(AccountChangeEvent accountchangeevent, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, accountchangeevent.mVersion);
        zzb.zza(parcel, 2, accountchangeevent.zzRr);
        zzb.zza(parcel, 3, accountchangeevent.zzRs, false);
        zzb.zzc(parcel, 4, accountchangeevent.zzRt);
        zzb.zzc(parcel, 5, accountchangeevent.zzRu);
        zzb.zza(parcel, 6, accountchangeevent.zzRv, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzz(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaq(i);
    }

    public AccountChangeEvent[] zzaq(int i)
    {
        return new AccountChangeEvent[i];
    }

    public AccountChangeEvent zzz(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        long l1 = 0L;
        int j = 0;
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i1);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new AccountChangeEvent(k, l1, s1, j, i, s);
            }
        } while (true);
    }
}
