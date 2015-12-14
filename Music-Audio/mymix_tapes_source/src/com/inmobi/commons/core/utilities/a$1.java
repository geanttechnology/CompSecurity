// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.core.utilities:
//            a

class a
    implements InvocationHandler
{

    final a a;
    private final Handler b = new <init>(com.inmobi.commons.core.utilities.a.d().getLooper());

    public void a(Activity activity)
    {
        b.sendEmptyMessageDelayed(1001, 3000L);
    }

    public void b(Activity activity)
    {
        b.removeMessages(1001);
        b.sendEmptyMessage(1002);
    }

    public Object invoke(Object obj, Method method, Object aobj[])
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

    (a a1)
    {
        a = a1;
        super();
    }
}
