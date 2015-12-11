// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import io.presage.Presage;
import io.presage.utils.f;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package io.presage.actions:
//            g

public final class c
{

    private LinkedList a;
    private boolean b;

    public c()
    {
        a = new LinkedList();
        b = false;
    }

    public final void a()
    {
        if (b) goto _L2; else goto _L1
_L1:
        Iterator iterator = a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        g g1 = (g)iterator.next();
        if (!g1.a().equals("home")) goto _L6; else goto _L5
_L5:
        g1.j();
        b = true;
_L2:
        return;
_L4:
        if (!a.isEmpty())
        {
            ((g)a.getFirst()).j();
            b = true;
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final void a(g g1)
    {
        if (!Presage.getInstance().getPackageHelper().a(g1.p()))
        {
            return;
        } else
        {
            g1.a(this);
            a.add(g1);
            return;
        }
    }

    public final void b(g g1)
    {
        a.remove(g1);
        if (b && !a.isEmpty())
        {
            ((g)a.getFirst()).j();
        }
    }
}
