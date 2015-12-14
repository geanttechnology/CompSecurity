// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            Value

public class zzt
    implements android.os.Parcelable.Creator
{

    public zzt()
    {
    }

    static void zza(Value value, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzrM());
        zzb.zza(parcel, 4, value.zzrU(), false);
        zzb.zza(parcel, 5, value.zzrV(), false);
        zzb.zza(parcel, 6, value.zzrW(), false);
        zzb.zza(parcel, 7, value.zzrX(), false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcJ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeC(i);
    }

    public Value zzcJ(Parcel parcel)
    {
        boolean flag = false;
        float af[] = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        float f = 0.0F;
        int ai[] = null;
        android.os.Bundle bundle = null;
        String s = null;
        int i = 0;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 3: // '\003'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 5: // '\005'
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
                    break;

                case 6: // '\006'
                    ai = com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, l);
                    break;

                case 7: // '\007'
                    af = com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new Value(j, i, flag, f, s, bundle, ai, af);
            }
        } while (true);
    }

    public Value[] zzeC(int i)
    {
        return new Value[i];
    }
}
