// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.common.server.converter:
//            ConverterWrapper, StringToIntConverter

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(ConverterWrapper converterwrapper, Parcel parcel, int i)
    {
        int j = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, converterwrapper.getVersionCode());
        zzb.zza(parcel, 2, converterwrapper.zzoh(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzae(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzbE(i);
    }

    public ConverterWrapper zzae(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        StringToIntConverter stringtointconverter = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    stringtointconverter = (StringToIntConverter)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, StringToIntConverter.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ConverterWrapper(i, stringtointconverter);
            }
        } while (true);
    }

    public ConverterWrapper[] zzbE(int i)
    {
        return new ConverterWrapper[i];
    }
}
