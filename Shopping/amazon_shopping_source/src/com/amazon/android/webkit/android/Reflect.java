// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect
{

    private Reflect()
    {
    }

    public static Class getOptionalClass(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static transient Method getOptionalMethod(Class class1, String s, Class aclass[])
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
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static Class getRequiredClass(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public static transient Method getRequiredMethod(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getMethod(s, aclass);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static Field getRequiredPrivateField(Class class1, String s)
    {
        try
        {
            class1 = class1.getDeclaredField(s);
            class1.setAccessible(true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static transient Method getRequiredPrivateMethod(Class class1, String s, Class aclass[])
    {
        try
        {
            class1 = class1.getDeclaredMethod(s, aclass);
            class1.setAccessible(true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError(class1);
        }
        return class1;
    }

    public static transient Object invokeMethod(Method method, Object obj, Object aobj[])
    {
        try
        {
            method = ((Method) (method.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new AssertionError(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new AssertionError(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            obj = method.getCause();
            if (obj instanceof Error)
            {
                throw (Error)obj;
            }
            if (obj instanceof RuntimeException)
            {
                throw (RuntimeException)obj;
            } else
            {
                throw new AssertionError(method);
            }
        }
        return method;
    }
}
