// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class n
{

    public n()
    {
    }

    public static n a()
    {
        Object obj;
        try
        {
            obj = Class.forName("sun.misc.Unsafe");
            Object obj3 = ((Class) (obj)).getDeclaredField("theUnsafe");
            ((Field) (obj3)).setAccessible(true);
            obj3 = ((Field) (obj3)).get(null);
            obj = new n(((Class) (obj)).getMethod("allocateInstance", new Class[] {
                java/lang/Class
            }), obj3) {

                private Method a;
                private Object b;

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
                obj1 = java/io/ObjectInputStream.getDeclaredMethod("newInstance", new Class[] {
                    java/lang/Class, java/lang/Class
                });
                ((Method) (obj1)).setAccessible(true);
                obj1 = new n(((Method) (obj1))) {

                    private Method a;

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
            catch (Exception exception1)
            {
                Object obj2;
                try
                {
                    obj2 = java/io/ObjectStreamClass.getDeclaredMethod("getConstructorId", new Class[] {
                        java/lang/Class
                    });
                    ((Method) (obj2)).setAccessible(true);
                    int i = ((Integer)((Method) (obj2)).invoke(null, new Object[] {
                        java/lang/Object
                    })).intValue();
                    obj2 = java/io/ObjectStreamClass.getDeclaredMethod("newInstance", new Class[] {
                        java/lang/Class, Integer.TYPE
                    });
                    ((Method) (obj2)).setAccessible(true);
                    obj2 = new n(((Method) (obj2)), i) {

                        private Method a;
                        private int b;

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
                catch (Exception exception2)
                {
                    return new n() {

                        public final Object a(Class class1)
                        {
                            throw new UnsupportedOperationException((new StringBuilder("Cannot allocate ")).append(class1).toString());
                        }

                    };
                }
                return ((n) (obj2));
            }
            return ((n) (obj1));
        }
        return ((n) (obj));
    }

    public abstract Object a(Class class1);
}
