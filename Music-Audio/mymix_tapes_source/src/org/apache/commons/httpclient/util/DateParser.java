// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package org.apache.commons.httpclient.util:
//            DateParseException

public class DateParser
{

    private static final Collection DEFAULT_PATTERNS = Arrays.asList(new String[] {
        "EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz"
    });
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateParser()
    {
    }

    public static Date parseDate(String s)
        throws DateParseException
    {
        return parseDate(s, null);
    }

    public static Date parseDate(String s, Collection collection)
        throws DateParseException
    {
        Object obj;
        if (s == null)
        {
            throw new IllegalArgumentException("dateValue is null");
        }
        obj = collection;
        if (collection == null)
        {
            obj = DEFAULT_PATTERNS;
        }
        collection = s;
        if (s.length() > 1)
        {
            collection = s;
            if (s.startsWith("'"))
            {
                collection = s;
                if (s.endsWith("'"))
                {
                    collection = s.substring(1, s.length() - 1);
                }
            }
        }
        s = null;
        obj = ((Collection) (obj)).iterator();
_L2:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        Object obj1 = (String)((Iterator) (obj)).next();
        if (s == null)
        {
            s = new SimpleDateFormat(((String) (obj1)), Locale.US);
            s.setTimeZone(TimeZone.getTimeZone("GMT"));
        } else
        {
            s.applyPattern(((String) (obj1)));
        }
        obj1 = s.parse(collection);
        return ((Date) (obj1));
        throw new DateParseException("Unable to parse the date " + collection);
        ParseException parseexception;
        parseexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
