// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.content.Context;
import android.location.Location;
import android.support.v7.aqo;
import android.support.v7.it;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.chat.DateFormatter;
import com.abtnprojects.ambatana.services.b;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            DistanceEntity, ApiProduct, Geo, Product

public class ProductEntity
{

    private static final String DEFAULT_CURRENCY_CODE = "USD";
    private final Context context;
    private final b countryCurrencyDelegate;
    private final DateFormatter dateFormatter = new DateFormatter();
    private final DistanceEntity distanceEntity;
    private final CountryCurrencyInfo info;
    private final List prepositions;

    public ProductEntity(List list, CountryCurrencyInfo countrycurrencyinfo, Context context1, b b1, Location location, String s)
    {
        prepositions = list;
        info = countrycurrencyinfo;
        context = context1;
        countryCurrencyDelegate = b1;
        distanceEntity = new DistanceEntity(location, s);
    }

    private String formatPriceWithCurrency(double d, NumberFormat numberformat, String s)
    {
        numberformat.setCurrency(Currency.getInstance(s));
        s = numberformat.format(d);
        numberformat = s;
        if (s != null)
        {
            numberformat = s;
            if (!s.isEmpty())
            {
                numberformat = s.replaceAll("\\.0{2}\\b", "");
            }
        }
        return numberformat;
    }

    private String formatPriceWithDefaultCurrency(double d, NumberFormat numberformat)
    {
        return formatPriceWithCurrency(d, numberformat, "USD");
    }

    private String getBackUpCurrency(Context context1, String s, double d, NumberFormat numberformat)
    {
        Object obj = null;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s = null;
_L1:
        context1 = obj;
        if (s != null)
        {
            try
            {
                context1 = formatPriceWithCurrency(d, numberformat, s.getCurrencyCode());
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                aqo.b(context1, "getFormattedPriceUsingCurrency", new Object[0]);
                context1 = obj;
            }
        }
        s = context1;
        if (context1 == null)
        {
            s = formatPriceWithDefaultCurrency(d, numberformat);
        }
        return s;
        s = countryCurrencyDelegate.a(s, context1);
          goto _L1
    }

    private static double round(double d, int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            long l = (long)Math.pow(10D, i);
            return (double)Math.round((double)l * d) / (double)l;
        }
    }

    public String getFormattedPriceUsingCurrency(CountryCurrencyInfo countrycurrencyinfo, String s, Context context1, String s1, Double double1)
    {
        Object obj;
        if (double1 == null)
        {
            obj = null;
        } else
        {
            obj = Double.toString(double1.doubleValue());
        }
        if (obj == null)
        {
            return null;
        }
        int i;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((String) (obj)).split("\\.");
        }
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.length;
        }
        if (i > 1)
        {
            obj = obj[1];
            if (((String) (obj)).startsWith("00") || ((String) (obj)).length() == 1 && ((String) (obj)).startsWith("0"))
            {
                i = 0;
            } else
            {
                i = 2;
            }
        } else
        {
            i = 0;
        }
        double1 = Double.valueOf(round(double1.doubleValue(), i));
        if (countrycurrencyinfo == null)
        {
            countrycurrencyinfo = new String[0];
        } else
        {
            countrycurrencyinfo = countrycurrencyinfo.getLocaleString().split("_");
        }
        countrycurrencyinfo.length;
        JVM INSTR tableswitch 0 1: default 136
    //                   0 231
    //                   1 238;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_238;
_L1:
        countrycurrencyinfo = new Locale(countrycurrencyinfo[0], countrycurrencyinfo[1]);
_L4:
        obj = NumberFormat.getCurrencyInstance(countrycurrencyinfo);
        ((NumberFormat) (obj)).setMaximumFractionDigits(i);
        if (s == null)
        {
            countrycurrencyinfo = null;
        } else
        {
            try
            {
                countrycurrencyinfo = formatPriceWithCurrency(double1.doubleValue(), ((NumberFormat) (obj)), s);
            }
            // Misplaced declaration of an exception variable
            catch (CountryCurrencyInfo countrycurrencyinfo)
            {
                aqo.b(countrycurrencyinfo, "getFormattedPriceUsingCurrency", new Object[0]);
                countrycurrencyinfo = null;
            }
        }
        s = countrycurrencyinfo;
        if (countrycurrencyinfo == null)
        {
            s = getBackUpCurrency(context1, s1, double1.doubleValue(), ((NumberFormat) (obj)));
        }
        return s;
_L2:
        countrycurrencyinfo = Locale.getDefault();
          goto _L4
        countrycurrencyinfo = new Locale(countrycurrencyinfo[0]);
          goto _L4
    }

    public Product transform(ApiProduct apiproduct)
    {
        Object obj = null;
        if (apiproduct != null)
        {
            obj = it.a(prepositions, " ", " ", apiproduct.getName());
            String s = it.a(prepositions, "\\.", ".", apiproduct.getDescription());
            Double double1 = apiproduct.getPrice();
            String s1 = apiproduct.getCurrency();
            Geo geo = apiproduct.getGeo();
            String s2 = getFormattedPriceUsingCurrency(info, s1, context, geo.getCountryCode(), double1);
            java.util.Date date = dateFormatter.getFormattedDate(apiproduct.getCreatedAt());
            java.util.Date date1 = dateFormatter.getFormattedDate(apiproduct.getUpdatedAt());
            ArrayList arraylist = new ArrayList();
            if (apiproduct.getImages() != null)
            {
                arraylist.addAll(apiproduct.getImages());
            }
            int i = distanceEntity.getDistanceRange(geo);
            obj = new Product(apiproduct.getId(), ((String) (obj)), apiproduct.getCategoryId(), apiproduct.getLanguageCode(), s, s2, s1, apiproduct.getStatus(), geo, arraylist, apiproduct.getThumb(), date, date1, apiproduct.isReported(), apiproduct.isFavorited(), apiproduct.getOwner(), double1.doubleValue(), i);
        }
        return ((Product) (obj));
    }

    public List transform(List list)
    {
        ArrayList arraylist = new ArrayList();
        if (list == null)
        {
            return null;
        }
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Product product = transform((ApiProduct)list.next());
            if (product != null)
            {
                arraylist.add(product);
            }
        } while (true);
        return arraylist;
    }
}
