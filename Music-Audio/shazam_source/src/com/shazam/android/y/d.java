// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y;

import com.shazam.android.y.c.a;
import com.shazam.android.y.c.c;
import com.shazam.android.y.d.b;
import com.shazam.b.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

// Referenced classes of package com.shazam.android.y:
//            c

public final class d
    implements com.shazam.android.y.c
{

    final com.shazam.android.y.f.b a;
    final Set b = new HashSet(3);
    private final com.shazam.android.y.e.d c;
    private final Executor d;

    public d(com.shazam.android.y.e.d d1, com.shazam.android.y.f.b b1, Executor executor)
    {
        c = d1;
        a = b1;
        d = executor;
    }

    private List c()
    {
        List list;
        try
        {
            list = c.a();
        }
        catch (a a1)
        {
            Object obj = a1.a;
            if (obj != null && !((Collection) (obj)).isEmpty())
            {
                String s;
                for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); c.a(s))
                {
                    s = (String)((Iterator) (obj)).next();
                }

            }
            return Collections.emptyList();
        }
        return list;
    }

    public final void a()
    {
        d.execute(new Runnable() {

            final d a;

            public final void run()
            {
                d d1;
                List list;
                int i;
                d1 = a;
                list = d1.();
                i = 0;
_L2:
                b b1;
                if (i >= list.size())
                {
                    break; /* Loop/switch isn't completed */
                }
                b1 = (b)list.get(i);
                String s = b1.a;
                com.shazam.android.y.g.c.a(b1);
                d1.a(b1, d1.a.a(b1.b));
                i++;
                if (true) goto _L2; else goto _L1
                c c1;
                c1;
                String s1 = b1.a;
                com.shazam.android.y.g.c.a(b1);
                d1.a(i, list);
_L1:
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    final void a(int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        b b1 = (b)list.get(i);
        b.remove(b1.a);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        list;
        throw list;
    }

    final void a(b b1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        b1 = b1.a;
        b.remove(b1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        c.a(b1);
        this;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    final List b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = com.shazam.b.b.b.a(c(), new e() {

            final d a;

            public final boolean apply(Object obj1)
            {
                obj1 = (b)obj1;
                return obj1 != null && !a..contains(((b) (obj1)).a);
            }

            
            {
                a = d.this;
                super();
            }
        });
        Collection collection = com.shazam.b.b.b.a(((Collection) (obj)), new com.shazam.b.a.c() {

            final d a;

            public final volatile Object a(Object obj1)
            {
                return ((b)obj1).a;
            }

            
            {
                a = d.this;
                super();
            }
        });
        b.addAll(collection);
        obj = new ArrayList(((Collection) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        Exception exception;
        exception;
        throw exception;
    }
}
