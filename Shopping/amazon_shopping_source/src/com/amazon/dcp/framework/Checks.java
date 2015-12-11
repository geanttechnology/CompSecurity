// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class Checks
{

    private Checks()
    {
    }

    public static transient void checkEquals(Comparable comparable, Comparable comparable1, Class class1, String s, Object aobj[])
        throws Throwable
    {
        while (comparable == null && comparable1 == null || comparable != null && comparable.compareTo(comparable1) == 0) 
        {
            return;
        }
        throwException(class1, s, aobj);
    }

    public static transient void checkFalse(boolean flag, Class class1, String s, Object aobj[])
        throws Throwable
    {
        if (flag)
        {
            throwException(class1, s, aobj);
        }
    }

    public static transient void checkNotEmpty(String s, Class class1, String s1, Object aobj[])
        throws Throwable
    {
        if (s == null || s.trim().isEmpty())
        {
            throwException(class1, s1, aobj);
        }
    }

    public static transient void checkNotEquals(Comparable comparable, Comparable comparable1, Class class1, String s, Object aobj[])
        throws Throwable
    {
        if (comparable == null && comparable1 == null || comparable != null && comparable.compareTo(comparable1) == 0)
        {
            throwException(class1, s, aobj);
        }
    }

    public static transient void checkNotNull(Object obj, Class class1, String s, Object aobj[])
        throws Throwable
    {
        if (obj == null)
        {
            throwException(class1, s, aobj);
        }
    }

    public static transient void checkTrue(boolean flag, Class class1, String s, Object aobj[])
        throws Throwable
    {
        if (!flag)
        {
            throwException(class1, s, aobj);
        }
    }

    private static transient void throwException(Class class1, String s, Object aobj[])
        throws Throwable
    {
        if (class1 == null)
        {
            throw new IllegalArgumentException("clazz may not be null");
        }
        try
        {
            throw (Throwable)class1.getConstructor(new Class[] {
                java/lang/String
            }).newInstance(new Object[] {
                String.format(s, aobj)
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        throw new IllegalStateException((new StringBuilder()).append("Failed to throw the requested exception: ").append(class1.getName()).toString(), s);
    }
}
