// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser, FormattingInfo

private static class type extends PatternConverter
{

    int type;

    public String convert(LoggingEvent loggingevent)
    {
        switch (type)
        {
        default:
            return null;

        case 2000: 
            return Long.toString(loggingevent.timeStamp - LoggingEvent.getStartTime());

        case 2001: 
            return loggingevent.getThreadName();

        case 2002: 
            return loggingevent.getLevel().toString();

        case 2003: 
            return loggingevent.getNDC();

        case 2004: 
            return loggingevent.getRenderedMessage();
        }
    }

    (FormattingInfo formattinginfo, int i)
    {
        super(formattinginfo);
        type = i;
    }
}
