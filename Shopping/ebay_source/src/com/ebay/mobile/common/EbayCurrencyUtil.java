// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.cos.base.Amount;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class EbayCurrencyUtil
{

    public static final int FLAG_DISPLAY_COMPACT = 2;
    public static final int FLAG_DISPLAY_CONVERTED = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PREFILL_INPUT = 4;
    public static final double FRACTIONAL_AMOUNT_HARD_LIMIT = 1000000D;
    public static final double FRACTIONAL_AMOUNT_SOFT_LIMIT = 1000D;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(logTag, 5, "eBay currency utility warnings");
    private static final String logTag = com/ebay/nautilus/domain/EbayCurrency.getSimpleName();

    private EbayCurrencyUtil()
    {
    }

    public static String formatDisplay(EbayCurrency ebaycurrency, double d, int i)
    {
        return formatDisplay(ebaycurrency, d, Locale.getDefault(), i);
    }

    public static String formatDisplay(EbayCurrency ebaycurrency, double d, Locale locale, int i)
    {
        boolean flag1 = true;
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 2) == 0)
        {
            flag1 = false;
        }
        ebaycurrency = resolveCurrency(ebaycurrency);
        locale = getDecimalFormatForDisplay(ebaycurrency, locale, i);
        if (d >= 1000000D && flag1 || d >= 1000D && (flag || ebaycurrency.isInsignificant(d % 1.0D)))
        {
            locale.setMaximumFractionDigits(0);
            locale.setMinimumFractionDigits(0);
        }
        return locale.format(d);
    }

    public static String formatDisplay(CurrencyAmount currencyamount, int i)
    {
        return formatDisplay(currencyamount.getCurrencyCode(), currencyamount.getValueAsDouble(), i);
    }

    public static String formatDisplay(ItemCurrency itemcurrency, int i)
    {
        return formatDisplay(itemcurrency, Locale.getDefault(), i);
    }

    public static String formatDisplay(ItemCurrency itemcurrency, Locale locale, int i)
    {
        if (itemcurrency != null)
        {
            Double double1 = parseApiValue(itemcurrency.value);
            itemcurrency = EbayCurrency.getInstance(itemcurrency.code);
            if (double1 != null)
            {
                return formatDisplay(((EbayCurrency) (itemcurrency)), double1.doubleValue(), locale, i);
            }
        }
        return null;
    }

    public static String formatDisplay(Amount amount, boolean flag, Locale locale, int i)
    {
        if (amount != null)
        {
            Double double1 = Double.valueOf(amount.getValue(flag));
            amount = EbayCurrency.getInstance(amount.getCurrency(flag));
            if (double1 != null)
            {
                return formatDisplay(((EbayCurrency) (amount)), double1.doubleValue(), locale, i);
            }
        }
        return null;
    }

    public static String formatDisplay(String s, double d, int i)
    {
        return formatDisplay(EbayCurrency.getInstance(s), d, i);
    }

    public static String formatUserInput(EbayCurrency ebaycurrency, Number number, int i)
    {
        boolean flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (number == null)
        {
            return "";
        } else
        {
            return getDecimalFormatForUserInput(ebaycurrency, flag).format(number.doubleValue());
        }
    }

    public static String formatUserInput(String s, Number number, int i)
    {
        boolean flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (number == null)
        {
            return "";
        } else
        {
            return getDecimalFormatForUserInput(s, flag).format(number.doubleValue());
        }
    }

    public static DecimalFormat getDecimalFormatForDisplay(EbayCurrency ebaycurrency, int i)
    {
        return getDecimalFormatForDisplay(ebaycurrency, Locale.getDefault(), i);
    }

    public static DecimalFormat getDecimalFormatForDisplay(EbayCurrency ebaycurrency, Locale locale, int i)
    {
        boolean flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return resolveCurrency(ebaycurrency).getDecimalFormat(locale, flag);
    }

    public static DecimalFormat getDecimalFormatForDisplay(String s, int i)
    {
        boolean flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return EbayCurrency.getInstance(s).getDecimalFormat(flag);
    }

    public static DecimalFormat getDecimalFormatForUserInput(EbayCurrency ebaycurrency, boolean flag)
    {
        ebaycurrency = resolveCurrency(ebaycurrency).getDecimalFormat(false);
        DecimalFormatSymbols decimalformatsymbols = ebaycurrency.getDecimalFormatSymbols();
        decimalformatsymbols.setDecimalSeparator(decimalformatsymbols.getMonetaryDecimalSeparator());
        int i = ebaycurrency.getMaximumFractionDigits();
        if (flag)
        {
            ebaycurrency = "0.0000";
        } else
        {
            ebaycurrency = "#.####";
        }
        if (i == 0)
        {
            ebaycurrency = "#";
        } else
        {
            ebaycurrency = ebaycurrency.substring(0, i + 2);
        }
        return new DecimalFormat(ebaycurrency, decimalformatsymbols);
    }

    public static DecimalFormat getDecimalFormatForUserInput(String s, boolean flag)
    {
        return getDecimalFormatForUserInput(EbayCurrency.getInstance(s), flag);
    }

    public static Double parseApiValue(String s)
    {
        try
        {
            s = Double.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Double parseUserInput(EbayCurrency ebaycurrency, String s)
    {
        double d;
        try
        {
            d = getDecimalFormatForUserInput(ebaycurrency, false).parse(s.trim()).doubleValue();
        }
        // Misplaced declaration of an exception variable
        catch (EbayCurrency ebaycurrency)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (EbayCurrency ebaycurrency)
        {
            return null;
        }
        return Double.valueOf(d);
    }

    public static Double parseUserInput(String s, String s1)
    {
        return parseUserInput(EbayCurrency.getInstance(s), s1);
    }

    private static EbayCurrency resolveCurrency(EbayCurrency ebaycurrency)
    {
        EbayCurrency ebaycurrency1 = ebaycurrency;
        if (ebaycurrency == null)
        {
            log.logAsWarning("Empty currency supplied");
            ebaycurrency1 = EbayCurrency.getInstance(null);
        }
        return ebaycurrency1;
    }

}
