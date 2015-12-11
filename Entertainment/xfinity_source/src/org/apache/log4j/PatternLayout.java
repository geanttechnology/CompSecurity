// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j:
//            Layout

public class PatternLayout extends Layout
{

    protected final int BUF_SIZE;
    protected final int MAX_CAPACITY;
    private PatternConverter head;
    private String pattern;
    private StringBuffer sbuf;

    public PatternLayout()
    {
        this("%m%n");
    }

    public PatternLayout(String s)
    {
        BUF_SIZE = 256;
        MAX_CAPACITY = 1024;
        sbuf = new StringBuffer(256);
        pattern = s;
        String s1 = s;
        if (s == null)
        {
            s1 = "%m%n";
        }
        head = createPatternParser(s1).parse();
    }

    public void activateOptions()
    {
    }

    protected PatternParser createPatternParser(String s)
    {
        return new PatternParser(s);
    }

    public String format(LoggingEvent loggingevent)
    {
        PatternConverter patternconverter;
        if (sbuf.capacity() > 1024)
        {
            sbuf = new StringBuffer(256);
        } else
        {
            sbuf.setLength(0);
        }
        for (patternconverter = head; patternconverter != null; patternconverter = patternconverter.next)
        {
            patternconverter.format(sbuf, loggingevent);
        }

        return sbuf.toString();
    }

    public boolean ignoresThrowable()
    {
        return true;
    }
}
