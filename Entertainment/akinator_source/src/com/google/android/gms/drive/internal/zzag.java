// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            FileUploadPreferencesImpl

public class zzag
    implements android.os.Parcelable.Creator
{

    public zzag()
    {
    }

    static void zza(FileUploadPreferencesImpl fileuploadpreferencesimpl, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, fileuploadpreferencesimpl.mVersionCode);
        zzb.zzc(parcel, 2, fileuploadpreferencesimpl.zzalx);
        zzb.zzc(parcel, 3, fileuploadpreferencesimpl.zzaly);
        zzb.zza(parcel, 4, fileuploadpreferencesimpl.zzalz);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbi(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcU(i);
    }

    public FileUploadPreferencesImpl zzbi(Parcel parcel)
    {
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int k = 0;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
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

    public FileUploadPreferencesImpl[] zzcU(int i)
    {
        return new FileUploadPreferencesImpl[i];
    }
}
