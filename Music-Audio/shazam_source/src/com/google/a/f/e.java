// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.c;
import com.google.a.a.d;
import com.google.a.a.g;
import com.google.a.a.i;
import com.google.a.c.ad;
import com.google.a.c.ao;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.a.f:
//            a

final class com.google.a.f.e
{
    private static abstract class a extends Enum
    {

        public static final a a;
        public static final a b;
        static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/a/f/e$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        abstract Class a(Class class1);

        static 
        {
            int j = 0;
            a = new a("OWNED_BY_ENCLOSING_CLASS") {

                final Class a(Class class1)
                {
                    return class1.getEnclosingClass();
                }

            };
            b = new a("LOCAL_CLASS_HAS_NO_OWNER") {

                final Class a(Class class1)
                {
                    if (class1.isLocalClass())
                    {
                        return null;
                    } else
                    {
                        return class1.getEnclosingClass();
                    }
                }

            };
            d = (new a[] {
                a, b
            });
            ParameterizedType parameterizedtype = (ParameterizedType)(new a.a() {

            }).getClass().getGenericSuperclass();
            a aa[] = values();
            for (int k = aa.length; j < k; j++)
            {
                a a1 = aa[j];
                if (a1.a(com/google/a/f/e$a$a) == parameterizedtype.getOwnerType())
                {
                    c = a1;
                    return;
                }
            }

            throw new AssertionError();
        }

        private a(String s, int j)
        {
            super(s, j);
        }

        a(String s, int j, byte byte0)
        {
            this(s, j);
        }
    }

    class a.a
    {

        a.a()
        {
        }
    }

    private static final class b
        implements Serializable, GenericArrayType
    {

        private final Type a;

        public final boolean equals(Object obj)
        {
            if (obj instanceof GenericArrayType)
            {
                obj = (GenericArrayType)obj;
                return com.google.a.a.f.a(getGenericComponentType(), ((GenericArrayType) (obj)).getGenericComponentType());
            } else
            {
                return false;
            }
        }

        public final Type getGenericComponentType()
        {
            return a;
        }

        public final int hashCode()
        {
            return a.hashCode();
        }

        public final String toString()
        {
            return String.valueOf(com.google.a.f.e.b(a)).concat("[]");
        }

        b(Type type)
        {
            a = com.google.a.f.c.d.b(type);
        }
    }

