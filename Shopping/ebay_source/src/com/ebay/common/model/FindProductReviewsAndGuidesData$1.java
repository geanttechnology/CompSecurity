// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model:
//            FindProductReviewsAndGuidesData

static final class 
    implements android.os.idesData._cls1
{

    public FindProductReviewsAndGuidesData createFromParcel(Parcel parcel)
    {
        return (FindProductReviewsAndGuidesData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/FindProductReviewsAndGuidesData);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public FindProductReviewsAndGuidesData[] newArray(int i)
    {
        return new FindProductReviewsAndGuidesData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
