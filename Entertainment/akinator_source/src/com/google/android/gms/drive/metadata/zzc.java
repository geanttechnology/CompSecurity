// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.metadata:
//            CustomPropertyKey

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(CustomPropertyKey custompropertykey, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, custompropertykey.mVersionCode);
        zzb.zza(parcel, 2, custompropertykey.zzue, false);
        zzb.zzc(parcel, 3, custompropertykey.mVisibility);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbU(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdG(i);
    }

    public CustomPropertyKey zzbU(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new CustomPropertyKey(i, s, j);
            }
        } while (true);
    }

    public CustomPropertyKey[] zzdG(int i)
    {
        return new CustomPropertyKey[i];
    }
}
