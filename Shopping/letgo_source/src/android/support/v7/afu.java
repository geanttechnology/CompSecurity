// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            agq, aew, afz, afy, 
//            agc, afb

public final class afu
{

    private final Map a;

    public afu(Map map)
    {
        a = map;
    }

    private afz a(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new afz(class1) {

                final Constructor a;
                final afu b;

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
                b = afu.this;
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

    private afz a(Type type, Class class1)
    {
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new TreeSet();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            }
            if (java/util/EnumSet.isAssignableFrom(class1))
            {
                return new afz(type) {

                    final Type a;
                    final afu b;

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
                                throw new afb((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
                            }
                        } else
                        {
                            throw new afb((new StringBuilder()).append("Invalid EnumSet type: ").append(a.toString()).toString());
                        }
                    }

            
            {
                b = afu.this;
                a = type;
                super();
            }
                };
            }
            if (java/util/Set.isAssignableFrom(class1))
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new LinkedHashSet();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            }
            if (java/util/Queue.isAssignableFrom(class1))
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new LinkedList();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            } else
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new ArrayList();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            }
        }
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (java/util/SortedMap.isAssignableFrom(class1))
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new TreeMap();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            }
            if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(agq.a(((ParameterizedType)type).getActualTypeArguments()[0]).a()))
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new LinkedHashMap();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            } else
            {
                return new afz() {

                    final afu a;

                    public Object a()
                    {
                        return new afy();
                    }

            
            {
                a = afu.this;
                super();
            }
                };
            }
        } else
        {
            return null;
        }
    }

    private afz b(Type type, Class class1)
    {
        return new afz(class1, type) {

            final Class a;
            final Type b;
            final afu c;
            private final agc d = agc.a();

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
                c = afu.this;
                a = class1;
                b = type;
                super();
            }
        };
    }

    public afz a(agq agq1)
    {
        Type type = agq1.b();
        Class class1 = agq1.a();
        agq1 = (aew)a.get(type);
        if (agq1 != null)
        {
            agq1 = new afz(agq1, type) {

                final aew a;
                final Type b;
                final afu c;

                public Object a()
                {
                    return a.a(b);
                }

            
            {
                c = afu.this;
                a = aew1;
                b = type;
                super();
            }
            };
        } else
        {
            agq1 = (aew)a.get(class1);
            if (agq1 != null)
            {
                return new afz(agq1, type) {

                    final aew a;
                    final Type b;
                    final afu c;

                    public Object a()
                    {
                        return a.a(b);
                    }

            
            {
                c = afu.this;
                a = aew1;
                b = type;
                super();
            }
                };
            }
            afz afz = a(class1);
            agq1 = afz;
            if (afz == null)
            {
                afz afz1 = a(type, class1);
                agq1 = afz1;
                if (afz1 == null)
                {
                    return b(type, class1);
                }
            }
        }
        return agq1;
    }

    public String toString()
    {
        return a.toString();
    }
}
