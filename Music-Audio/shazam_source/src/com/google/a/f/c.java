// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import com.google.a.a.h;
import com.google.a.c.ad;
import com.google.a.c.aj;
import com.google.a.c.ao;
import com.google.a.c.ap;
import com.google.a.c.aq;
import com.google.a.c.aw;
import com.google.a.c.bk;
import com.google.a.c.r;
import com.google.a.c.u;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.f:
//            a, b, e, d

public abstract class com.google.a.f.c extends com.google.a.f.a
    implements Serializable
{
    private static final class a extends com.google.a.f.c
    {

        a(Type type)
        {
            super(type, (byte)0);
        }
    }

    private static abstract class b
    {

        static final b a = new b() {

            final Class a(Object obj)
            {
                return com.google.a.f.c.c(((com.google.a.f.c)obj).a);
            }

            final Iterable b(Object obj)
            {
                obj = (com.google.a.f.c)obj;
                if (((com.google.a.f.c) (obj)).a instanceof TypeVariable)
                {
                    return com.google.a.f.c.a(((TypeVariable)((com.google.a.f.c) (obj)).a).getBounds());
                }
                if (((com.google.a.f.c) (obj)).a instanceof WildcardType)
                {
                    return com.google.a.f.c.a(((WildcardType)((com.google.a.f.c) (obj)).a).getUpperBounds());
                }
                com.google.a.c.ad.a a1 = ad.g();
                Type atype[] = com.google.a.f.c.c(((com.google.a.f.c) (obj)).a).getGenericInterfaces();
                int j = atype.length;
                for (int i = 0; i < j; i++)
                {
                    a1.c(((com.google.a.f.c) (obj)).a(atype[i]));
                }

                return a1.a();
            }

            final Object c(Object obj)
            {
                obj = (com.google.a.f.c)obj;
                if (((com.google.a.f.c) (obj)).a instanceof TypeVariable)
                {
                    return com.google.a.f.c.b(((TypeVariable)((com.google.a.f.c) (obj)).a).getBounds()[0]);
                }
                if (((com.google.a.f.c) (obj)).a instanceof WildcardType)
                {
                    return com.google.a.f.c.b(((WildcardType)((com.google.a.f.c) (obj)).a).getUpperBounds()[0]);
                }
                Type type = com.google.a.f.c.c(((com.google.a.f.c) (obj)).a).getGenericSuperclass();
                if (type == null)
                {
                    return null;
                } else
                {
                    return ((com.google.a.f.c) (obj)).a(type);
                }
            }

        };
        static final b b = new b() {

            final volatile Class a(Object obj)
            {
                return (Class)obj;
            }

            final Iterable b(Object obj)
            {
                return Arrays.asList(((Class)obj).getInterfaces());
            }

            final Object c(Object obj)
            {
                return ((Class)obj).getSuperclass();
            }

        };

        private int a(Object obj, Map map)
        {
            Object obj1 = (Integer)map.get(this);
            if (obj1 != null)
            {
                return ((Integer) (obj1)).intValue();
            }
            int i;
            if (a(obj).isInterface())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            for (obj1 = b(obj).iterator(); ((Iterator) (obj1)).hasNext();)
            {
                i = Math.max(i, a(((Iterator) (obj1)).next(), map));
            }

            obj1 = c(obj);
            int j = i;
            if (obj1 != null)
            {
                j = Math.max(i, a(obj1, map));
            }
            map.put(obj, Integer.valueOf(j + 1));
            return j + 1;
        }

        final ad a(Iterable iterable)
        {
            java.util.HashMap hashmap = aq.a();
            for (iterable = iterable.iterator(); iterable.hasNext(); a(iterable.next(), ((Map) (hashmap)))) { }
            aw aw1 = new aw(aw.b().a(), hashmap) {

                final Comparator a;
                final Map b;

                public final int compare(Object obj, Object obj1)
                {
                    return a.compare(b.get(obj), b.get(obj1));
                }

            
            {
                a = comparator;
                b = map;
                super();
            }
            };
            iterable = hashmap.keySet();
            int j;
            if (iterable instanceof Collection)
            {
                iterable = (Collection)iterable;
            } else
            {
                Iterator iterator = iterable.iterator();
                iterable = new ArrayList();
                ap.a(iterable, iterator);
            }
            iterable = ((Iterable) ((Object[])iterable.toArray()));
            j = iterable.length;
            for (int i = 0; i < j; i++)
            {
                g.a(iterable[i]);
            }

            Arrays.sort(iterable, aw1);
            return ad.b(iterable);
        }

        abstract Class a(Object obj);

        abstract Iterable b(Object obj);

        abstract Object c(Object obj);


        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static abstract class c extends Enum
        implements h
    {

        public static final c a;
        public static final c b;
        private static final c c[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/google/a/f/c$c, s);
        }

        public static c[] values()
        {
            return (c[])c.clone();
        }

        static 
        {
            a = new c("IGNORE_TYPE_VARIABLE_OR_WILDCARD") {

                public final volatile boolean a(Object obj)
                {
                    obj = (com.google.a.f.c)obj;
                    return !(((com.google.a.f.c) (obj)).a instanceof TypeVariable) && !(((com.google.a.f.c) (obj)).a instanceof WildcardType);
                }

            };
            b = new c("INTERFACE_ONLY") {

                public final boolean a(Object obj)
                {
                    return com.google.a.f.c.c(((com.google.a.f.c)obj).a).isInterface();
                }

            };
            c = (new c[] {
                a, b
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }

        c(String s, int i, byte byte0)
        {
            this(s, i);
        }
    }

    public final class d extends u
        implements Serializable
    {

        final com.google.a.f.c a;
        private transient aj b;

        protected final Collection a()
        {
            return c();
        }

        protected final Object b()
        {
            return c();
        }

        protected final Set c()
        {
            aj aj1 = b;
            Object obj = aj1;
            if (aj1 == null)
            {
                obj = r.a(b.a.a(ad.a(a)));
                c c1 = c.a;
                obj = aj.a(r.a(ao.a(((r) (obj)).a, c1)).a);
                b = ((aj) (obj));
            }
            return ((Set) (obj));
        }

        public final Set d()
        {
            return aj.a(b.b.a(com.google.a.f.c.d(a.a)));
        }

        d()
        {
            a = com.google.a.f.c.this;
            super();
        }
    }


    final Type a;
    private transient com.google.a.f.b b;

    protected com.google.a.f.c()
    {
        a = a();
        boolean flag;
        if (!(a instanceof TypeVariable))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.b(flag, "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", new Object[] {
            a
        });
    }

    private com.google.a.f.c(Type type)
    {
        a = (Type)g.a(type);
    }

    com.google.a.f.c(Type type, byte byte0)
    {
        this(type);
    }

    static ad a(Type atype[])
    {
        com.google.a.c.ad.a a1 = ad.g();
        int j = atype.length;
        for (int i = 0; i < j; i++)
        {
            com.google.a.f.c c1 = e(atype[i]);
            if (c(c1.a).isInterface())
            {
                a1.c(c1);
            }
        }

        return a1.a();
    }

    public static com.google.a.f.c a(Class class1)
    {
        return new a(class1);
    }

    static com.google.a.f.c b(Type type)
    {
        com.google.a.f.c c1 = e(type);
        type = c1;
        if (c(c1.a).isInterface())
        {
            type = null;
        }
        return type;
    }

    static Class c(Type type)
    {
        return (Class)d(type).a().next();
    }

    static aj d(Type type)
    {
        g.a(type);
        com.google.a.c.aj.a a1 = aj.h();
        (new com.google.a.f.d(a1) {

            final com.google.a.c.aj.a a;

            final void a(Class class1)
            {
                a.c(class1);
            }

            final void a(GenericArrayType genericarraytype)
            {
                a.c(com.google.a.f.e.a(com.google.a.f.c.c(genericarraytype.getGenericComponentType())));
            }

            final void a(ParameterizedType parameterizedtype)
            {
                a.c((Class)parameterizedtype.getRawType());
            }

            final void a(TypeVariable typevariable)
            {
                a(typevariable.getBounds());
            }

            final void a(WildcardType wildcardtype)
            {
                a(wildcardtype.getUpperBounds());
            }

            
            {
                a = a1;
                super();
            }
        }).a(new Type[] {
            type
        });
        return a1.a();
    }

    private static com.google.a.f.c e(Type type)
    {
        return new a(type);
    }

    final com.google.a.f.c a(Type type)
    {
        g.a(type);
        com.google.a.f.b b2 = b;
        com.google.a.f.b b1 = b2;
        if (b2 == null)
        {
            Object obj = a;
            b1 = new com.google.a.f.b();
            obj = com.google.a.f.b.a.a(((Type) (obj)));
            b1 = new com.google.a.f.b(b1.a.a(((Map) (obj))));
            b = b1;
        }
        type = e(b1.a(type));
        type.b = b;
        return type;
    }

    public final d b()
    {
        return new d();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof com.google.a.f.c)
        {
            obj = (com.google.a.f.c)obj;
            return a.equals(((com.google.a.f.c) (obj)).a);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public String toString()
    {
        return com.google.a.f.e.b(a);
    }
}
