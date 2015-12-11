// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.cart:
//            CartPaymentMethods

static final class actory
    implements android.os.aymentMethods._cls1
{

    public CartPaymentMethods createFromParcel(Parcel parcel)
    {
        return (CartPaymentMethods)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/cart/CartPaymentMethods);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CartPaymentMethods[] newArray(int i)
    {
        return new CartPaymentMethods[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    actory()
    {
    }
}
