// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser, FormattingInfo

private static class key extends PatternConverter
{

    private String key;

    public String convert(LoggingEvent loggingevent)
    {
        if (key == null)
        {
            StringBuffer stringbuffer = new StringBuffer("{");
            loggingevent = loggingevent.getProperties();
            if (loggingevent.size() > 0)
            {
                Object aobj[] = loggingevent.keySet().toArray();
                Arrays.sort(aobj);
                for (int i = 0; i < aobj.length; i++)
                {
                    stringbuffer.append('{');
                    stringbuffer.append(aobj[i]);
                    stringbuffer.append(',');
                    stringbuffer.append(loggingevent.get(aobj[i]));
                    stringbuffer.append('}');
                }

            }
            stringbuffer.append('}');
            return stringbuffer.toString();
        }
        loggingevent = ((LoggingEvent) (loggingevent.getMDC(key)));
        if (loggingevent == null)
        {
            return null;
        } else
        {
            return loggingevent.toString();
        }
    }

    (FormattingInfo formattinginfo, String s)
    {
        super(formattinginfo);
        key = s;
    }
}
