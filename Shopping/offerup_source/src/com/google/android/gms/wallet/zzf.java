// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(FullWalletRequest fullwalletrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, fullwalletrequest.getVersionCode());
        zzb.zza(parcel, 2, fullwalletrequest.zzbcp, false);
        zzb.zza(parcel, 3, fullwalletrequest.zzbcq, false);
        zzb.zza(parcel, 4, fullwalletrequest.zzbcA, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzhb(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzke(i);
    }

    public FullWalletRequest zzhb(Parcel parcel)
    {
        Cart cart = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        int i = 0;
        String s1 = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    cart = (Cart)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Cart.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new FullWalletRequest(i, s, s1, cart);
            }
        } while (true);
    }

    public FullWalletRequest[] zzke(int i)
    {
        return new FullWalletRequest[i];
    }
}
