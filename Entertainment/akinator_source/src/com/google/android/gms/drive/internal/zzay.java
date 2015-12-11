// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFileRange;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDownloadProgressResponse

public class zzay
    implements android.os.Parcelable.Creator
{

    public zzay()
    {
    }

    static void zza(OnDownloadProgressResponse ondownloadprogressresponse, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, ondownloadprogressresponse.mVersionCode);
        zzb.zza(parcel, 2, ondownloadprogressresponse.zzama);
        zzb.zza(parcel, 3, ondownloadprogressresponse.zzamb);
        zzb.zzc(parcel, 4, ondownloadprogressresponse.zzys);
        zzb.zzc(parcel, 5, ondownloadprogressresponse.zzamc, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbt(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdf(i);
    }

    public OnDownloadProgressResponse zzbt(Parcel parcel)
    {
        long l1 = 0L;
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        long l2 = 0L;
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
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 5: // '\005'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, DriveFileRange.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new OnDownloadProgressResponse(j, l2, l1, i, arraylist);
            }
        } while (true);
    }

    public OnDownloadProgressResponse[] zzdf(int i)
    {
        return new OnDownloadProgressResponse[i];
    }
}
