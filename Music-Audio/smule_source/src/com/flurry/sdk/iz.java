// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

// Referenced classes of package com.flurry.sdk:
//            iy

public final class iz
{

    static final Type a[] = new Type[0];

    static int a(Object obj)
    {
        return b(obj);
    }

    private static int a(Object aobj[], Object obj)
    {
        for (int j = 0; j < aobj.length; j++)
        {
            if (obj.equals(aobj[j]))
            {
                return j;
            }
        }

        throw new NoSuchElementException();
    }

    private static Class a(TypeVariable typevariable)
    {
        typevariable = typevariable.getGenericDeclaration();
        if (typevariable instanceof Class)
        {
            return (Class)typevariable;
        } else
        {
            return null;
        }
    }

    public static GenericArrayType a(Type type)
    {
        return new a(type);
    }

    public static transient ParameterizedType a(Type type, Type type1, Type atype[])
    {
        return new b(type, type1, atype);
    }

    public static Type a(Type type, Class class1)
    {
        class1 = b(type, class1, java/util/Collection);
        type = class1;
        if (class1 instanceof WildcardType)
        {
            type = ((WildcardType)class1).getUpperBounds()[0];
        }
        if (type instanceof ParameterizedType)
        {
            return ((ParameterizedType)type).getActualTypeArguments()[0];
        } else
        {
            return java/lang/Object;
        }
    }

    static Type a(Type type, Class class1, Class class2)
    {
        if (class2 == class1)
        {
            return type;
        }
        if (class2.isInterface())
        {
            type = class1.getInterfaces();
            int j = 0;
            for (int k = type.length; j < k; j++)
            {
                if (type[j] == class2)
                {
                    return class1.getGenericInterfaces()[j];
                }
                if (class2.isAssignableFrom(type[j]))
                {
                    return a(class1.getGenericInterfaces()[j], type[j], class2);
                }
            }

        }
        if (!class1.isInterface())
        {
            for (; class1 != java/lang/Object; class1 = type)
            {
                type = class1.getSuperclass();
                if (type == class2)
                {
                    return class1.getGenericSuperclass();
                }
                if (class2.isAssignableFrom(type))
                {
                    return a(class1.getGenericSuperclass(), ((Class) (type)), class2);
                }
            }

        }
        return class2;
    }

