// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ReflectionUtils
{

    private ReflectionUtils()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    private static Object helper(Object obj, Class class1, String s, String s1, Class aclass[], Object aobj[])
    {
        Class class2 = class1;
        if (class1 != null) goto _L2; else goto _L1
_L1:
        if (obj == null) goto _L4; else goto _L3
_L3:
        class2 = obj.getClass();
_L2:
        return class2.getMethod(s1, aclass).invoke(obj, aobj);
_L4:
        class2 = Class.forName(s);
        if (true) goto _L2; else goto _L5
_L5:
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        throw new RuntimeException(((Throwable) (obj)));
    }

    static Object tryGetStaticField(String s, String s1)
    {
        try
        {
            s = ((String) (Class.forName(s).getField(s1).get(null)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    static Object tryInvokeConstructor(String s, Class aclass[], Object aobj[])
    {
        try
        {
            s = ((String) (Class.forName(s).getDeclaredConstructor(aclass).newInstance(aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    static Object tryInvokeInstance(Object obj, String s, Class aclass[], Object aobj[])
    {
        return helper(obj, null, null, s, aclass, aobj);
    }

    static Object tryInvokeStatic(Class class1, String s, Class aclass[], Object aobj[])
    {
        return helper(null, class1, null, s, aclass, aobj);
    }

    static Object tryInvokeStatic(String s, String s1, Class aclass[], Object aobj[])
    {
        return helper(null, null, s, s1, aclass, aobj);
    }
}
