// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            DateParseException

public final class DateUtils
{

    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateUtils()
    {
    }

    public static String formatDate(Date date)
    {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date);
    }

    public static String formatDate(Date date, String s)
    {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date, s);
    }

    public static Date parseDate(String s)
        throws DateParseException
    {
        return parseDate(s, null, null);
    }

    public static Date parseDate(String s, String as[])
        throws DateParseException
    {
        return parseDate(s, as, null);
    }

    public static Date parseDate(String s, String as[], Date date)
        throws DateParseException
    {
        as = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(s, as, date);
        if (as == null)
        {
            throw new DateParseException((new StringBuilder()).append("Unable to parse the date ").append(s).toString());
        } else
        {
            return as;
        }
    }

}
