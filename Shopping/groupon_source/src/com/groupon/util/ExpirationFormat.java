// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.groupon.util:
//            TimeZoneUSRedeemedAtFormat, TimeZoneIntlDateTimeFormat, TimeZoneUSFriendlyDateFormat, TimeZoneRUFriendlyDateFormat, 
//            TimeZoneIntlDateFormat

public class ExpirationFormat
{

    private String DEFAULT_NULL_OFFSET_VALUE;
    private String EXPIRES;
    private boolean displayRUFriendlyDateFormat;
    private boolean displayTime;
    private boolean displayUSFriendlyDateFormat;
    private boolean displayUSRedeemedAtFormat;
    private TimeZoneIntlDateFormat timeZoneIntlDateFormat;
    private TimeZoneIntlDateTimeFormat timeZoneIntlDateTimeFormat;
    private TimeZoneRUFriendlyDateFormat timeZoneRUFriendlyDateFormat;
    private TimeZoneUSFriendlyDateFormat timeZoneUSFriendlyDateFormat;
    private TimeZoneUSRedeemedAtFormat timeZoneUSRedeemedAtFormat;

    public ExpirationFormat()
    {
    }

    private void init(Context context)
    {
        DEFAULT_NULL_OFFSET_VALUE = context.getString(0x7f0804d7);
        EXPIRES = context.getString(0x7f0801ae);
    }

    public String format(Date date, String s, Integer integer)
    {
        return format(date, s, integer, DEFAULT_NULL_OFFSET_VALUE, EXPIRES);
    }

    public String format(Date date, String s, Integer integer, String s1)
    {
        return format(date, s, integer, DEFAULT_NULL_OFFSET_VALUE, s1);
    }

    public String format(Date date, String s, Integer integer, String s1, String s2)
    {
        if (date == null)
        {
            return s1;
        }
        if (s != null)
        {
            setTimeZoneByIdentifier(s);
        } else
        if (integer != null)
        {
            s = TimeZone.getAvailableIDs(integer.intValue() * 1000);
            if (s.length > 0)
            {
                setTimeZoneByIdentifier(s[0]);
            }
        }
        if (displayTime)
        {
            if (displayUSRedeemedAtFormat)
            {
                date = timeZoneUSRedeemedAtFormat.format(date);
            } else
            {
                date = timeZoneIntlDateTimeFormat.format(date);
            }
        } else
        if (displayUSFriendlyDateFormat)
        {
            date = timeZoneUSFriendlyDateFormat.format(date);
        } else
        if (displayRUFriendlyDateFormat)
        {
            date = timeZoneRUFriendlyDateFormat.format(date);
        } else
        {
            date = timeZoneIntlDateFormat.format(date);
        }
        if (s2 != null)
        {
            date = String.format(s2, new Object[] {
                date
            });
        }
        return date;
    }

    protected void setTimeZoneByIdentifier(String s)
    {
        if (displayTime)
        {
            if (displayUSRedeemedAtFormat)
            {
                timeZoneUSRedeemedAtFormat.setTimeZoneByIdentifier(s);
                return;
            } else
            {
                timeZoneIntlDateTimeFormat.setTimeZoneByIdentifier(s);
                return;
            }
        }
        if (displayUSFriendlyDateFormat)
        {
            timeZoneUSFriendlyDateFormat.setTimeZoneByIdentifier(s);
            return;
        } else
        {
            timeZoneIntlDateFormat.setTimeZoneByIdentifier(s);
            return;
        }
    }

    public void shouldDisplayRUFriendlyDateFormat(boolean flag)
    {
        displayRUFriendlyDateFormat = flag;
    }

    public void shouldDisplayTime(boolean flag)
    {
        displayTime = flag;
    }

    public void shouldDisplayUSFriendlyDateFormat(boolean flag)
    {
        displayUSFriendlyDateFormat = flag;
    }

    public void shouldDisplayUSRedeemedAtDataFormat(boolean flag)
    {
        displayUSRedeemedAtFormat = flag;
    }
}
