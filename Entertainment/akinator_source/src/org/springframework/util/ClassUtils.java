// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.springframework.util:
//            Assert, CollectionUtils

public abstract class ClassUtils
{

    public static final String ARRAY_SUFFIX = "[]";
    public static final String CGLIB_CLASS_SEPARATOR = "$$";
    public static final String CLASS_FILE_SUFFIX = ".class";
    private static final char INNER_CLASS_SEPARATOR = 36;
    private static final String INTERNAL_ARRAY_PREFIX = "[";
    private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";
    private static final char PACKAGE_SEPARATOR = 46;
    private static final Map commonClassCache = new HashMap(32);
    private static final Map primitiveTypeNameMap;
    private static final Map primitiveTypeToWrapperMap;
    private static final Map primitiveWrapperTypeMap;

    public ClassUtils()
    {
    }

    public static String addResourcePathToPackagePath(Class class1, String s)
    {
        Assert.notNull(s, "Resource name must not be null");
        if (!s.startsWith("/"))
        {
            return (new StringBuilder()).append(classPackageAsResourcePath(class1)).append("/").append(s).toString();
        } else
        {
            return (new StringBuilder()).append(classPackageAsResourcePath(class1)).append(s).toString();
        }
    }

    public static String classNamesToString(Collection collection)
    {
        if (CollectionUtils.isEmpty(collection))
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder("[");
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            stringbuilder.append(((Class)collection.next()).getName());
            if (collection.hasNext())
            {
                stringbuilder.append(", ");
            }
        } while (true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public static transient String classNamesToString(Class aclass[])
    {
        return classNamesToString(((Collection) (Arrays.asList(aclass))));
    }

    public static String classPackageAsResourcePath(Class class1)
    {
        if (class1 == null)
        {
            return "";
        }
        class1 = class1.getName();
        int i = class1.lastIndexOf('.');
        if (i == -1)
        {
            return "";
        } else
        {
            return class1.substring(0, i).replace('.', '/');
        }
    }

    public static String convertClassNameToResourcePath(String s)
    {
        Assert.notNull(s, "Class name must not be null");
        return s.replace('.', '/');
    }

    public static String convertResourcePathToClassName(String s)
    {
        Assert.notNull(s, "Resource path must not be null");
        return s.replace('/', '.');
    }

    public static Class createCompositeInterface(Class aclass[], ClassLoader classloader)
    {
        Assert.notEmpty(aclass, "Interfaces must not be empty");
        Assert.notNull(classloader, "ClassLoader must not be null");
        return Proxy.getProxyClass(classloader, aclass);
    }

    public static Class forName(String s)
        throws ClassNotFoundException, LinkageError
    {
        return forName(s, getDefaultClassLoader());
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
            break MISSING_BLOCK_LABEL_230;
        }
        s = (new StringBuilder()).append(s.substring(0, i)).append('$').append(s.substring(i + 1)).toString();
        s = classloader.loadClass(s);
        return s;
        s;
        throw classnotfoundexception;
    }

    public static Class[] getAllInterfaces(Object obj)
    {
        Assert.notNull(obj, "Instance must not be null");
        return getAllInterfacesForClass(obj.getClass());
    }

    public static Set getAllInterfacesAsSet(Object obj)
    {
        Assert.notNull(obj, "Instance must not be null");
        return getAllInterfacesForClassAsSet(obj.getClass());
    }

    public static Class[] getAllInterfacesForClass(Class class1)
    {
        return getAllInterfacesForClass(class1, null);
    }

    public static Class[] getAllInterfacesForClass(Class class1, ClassLoader classloader)
    {
        class1 = getAllInterfacesForClassAsSet(class1, classloader);
        return (Class[])class1.toArray(new Class[class1.size()]);
    }

    public static Set getAllInterfacesForClassAsSet(Class class1)
    {
        return getAllInterfacesForClassAsSet(class1, null);
    }

