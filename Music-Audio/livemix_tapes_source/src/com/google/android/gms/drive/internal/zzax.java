// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDownloadProgressResponse

public class zzax
    implements android.os.Parcelable.Creator
{

    public zzax()
    {
    }

    static void zza(OnDownloadProgressResponse ondownloadprogressresponse, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, ondownloadprogressresponse.mVersionCode);
        zzb.zza(parcel, 2, ondownloadprogressresponse.zzajK);
        zzb.zza(parcel, 3, ondownloadprogressresponse.zzajL);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbl(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcZ(i);
    }

    public OnDownloadProgressResponse zzbl(Parcel parcel)
    {
        long l = 0L;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnDownloadProgressResponse(i, l1, l);
            }
        } while (true);
    }

    public OnDownloadProgressResponse[] zzcZ(int i)
    {
        return new OnDownloadProgressResponse[i];
    }
}
