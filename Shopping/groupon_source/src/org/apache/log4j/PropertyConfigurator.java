// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.RendererSupport;

// Referenced classes of package org.apache.log4j:
//            DefaultCategoryFactory, Level, Category, Appender, 
//            Layout, Logger

public class PropertyConfigurator
    implements Configurator
{

    static Class class$org$apache$log4j$Appender;
    static Class class$org$apache$log4j$Layout;
    static Class class$org$apache$log4j$spi$LoggerFactory;
    protected LoggerFactory loggerFactory;
    protected Hashtable registry;

    public PropertyConfigurator()
    {
        registry = new Hashtable(11);
        loggerFactory = new DefaultCategoryFactory();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    protected void configureLoggerFactory(Properties properties)
    {
        String s = OptionConverter.findAndSubst("log4j.loggerFactory", properties);
        if (s != null)
        {
            LogLog.debug("Setting category factory to [" + s + "].");
            Class class1;
            if (class$org$apache$log4j$spi$LoggerFactory == null)
            {
                class1 = _mthclass$("org.apache.log4j.spi.LoggerFactory");
                class$org$apache$log4j$spi$LoggerFactory = class1;
            } else
            {
                class1 = class$org$apache$log4j$spi$LoggerFactory;
            }
            loggerFactory = (LoggerFactory)OptionConverter.instantiateByClassName(s, class1, loggerFactory);
            PropertySetter.setProperties(loggerFactory, properties, "log4j.factory.");
        }
    }

    void configureRootCategory(Properties properties, LoggerRepository loggerrepository)
    {
        String s1 = "log4j.rootLogger";
        String s2 = OptionConverter.findAndSubst("log4j.rootLogger", properties);
        String s = s2;
        if (s2 == null)
        {
            s = OptionConverter.findAndSubst("log4j.rootCategory", properties);
            s1 = "log4j.rootCategory";
        }
        if (s == null)
        {
            LogLog.debug("Could not find root logger information. Is this OK?");
            return;
        }
        synchronized (loggerrepository.getRootLogger())
        {
            parseCategory(properties, loggerrepository, s1, "root", s);
        }
    }

    public void doConfigure(URL url, LoggerRepository loggerrepository)
    {
        Properties properties = new Properties();
        LogLog.debug("Reading configuration from URL " + url);
        try
        {
            properties.load(url.openStream());
        }
        // Misplaced declaration of an exception variable
        catch (LoggerRepository loggerrepository)
        {
            LogLog.error("Could not read configuration file from URL [" + url + "].", loggerrepository);
            LogLog.error("Ignoring configuration file [" + url + "].");
            return;
        }
        doConfigure(properties, loggerrepository);
    }

    public void doConfigure(Properties properties, LoggerRepository loggerrepository)
    {
        String s1 = properties.getProperty("log4j.debug");
        String s = s1;
        if (s1 == null)
        {
            String s2 = properties.getProperty("log4j.configDebug");
            s = s2;
            if (s2 != null)
            {
                LogLog.warn("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
                s = s2;
            }
        }
        if (s != null)
        {
            LogLog.setInternalDebugging(OptionConverter.toBoolean(s, true));
        }
        s = OptionConverter.findAndSubst("log4j.threshold", properties);
        if (s != null)
        {
            loggerrepository.setThreshold(OptionConverter.toLevel(s, Level.ALL));
            LogLog.debug("Hierarchy threshold set to [" + loggerrepository.getThreshold() + "].");
        }
        configureRootCategory(properties, loggerrepository);
        configureLoggerFactory(properties);
        parseCatsAndRenderers(properties, loggerrepository);
        LogLog.debug("Finished configuring.");
        registry.clear();
    }

    void parseAdditivityForLogger(Properties properties, Logger logger, String s)
    {
        properties = OptionConverter.findAndSubst("log4j.additivity." + s, properties);
        LogLog.debug("Handling log4j.additivity." + s + "=[" + properties + "]");
        if (properties != null && !properties.equals(""))
        {
            boolean flag = OptionConverter.toBoolean(properties, true);
            LogLog.debug("Setting additivity for \"" + s + "\" to " + flag);
            logger.setAdditivity(flag);
        }
    }

    Appender parseAppender(Properties properties, String s)
    {
        Object obj = registryGet(s);
        if (obj != null)
        {
            LogLog.debug("Appender \"" + s + "\" was already parsed.");
            return ((Appender) (obj));
        }
        String s1 = "log4j.appender." + s;
        String s2 = s1 + ".layout";
        Appender appender;
        if (class$org$apache$log4j$Appender == null)
        {
            obj = _mthclass$("org.apache.log4j.Appender");
            class$org$apache$log4j$Appender = ((Class) (obj));
        } else
        {
            obj = class$org$apache$log4j$Appender;
        }
        appender = (Appender)OptionConverter.instantiateByKey(properties, s1, ((Class) (obj)), null);
        if (appender == null)
        {
            LogLog.error("Could not instantiate appender named \"" + s + "\".");
            return null;
        }
        appender.setName(s);
        if (appender instanceof OptionHandler)
        {
            if (appender.requiresLayout())
            {
                Object obj1;
                if (class$org$apache$log4j$Layout == null)
                {
                    obj1 = _mthclass$("org.apache.log4j.Layout");
                    class$org$apache$log4j$Layout = ((Class) (obj1));
                } else
                {
                    obj1 = class$org$apache$log4j$Layout;
                }
                obj1 = (Layout)OptionConverter.instantiateByKey(properties, s2, ((Class) (obj1)), null);
                if (obj1 != null)
                {
                    appender.setLayout(((Layout) (obj1)));
                    LogLog.debug("Parsing layout options for \"" + s + "\".");
                    PropertySetter.setProperties(obj1, properties, s2 + ".");
                    LogLog.debug("End of parsing for \"" + s + "\".");
                }
            }
            PropertySetter.setProperties(appender, properties, s1 + ".");
            LogLog.debug("Parsed \"" + s + "\" options.");
        }
        registryPut(appender);
        return appender;
    }

    void parseCategory(Properties properties, Logger logger, String s, String s1, String s2)
    {
        LogLog.debug("Parsing for [" + s1 + "] with value=[" + s2 + "].");
        s = new StringTokenizer(s2, ",");
        if (s2.startsWith(",") || s2.equals("")) goto _L2; else goto _L1
_L1:
        if (s.hasMoreTokens()) goto _L4; else goto _L3
_L3:
        return;
_L4:
        s2 = s.nextToken();
        LogLog.debug("Level token is [" + s2 + "].");
        if ("inherited".equalsIgnoreCase(s2) || "null".equalsIgnoreCase(s2))
        {
            if (s1.equals("root"))
            {
                LogLog.warn("The root logger cannot be set to null.");
            } else
            {
                logger.setLevel(null);
            }
        } else
        {
            logger.setLevel(OptionConverter.toLevel(s2, Level.DEBUG));
        }
        LogLog.debug("Category " + s1 + " set to " + logger.getLevel());
_L2:
        logger.removeAllAppenders();
        while (s.hasMoreTokens()) 
        {
            s1 = s.nextToken().trim();
            if (s1 != null && !s1.equals(","))
            {
                LogLog.debug("Parsing appender named \"" + s1 + "\".");
                s1 = parseAppender(properties, s1);
                if (s1 != null)
                {
                    logger.addAppender(s1);
                }
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    protected void parseCatsAndRenderers(Properties properties, LoggerRepository loggerrepository)
    {
        Enumeration enumeration = properties.propertyNames();
_L7:
        String s2;
        if (!enumeration.hasMoreElements())
        {
            return;
        }
        s2 = (String)enumeration.nextElement();
        if (!s2.startsWith("log4j.category.") && !s2.startsWith("log4j.logger.")) goto _L2; else goto _L1
_L1:
        String s = null;
        if (!s2.startsWith("log4j.category.")) goto _L4; else goto _L3
_L3:
        s = s2.substring("log4j.category.".length());
_L5:
        String s3 = OptionConverter.findAndSubst(s2, properties);
        synchronized (loggerrepository.getLogger(s, loggerFactory))
        {
            parseCategory(properties, logger, s2, s, s3);
            parseAdditivityForLogger(properties, logger, s);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s2.startsWith("log4j.logger."))
        {
            s = s2.substring("log4j.logger.".length());
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (s2.startsWith("log4j.renderer."))
        {
            String s1 = s2.substring("log4j.renderer.".length());
            s2 = OptionConverter.findAndSubst(s2, properties);
            if (loggerrepository instanceof RendererSupport)
            {
                RendererMap.addRenderer((RendererSupport)loggerrepository, s1, s2);
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    Appender registryGet(String s)
    {
        return (Appender)registry.get(s);
    }

    void registryPut(Appender appender)
    {
        registry.put(appender.getName(), appender);
    }
}
