// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public final class cyr
{

    private static final Boolean i;
    private static final Boolean j;
    private cyv a;
    private bmt b;
    private long c;
    private long d;
    private boolean e;
    private boolean f;
    private boolean g;
    private List h;
    private List k;

    public cyr()
    {
        a = new cyv();
        k = new ArrayList();
        c = 0x8000000000000000L;
        e = true;
        f = true;
    }

    private bmt a(long l, long l1)
    {
        Object obj = a;
        if (l1 == 0x7fffffffffffffffL)
        {
            obj = ((cyv) (obj)).a(l);
        } else
        {
            cyt cyt1 = cys.b(l);
            cyt cyt2 = cys.b(1L + l1);
            obj = ((cyv) (obj)).a.subSet(cyt1, cyt2).iterator();
        }
        return new bmt(((Iterator) (obj)));
    }

    private bmt c(long l)
    {
        return new bmt(a.a(l));
    }

    private void d()
    {
        boolean flag;
        if (!g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        if (h == null || h.size() == 0)
        {
            return;
        }
        for (Iterator iterator = h.iterator(); iterator.hasNext();)
        {
            Pair pair = (Pair)iterator.next();
            if (pair.first == i)
            {
                a(new cyq[] {
                    (cyq)pair.second
                });
            } else
            {
                b(new cyq[] {
                    (cyq)pair.second
                });
            }
        }

        h.clear();
    }

    private void d(long l)
    {
        for (Iterator iterator = k.iterator(); iterator.hasNext();)
        {
            iterator.next();
            cyv cyv1 = a;
        }

    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        e = false;
        if (c == d) goto _L2; else goto _L1
_L1:
        b(d);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d(d);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final long a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            e();
        }
        if (l >= c && l > 0x8000000000000000L && l < 0x7fffffffffffffffL) goto _L2; else goto _L1
_L1:
        String s = String.valueOf(Long.toString(l));
        String s1 = String.valueOf(Long.toString(c));
        bmo.c((new StringBuilder(String.valueOf(s).length() + 65 + String.valueOf(s1).length())).append("CueRangeManger state error: currentPosition=").append(s).append(" lastPositionTracked=").append(s1).toString());
        l = 0x7fffffffffffffffL;
_L5:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        if (e)
        {
            bmo.c("CueRangeManger state error: isTrackingPaused = true");
        }
        g = true;
        if (f)
        {
            b = c(c + 1L);
            f = false;
            d(l);
        }
_L3:
        cyq cyq1;
        do
        {
            if (!b.hasNext() || l < ((cyt)b.a()).b)
            {
                break MISSING_BLOCK_LABEL_257;
            }
            cyt cyt1 = (cyt)b.next();
            cyq1 = (cyq)cyt1.c;
            if (cyt1.a != cyu.a)
            {
                break MISSING_BLOCK_LABEL_241;
            }
            cyq1.b(e, false);
        } while (true);
        Exception exception;
        exception;
        throw exception;
        boolean flag = e;
        flag = cyq1.a;
          goto _L3
        long l1;
        c = l;
        g = false;
        d();
        if (!b.hasNext())
        {
            break MISSING_BLOCK_LABEL_304;
        }
        l1 = ((cyt)b.a()).b;
        l = l1 - l;
        continue; /* Loop/switch isn't completed */
        l = 0x7fffffffffffffffL;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        e = false;
        b(0x8000000000000001L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final transient void a(cyq acyq[])
    {
        int l = 0;
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        l = ((flag) ? 1 : 0);
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        h = new ArrayList();
        l = ((flag) ? 1 : 0);
_L4:
        cyq cyq1;
        if (l > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        cyq1 = acyq[0];
        h.add(new Pair(i, cyq1));
        l++;
        if (true) goto _L4; else goto _L3
_L2:
        if (l > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        cyq1 = acyq[0];
        a.a(new cyq[] {
            cyq1
        });
        l++;
        if (true) goto _L2; else goto _L5
_L5:
        f = true;
        d(c);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
        acyq;
        throw acyq;
    }

    public final long b(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (l > 0x8000000000000000L && l < 0x7fffffffffffffffL) goto _L2; else goto _L1
_L1:
        Object obj = String.valueOf(Long.toString(l));
        if (((String) (obj)).length() == 0) goto _L4; else goto _L3
_L3:
        obj = "CueRangeManger state error: newPosition=".concat(((String) (obj)));
_L15:
        bmo.c(((String) (obj)));
_L2:
        d(l);
        if (!e) goto _L6; else goto _L5
_L5:
        long l1 = d;
_L16:
        g = true;
        if (l <= l1) goto _L8; else goto _L7
_L7:
        obj = a(l1, l);
_L17:
        b = ((bmt) (obj));
_L14:
        cyq cyq1;
        boolean flag1;
        boolean flag3;
        if (!b.hasNext())
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj = (cyt)b.next();
        cyq1 = (cyq)((cyt) (obj)).c;
        flag1 = cyq1.a(l1);
        flag3 = cyq1.a(l);
        boolean flag;
        if (((cys) (cyq1)).b.b == ((cys) (cyq1)).c.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 || !flag3) goto _L10; else goto _L9
_L9:
        if (!flag) goto _L12; else goto _L11
_L11:
        if (((cyt) (obj)).a != cyu.b) goto _L12; else goto _L13
_L13:
        flag1 = e;
        flag1 = cyq1.a;
          goto _L14
_L4:
        obj = new String("CueRangeManger state error: newPosition=");
          goto _L15
        obj;
        throw obj;
_L6:
        l1 = c;
          goto _L16
_L8:
        obj = a(l, l1);
          goto _L17
_L12:
        cyq1.b(e, true);
          goto _L14
_L10:
        if (!flag1 || flag3 || flag) goto _L14; else goto _L18
_L18:
        boolean flag2 = e;
        flag2 = cyq1.a;
          goto _L14
        if (!e) goto _L20; else goto _L19
_L19:
        d = l;
_L21:
        b = c(1L + l);
        f = false;
        g = false;
        d();
        if (!b.hasNext())
        {
            break MISSING_BLOCK_LABEL_359;
        }
        l1 = ((cyt)b.a()).b;
        l = l1 - l;
_L22:
        this;
        JVM INSTR monitorexit ;
        return l;
_L20:
        c = l;
          goto _L21
        l = 0x7fffffffffffffffL;
          goto _L22
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        e = true;
        d = c;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final transient void b(cyq acyq[])
    {
        int i1 = 0;
        int l = 0;
        this;
        JVM INSTR monitorenter ;
        if (!g) goto _L2; else goto _L1
_L1:
        if (h == null)
        {
            h = new ArrayList();
        }
        i1 = acyq.length;
_L4:
        cyq cyq1;
        if (l >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        cyq1 = acyq[l];
        h.add(new Pair(j, cyq1));
        l++;
        if (true) goto _L4; else goto _L3
_L2:
        int j1 = acyq.length;
        l = i1;
_L6:
        if (l >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        cyq1 = acyq[l];
        if (cyq1.a && cyq1.a(c))
        {
            boolean flag = e;
            flag = cyq1.a;
        }
        a.b(new cyq[] {
            cyq1
        });
        l++;
        if (true) goto _L6; else goto _L5
_L5:
        f = true;
        d(c);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
        acyq;
        throw acyq;
    }

    public final void c()
    {
        c = 0x8000000000000000L;
        f = true;
        b();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); arraylist.add((cyq)iterator.next())) { }
        b((cyq[])arraylist.toArray(new cyq[0]));
    }

    static 
    {
        i = Boolean.TRUE;
        j = Boolean.FALSE;
    }
}
