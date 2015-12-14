// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            FileUploadPreferencesImpl

public class zzaf
    implements android.os.Parcelable.Creator
{

    public zzaf()
    {
    }

    static void zza(FileUploadPreferencesImpl fileuploadpreferencesimpl, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fileuploadpreferencesimpl.mVersionCode);
        zzb.zzc(parcel, 2, fileuploadpreferencesimpl.zzajj);
        zzb.zzc(parcel, 3, fileuploadpreferencesimpl.zzajk);
        zzb.zza(parcel, 4, fileuploadpreferencesimpl.zzajl);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzba(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcO(i);
    }

    public FileUploadPreferencesImpl zzba(Parcel parcel)
    {
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new FileUploadPreferencesImpl(i, j, k, flag);
            }
        } while (true);
    }

    public FileUploadPreferencesImpl[] zzcO(int i)
    {
        return new FileUploadPreferencesImpl[i];
    }
}
