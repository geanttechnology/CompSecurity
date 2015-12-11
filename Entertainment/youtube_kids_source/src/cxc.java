// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public final class cxc
{

    private final Context a;
    private final Map b;

    public cxc(Context context, Executor executor)
    {
        this(context, executor, ((Map) (new HashMap())));
    }

    private cxc(Context context, Executor executor, Map map)
    {
        a = (Context)b.a(context);
        b.a(executor);
        b = (Map)b.a(map);
    }

    public final String a(String s, Map map)
    {
        b.b();
        Map map1 = b;
        map1;
        JVM INSTR monitorenter ;
        ayg ayg2 = (ayg)b.get(s);
        ayg ayg1;
        ayg1 = ayg2;
        if (ayg2 != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ayg1 = (new baf(a)).a(s);
        b.put(s, ayg1);
        map1;
        JVM INSTR monitorexit ;
        return ayg1.a(map);
        s;
        map1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void a()
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.values().iterator(); iterator.hasNext(); ((ayg)iterator.next()).a()) { }
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        b.clear();
        map;
        JVM INSTR monitorexit ;
    }
}
