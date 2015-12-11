// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package com.tapjoy.internal:
//            fx, bg, cx

public class AndroidListenerProxy
{
    static final class a
        implements InvocationHandler
    {

        private final Object a;
        private final Thread b;
        private final Looper c;

        static Object a(a a1)
        {
            return a1.a;
        }

        public final Object invoke(Object obj, Method method, Object aobj[])
        {
            Object obj1 = null;
            if (b != Thread.currentThread()) goto _L2; else goto _L1
_L1:
            obj = method.invoke(a, aobj);
_L4:
            return obj;
_L2:
            Runnable runnable;
            if (!method.getReturnType().equals(Void.TYPE))
            {
                throw new UnsupportedOperationException((new StringBuilder("method not return void: ")).append(method.getName()).toString());
            }
            runnable = new Runnable(this, method, aobj) {

                final Method a;
                final Object b[];
                final a c;

                public final void run()
                {
                    try
                    {
                        a.invoke(a.a(c), b);
                        return;
                    }
                    catch (IllegalArgumentException illegalargumentexception)
                    {
                        throw cx.a(illegalargumentexception);
                    }
                    catch (IllegalAccessException illegalaccessexception)
                    {
                        throw cx.a(illegalaccessexception);
                    }
                    catch (InvocationTargetException invocationtargetexception)
                    {
                        throw cx.a(invocationtargetexception);
                    }
                }

            
            {
                c = a1;
                a = method;
                b = aobj;
                super();
            }
            };
            if (c == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if ((new Handler(c)).post(runnable)) goto _L4; else goto _L3
_L3:
            if (b != fx.b())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if (fx.a.a(runnable)) goto _L4; else goto _L5
_L5:
            Looper looper;
            looper = Looper.getMainLooper();
            if (looper == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if ((new Handler(looper)).post(runnable)) goto _L4; else goto _L6
_L6:
            return method.invoke(a, aobj);
        }

        public a(Object obj, Thread thread, Looper looper)
        {
            a = obj;
            b = thread;
            c = looper;
        }
    }


    public AndroidListenerProxy()
    {
    }

    public static Object getListener(Object obj)
    {
        obj = Proxy.getInvocationHandler(obj);
        if (obj instanceof a)
        {
            return a.a((a)obj);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("not a proxy instance from ")).append(com/tapjoy/internal/AndroidListenerProxy.getSimpleName()).toString());
        }
    }

    public static Object newProxyInstance(Object obj, Class class1)
    {
        ClassLoader classloader = class1.getClassLoader();
        obj = new a(obj, Thread.currentThread(), Looper.myLooper());
        return Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, ((InvocationHandler) (obj)));
    }
}
