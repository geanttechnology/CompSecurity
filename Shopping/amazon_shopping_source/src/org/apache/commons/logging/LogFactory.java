// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

// Referenced classes of package org.apache.commons.logging:
//            LogConfigurationException, Log

public abstract class LogFactory
{

    static Class class$java$lang$Thread;
    static Class class$org$apache$commons$logging$LogFactory;
    private static String diagnosticPrefix;
    private static PrintStream diagnosticsStream = null;
    protected static Hashtable factories = null;
    protected static LogFactory nullClassLoaderFactory = null;
    private static ClassLoader thisClassLoader;

    protected LogFactory()
    {
    }

    private static void cacheFactory(ClassLoader classloader, LogFactory logfactory)
    {
label0:
        {
            if (logfactory != null)
            {
                if (classloader != null)
                {
                    break label0;
                }
                nullClassLoaderFactory = logfactory;
            }
            return;
        }
        factories.put(classloader, logfactory);
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

    protected static Object createFactory(String s, ClassLoader classloader)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj = null;
        obj4 = null;
        obj2 = null;
        obj1 = null;
        obj3 = null;
        if (classloader == null) goto _L2; else goto _L1
_L1:
        obj1 = classloader.loadClass(s);
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        if (class$org$apache$commons$logging$LogFactory != null) goto _L4; else goto _L3
_L3:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        Class class1 = _mthclass$("org.apache.commons.logging.LogFactory");
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        class$org$apache$commons$logging$LogFactory = class1;
_L22:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        if (!class1.isAssignableFrom(((Class) (obj1)))) goto _L6; else goto _L5
_L5:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        logDiagnostic("Loaded class " + ((Class) (obj1)).getName() + " from classloader " + objectId(classloader));
_L8:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        return (LogFactory)((Class) (obj1)).newInstance();
_L4:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        class1 = class$org$apache$commons$logging$LogFactory;
        continue; /* Loop/switch isn't completed */
_L6:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        if (!isDiagnosticsEnabled()) goto _L8; else goto _L7
_L7:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        StringBuffer stringbuffer = (new StringBuffer()).append("Factory class ").append(((Class) (obj1)).getName()).append(" loaded from classloader ").append(objectId(((Class) (obj1)).getClassLoader())).append(" does not extend '");
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        if (class$org$apache$commons$logging$LogFactory != null) goto _L10; else goto _L9
_L9:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        class1 = _mthclass$("org.apache.commons.logging.LogFactory");
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        class$org$apache$commons$logging$LogFactory = class1;
_L12:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        logDiagnostic(stringbuffer.append(class1.getName()).append("' as loaded by this classloader.").toString());
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        logHierarchy("[BAD CL TREE] ", classloader);
          goto _L8
        obj2;
        obj = obj3;
        obj1 = obj3;
        if (classloader != thisClassLoader) goto _L2; else goto _L11
_L11:
        obj = obj3;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_430;
        }
        obj = obj3;
        logDiagnostic("Unable to locate any class called '" + s + "' via classloader " + objectId(classloader));
        break MISSING_BLOCK_LABEL_430;
_L10:
        obj3 = obj1;
        obj = obj1;
        obj4 = obj1;
        obj2 = obj1;
        class1 = class$org$apache$commons$logging$LogFactory;
          goto _L12
        obj2;
        obj = obj4;
        obj1 = obj4;
        if (classloader != thisClassLoader) goto _L2; else goto _L13
_L13:
        obj = obj4;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_582;
        }
        obj = obj4;
        logDiagnostic("Class '" + s + "' cannot be loaded" + " via classloader " + objectId(classloader) + " - it depends on some other class that cannot" + " be found.");
        obj = obj4;
        throw obj2;
        obj;
        obj = obj2;
        obj1 = obj2;
        if (classloader != thisClassLoader) goto _L2; else goto _L14
_L14:
        obj = obj2;
        flag = implementsLogFactory(((Class) (obj2)));
        obj = obj2;
        classloader = (new StringBuffer()).append("The application has specified that a custom LogFactory implementation should be used but Class '").append(s).append("' cannot be converted to '");
        obj = obj2;
        if (class$org$apache$commons$logging$LogFactory != null) goto _L16; else goto _L15
_L15:
        obj = obj2;
        s = _mthclass$("org.apache.commons.logging.LogFactory");
        obj = obj2;
        class$org$apache$commons$logging$LogFactory = s;
_L19:
        obj = obj2;
        s = classloader.append(s.getName()).append("'. ").toString();
        if (!flag) goto _L18; else goto _L17
