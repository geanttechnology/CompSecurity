// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.b;

import com.c.a.c.c;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.c.a.a.b:
//            a

public abstract class b extends a
{

    private final int a;
    private final AtomicInteger b = new AtomicInteger();
    private final List c = Collections.synchronizedList(new LinkedList());

    public b(int i)
    {
        a = i;
        if (i > 0x1000000)
        {
            com.c.a.c.c.c("You set too large memory cache size (more than %1$d Mb)", new Object[] {
                Integer.valueOf(16)
            });
        }
    }

    public boolean a(Object obj, Object obj1)
    {
        boolean flag = false;
        int j = d(obj1);
        int k = b();
        int i = b.get();
        if (j < k)
        {
            do
            {
                if (i + j <= k)
                {
                    break;
                }
                Object obj2 = c();
                if (c.remove(obj2))
                {
                    i = b.addAndGet(-d(obj2));
                }
            } while (true);
            c.add(obj1);
            b.addAndGet(j);
            flag = true;
        }
        super.a(obj, obj1);
        return flag;
    }

    protected int b()
    {
        return a;
    }

    public void b(Object obj)
    {
        Object obj1 = super.a(obj);
        if (obj1 != null && c.remove(obj1))
        {
            b.addAndGet(-d(obj1));
        }
        super.b(obj);
    }

    protected abstract Object c();

    protected abstract int d(Object obj);
}
