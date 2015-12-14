// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class cfg
{

    private WeakReference a;
    private String b;

    public cfg(Object obj, String s)
    {
        a = new WeakReference(obj);
        b = s;
    }

    public void a(Object obj)
    {
        Object obj1;
        int i;
        i = 0;
        obj1 = a.get();
        Method amethod[];
        int j;
        amethod = obj1.getClass().getDeclaredMethods();
        j = amethod.length;
_L6:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Method method = amethod[i];
        if (!method.getName().equals(b))
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj2 = method.getParameterTypes();
        if (obj2.length != 0) goto _L4; else goto _L3
_L3:
        method.setAccessible(true);
        method.invoke(obj1, new Object[0]);
_L5:
        obj2 = obj2[0];
        int k;
        try
        {
            if (((Class) (obj2)).isAssignableFrom(obj.getClass()))
            {
                method.setAccessible(true);
                method.invoke(obj1, new Object[] {
                    ((Class) (obj2)).cast(obj)
                });
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        break MISSING_BLOCK_LABEL_148;
_L4:
        k = obj2.length;
        if (k > 1)
        {
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
        throw new IllegalArgumentException();
        i++;
          goto _L6
_L2:
    }
}
