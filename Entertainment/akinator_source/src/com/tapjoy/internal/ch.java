// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.tapjoy.internal:
//            cj, ck, cm

public abstract class ch
{

    public static ExecutorService a;
    public static ck b;
    private Future c;

    public ch()
    {
    }

    public abstract Object a(URI uri, InputStream inputstream);

    public List a()
    {
        return Collections.emptyList();
    }

    public final void a(cm cm, ExecutorService executorservice)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (c != null && !c.isDone())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        throw new IllegalStateException(String.valueOf("Call has not completed"));
        cm;
        this;
        JVM INSTR monitorexit ;
        throw cm;
        c = executorservice.submit(new cj(this, cm));
        this;
        JVM INSTR monitorexit ;
    }

    public abstract Object b();

    public abstract String c();

    public String d()
    {
        return null;
    }

    public Map e()
    {
        return new LinkedHashMap();
    }

    public Object f()
    {
        return b.a(this);
    }
}
