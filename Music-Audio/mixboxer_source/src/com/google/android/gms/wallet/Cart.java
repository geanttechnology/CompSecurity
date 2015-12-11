// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wallet:
//            b, LineItem

public final class Cart
    implements SafeParcelable
{
    public final class Builder
    {

        final Cart Gm;

        public Builder addLineItem(LineItem lineitem)
        {
            Gm.Gl.add(lineitem);
            return this;
        }

        public Cart build()
        {
            return Gm;
        }

        public Builder setCurrencyCode(String s)
        {
            Gm.Gk = s;
            return this;
        }

        public Builder setLineItems(List list)
        {
            Gm.Gl.clear();
            Gm.Gl.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String s)
        {
            Gm.Gj = s;
            return this;
        }

        private Builder()
        {
            Gm = Cart.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new b();
    String Gj;
    String Gk;
    ArrayList Gl;
    private final int kg;

    Cart()
    {
        kg = 1;
        Gl = new ArrayList();
    }

    Cart(int i, String s, String s1, ArrayList arraylist)
    {
        kg = i;
        Gj = s;
        Gk = s1;
        Gl = arraylist;
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
        return Gk;
    }

    public ArrayList getLineItems()
    {
        return Gl;
    }

    public String getTotalPrice()
    {
        return Gj;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b.a(this, parcel, i);
    }

}
