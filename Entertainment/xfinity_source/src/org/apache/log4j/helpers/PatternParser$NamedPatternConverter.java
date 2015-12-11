// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser, FormattingInfo

private static abstract class precision extends PatternConverter
{

    int precision;

    public String convert(LoggingEvent loggingevent)
    {
        loggingevent = getFullyQualifiedName(loggingevent);
        if (precision > 0) goto _L2; else goto _L1
_L1:
        return loggingevent;
_L2:
        int j;
        int k;
        k = loggingevent.length();
        j = k - 1;
        int i = precision;
label0:
        do
        {
label1:
            {
                if (i <= 0)
                {
                    break label1;
                }
                j = loggingevent.lastIndexOf('.', j - 1);
                if (j == -1)
                {
                    break label0;
                }
                i--;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return loggingevent.substring(j + 1, k);
    }

    abstract String getFullyQualifiedName(LoggingEvent loggingevent);

    (FormattingInfo formattinginfo, int i)
    {
        super(formattinginfo);
        precision = i;
    }
}
