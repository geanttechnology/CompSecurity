// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.Handler;
import java.lang.reflect.Method;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private static final class handler
{
    private final class NotificationRunnable
        implements Runnable
    {

        public final Object args[];
        public final Method method;
        final DataManager.Dispatcher this$0;

        public void run()
        {
            invoke(method, args);
        }

        public NotificationRunnable(Method method1, Object aobj[])
        {
            this$0 = DataManager.Dispatcher.this;
            super();
            method = method1;
            args = aobj;
        }
    }


    private final Handler handler;
    volatile Object iface;

    public final void dispatchChange(Method method, Object aobj[])
    {
        if (handler == null)
        {
            invoke(method, aobj);
            return;
        } else
        {
            handler.post(new NotificationRunnable(method, aobj));
            return;
        }
    }

    final void invoke(Method method, Object aobj[])
    {
        try
        {
            method.invoke(iface, aobj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new RuntimeException(method);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("dispatches to ").append(iface).toString();
    }

    public NotificationRunnable.args(Object obj, Handler handler1)
    {
        iface = obj;
        handler = handler1;
    }
}
