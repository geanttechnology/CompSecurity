// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
{

    private static final Map a = new ConcurrentHashMap();

    public i()
    {
    }

    public static Method[] a(Class class1, Class class2)
    {
        Method amethod[] = b(class1, class2);
        if (amethod != null)
        {
            return amethod;
        }
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Method amethod2[] = b(class1, class2);
        Method amethod1[] = amethod2;
        if (amethod2 != null) goto _L2; else goto _L1
_L1:
        HashSet hashset;
        int k;
        hashset = new HashSet();
        amethod1 = class1.getMethods();
        k = amethod1.length;
        int j = 0;
_L7:
        if (j >= k) goto _L4; else goto _L3
_L3:
        Method method = amethod1[j];
        if (method.isAnnotationPresent(class2))
        {
            hashset.add(method);
        }
          goto _L5
_L4:
        amethod1 = class1.getDeclaredMethods();
        k = amethod1.length;
        Method method1;
        for (j = 0; j >= k; j++)
        {
            break MISSING_BLOCK_LABEL_138;
        }

        method1 = amethod1[j];
        if (method1.isAnnotationPresent(class2))
        {
            method1.setAccessible(true);
            hashset.add(method1);
        }
        break MISSING_BLOCK_LABEL_223;
        if (!a.containsKey(class1))
        {
            a.put(class1, new ConcurrentHashMap());
        }
        amethod1 = new Method[hashset.size()];
        ((Map)a.get(class1)).put(class2, ((Object) (hashset.toArray(amethod1))));
_L2:
        map;
        JVM INSTR monitorexit ;
        return amethod1;
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static Method[] b(Class class1, Class class2)
    {
        class1 = (Map)a.get(class1);
        if (class1 != null)
        {
            class1 = (Method[])class1.get(class2);
            if (class1 != null)
            {
                return class1;
            }
        }
        return null;
    }

}
