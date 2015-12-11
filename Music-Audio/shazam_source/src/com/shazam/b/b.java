// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package com.shazam.b:
//            a

public final class b
{
    private static final class a
        implements InvocationHandler
    {

        public final Object invoke(Object obj, Method method, Object aobj[])
        {
            return com.shazam.b.a.a(method.getReturnType());
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    public static final InvocationHandler a = new a((byte)0);

    public static Object a(Class class1)
    {
        InvocationHandler invocationhandler = a;
        return Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
            class1
        }, invocationhandler);
    }

}
