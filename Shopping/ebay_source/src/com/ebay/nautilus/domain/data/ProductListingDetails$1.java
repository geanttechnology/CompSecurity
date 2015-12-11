// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ProductListingDetails

static final class 
    implements android.os.ctListingDetails._cls1
{

    public ProductListingDetails createFromParcel(Parcel parcel)
    {
        return (ProductListingDetails)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ProductListingDetails);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ProductListingDetails[] newArray(int i)
    {
        return new ProductListingDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
