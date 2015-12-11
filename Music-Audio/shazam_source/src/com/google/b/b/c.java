// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import com.google.b.c.a;
import com.google.b.h;
import com.google.b.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.google.b.b:
//            h, g, k

public final class c
{

    private final Map a;

    public c(Map map)
    {
        a = map;
    }

    private com.google.b.b.h a(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new com.google.b.b.h(class1) {

                final Constructor a;
                final c b;

                public final Object a()
                {
                    Object obj;
                    try
                    {
                        obj = a.newInstance(null);
                    }
                    catch (InstantiationException instantiationexception)
                    {
                        throw new RuntimeException((new StringBuilder("Failed to invoke ")).append(a).append(" with no args").toString(), instantiationexception);
                    }
                    catch (InvocationTargetException invocationtargetexception)
                    {
                        throw new RuntimeException((new StringBuilder("Failed to invoke ")).append(a).append(" with no args").toString(), invocationtargetexception.getTargetException());
                    }
                    catch (IllegalAccessException illegalaccessexception)
                    {
                        throw new AssertionError(illegalaccessexception);
                    }
                    return obj;
                }

            
            {
                b = c.this;
                a = constructor;
                super();
            }
            };
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public final com.google.b.b.h a(a a1)
    {
        Type type = a1.b;
        Class class1 = a1.a;
        a1 = (h)a.get(type);
        Object obj;
        if (a1 != null)
        {
            obj = new com.google.b.b.h(a1, type) {

                final h a;
                final Type b;
                final c c;

                public final Object a()
                {
                    return a.a();
                }

            
            {
                c = c.this;
                a = h1;
                b = type;
                super();
            }
            };
        } else
        {
            a1 = (h)a.get(class1);
            if (a1 != null)
            {
                return new com.google.b.b.h(a1, type) {

                    final h a;
                    final Type b;
                    final c c;

                    public final Object a()
                    {
                        return a.a();
                    }

            
            {
                c = c.this;
                a = h1;
                b = type;
                super();
            }
                };
            }
            a1 = a(class1);
            obj = a1;
            if (a1 == null)
            {
                if (java/util/Collection.isAssignableFrom(class1))
                {
                    if (java/util/SortedSet.isAssignableFrom(class1))
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new TreeSet();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    } else
                    if (java/util/EnumSet.isAssignableFrom(class1))
                    {
                        a1 = new com.google.b.b.h(type) {

                            final Type a;
                            final c b;

                            public final Object a()
                            {
                                if (a instanceof ParameterizedType)
                                {
                                    Type type1 = ((ParameterizedType)a).getActualTypeArguments()[0];
                                    if (type1 instanceof Class)
                                    {
                                        return EnumSet.noneOf((Class)type1);
                                    } else
                                    {
                                        throw new m((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
                                    }
                                } else
                                {
                                    throw new m((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
                                }
                            }

            
            {
                b = c.this;
                a = type;
                super();
            }
                        };
                    } else
                    if (java/util/Set.isAssignableFrom(class1))
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new LinkedHashSet();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    } else
                    if (java/util/Queue.isAssignableFrom(class1))
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new LinkedList();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    } else
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new ArrayList();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    }
                } else
                if (java/util/Map.isAssignableFrom(class1))
                {
                    if (java/util/SortedMap.isAssignableFrom(class1))
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new TreeMap();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    } else
                    if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(com.google.b.c.a.a(((ParameterizedType)type).getActualTypeArguments()[0]).a))
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new LinkedHashMap();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    } else
                    {
                        a1 = new com.google.b.b.h() {

                            final c a;

                            public final Object a()
                            {
                                return new g();
                            }

            
            {
                a = c.this;
                super();
            }
                        };
                    }
                } else
                {
                    a1 = null;
                }
                obj = a1;
                if (a1 == null)
                {
                    return new com.google.b.b.h(class1, type) {

                        final Class a;
                        final Type b;
                        final c c;
                        private final k d = com.google.b.b.k.a();

                        public final Object a()
                        {
                            Object obj1;
                            try
                            {
                                obj1 = d.a(a);
                            }
                            catch (Exception exception)
                            {
                                throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(b).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
                            }
                            return obj1;
                        }

            
            {
                c = c.this;
                a = class1;
                b = type;
                super();
            }
                    };
                }
            }
        }
        return ((com.google.b.b.h) (obj));
    }

    public final String toString()
    {
        return a.toString();
    }
}
