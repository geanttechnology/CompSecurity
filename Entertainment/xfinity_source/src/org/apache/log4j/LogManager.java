// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.DefaultRepositorySelector;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.NOPLoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.RootLogger;

// Referenced classes of package org.apache.log4j:
//            Hierarchy, Level, Logger

public class LogManager
{

    private static Object guard = null;
    private static RepositorySelector repositorySelector;

    public static Logger getLogger(String s)
    {
        return getLoggerRepository().getLogger(s);
    }

    public static LoggerRepository getLoggerRepository()
    {
        if (repositorySelector == null)
        {
            repositorySelector = new DefaultRepositorySelector(new NOPLoggerRepository());
            guard = null;
            IllegalStateException illegalstateexception = new IllegalStateException("Class invariant violation");
            if (isLikelySafeScenario(illegalstateexception))
            {
                LogLog.debug("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalstateexception);
            } else
            {
                LogLog.error("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalstateexception);
            }
        }
        return repositorySelector.getLoggerRepository();
    }

    public static Logger getRootLogger()
    {
        return getLoggerRepository().getRootLogger();
    }

    private static boolean isLikelySafeScenario(Exception exception)
    {
        StringWriter stringwriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1;
    }

    static 
    {
        repositorySelector = new DefaultRepositorySelector(new Hierarchy(new RootLogger(Level.DEBUG)));
        String s = OptionConverter.getSystemProperty("log4j.defaultInitOverride", null);
        if (s == null || "false".equalsIgnoreCase(s))
        {
            String s1 = OptionConverter.getSystemProperty("log4j.configuration", null);
            String s2 = OptionConverter.getSystemProperty("log4j.configuratorClass", null);
            URL url;
            if (s1 == null)
            {
                URL url1 = Loader.getResource("log4j.xml");
                url = url1;
                if (url1 == null)
                {
                    url = Loader.getResource("log4j.properties");
                }
            } else
            {
                try
                {
                    url = new URL(s1);
                }
                catch (MalformedURLException malformedurlexception)
                {
                    malformedurlexception = Loader.getResource(s1);
                }
            }
            if (url != null)
            {
                LogLog.debug("Using URL [" + url + "] for automatic log4j configuration.");
                try
                {
                    OptionConverter.selectAndConfigure(url, s2, getLoggerRepository());
                }
                catch (NoClassDefFoundError noclassdeffounderror)
                {
                    LogLog.warn("Error during default initialization", noclassdeffounderror);
                }
            } else
            {
                LogLog.debug("Could not find resource: [" + s1 + "].");
            }
        } else
        {
            LogLog.debug("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
        }
    }
}
