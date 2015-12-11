// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            zzb, WalletFragmentStyle

public final class WalletFragmentOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private int mTheme;
    final int zzCY;
    private int zzaRH;
    private WalletFragmentStyle zzaSk;
    private int zzacS;

    private WalletFragmentOptions()
    {
        zzCY = 1;
    }

    WalletFragmentOptions(int i, int j, int k, WalletFragmentStyle walletfragmentstyle, int l)
    {
        zzCY = i;
        zzaRH = j;
        mTheme = k;
        zzaSk = walletfragmentstyle;
        zzacS = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getEnvironment()
    {
        return zzaRH;
    }

    public WalletFragmentStyle getFragmentStyle()
    {
        return zzaSk;
    }

    public int getMode()
    {
        return zzacS;
    }

    public int getTheme()
    {
        return mTheme;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