    public static Type a(Type type, Class class1, Type type1)
    {
        Type atype[] = type1;
_L12:
        if (!(atype instanceof TypeVariable)) goto _L2; else goto _L1
_L1:
        atype = (TypeVariable)atype;
        type1 = a(type, class1, ((TypeVariable) (atype)));
        if (type1 != atype) goto _L4; else goto _L3
_L3:
        return type1;
_L4:
        atype = type1;
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(atype instanceof Class) || !((Class)atype).isArray())
        {
            break; /* Loop/switch isn't completed */
        }
        type1 = (Class)atype;
        atype = type1.getComponentType();
        type = a(type, class1, ((Type) (atype)));
        if (atype != type)
        {
            return a(type);
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (!(atype instanceof GenericArrayType))
        {
            break; /* Loop/switch isn't completed */
        }
        type1 = (GenericArrayType)atype;
        atype = type1.getGenericComponentType();
        type = a(type, class1, ((Type) (atype)));
        if (atype != type)
        {
            return a(type);
        }
        if (true) goto _L3; else goto _L6
_L6:
        if (!(atype instanceof ParameterizedType))
        {
            break; /* Loop/switch isn't completed */
        }
        ParameterizedType parameterizedtype = (ParameterizedType)atype;
        type1 = parameterizedtype.getOwnerType();
        Type type2 = a(type, class1, type1);
        boolean flag;
        int k;
        if (type2 != type1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        atype = parameterizedtype.getActualTypeArguments();
        k = atype.length;
        for (int j = 0; j < k;)
        {
            Type type3 = a(type, class1, atype[j]);
            type1 = atype;
            boolean flag1 = flag;
            if (type3 != atype[j])
            {
                type1 = atype;
                flag1 = flag;
                if (!flag)
                {
                    type1 = (Type[])atype.clone();
                    flag1 = true;
                }
                type1[j] = type3;
            }
            j++;
            atype = type1;
            flag = flag1;
        }

        type1 = parameterizedtype;
        if (flag)
        {
            return a(type2, parameterizedtype.getRawType(), atype);
        }
        if (true) goto _L3; else goto _L7
_L7:
        WildcardType wildcardtype;
        Type atype2[];
        type1 = atype;
        if (!(atype instanceof WildcardType))
        {
            continue; /* Loop/switch isn't completed */
        }
        wildcardtype = (WildcardType)atype;
        Type atype1[] = wildcardtype.getLowerBounds();
        atype2 = wildcardtype.getUpperBounds();
        if (atype1.length != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        type = a(type, class1, atype1[0]);
        type1 = wildcardtype;
        if (type != atype1[0])
        {
            return c(type);
        }
        if (true) goto _L3; else goto _L8
_L8:
        type1 = wildcardtype;
        if (atype2.length != 1) goto _L3; else goto _L9
_L9:
        type = a(type, class1, atype2[0]);
        type1 = wildcardtype;
        if (type == atype2[0]) goto _L3; else goto _L10
_L10:
        return b(type);
        if (true) goto _L12; else goto _L11
_L11:
    }

    static Type a(Type type, Class class1, TypeVariable typevariable)
    {
        Class class2 = a(typevariable);
        if (class2 != null)
        {
            if ((type = a(type, class1, class2)) instanceof ParameterizedType)
            {
                int j = a(((Object []) (class2.getTypeParameters())), typevariable);
                return ((ParameterizedType)type).getActualTypeArguments()[j];
            }
        }
        return typevariable;
    }

    static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static boolean a(Type type, Type type1)
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag4 = true;
        flag5 = true;
        flag2 = true;
        flag3 = false;
        if (type != type1) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if (type instanceof Class)
        {
            return type.equals(type1);
        }
        if (!(type instanceof ParameterizedType))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag3;
        if (type1 instanceof ParameterizedType)
        {
            type = (ParameterizedType)type;
            type1 = (ParameterizedType)type1;
            if (a(type.getOwnerType(), type1.getOwnerType()) && type.getRawType().equals(type1.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type1.getActualTypeArguments()))
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(type instanceof GenericArrayType))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag3;
        if (type1 instanceof GenericArrayType)
        {
            type = (GenericArrayType)type;
            type1 = (GenericArrayType)type1;
            return a(type.getGenericComponentType(), type1.getGenericComponentType());
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!(type instanceof WildcardType))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag3;
        if (type1 instanceof WildcardType)
        {
            type = (WildcardType)type;
            type1 = (WildcardType)type1;
            if (Arrays.equals(type.getUpperBounds(), type1.getUpperBounds()) && Arrays.equals(type.getLowerBounds(), type1.getLowerBounds()))
            {
                flag = flag4;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (true) goto _L4; else goto _L6
_L6:
        flag = flag3;
        if (type instanceof TypeVariable)
        {
            flag = flag3;
            if (type1 instanceof TypeVariable)
            {
                type = (TypeVariable)type;
                type1 = (TypeVariable)type1;
                boolean flag1;
                if (type.getGenericDeclaration() == type1.getGenericDeclaration() && type.getName().equals(type1.getName()))
                {
                    flag1 = flag5;
                } else
                {
                    flag1 = false;
                }
                return flag1;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private static int b(Object obj)
    {
        if (obj != null)
        {
            return obj.hashCode();
        } else
        {
            return 0;
        }
    }

    static Type b(Type type, Class class1, Class class2)
    {
        iy.a(class2.isAssignableFrom(class1));
        return a(type, class1, a(type, class1, class2));
    }

    public static WildcardType b(Type type)
    {
        Type atype[] = a;
        return new c(new Type[] {
            type
        }, atype);
    }

    public static Type[] b(Type type, Class class1)
    {
        if (type == java/util/Properties)
        {
            return (new Type[] {
                java/lang/String, java/lang/String
            });
        }
        type = b(type, class1, java/util/Map);
        if (type instanceof ParameterizedType)
        {
            return ((ParameterizedType)type).getActualTypeArguments();
        } else
        {
            return (new Type[] {
                java/lang/Object, java/lang/Object
            });
        }
    }

    public static WildcardType c(Type type)
    {
        return new c(new Type[] {
            java/lang/Object
        }, new Type[] {
            type
        });
    }

    public static Type d(Type type)
    {
        if (type instanceof Class)
        {
            type = (Class)type;
            if (type.isArray())
            {
                type = new a(d(((Type) (type.getComponentType()))));
            }
            return (Type)type;
        }
        if (type instanceof ParameterizedType)
        {
            type = (ParameterizedType)type;
            return new b(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType)
        {
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType)
        {
            type = (WildcardType)type;
            return new c(type.getUpperBounds(), type.getLowerBounds());
        } else
        {
            return type;
        }
    }

    public static Class e(Type type)
    {
        if (type instanceof Class)
        {
            return (Class)type;
        }
        if (type instanceof ParameterizedType)
        {
            type = ((ParameterizedType)type).getRawType();
            iy.a(type instanceof Class);
            return (Class)type;
        }
        if (type instanceof GenericArrayType)
        {
            return Array.newInstance(e(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable)
        {
            return java/lang/Object;
        }
        if (type instanceof WildcardType)
        {
            return e(((WildcardType)type).getUpperBounds()[0]);
        }
        String s;
        if (type == null)
        {
            s = "null";
        } else
        {
            s = type.getClass().getName();
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Expected a Class, ParameterizedType, or GenericArrayType, but <").append(type).append("> is of type ").append(s).toString());
    }

    public static String f(Type type)
    {
        if (type instanceof Class)
        {
            return ((Class)type).getName();
        } else
        {
            return type.toString();
        }
    }

    public static Type g(Type type)
    {
        if (type instanceof GenericArrayType)
        {
            return ((GenericArrayType)type).getGenericComponentType();
        } else
        {
            return ((Class)type).getComponentType();
        }
    }

    static void h(Type type)
    {
        i(type);
    }

    private static void i(Type type)
    {
        boolean flag;
        if (!(type instanceof Class) || !((Class)type).isPrimitive())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iy.a(flag);
    }


    private class a
        implements Serializable, GenericArrayType
    {

        private final Type a;

        public boolean equals(Object obj)
        {
            return (obj instanceof GenericArrayType) && iz.a(this, (GenericArrayType)obj);
        }

        public Type getGenericComponentType()
        {
            return a;
        }

        public int hashCode()
        {
            return a.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append(iz.f(a)).append("[]").toString();
        }

        public a(Type type)
        {
            a = iz.d(type);
        }
    }


    private class b
        implements Serializable, ParameterizedType
    {

        private final Type a;
        private final Type b;
        private final Type c[];

        public boolean equals(Object obj)
        {
            return (obj instanceof ParameterizedType) && iz.a(this, (ParameterizedType)obj);
        }

        public Type[] getActualTypeArguments()
        {
            return (Type[])c.clone();
        }

        public Type getOwnerType()
        {
            return a;
        }

        public Type getRawType()
        {
            return b;
        }

        public int hashCode()
        {
            return Arrays.hashCode(c) ^ b.hashCode() ^ iz.a(a);
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((c.length + 1) * 30);
            stringbuilder.append(iz.f(b));
            if (c.length == 0)
            {
                return stringbuilder.toString();
            }
            stringbuilder.append("<").append(iz.f(c[0]));
            for (int j = 1; j < c.length; j++)
            {
                stringbuilder.append(", ").append(iz.f(c[j]));
            }

            return stringbuilder.append(">").toString();
        }

        public transient b(Type type, Type type1, Type atype[])
        {
            boolean flag = false;
            super();
            if (type1 instanceof Class)
            {
                Class class1 = (Class)type1;
                int j;
                boolean flag1;
                if (Modifier.isStatic(class1.getModifiers()) || class1.getEnclosingClass() == null)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (type != null || j != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                iy.a(flag1);
            }
            if (type == null)
            {
                type = null;
            } else
            {
                type = iz.d(type);
            }
            a = type;
            b = iz.d(type1);
            c = (Type[])atype.clone();
            for (j = ((flag) ? 1 : 0); j < c.length; j++)
            {
                iy.a(c[j]);
                iz.h(c[j]);
                c[j] = iz.d(c[j]);
            }

        }
    }


    private class c
        implements Serializable, WildcardType
    {

        private final Type a;
        private final Type b;

        public boolean equals(Object obj)
        {
            return (obj instanceof WildcardType) && iz.a(this, (WildcardType)obj);
        }

        public Type[] getLowerBounds()
        {
            if (b != null)
            {
                return (new Type[] {
                    b
                });
            } else
            {
                return iz.a;
            }
        }

        public Type[] getUpperBounds()
        {
            return (new Type[] {
                a
            });
        }

        public int hashCode()
        {
            int j;
            if (b != null)
            {
                j = b.hashCode() + 31;
            } else
            {
                j = 1;
            }
            return j ^ a.hashCode() + 31;
        }

        public String toString()
        {
            if (b != null)
            {
                return (new StringBuilder()).append("? super ").append(iz.f(b)).toString();
            }
            if (a == java/lang/Object)
            {
                return "?";
            } else
            {
                return (new StringBuilder()).append("? extends ").append(iz.f(a)).toString();
            }
        }

        public c(Type atype[], Type atype1[])
        {
            boolean flag1 = true;
            super();
            boolean flag;
            if (atype1.length <= 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            iy.a(flag);
            if (atype.length == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            iy.a(flag);
            if (atype1.length == 1)
            {
                iy.a(atype1[0]);
                iz.h(atype1[0]);
                if (atype[0] == java/lang/Object)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                iy.a(flag);
                b = iz.d(atype1[0]);
                a = java/lang/Object;
                return;
            } else
            {
                iy.a(atype[0]);
                iz.h(atype[0]);
                b = null;
                a = iz.d(atype[0]);
                return;
            }
        }
    }

}
