// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;


// Referenced classes of package com.google.android.gms.wallet.fragment:
//            WalletFragmentOptions, WalletFragmentStyle

public final class <init>
{

    final WalletFragmentOptions zzaYj;

    public WalletFragmentOptions build()
    {
        return zzaYj;
    }

    public zzaYj setEnvironment(int i)
    {
        WalletFragmentOptions.zza(zzaYj, i);
        return this;
    }

    public zzaYj setFragmentStyle(int i)
    {
        WalletFragmentOptions.zza(zzaYj, (new WalletFragmentStyle()).setStyleResourceId(i));
        return this;
    }

    public sourceId setFragmentStyle(WalletFragmentStyle walletfragmentstyle)
    {
        WalletFragmentOptions.zza(zzaYj, walletfragmentstyle);
        return this;
    }

    public zzaYj setMode(int i)
    {
        WalletFragmentOptions.zzc(zzaYj, i);
        return this;
    }

    public zzaYj setTheme(int i)
    {
        WalletFragmentOptions.zzb(zzaYj, i);
        return this;
    }

    private (WalletFragmentOptions walletfragmentoptions)
    {
        zzaYj = walletfragmentoptions;
        super();
    }

    zzaYj(WalletFragmentOptions walletfragmentoptions, zzaYj zzayj)
    {
        this(walletfragmentoptions);
    }
}
