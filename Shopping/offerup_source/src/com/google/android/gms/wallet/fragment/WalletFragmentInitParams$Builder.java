// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentInitParams

public final class <init>
{

    final WalletFragmentInitParams zzbep;

    public final WalletFragmentInitParams build()
    {
        boolean flag1 = true;
        boolean flag;
        if (WalletFragmentInitParams.zza(zzbep) != null && WalletFragmentInitParams.zzb(zzbep) == null || WalletFragmentInitParams.zza(zzbep) == null && WalletFragmentInitParams.zzb(zzbep) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
        if (WalletFragmentInitParams.zzc(zzbep) >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "masked wallet request code is required and must be non-negative");
        return zzbep;
    }

    public final zzbep setAccountName(String s)
    {
        WalletFragmentInitParams.zza(zzbep, s);
        return this;
    }

    public final zzbep setMaskedWallet(MaskedWallet maskedwallet)
    {
        WalletFragmentInitParams.zza(zzbep, maskedwallet);
        return this;
    }

    public final zzbep setMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
    {
        WalletFragmentInitParams.zza(zzbep, maskedwalletrequest);
        return this;
    }

    public final zzbep setMaskedWalletRequestCode(int i)
    {
        WalletFragmentInitParams.zza(zzbep, i);
        return this;
    }

    private (WalletFragmentInitParams walletfragmentinitparams)
    {
        zzbep = walletfragmentinitparams;
        super();
    }

    zzbep(WalletFragmentInitParams walletfragmentinitparams, zzbep zzbep1)
    {
        this(walletfragmentinitparams);
    }
}
