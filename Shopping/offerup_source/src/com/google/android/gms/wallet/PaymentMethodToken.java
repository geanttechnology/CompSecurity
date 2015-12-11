// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzo

public final class PaymentMethodToken
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzo();
    private final int mVersionCode;
    String zzaPv;
    int zzbdC;

    private PaymentMethodToken()
    {
        mVersionCode = 1;
    }

    PaymentMethodToken(int i, int j, String s)
    {
        mVersionCode = i;
        zzbdC = j;
        zzaPv = s;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getPaymentMethodTokenizationType()
    {
        return zzbdC;
    }

    public final String getToken()
    {
        return zzaPv;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

}