_L17:
        obj = obj2;
        s = s + "The conflict is caused by the presence of multiple LogFactory classes in incompatible classloaders. " + "Background can be found in http://commons.apache.org/logging/tech.html. " + "If you have not explicitly specified a custom LogFactory then it is likely that " + "the container has set one without your knowledge. " + "In this case, consider using the commons-logging-adapters.jar file or " + "specifying the standard LogFactory from the command line. ";
_L20:
        obj = obj2;
        s = s + "Help can be found @http://commons.apache.org/logging/troubleshooting.html.";
        obj = obj2;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_774;
        }
        obj = obj2;
        logDiagnostic(s);
        obj = obj2;
        throw new ClassCastException(s);
_L16:
        obj = obj2;
        s = class$org$apache$commons$logging$LogFactory;
          goto _L19
_L18:
        obj = obj2;
        s = s + "Please check the custom implementation. ";
          goto _L20
_L2:
        obj = obj1;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_862;
        }
        obj = obj1;
        logDiagnostic("Unable to load factory class via classloader " + objectId(classloader) + " - trying the classloader associated with this LogFactory.");
        obj = obj1;
        s = Class.forName(s);
        obj = s;
        s = (LogFactory)s.newInstance();
        return s;
        obj = obj3;
        try
        {
            throw obj2;
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader) { }
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("Unable to create LogFactory instance.");
        }
        if (obj != null)
        {
            boolean flag;
            if (class$org$apache$commons$logging$LogFactory == null)
            {
                s = _mthclass$("org.apache.commons.logging.LogFactory");
                class$org$apache$commons$logging$LogFactory = s;
            } else
            {
                s = class$org$apache$commons$logging$LogFactory;
            }
            if (!s.isAssignableFrom(((Class) (obj))))
            {
                return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", classloader);
            }
        }
        return new LogConfigurationException(classloader);
        if (true) goto _L22; else goto _L21
_L21:
    }

    private static final Hashtable createFactoryStore()
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        try
        {
            obj = getSystemProperty("org.apache.commons.logging.LogFactory.HashtableImpl", null);
        }
        catch (SecurityException securityexception)
        {
            securityexception = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = "org.apache.commons.logging.impl.WeakHashtable";
        }
        obj = (Hashtable)Class.forName(((String) (obj1))).newInstance();
