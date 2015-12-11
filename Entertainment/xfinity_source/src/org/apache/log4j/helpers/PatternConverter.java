// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            FormattingInfo

public abstract class PatternConverter
{

    static String SPACES[] = {
        " ", "  ", "    ", "        ", "                ", "                                "
    };
    boolean leftAlign;
    int max;
    int min;
    public PatternConverter next;

    protected PatternConverter()
    {
        min = -1;
        max = 0x7fffffff;
        leftAlign = false;
    }

    protected PatternConverter(FormattingInfo formattinginfo)
    {
        min = -1;
        max = 0x7fffffff;
        leftAlign = false;
        min = formattinginfo.min;
        max = formattinginfo.max;
        leftAlign = formattinginfo.leftAlign;
    }

    protected abstract String convert(LoggingEvent loggingevent);

    public void format(StringBuffer stringbuffer, LoggingEvent loggingevent)
    {
        loggingevent = convert(loggingevent);
        if (loggingevent == null)
        {
            if (min > 0)
            {
                spacePad(stringbuffer, min);
            }
            return;
        }
        int i = loggingevent.length();
        if (i > max)
        {
            stringbuffer.append(loggingevent.substring(i - max));
            return;
        }
        if (i < min)
        {
            if (leftAlign)
            {
                stringbuffer.append(loggingevent);
                spacePad(stringbuffer, min - i);
                return;
            } else
            {
                spacePad(stringbuffer, min - i);
                stringbuffer.append(loggingevent);
                return;
            }
        } else
        {
            stringbuffer.append(loggingevent);
            return;
        }
    }

    public void spacePad(StringBuffer stringbuffer, int i)
    {
        for (; i >= 32; i -= 32)
        {
            stringbuffer.append(SPACES[5]);
        }

        for (int j = 4; j >= 0; j--)
        {
            if ((1 << j & i) != 0)
            {
                stringbuffer.append(SPACES[j]);
            }
        }

    }

}
