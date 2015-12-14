// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.core.utilities:
//            Logger

public class com.inmobi.commons.core.utilities.a
{
    static class a extends Handler
    {

        boolean a;

        public void handleMessage(Message message)
        {
            if (!com.inmobi.commons.core.utilities.a.f())
            {
                if (message.what == 1001 && a)
                {
                    a = false;
                    com.inmobi.commons.core.utilities.a.a(false);
                    Logger.a(Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.utilities.a.g(), "App has gone to background.");
                    return;
                }
                if (message.what == 1002 && !a)
                {
                    a = true;
                    com.inmobi.commons.core.utilities.a.a(true);
                    Logger.a(Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.utilities.a.g(), "App has come to foreground.");
                    return;
                }
            }
        }

        public a(Looper looper)
        {
            super(looper);
            a = true;
        }
    }

    public static interface b
    {

        public abstract void a(boolean flag);
    }


    private static final String a = com/inmobi/commons/core/utilities/a.getSimpleName();
    private static List b = new ArrayList();
    private static boolean c = false;
    private static HandlerThread d = null;
    private static Application e;
    private static final Object f = new Object();
    private static volatile com.inmobi.commons.core.utilities.a g;

    private com.inmobi.commons.core.utilities.a()
    {
        e = (Application)com.inmobi.commons.a.a.b();
    }

    public static com.inmobi.commons.core.utilities.a a()
    {
        Object obj;
        obj = g;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = f;
        obj1;
        JVM INSTR monitorenter ;
        com.inmobi.commons.core.utilities.a a1 = g;
        obj = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new com.inmobi.commons.core.utilities.a();
        g = ((com.inmobi.commons.core.utilities.a) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((com.inmobi.commons.core.utilities.a) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((com.inmobi.commons.core.utilities.a) (obj));
    }

    static void a(boolean flag)
    {
        b(flag);
    }

    public static void b()
    {
        c = true;
    }

    private static void b(boolean flag)
    {
        (new Handler(com.inmobi.commons.a.a.b().getMainLooper())).post(new Runnable(flag) {

            final boolean a;

            public void run()
            {
                for (Iterator iterator = com.inmobi.commons.core.utilities.a.e().iterator(); iterator.hasNext(); ((b)iterator.next()).a(a)) { }
            }

            
            {
                a = flag;
                super();
            }
        });
    }

    public static void c()
    {
        c = false;
    }

    static HandlerThread d()
    {
        return d;
    }

    static List e()
    {
        return b;
    }

    static boolean f()
    {
        return c;
    }

    static String g()
    {
        return a;
    }

    private void h()
    {
        Class class1;
        Object obj1;
        d = new HandlerThread("ApplicationFocusChangeObserverHandler");
        d.start();
        Class aclass[] = android/app/Application.getDeclaredClasses();
        class1 = null;
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            Class class2 = aclass[i];
            if (class2.getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks"))
            {
                class1 = class2;
            }
        }

        obj1 = class1.getClassLoader();
        InvocationHandler invocationhandler = new InvocationHandler() {

            final com.inmobi.commons.core.utilities.a a;
            private final Handler b = new a(com.inmobi.commons.core.utilities.a.d().getLooper());

            public void a(Activity activity)
            {
                b.sendEmptyMessageDelayed(1001, 3000L);
            }

            public void b(Activity activity)
            {
                b.removeMessages(1001);
                b.sendEmptyMessage(1002);
            }

            public Object invoke(Object obj2, Method method, Object aobj[])
                throws Throwable
            {
                if (aobj != null)
                {
                    if (method.getName().equals("onActivityPaused"))
                    {
                        a((Activity)aobj[0]);
                    } else
                    if (method.getName().equals("onActivityResumed"))
                    {
                        b((Activity)aobj[0]);
                        return null;
                    }
                }
                return null;
            }

            
            {
                a = com.inmobi.commons.core.utilities.a.this;
                super();
            }
        };
        obj1 = Proxy.newProxyInstance(((ClassLoader) (obj1)), new Class[] {
            class1
        }, invocationhandler);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        android/app/Application.getMethod("registerActivityLifecycleCallbacks", new Class[] {
            class1
        }).invoke(e, new Object[] {
            obj1
        });
        return;
        Object obj;
        obj;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", ((Throwable) (obj)));
        return;
        obj;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", ((Throwable) (obj)));
        return;
        obj;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", ((Throwable) (obj)));
        return;
    }

    public void a(b b1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b.add(b1);
            if (b.size() == 1)
            {
                h();
                return;
            }
        }
    }

}