_L2:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new Hashtable();
        }
        return ((Hashtable) (obj1));
        Throwable throwable;
        throwable;
        throwable = obj2;
        if (!"org.apache.commons.logging.impl.WeakHashtable".equals(obj1))
        {
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                throwable = obj2;
            } else
            {
                System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                throwable = obj2;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static ClassLoader directGetContextClassLoader()
        throws LogConfigurationException
    {
        Object obj1 = null;
        if (class$java$lang$Thread != null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = _mthclass$("java.lang.Thread");
        class$java$lang$Thread = ((Class) (obj));
_L3:
        obj = ((Class) (obj)).getMethod("getContextClassLoader", (Class[])null);
        obj = (ClassLoader)((Method) (obj)).invoke(Thread.currentThread(), (Object[])null);
_L5:
        return ((ClassLoader) (obj));
_L2:
        obj = class$java$lang$Thread;
          goto _L3
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        try
        {
            throw new LogConfigurationException("Unexpected IllegalAccessException", illegalaccessexception);
        }
        catch (NoSuchMethodException nosuchmethodexception) { }
        InvocationTargetException invocationtargetexception;
        if (class$org$apache$commons$logging$LogFactory == null)
        {
            nosuchmethodexception = _mthclass$("org.apache.commons.logging.LogFactory");
            class$org$apache$commons$logging$LogFactory = nosuchmethodexception;
        } else
        {
            nosuchmethodexception = class$org$apache$commons$logging$LogFactory;
        }
        return getClassLoader(nosuchmethodexception);
        invocationtargetexception;
        nosuchmethodexception = obj1;
        if (invocationtargetexception.getTargetException() instanceof SecurityException) goto _L5; else goto _L4
_L4:
        throw new LogConfigurationException("Unexpected InvocationTargetException", invocationtargetexception.getTargetException());
          goto _L3
    }

    private static LogFactory getCachedFactory(ClassLoader classloader)
    {
        if (classloader == null)
        {
            return nullClassLoaderFactory;
        } else
        {
            return (LogFactory)factories.get(classloader);
        }
    }

    protected static ClassLoader getClassLoader(Class class1)
    {
        ClassLoader classloader;
        try
        {
            classloader = class1.getClassLoader();
        }
        catch (SecurityException securityexception)
        {
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("Unable to get classloader for class '" + class1 + "' due to security restrictions - " + securityexception.getMessage());
            }
            throw securityexception;
        }
        return classloader;
    }

    private static final Properties getConfigurationFile(ClassLoader classloader, String s)
    {
        double d;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        obj3 = null;
        d = 0.0D;
        obj2 = null;
        obj = null;
        Enumeration enumeration = getResources(classloader, s);
        classloader = ((ClassLoader) (obj3));
        if (enumeration == null)
        {
            return null;
        }
_L6:
        Object obj4;
        obj1 = classloader;
        obj2 = obj;
        obj3 = classloader;
        obj4 = obj;
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        obj1 = classloader;
        obj2 = obj;
        URL url = (URL)enumeration.nextElement();
        obj1 = classloader;
        obj2 = obj;
        obj4 = getProperties(url);
        if (obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (classloader != null) goto _L4; else goto _L3
_L3:
        obj3 = url;
        obj1 = obj4;
        obj2 = obj3;
        classloader = ((Properties) (obj4)).getProperty("priority");
        double d1;
        d1 = 0.0D;
        if (classloader == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        obj1 = obj4;
        obj2 = obj3;
        d1 = Double.parseDouble(classloader);
        d = d1;
        classloader = ((ClassLoader) (obj4));
        obj = obj3;
        obj1 = obj4;
        obj2 = obj3;
        if (!isDiagnosticsEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj4;
        obj2 = obj3;
        logDiagnostic("[LOOKUP] Properties file found at '" + url + "'" + " with priority " + d1);
        d = d1;
        classloader = ((ClassLoader) (obj4));
        obj = obj3;
        continue; /* Loop/switch isn't completed */
_L2:
        if (isDiagnosticsEnabled())
        {
            if (obj3 == null)
            {
                logDiagnostic("[LOOKUP] No properties file of name '" + s + "' found.");
            } else
            {
                logDiagnostic("[LOOKUP] Properties file of name '" + s + "' found at '" + obj4 + '"');
            }
        }
        return ((Properties) (obj3));
_L4:
        obj1 = classloader;
        obj2 = obj;
        obj3 = ((Properties) (obj4)).getProperty("priority");
        d1 = 0.0D;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        obj1 = classloader;
        obj2 = obj;
        d1 = Double.parseDouble(((String) (obj3)));
        if (d1 <= d)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        obj1 = classloader;
        obj2 = obj;
        if (!isDiagnosticsEnabled())
        {
            break MISSING_BLOCK_LABEL_567;
        }
        obj1 = classloader;
        obj2 = obj;
        logDiagnostic("[LOOKUP] Properties file at '" + url + "'" + " with priority " + d1 + " overrides file at '" + obj + "'" + " with priority " + d);
        break MISSING_BLOCK_LABEL_567;
        obj1 = classloader;
        obj2 = obj;
        if (!isDiagnosticsEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = classloader;
        obj2 = obj;
        try
        {
            logDiagnostic("[LOOKUP] Properties file at '" + url + "'" + " with priority " + d1 + " does not override file at '" + obj + "'" + " with priority " + d);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            obj3 = obj1;
            obj4 = obj2;
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("SecurityException thrown while trying to find/read config files.");
                obj4 = obj2;
                obj3 = obj1;
            }
        }
          goto _L2
        obj = url;
        classloader = ((ClassLoader) (obj4));
        d = d1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static ClassLoader getContextClassLoaderInternal()
        throws LogConfigurationException
    {
        return (ClassLoader)AccessController.doPrivileged(new _cls1());
    }

    public static LogFactory getFactory()
        throws LogConfigurationException
    {
        Object obj;
        Object obj1;
        Object obj3;
        ClassLoader classloader = getContextClassLoaderInternal();
        if (classloader == null && isDiagnosticsEnabled())
        {
            logDiagnostic("Context classloader is null.");
        }
        obj1 = getCachedFactory(classloader);
        if (obj1 != null)
        {
            return ((LogFactory) (obj1));
        }
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("[LOOKUP] LogFactory implementation requested for the first time for context classloader " + objectId(classloader));
            logHierarchy("[LOOKUP] ", classloader);
        }
        Properties properties = getConfigurationFile(classloader, "commons-logging.properties");
        obj = classloader;
        Object obj2 = obj;
        if (properties != null)
        {
            String s = properties.getProperty("use_tccl");
            obj2 = obj;
            if (s != null)
            {
                obj2 = obj;
                if (!Boolean.valueOf(s).booleanValue())
                {
                    obj2 = thisClassLoader;
                }
            }
        }
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        try
        {
            obj = getSystemProperty("org.apache.commons.logging.LogFactory", null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3)
        {
            obj = obj1;
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + trim(((Throwable) (obj3)).getMessage()) + "]. Trying alternative implementations...");
                obj = obj1;
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [" + trim(((Throwable) (obj)).getMessage()) + "] as specified by a system property.");
            }
            throw obj;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("[LOOKUP] Creating an instance of LogFactory class '" + obj + "' as specified by system property " + "org.apache.commons.logging.LogFactory");
        }
        obj = newFactory(((String) (obj)), ((ClassLoader) (obj2)), classloader);
_L10:
        obj1 = obj;
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        obj3 = getResourceAsStream(classloader, "META-INF/services/org.apache.commons.logging.LogFactory");
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj3)), "UTF-8"));
_L7:
        obj3 = ((BufferedReader) (obj1)).readLine();
        ((BufferedReader) (obj1)).close();
        obj1 = obj;
        if (obj3 != null)
        {
            obj1 = obj;
            try
            {
                if (!"".equals(obj3))
                {
                    if (isDiagnosticsEnabled())
                    {
                        logDiagnostic("[LOOKUP]  Creating an instance of LogFactory class " + obj3 + " as specified by file '" + "META-INF/services/org.apache.commons.logging.LogFactory" + "' which was present in the path of the context" + " classloader.");
                    }
                    obj1 = newFactory(((String) (obj3)), ((ClassLoader) (obj2)), classloader);
                }
            }
            catch (Exception exception)
            {
                obj1 = obj;
                if (isDiagnosticsEnabled())
                {
                    logDiagnostic("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + trim(exception.getMessage()) + "]. Trying alternative implementations...");
                    obj1 = obj;
                }
            }
        }
          goto _L4
