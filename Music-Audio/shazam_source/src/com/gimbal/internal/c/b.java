// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.c;

import com.gimbal.proguard.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gimbal.internal.c:
//            c

public class b
{

    private static com.gimbal.a.a a = com.gimbal.internal.c.c.e(com/gimbal/internal/c/b.getName());
    private final Class b;
    private List c;

    public b(Class class1)
    {
        b = class1;
        com.gimbal.proguard.a.a(class1);
    }

    private Method a(String s, Class class1)
    {
        Object obj1 = new StringBuilder("set");
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        s = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
        obj = a(b).iterator();
        String s1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = (Method)((Iterator) (obj)).next();
            s1 = ((Method) (obj1)).getName();
        } while (((Method) (obj1)).getParameterTypes().length != 1 || !s.equals(s1) || !((Method) (obj1)).getParameterTypes()[0].isAssignableFrom(class1));
        ((Method) (obj1)).setAccessible(true);
        return ((Method) (obj1));
_L2:
        obj = s;
        if (s.length() != 0)
        {
            char c1 = s.charAt(0);
            obj = (new StringBuilder()).append(Character.toUpperCase(c1)).append(s.substring(1)).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    private List a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null) goto _L2; else goto _L1
_L1:
        c = new ArrayList();
_L3:
        if (class1 == java/lang/Object)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        Method amethod[];
        int j;
        amethod = class1.getDeclaredMethods();
        j = amethod.length;
        Method method;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_76;
        }

        method = amethod[i];
        if (method.getName().startsWith("set"))
        {
            c.add(method);
        }
        break MISSING_BLOCK_LABEL_106;
        class1 = class1.getSuperclass();
          goto _L3
        class1 = c;
_L5:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        class1 = c;
        if (true) goto _L5; else goto _L4
_L4:
        class1;
        throw class1;
    }

    public final void a(Object obj, String s, Object obj1)
    {
        if (obj1 == null)
        {
            return;
        }
        Method method1 = a(s, obj1.getClass());
        Method method = method1;
        if (method1 == null)
        {
            Object obj2 = obj1.getClass();
            if (obj2 == java/lang/Integer)
            {
                obj2 = Integer.TYPE;
            } else
            if (obj2 == Integer.TYPE)
            {
                obj2 = java/lang/Integer;
            } else
            if (obj2 == java/lang/Long)
            {
                obj2 = Long.TYPE;
            } else
            if (obj2 == Long.TYPE)
            {
                obj2 = java/lang/Long;
            } else
            if (obj2 == java/lang/Boolean)
            {
                obj2 = Boolean.TYPE;
            } else
            if (obj2 == Boolean.TYPE)
            {
                obj2 = java/lang/Boolean;
            } else
            if (obj2 == java/lang/Double)
            {
                obj2 = Double.TYPE;
            } else
            if (obj2 == Double.TYPE)
            {
                obj2 = java/lang/Double;
            } else
            if (obj2 == java/lang/Float)
            {
                obj2 = Float.TYPE;
            } else
            if (obj2 == Float.TYPE)
            {
                obj2 = java/lang/Float;
            } else
            {
                obj2 = null;
            }
            method = method1;
            if (obj2 != null)
            {
                method = a(s, ((Class) (obj2)));
            }
        }
        if (method != null)
        {
            try
            {
                method.invoke(obj, new Object[] {
                    obj1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        } else
        {
            obj1.getClass().getSimpleName();
            b.getName();
            return;
        }
    }

}
