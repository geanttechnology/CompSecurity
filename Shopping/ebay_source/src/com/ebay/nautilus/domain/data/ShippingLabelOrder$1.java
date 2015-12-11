// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelOrder

static final class ory
    implements android.os.ippingLabelOrder._cls1
{

    public ShippingLabelOrder createFromParcel(Parcel parcel)
    {
        return (ShippingLabelOrder)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingLabelOrder);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ShippingLabelOrder[] newArray(int i)
    {
        return new ShippingLabelOrder[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ory()
    {
    }
}
