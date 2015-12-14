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
    String zzaWz;
    String zzaYA;
    double zzaYB;
    long zzaYC;
    int zzaYD;
    int zzaYz;

    LoyaltyPointsBalance()
    {
        mVersionCode = 1;
        zzaYD = -1;
        zzaYz = -1;
        zzaYB = -1D;
    }

    LoyaltyPointsBalance(int i, int j, String s, double d, String s1, long l, int k)
    {
        mVersionCode = i;
        zzaYz = j;
        zzaYA = s;
        zzaYB = d;
        zzaWz = s1;
        zzaYC = l;
        zzaYD = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
