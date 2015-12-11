// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.springframework.util:
//            Assert

public abstract class ClassUtils
{

    private static final Map commonClassCache = new HashMap(32);
    private static final Map primitiveTypeNameMap;
    private static final Map primitiveTypeToWrapperMap;
    private static final Map primitiveWrapperTypeMap;

    public ClassUtils()
    {
    }

    public static Class forName(String s, ClassLoader classloader)
        throws ClassNotFoundException, LinkageError
    {
        Assert.notNull(s, "Name must not be null");
        Class class2 = resolvePrimitiveClassName(s);
        Object obj = class2;
        if (class2 == null)
        {
            obj = (Class)commonClassCache.get(s);
        }
        if (obj != null)
        {
            return ((Class) (obj));
        }
        if (s.endsWith("[]"))
        {
            return Array.newInstance(forName(s.substring(0, s.length() - "[]".length()), classloader), 0).getClass();
        }
        if (s.startsWith("[L") && s.endsWith(";"))
        {
            return Array.newInstance(forName(s.substring("[L".length(), s.length() - 1), classloader), 0).getClass();
        }
        if (s.startsWith("["))
        {
            return Array.newInstance(forName(s.substring("[".length()), classloader), 0).getClass();
        }
        obj = classloader;
        classloader = ((ClassLoader) (obj));
        if (obj == null)
        {
            classloader = getDefaultClassLoader();
        }
        Class class1 = classloader.loadClass(s);
        return class1;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        int i = s.lastIndexOf('.');
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        s = (new StringBuilder()).append(s.substring(0, i)).append('$').append(s.substring(i + 1)).toString();
        s = classloader.loadClass(s);
        return s;
        s;
        throw classnotfoundexception;
    }

    public static ClassLoader getDefaultClassLoader()
    {
        ClassLoader classloader = null;
        ClassLoader classloader1 = Thread.currentThread().getContextClassLoader();
        classloader = classloader1;
_L2:
        ClassLoader classloader2 = classloader;
        if (classloader == null)
        {
            classloader2 = org/springframework/util/ClassUtils.getClassLoader();
        }
        return classloader2;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getDescriptiveType(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        Object obj1 = obj.getClass();
        if (Proxy.isProxyClass(((Class) (obj1))))
        {
            obj = new StringBuilder(((Class) (obj1)).getName());
            ((StringBuilder) (obj)).append(" implementing ");
            obj1 = ((Class) (obj1)).getInterfaces();
            for (int i = 0; i < obj1.length; i++)
            {
                ((StringBuilder) (obj)).append(obj1[i].getName());
                if (i < obj1.length - 1)
                {
                    ((StringBuilder) (obj)).append(',');
                }
            }

            return ((StringBuilder) (obj)).toString();
        }
        if (((Class) (obj1)).isArray())
        {
            return getQualifiedNameForArray(((Class) (obj1)));
        } else
        {
            return ((Class) (obj1)).getName();
        }
    }

    public static String getQualifiedName(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        if (class1.isArray())
        {
            return getQualifiedNameForArray(class1);
        } else
        {
            return class1.getName();
        }
    }

    private static String getQualifiedNameForArray(Class class1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (; class1.isArray(); stringbuilder.append("[]"))
        {
            class1 = class1.getComponentType();
        }

        stringbuilder.insert(0, class1.getName());
        return stringbuilder.toString();
    }

    public static boolean isPresent(String s, ClassLoader classloader)
    {
        try
        {
            forName(s, classloader);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    private static transient void registerCommonClasses(Class aclass[])
    {
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            Class class1 = aclass[i];
            commonClassCache.put(class1.getName(), class1);
        }

    }

    public static Class resolvePrimitiveClassName(String s)
    {
        Object obj = null;
        Class class1 = obj;
        if (s != null)
        {
            class1 = obj;
            if (s.length() <= 8)
            {
                class1 = (Class)primitiveTypeNameMap.get(s);
            }
        }
        return class1;
    }

    static 
    {
        primitiveWrapperTypeMap = new HashMap(8);
        primitiveTypeToWrapperMap = new HashMap(8);
        primitiveTypeNameMap = new HashMap(32);
        primitiveWrapperTypeMap.put(java/lang/Boolean, Boolean.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Byte, Byte.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Character, Character.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Double, Double.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Float, Float.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Integer, Integer.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Long, Long.TYPE);
        primitiveWrapperTypeMap.put(java/lang/Short, Short.TYPE);
        java.util.Map.Entry entry;
        for (Iterator iterator = primitiveWrapperTypeMap.entrySet().iterator(); iterator.hasNext(); registerCommonClasses(new Class[] {
    (Class)entry.getKey()
}))
        {
            entry = (java.util.Map.Entry)iterator.next();
            primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
        }

        Object obj = new HashSet(32);
        ((Set) (obj)).addAll(primitiveWrapperTypeMap.values());
        ((Set) (obj)).addAll(Arrays.asList(new Class[] {
            [Z, [B, [C, [D, [F, [I, [J, [S
        }));
        ((Set) (obj)).add(Void.TYPE);
        Class class1;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); primitiveTypeNameMap.put(class1.getName(), class1))
        {
            class1 = (Class)((Iterator) (obj)).next();
        }

        registerCommonClasses(new Class[] {
            [Ljava/lang/Boolean;, [Ljava/lang/Byte;, [Ljava/lang/Character;, [Ljava/lang/Double;, [Ljava/lang/Float;, [Ljava/lang/Integer;, [Ljava/lang/Long;, [Ljava/lang/Short;
        });
        registerCommonClasses(new Class[] {
            java/lang/Number, [Ljava/lang/Number;, java/lang/String, [Ljava/lang/String;, java/lang/Object, [Ljava/lang/Object;, java/lang/Class, [Ljava/lang/Class;
        });
        registerCommonClasses(new Class[] {
            java/lang/Throwable, java/lang/Exception, java/lang/RuntimeException, java/lang/Error, java/lang/StackTraceElement, [Ljava/lang/StackTraceElement;
        });
    }
}
