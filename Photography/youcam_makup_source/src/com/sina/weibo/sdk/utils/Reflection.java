// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection
{

    public Reflection()
    {
    }

    public static Object getByArray(Object obj, int i)
    {
        return Array.get(obj, i);
    }

    public static Object getProperty(Object obj, String s)
    {
        return obj.getClass().getField(s).get(obj);
    }

    public static Object getStaticProperty(String s, String s1)
    {
        s = Class.forName(s);
        return s.getField(s1).get(s);
    }

    public static Object invokeMethod(Object obj, String s, Class aclass[], Object aobj[])
    {
        obj = obj.getClass().getMethod(s, aclass).invoke(obj, aobj);
        return obj;
        obj;
        ((SecurityException) (obj)).printStackTrace();
_L2:
        return null;
        obj;
        ((NoSuchMethodException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((IllegalArgumentException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((IllegalAccessException) (obj)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj;
        ((InvocationTargetException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Object invokeMethod(Object obj, String s, Object aobj[])
    {
        Class class1 = obj.getClass();
        Class aclass[] = new Class[aobj.length];
        int i = 0;
        int j = aobj.length;
        do
        {
            if (i >= j)
            {
                return class1.getMethod(s, aclass).invoke(obj, aobj);
            }
            aclass[i] = aobj[i].getClass();
            i++;
        } while (true);
    }

    public static Object invokeParamsMethod(Object obj, String s, Class aclass[], Object aobj[])
    {
        s = obj.getClass().getMethod(s, aclass);
        s.setAccessible(true);
        return s.invoke(obj, aobj);
    }

    public static Object invokeStaticMethod(Class class1, String s, Class aclass[], Object aobj[])
    {
        try
        {
            class1 = ((Class) (class1.getMethod(s, aclass).invoke(null, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            return null;
        }
        return class1;
    }

    public static Object invokeStaticMethod(String s, String s1, Class aclass[], Object aobj[])
    {
        try
        {
            s = ((String) (Class.forName(s).getMethod(s1, aclass).invoke(null, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static Object invokeStaticMethod(String s, String s1, Object aobj[])
    {
        s = Class.forName(s);
        Class aclass[] = new Class[aobj.length];
        int i = 0;
        int j = aobj.length;
        do
        {
            if (i >= j)
            {
                return s.getMethod(s1, aclass).invoke(null, aobj);
            }
            aclass[i] = aobj[i].getClass();
            i++;
        } while (true);
    }

    public static void invokeVoidMethod(Object obj, String s, boolean flag)
    {
        try
        {
            obj.getClass().getMethod(s, new Class[] {
                Boolean.TYPE
            }).invoke(obj, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    public static boolean isInstance(Object obj, Class class1)
    {
        return class1.isInstance(obj);
    }

    public static Object newInstance(String s, Class aclass[], Object aobj[])
    {
        return Class.forName(s).getConstructor(aclass).newInstance(aobj);
    }
}
