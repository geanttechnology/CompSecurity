// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliverySchedulingParams

static final class 
    implements android.os.verySchedulingParams._cls1
{

    public DeliverySchedulingParams createFromParcel(Parcel parcel)
    {
        return (DeliverySchedulingParams)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/checkout/delivery/DeliverySchedulingParams);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public DeliverySchedulingParams[] newArray(int i)
    {
        return new DeliverySchedulingParams[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
