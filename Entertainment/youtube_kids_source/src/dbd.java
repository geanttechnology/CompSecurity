// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class dbd
    implements Runnable
{

    private Method a;
    private Object b[];
    private Throwable c;
    private dbc d;

    dbd(dbc dbc1, Method method, Object aobj[], Throwable throwable)
    {
        d = dbc1;
        a = method;
        b = aobj;
        c = throwable;
        super();
    }

    public final void run()
    {
        Throwable throwable;
        try
        {
            a.invoke(d.a, b);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new IllegalStateException(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throwable = a.a(invocationtargetexception.getCause(), c);
        }
        if (throwable instanceof RuntimeException)
        {
            throw (RuntimeException)throwable;
        }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        } else
        {
            throw new IllegalStateException(throwable);
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ThreadChanger: ");
        stringbuilder.append(a.getDeclaringClass().getSimpleName()).append(".");
        stringbuilder.append(a.getName()).append("(");
        boolean flag = true;
        Class aclass[] = a.getParameterTypes();
        int j = aclass.length;
        int i = 0;
        while (i < j) 
        {
            Class class1 = aclass[i];
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(class1.getSimpleName());
            i++;
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }
}
