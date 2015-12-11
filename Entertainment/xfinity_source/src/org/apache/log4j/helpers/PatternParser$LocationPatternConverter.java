// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser, FormattingInfo

private class type extends PatternConverter
{

    private final PatternParser this$0;
    int type;

    public String convert(LoggingEvent loggingevent)
    {
        loggingevent = loggingevent.getLocationInformation();
        switch (type)
        {
        case 1002: 
        default:
            return null;

        case 1000: 
            return ((LocationInfo) (loggingevent)).fullInfo;

        case 1001: 
            return loggingevent.getMethodName();

        case 1003: 
            return loggingevent.getLineNumber();

        case 1004: 
            return loggingevent.getFileName();
        }
    }

    (FormattingInfo formattinginfo, int i)
    {
        super(formattinginfo);
        this$0 = PatternParser.this;
        type = i;
    }
}
