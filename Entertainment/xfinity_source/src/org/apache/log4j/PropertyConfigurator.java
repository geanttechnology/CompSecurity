// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

// Referenced classes of package org.apache.log4j:
//            DefaultCategoryFactory, Level, Category, Appender, 
//            Layout, NameValue, SortedKeyEnumeration, Logger

public class PropertyConfigurator
    implements Configurator
{

    static Class class$org$apache$log4j$Appender;
    static Class class$org$apache$log4j$Layout;
    static Class class$org$apache$log4j$spi$ErrorHandler;
    static Class class$org$apache$log4j$spi$Filter;
    static Class class$org$apache$log4j$spi$LoggerFactory;
    static Class class$org$apache$log4j$spi$ThrowableRenderer;
    protected LoggerFactory loggerFactory;
    protected Hashtable registry;
    private LoggerRepository repository;

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

    private void parseErrorHandler(ErrorHandler errorhandler, String s, Properties properties, LoggerRepository loggerrepository)
    {
        if (OptionConverter.toBoolean(OptionConverter.findAndSubst(s + "root-ref", properties), false))
        {
            errorhandler.setLogger(loggerrepository.getRootLogger());
        }
        String s1 = OptionConverter.findAndSubst(s + "logger-ref", properties);
        if (s1 != null)
        {
            if (loggerFactory == null)
            {
                loggerrepository = loggerrepository.getLogger(s1);
            } else
            {
                loggerrepository = loggerrepository.getLogger(s1, loggerFactory);
            }
            errorhandler.setLogger(loggerrepository);
        }
        s = OptionConverter.findAndSubst(s + "appender-ref", properties);
        if (s != null)
        {
            s = parseAppender(properties, s);
            if (s != null)
            {
                errorhandler.setBackupAppender(s);
            }
        }
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
        return;
        properties;
        loggerrepository;
        JVM INSTR monitorexit ;
        throw properties;
    }

    public void doConfigure(URL url, LoggerRepository loggerrepository)
    {
        InputStream inputstream;
        InputStream inputstream1;
        InputStream inputstream2;
        Object obj;
        Properties properties;
        properties = new Properties();
        LogLog.debug("Reading configuration from URL " + url);
        obj = null;
        inputstream2 = null;
        inputstream1 = inputstream2;
        inputstream = obj;
        URLConnection urlconnection = url.openConnection();
        inputstream1 = inputstream2;
        inputstream = obj;
        urlconnection.setUseCaches(false);
        inputstream1 = inputstream2;
        inputstream = obj;
        inputstream2 = urlconnection.getInputStream();
        inputstream1 = inputstream2;
        inputstream = inputstream2;
        properties.load(inputstream2);
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                Thread.currentThread().interrupt();
            }
            // Misplaced declaration of an exception variable
            catch (URL url) { }
            // Misplaced declaration of an exception variable
            catch (URL url) { }
        }
        doConfigure(properties, loggerrepository);
        return;
        loggerrepository;
        inputstream = inputstream1;
        if (loggerrepository instanceof InterruptedIOException)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        inputstream = inputstream1;
        if (!(loggerrepository instanceof InterruptedException))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        inputstream = inputstream1;
        Thread.currentThread().interrupt();
        inputstream = inputstream1;
        LogLog.error("Could not read configuration file from URL [" + url + "].", loggerrepository);
        inputstream = inputstream1;
        LogLog.error("Ignoring configuration file [" + url + "].");
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                Thread.currentThread().interrupt();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                return;
            }
            return;
        } else
        {
            break MISSING_BLOCK_LABEL_108;
        }
        url;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (LoggerRepository loggerrepository)
            {
                Thread.currentThread().interrupt();
            }
            // Misplaced declaration of an exception variable
            catch (LoggerRepository loggerrepository) { }
            // Misplaced declaration of an exception variable
            catch (LoggerRepository loggerrepository) { }
        }
        throw url;
    }

    public void doConfigure(Properties properties, LoggerRepository loggerrepository)
    {
        repository = loggerrepository;
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
        s = properties.getProperty("log4j.reset");
        if (s != null && OptionConverter.toBoolean(s, false))
        {
            loggerrepository.resetConfiguration();
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
        String s1;
        Appender appender;
        String s2;
        Object obj = registryGet(s);
        if (obj != null)
        {
            LogLog.debug("Appender \"" + s + "\" was already parsed.");
            return ((Appender) (obj));
        }
        s1 = "log4j.appender." + s;
        s2 = s1 + ".layout";
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
        if (!(appender instanceof OptionHandler)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Properties properties1;
        if (appender.requiresLayout())
        {
            String as[];
            Iterator iterator;
            java.util.Map.Entry entry;
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
        s2 = s1 + ".errorhandler";
        if (OptionConverter.findAndSubst(s2, properties) == null) goto _L4; else goto _L3
_L3:
        if (class$org$apache$log4j$spi$ErrorHandler == null)
        {
            obj1 = _mthclass$("org.apache.log4j.spi.ErrorHandler");
            class$org$apache$log4j$spi$ErrorHandler = ((Class) (obj1));
        } else
        {
            obj1 = class$org$apache$log4j$spi$ErrorHandler;
        }
        obj1 = (ErrorHandler)OptionConverter.instantiateByKey(properties, s2, ((Class) (obj1)), null);
        if (obj1 == null) goto _L4; else goto _L5
_L5:
        appender.setErrorHandler(((ErrorHandler) (obj1)));
        LogLog.debug("Parsing errorhandler options for \"" + s + "\".");
        parseErrorHandler(((ErrorHandler) (obj1)), s2, properties, repository);
        properties1 = new Properties();
        as = new String[3];
        as[0] = s2 + "." + "root-ref";
        as[1] = s2 + "." + "logger-ref";
        as[2] = s2 + "." + "appender-ref";
        iterator = properties.entrySet().iterator();
_L7:
        if (iterator.hasNext())
        {
            entry = (java.util.Map.Entry)iterator.next();
            int i = 0;
            do
            {
                if (i >= as.length || as[i].equals(entry.getKey()))
                {
                    if (i == as.length)
                    {
                        properties1.put(entry.getKey(), entry.getValue());
                    }
                    continue; /* Loop/switch isn't completed */
                }
                i++;
            } while (true);
        }
        PropertySetter.setProperties(obj1, properties1, s2 + ".");
        LogLog.debug("End of errorhandler parsing for \"" + s + "\".");
_L4:
        PropertySetter.setProperties(appender, properties, s1 + ".");
        LogLog.debug("Parsed \"" + s + "\" options.");
_L2:
        parseAppenderFilters(properties, s, appender);
        registryPut(appender);
        return appender;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void parseAppenderFilters(Properties properties, String s, Appender appender)
    {
        String s4 = "log4j.appender." + s + ".filter.";
        int i = s4.length();
        Hashtable hashtable = new Hashtable();
        Enumeration enumeration = properties.keys();
        Object obj = "";
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break;
            }
            String s3 = (String)enumeration.nextElement();
            if (s3.startsWith(s4))
            {
                int j = s3.indexOf('.', i);
                String s1 = s3;
                s = ((String) (obj));
                if (j != -1)
                {
                    s1 = s3.substring(0, j);
                    s = s3.substring(j + 1);
                }
                obj = (Vector)hashtable.get(s1);
                Vector vector = ((Vector) (obj));
                if (obj == null)
                {
                    vector = new Vector();
                    hashtable.put(s1, vector);
                }
                obj = s;
                if (j != -1)
                {
                    vector.add(new NameValue(s, OptionConverter.findAndSubst(s3, properties)));
                    obj = s;
                }
            }
        } while (true);
        SortedKeyEnumeration sortedkeyenumeration = new SortedKeyEnumeration(hashtable);
        do
        {
            if (!sortedkeyenumeration.hasMoreElements())
            {
                break;
            }
            Object obj1 = (String)sortedkeyenumeration.nextElement();
            String s2 = properties.getProperty(((String) (obj1)));
            if (s2 != null)
            {
                LogLog.debug("Filter key: [" + obj1 + "] class: [" + properties.getProperty(((String) (obj1))) + "] props: " + hashtable.get(obj1));
                if (class$org$apache$log4j$spi$Filter == null)
                {
                    s = _mthclass$("org.apache.log4j.spi.Filter");
                    class$org$apache$log4j$spi$Filter = s;
                } else
                {
                    s = class$org$apache$log4j$spi$Filter;
                }
                s = (Filter)OptionConverter.instantiateByClassName(s2, s, null);
                if (s != null)
                {
                    PropertySetter propertysetter = new PropertySetter(s);
                    NameValue namevalue;
                    for (obj1 = ((Vector)hashtable.get(obj1)).elements(); ((Enumeration) (obj1)).hasMoreElements(); propertysetter.setProperty(namevalue.key, namevalue.value))
                    {
                        namevalue = (NameValue)((Enumeration) (obj1)).nextElement();
                    }

                    propertysetter.activate();
                    LogLog.debug("Adding filter of type [" + s.getClass() + "] to appender named [" + appender.getName() + "].");
                    appender.addFilter(s);
                }
            } else
            {
                LogLog.warn("Missing class definition for filter: [" + obj1 + "]");
            }
        } while (true);
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
            break; /* Loop/switch isn't completed */
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
        properties;
        logger;
        JVM INSTR monitorexit ;
        throw properties;
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
        } else
        if (s2.equals("log4j.throwableRenderer") && (loggerrepository instanceof ThrowableRendererSupport))
        {
            Object obj;
            if (class$org$apache$log4j$spi$ThrowableRenderer == null)
            {
                obj = _mthclass$("org.apache.log4j.spi.ThrowableRenderer");
                class$org$apache$log4j$spi$ThrowableRenderer = ((Class) (obj));
            } else
            {
                obj = class$org$apache$log4j$spi$ThrowableRenderer;
            }
            obj = (ThrowableRenderer)OptionConverter.instantiateByKey(properties, "log4j.throwableRenderer", ((Class) (obj)), null);
            if (obj == null)
            {
                LogLog.error("Could not instantiate throwableRenderer.");
            } else
            {
                (new PropertySetter(obj)).setProperties(properties, "log4j.throwableRenderer.");
                ((ThrowableRendererSupport)loggerrepository).setThrowableRenderer(((ThrowableRenderer) (obj)));
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
