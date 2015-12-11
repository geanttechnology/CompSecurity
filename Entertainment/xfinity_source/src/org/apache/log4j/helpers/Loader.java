// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

// Referenced classes of package org.apache.log4j.helpers:
//            OptionConverter, LogLog

public class Loader
{

    static Class class$java$lang$Thread;
    static Class class$org$apache$log4j$helpers$Loader;
    private static boolean ignoreTCL = false;
    private static boolean java1 = true;

    public Loader()
    {
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

    public static URL getResource(String s)
    {
        Object obj;
        if (java1 || ignoreTCL)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        obj = getTCL();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        LogLog.debug("Trying to find [" + s + "] using context classloader " + obj + ".");
        obj = ((ClassLoader) (obj)).getResource(s);
        if (obj != null)
        {
            return ((URL) (obj));
        }
        if (class$org$apache$log4j$helpers$Loader != null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = _mthclass$("org.apache.log4j.helpers.Loader");
        class$org$apache$log4j$helpers$Loader = ((Class) (obj));
_L1:
        obj = ((Class) (obj)).getClassLoader();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        LogLog.debug("Trying to find [" + s + "] using " + obj + " class loader.");
        obj = ((ClassLoader) (obj)).getResource(s);
        if (obj != null)
        {
            return ((URL) (obj));
        }
        break MISSING_BLOCK_LABEL_155;
        obj = class$org$apache$log4j$helpers$Loader;
          goto _L1
        Object obj1;
        obj1;
        LogLog.warn("Caught Exception while in Loader.getResource. This may be innocuous.", ((Throwable) (obj1)));
_L3:
        LogLog.debug("Trying to find [" + s + "] using ClassLoader.getSystemResource().");
        return ClassLoader.getSystemResource(s);
        obj1;
        if ((((InvocationTargetException) (obj1)).getTargetException() instanceof InterruptedException) || (((InvocationTargetException) (obj1)).getTargetException() instanceof InterruptedIOException))
        {
            Thread.currentThread().interrupt();
        }
        LogLog.warn("Caught Exception while in Loader.getResource. This may be innocuous.", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        LogLog.warn("Caught Exception while in Loader.getResource. This may be innocuous.", ((Throwable) (obj1)));
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static ClassLoader getTCL()
        throws IllegalAccessException, InvocationTargetException
    {
        Object obj;
        if (class$java$lang$Thread != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = _mthclass$("java.lang.Thread");
        class$java$lang$Thread = ((Class) (obj));
_L1:
        obj = ((Class) (obj)).getMethod("getContextClassLoader", null);
        return (ClassLoader)((Method) (obj)).invoke(Thread.currentThread(), null);
        try
        {
            obj = class$java$lang$Thread;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return null;
        }
          goto _L1
    }

    public static boolean isJava1()
    {
        return java1;
    }

    public static Class loadClass(String s)
        throws ClassNotFoundException
    {
        if (java1 || ignoreTCL)
        {
            return Class.forName(s);
        }
        Class class1 = getTCL().loadClass(s);
        return class1;
        Object obj;
        obj;
        if ((((InvocationTargetException) (obj)).getTargetException() instanceof InterruptedException) || (((InvocationTargetException) (obj)).getTargetException() instanceof InterruptedIOException))
        {
            Thread.currentThread().interrupt();
        }
_L2:
        return Class.forName(s);
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        String s = OptionConverter.getSystemProperty("java.version", null);
        if (s != null)
        {
            int i = s.indexOf('.');
            if (i != -1 && s.charAt(i + 1) != '1')
            {
                java1 = false;
            }
        }
        s = OptionConverter.getSystemProperty("log4j.ignoreTCL", null);
        if (s != null)
        {
            ignoreTCL = OptionConverter.toBoolean(s, true);
        }
    }
}
