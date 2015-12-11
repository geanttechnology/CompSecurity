// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

// Referenced classes of package com.ebay.common.model.local:
//            BaseEbayNowDelivery

public class EbayNowDelivery extends BaseEbayNowDelivery
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayNowDelivery createFromParcel(Parcel parcel)
        {
            return (EbayNowDelivery)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/EbayNowDelivery);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayNowDelivery[] newArray(int i)
        {
            return new EbayNowDelivery[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final BaseEbayNowDelivery.CurrencyAmountWrapper feeWrapper;

    public EbayNowDelivery(String s, String s1, Date date, BaseEbayNowDelivery.CurrencyAmountWrapper currencyamountwrapper, BaseEbayNowDelivery.EstimatedDelivery estimateddelivery)
    {
        super(s, s1, date, estimateddelivery);
        feeWrapper = currencyamountwrapper;
    }

    public CurrencyAmount getFee()
    {
        return feeWrapper.asCurrencyAmount();
    }

    public String toString()
    {
        return (new StringBuilder()).append("EbayNowDelivery [serviceId=").append(serviceId).append(", displayName=").append(displayName).append(", orderCutoffTime=").append(orderCutoffTime).append(", fee=").append(getFee()).append(", estimatedDelivery=").append(estimatedDelivery).append("]").toString();
    }

}
