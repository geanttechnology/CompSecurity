// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class mk
{

    private static final String a = mk.getSimpleName();
    private static final Object b;
    private static final Method c;

    private mk()
    {
    }

    private static Class a(String s)
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
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static transient Object a(Method method, Object obj, Object aobj[])
    {
        try
        {
            method = ((Method) (method.invoke(obj, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            return null;
        }
        return method;
    }

    private static transient Method a(Class class1, String s, Class aclass[])
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

    private static Method a(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return a(obj.getClass(), "setFlashlightEnabled", new Class[] {
                Boolean.TYPE
            });
        }
    }

    static void a()
    {
        a(false);
    }

    private static void a(boolean flag)
    {
        if (b != null)
        {
            a(c, b, new Object[] {
                Boolean.valueOf(flag)
            });
        }
    }

    private static Object b()
    {
        Object obj = a("android.os.ServiceManager");
        Object obj1;
        if (obj != null)
        {
            if ((obj = a(((Class) (obj)), "getService", new Class[] {
    java/lang/String
})) != null && (obj = a(((Method) (obj)), null, new Object[] {
    "hardware"
})) != null && (obj1 = a("android.os.IHardwareService$Stub")) != null && (obj1 = a(((Class) (obj1)), "asInterface", new Class[] {
    android/os/IBinder
})) != null)
            {
                return a(((Method) (obj1)), null, new Object[] {
                    obj
                });
            }
        }
        return null;
    }

    static 
    {
        b = b();
        c = a(b);
        if (b == null)
        {
            kf.a(a, "This device does supports control of a flashlight");
        } else
        {
            kf.a(a, "This device does not support control of a flashlight");
        }
    }
}