    public static Set getAllInterfacesForClassAsSet(Class class1, ClassLoader classloader)
    {
        Assert.notNull(class1, "Class must not be null");
        if (!class1.isInterface() || !isVisible(class1, classloader)) goto _L2; else goto _L1
_L1:
        Object obj = Collections.singleton(class1);
_L4:
        return ((Set) (obj));
_L2:
        LinkedHashSet linkedhashset = new LinkedHashSet();
        do
        {
            obj = linkedhashset;
            if (class1 == null)
            {
                continue;
            }
            Class aclass[] = class1.getInterfaces();
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                linkedhashset.addAll(getAllInterfacesForClassAsSet(aclass[i], classloader));
            }

            class1 = class1.getSuperclass();
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getClassFileName(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        class1 = class1.getName();
        int i = class1.lastIndexOf('.');
        return (new StringBuilder()).append(class1.substring(i + 1)).append(".class").toString();
    }

    public static transient Constructor getConstructorIfAvailable(Class class1, Class aclass[])
    {
        Assert.notNull(class1, "Class must not be null");
        try
        {
            class1 = class1.getConstructor(aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
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

    public static transient Method getMethod(Class class1, String s, Class aclass[])
    {
        Assert.notNull(class1, "Class must not be null");
        Assert.notNull(s, "Method name must not be null");
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected method not found: ").append(class1).toString());
        }
        return class1;
    }

    public static int getMethodCountForName(Class class1, String s)
    {
        Assert.notNull(class1, "Class must not be null");
        Assert.notNull(s, "Method name must not be null");
        int i = 0;
        Object aobj[] = class1.getDeclaredMethods();
        int k1 = aobj.length;
        for (int j = 0; j < k1;)
        {
            int i1 = i;
            if (s.equals(aobj[j].getName()))
            {
                i1 = i + 1;
            }
            j++;
            i = i1;
        }

        aobj = class1.getInterfaces();
        int j1 = aobj.length;
        for (int k = 0; k < j1; k++)
        {
            i += getMethodCountForName(aobj[k], s);
        }

        int l = i;
        if (class1.getSuperclass() != null)
        {
            l = i + getMethodCountForName(class1.getSuperclass(), s);
        }
        return l;
    }

    public static transient Method getMethodIfAvailable(Class class1, String s, Class aclass[])
    {
        Assert.notNull(class1, "Class must not be null");
        Assert.notNull(s, "Method name must not be null");
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static String getPackageName(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        class1 = class1.getName();
        int i = class1.lastIndexOf('.');
        if (i != -1)
        {
            return class1.substring(0, i);
        } else
        {
            return "";
        }
    }

    public static String getQualifiedMethodName(Method method)
    {
        Assert.notNull(method, "Method must not be null");
        return (new StringBuilder()).append(method.getDeclaringClass().getName()).append(".").append(method.getName()).toString();
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

    public static String getShortName(Class class1)
    {
        return getShortName(getQualifiedName(class1));
    }

    public static String getShortName(String s)
    {
        Assert.hasLength(s, "Class name must not be empty");
        int k = s.lastIndexOf('.');
        int j = s.indexOf("$$");
        int i = j;
        if (j == -1)
        {
            i = s.length();
        }
        return s.substring(k + 1, i).replace('$', '.');
    }

    public static transient Method getStaticMethod(Class class1, String s, Class aclass[])
    {
        Assert.notNull(class1, "Class must not be null");
        Assert.notNull(s, "Method name must not be null");
        boolean flag;
        try
        {
            class1 = class1.getMethod(s, aclass);
            flag = Modifier.isStatic(class1.getModifiers());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        if (flag)
        {
            return class1;
        } else
        {
            return null;
        }
    }

    public static Class getUserClass(Class class1)
    {
        if (class1 != null && class1.getName().contains("$$"))
        {
            Class class2 = class1.getSuperclass();
            if (class2 != null && !java/lang/Object.equals(class2))
            {
                return class2;
            }
        }
        return class1;
    }

    public static Class getUserClass(Object obj)
    {
        Assert.notNull(obj, "Instance must not be null");
        return getUserClass(obj.getClass());
    }

    public static boolean hasAtLeastOneMethodWithName(Class class1, String s)
    {
        Object aobj[];
        int i;
        int j;
        Assert.notNull(class1, "Class must not be null");
        Assert.notNull(s, "Method name must not be null");
        aobj = class1.getDeclaredMethods();
        j = aobj.length;
        i = 0;
_L9:
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (!aobj[i].getName().equals(s)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        aobj = class1.getInterfaces();
        j = aobj.length;
        i = 0;
_L6:
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (hasAtLeastOneMethodWithName(aobj[i], s)) goto _L3; else goto _L5
_L5:
        i++;
          goto _L6
        if (class1.getSuperclass() != null && hasAtLeastOneMethodWithName(class1.getSuperclass(), s)) goto _L3; else goto _L7
_L7:
        return false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static transient boolean hasConstructor(Class class1, Class aclass[])
    {
        return getConstructorIfAvailable(class1, aclass) != null;
    }

    public static transient boolean hasMethod(Class class1, String s, Class aclass[])
    {
        return getMethodIfAvailable(class1, s, aclass) != null;
    }

    public static boolean isAssignable(Class class1, Class class2)
    {
        Assert.notNull(class1, "Left-hand side type must not be null");
        Assert.notNull(class2, "Right-hand side type must not be null");
        if (!class1.isAssignableFrom(class2)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!class1.isPrimitive()) goto _L4; else goto _L3
_L3:
        if ((class2 = (Class)primitiveWrapperTypeMap.get(class2)) != null && class1.equals(class2)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        class2 = (Class)primitiveTypeToWrapperMap.get(class2);
        if (class2 != null && class1.isAssignableFrom(class2))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public static boolean isAssignableValue(Class class1, Object obj)
    {
        Assert.notNull(class1, "Type must not be null");
        if (obj != null)
        {
            return isAssignable(class1, obj.getClass());
        }
        return !class1.isPrimitive();
    }

    public static boolean isCacheSafe(Class class1, ClassLoader classloader)
    {
        ClassLoader classloader1;
        Assert.notNull(class1, "Class must not be null");
        classloader1 = class1.getClassLoader();
        if (classloader1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        class1 = classloader;
        if (classloader == classloader1)
        {
            return true;
        }
        do
        {
            if (class1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            classloader = class1.getParent();
            class1 = classloader;
        } while (classloader != classloader1);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isPresent(String s)
    {
        return isPresent(s, getDefaultClassLoader());
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

    public static boolean isPrimitiveArray(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        return class1.isArray() && class1.getComponentType().isPrimitive();
    }

    public static boolean isPrimitiveOrWrapper(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        return class1.isPrimitive() || isPrimitiveWrapper(class1);
    }

    public static boolean isPrimitiveWrapper(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        return primitiveWrapperTypeMap.containsKey(class1);
    }

    public static boolean isPrimitiveWrapperArray(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        return class1.isArray() && isPrimitiveWrapper(class1.getComponentType());
    }

    public static boolean isVisible(Class class1, ClassLoader classloader)
    {
        if (classloader != null)
        {
            try
            {
                classloader = classloader.loadClass(class1.getName());
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                return false;
            }
            if (class1 != classloader)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean matchesTypeName(Class class1, String s)
    {
        return s != null && (s.equals(class1.getName()) || s.equals(class1.getSimpleName()) || class1.isArray() && s.equals(getQualifiedNameForArray(class1)));
    }

    public static ClassLoader overrideThreadContextClassLoader(ClassLoader classloader)
    {
        Thread thread = Thread.currentThread();
        ClassLoader classloader1 = thread.getContextClassLoader();
        if (classloader != null && !classloader.equals(classloader1))
        {
            thread.setContextClassLoader(classloader);
            return classloader1;
        } else
        {
            return null;
        }
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

    public static Class resolveClassName(String s, ClassLoader classloader)
        throws IllegalArgumentException
    {
        try
        {
            classloader = forName(s, classloader);
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot find class [").append(s).append("]").toString(), classloader);
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error loading class [").append(s).append("]: problem with class file or dependent class.").toString(), classloader);
        }
        return classloader;
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

    public static Class resolvePrimitiveIfNecessary(Class class1)
    {
        Assert.notNull(class1, "Class must not be null");
        if (class1.isPrimitive() && class1 != Void.TYPE)
        {
            return (Class)primitiveTypeToWrapperMap.get(class1);
        } else
        {
            return class1;
        }
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
