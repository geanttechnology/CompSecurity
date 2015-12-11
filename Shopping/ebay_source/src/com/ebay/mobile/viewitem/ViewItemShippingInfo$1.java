// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemShippingInfo

static final class actory
    implements android.os.hippingInfo._cls1
{

    public ViewItemShippingInfo createFromParcel(Parcel parcel)
    {
        return (ViewItemShippingInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/viewitem/ViewItemShippingInfo);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ViewItemShippingInfo[] newArray(int i)
    {
        return new ViewItemShippingInfo[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    actory()
    {
    }
}
