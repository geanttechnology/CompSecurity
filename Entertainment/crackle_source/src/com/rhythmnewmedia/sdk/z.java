// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import com.rhythmnewmedia.sdk.util.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class z extends Enum
{

    public static final z a;
    private static final z c[];
    private final Map b = Collections.synchronizedMap(new HashMap());

    private z(String s)
    {
        super(s, 0);
    }

    private static transient Object a(Class class1, String s, Object aobj[])
    {
        Constructor aconstructor[];
        int k;
        aconstructor = class1.getDeclaredConstructors();
        k = aconstructor.length;
        int j = 0;
_L17:
        if (j >= k) goto _L2; else goto _L1
_L1:
        class1 = aconstructor[j];
        Class aclass[] = class1.getParameterTypes();
        if (aclass.length != aobj.length) goto _L4; else goto _L3
_L3:
        int i = 0;
_L15:
        if (i >= aclass.length) goto _L6; else goto _L5
_L5:
        if (!aclass[i].isPrimitive() || aobj[i] != null) goto _L8; else goto _L7
_L7:
        i = 0;
          goto _L9
_L13:
        if (class1 == null)
        {
            Class class2;
            try
            {
                throw new RuntimeException(String.format("no matching constructor for %s", new Object[] {
                    s
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                aobj = class1.getCause();
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new RuntimeException(String.format("instantiation failed for %s: %s", new Object[] {
                    s, class1.toString()
                }), class1);
            }
            throw new RuntimeException(String.format("instantiation failed for %s\n%s:%s", new Object[] {
                s, class1.toString(), ((Throwable) (aobj)).toString()
            }), ((Throwable) (aobj)));
        }
          goto _L10
_L8:
        class2 = Util.a(aclass[i]);
        if (aobj[i] == null) goto _L12; else goto _L11
_L11:
        if (!class2.isAssignableFrom(aobj[i].getClass()))
        {
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L12
_L10:
        class1.setAccessible(true);
        class1 = ((Class) (class1.newInstance(aobj)));
        return class1;
_L6:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L2:
        class1 = null;
          goto _L13
_L9:
        if (i == 0) goto _L14; else goto _L13
_L14:
        break; /* Loop/switch isn't completed */
_L12:
        i++;
        if (true) goto _L15; else goto _L4
_L4:
        j++;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public static z valueOf(String s)
    {
        return (z)Enum.valueOf(com/rhythmnewmedia/sdk/z, s);
    }

    public static z[] values()
    {
        return (z[])c.clone();
    }

    public final transient Object a(Class class1, Object aobj[])
    {
        String s = class1.getName().intern();
        s;
        JVM INSTR monitorenter ;
        Object obj1 = b.get(s);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj = a(class1, s, aobj);
        b.put(s, obj);
        s;
        JVM INSTR monitorexit ;
        return obj;
        class1;
        throw class1;
    }

    static 
    {
        a = new z("instance");
        c = (new z[] {
            a
        });
    }
}
