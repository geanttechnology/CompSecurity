// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnContentsResponse

public class zzav
    implements android.os.Parcelable.Creator
{

    public zzav()
    {
    }

    static void zza(OnContentsResponse oncontentsresponse, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, oncontentsresponse.mVersionCode);
        zzb.zza(parcel, 2, oncontentsresponse.zzaiD, i, false);
        zzb.zza(parcel, 3, oncontentsresponse.zzajI);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbj(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcX(i);
    }

    public OnContentsResponse zzbj(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        Contents contents = null;
        int i = 0;
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
                    contents = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Contents.CREATOR);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnContentsResponse(i, contents, flag);
            }
        } while (true);
    }

    public OnContentsResponse[] zzcX(int i)
    {
        return new OnContentsResponse[i];
    }
}
