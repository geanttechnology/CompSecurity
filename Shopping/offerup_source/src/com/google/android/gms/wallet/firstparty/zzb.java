// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.wallet.firstparty:
//            GetBuyFlowInitializationTokenRequest

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(GetBuyFlowInitializationTokenRequest getbuyflowinitializationtokenrequest, Parcel parcel, int i)
    {
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getbuyflowinitializationtokenrequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getbuyflowinitializationtokenrequest.zzbdN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getbuyflowinitializationtokenrequest.zzbdO, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzhn(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzkq(i);
    }

    public GetBuyFlowInitializationTokenRequest zzhn(Parcel parcel)
    {
        byte abyte1[] = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        byte abyte0[] = null;
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
                    abyte0 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, k);
                    break;

                case 3: // '\003'
                    abyte1 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new GetBuyFlowInitializationTokenRequest(i, abyte0, abyte1);
            }
        } while (true);
    }

    public GetBuyFlowInitializationTokenRequest[] zzkq(int i)
    {
        return new GetBuyFlowInitializationTokenRequest[i];
    }
}
