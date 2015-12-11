// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            BeginCompoundOperationRequest

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(BeginCompoundOperationRequest begincompoundoperationrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, begincompoundoperationrequest.mVersionCode);
        zzb.zza(parcel, 2, begincompoundoperationrequest.zzaov);
        zzb.zza(parcel, 3, begincompoundoperationrequest.mName, false);
        zzb.zza(parcel, 4, begincompoundoperationrequest.zzaow);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzco(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzea(i);
    }

    public BeginCompoundOperationRequest zzco(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        boolean flag1 = true;
        int i = 0;
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
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new BeginCompoundOperationRequest(i, flag, s, flag1);
            }
        } while (true);
    }

    public BeginCompoundOperationRequest[] zzea(int i)
    {
        return new BeginCompoundOperationRequest[i];
    }
}
