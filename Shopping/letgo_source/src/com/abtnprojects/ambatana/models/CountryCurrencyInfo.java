// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.aeu;
import android.support.v7.aev;
import android.support.v7.aqo;
import android.text.TextUtils;
import java.util.Currency;
import java.util.Locale;

public class CountryCurrencyInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CountryCurrencyInfo createFromParcel(Parcel parcel)
        {
            return new CountryCurrencyInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CountryCurrencyInfo[] newArray(int i)
        {
            return new CountryCurrencyInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String countryCode;
    private final String currencyCode;
    private final String currencySymbol;
    private final String localeString;

    public CountryCurrencyInfo(Parcel parcel)
    {
        countryCode = parcel.readString();
        currencySymbol = parcel.readString();
        currencyCode = parcel.readString();
        localeString = parcel.readString();
    }

    public CountryCurrencyInfo(String s, String s1, String s2, String s3)
    {
        Locale locale = Locale.getDefault();
        String s4 = s1;
        if (TextUtils.isEmpty(s1))
        {
            s4 = Currency.getInstance(locale).getCurrencyCode();
        }
        aqo.a("CurrencyCode : %s ", new Object[] {
            s4
        });
        aqo.a("CurrencySymbol : %s", new Object[] {
            s3
        });
        s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = locale.toString();
        }
        countryCode = s;
        currencySymbol = s3;
        currencyCode = s4;
        localeString = s1;
    }

    public static CountryCurrencyInfo createDefaultCountryCurrencyInfo()
    {
        Locale locale = Locale.getDefault();
        Object obj;
        String s;
        String s1;
        try
        {
            obj = Currency.getInstance(locale);
            s = ((Currency) (obj)).getCurrencyCode();
            obj = ((Currency) (obj)).getSymbol(locale);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            aqo.a(illegalargumentexception, "Unsupported iso country", new Object[0]);
            illegalargumentexception = Currency.getInstance(Locale.US);
            s = illegalargumentexception.getCurrencyCode();
            illegalargumentexception = illegalargumentexception.getSymbol(Locale.US);
        }
        s1 = locale.toString();
        return new CountryCurrencyInfo(locale.getCountry(), s, s1, ((String) (obj)));
    }

    public static CountryCurrencyInfo fromJSON(String s)
    {
        Object obj;
        if (s == null)
        {
            return null;
        }
        obj = (new aev()).a();
        obj = (CountryCurrencyInfo)((aeu) (obj)).a(s, com/abtnprojects/ambatana/models/CountryCurrencyInfo);
        s = ((String) (obj));
_L2:
        return s;
        Exception exception;
        exception;
        aqo.b(exception, "fromJSON %s ", new Object[] {
            s
        });
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String asJson()
    {
        return (new aeu()).a(this);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public String getCurrencySymbol()
    {
        return currencySymbol;
    }

    public String getLocaleString()
    {
        return localeString;
    }

    public String toString()
    {
        return (new StringBuilder()).append("CountryCurrencyInfo{countryCode='").append(countryCode).append('\'').append(", currencySymbol='").append(currencySymbol).append('\'').append(", currencyCode='").append(currencyCode).append('\'').append(", localeString='").append(localeString).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(countryCode);
        parcel.writeString(currencySymbol);
        parcel.writeString(currencyCode);
        parcel.writeString(localeString);
    }

}
