// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import com.google.a.c.ae;
import com.google.a.c.aq;
import com.google.a.c.az;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.a.f:
//            e, d

public final class com.google.a.f.b
{
    private static final class a extends com.google.a.f.d
    {

        private static final d a = new d((byte)0);
        private final Map b = aq.a();

        static ae a(Type type)
        {
            a a1 = new a();
            a1.a(new Type[] {
                a.a(type)
            });
            return ae.a(a1.b);
        }

        final void a(Class class1)
        {
            a(new Type[] {
                class1.getGenericSuperclass()
            });
            a(class1.getGenericInterfaces());
        }

        final void a(ParameterizedType parameterizedtype)
        {
            Class class1 = (Class)parameterizedtype.getRawType();
            TypeVariable atypevariable[] = class1.getTypeParameters();
            Type atype[] = parameterizedtype.getActualTypeArguments();
            boolean flag;
            if (atypevariable.length == atype.length)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            g.b(flag);
label0:
            for (int i = 0; i < atypevariable.length; i++)
            {
                c c1 = new c(atypevariable[i]);
                Type type = atype[i];
                if (b.containsKey(c1))
                {
                    continue;
                }
                for (Type type1 = type; type1 != null; type1 = (Type)b.get(c.a(type1)))
                {
                    if (c1.b(type1))
                    {
                        for (; type != null; type = (Type)b.remove(c.a(type))) { }
                        continue label0;
                    }
                }

                b.put(c1, type);
            }

            a(new Type[] {
                class1
            });
            a(new Type[] {
                parameterizedtype.getOwnerType()
            });
        }

        final void a(TypeVariable typevariable)
        {
            a(typevariable.getBounds());
        }

        final void a(WildcardType wildcardtype)
        {
            a(wildcardtype.getUpperBounds());
        }


        private a()
        {
        }
    }

    private static class b
    {

        private final ae a;

        final b a(Map map)
        {
            com.google.a.c.ae.a a1;
            a1 = ae.i();
            Object obj = a;
            a1.a(a1.b + ((Map) (obj)).size());
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a1.a(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                Object obj1 = (java.util.Map.Entry)map.next();
                c c1 = (c)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = (Type)((java.util.Map.Entry) (obj1)).getValue();
                boolean flag;
                if (!c1.b(((Type) (obj1))))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                g.a(flag, "Type variable %s bound to itself", new Object[] {
                    c1
                });
                a1.a(c1, obj1);
            }
            a1.b;
            JVM INSTR tableswitch 0 1: default 204
        //                       0 229
        //                       1 236;
               goto _L1 _L2 _L3
_L1:
            map = new az(a1.b, a1.a);
_L5:
            return new b(map);
_L2:
            map = ae.h();
            continue; /* Loop/switch isn't completed */
_L3:
            map = ae.b(a1.a[0].getKey(), a1.a[0].getValue());
            if (true) goto _L5; else goto _L4
_L4:
        }

        Type a(TypeVariable typevariable, b b1)
        {
            Type type;
            type = (Type)a.get(new c(typevariable));
            if (type != null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            type = typevariable.getBounds();
            if (type.length != 0) goto _L2; else goto _L1
_L1:
            return typevariable;
_L2:
            b1 = (new com.google.a.f.b(b1, (byte)0)).a(type);
            if (e.d.a && Arrays.equals(type, b1)) goto _L1; else goto _L3
_L3:
            return e.a(typevariable.getGenericDeclaration(), typevariable.getName(), b1);
            return (new com.google.a.f.b(b1, (byte)0)).a(type);
        }

        b()
        {
            a = ae.h();
        }

        private b(ae ae1)
        {
            a = ae1;
        }
    }

    static final class c
    {

        private final TypeVariable a;

        static Object a(Type type)
        {
            if (type instanceof TypeVariable)
            {
                return new c((TypeVariable)type);
            } else
            {
                return null;
            }
        }

        private boolean a(TypeVariable typevariable)
        {
            return a.getGenericDeclaration().equals(typevariable.getGenericDeclaration()) && a.getName().equals(typevariable.getName());
        }

        final boolean b(Type type)
        {
            if (type instanceof TypeVariable)
            {
                return a((TypeVariable)type);
            } else
            {
                return false;
            }
        }

