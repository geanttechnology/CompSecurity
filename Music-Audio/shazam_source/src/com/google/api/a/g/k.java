// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.google.api.a.g:
//            h, w, ad, t, 
//            o

public final class k
{

    private static final Map d = new WeakHashMap();
    public final boolean a;
    public final Field b;
    public final String c;

    private k(Field field, String s)
    {
        b = field;
        if (s == null)
        {
            field = null;
        } else
        {
            field = s.intern();
        }
        c = field;
        a = h.a(b.getType());
    }

    public static k a(Enum enum)
    {
        boolean flag = true;
        k k1;
        try
        {
            k1 = a(enum.getClass().getField(enum.name()));
        }
        // Misplaced declaration of an exception variable
        catch (Enum enum)
        {
            throw new RuntimeException(enum);
        }
        if (k1 == null)
        {
            flag = false;
        }
        w.a(flag, "enum constant missing @Value or @NullValue annotation: %s", new Object[] {
            enum
        });
        return k1;
    }

    public static k a(Field field)
    {
        if (field == null)
        {
            return null;
        }
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        k k1;
        boolean flag;
        k1 = (k)d.get(field);
        flag = field.isEnumConstant();
        Object obj = k1;
        if (k1 != null) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        obj = k1;
        if (Modifier.isStatic(field.getModifiers())) goto _L2; else goto _L4
_L4:
        if (!flag) goto _L6; else goto _L5
_L5:
        obj = (ad)field.getAnnotation(com/google/api/a/g/ad);
        if (obj == null) goto _L8; else goto _L7
_L7:
        obj = ((ad) (obj)).a();
_L9:
        if ("##default".equals(obj))
        {
            obj = field.getName();
        }
        obj = new k(field, ((String) (obj)));
        d.put(field, obj);
_L2:
        map;
        JVM INSTR monitorexit ;
        return ((k) (obj));
        field;
        map;
        JVM INSTR monitorexit ;
        throw field;
_L8:
        if ((t)field.getAnnotation(com/google/api/a/g/t) == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = null;
          goto _L9
        map;
        JVM INSTR monitorexit ;
        return null;
_L6:
        obj = (o)field.getAnnotation(com/google/api/a/g/o);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        map;
        JVM INSTR monitorexit ;
        return null;
        obj = ((o) (obj)).a();
        field.setAccessible(true);
          goto _L9
    }

    private static Object a(Field field, Object obj)
    {
        try
        {
            field = ((Field) (field.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new IllegalArgumentException(field);
        }
        return field;
    }

    public static void a(Field field, Object obj, Object obj1)
    {
        if (Modifier.isFinal(field.getModifiers()))
        {
            Object obj2 = a(field, obj);
            if (obj1 != null ? !obj1.equals(obj2) : obj2 != null)
            {
                obj2 = String.valueOf(String.valueOf(obj2));
                obj1 = String.valueOf(String.valueOf(obj1));
                field = String.valueOf(String.valueOf(field.getName()));
                obj = String.valueOf(String.valueOf(obj.getClass().getName()));
                throw new IllegalArgumentException((new StringBuilder(((String) (obj2)).length() + 48 + ((String) (obj1)).length() + field.length() + ((String) (obj)).length())).append("expected final value <").append(((String) (obj2))).append("> but was <").append(((String) (obj1))).append("> on ").append(field).append(" field in ").append(((String) (obj))).toString());
            } else
            {
                return;
            }
        }
        try
        {
            field.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new IllegalArgumentException(field);
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            throw new IllegalArgumentException(field);
        }
    }

    public final Object a(Object obj)
    {
        return a(b, obj);
    }

    public final void a(Object obj, Object obj1)
    {
        a(b, obj, obj1);
    }

    public final boolean a()
    {
        return Modifier.isFinal(b.getModifiers());
    }

    public final Enum b()
    {
        return Enum.valueOf(b.getDeclaringClass(), b.getName());
    }

}
