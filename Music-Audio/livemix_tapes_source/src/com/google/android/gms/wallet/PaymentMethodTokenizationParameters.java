// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.wallet:
//            zzp

public final class PaymentMethodTokenizationParameters
    implements SafeParcelable
{
    public final class Builder
    {

        final PaymentMethodTokenizationParameters zzaXx;

        public Builder addParameter(String s, String s1)
        {
            zzx.zzh(s, "Tokenization parameter name must not be empty");
            zzx.zzh(s1, "Tokenization parameter value must not be empty");
            zzaXx.zzaXw.putString(s, s1);
            return this;
        }

        public PaymentMethodTokenizationParameters build()
        {
            return zzaXx;
        }

        public Builder setPaymentMethodTokenizationType(int i)
        {
            zzaXx.zzaXv = i;
            return this;
        }

        private Builder()
        {
            zzaXx = PaymentMethodTokenizationParameters.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    int zzaXv;
    Bundle zzaXw;

    private PaymentMethodTokenizationParameters()
    {
        zzaXw = new Bundle();
        mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int i, int j, Bundle bundle)
    {
        zzaXw = new Bundle();
        mVersionCode = i;
        zzaXv = j;
        zzaXw = bundle;
    }

    public static Builder newBuilder()
    {
        PaymentMethodTokenizationParameters paymentmethodtokenizationparameters = new PaymentMethodTokenizationParameters();
        paymentmethodtokenizationparameters.getClass();
        return paymentmethodtokenizationparameters. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public Bundle getParameters()
    {
        return new Bundle(zzaXw);
    }

    public int getPaymentMethodTokenizationType()
    {
        return zzaXv;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }

}
