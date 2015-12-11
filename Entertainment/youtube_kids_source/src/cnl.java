// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.LruCache;
import java.util.HashMap;
import java.util.Map;

public final class cnl
    implements lr
{

    private LruCache a;

    public cnl(int i)
    {
        a = new cnm(this, 0x40000);
    }

    public final ls a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (ls)a.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s.f = new HashMap(((ls) (s)).f);
        ((ls) (s)).f.put("X-YouTube-cache-hit", "true");
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public final void a(String s, ls ls1)
    {
        this;
        JVM INSTR monitorenter ;
        a.put(s, ls1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void a(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
