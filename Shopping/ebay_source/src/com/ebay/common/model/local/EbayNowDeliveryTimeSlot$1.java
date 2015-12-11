// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.local:
//            EbayNowDeliveryTimeSlot

static final class 
    implements android.os.liveryTimeSlot._cls1
{

    public EbayNowDeliveryTimeSlot createFromParcel(Parcel parcel)
    {
        return (EbayNowDeliveryTimeSlot)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/EbayNowDeliveryTimeSlot);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public EbayNowDeliveryTimeSlot[] newArray(int i)
    {
        return new EbayNowDeliveryTimeSlot[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
