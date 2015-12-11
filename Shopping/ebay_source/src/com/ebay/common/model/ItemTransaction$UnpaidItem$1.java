// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model:
//            ItemTransaction

static final class ory
    implements android.os.paidItem._cls1
{

    public ory createFromParcel(Parcel parcel)
    {
        return (ory)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/ItemTransaction$UnpaidItem);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ory()
    {
    }
}
