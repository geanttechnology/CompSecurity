// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect

private static class originalClass
    implements InvocationHandler
{

    private Class originalClass;
    private Object receiver;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        obj = originalClass.getMethod(method.getName(), method.getParameterTypes());
        try
        {
            obj = ((Method) (obj)).invoke(receiver, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw ((InvocationTargetException) (obj)).getCause();
        }
        return obj;
    }

    public (Class class1, Object obj)
    {
        receiver = obj;
        originalClass = obj.getClass();
        obj = class1.getMethods();
        int j = obj.length;
        int i = 0;
        while (i < j) 
        {
            class1 = obj[i];
            try
            {
                originalClass.getMethod(class1.getName(), class1.getParameterTypes());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ClassCastException((new StringBuilder()).append("Type ").append(originalClass).append(" does not allow access to the method ").append(class1).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ClassCastException((new StringBuilder()).append("Type ").append(originalClass).append(" does not have the method ").append(class1).toString());
            }
            i++;
        }
    }
}
