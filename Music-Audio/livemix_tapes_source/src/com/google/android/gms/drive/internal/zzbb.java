// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnFetchThumbnailResponse

public class zzbb
    implements android.os.Parcelable.Creator
{

    public zzbb()
    {
    }

    static void zza(OnFetchThumbnailResponse onfetchthumbnailresponse, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onfetchthumbnailresponse.mVersionCode);
        zzb.zza(parcel, 2, onfetchthumbnailresponse.zzajS, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdd(i);
    }

    public OnFetchThumbnailResponse zzbp(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelfiledescriptor = null;
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
                    parcelfiledescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, ParcelFileDescriptor.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnFetchThumbnailResponse(i, parcelfiledescriptor);
            }
        } while (true);
    }

    public OnFetchThumbnailResponse[] zzdd(int i)
    {
        return new OnFetchThumbnailResponse[i];
    }
}
