// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzf, Cart

public final class FullWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    Cart zzbcA;
    String zzbcp;
    String zzbcq;

    FullWalletRequest()
    {
        mVersionCode = 1;
    }

    FullWalletRequest(int i, String s, String s1, Cart cart)
    {
        mVersionCode = i;
        zzbcp = s;
        zzbcq = s1;
        zzbcA = cart;
    }

    public static Builder newBuilder()
    {
        FullWalletRequest fullwalletrequest = new FullWalletRequest();
        fullwalletrequest.getClass();
        return fullwalletrequest. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Cart getCart()
    {
        return zzbcA;
    }

    public final String getGoogleTransactionId()
    {
        return zzbcp;
    }

    public final String getMerchantTransactionId()
    {
        return zzbcq;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }


    private class Builder
    {

        final FullWalletRequest zzbcB;

        public final FullWalletRequest build()
        {
            return zzbcB;
        }

        public final Builder setCart(Cart cart)
        {
            zzbcB.zzbcA = cart;
            return this;
        }

        public final Builder setGoogleTransactionId(String s)
        {
            zzbcB.zzbcp = s;
            return this;
        }

        public final Builder setMerchantTransactionId(String s)
        {
            zzbcB.zzbcq = s;
            return this;
        }

        private Builder()
        {
            zzbcB = FullWalletRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