_L2:
        obj = obj1;
        if (!isDiagnosticsEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj3))));
          goto _L7
_L6:
        obj1 = obj;
        if (!isDiagnosticsEnabled()) goto _L4; else goto _L8
_L8:
        logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
        obj1 = obj;
_L4:
        obj = obj1;
        if (obj1 == null)
        {
            if (properties != null)
            {
                if (isDiagnosticsEnabled())
                {
                    logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                }
                obj = properties.getProperty("org.apache.commons.logging.LogFactory");
                if (obj != null)
                {
                    if (isDiagnosticsEnabled())
                    {
                        logDiagnostic("[LOOKUP] Properties file specifies LogFactory subclass '" + obj + "'");
                    }
                    obj = newFactory(((String) (obj)), ((ClassLoader) (obj2)), classloader);
                } else
                {
                    obj = obj1;
                    if (isDiagnosticsEnabled())
                    {
                        logDiagnostic("[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
                        obj = obj1;
                    }
                }
            } else
            {
                obj = obj1;
                if (isDiagnosticsEnabled())
                {
                    logDiagnostic("[LOOKUP] No properties file available to determine LogFactory subclass from..");
                    obj = obj1;
                }
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
            }
            obj1 = newFactory("org.apache.commons.logging.impl.LogFactoryImpl", thisClassLoader, classloader);
        }
        if (obj1 != null)
        {
            cacheFactory(classloader, ((LogFactory) (obj1)));
            if (properties != null)
            {
                for (obj = properties.propertyNames(); ((Enumeration) (obj)).hasMoreElements(); ((LogFactory) (obj1)).setAttribute(((String) (obj2)), properties.getProperty(((String) (obj2)))))
                {
                    obj2 = (String)((Enumeration) (obj)).nextElement();
                }

            }
        }
        return ((LogFactory) (obj1));
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static Log getLog(Class class1)
        throws LogConfigurationException
    {
        return getFactory().getInstance(class1);
    }

    public static Log getLog(String s)
        throws LogConfigurationException
    {
        return getFactory().getInstance(s);
    }

    private static Properties getProperties(final URL url)
    {
        return (Properties)AccessController.doPrivileged(new _cls5());
    }

    private static InputStream getResourceAsStream(final ClassLoader loader, final String name)
    {
        return (InputStream)AccessController.doPrivileged(new _cls3());
    }

    private static Enumeration getResources(final ClassLoader loader, final String name)
    {
        return (Enumeration)AccessController.doPrivileged(new _cls4());
    }

    private static String getSystemProperty(final String key, final String def)
        throws SecurityException
    {
        return (String)AccessController.doPrivileged(new _cls6());
    }

    private static boolean implementsLogFactory(Class class1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag4 = false;
        flag5 = false;
        flag = false;
        flag1 = false;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        flag2 = flag1;
        flag3 = flag4;
        flag = flag5;
        ClassLoader classloader = class1.getClassLoader();
        if (classloader != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        flag2 = flag1;
        flag3 = flag4;
        flag = flag5;
        logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
        return false;
        flag2 = flag1;
        flag3 = flag4;
        flag = flag5;
        logHierarchy("[CUSTOM LOG FACTORY] ", classloader);
        flag2 = flag1;
        flag3 = flag4;
        flag = flag5;
        flag1 = Class.forName("org.apache.commons.logging.LogFactory", false, classloader).isAssignableFrom(class1);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        flag2 = flag1;
        flag3 = flag1;
        flag = flag1;
        logDiagnostic("[CUSTOM LOG FACTORY] " + class1.getName() + " implements LogFactory but was loaded by an incompatible classloader.");
        return flag1;
        class1;
        logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + class1.getMessage());
        return flag2;
        flag2 = flag1;
        flag3 = flag1;
        flag = flag1;
        logDiagnostic("[CUSTOM LOG FACTORY] " + class1.getName() + " does not implement LogFactory.");
        return flag1;
        class1;
        logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + class1.getMessage());
        return flag3;
        class1;
        logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
        return flag;
    }

    private static void initDiagnostics()
    {
        Object obj;
        try
        {
            obj = getSystemProperty("org.apache.commons.logging.diagnostics.dest", null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        if (obj == null)
        {
            return;
        }
        if (((String) (obj)).equals("STDOUT"))
        {
            diagnosticsStream = System.out;
        } else
        if (((String) (obj)).equals("STDERR"))
        {
            diagnosticsStream = System.err;
        } else
        {
            try
            {
                diagnosticsStream = new PrintStream(new FileOutputStream(((String) (obj)), true));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
        obj = thisClassLoader;
        if (thisClassLoader == null)
        {
            obj = "BOOTLOADER";
        } else
        {
            try
            {
                obj = objectId(obj);
            }
            catch (SecurityException securityexception)
            {
                securityexception = "UNKNOWN";
            }
        }
        diagnosticPrefix = "[LogFactory from " + obj + "] ";
        return;
    }

    protected static boolean isDiagnosticsEnabled()
    {
        return diagnosticsStream != null;
    }

    private static void logClassLoaderEnvironment(Class class1)
    {
        if (!isDiagnosticsEnabled())
        {
            return;
        }
        Object obj;
        try
        {
            logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
            logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
        }
        obj = class1.getName();
        try
        {
            class1 = getClassLoader(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            logDiagnostic("[ENV] Security forbids determining the classloader for " + obj);
            return;
        }
        logDiagnostic("[ENV] Class " + obj + " was loaded via classloader " + objectId(class1));
        logHierarchy("[ENV] Ancestry of classloader which loaded " + obj + " is ", class1);
    }

    private static final void logDiagnostic(String s)
    {
        if (diagnosticsStream != null)
        {
            diagnosticsStream.print(diagnosticPrefix);
            diagnosticsStream.println(s);
            diagnosticsStream.flush();
        }
    }

    private static void logHierarchy(String s, ClassLoader classloader)
    {
        if (isDiagnosticsEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        StringBuffer stringbuffer;
        if (classloader != null)
        {
            String s1 = classloader.toString();
            logDiagnostic(s + objectId(classloader) + " == '" + s1 + "'");
        }
        ClassLoader classloader1;
        try
        {
            classloader1 = ClassLoader.getSystemClassLoader();
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            logDiagnostic(s + "Security forbids determining the system classloader.");
            return;
        }
        if (classloader == null) goto _L1; else goto _L3
_L3:
        stringbuffer = new StringBuffer(s + "ClassLoader tree:");
_L5:
        stringbuffer.append(objectId(classloader));
        if (classloader == classloader1)
        {
            stringbuffer.append(" (SYSTEM) ");
        }
        s = classloader.getParent();
        stringbuffer.append(" --> ");
        classloader = s;
        if (s != null) goto _L5; else goto _L4
_L4:
        stringbuffer.append("BOOT");
_L7:
        logDiagnostic(stringbuffer.toString());
        return;
        s;
        stringbuffer.append(" --> SECRET");
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected static LogFactory newFactory(final String factoryClass, final ClassLoader classLoader, ClassLoader classloader)
        throws LogConfigurationException
    {
        factoryClass = ((String) (AccessController.doPrivileged(new _cls2())));
        if (factoryClass instanceof LogConfigurationException)
        {
            factoryClass = (LogConfigurationException)factoryClass;
            if (isDiagnosticsEnabled())
            {
                logDiagnostic("An error occurred while loading the factory class:" + factoryClass.getMessage());
            }
            throw factoryClass;
        }
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("Created object " + objectId(factoryClass) + " to manage classloader " + objectId(classloader));
        }
        return (LogFactory)factoryClass;
    }

    public static String objectId(Object obj)
    {
        if (obj == null)
        {
            return "null";
        } else
        {
            return obj.getClass().getName() + "@" + System.identityHashCode(obj);
        }
    }

    private static String trim(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.trim();
        }
    }

    public abstract Log getInstance(Class class1)
        throws LogConfigurationException;

    public abstract Log getInstance(String s)
        throws LogConfigurationException;

    public abstract void setAttribute(String s, Object obj);

    static 
    {
        Class class1;
        if (class$org$apache$commons$logging$LogFactory == null)
        {
            class1 = _mthclass$("org.apache.commons.logging.LogFactory");
            class$org$apache$commons$logging$LogFactory = class1;
        } else
        {
            class1 = class$org$apache$commons$logging$LogFactory;
        }
        thisClassLoader = getClassLoader(class1);
        initDiagnostics();
        if (class$org$apache$commons$logging$LogFactory == null)
        {
            class1 = _mthclass$("org.apache.commons.logging.LogFactory");
            class$org$apache$commons$logging$LogFactory = class1;
        } else
        {
            class1 = class$org$apache$commons$logging$LogFactory;
        }
        logClassLoaderEnvironment(class1);
        factories = createFactoryStore();
        if (isDiagnosticsEnabled())
        {
            logDiagnostic("BOOTSTRAP COMPLETED");
        }
    }


    private class _cls1
        implements PrivilegedAction
    {

        public Object run()
        {
            return LogFactory.directGetContextClassLoader();
        }

        _cls1()
        {
        }
    }


    private class _cls5
        implements PrivilegedAction
    {

        private final URL val$url;

        public Object run()
        {
            InputStream inputstream = url.openStream();
            if (inputstream == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            Properties properties;
            properties = new Properties();
            properties.load(inputstream);
            inputstream.close();
            return properties;
            IOException ioexception;
            ioexception;
            if (LogFactory.isDiagnosticsEnabled())
            {
                LogFactory.logDiagnostic("Unable to read URL " + url);
            }
            return null;
        }

        _cls5()
        {
            url = url1;
        }
    }


    private class _cls3
        implements PrivilegedAction
    {

        private final ClassLoader val$loader;
        private final String val$name;

        public Object run()
        {
            if (loader != null)
            {
                return loader.getResourceAsStream(name);
            } else
            {
                return ClassLoader.getSystemResourceAsStream(name);
            }
        }

        _cls3()
        {
            loader = classloader;
            name = s;
        }
    }


    private class _cls4
        implements PrivilegedAction
    {

        private final ClassLoader val$loader;
        private final String val$name;

        public Object run()
        {
            Enumeration enumeration;
            try
            {
                if (loader != null)
                {
                    return loader.getResources(name);
                }
                enumeration = ClassLoader.getSystemResources(name);
            }
            catch (IOException ioexception)
            {
label0:
                {
                    if (LogFactory.isDiagnosticsEnabled())
                    {
                        LogFactory.logDiagnostic("Exception while trying to find configuration file " + name + ":" + ioexception.getMessage());
                        return null;
                    }
                    break label0;
                }
            }
            catch (NoSuchMethodError nosuchmethoderror)
            {
                return null;
            }
            return enumeration;
        }

        _cls4()
        {
            loader = classloader;
            name = s;
        }
    }


    private class _cls6
        implements PrivilegedAction
    {

        private final String val$def;
        private final String val$key;

        public Object run()
        {
            return System.getProperty(key, def);
        }

        _cls6()
        {
            key = s;
            def = s1;
        }
    }


    private class _cls2
        implements PrivilegedAction
    {

        private final ClassLoader val$classLoader;
        private final String val$factoryClass;

        public Object run()
        {
            return LogFactory.createFactory(factoryClass, classLoader);
        }

        _cls2()
        {
            factoryClass = s;
            classLoader = classloader;
        }
    }

}
