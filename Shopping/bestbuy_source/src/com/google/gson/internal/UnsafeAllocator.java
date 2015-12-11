// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator
{

    public UnsafeAllocator()
    {
    }

    public static UnsafeAllocator create()
    {
        Object obj;
        try
        {
            obj = Class.forName("sun.misc.Unsafe");
            Object obj1 = ((Class) (obj)).getDeclaredField("theUnsafe");
            ((Field) (obj1)).setAccessible(true);
            obj1 = ((Field) (obj1)).get(null);
            obj = new UnsafeAllocator() {

                final Method val$allocateInstance;
                final Object val$unsafe;

                public Object newInstance(Class class1)
                {
                    return allocateInstance.invoke(unsafe, new Object[] {
                        class1
                    });
                }

            
            {
                allocateInstance = method;
                unsafe = obj;
                super();
            }
            };
        }
        catch (Exception exception)
        {
            final Method newInstance;
            try
            {
                newInstance = java/io/ObjectStreamClass.getDeclaredMethod("getConstructorId", new Class[] {
                    java/lang/Class
                });
                newInstance.setAccessible(true);
                final int constructorId = ((Integer)newInstance.invoke(null, new Object[] {
                    java/lang/Object
                })).intValue();
                newInstance = java/io/ObjectStreamClass.getDeclaredMethod("newInstance", new Class[] {
                    java/lang/Class, Integer.TYPE
                });
                newInstance.setAccessible(true);
                newInstance = new UnsafeAllocator() {

                    final int val$constructorId;
                    final Method val$newInstance;

                    public Object newInstance(Class class1)
                    {
                        return newInstance.invoke(null, new Object[] {
                            class1, Integer.valueOf(constructorId)
                        });
                    }

            
            {
                newInstance = method;
                constructorId = i;
                super();
            }
                };
            }
            catch (Exception exception1)
            {
                try
                {
                    exception1 = java/io/ObjectInputStream.getDeclaredMethod("newInstance", new Class[] {
                        java/lang/Class, java/lang/Class
                    });
                    exception1.setAccessible(true);
                    exception1 = new UnsafeAllocator() {

                        final Method val$newInstance;

                        public Object newInstance(Class class1)
                        {
                            return newInstance.invoke(null, new Object[] {
                                class1, java/lang/Object
                            });
                        }

            
            {
                newInstance = method;
                super();
            }
                    };
                }
                catch (Exception exception2)
                {
                    return new UnsafeAllocator() {

                        public Object newInstance(Class class1)
                        {
                            throw new UnsupportedOperationException((new StringBuilder()).append("Cannot allocate ").append(class1).toString());
                        }

                    };
                }
                return exception1;
            }
            return newInstance;
        }
        return ((UnsafeAllocator) (obj));
    }

    public abstract Object newInstance(Class class1);
}
