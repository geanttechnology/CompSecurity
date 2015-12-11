// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart, CountrySpecification, PaymentMethodTokenizationParameters

public class zzl
    implements android.os.Parcelable.Creator
{

    public zzl()
    {
    }

    static void zza(MaskedWalletRequest maskedwalletrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, maskedwalletrequest.getVersionCode());
        zzb.zza(parcel, 2, maskedwalletrequest.zzbcq, false);
        zzb.zza(parcel, 3, maskedwalletrequest.zzbdl);
        zzb.zza(parcel, 4, maskedwalletrequest.zzbdm);
        zzb.zza(parcel, 5, maskedwalletrequest.zzbdn);
        zzb.zza(parcel, 6, maskedwalletrequest.zzbdo, false);
        zzb.zza(parcel, 7, maskedwalletrequest.zzbcj, false);
        zzb.zza(parcel, 8, maskedwalletrequest.zzbdp, false);
        zzb.zza(parcel, 9, maskedwalletrequest.zzbcA, i, false);
        zzb.zza(parcel, 10, maskedwalletrequest.zzbdq);
        zzb.zza(parcel, 11, maskedwalletrequest.zzbdr);
        zzb.zza(parcel, 12, maskedwalletrequest.zzbds, i, false);
        zzb.zza(parcel, 13, maskedwalletrequest.zzbdt);
        zzb.zza(parcel, 14, maskedwalletrequest.zzbdu);
        zzb.zzc(parcel, 15, maskedwalletrequest.zzbdv, false);
        zzb.zza(parcel, 17, maskedwalletrequest.zzbdx, false);
        zzb.zza(parcel, 16, maskedwalletrequest.zzbdw, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzhh(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzkk(i);
    }

    public MaskedWalletRequest zzhh(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s3 = null;
        boolean flag6 = false;
        boolean flag5 = false;
        boolean flag4 = false;
        String s2 = null;
        String s1 = null;
        String s = null;
        Cart cart = null;
        boolean flag3 = false;
        boolean flag2 = false;
        com.google.android.gms.wallet.CountrySpecification acountryspecification[] = null;
        boolean flag1 = true;
        boolean flag = true;
        java.util.ArrayList arraylist1 = null;
        PaymentMethodTokenizationParameters paymentmethodtokenizationparameters = null;
        java.util.ArrayList arraylist = null;
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
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    flag6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    flag5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    flag4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 9: // '\t'
                    cart = (Cart)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Cart.CREATOR);
                    break;

                case 10: // '\n'
                    flag3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 11: // '\013'
                    flag2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 12: // '\f'
                    acountryspecification = (com.google.android.gms.wallet.CountrySpecification[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k, CountrySpecification.CREATOR);
                    break;

                case 13: // '\r'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 14: // '\016'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 15: // '\017'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, CountrySpecification.CREATOR);
                    break;

                case 17: // '\021'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, k);
                    break;

                case 16: // '\020'
                    paymentmethodtokenizationparameters = (PaymentMethodTokenizationParameters)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new MaskedWalletRequest(i, s3, flag6, flag5, flag4, s2, s1, s, cart, flag3, flag2, acountryspecification, flag1, flag, arraylist1, paymentmethodtokenizationparameters, arraylist);
            }
        } while (true);
    }

    public MaskedWalletRequest[] zzkk(int i)
    {
        return new MaskedWalletRequest[i];
    }
}
