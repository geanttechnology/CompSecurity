// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.JsonIOException;
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

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            j, LinkedHashTreeMap, n

public final class a
{

    private final Map a;

    public a(Map map)
    {
        a = map;
    }

    private j a(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new j(class1) {

                private Constructor a;

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

    public final j a(myobfuscated.ap.a a1)
    {
        Type type = a1.b;
        Class class1 = a1.a;
        a1 = (com.melnykov.fab.a)a.get(type);
        Object obj;
        if (a1 != null)
        {
            obj = new j(a1, type) {

                private com.melnykov.fab.a a;

                public final Object a()
                {
                    return a.c();
                }

            
            {
                a = a1;
                super();
            }
            };
        } else
        {
            a1 = (com.melnykov.fab.a)a.get(class1);
            if (a1 != null)
            {
                return new j(a1, type) {

                    private com.melnykov.fab.a a;

                    public final Object a()
                    {
                        return a.c();
                    }

            
            {
                a = a1;
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
                        a1 = new j() {

                            public final Object a()
                            {
                                return new TreeSet();
                            }

                        };
                    } else
                    if (java/util/EnumSet.isAssignableFrom(class1))
                    {
                        a1 = new j(type) {

                            private Type a;

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
                                        throw new JsonIOException((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
                                    }
                                } else
                                {
                                    throw new JsonIOException((new StringBuilder("Invalid EnumSet type: ")).append(a.toString()).toString());
                                }
                            }

            
            {
                a = type;
                super();
            }
                        };
                    } else
                    if (java/util/Set.isAssignableFrom(class1))
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new LinkedHashSet();
                            }

                        };
                    } else
                    if (java/util/Queue.isAssignableFrom(class1))
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new LinkedList();
                            }

                        };
                    } else
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new ArrayList();
                            }

                        };
                    }
                } else
                if (java/util/Map.isAssignableFrom(class1))
                {
                    if (java/util/SortedMap.isAssignableFrom(class1))
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new TreeMap();
                            }

                        };
                    } else
                    if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(myobfuscated.ap.a.a(((ParameterizedType)type).getActualTypeArguments()[0]).a))
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new LinkedHashMap();
                            }

                        };
                    } else
                    {
                        a1 = new j() {

                            public final Object a()
                            {
                                return new LinkedHashTreeMap();
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
                    return new j(class1, type) {

                        private final n a = n.a();
                        private Class b;
                        private Type c;

                        public final Object a()
                        {
                            Object obj1;
                            try
                            {
                                obj1 = a.a(b);
                            }
                            catch (Exception exception)
                            {
                                throw new RuntimeException((new StringBuilder("Unable to invoke no-args constructor for ")).append(c).append(". Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
                            }
                            return obj1;
                        }

            
            {
                b = class1;
                c = type;
                super();
            }
                    };
                }
            }
        }
        return ((j) (obj));
    }

    public final String toString()
    {
        return a.toString();
    }
}
