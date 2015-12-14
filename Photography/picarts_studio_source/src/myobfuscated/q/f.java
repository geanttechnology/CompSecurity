// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.q:
//            e, d, g

public final class f
{

    private static final e b = new e() {

        public final Class a()
        {
            throw new UnsupportedOperationException("Not implemented");
        }

        public final d a(Object obj)
        {
            return new g(obj);
        }

    };
    private final Map a = new HashMap();

    public f()
    {
    }

    public final d a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        e e2;
        m.a(obj, "Argument must not be null");
        e2 = (e)a.get(obj.getClass());
        e e1 = e2;
        if (e2 != null) goto _L2; else goto _L1
_L1:
        Iterator iterator = a.values().iterator();
_L3:
        e1 = e2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        e1 = (e)iterator.next();
        if (!e1.a().isAssignableFrom(obj.getClass())) goto _L3; else goto _L2
_L2:
        e2 = e1;
        if (e1 != null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        e2 = b;
        obj = e2.a(obj);
        this;
        JVM INSTR monitorexit ;
        return ((d) (obj));
        obj;
        throw obj;
    }

    public final void a(e e1)
    {
        this;
        JVM INSTR monitorenter ;
        a.put(e1.a(), e1);
        this;
        JVM INSTR monitorexit ;
        return;
        e1;
        throw e1;
    }

}
