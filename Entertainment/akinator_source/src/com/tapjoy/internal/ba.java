// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

// Referenced classes of package com.tapjoy.internal:
//            az, bd, bc

public final class ba extends az
    implements bd, Closeable, Flushable
{

    private final bd a;
    private final LinkedList b = new LinkedList();
    private final LinkedList c = new LinkedList();
    private int d;
    private boolean e;

    private ba(bd bd1)
    {
        a = bd1;
        d = bd1.size();
        boolean flag;
        if (d == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    public static ba a(bd bd1)
    {
        return new ba(bd1);
    }

    public final Object a(int i)
    {
        if (i < 0 || i >= d)
        {
            throw new IndexOutOfBoundsException();
        }
        int j = b.size();
        Object obj1;
        if (i < j)
        {
            obj1 = b.get(i);
        } else
        {
            if (e)
            {
                return c.get(i - j);
            }
            if (i < a.size())
            {
                Object obj = null;
                for (; j <= i; j++)
                {
                    obj = a.a(j);
                    b.add(obj);
                }

                obj1 = obj;
                if (i + 1 + c.size() == d)
                {
                    e = true;
                    return obj;
                }
            } else
            {
                return c.get(i - a.size());
            }
        }
        return obj1;
    }

    public final void b(int i)
    {
        if (i <= 0 || i > d)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i > b.size()) goto _L2; else goto _L1
_L1:
        bc.a(b, i);
        a.b(i);
_L4:
        d = d - i;
        return;
_L2:
        b.clear();
        int j = (c.size() + i) - d;
        if (j < 0)
        {
            a.b(i);
        } else
        {
            a.clear();
            e = true;
            if (j > 0)
            {
                bc.a(c, j);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void close()
    {
        flush();
        if (a instanceof Closeable)
        {
            ((Closeable)a).close();
        }
        return;
        Exception exception;
        exception;
        if (a instanceof Closeable)
        {
            ((Closeable)a).close();
        }
        throw exception;
    }

    protected final void finalize()
    {
        close();
        super.finalize();
    }

    public final void flush()
    {
        if (!c.isEmpty())
        {
            a.addAll(c);
            if (e)
            {
                b.addAll(c);
            }
            c.clear();
        }
    }

    public final boolean offer(Object obj)
    {
        c.add(obj);
        d = d + 1;
        return true;
    }

    public final Object peek()
    {
        Object obj;
        if (d <= 0)
        {
            obj = null;
        } else
        {
            if (!b.isEmpty())
            {
                return b.element();
            }
            if (e)
            {
                return c.element();
            }
            Object obj1 = a.peek();
            b.add(obj1);
            obj = obj1;
            if (d == b.size() + c.size())
            {
                e = true;
                return obj1;
            }
        }
        return obj;
    }

    public final Object poll()
    {
        if (d <= 0)
        {
            return null;
        }
        if (b.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = b.remove();
        a.b(1);
_L4:
        d = d - 1;
        return obj;
_L2:
        if (e)
        {
            obj = c.remove();
        } else
        {
            Object obj1 = a.remove();
            obj = obj1;
            if (d == c.size() + 1)
            {
                e = true;
                obj = obj1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int size()
    {
        return d;
    }
}
