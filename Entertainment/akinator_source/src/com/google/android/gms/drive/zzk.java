// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive:
//            UserMetadata

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(UserMetadata usermetadata, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, usermetadata.mVersionCode);
        zzb.zza(parcel, 2, usermetadata.zzajr, false);
        zzb.zza(parcel, 3, usermetadata.zzTa, false);
        zzb.zza(parcel, 4, usermetadata.zzajs, false);
        zzb.zza(parcel, 5, usermetadata.zzajt);
        zzb.zza(parcel, 6, usermetadata.zzaju, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcq(i);
    }

    public UserMetadata zzaK(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s1 = null;
        String s2 = null;
        String s3 = null;
        int i = 0;
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
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UserMetadata(i, s3, s2, s1, flag, s);
            }
        } while (true);
    }

    public UserMetadata[] zzcq(int i)
    {
        return new UserMetadata[i];
    }
}
