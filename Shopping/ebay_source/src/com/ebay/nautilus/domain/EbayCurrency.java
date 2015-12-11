// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EbayCurrency
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCurrency createFromParcel(Parcel parcel)
        {
            return EbayCurrency.getInstance(parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCurrency[] newArray(int i)
        {
            return new EbayCurrency[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int DEFAULT_FRACTION_DIGITS = 2;
    private static final char DIGIT_PATTERN_CHAR = 35;
    private static Pattern GET_DECIMAL_FORMAT_REMOVE_SYMBOL = Pattern.compile(String.format("%s?%s%s?", new Object[] {
        Character.valueOf('\240'), Character.valueOf('\244'), Character.valueOf('\240')
    }));
    private static final char NONBREAKING_SPACE = 160;
    private static final char SYMBOL_PATTERN_CHAR = 164;
    private static final Map instances = new HashMap();
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(logTag, 3, "eBay currency class debug messages");
    private static final String logTag = com/ebay/nautilus/domain/EbayCurrency.getSimpleName();
    private final Currency currency;
    private final String currencyCode;
    private final String domesticShortSymbolOverrideLeft;
    private final String domesticShortSymbolOverrideRight;
    private final String domesticSymbolOverrideLeft;
    private final String domesticSymbolOverrideRight;
    private final String internationalSymbolOverrideLeft;
    private final String internationalSymbolOverrideRight;

    private EbayCurrency(String s)
    {
        this(s, null, null, null, null, null, null);
    }

    private EbayCurrency(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        String s7;
        s7 = resolveCurrencyCode(s);
        s = null;
        Currency currency1 = Currency.getInstance(s7);
        s = currency1;
_L2:
        currencyCode = s7;
        domesticSymbolOverrideLeft = s1;
        domesticSymbolOverrideRight = s2;
        domesticShortSymbolOverrideLeft = s3;
        domesticShortSymbolOverrideRight = s4;
        internationalSymbolOverrideLeft = s5;
        internationalSymbolOverrideRight = s6;
        currency = s;
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        log.logAsWarning((new StringBuilder()).append("Unrecognized currency code: ").append(s7).toString(), illegalargumentexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int getDefaultFractionDigits()
    {
        if (currency == null)
        {
            return 2;
        } else
        {
            return currency.getDefaultFractionDigits();
        }
    }

    public static EbayCurrency getInstance(String s)
    {
        com/ebay/nautilus/domain/EbayCurrency;
        JVM INSTR monitorenter ;
        s = getInstance(s, null, null, null, null, null, null);
        com/ebay/nautilus/domain/EbayCurrency;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    private static EbayCurrency getInstance(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        com/ebay/nautilus/domain/EbayCurrency;
        JVM INSTR monitorenter ;
        EbayCurrency ebaycurrency;
        String s7;
        s7 = resolveCurrencyCode(s);
        ebaycurrency = (EbayCurrency)instances.get(s7);
        s = ebaycurrency;
        if (ebaycurrency != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s1 = new EbayCurrency(s7, s1, s2, s3, s4, s5, s6);
        instances.put(s7, s1);
        s = s1;
        if (!log.isLoggable)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        log.log((new StringBuilder()).append("Created new currency: ").append(s1).toString());
        s = s1;
        com/ebay/nautilus/domain/EbayCurrency;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    private static String nonbreaking(String s)
    {
        return s.replace(' ', '\240');
    }

    private static String resolveCurrencyCode(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            log.logAsWarning("Empty currency code supplied");
            return "";
        } else
        {
            return s.trim().toUpperCase(Locale.US);
        }
    }

    private static Locale resolveLocale(Locale locale)
    {
        Locale locale1 = locale;
        if (locale == null)
        {
            locale1 = Locale.getDefault();
        }
        return locale1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof EbayCurrency)
        {
            obj = (EbayCurrency)obj;
            return TextUtils.equals(getCurrencyCode(), ((EbayCurrency) (obj)).getCurrencyCode());
        } else
        {
            return super.equals(obj);
        }
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public DecimalFormat getDecimalFormat(Locale locale, boolean flag)
    {
        DecimalFormat decimalformat;
        DecimalFormatSymbols decimalformatsymbols;
        String s;
        locale = resolveLocale(locale);
        decimalformat = (DecimalFormat)NumberFormat.getCurrencyInstance(locale);
        decimalformatsymbols = decimalformat.getDecimalFormatSymbols();
        s = getSymbol(locale, flag);
        if (!"".equals(s)) goto _L2; else goto _L1
_L1:
        locale = GET_DECIMAL_FORMAT_REMOVE_SYMBOL.matcher(decimalformat.toPattern()).replaceAll("");
        decimalformatsymbols.setDecimalSeparator(decimalformatsymbols.getMonetaryDecimalSeparator());
        locale = new DecimalFormat(locale);
_L4:
        decimalformatsymbols.setCurrencySymbol(s);
        locale.setDecimalFormatSymbols(decimalformatsymbols);
        int i = getDefaultFractionDigits();
        locale.setMaximumFractionDigits(i);
        locale.setMinimumFractionDigits(i);
        return locale;
_L2:
        locale = decimalformat;
        if (s.equals(getCurrencyCode()))
        {
            locale = new DecimalFormat(decimalformat.toPattern().replace("\244#", "\244\240#"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public DecimalFormat getDecimalFormat(boolean flag)
    {
        return getDecimalFormat(Locale.getDefault(), flag);
    }

    public String getSymbol()
    {
        return getSymbol(Locale.getDefault(), false);
    }

    public String getSymbol(Locale locale)
    {
        return getSymbol(locale, false);
    }

    public String getSymbol(Locale locale, boolean flag)
    {
        Locale locale1;
label0:
        {
            locale1 = resolveLocale(locale);
            boolean flag1 = isDefaultForLocale(locale1);
            boolean flag2 = isSymbolOnLeft(locale1);
            Object obj;
            if (flag1)
            {
                if (flag && domesticShortSymbolOverrideLeft != null && domesticShortSymbolOverrideRight != null)
                {
                    if (flag2)
                    {
                        locale = domesticShortSymbolOverrideLeft;
                    } else
                    {
                        locale = domesticShortSymbolOverrideRight;
                    }
                } else
                if (flag2)
                {
                    locale = domesticSymbolOverrideLeft;
                } else
                {
                    locale = domesticSymbolOverrideRight;
                }
            } else
            if (flag2)
            {
                locale = internationalSymbolOverrideLeft;
            } else
            {
                locale = internationalSymbolOverrideRight;
            }
            obj = locale;
            if (locale == null)
            {
                if (currency != null)
                {
                    break label0;
                }
                obj = currencyCode;
            }
            return ((String) (obj));
        }
        return currency.getSymbol(locale1);
    }

    public String getSymbol(boolean flag)
    {
        return getSymbol(Locale.getDefault(), flag);
    }

    public int hashCode()
    {
        return getCurrencyCode().hashCode();
    }

    public boolean isDefaultForLocale(Locale locale)
    {
        boolean flag;
        try
        {
            flag = Currency.getInstance(locale).getCurrencyCode().equals(getCurrencyCode());
        }
        // Misplaced declaration of an exception variable
        catch (Locale locale)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Locale locale)
        {
            return false;
        }
        return flag;
    }

    public boolean isInsignificant(double d)
    {
        return d < Math.pow(10D, -getDefaultFractionDigits());
    }

    public boolean isInsignificant(Number number)
    {
        if (number == null)
        {
            return true;
        } else
        {
            return isInsignificant(number.doubleValue());
        }
    }

    public boolean isSymbolOnLeft()
    {
        return isSymbolOnLeft(Locale.getDefault());
    }

    public boolean isSymbolOnLeft(Locale locale)
    {
        boolean flag = false;
        if ('\244' == ((DecimalFormat)NumberFormat.getCurrencyInstance(resolveLocale(locale))).toPattern().charAt(0))
        {
            flag = true;
        }
        return flag;
    }

    public String toString()
    {
        return getCurrencyCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(currencyCode);
    }

    static 
    {
        getInstance("MYR", "RM", "RM", "RM", "RM", null, null);
        getInstance("USD", nonbreaking("US $"), "$US", "$", "$", nonbreaking("US $"), "$US");
        getInstance("AUD", nonbreaking("AU $"), "$AU", nonbreaking("AU $"), "$AU", nonbreaking("AU $"), "$AU");
        getInstance("CAD", nonbreaking("C $"), "$C", nonbreaking("C $"), "$C", null, null);
        getInstance("GBP", "\243", "\243", "\243", "\243", "\243", "\243");
        getInstance("EUR", "\u20AC", "\u20AC", "\u20AC", "\u20AC", "\u20AC", "\u20AC");
        getInstance("PHP", null, null, null, null, "PHP", "PHP");
    }
}
