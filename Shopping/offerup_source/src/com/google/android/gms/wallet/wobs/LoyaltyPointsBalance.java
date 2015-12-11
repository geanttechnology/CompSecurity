// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            zzd

public final class LoyaltyPointsBalance
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    String zzbcG;
    int zzbeH;
    String zzbeI;
    double zzbeJ;
    long zzbeK;
    int zzbeL;

    LoyaltyPointsBalance()
    {
        mVersionCode = 1;
        zzbeL = -1;
        zzbeH = -1;
        zzbeJ = -1D;
    }

    LoyaltyPointsBalance(int i, int j, String s, double d, String s1, long l, int k)
    {
        mVersionCode = i;
        zzbeH = j;
        zzbeI = s;
        zzbeJ = d;
        zzbcG = s1;
        zzbeK = l;
        zzbeL = k;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
