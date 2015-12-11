// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class IntlDateFormat extends DateFormat
{

    private static final String INTL_DATE_FORMAT = "dd/MM/yyyy";
    private static final String JAPAN_DATE_FORMAT = "yyyy\u5E74MM\u6708dd\u65E5, EEEE";
    private Context context;
    protected CurrentCountryManager currentCountryManager;
    protected StaticSupportInfoService staticSupportInfoService;

    public IntlDateFormat()
    {
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return getLocalInstance().format(date, stringbuffer, fieldposition);
    }

    protected DateFormat getLocalInstance()
    {
        Object obj = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry());
        if (obj != null)
        {
            if (Strings.equals(context.getResources().getConfiguration().locale, Locale.JAPAN))
            {
                obj = "yyyy\u5E74MM\u6708dd\u65E5, EEEE";
            } else
            {
                obj = ((StaticSupportInfo) (obj)).dateFormat;
            }
            return new SimpleDateFormat(((String) (obj)));
        } else
        {
            Ln.e("Could not load support info when trying to find appropriate date format. Defaulting international date format: dd/MM/yyyy", new Object[0]);
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    }

    public Date parse(String s)
        throws ParseException
    {
        return getLocalInstance().parse(s);
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return getLocalInstance().parse(s, parseposition);
    }
}
