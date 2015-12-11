// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.local:
//            AvailabilityIdentifier

static final class y
    implements android.os.lityIdentifier._cls1
{

    public AvailabilityIdentifier createFromParcel(Parcel parcel)
    {
        return (AvailabilityIdentifier)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/AvailabilityIdentifier);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public AvailabilityIdentifier[] newArray(int i)
    {
        return new AvailabilityIdentifier[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    y()
    {
    }
}
