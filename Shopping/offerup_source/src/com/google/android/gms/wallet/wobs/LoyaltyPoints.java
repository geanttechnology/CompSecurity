// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            zze, TimeInterval, LoyaltyPointsBalance

public final class LoyaltyPoints
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    String label;
    private final int mVersionCode;
    String type;
    TimeInterval zzbcY;
    LoyaltyPointsBalance zzbeG;

    LoyaltyPoints()
    {
        mVersionCode = 1;
    }

    LoyaltyPoints(int i, String s, LoyaltyPointsBalance loyaltypointsbalance, String s1, TimeInterval timeinterval)
    {
        mVersionCode = i;
        label = s;
        zzbeG = loyaltypointsbalance;
        type = s1;
        zzbcY = timeinterval;
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
        zze.zza(this, parcel, i);
    }

}
