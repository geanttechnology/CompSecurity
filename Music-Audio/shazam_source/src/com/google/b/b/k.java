// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class k
{

    public k()
    {
    }

    public static k a()
    {
        Object obj;
        try
        {
            obj = Class.forName("sun.misc.Unsafe");
            Object obj3 = ((Class) (obj)).getDeclaredField("theUnsafe");
            ((Field) (obj3)).setAccessible(true);
            obj3 = ((Field) (obj3)).get(null);
            obj = new k(((Class) (obj)).getMethod("allocateInstance", new Class[] {
                java/lang/Class
            }), obj3) {

                final Method a;
                final Object b;

                public final Object a(Class class1)
                {
                    return a.invoke(b, new Object[] {
                        class1
                    });
                }

            
            {
                a = method;
                b = obj;
                super();
            }
            };
        }
        catch (Exception exception)
        {
            Object obj1;
            try
            {
                obj1 = java/io/ObjectStreamClass.getDeclaredMethod("getConstructorId", new Class[] {
                    java/lang/Class
                });
                ((Method) (obj1)).setAccessible(true);
                int i = ((Integer)((Method) (obj1)).invoke(null, new Object[] {
                    java/lang/Object
                })).intValue();
                obj1 = java/io/ObjectStreamClass.getDeclaredMethod("newInstance", new Class[] {
                    java/lang/Class, Integer.TYPE
                });
                ((Method) (obj1)).setAccessible(true);
                obj1 = new k(((Method) (obj1)), i) {

                    final Method a;
                    final int b;

                    public final Object a(Class class1)
                    {
                        return a.invoke(null, new Object[] {
                            class1, Integer.valueOf(b)
                        });
                    }

            
            {
                a = method;
                b = i;
                super();
            }
                };
            }
            catch (Exception exception1)
            {
                Object obj2;
                try
                {
                    obj2 = java/io/ObjectInputStream.getDeclaredMethod("newInstance", new Class[] {
                        java/lang/Class, java/lang/Class
                    });
                    ((Method) (obj2)).setAccessible(true);
                    obj2 = new k(((Method) (obj2))) {

                        final Method a;

                        public final Object a(Class class1)
                        {
                            return a.invoke(null, new Object[] {
                                class1, java/lang/Object
                            });
                        }

            
            {
                a = method;
                super();
            }
                    };
                }
                catch (Exception exception2)
                {
                    return new k() {

                        public final Object a(Class class1)
                        {
                            throw new UnsupportedOperationException((new StringBuilder("Cannot allocate ")).append(class1).toString());
                        }

                    };
                }
                return ((k) (obj2));
            }
            return ((k) (obj1));
        }
        return ((k) (obj));
    }

    public abstract Object a(Class class1);
}
