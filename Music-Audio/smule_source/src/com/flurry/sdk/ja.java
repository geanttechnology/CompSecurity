// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

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

// Referenced classes of package com.flurry.sdk:
//            jw, ic, jf, je, 
//            ji, ih

public final class ja
{

    private final Map a;

    public ja(Map map)
    {
        a = map;
    }

    private jf a(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new jf(class1) {

                final Constructor a;
                final ja b;

                public Object a()
                {
                    Object obj;
                    try
                    {
                        obj = a.newInstance(null);
                    }
                    catch (InstantiationException instantiationexception)
                    {
                        throw new RuntimeException((new StringBuilder()).append("Failed to invoke ").append(a).append(" with no args").toString(), instantiationexception);
                    }
                    catch (InvocationTargetException invocationtargetexception)
                    {
                        throw new RuntimeException((new StringBuilder()).append("Failed to invoke ").append(a).append(" with no args").toString(), invocationtargetexception.getTargetException());
                    }
                    catch (IllegalAccessException illegalaccessexception)
                    {
                        throw new AssertionError(illegalaccessexception);
                    }
                    return obj;
                }

            
            {
                b = ja.this;
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

    private jf a(Type type, Class class1)
    {
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new TreeSet();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            }
            if (java/util/EnumSet.isAssignableFrom(class1))
            {
                return new jf(type) {

                    final Type a;
                    final ja b;

                    public Object a()
                    {
                        if (a instanceof ParameterizedType)
                        {
                            Type type1 = ((ParameterizedType)a).getActualTypeArguments()[0];
                            if (type1 instanceof Class)
                            {
                                return EnumSet.noneOf((Class)type1);
                            } else
                            {
                                throw new ih((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
                            }
                        } else
                        {
                            throw new ih((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
                        }
                    }

            
            {
                b = ja.this;
                a = type;
                super();
            }
                };
            }
            if (java/util/Set.isAssignableFrom(class1))
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new LinkedHashSet();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            }
            if (java/util/Queue.isAssignableFrom(class1))
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new LinkedList();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            } else
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new ArrayList();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            }
        }
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (java/util/SortedMap.isAssignableFrom(class1))
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new TreeMap();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            }
            if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(jw.a(((ParameterizedType)type).getActualTypeArguments()[0]).a()))
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new LinkedHashMap();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            } else
            {
                return new jf() {

                    final ja a;

                    public Object a()
                    {
                        return new je();
                    }

            
            {
                a = ja.this;
                super();
            }
                };
            }
        } else
        {
            return null;
        }
    }

    private jf b(Type type, Class class1)
    {
        return new jf(class1, type) {

            final Class a;
            final Type b;
            final ja c;
            private final ji d = ji.a();

            public Object a()
            {
                Object obj;
                try
                {
                    obj = d.a(a);
                }
                catch (Exception exception)
                {
                    throw new RuntimeException((new StringBuilder()).append("Unable to invoke no-args constructor for ").append(b).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
                }
                return obj;
            }

            
            {
                c = ja.this;
                a = class1;
                b = type;
                super();
            }
        };
    }

    public jf a(jw jw1)
    {
        Type type = jw1.b();
        Class class1 = jw1.a();
        jw1 = (ic)a.get(type);
        if (jw1 != null)
        {
            jw1 = new jf(jw1, type) {

                final ic a;
                final Type b;
                final ja c;

                public Object a()
                {
                    return a.a(b);
                }

            
            {
                c = ja.this;
                a = ic1;
                b = type;
                super();
            }
            };
        } else
        {
            jw1 = (ic)a.get(class1);
            if (jw1 != null)
            {
                return new jf(jw1, type) {

                    final ic a;
                    final Type b;
                    final ja c;

                    public Object a()
                    {
                        return a.a(b);
                    }

            
            {
                c = ja.this;
                a = ic1;
                b = type;
                super();
            }
                };
            }
            jf jf = a(class1);
            jw1 = jf;
            if (jf == null)
            {
                jf jf1 = a(type, class1);
                jw1 = jf1;
                if (jf1 == null)
                {
                    return b(type, class1);
                }
            }
        }
        return jw1;
    }

    public String toString()
    {
        return a.toString();
    }
}
