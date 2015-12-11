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
import java.text.SimpleDateFormat;
import java.util.Locale;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            TimeZoneIntlDateFormat

public class TimeZoneIntlDateTimeFormat extends TimeZoneIntlDateFormat
{

    private static String INTL_DATE_FORMAT = "dd/MM/yyyy HH:mm";
    private static String JAPAN_DATE_FORMAT = "yyyy\u5E74MM\u6708dd\u65E5 HH\u6642\u9593mm\u5206";
    private Context context;

    public TimeZoneIntlDateTimeFormat()
    {
    }

    protected DateFormat getLocalInstance()
    {
        Object obj = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry());
        if (obj != null)
        {
            if (Strings.equals(context.getResources().getConfiguration().locale, Locale.JAPAN))
            {
                obj = JAPAN_DATE_FORMAT;
            } else
            {
                obj = (new StringBuilder()).append(((StaticSupportInfo) (obj)).dateFormat).append(" ").append(((StaticSupportInfo) (obj)).timeFormat).toString();
            }
            return new SimpleDateFormat(((String) (obj)));
        } else
        {
            Ln.e((new StringBuilder()).append("Could not load support info when trying to find appropriate date format. Defaulting international date format: ").append(INTL_DATE_FORMAT).toString(), new Object[0]);
            return new SimpleDateFormat(INTL_DATE_FORMAT);
        }
    }

}