    static abstract class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        static final c d;
        private static final c e[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/google/a/f/e$c, s);
        }

        public static c[] values()
        {
            return (c[])e.clone();
        }

        final ad a(Type atype[])
        {
            com.google.a.c.ad.a a1 = ad.g();
            int k = atype.length;
            for (int j = 0; j < k; j++)
            {
                a1.c(b(atype[j]));
            }

            return a1.a();
        }

        abstract Type a(Type type);

        abstract Type b(Type type);

        String c(Type type)
        {
            return com.google.a.f.e.b(type);
        }

        static 
        {
            a = new c("JAVA6") {

                final Type a(Type type)
                {
                    return new b(type);
                }

                final Type b(Type type)
                {
                    com.google.a.a.g.a(type);
                    Object obj = type;
                    if (type instanceof Class)
                    {
                        Class class1 = (Class)type;
                        obj = type;
                        if (class1.isArray())
                        {
                            obj = new b(class1.getComponentType());
                        }
                    }
                    return ((Type) (obj));
                }

            };
            b = new c("JAVA7") {

                final Type a(Type type)
                {
                    if (type instanceof Class)
                    {
                        return com.google.a.f.e.a((Class)type);
                    } else
                    {
                        return new b(type);
                    }
                }

                final Type b(Type type)
                {
                    return (Type)com.google.a.a.g.a(type);
                }

            };
            c = new c("JAVA8") {

                final Type a(Type type)
                {
                    return b.a(type);
                }

                final Type b(Type type)
                {
                    return b.b(type);
                }

                final String c(Type type)
                {
                    try
                    {
                        type = (String)java/lang/reflect/Type.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Type type)
                    {
                        throw new AssertionError("Type.getTypeName should be available in Java 8");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Type type)
                    {
                        throw new RuntimeException(type);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Type type)
                    {
                        throw new RuntimeException(type);
                    }
                    return type;
                }

            };
            e = (new c[] {
                a, b, c
            });
            if (java/lang/reflect/AnnotatedElement.isAssignableFrom(java/lang/reflect/TypeVariable))
            {
                d = c;
            } else
            if ((new com.google.a.f.a() {

    }).a() instanceof Class)
            {
                d = b;
            } else
            {
                d = a;
            }
        }

        private c(String s, int j)
        {
            super(s, j);
        }

        c(String s, int j, byte byte0)
        {
            this(s, j);
        }
    }

    static final class d
    {

        static final boolean a;

        static 
        {
            boolean flag = false;
            if (!com/google/a/f/e$d.getTypeParameters()[0].equals(com.google.a.f.e.a(com/google/a/f/e$d, "X", new Type[0])))
            {
                flag = true;
            }
            a = flag;
        }

        d()
        {
        }
    }

    private static final class e
        implements Serializable, ParameterizedType
    {

        private final Type a;
        private final ad b;
        private final Class c;

        public final boolean equals(Object obj)
        {
            if (obj instanceof ParameterizedType)
            {
                if (getRawType().equals(((ParameterizedType) (obj = (ParameterizedType)obj)).getRawType()) && com.google.a.a.f.a(getOwnerType(), ((ParameterizedType) (obj)).getOwnerType()) && Arrays.equals(getActualTypeArguments(), ((ParameterizedType) (obj)).getActualTypeArguments()))
                {
                    return true;
                }
            }
            return false;
        }

        public final Type[] getActualTypeArguments()
        {
            return com.google.a.f.e.a(b);
        }

        public final Type getOwnerType()
        {
            return a;
        }

        public final Type getRawType()
        {
            return c;
        }

        public final int hashCode()
        {
            int j;
            if (a == null)
            {
                j = 0;
            } else
            {
                j = a.hashCode();
            }
            return j ^ b.hashCode() ^ c.hashCode();
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (a != null)
            {
                stringbuilder.append(com.google.a.f.c.d.c(a)).append('.');
            }
            StringBuilder stringbuilder1 = stringbuilder.append(c.getName()).append('<');
            com.google.a.a.d d1 = com.google.a.f.e.b();
            ad ad1 = b;
            com.google.a.a.c c1 = com.google.a.f.e.a();
            com.google.a.a.g.a(ad1);
            com.google.a.a.g.a(c1);
            stringbuilder1.append(d1.a(new com.google.a.c.ao._cls2(ad1, c1))).append('>');
            return stringbuilder.toString();
        }

        e(Type type, Class class1, Type atype[])
        {
            com.google.a.a.g.a(class1);
            boolean flag;
            if (atype.length == class1.getTypeParameters().length)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.a(flag);
            com.google.a.f.e.a(atype, "type parameter");
            a = type;
            c = class1;
            b = com.google.a.f.c.d.a(atype);
        }
    }

    private static final class f
        implements TypeVariable
    {

        private final GenericDeclaration a;
        private final String b;
        private final ad c;

        public final boolean equals(Object obj)
        {
            if (!d.a) goto _L2; else goto _L1
_L1:
            if (!(obj instanceof f)) goto _L4; else goto _L3
_L3:
            obj = (f)obj;
            if (!b.equals(((f) (obj)).getName()) || !a.equals(((f) (obj)).getGenericDeclaration()) || !c.equals(((f) (obj)).c)) goto _L6; else goto _L5
_L5:
            return true;
_L6:
            return false;
_L4:
            return false;
_L2:
            if (obj instanceof TypeVariable)
            {
                obj = (TypeVariable)obj;
                if (!b.equals(((TypeVariable) (obj)).getName()) || !a.equals(((TypeVariable) (obj)).getGenericDeclaration()))
                {
                    return false;
                }
            } else
            {
                return false;
            }
            if (true) goto _L5; else goto _L7
_L7:
        }

        public final Type[] getBounds()
        {
            return com.google.a.f.e.a(c);
        }

        public final GenericDeclaration getGenericDeclaration()
        {
            return a;
        }

        public final String getName()
        {
            return b;
        }

        public final int hashCode()
        {
            return a.hashCode() ^ b.hashCode();
        }

        public final String toString()
        {
            return b;
        }

        f(GenericDeclaration genericdeclaration, String s, Type atype[])
        {
            com.google.a.f.e.a(atype, "bound for type variable");
            a = (GenericDeclaration)com.google.a.a.g.a(genericdeclaration);
            b = (String)com.google.a.a.g.a(s);
            c = ad.a(atype);
        }
    }

    static final class g
        implements Serializable, WildcardType
    {

        private final ad a;
        private final ad b;

        public final boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof WildcardType)
            {
                obj = (WildcardType)obj;
                flag = flag1;
                if (a.equals(Arrays.asList(((WildcardType) (obj)).getLowerBounds())))
                {
                    flag = flag1;
                    if (b.equals(Arrays.asList(((WildcardType) (obj)).getUpperBounds())))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public final Type[] getLowerBounds()
        {
            return com.google.a.f.e.a(a);
        }

        public final Type[] getUpperBounds()
        {
            return com.google.a.f.e.a(b);
        }

        public final int hashCode()
        {
            return a.hashCode() ^ b.hashCode();
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder("?");
            Type type;
            for (Iterator iterator = a.iterator(); iterator.hasNext(); stringbuilder.append(" super ").append(com.google.a.f.c.d.c(type)))
            {
                type = (Type)iterator.next();
            }

            Type type1;
            for (Iterator iterator1 = com.google.a.f.e.a(b).iterator(); iterator1.hasNext(); stringbuilder.append(" extends ").append(com.google.a.f.c.d.c(type1)))
            {
                type1 = (Type)iterator1.next();
            }

            return stringbuilder.toString();
        }

        g(Type atype[], Type atype1[])
        {
            com.google.a.f.e.a(atype, "lower bound for wildcard");
            com.google.a.f.e.a(atype1, "upper bound for wildcard");
            a = com.google.a.f.c.d.a(atype);
            b = com.google.a.f.c.d.a(atype1);
        }
    }


    private static final com.google.a.a.c a = new com.google.a.a.c() {

        public final Object a(Object obj)
        {
            obj = (Type)obj;
            return com.google.a.f.c.d.c(((Type) (obj)));
        }

    };
    private static final com.google.a.a.d b = com.google.a.a.d.a(", ").b("null");

    static com.google.a.a.c a()
    {
        return a;
    }

    static Class a(Class class1)
    {
        return Array.newInstance(class1, 0).getClass();
    }

    static Iterable a(Iterable iterable)
    {
        return ao.a(iterable, i.a(i.a(java/lang/Object)));
    }

    static transient ParameterizedType a(Type type, Class class1, Type atype[])
    {
        if (type == null)
        {
            return new e(com.google.a.f.a.c.a(class1), class1, atype);
        }
        com.google.a.a.g.a(atype);
        boolean flag;
        if (class1.getEnclosingClass() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.a.a.g.a(flag, "Owner type for unenclosed %s", new Object[] {
            class1
        });
        return new e(type, class1, atype);
    }

    static Type a(Type type)
    {
        if (type instanceof WildcardType)
        {
            type = (WildcardType)type;
            Type atype[] = type.getLowerBounds();
            boolean flag;
            if (atype.length <= 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.a(flag, "Wildcard cannot have more than one lower bounds.");
            if (atype.length == 1)
            {
                return new g(new Type[] {
                    a(atype[0])
                }, new Type[] {
                    java/lang/Object
                });
            }
            type = type.getUpperBounds();
            if (type.length == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.a.a.g.a(flag, "Wildcard should have only one upper bound.");
            type = a(type[0]);
            return new g(new Type[0], new Type[] {
                type
            });
        } else
        {
            return com.google.a.f.c.d.a(type);
        }
    }

    static transient TypeVariable a(GenericDeclaration genericdeclaration, String s, Type atype[])
    {
        Type atype1[] = atype;
        if (atype.length == 0)
        {
            atype1 = new Type[1];
            atype1[0] = java/lang/Object;
        }
        return new f(genericdeclaration, s, atype1);
    }

    static void a(Type atype[], String s)
    {
        int k = atype.length;
        int j = 0;
        while (j < k) 
        {
            Object obj = atype[j];
            if (obj instanceof Class)
            {
                obj = (Class)obj;
                boolean flag;
                if (!((Class) (obj)).isPrimitive())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.google.a.a.g.a(flag, "Primitive type '%s' used as %s", new Object[] {
                    obj, s
                });
            }
            j++;
        }
    }

    static Type[] a(Collection collection)
    {
        return (Type[])collection.toArray(new Type[collection.size()]);
    }

    static com.google.a.a.d b()
    {
        return b;
    }

    static String b(Type type)
    {
        if (type instanceof Class)
        {
            return ((Class)type).getName();
        } else
        {
            return type.toString();
        }
    }

}
