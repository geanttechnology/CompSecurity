// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            zzb, WalletFragmentStyle

public final class WalletFragmentOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private int mTheme;
    final int mVersionCode;
    private int zzaiz;
    private int zzbdL;
    private WalletFragmentStyle zzbeq;

    private WalletFragmentOptions()
    {
        mVersionCode = 1;
    }

    WalletFragmentOptions(int i, int j, int k, WalletFragmentStyle walletfragmentstyle, int l)
    {
        mVersionCode = i;
        zzbdL = j;
        mTheme = k;
        zzbeq = walletfragmentstyle;
        zzaiz = l;
    }

    public static Builder newBuilder()
    {
        WalletFragmentOptions walletfragmentoptions = new WalletFragmentOptions();
        walletfragmentoptions.getClass();
        return walletfragmentoptions. new Builder(null);
    }

    static int zza(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.zzbdL = i;
        return i;
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, com.google.android.gms.R.styleable.WalletFragmentOptions);
        int i = attributeset.getInt(com.google.android.gms.R.styleable.WalletFragmentOptions_appTheme, 0);
        int j = attributeset.getInt(com.google.android.gms.R.styleable.WalletFragmentOptions_environment, 1);
        int k = attributeset.getResourceId(com.google.android.gms.R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int l = attributeset.getInt(com.google.android.gms.R.styleable.WalletFragmentOptions_fragmentMode, 1);
        attributeset.recycle();
        attributeset = new WalletFragmentOptions();
        attributeset.mTheme = i;
        attributeset.zzbdL = j;
        attributeset.zzbeq = (new WalletFragmentStyle()).setStyleResourceId(k);
        ((WalletFragmentOptions) (attributeset)).zzbeq.zzaT(context);
        attributeset.zzaiz = l;
        return attributeset;
    }

    static WalletFragmentStyle zza(WalletFragmentOptions walletfragmentoptions, WalletFragmentStyle walletfragmentstyle)
    {
        walletfragmentoptions.zzbeq = walletfragmentstyle;
        return walletfragmentstyle;
    }

    static int zzb(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.mTheme = i;
        return i;
    }

    static int zzc(WalletFragmentOptions walletfragmentoptions, int i)
    {
        walletfragmentoptions.zzaiz = i;
        return i;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getEnvironment()
    {
        return zzbdL;
    }

    public final WalletFragmentStyle getFragmentStyle()
    {
        return zzbeq;
    }

    public final int getMode()
    {
        return zzaiz;
    }

    public final int getTheme()
    {
        return mTheme;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.fragment.zzb.zza(this, parcel, i);
    }

    public final void zzaT(Context context)
    {
        if (zzbeq != null)
        {
            zzbeq.zzaT(context);
        }
    }


    private class Builder
    {

        final WalletFragmentOptions zzber;

        public final WalletFragmentOptions build()
        {
            return zzber;
        }

        public final Builder setEnvironment(int i)
        {
            WalletFragmentOptions.zza(zzber, i);
            return this;
        }

        public final Builder setFragmentStyle(int i)
        {
            WalletFragmentOptions.zza(zzber, (new WalletFragmentStyle()).setStyleResourceId(i));
            return this;
        }

        public final Builder setFragmentStyle(WalletFragmentStyle walletfragmentstyle)
        {
            WalletFragmentOptions.zza(zzber, walletfragmentstyle);
            return this;
        }

        public final Builder setMode(int i)
        {
            WalletFragmentOptions.zzc(zzber, i);
            return this;
        }

        public final Builder setTheme(int i)
        {
            WalletFragmentOptions.zzb(zzber, i);
            return this;
        }

        private Builder()
        {
            zzber = WalletFragmentOptions.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
