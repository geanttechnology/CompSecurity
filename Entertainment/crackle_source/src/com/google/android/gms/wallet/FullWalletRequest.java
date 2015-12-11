// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            e, Cart

public final class FullWalletRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final FullWalletRequest Gv;

        public FullWalletRequest build()
        {
            return Gv;
        }

        public Builder setCart(Cart cart)
        {
            Gv.Gu = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            Gv.Gn = s;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            Gv.Go = s;
            return this;
        }

        private Builder()
        {
            Gv = FullWalletRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new e();
    String Gn;
    String Go;
    Cart Gu;
    private final int kg;

    FullWalletRequest()
    {
        kg = 1;
    }

    FullWalletRequest(int i, String s, String s1, Cart cart)
    {
        kg = i;
        Gn = s;
        Go = s1;
        Gu = cart;
    }

    public static Builder newBuilder()
    {
        FullWalletRequest fullwalletrequest = new FullWalletRequest();
        fullwalletrequest.getClass();
        return fullwalletrequest. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public Cart getCart()
    {
        return Gu;
    }

    public String getGoogleTransactionId()
    {
        return Gn;
    }

    public String getMerchantTransactionId()
    {
        return Go;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        e.a(this, parcel, i);
    }

}
