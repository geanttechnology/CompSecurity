// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CreditCard

static final class pperFactory
    implements android.os.eator
{

    public CreditCard createFromParcel(Parcel parcel)
    {
        return (CreditCard)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/CreditCard);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CreditCard[] newArray(int i)
    {
        return new CreditCard[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    pperFactory()
    {
    }
}
