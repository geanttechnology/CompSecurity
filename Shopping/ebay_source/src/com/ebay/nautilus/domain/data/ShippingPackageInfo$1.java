// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingPackageInfo

static final class ry
    implements android.os.ppingPackageInfo._cls1
{

    public ShippingPackageInfo createFromParcel(Parcel parcel)
    {
        return (ShippingPackageInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingPackageInfo);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ShippingPackageInfo[] newArray(int i)
    {
        return new ShippingPackageInfo[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ry()
    {
    }
}
