// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.logging;

import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggerRepository;

// Referenced classes of package com.comcast.cim.cmasl.utils.logging:
//            Log4JConfigurator

public final class Log4JConfiguratorForTests
    implements Log4JConfigurator
{

    public Log4JConfiguratorForTests()
    {
    }

    public void configureLogging()
    {
        Object obj = Logger.getRootLogger();
        if (((Logger) (obj)).getAllAppenders().hasMoreElements())
        {
            return;
        }
        ConsoleAppender consoleappender = new ConsoleAppender(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - %m%n"), "System.out");
        consoleappender.setName("console");
        ((Logger) (obj)).addAppender(consoleappender);
        ((Logger) (obj)).setLevel(Level.INFO);
        obj = ((Logger) (obj)).getLoggerRepository();
        for (Iterator iterator = CollectionUtils.createList("com.comcast", "com.xfinity").iterator(); iterator.hasNext(); ((LoggerRepository) (obj)).getLogger((String)iterator.next()).setLevel(Level.DEBUG)) { }
        ((LoggerRepository) (obj)).getLogger("com.comcast.cim.httpcomponentsandroid").setLevel(Level.INFO);
    }
}
