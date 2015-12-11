// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            AutocompletePredictionEntity

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(AutocompletePredictionEntity autocompletepredictionentity, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, autocompletepredictionentity.zzaGO, false);
        zzb.zzc(parcel, 1000, autocompletepredictionentity.mVersionCode);
        zzb.zza(parcel, 2, autocompletepredictionentity.zzaGt, false);
        zzb.zza(parcel, 3, autocompletepredictionentity.zzaFT, false);
        zzb.zzc(parcel, 4, autocompletepredictionentity.zzaGP, false);
        zzb.zzc(parcel, 5, autocompletepredictionentity.zzaGQ);
        zzb.zza(parcel, 6, autocompletepredictionentity.zzaGR, false);
        zzb.zzc(parcel, 7, autocompletepredictionentity.zzaGS, false);
        zzb.zza(parcel, 8, autocompletepredictionentity.zzaGT, false);
        zzb.zzc(parcel, 9, autocompletepredictionentity.zzaGU, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeU(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhr(i);
    }

    public AutocompletePredictionEntity zzeU(Parcel parcel)
    {
        int i = 0;
        java.util.ArrayList arraylist = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        java.util.ArrayList arraylist1 = null;
        String s1 = null;
        java.util.ArrayList arraylist2 = null;
        String s2 = null;
        java.util.ArrayList arraylist3 = null;
        String s3 = null;
        int j = 0;
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
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 3: // '\003'
                    arraylist3 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, l);
                    break;

                case 4: // '\004'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 7: // '\007'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 9: // '\t'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new AutocompletePredictionEntity(j, s3, arraylist3, i, s2, arraylist2, s1, arraylist1, s, arraylist);
            }
        } while (true);
    }

    public AutocompletePredictionEntity[] zzhr(int i)
    {
        return new AutocompletePredictionEntity[i];
    }
}
