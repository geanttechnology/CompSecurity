// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            LandmarkParcel

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(LandmarkParcel landmarkparcel, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, landmarkparcel.versionCode);
        zzb.zza(parcel, 2, landmarkparcel.x);
        zzb.zza(parcel, 3, landmarkparcel.y);
        zzb.zzc(parcel, 4, landmarkparcel.type);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgC(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjH(i);
    }

    public LandmarkParcel zzgC(Parcel parcel)
    {
        int j = 0;
        float f1 = 0.0F;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        float f = 0.0F;
        int i = 0;
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

                case 2: // '\002'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 3: // '\003'
                    f1 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new LandmarkParcel(i, f, f1, j);
            }
        } while (true);
    }

    public LandmarkParcel[] zzjH(int i)
    {
        return new LandmarkParcel[i];
    }
}
