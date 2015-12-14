// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.ad:
//            g, h

final class a
    implements g
{

    private final Set a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a()
    {
    }

    final void a()
    {
        b = true;
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).d()) { }
    }

    public final void a(h h1)
    {
        a.add(h1);
        if (c)
        {
            h1.f();
            return;
        }
        if (b)
        {
            h1.d();
            return;
        } else
        {
            h1.e();
            return;
        }
    }

    final void b()
    {
        b = false;
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).e()) { }
    }

    public final void b(h h1)
    {
        a.remove(h1);
    }

    final void c()
    {
        c = true;
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).f()) { }
    }
}
