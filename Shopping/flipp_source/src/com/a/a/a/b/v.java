// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.a.a.a.b:
//            c, q, x, a, 
//            j, y, k, w, 
//            b

final class v
    implements c, Runnable
{

    final q a;

    private v(q q1)
    {
        a = q1;
        super();
    }

    v(q q1, byte byte0)
    {
        this(q1);
    }

    public final void a(int i)
    {
        q q1 = a;
        q1;
        JVM INSTR monitorenter ;
        q.f(a);
        Iterator iterator = q.c(a).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Integer)entry.getKey()).intValue() > i && ((x)entry.getValue()).b())
            {
                ((x)entry.getValue()).c(a.k);
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_116;
        Exception exception;
        exception;
        q1;
        JVM INSTR monitorexit ;
        throw exception;
        q1;
        JVM INSTR monitorexit ;
    }

    public final void a(int i, int l)
    {
        x x1;
        if (i != 0)
        {
            if ((x1 = q.a(a, i)) != null)
            {
                x1.a(l);
                return;
            }
        }
    }

    public final void a(int i, a a1)
    {
        x x1 = a.a(i);
        if (x1 != null)
        {
            x1.c(a1);
        }
    }

    public final void a(int i, List list)
    {
        x x1 = q.a(a, i);
        if (x1 == null) goto _L2; else goto _L1
_L1:
        if (!x.f && Thread.holdsLock(x1))
        {
            throw new AssertionError();
        }
        i = 0;
        x1;
        JVM INSTR monitorenter ;
        if (x1.d == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(x1.d);
        arraylist.addAll(list);
        x1.d = arraylist;
_L3:
        x1;
        JVM INSTR monitorexit ;
        if (i != 0)
        {
            x1.b(a.b);
        }
_L2:
        return;
        i = 1;
          goto _L3
        list;
        x1;
        JVM INSTR monitorexit ;
        throw list;
    }

    public final void a(boolean flag, int i, int l)
    {
        if (flag)
        {
            j j1 = q.c(a, i);
            if (j1 != null)
            {
                if (j1.c != -1L || j1.b == -1L)
                {
                    throw new IllegalStateException();
                }
                j1.c = System.nanoTime();
                j1.a.countDown();
            }
            return;
        } else
        {
            q.a(a, i, l);
            return;
        }
    }

    public final void a(boolean flag, int i, InputStream inputstream, int l)
    {
        x x1;
        boolean flag1;
        flag1 = false;
        x1 = q.a(a, i);
        if (x1 != null) goto _L2; else goto _L1
_L1:
        a.a(i, a.c);
        u.a(inputstream, l);
_L8:
        return;
_L2:
        y y1;
        if (!x.f && Thread.holdsLock(x1))
        {
            throw new AssertionError();
        }
        y1 = x1.e;
        if (!y.e && Thread.holdsLock(y1.f))
        {
            throw new AssertionError();
        }
        if (l == 0) goto _L4; else goto _L3
_L3:
        x x2 = y1.f;
        x2;
        JVM INSTR monitorenter ;
        int j1;
        int k1;
        int l1;
        boolean flag2;
        flag2 = y1.d;
        l1 = y1.b;
        k1 = y1.c;
        j1 = y1.c;
        if (l > y1.a.length - y1.available())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        x2;
        JVM INSTR monitorexit ;
        if (i == 0) goto _L6; else goto _L5
_L5:
        u.a(inputstream, l);
        y1.f.b(a.h);
_L4:
        if (!flag) goto _L8; else goto _L7
_L7:
        x1.e();
        return;
        inputstream;
        x2;
        JVM INSTR monitorexit ;
        throw inputstream;
_L6:
label0:
        {
            if (!flag2)
            {
                break label0;
            }
            u.a(inputstream, l);
        }
        if (true) goto _L4; else goto _L9
_L9:
        int i1;
        i1 = j1;
        i = l;
        if (l1 >= j1)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        i = Math.min(l, y1.a.length - j1);
        u.a(inputstream, y1.a, j1, i);
        j1 += i;
        l -= i;
        i1 = j1;
        i = l;
        if (j1 != y1.a.length)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        i = l;
        l = ((flag1) ? 1 : 0);
_L11:
        i1 = l;
        if (i > 0)
        {
            u.a(inputstream, y1.a, l, i);
            i1 = l + i;
        }
        synchronized (y1.f)
        {
            y1.c = i1;
            if (y1.b == -1)
            {
                y1.b = k1;
                y1.f.notifyAll();
            }
        }
        if (true) goto _L4; else goto _L10
_L10:
          goto _L8
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
        l = i1;
          goto _L11
    }

    public final void a(boolean flag, int i, List list)
    {
        x x1;
        boolean flag1;
        flag1 = false;
        x1 = q.a(a, i);
        if (x1 != null) goto _L2; else goto _L1
_L1:
        a.a(i, a.c);
_L8:
        return;
_L2:
        if (!x.f && Thread.holdsLock(x1))
        {
            throw new AssertionError();
        }
        x1;
        JVM INSTR monitorenter ;
        if (!x1.b() || x1.d != null) goto _L4; else goto _L3
_L3:
        boolean flag2;
        x1.d = list;
        flag2 = x1.a();
        x1.notifyAll();
        i = ((flag1) ? 1 : 0);
_L6:
        x1;
        JVM INSTR monitorexit ;
        if (i != 0)
        {
            x1.b(a.e);
        } else
        if (!flag2)
        {
            x1.b.a(x1.a);
        }
        if (flag)
        {
            x1.e();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i = 1;
        flag2 = false;
        if (true) goto _L6; else goto _L5
_L5:
        list;
        x1;
        JVM INSTR monitorexit ;
        throw list;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(boolean flag, k k1)
    {
        q q1 = a;
        q1;
        JVM INSTR monitorenter ;
        if (a.f != null && !flag) goto _L2; else goto _L1
_L1:
        a.f = k1;
_L10:
        if (q.c(a).isEmpty()) goto _L4; else goto _L3
_L3:
        k1 = (x[])q.c(a).values().toArray(new x[q.c(a).size()]);
_L13:
        q1;
        JVM INSTR monitorexit ;
        if (k1 == null) goto _L6; else goto _L5
_L5:
        int i;
        int l;
        l = k1.length;
        i = 0;
_L12:
        if (i >= l) goto _L6; else goto _L7
_L7:
        q1 = k1[i];
        q1;
        JVM INSTR monitorenter ;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        k k2;
        k2 = a.f;
        if (!x.f && !Thread.holdsLock(q1))
        {
            throw new AssertionError();
        }
          goto _L8
        k1;
        obj;
        JVM INSTR monitorexit ;
        throw k1;
        k1;
        q1;
        JVM INSTR monitorexit ;
        throw k1;
_L2:
        obj = a.f;
        l = 0;
_L18:
        if (l >= 10) goto _L10; else goto _L9
_L9:
        int i1;
        if ((1 << l & k1.a) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        if ((1 << l & k1.c) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L11
_L17:
        ((k) (obj)).a(l, i1, k1.d[l]);
        break MISSING_BLOCK_LABEL_321;
        k1;
        q1;
        JVM INSTR monitorexit ;
        throw k1;
_L8:
        q1.a(k2);
        q1.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        q1;
        JVM INSTR monitorexit ;
        i++;
          goto _L12
_L6:
        return;
_L4:
        k1 = null;
          goto _L13
_L16:
        i = 0;
          goto _L14
_L11:
        if (i == 0) goto _L16; else goto _L15
_L15:
        i = 2;
_L14:
        boolean flag1;
        if ((1 << l & k1.b) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i1 = i;
        if (flag1)
        {
            i1 = i | 1;
        }
          goto _L17
        l++;
          goto _L18
    }

    public final void a(boolean flag, boolean flag1, int i, int l, int i1, List list)
    {
label0:
        {
            synchronized (a)
            {
                list = new x(i, a, flag, flag1, l, i1, list, a.f);
                if (!q.b(a))
                {
                    break label0;
                }
            }
            return;
        }
        x x1;
        q.b(a, i);
        x1 = (x)q.c(a).put(Integer.valueOf(i), list);
        q1;
        JVM INSTR monitorexit ;
        if (x1 != null)
        {
            x1.b(a.b);
            a.a(i);
            return;
        } else
        {
            q.d().submit(new w(this, "OkHttp SPDY Callback %s stream %d", new Object[] {
                q.d(a), Integer.valueOf(i)
            }, list));
            return;
        }
        list;
        q1;
        JVM INSTR monitorexit ;
        throw list;
    }

    public final void run()
    {
        Object obj1;
        a a2;
        obj1 = a.g;
        a2 = a.g;
_L2:
        Object obj;
        a a1;
        a1 = ((a) (obj1));
        obj = obj1;
        if (q.a(a).a(this)) goto _L2; else goto _L1
_L1:
        a1 = ((a) (obj1));
        obj = obj1;
        obj1 = a.a;
        a1 = ((a) (obj1));
        obj = obj1;
        a a3 = a.l;
        Exception exception;
        try
        {
            q.a(a, ((a) (obj1)), a3);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        obj;
        obj = a1;
        obj1 = a.b;
        obj = a.b;
        try
        {
            q.a(a, ((a) (obj1)), ((a) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        exception;
        obj1 = obj;
        obj = exception;
_L4:
        try
        {
            q.a(a, ((a) (obj1)), a2);
        }
        catch (IOException ioexception1) { }
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
