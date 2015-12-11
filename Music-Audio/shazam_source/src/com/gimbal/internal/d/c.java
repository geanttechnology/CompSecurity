// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.d;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.gimbal.internal.d:
//            a, i

public abstract class c
{

    protected final Map a = new HashMap();
    protected final Map b = new HashMap();
    boolean c;

    protected c(boolean flag)
    {
        c = flag;
    }

    protected static String a(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        Object obj1 = obj.getClass().getMethod("name", new Class[0]);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (((Method) (obj1)).getReturnType() != java/lang/String)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        obj1 = (String)((Method) (obj1)).invoke(obj, new Object[0]);
        return ((String) (obj1));
        Object obj2;
        obj2;
_L2:
        return obj.toString();
        obj2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static List b(Class class1)
    {
        Object obj;
        if (java/lang/Object.isAssignableFrom(class1))
        {
            ArrayList arraylist = new ArrayList();
            do
            {
                obj = arraylist;
                if (class1 == java/lang/Object)
                {
                    break;
                }
                obj = class1.getDeclaredMethods();
                int j = obj.length;
                for (int i = 0; i < j; i++)
                {
                    arraylist.add(obj[i]);
                }

                class1 = class1.getSuperclass();
            } while (true);
        } else
        {
            obj = new ArrayList();
        }
        return ((List) (obj));
    }

    public final transient void a(i i, Class aclass[])
    {
        if (aclass.length == 0)
        {
            b.put(java/lang/Void, i);
        } else
        {
            int k = aclass.length;
            int j = 0;
            while (j < k) 
            {
                Class class1 = aclass[j];
                b.put(class1, i);
                j++;
            }
        }
    }

    protected final boolean a(Class class1)
    {
        if ((a)a.get(class1) == null);
        return false;
    }
}
