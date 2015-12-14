// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import myobfuscated.ag.h;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.ad:
//            h

public final class q
    implements myobfuscated.ad.h
{

    public final Set a = Collections.newSetFromMap(new WeakHashMap());

    public q()
    {
    }

    public final void d()
    {
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).d()) { }
    }

    public final void e()
    {
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).e()) { }
    }

    public final void f()
    {
        for (Iterator iterator = j.a(a).iterator(); iterator.hasNext(); ((h)iterator.next()).f()) { }
    }
}
