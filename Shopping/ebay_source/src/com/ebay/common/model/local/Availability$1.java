// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.local:
//            Availability

static final class pperFactory
    implements android.os.tor
{

    public Availability createFromParcel(Parcel parcel)
    {
        return (Availability)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/Availability);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public Availability[] newArray(int i)
    {
        return new Availability[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    pperFactory()
    {
    }
}
