// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.tapjoy.internal:
//            cm, da, hc, cy, 
//            gd, gj, ga, ge, 
//            db, gk, ch

public final class gl
    implements cm
{

    final gd a;
    Set b;
    private final Map c = Collections.synchronizedMap(new HashMap());
    private final Map d = da.a();

    public gl(gd gd1)
    {
        a = gd1;
        b = null;
    }

    private void a(ch ch, hc.a a1)
    {
        if (!(ch instanceof hc))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (a1.b == null) goto _L2; else goto _L1
_L1:
        Object obj = a1.b;
        this;
        JVM INSTR monitorenter ;
        if (!(obj instanceof Collection))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj = new HashSet(cy.a(((Iterable) (obj))));
_L3:
        b = ((Set) (obj));
        this;
        JVM INSTR monitorexit ;
_L2:
        boolean flag;
        obj = (hc)ch;
        ch = ((hc) (obj)).c;
        flag = ((hc) (obj)).d;
        d.remove(ch);
        if (!flag)
        {
            c.put(ch, a1.a);
        }
        a1 = a1.a;
        obj = a.j();
        if (a1 instanceof gj)
        {
            ga.a("No content for \"{}\"", new Object[] {
                ch
            });
            ((ge) (obj)).a(ch);
            return;
        }
        break MISSING_BLOCK_LABEL_151;
        obj = db.a(((Iterable) (obj)).iterator());
          goto _L3
        ch;
        throw ch;
        ga.a("New content for \"{}\" is ready", new Object[] {
            ch
        });
        if (flag)
        {
            a1.a(((ge) (obj)));
            return;
        } else
        {
            ((ge) (obj)).b(ch);
            return;
        }
        throw new IllegalStateException(ch.getClass().getName());
    }

    public final void a(ch ch)
    {
        a(ch, new hc.a(new gj(), null));
    }

    public final volatile void a(ch ch, Object obj)
    {
        a(ch, (hc.a)obj);
    }
}