        public final boolean equals(Object obj)
        {
            if (obj instanceof c)
            {
                return a(((c)obj).a);
            } else
            {
                return false;
            }
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                a.getGenericDeclaration(), a.getName()
            });
        }

        public final String toString()
        {
            return a.toString();
        }

        c(TypeVariable typevariable)
        {
            a = (TypeVariable)g.a(typevariable);
        }
    }

    private static final class d
    {

        private final AtomicInteger a;

        final Type a(Type type)
        {
            g.a(type);
            break MISSING_BLOCK_LABEL_5;
            if (!(type instanceof Class) && !(type instanceof TypeVariable))
            {
                if (type instanceof GenericArrayType)
                {
                    return e.a(a(((GenericArrayType)type).getGenericComponentType()));
                }
                if (type instanceof ParameterizedType)
                {
                    ParameterizedType parameterizedtype = (ParameterizedType)type;
                    type = parameterizedtype.getOwnerType();
                    Type atype[];
                    Class class1;
                    Type atype1[];
                    if (type == null)
                    {
                        type = null;
                    } else
                    {
                        type = a(type);
                    }
                    class1 = (Class)parameterizedtype.getRawType();
                    atype = parameterizedtype.getActualTypeArguments();
                    atype1 = new Type[atype.length];
                    for (int i = 0; i < atype.length; i++)
                    {
                        atype1[i] = a(atype[i]);
                    }

                    return e.a(type, class1, atype1);
                }
                if (type instanceof WildcardType)
                {
                    WildcardType wildcardtype = (WildcardType)type;
                    if (wildcardtype.getLowerBounds().length == 0)
                    {
                        type = wildcardtype.getUpperBounds();
                        int j = a.incrementAndGet();
                        type = String.valueOf(String.valueOf(com.google.a.a.d.a('&').a(Arrays.asList(type))));
                        return e.a(com/google/a/f/b$d, (new StringBuilder(type.length() + 33)).append("capture#").append(j).append("-of ? extends ").append(type).toString(), wildcardtype.getUpperBounds());
                    }
                } else
                {
                    throw new AssertionError("must have been one of the known types");
                }
            }
            return type;
        }

        private d()
        {
            a = new AtomicInteger();
        }

        d(byte byte0)
        {
            this();
        }
    }


    final b a;

    public com.google.a.f.b()
    {
        a = new b();
    }

    com.google.a.f.b(b b1)
    {
        a = b1;
    }

    com.google.a.f.b(b b1, byte byte0)
    {
        this(b1);
    }

    public final Type a(Type type)
    {
        g.a(type);
        Object obj;
        if (type instanceof TypeVariable)
        {
            obj = a;
            type = (TypeVariable)type;
            obj = ((b) (obj)).a(type, new b(((b) (obj)), type, ((b) (obj))) {

                final TypeVariable a;
                final b b;
                final b c;

                public final Type a(TypeVariable typevariable, b b1)
                {
                    if (typevariable.getGenericDeclaration().equals(a.getGenericDeclaration()))
                    {
                        return typevariable;
                    } else
                    {
                        return b.a(typevariable, b1);
                    }
                }

            
            {
                c = b1;
                a = typevariable;
                b = b2;
                super();
            }
            });
        } else
        {
            if (type instanceof ParameterizedType)
            {
                obj = (ParameterizedType)type;
                type = ((ParameterizedType) (obj)).getOwnerType();
                Type type1;
                if (type == null)
                {
                    type = null;
                } else
                {
                    type = a(type);
                }
                type1 = a(((ParameterizedType) (obj)).getRawType());
                obj = a(((ParameterizedType) (obj)).getActualTypeArguments());
                return e.a(type, (Class)type1, ((Type []) (obj)));
            }
            if (type instanceof GenericArrayType)
            {
                return e.a(a(((GenericArrayType)type).getGenericComponentType()));
            }
            obj = type;
            if (type instanceof WildcardType)
            {
                WildcardType wildcardtype = (WildcardType)type;
                type = wildcardtype.getLowerBounds();
                Type atype[] = wildcardtype.getUpperBounds();
                return new e.g(a(((Type []) (type))), a(atype));
            }
        }
        return ((Type) (obj));
    }

    final Type[] a(Type atype[])
    {
        Type atype1[] = new Type[atype.length];
        for (int i = 0; i < atype.length; i++)
        {
            atype1[i] = a(atype[i]);
        }

        return atype1;
    }
}
