// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.google.api.a.g:
//            j, f, k, ac, 
//            w, l, a, i

public final class h
{

    public static final Boolean a;
    public static final String b = new String();
    public static final Character c;
    public static final Byte d;
    public static final Short e;
    public static final Integer f;
    public static final Float g;
    public static final Long h;
    public static final Double i;
    public static final BigInteger j;
    public static final BigDecimal k;
    public static final j l;
    private static final ConcurrentHashMap m;

    public static Object a(Class class1)
    {
        Object obj;
        int i1;
        i1 = 0;
        obj = m.get(class1);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        ConcurrentHashMap concurrenthashmap = m;
        concurrenthashmap;
        JVM INSTR monitorenter ;
        Object obj1 = m.get(class1);
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        if (!class1.isArray()) goto _L4; else goto _L3
_L3:
        obj = class1;
_L6:
        obj1 = ((Class) (obj)).getComponentType();
        int j1;
        j1 = i1 + 1;
        obj = obj1;
        i1 = j1;
        if (((Class) (obj1)).isArray()) goto _L6; else goto _L5
_L5:
        obj = Array.newInstance(((Class) (obj1)), new int[j1]);
_L7:
        m.put(class1, obj);
_L2:
        concurrenthashmap;
        JVM INSTR monitorexit ;
        return obj;
_L4:
        if (!class1.isEnum())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = com.google.api.a.g.f.a(class1).a(null);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        throw new NullPointerException(com.google.api.a.f.a.a.a.a.c.a("enum missing constant with @NullValue annotation: %s", new Object[] {
            class1
        }));
        class1;
        concurrenthashmap;
        JVM INSTR monitorexit ;
        throw class1;
        obj = ((k) (obj)).b();
          goto _L7
        obj = ac.a(class1);
          goto _L7
        return obj;
    }

