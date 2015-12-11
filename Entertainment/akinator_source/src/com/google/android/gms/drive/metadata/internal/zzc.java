// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            CustomProperty

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(CustomProperty customproperty, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, customproperty.mVersionCode);
        zzb.zza(parcel, 2, customproperty.zzamD, i, false);
        zzb.zza(parcel, 3, customproperty.mValue, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbW(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdI(i);
    }

    public CustomProperty zzbW(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        CustomPropertyKey custompropertykey = null;
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
                    custompropertykey = (CustomPropertyKey)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, CustomPropertyKey.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CustomProperty(i, custompropertykey, s);
            }
        } while (true);
    }

    public CustomProperty[] zzdI(int i)
    {
        return new CustomProperty[i];
    }
}
