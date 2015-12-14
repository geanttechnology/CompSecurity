// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            UnpublishRequest, MessageWrapper

public class zzm
    implements android.os.Parcelable.Creator
{

    public zzm()
    {
    }

    static void zza(UnpublishRequest unpublishrequest, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, unpublishrequest.mVersionCode);
        zzb.zza(parcel, 2, unpublishrequest.zzaKc, i, false);
        zzb.zza(parcel, 3, unpublishrequest.zzyp(), false);
        zzb.zza(parcel, 4, unpublishrequest.zzaCr, false);
        zzb.zza(parcel, 5, unpublishrequest.zzaKe, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfF(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzit(i);
    }

    public UnpublishRequest zzfF(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s1 = null;
        android.os.IBinder ibinder = null;
        MessageWrapper messagewrapper = null;
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
                    messagewrapper = (MessageWrapper)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, MessageWrapper.CREATOR);
                    break;

                case 3: // '\003'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UnpublishRequest(i, messagewrapper, ibinder, s1, s);
            }
        } while (true);
    }

    public UnpublishRequest[] zzit(int i)
    {
        return new UnpublishRequest[i];
    }
}
