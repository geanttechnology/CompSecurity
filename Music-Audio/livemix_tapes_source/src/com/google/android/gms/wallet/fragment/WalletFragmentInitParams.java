// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            zza

public final class WalletFragmentInitParams
    implements SafeParcelable
{
    public final class Builder
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

        public Builder setAccountName(String s)
        {
            WalletFragmentInitParams.zza(zzaYh, s);
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedwallet)
        {
            WalletFragmentInitParams.zza(zzaYh, maskedwallet);
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
        {
            WalletFragmentInitParams.zza(zzaYh, maskedwalletrequest);
            return this;
        }

        public Builder setMaskedWalletRequestCode(int i)
        {
            WalletFragmentInitParams.zza(zzaYh, i);
            return this;
        }

        private Builder()
        {
            zzaYh = WalletFragmentInitParams.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    private String zzQE;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private int zzaYg;

    private WalletFragmentInitParams()
    {
        mVersionCode = 1;
        zzaYg = -1;
    }

    WalletFragmentInitParams(int i, String s, MaskedWalletRequest maskedwalletrequest, int j, MaskedWallet maskedwallet)
    {
        mVersionCode = i;
        zzQE = s;
        zzaXS = maskedwalletrequest;
        zzaYg = j;
        zzaXT = maskedwallet;
    }

    public static Builder newBuilder()
    {
        WalletFragmentInitParams walletfragmentinitparams = new WalletFragmentInitParams();
        walletfragmentinitparams.getClass();
        return walletfragmentinitparams. new Builder();
    }

    static int zza(WalletFragmentInitParams walletfragmentinitparams, int i)
    {
        walletfragmentinitparams.zzaYg = i;
        return i;
    }

    static MaskedWallet zza(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzaXT;
    }

    static MaskedWallet zza(WalletFragmentInitParams walletfragmentinitparams, MaskedWallet maskedwallet)
    {
        walletfragmentinitparams.zzaXT = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(WalletFragmentInitParams walletfragmentinitparams, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragmentinitparams.zzaXS = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static String zza(WalletFragmentInitParams walletfragmentinitparams, String s)
    {
        walletfragmentinitparams.zzQE = s;
        return s;
    }

    static MaskedWalletRequest zzb(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzaXS;
    }

    static int zzc(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzaYg;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccountName()
    {
        return zzQE;
    }

    public MaskedWallet getMaskedWallet()
    {
        return zzaXT;
    }

    public MaskedWalletRequest getMaskedWalletRequest()
    {
        return zzaXS;
    }

    public int getMaskedWalletRequestCode()
    {
        return zzaYg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.fragment.zza.zza(this, parcel, i);
    }

}
