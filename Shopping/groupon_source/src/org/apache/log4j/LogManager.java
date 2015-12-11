// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.DefaultRepositorySelector;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.RootLogger;

// Referenced classes of package org.apache.log4j:
//            Hierarchy, Level, Logger

public class LogManager
{

    private static Object guard;
    private static RepositorySelector repositorySelector;

    public static Logger getLogger(String s)
    {
        return repositorySelector.getLoggerRepository().getLogger(s);
    }

    public static LoggerRepository getLoggerRepository()
    {
        return repositorySelector.getLoggerRepository();
    }

    public static Logger getRootLogger()
    {
        return repositorySelector.getLoggerRepository().getRootLogger();
    }

    static 
    {
        String s1;
label0:
        {
            guard = null;
            repositorySelector = new DefaultRepositorySelector(new Hierarchy(new RootLogger(Level.DEBUG)));
            String s = OptionConverter.getSystemProperty("log4j.defaultInitOverride", null);
            if (s == null || "false".equalsIgnoreCase(s))
            {
                s1 = OptionConverter.getSystemProperty("log4j.configuration", null);
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
                if (url == null)
                {
                    break label0;
                }
                LogLog.debug("Using URL [" + url + "] for automatic log4j configuration.");
                OptionConverter.selectAndConfigure(url, s2, getLoggerRepository());
            }
            return;
        }
        LogLog.debug("Could not find resource: [" + s1 + "].");
    }
}
