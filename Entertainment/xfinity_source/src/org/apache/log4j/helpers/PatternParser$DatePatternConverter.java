// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.util.Date;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser, LogLog, FormattingInfo

private static class df extends PatternConverter
{

    private Date date;
    private DateFormat df;

    public String convert(LoggingEvent loggingevent)
    {
        date.setTime(loggingevent.timeStamp);
        try
        {
            loggingevent = df.format(date);
        }
        // Misplaced declaration of an exception variable
        catch (LoggingEvent loggingevent)
        {
            LogLog.error("Error occured while converting date.", loggingevent);
            return null;
        }
        return loggingevent;
    }

    A(FormattingInfo formattinginfo, DateFormat dateformat)
    {
        super(formattinginfo);
        date = new Date();
        df = dateformat;
    }
}
