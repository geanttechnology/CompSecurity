// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.givingworks;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.givingworks:
//            NonprofitData

static final class tory
    implements android.os.or
{

    public NonprofitData createFromParcel(Parcel parcel)
    {
        return (NonprofitData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/givingworks/NonprofitData);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public NonprofitData[] newArray(int i)
    {
        return new NonprofitData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    tory()
    {
    }
}
