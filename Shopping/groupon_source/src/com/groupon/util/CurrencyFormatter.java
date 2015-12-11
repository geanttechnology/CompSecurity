// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.Price;
import com.groupon.models.GenericAmount;
import com.groupon.models.GenericAmountContainer;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            CountryUtil, Currency

public class CurrencyFormatter extends Format
{
    public static final class DecimalStripBehavior extends Enum
    {

        private static final DecimalStripBehavior $VALUES[];
        public static final DecimalStripBehavior Always;
        public static final DecimalStripBehavior Never;
        public static final DecimalStripBehavior OnlyIfZero;

        public static DecimalStripBehavior valueOf(String s)
        {
            return (DecimalStripBehavior)Enum.valueOf(com/groupon/util/CurrencyFormatter$DecimalStripBehavior, s);
        }

        public static DecimalStripBehavior[] values()
        {
            return (DecimalStripBehavior[])$VALUES.clone();
        }

        static 
        {
            Never = new DecimalStripBehavior("Never", 0);
            OnlyIfZero = new DecimalStripBehavior("OnlyIfZero", 1);
            Always = new DecimalStripBehavior("Always", 2);
            $VALUES = (new DecimalStripBehavior[] {
                Never, OnlyIfZero, Always
            });
        }

        private DecimalStripBehavior(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String US_DOLLAR_CURRENCY_CODE = "USD";
    public static final String US_DOLLAR_SIGN = "$";
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private StaticSupportInfoService staticSupportInfoService;

    public CurrencyFormatter()
    {
    }

    protected StringBuffer doFormat(double d, int i, String s, DecimalStripBehavior decimalstripbehavior)
    {
        return doFormat(d, i, s, decimalstripbehavior, null);
    }

    protected StringBuffer doFormat(double d, int i, String s, DecimalStripBehavior decimalstripbehavior, RoundingMode roundingmode)
    {
        double d1;
        double d2;
        String s1;
        s1 = "%,.2f";
        d1 = ((double)i * d) / 100D;
        d2 = d1 - Math.floor(d1);
        d = d1;
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[];

            static 
            {
                $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior = new int[DecimalStripBehavior.values().length];
                try
                {
                    $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[DecimalStripBehavior.OnlyIfZero.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[DecimalStripBehavior.Always.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[DecimalStripBehavior.Never.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.util.CurrencyFormatter.DecimalStripBehavior[decimalstripbehavior.ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 187
    //                   2 207;
           goto _L1 _L2 _L3
_L1:
        DecimalFormat decimalformat;
        decimalformat = (DecimalFormat)DecimalFormat.getCurrencyInstance();
        decimalformat.setDecimalFormatSymbols(getDecimalFormatSymbols());
        _cls1..SwitchMap.com.groupon.util.CurrencyFormatter.DecimalStripBehavior[decimalstripbehavior.ordinal()];
        JVM INSTR tableswitch 1 2: default 308
    //                   1 220
    //                   2 282;
           goto _L4 _L5 _L6
_L4:
        decimalformat.setMinimumFractionDigits(2);
_L13:
        if (roundingmode == null) goto _L8; else goto _L7
_L7:
        decimalformat.setRoundingMode(roundingmode);
_L8:
        if (!staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).currencySettings.prefixNegativeSymbol) goto _L10; else goto _L9
_L9:
        decimalformat.setNegativePrefix("-");
        decimalformat.setNegativeSuffix("");
_L14:
        decimalformat.setPositiveSuffix("");
        decimalstripbehavior = finishFormatting(decimalformat.format(d), s);
        return decimalstripbehavior;
_L2:
        if (d2 <= 0.0D)
        {
            d = d1 - d2;
            s1 = "%.0f";
        }
          goto _L1
_L3:
        d = d1 - d2;
        s1 = "%.0f";
          goto _L1
_L5:
        if (d2 > 0.0D) goto _L12; else goto _L11
_L11:
        try
        {
            decimalformat.setMaximumFractionDigits(0);
        }
        // Misplaced declaration of an exception variable
        catch (DecimalStripBehavior decimalstripbehavior)
        {
            Ln.e(decimalstripbehavior, "CURRENCY: Could not load decimal pattern for given locale. Using default decimal pattern.", new Object[0]);
            return finishFormatting(String.format(s1, new Object[] {
                Double.valueOf(d)
            }), s);
        }
          goto _L13
_L12:
        decimalformat.setMinimumFractionDigits(2);
          goto _L13
_L6:
        decimalformat.setMaximumFractionDigits(0);
          goto _L13
_L10:
        decimalformat.setNegativePrefix("(");
        decimalformat.setNegativeSuffix(")");
          goto _L14
    }

    protected StringBuffer doFormat(Price price, int i, boolean flag, DecimalStripBehavior decimalstripbehavior)
    {
        double d = price.amount;
        if (flag)
        {
            price = getCurrencySymbol(price);
        } else
        {
            price = null;
        }
        return doFormat(d, i, ((String) (price)), decimalstripbehavior);
    }

    protected StringBuffer doFormat(GenericAmountContainer genericamountcontainer, int i, boolean flag, DecimalStripBehavior decimalstripbehavior)
    {
        double d = genericamountcontainer.getAmount();
        if (flag)
        {
            genericamountcontainer = getCurrencySymbol(genericamountcontainer);
        } else
        {
            genericamountcontainer = null;
        }
        return doFormat(d, i, ((String) (genericamountcontainer)), decimalstripbehavior);
    }

    protected StringBuffer finishFormatting(String s, String s1)
    {
        String s2 = s;
        if (Strings.notEmpty(s1))
        {
            try
            {
                s2 = getFormattedAsCurrency(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s2 = s;
            }
        }
        return new StringBuffer(s2);
    }

    public String format(double d, String s, DecimalStripBehavior decimalstripbehavior)
    {
        return doFormat(d, 1, s, decimalstripbehavior).toString();
    }

    public String format(double d, String s, DecimalStripBehavior decimalstripbehavior, RoundingMode roundingmode)
    {
        return doFormat(d, 1, s, decimalstripbehavior, roundingmode).toString();
    }

    public String format(Price price, boolean flag, DecimalStripBehavior decimalstripbehavior)
    {
        return doFormat(price, 1, flag, decimalstripbehavior).toString();
    }

    public String format(GenericAmountContainer genericamountcontainer, boolean flag, DecimalStripBehavior decimalstripbehavior)
    {
        return doFormat(genericamountcontainer, 1, flag, decimalstripbehavior).toString();
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (obj instanceof Price)
        {
            return doFormat((Price)obj, 1, true, DecimalStripBehavior.OnlyIfZero);
        }
        if (obj instanceof GenericAmountContainer)
        {
            return doFormat((GenericAmountContainer)obj, 1, true, DecimalStripBehavior.OnlyIfZero);
        } else
        {
            return null;
        }
    }

    public String formatWithQuantity(double d, String s, int i, DecimalStripBehavior decimalstripbehavior)
    {
        try
        {
            s = doFormat(d, i, getCurrencySymbol(s), decimalstripbehavior).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public String formatWithQuantity(Price price, int i)
    {
        if (price == null)
        {
            return "";
        } else
        {
            return countryUtil.addLeftToRightMarkForRTLLanguages(formatWithQuantity(price, i, true, DecimalStripBehavior.OnlyIfZero));
        }
    }

    public String formatWithQuantity(Price price, int i, boolean flag, DecimalStripBehavior decimalstripbehavior)
    {
        if (price == null)
        {
            return "";
        } else
        {
            return doFormat(price, i, flag, decimalstripbehavior).toString();
        }
    }

    public String getCurrencySymbol(Price price)
    {
        return getCurrencySymbol(price.currencyCode);
    }

    public String getCurrencySymbol(GenericAmountContainer genericamountcontainer)
    {
        return getCurrencySymbol(genericamountcontainer.getCurrencyCode());
    }

    public String getCurrencySymbol(String s)
    {
        s = Currency.findCurrencyBy(s);
        if (s == null)
        {
            s = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry());
            if (s != null)
            {
                return ((StaticSupportInfo) (s)).currencySettings.currencySymbol;
            } else
            {
                return "$";
            }
        } else
        {
            return ((Currency) (s)).symbol;
        }
    }

    protected DecimalFormatSymbols getDecimalFormatSymbols()
        throws IOException
    {
        StaticSupportInfo staticsupportinfo = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry());
        DecimalFormatSymbols decimalformatsymbols = new DecimalFormatSymbols();
        char c = staticsupportinfo.currencySettings.decimalSeparator.charAt(0);
        char c1 = staticsupportinfo.currencySettings.groupingSeparator.charAt(0);
        decimalformatsymbols.setDecimalSeparator(c);
        decimalformatsymbols.setGroupingSeparator(c1);
        decimalformatsymbols.setCurrencySymbol("");
        decimalformatsymbols.setMonetaryDecimalSeparator(c);
        return decimalformatsymbols;
    }

    protected String getFormattedAsCurrency(String s, String s1)
        throws IOException
    {
        Object obj = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry());
        String s2;
        boolean flag;
        boolean flag1;
        if (obj != null)
        {
            flag = ((StaticSupportInfo) (obj)).currencySettings.isCurrencyFirst;
        } else
        {
            flag = true;
        }
        if (obj != null)
        {
            flag1 = ((StaticSupportInfo) (obj)).currencySettings.isCurrencyFromAmountSeparated;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            if (s.startsWith("-"))
            {
                obj = (new StringBuilder()).append("-").append(s1).toString();
            } else
            {
                obj = s1;
            }
        } else
        {
            obj = s;
        }
        if (flag1)
        {
            s2 = " ";
        } else
        {
            s2 = "";
        }
        if (flag)
        {
            s1 = s;
            if (s.startsWith("-"))
            {
                s1 = s.substring(1);
            }
        }
        return String.format("%s%s%s", new Object[] {
            obj, s2, s1
        });
    }

    public boolean isUSDCurrency(Price price)
    {
        return Strings.equalsIgnoreCase(price.currencyCode, "USD");
    }

    public boolean isUSDCurrency(GenericAmount genericamount)
    {
        return genericamount != null && genericamount.getCurrencyCode() != null && Strings.equalsIgnoreCase(genericamount.getCurrencyCode(), "USD");
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new UnsupportedOperationException();
    }
}
