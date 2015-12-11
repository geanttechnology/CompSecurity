// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet:
//            zzb

public final class Cart
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    String zzbci;
    String zzbcj;
    ArrayList zzbck;

    Cart()
    {
        mVersionCode = 1;
        zzbck = new ArrayList();
    }

    Cart(int i, String s, String s1, ArrayList arraylist)
    {
        mVersionCode = i;
        zzbci = s;
        zzbcj = s1;
        zzbck = arraylist;
    }

    public static Builder newBuilder()
    {
        Cart cart = new Cart();
        cart.getClass();
        return cart. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getCurrencyCode()
    {
        return zzbcj;
    }

    public final ArrayList getLineItems()
    {
        return zzbck;
    }

    public final String getTotalPrice()
    {
        return zzbci;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }


    private class Builder
    {

        final Cart zzbcl;

        public final Builder addLineItem(LineItem lineitem)
        {
            zzbcl.zzbck.add(lineitem);
            return this;
        }

        public final Cart build()
        {
            return zzbcl;
        }

        public final Builder setCurrencyCode(String s)
        {
            zzbcl.zzbcj = s;
            return this;
        }

        public final Builder setLineItems(List list)
        {
            zzbcl.zzbck.clear();
            zzbcl.zzbck.addAll(list);
            return this;
        }

        public final Builder setTotalPrice(String s)
        {
            zzbcl.zzbci = s;
            return this;
        }

        private Builder()
        {
            zzbcl = Cart.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
