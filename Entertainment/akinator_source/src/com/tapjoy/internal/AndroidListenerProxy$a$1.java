// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.tapjoy.internal:
//            AndroidListenerProxy, cx

final class b
    implements Runnable
{

    final Method a;
    final Object b[];
    final b c;

    public final void run()
    {
        try
        {
            a.invoke(a(c), b);
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

    ( , Method method, Object aobj[])
    {
        c = ;
        a = method;
        b = aobj;
        super();
    }
}
