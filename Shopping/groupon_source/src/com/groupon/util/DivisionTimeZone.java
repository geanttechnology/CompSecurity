// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.models.division.Division;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil

public class DivisionTimeZone
{

    private String idOrStandardName;
    private Integer serverTimeZoneOffset_s;
    private TimeZone timeZone;
    private String zoneId;

    public DivisionTimeZone(Division division)
    {
        timeZone = null;
        if (division != null)
        {
            idOrStandardName = division.timezone;
            serverTimeZoneOffset_s = Integer.valueOf(division.timezoneOffsetInSeconds);
            if (serverTimeZoneOffset_s.intValue() != 0)
            {
                Object obj = null;
                division = obj;
                if (idOrStandardName != null)
                {
                    String as[] = idOrStandardName.split("\\s+");
                    division = obj;
                    if (as.length > 0)
                    {
                        division = as[0];
                    }
                }
                int i = serverTimeZoneOffset_s.intValue() * 1000;
                timeZone = findTimeZone(i, 0, division);
                if (timeZone == null)
                {
                    timeZone = findTimeZone(i, 0xffc91180, division);
                }
            }
        }
        if (timeZone == null)
        {
            zoneId = "GMT";
            timeZone = TimeZone.getTimeZone(zoneId);
        }
    }

    public static String getDateToDisplay(Date date, Context context)
    {
        if (date == null)
        {
            return null;
        }
        try
        {
            context = (DeviceInfoUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/DeviceInfoUtil);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            date = new StringBuilder();
            date.append(calendar.getDisplayName(2, 2, context.getDeviceLocale())).append(" ");
            date.append(calendar.get(5)).append(", ");
            date.append(calendar.get(1));
            date = date.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            return null;
        }
        return date;
    }

    protected TimeZone findTimeZone(int i, int j, String s)
    {
        int k = i + j;
        String as[] = TimeZone.getAvailableIDs(k);
        int l = as.length;
        for (i = 0; i < l; i++)
        {
            Object obj = as[i];
            if (s != null && !((String) (obj)).contains(s))
            {
                continue;
            }
            obj = TimeZone.getTimeZone(((String) (obj)));
            if (((TimeZone) (obj)).getRawOffset() != k || j != -((TimeZone) (obj)).getDSTSavings())
            {
                continue;
            }
            String s1 = ((TimeZone) (obj)).getDisplayName(((TimeZone) (obj)).inDaylightTime(Calendar.getInstance(((TimeZone) (obj))).getTime()), 0);
            if (!s1.contains("GMT"))
            {
                zoneId = s1;
                return ((TimeZone) (obj));
            }
        }

        return null;
    }

    public Calendar getNow()
    {
        return Calendar.getInstance(timeZone);
    }
}
