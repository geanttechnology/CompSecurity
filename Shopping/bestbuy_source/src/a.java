// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class a
{

    private static final String a = (new StringBuilder()).append(a.getName()).append("_persisted").toString();
    private final Map b = new HashMap();
    private final SharedPreferences c;
    private boolean d;
    private Map e;

    public a(Context context)
    {
        d = false;
        c = context.getSharedPreferences(a, 0);
    }

    final void a()
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        if (d)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        d = true;
        java.util.Map.Entry entry;
        for (Iterator iterator = c.getAll().entrySet().iterator(); iterator.hasNext(); b.put(entry.getKey(), entry.getValue().toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_91;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        e = null;
        map;
        JVM INSTR monitorexit ;
    }

    final Map b()
    {
        Map map1;
        synchronized (b)
        {
            if (e == null)
            {
                e = Collections.unmodifiableMap(new HashMap(b));
            }
            map1 = e;
        }
        return map1;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
