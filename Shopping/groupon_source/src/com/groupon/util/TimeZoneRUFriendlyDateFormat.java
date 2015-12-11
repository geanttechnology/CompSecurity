// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Referenced classes of package com.groupon.util:
//            TimeZoneIntlDateFormat

public class TimeZoneRUFriendlyDateFormat extends TimeZoneIntlDateFormat
{

    private static final String USER_FRIENDLY_RU_DATE_FORMAT = "dd MMMM yyyy";

    public TimeZoneRUFriendlyDateFormat()
    {
    }

    protected DateFormat getLocalInstance()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd MMMM yyyy");
        if (timeZone != null)
        {
            simpledateformat.setTimeZone(timeZone);
        }
        return simpledateformat;
    }
}
