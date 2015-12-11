// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private static final class dataManagerBackRef
    implements InvocationHandler
{

    final WeakReference dataManagerBackRef;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag = true;
        int i = 0;
        Object obj1 = dataManagerBackRef.get();
        if (java/lang/Object.equals(method.getDeclaringClass()))
        {
            if (method.getName().equals("toString"))
            {
                return (new StringBuilder()).append("Proxy to: ").append(obj1).toString();
            }
            if (method.getName().equals("equals"))
            {
                if (obj != aobj[0])
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }
            if (method.getName().equals("hashCode"))
            {
                if (obj1 != null)
                {
                    i = obj1.hashCode();
                }
                return Integer.valueOf(i);
            } else
            {
                return null;
            }
        }
        if (com/ebay/nautilus/domain/content/DataManager$VerifyObserver.equals(method.getDeclaringClass()))
        {
            if (method.getName().equals("isConnected"))
            {
                boolean flag1;
                if (obj1 != null)
                {
                    flag1 = flag3;
                } else
                {
                    flag1 = false;
                }
                return Boolean.valueOf(flag1);
            }
            if (method.getName().equals("isProxyFor"))
            {
                boolean flag2;
                if (aobj[0] == obj1)
                {
                    flag2 = flag4;
                } else
                {
                    flag2 = false;
                }
                return Boolean.valueOf(flag2);
            } else
            {
                return null;
            }
        }
        if (obj1 == null)
        {
            return null;
        } else
        {
            return method.invoke(obj1, aobj);
        }
    }

    public bserver(Object obj)
    {
        dataManagerBackRef = new WeakReference(obj);
    }
}
