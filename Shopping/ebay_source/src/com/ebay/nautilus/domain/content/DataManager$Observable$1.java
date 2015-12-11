// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

class val.dispatcher
    implements InvocationHandler
{

    final val.dispatcher this$0;
    final val.dispatcher val$dispatcher;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        boolean flag = false;
        if (java/lang/Object.equals(method.getDeclaringClass()))
        {
            if (method.getName().equals("toString"))
            {
                return (new StringBuilder()).append("Proxy to: ").append(val$dispatcher).toString();
            }
            if (method.getName().equals("equals"))
            {
                if (obj == aobj[0])
                {
                    flag = true;
                }
                return Boolean.valueOf(flag);
            }
            if (method.getName().equals("hashCode"))
            {
                return Integer.valueOf(val$dispatcher.hashCode());
            } else
            {
                return null;
            }
        } else
        {
            spatch(val$dispatcher, method, aobj);
            return null;
        }
    }

    ()
    {
        this$0 = final_;
        val$dispatcher = val.dispatcher.this;
        super();
    }
}
