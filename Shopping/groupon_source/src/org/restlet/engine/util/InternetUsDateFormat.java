// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.restlet.engine.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package org.restlet.engine.util:
//            InternetDateFormat

public class InternetUsDateFormat extends InternetDateFormat
{

    public InternetUsDateFormat()
    {
        DecimalFormatSymbols decimalformatsymbols = new DecimalFormatSymbols(Locale.US);
        df2 = new DecimalFormat("00", decimalformatsymbols);
        df4 = new DecimalFormat("0000", decimalformatsymbols);
        initCalendar(UTC);
    }

    public CharSequence format(CharSequence charsequence, Date date)
    {
        return (new SimpleDateFormat(charsequence.toString(), Locale.US)).format(date);
    }

    public CharSequence format(CharSequence charsequence, Date date, TimeZone timezone)
    {
        charsequence = new SimpleDateFormat(charsequence.toString(), Locale.US);
        charsequence.setTimeZone(timezone);
        return charsequence.format(date);
    }

    public SimpleDateFormat getFormatter(String s)
    {
        return new SimpleDateFormat(s, Locale.US);
    }

    public void initCalendar()
    {
        cal = new GregorianCalendar(Locale.US);
    }

    public void initCalendar(TimeZone timezone)
    {
        cal = new GregorianCalendar(timezone, Locale.US);
    }
}
