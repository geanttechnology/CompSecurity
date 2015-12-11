// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternConverter, PatternParser

private static class literal extends PatternConverter
{

    private String literal;

    public String convert(LoggingEvent loggingevent)
    {
        return literal;
    }

    public final void format(StringBuffer stringbuffer, LoggingEvent loggingevent)
    {
        stringbuffer.append(literal);
    }

    (String s)
    {
        literal = s;
    }
}
