// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.currency;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model.currency:
//            CurrencyConversionRate

static final class 
    implements android.os.ncyConversionRate._cls1
{

    public CurrencyConversionRate createFromParcel(Parcel parcel)
    {
        return (CurrencyConversionRate)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/currency/CurrencyConversionRate);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public CurrencyConversionRate[] newArray(int i)
    {
        return new CurrencyConversionRate[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
