// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.currency;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

public final class CurrencyConversionRate extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

    };
    public final BigDecimal conversionFactor;
    public final String fromCurrency;
    public final boolean isExchangeRateAvailable;
    public final long timeStamp;
    public final String toCurrency;

    protected CurrencyConversionRate()
    {
        timeStamp = 0L;
        conversionFactor = null;
        fromCurrency = null;
        toCurrency = null;
        isExchangeRateAvailable = false;
    }

    public CurrencyConversionRate(long l, String s, String s1, String s2, boolean flag)
        throws ParseException
    {
        timeStamp = l;
        if (s != null)
        {
            conversionFactor = new BigDecimal(s);
        } else
        {
            conversionFactor = BigDecimal.ZERO;
        }
        fromCurrency = s1;
        toCurrency = s2;
        isExchangeRateAvailable = flag;
    }

    public CurrencyConversionRate createReciprocalRate()
    {
label0:
        {
            Object obj;
            try
            {
                if (conversionFactor.compareTo(BigDecimal.ZERO) != 1)
                {
                    break label0;
                }
                obj = BigDecimal.ONE.divide(conversionFactor, 6, RoundingMode.HALF_EVEN);
                obj = new CurrencyConversionRate(timeStamp, ((BigDecimal) (obj)).toString(), toCurrency, fromCurrency, isExchangeRateAvailable);
            }
            catch (ParseException parseexception)
            {
                return null;
            }
            return ((CurrencyConversionRate) (obj));
        }
        return null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (isExchangeRateAvailable)
        {
            stringbuilder.append("1 ").append(fromCurrency.toString()).append(" = ").append(conversionFactor).append(" ").append(toCurrency.toString());
        } else
        {
            stringbuilder.append(fromCurrency.toString()).append(" to ").append(toCurrency.toString()).append(" is not available");
        }
        return stringbuilder.toString();
    }

}
