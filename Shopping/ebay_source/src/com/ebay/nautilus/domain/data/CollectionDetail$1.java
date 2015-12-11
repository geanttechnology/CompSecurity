// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CollectionDetail

static final class ctory
    implements android.os.CollectionDetail._cls1
{

    public CollectionDetail createFromParcel(Parcel parcel)
    {
        return (CollectionDetail)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/CollectionDetail);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CollectionDetail[] newArray(int i)
    {
        return new CollectionDetail[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ctory()
    {
    }
}
