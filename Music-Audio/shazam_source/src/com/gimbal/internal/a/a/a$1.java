// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.a.a;

import com.gimbal.a.b;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gimbal.internal.a.a:
//            a, b

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        if (com.gimbal.internal.a.a.a.a(a) && com.gimbal.internal.a.a.a.b(a))
        {
            com.gimbal.internal.a.a.a.c(a);
            com.gimbal.internal.a.a.a.b().a("went background", new Object[0]);
            for (Iterator iterator = com.gimbal.internal.a.a.a.d(a).iterator(); iterator.hasNext();)
            {
                com.gimbal.internal.a.a.b b1 = (com.gimbal.internal.a.a.b)iterator.next();
                try
                {
                    b1.b();
                }
                catch (Exception exception)
                {
                    com.gimbal.internal.a.a.a.b().d("Listener failed", new Object[] {
                        exception
                    });
                }
            }

        } else
        {
            com.gimbal.internal.a.a.a.b().a("still foreground", new Object[0]);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
