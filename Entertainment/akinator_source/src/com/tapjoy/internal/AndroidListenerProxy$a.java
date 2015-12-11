// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.tapjoy.internal:
//            AndroidListenerProxy, fx, bg, cx

static final class c
    implements InvocationHandler
{

    private final Object a;
    private final Thread b;
    private final Looper c;

    static Object a(c c1)
    {
        return c1.a;
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
        runnable = new Runnable(method, aobj) {

            final Method a;
            final Object b[];
            final AndroidListenerProxy.a c;

            public final void run()
            {
                try
                {
                    a.invoke(AndroidListenerProxy.a.a(c), b);
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
                c = AndroidListenerProxy.a.this;
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

    public _cls1.b(Object obj, Thread thread, Looper looper)
    {
        a = obj;
        b = thread;
        c = looper;
    }
}
