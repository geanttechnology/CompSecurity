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
    public final class Builder
    {

        final FullWalletRequest zzaWu;

        public FullWalletRequest build()
        {
            return zzaWu;
        }

        public Builder setCart(Cart cart)
        {
            zzaWu.zzaWt = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            zzaWu.zzaWi = s;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            zzaWu.zzaWj = s;
            return this;
        }

        private Builder()
        {
            zzaWu = FullWalletRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    private final int mVersionCode;
    String zzaWi;
    String zzaWj;
    Cart zzaWt;

    FullWalletRequest()
    {
        mVersionCode = 1;
    }

    FullWalletRequest(int i, String s, String s1, Cart cart)
    {
        mVersionCode = i;
        zzaWi = s;
        zzaWj = s1;
        zzaWt = cart;
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
        return zzaWt;
    }

    public String getGoogleTransactionId()
    {
        return zzaWi;
    }

    public String getMerchantTransactionId()
    {
        return zzaWj;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

}
