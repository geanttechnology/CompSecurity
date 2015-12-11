// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.a.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f
{

    final Object a;
    final Method b;

    f(Object obj, Method method)
    {
        g.a(obj, "EventSubscriber target cannot be null.");
        g.a(method, "EventSubscriber method cannot be null.");
        a = obj;
        b = method;
        method.setAccessible(true);
    }

    public void a(Object obj)
    {
        g.a(obj);
        try
        {
            b.invoke(a, new Object[] {
                obj
            });
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            obj = String.valueOf(String.valueOf(obj));
            throw new Error((new StringBuilder(((String) (obj)).length() + 33)).append("Method rejected target/argument: ").append(((String) (obj))).toString(), illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            obj = String.valueOf(String.valueOf(obj));
            throw new Error((new StringBuilder(((String) (obj)).length() + 28)).append("Method became inaccessible: ").append(((String) (obj))).toString(), illegalaccessexception);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (((InvocationTargetException) (obj)).getCause() instanceof Error)
        {
            throw (Error)((InvocationTargetException) (obj)).getCause();
        } else
        {
            throw obj;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof f)
        {
            obj = (f)obj;
            flag = flag1;
            if (a == ((f) (obj)).a)
            {
                flag = flag1;
                if (b.equals(((f) (obj)).b))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (b.hashCode() + 31) * 31 + System.identityHashCode(a);
    }

    public String toString()
    {
        String s = String.valueOf(String.valueOf(b));
        return (new StringBuilder(s.length() + 10)).append("[wrapper ").append(s).append("]").toString();
    }
}
