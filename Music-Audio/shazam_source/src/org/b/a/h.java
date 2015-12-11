// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.b.a;
import org.b.b;

// Referenced classes of package org.b.a:
//            g

public final class h
    implements a
{

    public final ConcurrentMap a = new ConcurrentHashMap();

    public h()
    {
    }

    public final b a(String s)
    {
        g g2;
label0:
        {
            g2 = (g)a.get(s);
            g g1 = g2;
            if (g2 == null)
            {
                g2 = new g(s);
                g1 = (g)a.putIfAbsent(s, g2);
                if (g1 == null)
                {
                    break label0;
                }
            }
            return g1;
        }
        return g2;
    }
}
