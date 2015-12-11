// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.e.a;
import e.b.f;
import e.d.d.e;
import e.d.d.i;
import e.h.b;
import e.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package e.d.a:
//            l, a, m

final class n extends j
{

    private static l p[] = new l[0];
    m a;
    private j b;
    private boolean c;
    private volatile e d;
    private volatile b e;
    private volatile ConcurrentLinkedQueue f;
    private e.d.a.a g;
    private volatile boolean h;
    private boolean i;
    private boolean j;
    private Object k;
    private volatile l l[];
    private long m;
    private long n;
    private int o;

    public n(j j1, boolean flag, int i1)
    {
        b = j1;
        c = flag;
        g = e.d.a.a.a();
        k = new Object();
        l = p;
        a(Math.min(i1, e.b));
    }

    private void a(Object obj, long l1)
    {
        boolean flag = false;
        b.a(obj);
_L9:
        if (l1 == 0x7fffffffffffffffL)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        a.addAndGet(-1);
        a(1L);
        this;
        JVM INSTR monitorenter ;
        if (j) goto _L2; else goto _L1
_L1:
        i = false;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        if (c) goto _L4; else goto _L3
_L3:
        android.support.v4.e.a.a(((Throwable) (obj)));
        b();
        a(((Throwable) (obj)));
        return;
        obj;
        flag = true;
_L7:
        if (flag) goto _L6; else goto _L5
_L5:
        this;
        JVM INSTR monitorenter ;
        i = false;
        this;
        JVM INSTR monitorexit ;
_L6:
        throw obj;
_L4:
        e().offer(obj);
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L7; else goto _L2
_L2:
        j = false;
        this;
        JVM INSTR monitorexit ;
        i();
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void b(Object obj)
    {
        e e1;
        e e2 = d;
        e1 = e2;
        if (e2 == null)
        {
            e1 = e.d.d.e.a();
            a(e1);
            d = e1;
        }
        e1.a(e.d.a.a.a(obj));
        f();
_L2:
        return;
        obj;
        b();
        a(((Throwable) (obj)));
        return;
        obj;
        if (!c())
        {
            b();
            a(((Throwable) (obj)));
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private b g()
    {
        b b1;
        b b2;
        b1 = e;
        b2 = b1;
        if (b1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        b1 = e;
        if (b1 != null) goto _L4; else goto _L3
_L3:
        b1 = new b();
        e = b1;
        boolean flag = true;
_L6:
        this;
        JVM INSTR monitorexit ;
        b2 = b1;
        if (flag)
        {
            a(b1);
            b2 = b1;
        }
_L2:
        return b2;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void h()
    {
        ArrayList arraylist = new ArrayList(f);
        if (arraylist.size() == 1)
        {
            b.a((Throwable)arraylist.get(0));
            return;
        } else
        {
            b.a(new e.b.a(arraylist, (byte)0));
            return;
        }
    }

    private void i()
    {
        int i1;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        i1 = ((flag1) ? 1 : 0);
        j j1 = b;
_L63:
        i1 = ((flag1) ? 1 : 0);
        if (j())
        {
            return;
        }
        i1 = ((flag1) ? 1 : 0);
        Object obj2 = d;
        i1 = ((flag1) ? 1 : 0);
        long l3 = a.get();
        Object obj;
        Object obj1;
        int l1;
        int i2;
        int j2;
        boolean flag;
        int i3;
        int j3;
        int k3;
        long l4;
        e.k k1;
        l al[];
        e e1;
        int k2;
        int l2;
        boolean flag3;
        if (l3 == 0x7fffffffffffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1 = 0;
        l1 = 0;
        l4 = l3;
          goto _L1
_L7:
        obj1 = obj;
        if (l3 <= 0L) goto _L3; else goto _L2
_L2:
        i1 = ((flag1) ? 1 : 0);
        obj = ((e) (obj2)).g();
        i1 = ((flag1) ? 1 : 0);
        if (j()) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        if (obj == null) goto _L3; else goto _L6
_L6:
        i1 = ((flag1) ? 1 : 0);
        obj1 = e.d.a.a.c(obj);
        i1 = ((flag1) ? 1 : 0);
        j1.a(obj1);
_L10:
        l3--;
        l1++;
        i2++;
          goto _L7
        obj1;
        i1 = ((flag1) ? 1 : 0);
        if (c)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        i1 = ((flag1) ? 1 : 0);
        android.support.v4.e.a.a(((Throwable) (obj1)));
        l1 = 1;
        i1 = l1;
        b();
        i1 = l1;
        j1.a(((Throwable) (obj1)));
        return;
        obj;
        if (i1 != 0) goto _L9; else goto _L8
_L8:
        this;
        JVM INSTR monitorenter ;
        i = false;
        this;
        JVM INSTR monitorexit ;
_L9:
        throw obj;
        i1 = ((flag1) ? 1 : 0);
        e().offer(obj1);
          goto _L10
_L66:
        i1 = ((flag1) ? 1 : 0);
        flag3 = h;
        i1 = ((flag1) ? 1 : 0);
        obj = d;
        i1 = ((flag1) ? 1 : 0);
        obj2 = l;
        i1 = ((flag1) ? 1 : 0);
        k3 = obj2.length;
        if (!flag3) goto _L12; else goto _L11
_L11:
        if (obj == null) goto _L14; else goto _L13
_L13:
        i1 = ((flag1) ? 1 : 0);
        if (!((e) (obj)).f()) goto _L12; else goto _L14
_L14:
        if (k3 != 0) goto _L12; else goto _L15
_L15:
        i1 = ((flag1) ? 1 : 0);
        obj1 = f;
        if (obj1 == null) goto _L17; else goto _L16
_L16:
        i1 = ((flag1) ? 1 : 0);
        if (!((Queue) (obj1)).isEmpty()) goto _L18; else goto _L17
_L17:
        i1 = ((flag1) ? 1 : 0);
        j1.a();
_L21:
        if (obj == null) goto _L5; else goto _L19
_L19:
        i1 = ((flag1) ? 1 : 0);
        ((e) (obj)).e();
        return;
_L69:
        i1 = ((flag1) ? 1 : 0);
        l3 = a.addAndGet(-l1);
          goto _L20
_L18:
        i1 = ((flag1) ? 1 : 0);
        h();
          goto _L21
_L12:
        if (k3 <= 0) goto _L23; else goto _L22
_L22:
        i1 = ((flag1) ? 1 : 0);
        l3 = n;
        i1 = ((flag1) ? 1 : 0);
        j2 = o;
        if (k3 <= j2) goto _L25; else goto _L24
_L24:
        i1 = ((flag1) ? 1 : 0);
        i2 = j2;
        if (((l) (obj2[j2])).a == l3) goto _L26; else goto _L25
_L73:
        if (j2 >= k3) goto _L28; else goto _L27
_L27:
        i1 = ((flag1) ? 1 : 0);
        if (((l) (obj2[i2])).a == l3) goto _L28; else goto _L29
_L28:
        i1 = ((flag1) ? 1 : 0);
        o = i2;
        i1 = ((flag1) ? 1 : 0);
        n = ((l) (obj2[i2])).a;
          goto _L26
_L56:
        l2 = i2;
        i1 = l1;
        if (j3 >= k3) goto _L31; else goto _L30
_L30:
        i1 = ((flag1) ? 1 : 0);
        if (j()) goto _L5; else goto _L32
_L32:
        k1 = obj2[i3];
        obj1 = null;
        l4 = l3;
          goto _L33
_L39:
        obj = obj1;
        if (l3 <= 0L) goto _L35; else goto _L34
_L34:
        i1 = ((flag1) ? 1 : 0);
        if (j()) goto _L5; else goto _L36
_L36:
        i1 = ((flag1) ? 1 : 0);
        e1 = ((l) (k1)).c;
        obj = obj1;
        if (e1 == null) goto _L35; else goto _L37
_L37:
        i1 = ((flag1) ? 1 : 0);
        obj1 = e1.g();
        obj = obj1;
        if (obj1 == null) goto _L35; else goto _L38
_L38:
        i1 = ((flag1) ? 1 : 0);
        obj = e.d.a.a.c(obj1);
        i1 = ((flag1) ? 1 : 0);
        j1.a(obj);
        j2++;
        l3--;
          goto _L39
        obj;
        l1 = 1;
        i1 = l1;
        android.support.v4.e.a.a(((Throwable) (obj)));
        j1.a(((Throwable) (obj)));
        i1 = l1;
        b();
        return;
        obj;
        i1 = l1;
        b();
        i1 = l1;
        throw obj;
_L35:
        if (j2 <= 0) goto _L41; else goto _L40
_L40:
        if (flag) goto _L43; else goto _L42
_L42:
        i1 = ((flag1) ? 1 : 0);
        l3 = a.addAndGet(-j2);
_L57:
        i1 = ((flag1) ? 1 : 0);
        k1.b(j2);
          goto _L41
_L74:
        i1 = ((flag1) ? 1 : 0);
        flag3 = ((l) (k1)).b;
        i1 = ((flag1) ? 1 : 0);
        obj = ((l) (k1)).c;
        k2 = i2;
        j2 = l1;
        if (!flag3) goto _L45; else goto _L44
_L44:
        if (obj == null) goto _L47; else goto _L46
_L46:
        i1 = ((flag1) ? 1 : 0);
        k2 = i2;
        j2 = l1;
        if (!((e) (obj)).f()) goto _L45; else goto _L47
_L47:
        i1 = ((flag1) ? 1 : 0);
        obj = ((l) (k1)).c;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_788;
        }
        i1 = ((flag1) ? 1 : 0);
        ((e) (obj)).e();
        i1 = ((flag1) ? 1 : 0);
        e.b(k1);
        i1 = ((flag1) ? 1 : 0);
        obj = k;
        i1 = ((flag1) ? 1 : 0);
        obj;
        JVM INSTR monitorenter ;
        obj1 = l;
        i2 = obj1.length;
        i1 = 0;
_L58:
        if (i1 >= i2) goto _L49; else goto _L48
_L48:
        if (!k1.equals(obj1[i1])) goto _L51; else goto _L50
_L50:
        if (i1 >= 0) goto _L53; else goto _L52
_L52:
        obj;
        JVM INSTR monitorexit ;
_L59:
        i1 = ((flag1) ? 1 : 0);
        flag3 = j();
        if (flag3) goto _L5; else goto _L54
_L54:
        j2 = l1 + 1;
        k2 = 1;
_L45:
        l2 = k2;
        i1 = j2;
        if (l3 == 0L) goto _L31; else goto _L55
_L55:
        l1 = i3 + 1;
        i1 = l1;
        if (l1 == k3)
        {
            i1 = 0;
        }
        j3++;
        i2 = k2;
        l1 = j2;
        i3 = i1;
          goto _L56
_L43:
        l3 = 0x7fffffffffffffffL;
          goto _L57
_L51:
        i1++;
          goto _L58
_L53:
        if (i2 != 1)
        {
            break MISSING_BLOCK_LABEL_978;
        }
        l = p;
        obj;
        JVM INSTR monitorexit ;
          goto _L59
        obj1;
        obj;
        JVM INSTR monitorexit ;
        i1 = ((flag1) ? 1 : 0);
        throw obj1;
        al = new l[i2 - 1];
        System.arraycopy(obj1, 0, al, 0, i1);
        System.arraycopy(obj1, i1 + 1, al, i1, i2 - i1 - 1);
        l = al;
        obj;
        JVM INSTR monitorexit ;
          goto _L59
_L31:
        l1 = i1;
        i1 = ((flag1) ? 1 : 0);
        o = i3;
        i1 = ((flag1) ? 1 : 0);
        n = ((l) (obj2[i3])).a;
_L64:
        if (l1 <= 0) goto _L61; else goto _L60
_L60:
        i1 = ((flag1) ? 1 : 0);
        a(l1);
_L61:
        if (l2 != 0) goto _L63; else goto _L62
_L62:
        i1 = ((flag1) ? 1 : 0);
        this;
        JVM INSTR monitorenter ;
        i1 = ((flag2) ? 1 : 0);
        if (j)
        {
            break MISSING_BLOCK_LABEL_1119;
        }
        l1 = 1;
        i1 = l1;
        i = false;
        i1 = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        i1 = ((flag2) ? 1 : 0);
        j = false;
        i1 = ((flag2) ? 1 : 0);
        this;
        JVM INSTR monitorexit ;
          goto _L63
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L49:
        i1 = -1;
          goto _L50
_L23:
        l2 = 0;
          goto _L64
_L5:
        return;
_L1:
        if (obj2 == null) goto _L66; else goto _L65
_L65:
        l4 = l3;
_L72:
        l1 = 0;
        obj = null;
        i2 = i1;
        l3 = l4;
          goto _L7
_L3:
        if (l1 <= 0) goto _L20; else goto _L67
_L67:
        if (!flag) goto _L69; else goto _L68
_L68:
        l3 = 0x7fffffffffffffffL;
_L20:
        l1 = i2;
        l4 = l3;
        if (l3 == 0L) goto _L66; else goto _L70
_L70:
        i1 = i2;
        l4 = l3;
        if (obj1 != null) goto _L72; else goto _L71
_L71:
        l1 = i2;
        l4 = l3;
          goto _L66
_L25:
        i2 = j2;
        if (k3 <= j2)
        {
            i2 = 0;
        }
        j2 = 0;
          goto _L73
_L29:
        i1 = i2 + 1;
        i2 = i1;
        if (i1 == k3)
        {
            i2 = 0;
        }
        j2++;
          goto _L73
_L26:
        j3 = 0;
        i3 = i2;
        i2 = 0;
        l3 = l4;
          goto _L56
_L33:
        j2 = 0;
        l3 = l4;
          goto _L39
_L41:
        if (l3 == 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        l4 = l3;
        if (obj != null) goto _L33; else goto _L74
    }

    private boolean j()
    {
        if (b.c())
        {
            return true;
        }
        ConcurrentLinkedQueue concurrentlinkedqueue = f;
        if (c || concurrentlinkedqueue == null || concurrentlinkedqueue.isEmpty())
        {
            break MISSING_BLOCK_LABEL_54;
        }
        h();
        b();
        return true;
        Exception exception;
        exception;
        b();
        throw exception;
        return false;
    }

    public final void a()
    {
        h = true;
        f();
    }

    final void a(l l1, Object obj)
    {
        boolean flag1;
        long l2;
        flag1 = false;
        l2 = a.get();
        if (l2 == 0L)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        this;
        JVM INSTR monitorenter ;
        l2 = a.get();
        if (i || l2 == 0L) goto _L2; else goto _L1
_L1:
        i = true;
        boolean flag = true;
_L15:
        this;
        JVM INSTR monitorexit ;
_L16:
        if (!flag) goto _L4; else goto _L3
_L3:
        b.a(obj);
_L11:
        if (l2 == 0x7fffffffffffffffL)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        a.addAndGet(-1);
        l1.b(1L);
        this;
        JVM INSTR monitorenter ;
        if (j) goto _L6; else goto _L5
_L5:
        i = false;
        this;
        JVM INSTR monitorexit ;
_L14:
        return;
        l1;
        this;
        JVM INSTR monitorexit ;
        throw l1;
        obj;
        if (c) goto _L8; else goto _L7
_L7:
        android.support.v4.e.a.a(((Throwable) (obj)));
        l1.b();
        l1.a(((Throwable) (obj)));
        return;
        l1;
        flag = true;
_L12:
        if (flag) goto _L10; else goto _L9
_L9:
        this;
        JVM INSTR monitorenter ;
        i = false;
        this;
        JVM INSTR monitorexit ;
_L10:
        throw l1;
_L8:
        e().offer(obj);
          goto _L11
        l1;
        flag = flag1;
          goto _L12
_L6:
        j = false;
        this;
        JVM INSTR monitorexit ;
        i();
        return;
        l1;
        this;
        JVM INSTR monitorexit ;
        throw l1;
        l1;
        this;
        JVM INSTR monitorexit ;
        throw l1;
_L4:
        e e1;
        e e2 = l1.c;
        e1 = e2;
        if (e2 == null)
        {
            e1 = e.d.d.e.a();
            l1.a(e1);
            l1.c = e1;
        }
        e1.a(e.d.a.a.a(obj));
        f();
        return;
        obj;
        l1.b();
        l1.a(((Throwable) (obj)));
        return;
        obj;
        if (l1.c()) goto _L14; else goto _L13
_L13:
        l1.b();
        l1.a(((Throwable) (obj)));
        return;
_L2:
        flag = false;
          goto _L15
        flag = false;
          goto _L16
    }

    public final void a(Object obj)
    {
        e.a a1;
        int i1;
        boolean flag;
        long l2;
        long l4;
        i1 = 0;
        flag = false;
        a1 = (e.a)obj;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (!(a1 instanceof i))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = ((i)a1).b();
        l4 = a.get();
        l2 = l4;
        if (l4 == 0L) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        l2 = a.get();
        i1 = ((flag) ? 1 : 0);
        if (i)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        i1 = ((flag) ? 1 : 0);
        if (l2 == 0L)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        i = true;
        i1 = 1;
        this;
        JVM INSTR monitorexit ;
_L2:
        if (!i1)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        a(obj, l2);
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        b(obj);
        return;
        l l1;
        long l3 = m;
        m = 1L + l3;
        l1 = new l(this, l3);
        g().a(l1);
        obj = k;
        obj;
        JVM INSTR monitorenter ;
        l al1[];
        l al[] = l;
        i1 = al.length;
        al1 = new l[i1 + 1];
        System.arraycopy(al, 0, al1, 0, i1);
        al1[i1] = l1;
        l = al1;
        obj;
        JVM INSTR monitorexit ;
        a1.a(l1);
        f();
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(Throwable throwable)
    {
        e().offer(throwable);
        h = true;
        f();
    }

    final Queue e()
    {
        Object obj;
        obj = f;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        this;
        JVM INSTR monitorenter ;
        ConcurrentLinkedQueue concurrentlinkedqueue = f;
        obj = concurrentlinkedqueue;
        if (concurrentlinkedqueue != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj = new ConcurrentLinkedQueue();
        f = ((ConcurrentLinkedQueue) (obj));
        this;
        JVM INSTR monitorexit ;
        return ((Queue) (obj));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        return ((Queue) (obj));
    }

    final void f()
    {
        this;
        JVM INSTR monitorenter ;
        if (!i)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        j = true;
        this;
        JVM INSTR monitorexit ;
        return;
        i = true;
        this;
        JVM INSTR monitorexit ;
        i();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
