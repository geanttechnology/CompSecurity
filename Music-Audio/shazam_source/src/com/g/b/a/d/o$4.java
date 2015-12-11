// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import com.g.b.a.f;
import java.io.IOException;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.g.b.a.d:
//            o, l, a, c

final class  extends f
{

    final int b;
    final List c;
    final o d;

    public final void a()
    {
        o.j(d).a();
        d.i.a(b, a.l);
        synchronized (d)
        {
            o.k(d).remove(Integer.valueOf(b));
        }
        return;
        exception;
        o1;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (o o1, String s, Object aobj[], int i, List list)
    {
        d = o1;
        b = i;
        c = list;
        super(s, aobj);
    }
}
