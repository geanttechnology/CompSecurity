// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

final class bjj
    implements bjh
{

    private final WeakReference a;
    private final Method b;
    private final int c;

    bjj(Object obj, Method method)
    {
        b.a(obj);
        a = new WeakReference(obj);
        b = (Method)b.a(method);
        b.setAccessible(true);
        c = Arrays.hashCode(new Object[] {
            obj, b
        });
    }

    public final void a(Object obj)
    {
        Object obj1 = a.get();
        if (obj1 == null)
        {
            return;
        }
        try
        {
            b.invoke(obj1, new Object[] {
                obj
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((InvocationTargetException) (obj)).getCause());
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof bjj)
            {
                if (((bjj) (obj = (bjj)obj)).a.get() != a.get() || !b.equals(((bjj) (obj)).b))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return c;
    }
}
