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

    final WalletFragmentInitParams zzaYh;

    public WalletFragmentInitParams build()
    {
        boolean flag1 = true;
        boolean flag;
        if (WalletFragmentInitParams.zza(zzaYh) != null && WalletFragmentInitParams.zzb(zzaYh) == null || WalletFragmentInitParams.zza(zzaYh) == null && WalletFragmentInitParams.zzb(zzaYh) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
        if (WalletFragmentInitParams.zzc(zzaYh) >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "masked wallet request code is required and must be non-negative");
        return zzaYh;
    }

    public zzaYh setAccountName(String s)
    {
        WalletFragmentInitParams.zza(zzaYh, s);
        return this;
    }

    public zzaYh setMaskedWallet(MaskedWallet maskedwallet)
    {
        WalletFragmentInitParams.zza(zzaYh, maskedwallet);
        return this;
    }

    public zzaYh setMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
    {
        WalletFragmentInitParams.zza(zzaYh, maskedwalletrequest);
        return this;
    }

    public zzaYh setMaskedWalletRequestCode(int i)
    {
        WalletFragmentInitParams.zza(zzaYh, i);
        return this;
    }

    private (WalletFragmentInitParams walletfragmentinitparams)
    {
        zzaYh = walletfragmentinitparams;
        super();
    }

    zzaYh(WalletFragmentInitParams walletfragmentinitparams, zzaYh zzayh)
    {
        this(walletfragmentinitparams);
    }
}
