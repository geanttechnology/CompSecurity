// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;


// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentStyle

public final class <init>
{

    final WalletFragmentOptions zzber;

    public final WalletFragmentOptions build()
    {
        return zzber;
    }

    public final zzber setEnvironment(int i)
    {
        WalletFragmentOptions.zza(zzber, i);
        return this;
    }

    public final zzber setFragmentStyle(int i)
    {
        WalletFragmentOptions.zza(zzber, (new WalletFragmentStyle()).setStyleResourceId(i));
        return this;
    }

    public final sourceId setFragmentStyle(WalletFragmentStyle walletfragmentstyle)
    {
        WalletFragmentOptions.zza(zzber, walletfragmentstyle);
        return this;
    }

    public final zzber setMode(int i)
    {
        WalletFragmentOptions.zzc(zzber, i);
        return this;
    }

    public final zzber setTheme(int i)
    {
        WalletFragmentOptions.zzb(zzber, i);
        return this;
    }

    private (WalletFragmentOptions walletfragmentoptions)
    {
        zzber = walletfragmentoptions;
        super();
    }

    zzber(WalletFragmentOptions walletfragmentoptions, zzber zzber1)
    {
        this(walletfragmentoptions);
    }
}
