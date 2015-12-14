// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wallet:
//            zzb, LineItem

public final class Cart
    implements SafeParcelable
{
    public final class Builder
    {

        final Cart zzaWe;

        public Builder addLineItem(LineItem lineitem)
        {
            zzaWe.zzaWd.add(lineitem);
            return this;
        }

        public Cart build()
        {
            return zzaWe;
        }

        public Builder setCurrencyCode(String s)
        {
            zzaWe.zzaWc = s;
            return this;
        }

        public Builder setLineItems(List list)
        {
            zzaWe.zzaWd.clear();
            zzaWe.zzaWd.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String s)
        {
            zzaWe.zzaWb = s;
            return this;
        }

        private Builder()
        {
            zzaWe = Cart.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    String zzaWb;
    String zzaWc;
    ArrayList zzaWd;

    Cart()
    {
        mVersionCode = 1;
        zzaWd = new ArrayList();
    }

    Cart(int i, String s, String s1, ArrayList arraylist)
    {
        mVersionCode = i;
        zzaWb = s;
        zzaWc = s1;
        zzaWd = arraylist;
    }

    public static Builder newBuilder()
    {
        Cart cart = new Cart();
        cart.getClass();
        return cart. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCurrencyCode()
    {
        return zzaWc;
    }

    public ArrayList getLineItems()
    {
        return zzaWd;
    }

    public String getTotalPrice()
    {
        return zzaWb;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
