// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.local:
//            BaseEbayNowDelivery

static final class tory
    implements android.os.bayNowDelivery._cls1
{

    public BaseEbayNowDelivery createFromParcel(Parcel parcel)
    {
        return (BaseEbayNowDelivery)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/BaseEbayNowDelivery);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public BaseEbayNowDelivery[] newArray(int i)
    {
        return new BaseEbayNowDelivery[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    tory()
    {
    }
}
