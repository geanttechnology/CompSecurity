// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

final class anp
    implements android.os.Handler.Callback
{

    final Handler a;
    final HandlerThread b = new atk(String.valueOf(getClass().getSimpleName()).concat(":Handler"), -16);
    int c;
    volatile long d;
    volatile long e;
    volatile long f;
    private final Handler g;
    private final anr h = new anr();
    private final boolean i[];
    private final long j;
    private final long k;
    private final List l;
    private aou m[];
    private aou n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private long t;

    public anp(Handler handler, boolean flag, boolean aflag[], int i1, int j1)
    {
        boolean flag1 = false;
        super();
        c = 0;
        s = 0;
        g = handler;
        p = flag;
        i = new boolean[aflag.length];
        j = (long)i1 * 1000L;
        k = (long)j1 * 1000L;
        for (i1 = ((flag1) ? 1 : 0); i1 < aflag.length; i1++)
        {
            i[i1] = aflag[i1];
        }

        r = 1;
        d = -1L;
        f = -1L;
        l = new ArrayList(aflag.length);
        b.start();
        a = new Handler(b.getLooper(), this);
    }

    private void a(int i1)
    {
        if (r != i1)
        {
            r = i1;
            g.obtainMessage(1, i1, 0).sendToTarget();
        }
    }

    private void a(int i1, long l1, long l2)
    {
        l1 = (l1 + l2) - SystemClock.elapsedRealtime();
        if (l1 <= 0L)
        {
            a.sendEmptyMessage(i1);
            return;
        } else
        {
            a.sendEmptyMessageDelayed(i1, l1);
            return;
        }
    }

    private boolean a(aou aou1)
    {
        if (!aou1.d())
        {
            if (!aou1.e())
            {
                return false;
            }
            if (r != 4)
            {
                long l2 = aou1.m();
                long l3 = aou1.n();
                long l1;
                if (q)
                {
                    l1 = k;
                } else
                {
                    l1 = j;
                }
                if (l1 > 0L && l3 != -1L && l3 != -3L && l3 < l1 + e && (l2 == -1L || l2 == -2L || l3 < l2))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void b()
    {
        q = false;
        anr anr1 = h;
        if (!anr1.a)
        {
            anr1.a = true;
            anr1.c = anr.b(anr1.b);
        }
        for (int i1 = 0; i1 < l.size(); i1++)
        {
            ((aou)l.get(i1)).p();
        }

    }

    private static void b(aou aou1)
    {
        if (aou1.g == 3)
        {
            aou1.q();
        }
    }

    private void c()
    {
        h.a();
        for (int i1 = 0; i1 < l.size(); i1++)
        {
            b((aou)l.get(i1));
        }

    }

    private void d()
    {
        long l1;
        if (n != null && l.contains(n))
        {
            l1 = n.f();
        } else
        {
            anr anr1 = h;
            if (anr1.a)
            {
                l1 = anr.b(anr1.c);
            } else
            {
                l1 = anr1.b;
            }
        }
        e = l1;
        t = SystemClock.elapsedRealtime() * 1000L;
    }

    private void e()
    {
        q = false;
        f();
    }

    private void f()
    {
        a.removeMessages(7);
        a.removeMessages(2);
        h.a();
        if (m == null)
        {
            return;
        }
        int i1 = 0;
        while (i1 < m.length) 
        {
            aou aou1 = m[i1];
            try
            {
                b(aou1);
                if (aou1.g == 2)
                {
                    aou1.r();
                }
            }
            catch (ank ank2)
            {
                Log.e("ExoPlayerImplInternal", "Stop failed.", ank2);
            }
            catch (RuntimeException runtimeexception1)
            {
                Log.e("ExoPlayerImplInternal", "Stop failed.", runtimeexception1);
            }
            try
            {
                aou1.s();
            }
            catch (ank ank1)
            {
                Log.e("ExoPlayerImplInternal", "Release failed.", ank1);
            }
            catch (RuntimeException runtimeexception)
            {
                Log.e("ExoPlayerImplInternal", "Release failed.", runtimeexception);
            }
            i1++;
        }
        m = null;
        n = null;
        l.clear();
        a(1);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = o;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.sendEmptyMessage(5);
_L3:
        flag = o;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        wait();
          goto _L3
        Object obj;
        obj;
        Thread.currentThread().interrupt();
          goto _L3
        obj;
        throw obj;
        b.quit();
          goto _L1
    }

    public final void a(anm anm1, int i1, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!o) goto _L2; else goto _L1
_L1:
        Log.w("ExoPlayerImplInternal", (new StringBuilder(57)).append("Sent message(").append(i1).append(") after release. Message ignored.").toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j1;
        j1 = c;
        c = j1 + 1;
        a.obtainMessage(9, i1, 0, Pair.create(anm1, obj)).sendToTarget();
_L5:
        i1 = s;
        if (i1 > j1) goto _L4; else goto _L3
_L3:
        wait();
          goto _L5
        anm1;
        Thread.currentThread().interrupt();
          goto _L5
        anm1;
        throw anm1;
    }

    public final boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 9: default 1407
    //                   1 56
    //                   2 132
    //                   3 522
    //                   4 1078
    //                   5 1084
    //                   6 950
    //                   7 637
    //                   8 1217
    //                   9 1108;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        message = (aou[])message.obj;
        q = false;
        m = message;
        int i1 = 0;
_L89:
        int j1;
        int k1;
        int l1;
        int i2;
        long l2;
        long l3;
        long l4;
        long l5;
        boolean flag;
        if (i1 < message.length)
        {
            if (message[i1].a())
            {
                if (n == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                try
                {
                    a.b(flag);
                    n = message[i1];
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.e("ExoPlayerImplInternal", "Internal track renderer error.", message);
                    g.obtainMessage(3, message).sendToTarget();
                    e();
                    return true;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.e("ExoPlayerImplInternal", "Internal runtime error.", message);
                    g.obtainMessage(3, new ank(message)).sendToTarget();
                    e();
                    return true;
                }
            }
            i1++;
            continue; /* Loop/switch isn't completed */
        }
        a(2);
        a.sendEmptyMessage(2);
        return true;
_L3:
        l2 = SystemClock.elapsedRealtime();
        j1 = 1;
        i1 = 0;
_L79:
        if (i1 >= m.length) goto _L12; else goto _L11
_L11:
        k1 = j1;
        if (m[i1].g != 0) goto _L14; else goto _L13
_L13:
        k1 = j1;
        if (m[i1].o() == 0)
        {
            k1 = 0;
        }
          goto _L14
_L12:
        if (j1 != 0) goto _L16; else goto _L15
_L15:
        a(2, l2, 10L);
          goto _L17
_L80:
        if (k1 >= m.length) goto _L19; else goto _L18
_L18:
        message = m[k1];
        l1 = j1;
        i2 = i1;
        l2 = l3;
        if (!i[k1]) goto _L21; else goto _L20
_L20:
        l1 = j1;
        i2 = i1;
        l2 = l3;
        if (((aou) (message)).g != 1) goto _L21; else goto _L22
_L22:
        message.b(e, false);
        l.add(message);
        if (i1 == 0) goto _L24; else goto _L23
_L23:
        if (!message.d()) goto _L24; else goto _L25
_L25:
        i1 = 1;
_L81:
        if (j1 == 0) goto _L27; else goto _L26
_L26:
        if (!a(message)) goto _L27; else goto _L28
_L28:
        j1 = 1;
_L82:
        l1 = j1;
        i2 = i1;
        l2 = l3;
        if (l3 == -1L) goto _L21; else goto _L29
_L29:
        l4 = message.m();
        if (l4 != -1L) goto _L31; else goto _L30
_L30:
        l2 = -1L;
        l1 = j1;
        i2 = i1;
          goto _L21
_L31:
        l1 = j1;
        i2 = i1;
        l2 = l3;
        if (l4 == -2L) goto _L21; else goto _L32
_L32:
        l2 = Math.max(l3, l4);
        l1 = j1;
        i2 = i1;
          goto _L21
_L19:
        d = l3;
        if (i1 == 0) goto _L34; else goto _L33
_L33:
        a(5);
_L35:
        a.sendEmptyMessage(7);
          goto _L17
_L34:
        if (j1 != 0)
        {
            i1 = 4;
        } else
        {
            i1 = 3;
        }
        a(i1);
        if (p && r == 4)
        {
            b();
        }
          goto _L35
_L4:
        i1 = message.arg1;
        if (i1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = false;
        p = flag;
        if (flag) goto _L37; else goto _L36
_L36:
        c();
        d();
_L40:
        g.obtainMessage(2).sendToTarget();
        return true;
_L37:
        if (r != 4) goto _L39; else goto _L38
_L38:
        b();
        a.sendEmptyMessage(7);
          goto _L40
        message;
        g.obtainMessage(2).sendToTarget();
        throw message;
_L39:
        if (r != 3) goto _L40; else goto _L41
_L41:
        a.sendEmptyMessage(7);
          goto _L40
_L8:
        a.g("doSomeWork");
        l3 = SystemClock.elapsedRealtime();
        if (d == -1L) goto _L43; else goto _L42
_L42:
        l2 = d;
_L84:
        i1 = 1;
        j1 = 1;
        d();
        k1 = 0;
_L83:
        if (k1 >= l.size()) goto _L45; else goto _L44
_L44:
        message = (aou)l.get(k1);
        message.a(e, t);
        if (i1 == 0) goto _L47; else goto _L46
_L46:
        if (!message.d()) goto _L47; else goto _L48
_L48:
        i1 = 1;
_L85:
        if (j1 == 0) goto _L50; else goto _L49
_L49:
        if (!a(message)) goto _L50; else goto _L51
_L51:
        j1 = 1;
_L86:
        if (l2 == -1L) goto _L53; else goto _L52
_L52:
        l4 = message.m();
        l5 = message.n();
        if (l5 != -1L) goto _L55; else goto _L54
_L54:
        l2 = -1L;
          goto _L53
_L87:
        l2 = Math.min(l2, l5);
          goto _L53
_L45:
        f = l2;
        if (i1 == 0) goto _L57; else goto _L56
_L56:
        a(5);
        c();
_L62:
        a.removeMessages(7);
        if ((!p || r != 4) && r != 3) goto _L59; else goto _L58
_L58:
        a(7, l3, 10L);
_L65:
        a.c();
        return true;
_L57:
        if (r != 3 || j1 == 0) goto _L61; else goto _L60
_L60:
        a(4);
        if (p)
        {
            b();
        }
          goto _L62
_L61:
        if (r != 4 || j1 != 0) goto _L62; else goto _L63
_L63:
        q = p;
        a(3);
        c();
          goto _L62
_L59:
        if (l.isEmpty()) goto _L65; else goto _L64
_L64:
        a(7, l3, 1000L);
          goto _L65
_L7:
        l2 = ((Long)message.obj).longValue();
        q = false;
        e = l2 * 1000L;
        h.a();
        h.a(e);
        if (r != 1 && r != 2) goto _L67; else goto _L66
_L70:
        if (i1 >= l.size()) goto _L69; else goto _L68
_L68:
        message = (aou)l.get(i1);
        b(message);
        message.a(e);
        i1++;
          goto _L70
_L69:
        a(3);
        a.sendEmptyMessage(7);
          goto _L66
_L5:
        e();
        return true;
_L6:
        f();
        this;
        JVM INSTR monitorenter ;
        o = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return true;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
_L10:
        i1 = message.arg1;
        message = ((Message) (message.obj));
        message = (Pair)message;
        ((anm)((Pair) (message)).first).a(i1, ((Pair) (message)).second);
        this;
        JVM INSTR monitorenter ;
        s = s + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (r != 1 && r != 2)
        {
            a.sendEmptyMessage(7);
        }
        return true;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
        message;
        this;
        JVM INSTR monitorenter ;
        s = s + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw message;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
_L9:
        i1 = message.arg1;
        if (message.arg2 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i[i1] == flag) goto _L72; else goto _L71
_L71:
        i[i1] = flag;
        if (r != 1 && r != 2) goto _L73; else goto _L72
_L73:
        message = m[i1];
        i1 = ((aou) (message)).g;
        if (i1 != 1 && i1 != 2 && i1 != 3) goto _L72; else goto _L74
_L74:
        if (!flag) goto _L76; else goto _L75
_L75:
        if (p && r == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message.b(e, flag);
        l.add(message);
        if (!flag) goto _L78; else goto _L77
_L77:
        message.p();
_L78:
        a.sendEmptyMessage(7);
          goto _L72
_L76:
        if (message == n)
        {
            h.a(message.f());
        }
        b(message);
        l.remove(message);
        message.r();
          goto _L72
_L1:
        return false;
_L14:
        i1++;
        j1 = k1;
          goto _L79
_L17:
        return true;
_L16:
        j1 = 1;
        i1 = 1;
        l3 = 0L;
        k1 = 0;
          goto _L80
_L21:
        k1++;
        j1 = l1;
        i1 = i2;
        l3 = l2;
          goto _L80
_L24:
        i1 = 0;
          goto _L81
_L27:
        j1 = 0;
          goto _L82
_L53:
        k1++;
          goto _L83
_L43:
        l2 = 0x7fffffffffffffffL;
          goto _L84
_L47:
        i1 = 0;
          goto _L85
_L50:
        j1 = 0;
          goto _L86
_L55:
        if (l5 == -3L || l4 != -1L && l4 != -2L && l5 >= l4) goto _L53; else goto _L87
_L66:
        return true;
_L67:
        i1 = 0;
          goto _L70
_L72:
        return true;
        if (true) goto _L89; else goto _L88
_L88:
    }
}
