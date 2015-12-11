// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCurrency;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import junit.framework.Assert;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency

public final class CurrencyAmount
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CurrencyAmount createFromParcel(Parcel parcel)
        {
            return new CurrencyAmount(parcel.readString(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CurrencyAmount[] newArray(int i)
        {
            return new CurrencyAmount[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final CurrencyAmount ZERO = new CurrencyAmount();
    private static MathContext mc;
    private static final long serialVersionUID = 0x92599dea2c95dcd7L;
    private final String currencyCode;
    private final BigDecimal value;

    protected CurrencyAmount()
    {
        this(BigDecimal.ZERO, "USD");
    }

    public CurrencyAmount(double d, String s)
    {
        value = BigDecimal.valueOf(d);
        currencyCode = s;
    }

    public CurrencyAmount(CurrencyAmount currencyamount)
    {
        value = currencyamount.value;
        currencyCode = currencyamount.currencyCode;
    }

    public CurrencyAmount(ItemCurrency itemcurrency)
    {
        Assert.assertNotNull(itemcurrency);
        value = new BigDecimal(itemcurrency.value);
        currencyCode = itemcurrency.code;
    }

    public CurrencyAmount(String s, String s1)
    {
        value = new BigDecimal(s);
        currencyCode = s1;
    }

    public CurrencyAmount(BigDecimal bigdecimal, String s)
    {
        value = bigdecimal;
        currencyCode = s;
    }

    public CurrencyAmount add(CurrencyAmount currencyamount)
    {
        if (currencyamount == null)
        {
            return this;
        } else
        {
            return new CurrencyAmount(value.add(currencyamount.value), currencyCode);
        }
    }

    public CurrencyAmount add(ItemCurrency itemcurrency)
    {
        if (itemcurrency == null)
        {
            return this;
        } else
        {
            return new CurrencyAmount(value.add(BigDecimal.valueOf(Double.parseDouble(itemcurrency.value))), currencyCode);
        }
    }

    public int compareTo(CurrencyAmount currencyamount)
    {
        return value.compareTo(currencyamount.value);
    }

    public int compareToZero()
    {
        return value.compareTo(BigDecimal.ZERO);
    }

    public int describeContents()
    {
        return 0;
    }

    public CurrencyAmount divideBy(int i)
    {
        return new CurrencyAmount(new BigDecimal(value.doubleValue() / (double)i, mc), currencyCode);
    }

    public CurrencyAmount divideBy(CurrencyAmount currencyamount)
    {
        return new CurrencyAmount(new BigDecimal(value.doubleValue() / currencyamount.value.doubleValue(), mc), currencyCode);
    }

    public CurrencyAmount divideBy(BigDecimal bigdecimal)
    {
        return new CurrencyAmount(value.divide(bigdecimal, mc), currencyCode);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof CurrencyAmount)
            {
                obj = (CurrencyAmount)obj;
                flag = flag1;
                if (toString().equals(((CurrencyAmount) (obj)).toString()))
                {
                    return true;
                }
            }
        }
        return flag;
    }

    public final String getCurrencyCode()
    {
        return currencyCode;
    }

    public final BigDecimal getValueAsBigDecimal()
    {
        return value;
    }

    public final double getValueAsDouble()
    {
        return value.doubleValue();
    }

    public String getValueAsString()
    {
        return getValueAsString(null);
    }

    public String getValueAsString(Locale locale)
    {
        return getValueAsString(locale, true);
    }

    public String getValueAsString(Locale locale, boolean flag)
    {
        if (locale != null)
        {
            locale = NumberFormat.getInstance(locale);
        } else
        {
            locale = NumberFormat.getInstance();
        }
        locale.setMinimumFractionDigits(2);
        locale.setMaximumFractionDigits(2);
        locale.setGroupingUsed(flag);
        return locale.format(value);
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (currencyCode == null)
        {
            i = 0;
        } else
        {
            i = currencyCode.hashCode();
        }
        if (value != null)
        {
            j = value.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public boolean isGreaterThanZero()
    {
        return value.compareTo(BigDecimal.ZERO) == 1;
    }

    public boolean isZero()
    {
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    public CurrencyAmount multiplyBy(int i)
    {
        return new CurrencyAmount(value.multiply(new BigDecimal(i)), currencyCode);
    }

    public CurrencyAmount multiplyBy(CurrencyAmount currencyamount)
    {
        return new CurrencyAmount(new BigDecimal(value.doubleValue() * currencyamount.value.doubleValue(), mc), currencyCode);
    }

    public CurrencyAmount multiplyBy(BigDecimal bigdecimal)
    {
        return new CurrencyAmount(value.multiply(bigdecimal), currencyCode);
    }

    public CurrencyAmount subtract(CurrencyAmount currencyamount)
    {
        if (currencyamount == null)
        {
            return this;
        } else
        {
            return new CurrencyAmount(value.subtract(currencyamount.value), currencyCode);
        }
    }

    public String toAbbrevString()
    {
        EbayCurrency ebaycurrency = EbayCurrency.getInstance(currencyCode);
        if (ebaycurrency == null)
        {
            return getValueAsString();
        } else
        {
            return (new StringBuilder()).append(ebaycurrency.getSymbol()).append(getValueAsString()).toString();
        }
    }

    public final ItemCurrency toItemCurrency()
    {
        return new ItemCurrency(currencyCode, value.toString());
    }

    public String toString()
    {
        return EbayCurrency.getInstance(currencyCode).getDecimalFormat(false).format(value);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(value.toEngineeringString());
        parcel.writeString(currencyCode);
    }

    static 
    {
        mc = MathContext.DECIMAL32;
    }
}
