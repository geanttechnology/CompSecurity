// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.math.BigDecimal;
import junit.framework.Assert;

// Referenced classes of package com.ebay.mobile.common:
//            HashCodeUtil

public class ItemPrice
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ItemPrice createFromParcel(Parcel parcel)
        {
            return new ItemPrice(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemPrice[] newArray(int i)
        {
            return new ItemPrice[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public double m_amount;
    public String m_currency;

    public ItemPrice()
    {
        m_currency = MyApp.getPrefs().getCurrentSite().getCurrency().getCurrencyCode();
        m_amount = 0.0D;
    }

    public ItemPrice(double d, String s)
    {
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("currency required", flag);
        m_amount = d;
        m_currency = s;
    }

    private ItemPrice(Parcel parcel)
    {
        m_currency = parcel.readString();
        m_amount = Double.parseDouble(parcel.readString());
    }


    public ItemPrice(CurrencyAmount currencyamount)
    {
        m_amount = Double.parseDouble(currencyamount.getValueAsBigDecimal().toString());
        m_currency = currencyamount.getCurrencyCode();
    }

    public ItemPrice(ItemCurrency itemcurrency)
    {
        m_amount = Double.parseDouble(itemcurrency.value);
        m_currency = itemcurrency.code;
    }

    public ItemPrice(String s)
    {
        if (s == null || s.length() < 1)
        {
            m_currency = MyApp.getPrefs().getCurrentSite().getCurrency().getCurrencyCode();
            m_amount = 0.0D;
            return;
        }
        s = s.split("\\:");
        if (2 > s.length)
        {
            m_currency = "";
            m_amount = 0.0D;
            return;
        } else
        {
            m_currency = s[0];
            m_amount = Double.parseDouble(s[1]);
            return;
        }
    }

    public static boolean isDefault(ItemPrice itemprice)
    {
        while (itemprice == null || itemprice.m_currency.equals(MyApp.getPrefs().getCurrentSite().getCurrency().getCurrencyCode()) && itemprice.m_amount == 0.0D) 
        {
            return true;
        }
        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ItemPrice)obj;
            if (((ItemPrice) (obj)).m_amount != m_amount || !((ItemPrice) (obj)).m_currency.equals(m_currency))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return HashCodeUtil.hash(HashCodeUtil.hash(47, m_amount), m_currency);
    }

    public String toString()
    {
        return (new StringBuilder()).append(m_currency).append(": ").append(Double.toString(m_amount)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(m_currency);
        parcel.writeString(Double.toString(m_amount));
    }

}
