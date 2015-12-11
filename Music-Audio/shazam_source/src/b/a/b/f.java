// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import b.a.a;
import b.a.a.b;
import b.a.a.c;
import b.a.d;
import b.a.e;
import com.google.b.b.i;
import com.google.b.q;
import com.google.b.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package b.a.b:
//            h

public final class f extends x
{

    private final Class a;
    private final a b;
    private final com.google.b.f c;
    private final x d;
    private final h e = new h();

    public f(Class class1, a a1, x x1, com.google.b.f f1)
    {
        b = a1;
        c = f1;
        d = x1;
        a = class1;
    }

    private void a()
    {
        for (Iterator iterator = b.a().iterator(); iterator.hasNext(); iterator.next()) { }
    }

    public final Object a(com.google.b.d.a a1)
    {
        new q();
        com.google.b.l l = q.a(a1);
        a1 = b;
        if (((a) (a1)).c == null)
        {
            a1.c = new ArrayList();
        }
        for (a1 = ((a) (a1)).c.iterator(); a1.hasNext(); a1.next()) { }
        Object obj = null;
        a1 = obj;
        if (a == b.a)
        {
            a1 = obj;
            if (b.b != null)
            {
                a1 = b.b.getClassForElement(l);
            }
        }
        if (a1 == null || a1 == b.a)
        {
            a1 = ((com.google.b.d.a) (d.a(l)));
        } else
        {
            Object obj1 = c.a(l, a1);
            a1 = ((com.google.b.d.a) (i.a(a1).cast(obj1)));
        }
        if (b.d)
        {
            b.a.b.h.a(a1, b/a/a/b);
        }
        a();
        return a1;
    }

    public final void a(com.google.b.d.c c1, Object obj)
    {
        if (b.d)
        {
            b.a.b.h.a(obj, b/a/a/c);
        }
        com.google.b.l l = d.a(obj);
        for (Iterator iterator = b.a().iterator(); iterator.hasNext(); ((d)iterator.next()).a(l, obj, c)) { }
        c.a(l, c1);
    }
}
