// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzp

public final class PaymentMethodTokenizationParameters
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    int zzbdC;
    Bundle zzbdD;

    private PaymentMethodTokenizationParameters()
    {
        zzbdD = new Bundle();
        mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int i, int j, Bundle bundle)
    {
        zzbdD = new Bundle();
        mVersionCode = i;
        zzbdC = j;
        zzbdD = bundle;
    }

    public static Builder newBuilder()
    {
        PaymentMethodTokenizationParameters paymentmethodtokenizationparameters = new PaymentMethodTokenizationParameters();
        paymentmethodtokenizationparameters.getClass();
        return paymentmethodtokenizationparameters. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Bundle getParameters()
    {
        return new Bundle(zzbdD);
    }

    public final int getPaymentMethodTokenizationType()
    {
        return zzbdC;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }


    private class Builder
    {

        final PaymentMethodTokenizationParameters zzbdE;

        public final Builder addParameter(String s, String s1)
        {
            zzx.zzh(s, "Tokenization parameter name must not be empty");
            zzx.zzh(s1, "Tokenization parameter value must not be empty");
            zzbdE.zzbdD.putString(s, s1);
            return this;
        }

        public final PaymentMethodTokenizationParameters build()
        {
            return zzbdE;
        }

        public final Builder setPaymentMethodTokenizationType(int i)
        {
            zzbdE.zzbdC = i;
            return this;
        }

        private Builder()
        {
            zzbdE = PaymentMethodTokenizationParameters.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
