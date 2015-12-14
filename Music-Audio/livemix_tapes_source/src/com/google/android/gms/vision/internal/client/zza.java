// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.vision.internal.client:
//            FrameMetadataParcel

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(FrameMetadataParcel framemetadataparcel, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, framemetadataparcel.versionCode);
        zzb.zzc(parcel, 2, framemetadataparcel.width);
        zzb.zzc(parcel, 3, framemetadataparcel.height);
        zzb.zzc(parcel, 4, framemetadataparcel.id);
        zzb.zza(parcel, 5, framemetadataparcel.zzaVY);
        zzb.zzc(parcel, 6, framemetadataparcel.rotation);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgD(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjI(i);
    }

    public FrameMetadataParcel zzgD(Parcel parcel)
    {
        int i = 0;
        int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        long l1 = 0L;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 2: // '\002'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 5: // '\005'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j1).toString(), parcel);
            } else
            {
                return new FrameMetadataParcel(i1, l, k, j, l1, i);
            }
        } while (true);
    }

    public FrameMetadataParcel[] zzjI(int i)
    {
        return new FrameMetadataParcel[i];
    }
}
