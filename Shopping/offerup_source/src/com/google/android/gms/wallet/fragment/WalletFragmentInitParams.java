// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            zza

public final class WalletFragmentInitParams
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    private String zzRs;
    private MaskedWalletRequest zzbea;
    private MaskedWallet zzbeb;
    private int zzbeo;

    private WalletFragmentInitParams()
    {
        mVersionCode = 1;
        zzbeo = -1;
    }

    WalletFragmentInitParams(int i, String s, MaskedWalletRequest maskedwalletrequest, int j, MaskedWallet maskedwallet)
    {
        mVersionCode = i;
        zzRs = s;
        zzbea = maskedwalletrequest;
        zzbeo = j;
        zzbeb = maskedwallet;
    }

    public static Builder newBuilder()
    {
        WalletFragmentInitParams walletfragmentinitparams = new WalletFragmentInitParams();
        walletfragmentinitparams.getClass();
        return walletfragmentinitparams. new Builder(null);
    }

    static int zza(WalletFragmentInitParams walletfragmentinitparams, int i)
    {
        walletfragmentinitparams.zzbeo = i;
        return i;
    }

    static MaskedWallet zza(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzbeb;
    }

    static MaskedWallet zza(WalletFragmentInitParams walletfragmentinitparams, MaskedWallet maskedwallet)
    {
        walletfragmentinitparams.zzbeb = maskedwallet;
        return maskedwallet;
    }

    static MaskedWalletRequest zza(WalletFragmentInitParams walletfragmentinitparams, MaskedWalletRequest maskedwalletrequest)
    {
        walletfragmentinitparams.zzbea = maskedwalletrequest;
        return maskedwalletrequest;
    }

    static String zza(WalletFragmentInitParams walletfragmentinitparams, String s)
    {
        walletfragmentinitparams.zzRs = s;
        return s;
    }

    static MaskedWalletRequest zzb(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzbea;
    }

    static int zzc(WalletFragmentInitParams walletfragmentinitparams)
    {
        return walletfragmentinitparams.zzbeo;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getAccountName()
    {
        return zzRs;
    }

    public final MaskedWallet getMaskedWallet()
    {
        return zzbeb;
    }

    public final MaskedWalletRequest getMaskedWalletRequest()
    {
        return zzbea;
    }

    public final int getMaskedWalletRequestCode()
    {
        return zzbeo;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.fragment.zza.zza(this, parcel, i);
    }


    private class Builder
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

        public final Builder setAccountName(String s)
        {
            WalletFragmentInitParams.zza(zzbep, s);
            return this;
        }

        public final Builder setMaskedWallet(MaskedWallet maskedwallet)
        {
            WalletFragmentInitParams.zza(zzbep, maskedwallet);
            return this;
        }

        public final Builder setMaskedWalletRequest(MaskedWalletRequest maskedwalletrequest)
        {
            WalletFragmentInitParams.zza(zzbep, maskedwalletrequest);
            return this;
        }

        public final Builder setMaskedWalletRequestCode(int i)
        {
            WalletFragmentInitParams.zza(zzbep, i);
            return this;
        }

        private Builder()
        {
            zzbep = WalletFragmentInitParams.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
