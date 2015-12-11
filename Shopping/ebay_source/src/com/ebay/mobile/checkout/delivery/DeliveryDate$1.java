// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliveryDate

static final class ctory
    implements android.os.tor
{

    public DeliveryDate createFromParcel(Parcel parcel)
    {
        return (DeliveryDate)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/checkout/delivery/DeliveryDate);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public DeliveryDate[] newArray(int i)
    {
        return new DeliveryDate[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ctory()
    {
    }
}
