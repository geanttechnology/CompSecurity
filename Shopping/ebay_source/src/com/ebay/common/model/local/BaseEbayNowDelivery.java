// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

public class BaseEbayNowDelivery extends BaseDataMapped
    implements Parcelable
{
    public static class CurrencyAmountWrapper
    {

        protected final String amt;
        protected final String currency;

        public CurrencyAmount asCurrencyAmount()
        {
            if (!TextUtils.isEmpty(amt) && !TextUtils.isEmpty(currency))
            {
                return new CurrencyAmount(amt, currency);
            } else
            {
                return null;
            }
        }

        public String getAmt()
        {
            return amt;
        }

        public String getCurrency()
        {
            return currency;
        }

        public String toString()
        {
            return (new StringBuilder()).append("CurrencyAmountWrapper [amount=").append(asCurrencyAmount()).append("]").toString();
        }

        public CurrencyAmountWrapper(CurrencyAmount currencyamount)
        {
            this(String.valueOf(currencyamount.getValueAsDouble()), currencyamount.getCurrencyCode());
        }

        public CurrencyAmountWrapper(String s, String s1)
        {
            amt = s;
            currency = s1;
        }
    }

    public static class EstimatedDelivery
    {

        public final Date max;
        public final Date min;

        public String toString()
        {
            return (new StringBuilder()).append("EstimatedDelivery [min=").append(min).append(", max=").append(max).append("]").toString();
        }

        public EstimatedDelivery(Date date, Date date1)
        {
            min = date;
            max = date1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BaseEbayNowDelivery createFromParcel(Parcel parcel)
        {
            return (BaseEbayNowDelivery)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/local/BaseEbayNowDelivery);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BaseEbayNowDelivery[] newArray(int i)
        {
            return new BaseEbayNowDelivery[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String displayName;
    public final EstimatedDelivery estimatedDelivery;
    public final Date orderCutoffTime;
    public final String serviceId;

    public BaseEbayNowDelivery(String s, String s1, Date date, EstimatedDelivery estimateddelivery)
    {
        serviceId = s;
        displayName = s1;
        orderCutoffTime = date;
        estimatedDelivery = estimateddelivery;
    }

    public String toString()
    {
        return (new StringBuilder()).append("EbayNowDelivery [serviceId=").append(serviceId).append(", displayName=").append(displayName).append(", orderCutoffTime=").append(orderCutoffTime).append(", estimatedDelivery=").append(estimatedDelivery).append("]").toString();
    }

}
