// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            MessageType

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(MessageType messagetype, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zza(parcel, 1, messagetype.zzaeI, false);
        zzb.zzc(parcel, 1000, messagetype.versionCode);
        zzb.zza(parcel, 2, messagetype.type, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfB(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzip(i);
    }

    public MessageType zzfB(Parcel parcel)
    {
        String s1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MessageType(i, s, s1);
            }
        } while (true);
    }

    public MessageType[] zzip(int i)
    {
        return new MessageType[i];
    }
}
