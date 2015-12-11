// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

protected static class pointer extends ce
    implements ce
{

    Method method;
    Pointer pointer;

    public void deallocate()
    {
        try
        {
            method.invoke(null, new Object[] {
                pointer
            });
            pointer.setNull();
            return;
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }

    public ce(Pointer pointer1)
    {
        super(pointer1, null);
        pointer = null;
        method = null;
        deallocator = this;
        Object obj = pointer1.getClass();
        Method amethod[] = ((Class) (obj)).getDeclaredMethods();
        int j = amethod.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i < j)
                {
                    Method method1 = amethod[i];
                    Class aclass[] = method1.getParameterTypes();
                    if (!Modifier.isStatic(method1.getModifiers()) || !method1.getReturnType().equals(Void.TYPE) || !method1.getName().equals("deallocate") || aclass.length != 1 || !com/googlecode/javacpp/Pointer.isAssignableFrom(aclass[0]))
                    {
                        break label1;
                    }
                    method1.setAccessible(true);
                    method = method1;
                }
                if (method == null)
                {
                    throw new RuntimeException(new NoSuchMethodException((new StringBuilder()).append("static void ").append(((Class) (obj)).getCanonicalName()).append(".deallocate(").append(com/googlecode/javacpp/Pointer.getCanonicalName()).append(")").toString()));
                }
                break label0;
            }
            i++;
        } while (true);
        try
        {
            obj = ((Class) (obj)).getConstructor(new Class[] {
                com/googlecode/javacpp/Pointer
            });
            ((Constructor) (obj)).setAccessible(true);
            pointer = (Pointer)((Constructor) (obj)).newInstance(new Object[] {
                pointer1
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Pointer pointer1)
        {
            throw new RuntimeException(pointer1);
        }
    }
}
