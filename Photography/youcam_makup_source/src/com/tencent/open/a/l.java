// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class l
    implements Iterable
{

    private ConcurrentLinkedQueue a;
    private AtomicInteger b;

    public l()
    {
        a = null;
        b = null;
        a = new ConcurrentLinkedQueue();
        b = new AtomicInteger(0);
    }

    public int a()
    {
        return b.get();
    }

    public int a(String s)
    {
        int i = s.length();
        a.add(s);
        return b.addAndGet(i);
    }

    public void a(Writer writer, char ac[])
    {
        int l1;
        if (writer == null || ac == null || ac.length == 0)
        {
            return;
        }
        int j1 = ac.length;
        Iterator iterator1 = iterator();
        l1 = 0;
        int k1 = j1;
        do
        {
label0:
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                String s = (String)iterator1.next();
                int k = s.length();
                int i1 = 0;
                int i = k1;
                int j = l1;
                do
                {
                    l1 = j;
                    k1 = i;
                    if (k <= 0)
                    {
                        break;
                    }
                    if (i > k)
                    {
                        k1 = k;
                    } else
                    {
                        k1 = i;
                    }
                    s.getChars(i1, i1 + k1, ac, j);
                    i -= k1;
                    j += k1;
                    k -= k1;
                    i1 = k1 + i1;
                    if (i == 0)
                    {
                        writer.write(ac, 0, j1);
                        j = 0;
                        i = j1;
                    }
                } while (true);
            }
        } while (true);
        if (l1 > 0)
        {
            writer.write(ac, 0, l1);
        }
        writer.flush();
        return;
    }

    public void b()
    {
        a.clear();
        b.set(0);
    }

    public Iterator iterator()
    {
        return a.iterator();
    }
}
