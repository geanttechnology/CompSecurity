// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            AppMetadata

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(AppMetadata appmetadata, Parcel parcel, int i)
    {
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appmetadata.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, appmetadata.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, appmetadata.zzaLP, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, appmetadata.zzaDC, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, appmetadata.zzaLQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, appmetadata.zzaLR);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, appmetadata.zzaLS);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfx(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzid(i);
    }

    public AppMetadata zzfx(Parcel parcel)
    {
        long l = 0L;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        long l1 = 0L;
        String s1 = null;
        String s2 = null;
        String s3 = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 6: // '\006'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 7: // '\007'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new AppMetadata(i, s3, s2, s1, s, l1, l);
            }
        } while (true);
    }

    public AppMetadata[] zzid(int i)
    {
        return new AppMetadata[i];
    }
}
