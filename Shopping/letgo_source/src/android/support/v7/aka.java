// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aka
{

    final Object a;
    private final Method b;
    private final int c;
    private boolean d;

    aka(Object obj, Method method)
    {
        d = true;
        if (obj == null)
        {
            throw new NullPointerException("EventProducer target cannot be null.");
        }
        if (method == null)
        {
            throw new NullPointerException("EventProducer method cannot be null.");
        } else
        {
            a = obj;
            b = method;
            method.setAccessible(true);
            c = (method.hashCode() + 31) * 31 + obj.hashCode();
            return;
        }
    }

    public boolean a()
    {
        return d;
    }

    public void b()
    {
        d = false;
    }

    public Object c()
        throws InvocationTargetException
    {
        if (!d)
        {
            throw new IllegalStateException((new StringBuilder()).append(toString()).append(" has been invalidated and can no longer produce events.").toString());
        }
        Object obj;
        try
        {
            obj = b.invoke(a, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            if (invocationtargetexception.getCause() instanceof Error)
            {
                throw (Error)invocationtargetexception.getCause();
            } else
            {
                throw invocationtargetexception;
            }
        }
        return obj;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (aka)obj;
            if (!b.equals(((aka) (obj)).b) || a != ((aka) (obj)).a)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return c;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[EventProducer ").append(b).append("]").toString();
    }
}