    public static Object a(Type type, String s)
    {
        Class class1;
        String s1;
        if (type instanceof Class)
        {
            class1 = (Class)type;
        } else
        {
            class1 = null;
        }
        if (type != null && class1 == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        if (class1 != java/lang/Void) goto _L2; else goto _L1
_L1:
        s1 = null;
_L4:
        return s1;
_L2:
        s1 = s;
        if (s == null) goto _L4; else goto _L3
_L3:
        s1 = s;
        if (class1 == null) goto _L4; else goto _L5
_L5:
        s1 = s;
        if (class1.isAssignableFrom(java/lang/String)) goto _L4; else goto _L6
_L6:
        if (class1 == java/lang/Character || class1 == Character.TYPE)
        {
            if (s.length() != 1)
            {
                type = String.valueOf(String.valueOf(class1));
                throw new IllegalArgumentException((new StringBuilder(type.length() + 37)).append("expected type Character/char but got ").append(type).toString());
            } else
            {
                return Character.valueOf(s.charAt(0));
            }
        }
        if (class1 == java/lang/Boolean || class1 == Boolean.TYPE)
        {
            return Boolean.valueOf(s);
        }
        if (class1 == java/lang/Byte || class1 == Byte.TYPE)
        {
            return Byte.valueOf(s);
        }
        if (class1 == java/lang/Short || class1 == Short.TYPE)
        {
            return Short.valueOf(s);
        }
        if (class1 == java/lang/Integer || class1 == Integer.TYPE)
        {
            return Integer.valueOf(s);
        }
        if (class1 == java/lang/Long || class1 == Long.TYPE)
        {
            return Long.valueOf(s);
        }
        if (class1 == java/lang/Float || class1 == Float.TYPE)
        {
            return Float.valueOf(s);
        }
        if (class1 == java/lang/Double || class1 == Double.TYPE)
        {
            return Double.valueOf(s);
        }
        if (class1 == com/google/api/a/g/j)
        {
            return com.google.api.a.g.j.a(s);
        }
        if (class1 == java/math/BigInteger)
        {
            return new BigInteger(s);
        }
        if (class1 == java/math/BigDecimal)
        {
            return new BigDecimal(s);
        }
        if (class1.isEnum())
        {
            return com.google.api.a.g.f.a(class1).a(s).b();
        }
        type = String.valueOf(String.valueOf(type));
        throw new IllegalArgumentException((new StringBuilder(type.length() + 35)).append("expected primitive class, but got: ").append(type).toString());
    }

    public static Type a(List list, Type type)
    {
        if (type instanceof WildcardType)
        {
            type = ac.a((WildcardType)type);
        }
        do
        {
            if (!(type instanceof TypeVariable))
            {
                break;
            }
            Type type1 = ac.a(list, (TypeVariable)type);
            if (type1 != null)
            {
                type = type1;
            }
            if (type instanceof TypeVariable)
            {
                type = ((TypeVariable)type).getBounds()[0];
            }
        } while (true);
        return type;
    }

    public static void a(Object obj, Object obj1)
    {
        boolean flag3 = true;
        int i1 = 0;
        boolean flag = false;
        Object obj2 = obj.getClass();
        boolean flag1;
        if (obj2 == obj1.getClass())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w.a(flag1);
        if (((Class) (obj2)).isArray())
        {
            if (Array.getLength(obj) == Array.getLength(obj1))
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
            w.a(flag1);
            obj = ac.a(obj).iterator();
            for (i1 = ((flag) ? 1 : 0); ((Iterator) (obj)).hasNext(); i1++)
            {
                Array.set(obj1, i1, c(((Iterator) (obj)).next()));
            }

        } else
        if (java/util/Collection.isAssignableFrom(((Class) (obj2))))
        {
            obj = (Collection)obj;
            if (java/util/ArrayList.isAssignableFrom(((Class) (obj2))))
            {
                ((ArrayList)obj1).ensureCapacity(((Collection) (obj)).size());
            }
            obj1 = (Collection)obj1;
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Collection) (obj1)).add(c(((Iterator) (obj)).next()))) { }
        } else
        {
            boolean flag2 = com/google/api/a/g/l.isAssignableFrom(((Class) (obj2)));
            if (flag2 || !java/util/Map.isAssignableFrom(((Class) (obj2))))
            {
                Iterator iterator;
                if (flag2)
                {
                    obj2 = ((l)obj).classInfo;
                } else
                {
                    obj2 = com.google.api.a.g.f.a(((Class) (obj2)));
                }
                iterator = ((f) (obj2)).d.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    k k1 = ((f) (obj2)).a((String)iterator.next());
                    if (!k1.a() && (!flag2 || !k1.a))
                    {
                        Object obj3 = k1.a(obj);
                        if (obj3 != null)
                        {
                            k1.a(obj1, c(obj3));
                        }
                    }
                } while (true);
            } else
            if (com/google/api/a/g/a.isAssignableFrom(((Class) (obj2))))
            {
                obj1 = (a)obj1;
                obj = (a)obj;
                for (int j1 = ((a) (obj)).size(); i1 < j1; i1++)
                {
                    ((a) (obj1)).a(i1, c(((a) (obj)).a(i1)));
                }

            } else
            {
                obj1 = (Map)obj1;
                java.util.Map.Entry entry;
                for (obj = ((Map)obj).entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((Map) (obj1)).put(entry.getKey(), c(entry.getValue())))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

            }
        }
    }

    public static boolean a(Object obj)
    {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static boolean a(Type type)
    {
        if (type instanceof WildcardType)
        {
            type = ac.a((WildcardType)type);
        }
        if (!(type instanceof Class))
        {
            return false;
        }
        type = (Class)type;
        return type.isPrimitive() || type == java/lang/Character || type == java/lang/String || type == java/lang/Integer || type == java/lang/Long || type == java/lang/Short || type == java/lang/Byte || type == java/lang/Float || type == java/lang/Double || type == java/math/BigInteger || type == java/math/BigDecimal || type == com/google/api/a/g/j || type == java/lang/Boolean;
    }

    public static Collection b(Type type)
    {
        if (type instanceof WildcardType)
        {
            type = ac.a((WildcardType)type);
        }
        if (type instanceof ParameterizedType)
        {
            type = ((ParameterizedType)type).getRawType();
        }
        Class class1;
        if (type instanceof Class)
        {
            class1 = (Class)type;
        } else
        {
            class1 = null;
        }
        if (type == null || (type instanceof GenericArrayType) || class1 != null && (class1.isArray() || class1.isAssignableFrom(java/util/ArrayList)))
        {
            return new ArrayList();
        }
        if (class1 == null)
        {
            type = String.valueOf(String.valueOf(type));
            throw new IllegalArgumentException((new StringBuilder(type.length() + 39)).append("unable to create new instance of type: ").append(type).toString());
        }
        if (class1.isAssignableFrom(java/util/HashSet))
        {
            return new HashSet();
        }
        if (class1.isAssignableFrom(java/util/TreeSet))
        {
            return new TreeSet();
        } else
        {
            return (Collection)ac.a(class1);
        }
    }

    public static Map b(Class class1)
    {
        if (class1 == null || class1.isAssignableFrom(com/google/api/a/g/a))
        {
            return com.google.api.a.g.a.a();
        }
        if (class1.isAssignableFrom(java/util/TreeMap))
        {
            return new TreeMap();
        } else
        {
            return (Map)ac.a(class1);
        }
    }

    public static Map b(Object obj)
    {
        if (obj == null || a(obj))
        {
            return Collections.emptyMap();
        }
        if (obj instanceof Map)
        {
            return (Map)obj;
        } else
        {
            return new i(obj, false);
        }
    }

    public static Object c(Object obj)
    {
        if (obj == null || a(obj.getClass()))
        {
            return obj;
        }
        if (obj instanceof l)
        {
            return ((l)obj).clone();
        }
        Object obj1 = obj.getClass();
        if (((Class) (obj1)).isArray())
        {
            obj1 = Array.newInstance(((Class) (obj1)).getComponentType(), Array.getLength(obj));
        } else
        if (obj instanceof a)
        {
            obj1 = ((a)obj).b();
        } else
        {
            obj1 = ac.a(((Class) (obj1)));
        }
        a(obj, obj1);
        return obj1;
    }

    public static boolean d(Object obj)
    {
        return obj == null || a(obj.getClass());
    }

    static 
    {
        a = new Boolean(true);
        c = new Character('\0');
        d = new Byte((byte)0);
        e = new Short((short)0);
        f = new Integer(0);
        g = new Float(0.0F);
        h = new Long(0L);
        i = new Double(0.0D);
        j = new BigInteger("0");
        k = new BigDecimal("0");
        l = new j();
        ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
        m = concurrenthashmap;
        concurrenthashmap.put(java/lang/Boolean, a);
        m.put(java/lang/String, b);
        m.put(java/lang/Character, c);
        m.put(java/lang/Byte, d);
        m.put(java/lang/Short, e);
        m.put(java/lang/Integer, f);
        m.put(java/lang/Float, g);
        m.put(java/lang/Long, h);
        m.put(java/lang/Double, i);
        m.put(java/math/BigInteger, j);
        m.put(java/math/BigDecimal, k);
        m.put(com/google/api/a/g/j, l);
    }
}
