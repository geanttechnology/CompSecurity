// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            ReflectionException

public final class ReflectionUtils
{

    private ReflectionUtils()
    {
    }

    public static Method getMethod(Class class1, String s)
    {
        try
        {
            class1 = class1.getMethod(s, new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static Method getMethod(Class class1, String s, Class aclass[])
    {
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

    public static List getStaticMethods(Class class1)
    {
        ArrayList arraylist = new ArrayList();
        class1 = class1.getMethods();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Method method = class1[i];
            if (Modifier.isStatic(method.getModifiers()))
            {
                arraylist.add(method);
            }
        }

        return Collections.unmodifiableList(arraylist);
    }

    private static Object helper(Object obj, String s, String s1, Class aclass[], Object aobj[])
        throws ReflectionException
    {
        {
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            Object obj1;
            try
            {
                obj = Class.forName(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ReflectionException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ReflectionException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ReflectionException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ReflectionException(((Throwable) (obj)));
            }
            obj1 = obj;
            s = ((String) (obj));
        }
        if (aclass != null)
        {
            break; /* Loop/switch isn't completed */
        }
        return getMethod(s, s1).invoke(obj1, new Object[0]);
        s = obj.getClass();
        obj1 = obj;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_14;
_L1:
        obj = getMethod(s, s1, aclass).invoke(obj1, aobj);
        return obj;
    }

    public static Object invokeMethod(Object obj, String s)
        throws ReflectionException
    {
        return helper(obj, null, s, null, null);
    }

    public static transient Object invokeMethod(Object obj, String s, Class aclass[], Object aobj[])
        throws ReflectionException
    {
        return helper(obj, null, s, aclass, aobj);
    }

    public static transient Object invokeStaticMethod(String s, String s1, Class aclass[], Object aobj[])
        throws ReflectionException
    {
        return helper(null, s, s1, aclass, aobj);
    }

    public static transient Object newInstance(String s, Class aclass[], Object aobj[])
        throws ReflectionException
    {
        if (aclass.length != aobj.length)
        {
            throw new ReflectionException("parameterTypes and parameterValues must have the same length");
        }
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        try
        {
            s = s.getConstructor(aclass);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        try
        {
            s = ((String) (s.newInstance(aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ReflectionException(s);
        }
        return s;
    }
}
