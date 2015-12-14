// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.f;
import java.util.UUID;

// Referenced classes of package com.inmobi.signals:
//            o

public class n
{

    private static final String a = com/inmobi/signals/n.getSimpleName();
    private static n b;
    private static Object c = new Object();

    private n()
    {
    }

    public static n a()
    {
        Object obj;
        obj = b;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        n n1 = b;
        obj = n1;
        if (n1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        b = new n();
        obj = b;
        obj1;
        JVM INSTR monitorexit ;
        return ((n) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((n) (obj));
    }

    void b()
    {
        if (o.a().e().i())
        {
            f.a().a(UUID.randomUUID().toString());
            f.a().a(System.currentTimeMillis());
            f.a().b(0L);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Session tracking started.");
        }
    }

    void c()
    {
        if (o.a().e().i())
        {
            f.a().b(System.currentTimeMillis());
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Session tracking stopped.");
        }
    }

    f d()
    {
        if (!o.a().e().i())
        {
            return null;
        } else
        {
            return f.a();
        }
    }

}
