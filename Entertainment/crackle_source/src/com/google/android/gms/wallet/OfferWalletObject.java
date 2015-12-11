// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            k

public final class OfferWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new k();
    String GA;
    String GX;
    private final int kg;

    OfferWalletObject()
    {
        kg = 2;
    }

    OfferWalletObject(int i, String s, String s1)
    {
        kg = i;
        GA = s;
        GX = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getId()
    {
        return GA;
    }

    public String getRedemptionCode()
    {
        return GX;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        k.a(this, parcel, i);
    }

}
