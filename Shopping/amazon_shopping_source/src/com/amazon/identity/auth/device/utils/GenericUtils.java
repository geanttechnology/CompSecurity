// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, PublicCloneable

public final class GenericUtils
{

    private static final WeakHashMap CLONEABLE_TO_CLONE_METHOD = new WeakHashMap();
    private static final String TAG = com/amazon/identity/auth/device/utils/GenericUtils.getName();

    private GenericUtils()
    {
    }

    private static Object clone(Cloneable cloneable)
        throws CloneNotSupportedException
    {
        com/amazon/identity/auth/device/utils/GenericUtils;
        JVM INSTR monitorenter ;
        Method method;
        Class class1;
        class1 = cloneable.getClass();
        method = (Method)CLONEABLE_TO_CLONE_METHOD.get(class1);
        Object obj;
        obj = method;
        if (method != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = class1.getMethod("clone", new Class[0]);
        ((Method) (obj)).setAccessible(true);
        CLONEABLE_TO_CLONE_METHOD.put(class1, obj);
        obj = ((Method) (obj)).invoke(cloneable, new Object[0]);
        com/amazon/identity/auth/device/utils/GenericUtils;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        cloneable = String.format("Clone method failed on the object of type %s", new Object[] {
            cloneable.getClass().getName()
        });
        MAPLog.e(TAG, cloneable, exception);
        throw new CloneNotSupportedException(cloneable);
        cloneable;
        com/amazon/identity/auth/device/utils/GenericUtils;
        JVM INSTR monitorexit ;
        throw cloneable;
    }

    public static Map cloneMap(Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        PublicCloneable publiccloneable;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey(), publiccloneable))
        {
            entry = (java.util.Map.Entry)map.next();
            publiccloneable = cloneObject((PublicCloneable)entry.getValue());
        }

        return hashmap;
    }

    public static PublicCloneable cloneObject(PublicCloneable publiccloneable)
    {
        if (publiccloneable == null)
        {
            return null;
        } else
        {
            return publiccloneable.cloneObject();
        }
    }

    public static boolean equals(Object obj, Object obj1)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == null)
        {
            flag = flag1;
            if (obj1 == null)
            {
                flag = true;
            }
        } else
        {
            flag = flag1;
            if (obj1 != null)
            {
                flag = flag1;
                if (obj1.getClass() == obj1.getClass())
                {
                    return obj.equals(obj1);
                }
            }
        }
        return flag;
    }

    public static Object typeSafeClone(Object obj)
        throws CloneNotSupportedException
    {
        Object obj1;
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            if (obj instanceof PublicCloneable)
            {
                return ((PublicCloneable)obj).cloneObject();
            }
            obj1 = obj;
            if (!(obj instanceof String))
            {
                obj1 = obj;
                if (!(obj instanceof Integer))
                {
                    if (obj instanceof Cloneable)
                    {
                        return clone((Cloneable)obj);
                    } else
                    {
                        throw new CloneNotSupportedException(String.format("Clone not supported on type %s", new Object[] {
                            obj.getClass().getName()
                        }));
                    }
                }
            }
        }
        return obj1;
    }

}
