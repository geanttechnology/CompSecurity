// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.util;

import com.rhythmnewmedia.sdk.y;
import java.lang.reflect.Method;

// Referenced classes of package com.rhythmnewmedia.sdk.util:
//            Util

static final class d
    implements Runnable
{

    final Method a;
    final Object b;
    final Object c[];
    final String d;

    public final void run()
    {
        try
        {
            a.invoke(b, c);
            return;
        }
        catch (Exception exception)
        {
            y.a(exception, "Failed to invoke method %s on %s", new Object[] {
                d, b.getClass().getSimpleName()
            });
        }
    }

    (Method method, Object obj, Object aobj[], String s)
    {
        a = method;
        b = obj;
        c = aobj;
        d = s;
        super();
    }
}
