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
    String zzaJf;
    int zzaXv;

    private PaymentMethodToken()
    {
        mVersionCode = 1;
    }

    PaymentMethodToken(int i, int j, String s)
    {
        mVersionCode = i;
        zzaXv = j;
        zzaJf = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getPaymentMethodTokenizationType()
    {
        return zzaXv;
    }

    public String getToken()
    {
        return zzaJf;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

}
