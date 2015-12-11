// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.d;

import com.gimbal.internal.c.c;
import com.gimbal.proguard.a;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gimbal.internal.d:
//            c, d, i, a

public class e extends com.gimbal.internal.d.c
{

    private static final com.gimbal.a.a d = com.gimbal.internal.c.c.e(com/gimbal/internal/d/e.getName());
    private static final Type e[] = {
        java/lang/Object, java/lang/Object
    };
    private final Map f;

    e()
    {
        this(false);
    }

    public e(boolean flag)
    {
        super(flag);
        f = new HashMap();
    }

    private Object a(Class class1, Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof String)
        {
            return b(class1, obj);
        }
        if (obj instanceof Double)
        {
            return c(class1, obj);
        }
        if (obj instanceof Long)
        {
            return d(class1, obj);
        }
        if (obj instanceof Integer)
        {
            return e(class1, obj);
        }
        if (obj instanceof Boolean)
        {
            return f(class1, obj);
        }
        if (obj instanceof JSONObject)
        {
            if (java/util/Map.isAssignableFrom(class1))
            {
                return a(class1, e, (JSONObject)obj);
            }
            if (class1 == java/lang/Object)
            {
                return a(java/util/HashMap, e, (JSONObject)obj);
            } else
            {
                obj = (JSONObject)obj;
                return a(c(class1), ((JSONObject) (obj)));
            }
        }
        if (obj instanceof JSONArray)
        {
            if (java/util/Set.isAssignableFrom(class1))
            {
                return a(class1, e, (JSONArray)obj);
            }
            if (java/util/List.isAssignableFrom(class1))
            {
                return b(class1, e, (JSONArray)obj);
            }
            if (class1 == java/lang/Object)
            {
                return b(java/util/ArrayList, e, (JSONArray)obj);
            }
            if (class1.isArray())
            {
                return ((Object) (a(class1.getComponentType(), (JSONArray)obj)));
            }
        }
        StringBuilder stringbuilder = (new StringBuilder("Can't handle result type: ")).append(class1.getName()).append(" from ");
        if (obj == null)
        {
            class1 = "(null)";
        } else
        {
            class1 = obj.getClass().getName();
        }
        throw new d(stringbuilder.append(class1).toString());
    }

    private Object a(Class class1, Type atype[], JSONArray jsonarray)
    {
        int j;
        if (class1 == java/util/Set)
        {
            class1 = new HashSet();
        } else
        {
            try
            {
                obj = (Set)class1.newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (Type atype[])
            {
                throw new d((new StringBuilder("Couldn't instantiate Set sub-class '")).append(class1).append("' specified as argument in setter").toString());
            }
            class1 = ((Class) (obj));
        }
        j = 0;
        while (j < jsonarray.length()) 
        {
            Object obj;
            if (jsonarray.isNull(j))
            {
                obj = null;
            } else
            {
                obj = a((Class)atype[0], jsonarray.get(j));
            }
            class1.add(obj);
            j++;
        }
        return class1;
    }

    private Object a(Class class1, Type atype[], JSONObject jsonobject)
    {
        Class class2;
        Class class3;
        Iterator iterator;
        if (class1 == java/util/Map)
        {
            class1 = new HashMap();
        } else
        {
            Map map;
            try
            {
                map = (Map)class1.newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (Type atype[])
            {
                throw new d((new StringBuilder("Couldn't instantiate Map sub-class '")).append(class1).append("' specified as argument in setter").toString());
            }
            class1 = map;
        }
        class2 = (Class)atype[0];
        class3 = (Class)atype[1];
        iterator = jsonobject.keys();
        while (iterator.hasNext()) 
        {
            atype = ((Type []) (iterator.next()));
            Object obj = a(class2, atype);
            if (jsonobject.isNull(atype.toString()))
            {
                atype = null;
            } else
            {
                atype = ((Type []) (a(class3, jsonobject.get(atype.toString()))));
            }
            class1.put(obj, atype);
        }
        return class1;
    }

    private Object a(Object obj, JSONObject jsonobject)
    {
        Class class1 = obj.getClass();
        if (super.c)
        {
            com.gimbal.proguard.a.a(class1);
        }
        Iterator iterator = jsonobject.keys();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            a(class1);
            if (jsonobject.isNull(s))
            {
                continue;
            }
            Object obj3 = new StringBuilder("set");
            Object obj1 = null;
            Object obj2 = (i)b.get(class1);
            if (obj2 != null)
            {
                obj1 = ((i) (obj2)).b(s);
            }
            if (obj1 == null)
            {
                obj2 = (i)b.get(java/lang/Void);
                if (obj2 != null)
                {
                    obj1 = ((i) (obj2)).b(s);
                }
            }
            obj2 = obj1;
            if (obj1 == null)
            {
                obj2 = s;
            }
            obj2 = ((StringBuilder) (obj3)).append((new StringBuilder()).append(Character.toUpperCase(((String) (obj2)).charAt(0))).append(((String) (obj2)).substring(1)).toString()).toString();
            obj1 = jsonobject.get(s);
            Object obj4 = b(class1).iterator();
            do
            {
                if (!((Iterator) (obj4)).hasNext())
                {
                    continue label0;
                }
                obj3 = (Method)((Iterator) (obj4)).next();
            } while (((Method) (obj3)).getParameterTypes().length != 1 || !((String) (obj2)).equals(((Method) (obj3)).getName()));
            ((Method) (obj3)).setAccessible(true);
            obj4 = ((Method) (obj3)).getParameterTypes()[0];
            if (java/util/Set.isAssignableFrom(((Class) (obj4))))
            {
                obj1 = a(((Class) (obj4)), a(((Method) (obj3))), a(s, obj1));
            } else
            if (java/util/List.isAssignableFrom(((Class) (obj4))))
            {
                obj1 = b(((Class) (obj4)), a(((Method) (obj3))), a(s, obj1));
            } else
            if (((Class) (obj4)).isArray())
            {
                obj1 = ((Object) (a(((Class) (obj4)).getComponentType(), a(s, obj1))));
            } else
            if (java/util/Map.isAssignableFrom(((Class) (obj4))))
            {
                Type atype[] = a(((Method) (obj3)));
                if (obj1 instanceof JSONObject)
                {
                    obj1 = a(((Class) (obj4)), atype, (JSONObject)obj1);
                } else
                {
                    throw new d((new StringBuilder("JSON needs object for ")).append(s).toString());
                }
            } else
            {
                if ((com.gimbal.internal.d.a)a.get(class1) == null);
                obj1 = a(((Class) (obj4)), obj1);
            }
            try
            {
                ((Method) (obj3)).invoke(obj, new Object[] {
                    obj1
                });
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new d((new StringBuilder("Invoking setter '")).append(((String) (obj2))).append("' failed").append(obj.getClass()).toString());
            }
        } while (true);
        return obj;
    }

    private static String a(String s)
    {
        StringBuilder stringbuilder1;
        int j;
        stringbuilder1 = null;
        if (s.length() <= 0)
        {
            throw new d("Invalid string");
        }
        if (s.charAt(0) != '"')
        {
            throw new d("Missing \" at beginning of string");
        }
        j = 1;
_L2:
        char c1;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder2;
        int k;
        if (j >= s.length())
        {
            throw new d("No trailing quote");
        }
        c1 = s.charAt(j);
        if (c1 == '"')
        {
            if (j != s.length() - 1)
            {
                throw new d("Trailing quote not at end of string");
            }
            break MISSING_BLOCK_LABEL_534;
        }
        if (c1 != '\\')
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder = stringbuilder1;
        if (stringbuilder1 == null)
        {
            stringbuilder = new StringBuilder();
            stringbuilder.append(s.substring(1, j));
        }
        j++;
        stringbuilder2 = stringbuilder;
        k = j;
        if (j >= s.length())
        {
            break MISSING_BLOCK_LABEL_524;
        }
        c1 = s.charAt(j);
        if (c1 == '"')
        {
            stringbuilder.append(c1);
        } else
        if (c1 == '\\')
        {
            stringbuilder.append('\\');
        } else
        if (c1 == '/')
        {
            stringbuilder.append('/');
        } else
        if (c1 == 'b')
        {
            stringbuilder.append('\b');
        } else
        if (c1 == 'n')
        {
            stringbuilder.append('\n');
        } else
        if (c1 == 'r')
        {
            stringbuilder.append('\r');
        } else
        if (c1 == 't')
        {
            stringbuilder.append('\t');
        } else
        if (c1 == 'f')
        {
            stringbuilder.append('\f');
        } else
        if (c1 == 'u')
        {
            k = 0;
            int l = 0;
            while (k < 4) 
            {
                int i1 = j + 1;
                if (i1 >= s.length())
                {
                    throw new d("Invalid character representation at end of string");
                }
                j = Character.toLowerCase(s.charAt(i1));
                if (j >= 48 && j <= 57)
                {
                    j = j - 48 & 0xf | l << 4;
                } else
                if (j >= 97 && j <= 102)
                {
                    j = (j - 97 & 0xf) + 10 | l << 4;
                } else
                {
                    throw new d((new StringBuilder("Invalid hex value in character representation: ")).append(s.charAt(i1)).toString());
                }
                k++;
                l = j;
                j = i1;
            }
            stringbuilder.append(Character.valueOf((char)l));
        } else
        {
            throw new d((new StringBuilder("Invalid escaped character: \\")).append(c1).toString());
        }
_L3:
        j++;
        stringbuilder1 = stringbuilder;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder2 = stringbuilder1;
        k = j;
        if (stringbuilder1 != null)
        {
            stringbuilder1.append(c1);
            k = j;
            stringbuilder2 = stringbuilder1;
        }
        stringbuilder = stringbuilder2;
        j = k;
          goto _L3
        if (stringbuilder1 != null)
        {
            return stringbuilder1.toString();
        } else
        {
            return s.substring(1, s.length() - 1);
        }
    }

    private static JSONArray a(String s, Object obj)
    {
        if (obj instanceof JSONArray)
        {
            return (JSONArray)obj;
        } else
        {
            throw new d((new StringBuilder("JSON needs array for ")).append(s).toString());
        }
    }

    private Object[] a(Class class1, JSONArray jsonarray)
    {
        try
        {
            if (class1.isPrimitive())
            {
                throw new d("Can't handle arrays of primitives yet :-(");
            }
        }
        catch (JSONException jsonexception)
        {
            throw new d((new StringBuilder("Failed to read array of type: ")).append(class1.getSimpleName()).append(" from ").append(jsonarray.getClass().getSimpleName()).toString());
        }
        Object aobj[] = (Object[])Array.newInstance(class1, jsonarray.length());
        int j = 0;
_L2:
        if (j >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_116;
        }
        Object obj;
        if (jsonarray.isNull(j))
        {
            obj = null;
            break MISSING_BLOCK_LABEL_119;
        }
        obj = a(class1, jsonarray.get(j));
        break MISSING_BLOCK_LABEL_119;
        return aobj;
        aobj[j] = obj;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Type[] a(Method method)
    {
        this;
        JVM INSTR monitorenter ;
        Type atype1[] = (Type[])f.get(method);
        Type atype[] = atype1;
        if (atype1 != null) goto _L2; else goto _L1
_L1:
        atype = method.getGenericParameterTypes();
        if (atype.length != 1)
        {
            throw new RuntimeException("Internal error - setter with argument count != 1");
        }
        break MISSING_BLOCK_LABEL_49;
        method;
        this;
        JVM INSTR monitorexit ;
        throw method;
        atype = atype[0];
        if (!(atype instanceof ParameterizedType))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        atype = ((ParameterizedType)atype).getActualTypeArguments();
_L3:
        f.put(method, atype);
_L2:
        if (atype == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (atype.length != 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        System.out.println((new StringBuilder("No generic params for method: ")).append(method.getName()).toString());
        this;
        JVM INSTR monitorexit ;
        return atype;
        atype = new Type[0];
          goto _L3
    }

    private static Object b(Class class1, Object obj)
    {
        Object obj1 = (String)obj;
        if (class1.isAssignableFrom(java/lang/String))
        {
            return obj1;
        }
        if (!class1.isEnum()) goto _L2; else goto _L1
_L1:
        int k;
        obj = ((Object) (class1.getEnumConstants()));
        k = obj.length;
        int j = 0;
_L4:
        Object obj2;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj2 = obj[j];
        Exception exception;
        if (((String) (obj1)).equals(a(obj2)))
        {
            return obj2;
        }
        j++;
        continue; /* Loop/switch isn't completed */
        try
        {
            throw new d((new StringBuilder("Can't find enum constant: ")).append(((String) (obj1))).append(" in enum type: ").append(class1.getSimpleName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new d(class1);
        }
_L2:
        if (class1 == java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (class1 != Integer.TYPE)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        return e(class1, Integer.valueOf(((String) (obj1))));
        if (class1 == java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (class1 != Long.TYPE)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        return d(class1, Long.valueOf(((String) (obj1))));
        if (class1 == java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (class1 != Double.TYPE)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj1 = c(class1, Double.valueOf(((String) (obj1))));
        return obj1;
        if (class1 == java/lang/Object)
        {
            return obj;
        }
        try
        {
            throw g(class1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        throw g(class1, obj);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object b(Class class1, Type atype[], JSONArray jsonarray)
    {
        int j;
        if (class1 == java/util/List)
        {
            class1 = new ArrayList();
        } else
        {
            try
            {
                obj = (List)class1.newInstance();
            }
            // Misplaced declaration of an exception variable
            catch (Type atype[])
            {
                throw new d((new StringBuilder("Couldn't instantiate List sub-class '")).append(class1).append("' specified as argument in setter").toString());
            }
            class1 = ((Class) (obj));
        }
        j = 0;
        while (j < jsonarray.length()) 
        {
            Object obj;
            if (jsonarray.isNull(j))
            {
                obj = null;
            } else
            {
                obj = a((Class)atype[0], jsonarray.get(j));
            }
            class1.add(obj);
            j++;
        }
        return class1;
    }

    private Object c(Class class1)
    {
        a.get(class1);
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            class1.setAccessible(true);
            class1 = ((Class) (class1.newInstance(new Object[0])));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new d(class1);
        }
        return class1;
    }

    private static Object c(Class class1, Object obj)
    {
        Double double1 = (Double)obj;
        if (class1 == java/lang/Double) goto _L2; else goto _L1
_L1:
        Object obj1;
        try
        {
            obj1 = Double.TYPE;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new d(class1);
        }
        if (class1 != obj1) goto _L3; else goto _L2
_L2:
        obj1 = double1;
_L5:
        return obj1;
_L3:
        obj1 = obj;
        if (class1 == java/lang/Object) goto _L5; else goto _L4
_L4:
        if (class1.isAssignableFrom(java/lang/String))
        {
            return double1.toString();
        } else
        {
            throw g(class1, obj);
        }
    }

    private static Object d(Class class1, Object obj)
    {
        Long long1;
        long1 = (Long)obj;
        if (class1 == java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (class1 == Long.TYPE)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (class1 == java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (class1 != Double.TYPE)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        double d1 = long1.longValue();
        return Double.valueOf(d1);
        Object obj1;
        obj1 = obj;
        if (class1 != java/lang/Object)
        {
            try
            {
                if (class1.isAssignableFrom(java/lang/String))
                {
                    return long1.toString();
                } else
                {
                    throw g(class1, obj);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new d(class1);
            }
        }
        break MISSING_BLOCK_LABEL_91;
        obj1 = long1;
        return obj1;
    }

    private static Object e(Class class1, Object obj)
    {
        Integer integer;
        integer = (Integer)obj;
        if (class1 == java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        if (class1 == Integer.TYPE)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        if (class1 == java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (class1 != Long.TYPE)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        return Long.valueOf(integer.intValue());
        if (class1 == java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (class1 != Double.TYPE)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        double d1 = integer.intValue();
        return Double.valueOf(d1);
        Object obj1;
        obj1 = obj;
        if (class1 != java/lang/Object)
        {
            try
            {
                if (class1.isAssignableFrom(java/lang/String))
                {
                    return integer.toString();
                } else
                {
                    throw g(class1, obj);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new d(class1);
            }
        }
        break MISSING_BLOCK_LABEL_114;
        obj1 = integer;
        return obj1;
    }

    private static Object f(Class class1, Object obj)
    {
        Object obj1 = (Boolean)obj;
        if (class1 == java/lang/Boolean) goto _L2; else goto _L1
_L1:
        Class class2;
        try
        {
            class2 = Boolean.TYPE;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new d(class1);
        }
        if (class1 != class2) goto _L3; else goto _L2
_L2:
        return obj1;
_L3:
        obj1 = obj;
        if (class1 == java/lang/Object) goto _L2; else goto _L4
_L4:
        throw g(class1, obj);
    }

    private static d g(Class class1, Object obj)
    {
        return new d((new StringBuilder("Value of type: ")).append(obj.getClass().getSimpleName()).append(" cannot be set to: ").append(class1.getSimpleName()).toString());
    }

    public final Object a(Class class1, String s)
    {
        String s1 = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        String s2;
        return s1;
_L2:
        if ((s2 = s.trim()).length() == 0) goto _L1; else goto _L3
_L3:
        if (s2.charAt(0) != '{') goto _L5; else goto _L4
_L4:
        s = new JSONObject(s2);
        s1 = s;
        if (class1 == org/json/JSONObject) goto _L1; else goto _L6
_L6:
        return a(class1, s);
_L5:
        if (s2.charAt(0) != '[') goto _L8; else goto _L7
_L7:
        s = new JSONArray(s2);
        s1 = s;
        if (class1 == org/json/JSONArray) goto _L1; else goto _L9
_L9:
        return a(class1, s);
_L8:
        if (s2.charAt(0) == '"')
        {
            return a(s2);
        }
        if (class1 != Double.TYPE && class1 != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        return Double.valueOf(s);
        if (class1 != Long.TYPE && class1 != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        return Long.valueOf(s);
        if (class1 != Integer.TYPE && class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        return Integer.valueOf(s);
        throw new d((new StringBuilder("Unrecognized JSON format starting with : ")).append(s2.charAt(0)).toString());
        class1;
        throw new d("JSON parse failed", class1);
    }

}
