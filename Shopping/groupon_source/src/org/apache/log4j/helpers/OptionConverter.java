// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;

// Referenced classes of package org.apache.log4j.helpers:
//            LogLog, Loader

public class OptionConverter
{

    static String DELIM_START = "${";
    static int DELIM_START_LEN = 2;
    static char DELIM_STOP = '}';
    static int DELIM_STOP_LEN = 1;
    static Class class$java$lang$String;
    static Class class$org$apache$log4j$Level;
    static Class class$org$apache$log4j$spi$Configurator;

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

    public static String findAndSubst(String s, Properties properties)
    {
        s = properties.getProperty(s);
        if (s == null)
        {
            return null;
        }
        try
        {
            properties = substVars(s, properties);
        }
        // Misplaced declaration of an exception variable
        catch (Properties properties)
        {
            LogLog.error("Bad option value [" + s + "].", properties);
            return s;
        }
        return properties;
    }

    public static String getSystemProperty(String s, String s1)
    {
        String s2;
        try
        {
            s2 = System.getProperty(s, s1);
        }
        catch (Throwable throwable)
        {
            LogLog.debug("Was not allowed to read system property \"" + s + "\".");
            return s1;
        }
        return s2;
    }

    public static Object instantiateByClassName(String s, Class class1, Object obj)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        Class class2;
        class2 = Loader.loadClass(s);
        if (class1.isAssignableFrom(class2))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        LogLog.error("A \"" + s + "\" object is not assignable to a \"" + class1.getName() + "\" variable.");
        LogLog.error("The class \"" + class1.getName() + "\" was loaded by ");
        LogLog.error("[" + class1.getClassLoader() + "] whereas object of type ");
        LogLog.error("\"" + class2.getName() + "\" was loaded by [" + class2.getClassLoader() + "].");
        return obj;
        class1 = ((Class) (class2.newInstance()));
        return class1;
        class1;
        LogLog.error("Could not instantiate class [" + s + "].", class1);
        return obj;
    }

    public static Object instantiateByKey(Properties properties, String s, Class class1, Object obj)
    {
        properties = findAndSubst(s, properties);
        if (properties == null)
        {
            LogLog.error("Could not find value for key " + s);
            return obj;
        } else
        {
            return instantiateByClassName(properties.trim(), class1, obj);
        }
    }

    public static void selectAndConfigure(URL url, String s, LoggerRepository loggerrepository)
    {
        String s2 = url.getFile();
        String s1 = s;
        if (s == null)
        {
            s1 = s;
            if (s2 != null)
            {
                s1 = s;
                if (s2.endsWith(".xml"))
                {
                    s1 = "org.apache.log4j.xml.DOMConfigurator";
                }
            }
        }
        if (s1 != null)
        {
            LogLog.debug("Preferred configurator class: " + s1);
            Configurator configurator;
            if (class$org$apache$log4j$spi$Configurator == null)
            {
                s = _mthclass$("org.apache.log4j.spi.Configurator");
                class$org$apache$log4j$spi$Configurator = s;
            } else
            {
                s = class$org$apache$log4j$spi$Configurator;
            }
            configurator = (Configurator)instantiateByClassName(s1, s, null);
            s = configurator;
            if (configurator == null)
            {
                LogLog.error("Could not instantiate configurator [" + s1 + "].");
                return;
            }
        } else
        {
            s = new PropertyConfigurator();
        }
        s.doConfigure(url, loggerrepository);
    }

    public static String substVars(String s, Properties properties)
        throws IllegalArgumentException
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
            int j = s.indexOf(DELIM_START, i);
            if (j == -1)
            {
                if (i == 0)
                {
                    return s;
                } else
                {
                    stringbuffer.append(s.substring(i, s.length()));
                    return stringbuffer.toString();
                }
            }
            stringbuffer.append(s.substring(i, j));
            i = s.indexOf(DELIM_STOP, j);
            if (i == -1)
            {
                throw new IllegalArgumentException('"' + s + "\" has no closing brace. Opening brace at position " + j + '.');
            }
            String s3 = s.substring(j + DELIM_START_LEN, i);
            String s2 = getSystemProperty(s3, null);
            String s1 = s2;
            if (s2 == null)
            {
                s1 = s2;
                if (properties != null)
                {
                    s1 = properties.getProperty(s3);
                }
            }
            if (s1 != null)
            {
                stringbuffer.append(substVars(s1, properties));
            }
            i += DELIM_STOP_LEN;
        } while (true);
    }

    public static boolean toBoolean(String s, boolean flag)
    {
        if (s != null)
        {
            s = s.trim();
            if ("true".equalsIgnoreCase(s))
            {
                return true;
            }
            if ("false".equalsIgnoreCase(s))
            {
                return false;
            }
        }
        return flag;
    }

    public static Level toLevel(String s, Level level)
    {
        Object obj;
        String s1;
        String s2;
        if (s == null)
        {
            return level;
        }
        int i = s.indexOf('#');
        if (i == -1)
        {
            if ("NULL".equalsIgnoreCase(s))
            {
                return null;
            } else
            {
                return Level.toLevel(s, level);
            }
        }
        obj = level;
        s1 = s.substring(i + 1);
        s2 = s.substring(0, i);
        if ("NULL".equalsIgnoreCase(s2))
        {
            return null;
        }
        LogLog.debug("toLevel:class=[" + s1 + "]" + ":pri=[" + s2 + "]");
        Class class2 = Loader.loadClass(s1);
        if (class$java$lang$String != null) goto _L2; else goto _L1
_L1:
        s = _mthclass$("java.lang.String");
        class$java$lang$String = s;
_L8:
        if (class$org$apache$log4j$Level != null) goto _L4; else goto _L3
_L3:
        Class class1;
        class1 = _mthclass$("org.apache.log4j.Level");
        class$org$apache$log4j$Level = class1;
_L6:
        s = (Level)class2.getMethod("toLevel", new Class[] {
            s, class1
        }).invoke(null, new Object[] {
            s2, level
        });
        obj = s;
          goto _L5
_L2:
        try
        {
            s = class$java$lang$String;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("custom level class [" + s1 + "] not found.");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("custom level class [" + s1 + "]" + " does not have a constructor which takes one string parameter", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("custom level class [" + s1 + "]" + " could not be instantiated", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("class [" + s1 + "] is not a subclass of org.apache.log4j.Level", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("class [" + s1 + "] cannot be instantiated due to access restrictions", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogLog.warn("class [" + s1 + "], level [" + s2 + "] conversion failed.", s);
        }
          goto _L5
_L4:
        class1 = class$org$apache$log4j$Level;
          goto _L6
_L5:
        return ((Level) (obj));
        if (true) goto _L8; else goto _L7
_L7:
    }

}
