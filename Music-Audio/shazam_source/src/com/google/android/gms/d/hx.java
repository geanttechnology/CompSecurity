// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

// Referenced classes of package com.google.android.gms.d:
//            bz, hz, lf, iv, 
//            kq, gs, is

public abstract class hx
    implements Comparable
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/android/gms/d/hx$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("LOW", 0);
            b = new a("NORMAL", 1);
            c = new a("HIGH", 2);
            d = new a("IMMEDIATE", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }


    private final lf.a a;
    private long b;
    final int c;
    final String d;
    final int e;
    final is.a f;
    Integer g;
    hz h;
    boolean i;
    boolean j;
    boolean k;
    iv l;
    z.a m;

    public hx(String s, is.a a1)
    {
        int i1;
        lf.a a2;
        if (lf.a.a)
        {
            a2 = new lf.a();
        } else
        {
            a2 = null;
        }
        a = a2;
        i = true;
        j = false;
        k = false;
        b = 0L;
        m = null;
        c = 0;
        d = s;
        f = a1;
        l = new bz();
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = Uri.parse(s);
        if (s == null) goto _L2; else goto _L3
_L3:
        s = s.getHost();
        if (s == null) goto _L2; else goto _L4
_L4:
        i1 = s.hashCode();
_L6:
        e = i1;
        return;
_L2:
        i1 = 0;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected static kq a(kq kq)
    {
        return kq;
    }

    static lf.a a(hx hx1)
    {
        return hx1.a;
    }

    public static String b()
    {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    protected abstract is a(gs gs);

    public Map a()
    {
        return Collections.emptyMap();
    }

    protected abstract void a(Object obj);

    public final void a(String s)
    {
        if (lf.a.a)
        {
            a.a(s, Thread.currentThread().getId());
        } else
        if (b == 0L)
        {
            b = SystemClock.elapsedRealtime();
            return;
        }
    }

    final void b(String s)
    {
        if (h == null) goto _L2; else goto _L1
_L1:
        hz hz1;
        hz1 = h;
        synchronized (hz1.b)
        {
            hz1.b.remove(this);
        }
        obj = hz1.d;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = hz1.d.iterator(); iterator.hasNext(); iterator.next()) { }
        break MISSING_BLOCK_LABEL_81;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        obj;
        JVM INSTR monitorexit ;
        if (!i) goto _L2; else goto _L3
_L3:
        Map map = hz1.a;
        map;
        JVM INSTR monitorenter ;
        String s1;
        Queue queue;
        s1 = d;
        queue = (Queue)hz1.a.remove(s1);
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (lf.b)
        {
            lf.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
                Integer.valueOf(queue.size()), s1
            });
        }
        hz1.c.addAll(queue);
        map;
        JVM INSTR monitorexit ;
_L2:
        if (!lf.a.a) goto _L5; else goto _L4
_L4:
        long l1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L7; else goto _L6
_L6:
        (new Handler(Looper.getMainLooper())).post(new Runnable(s, l1) {

            final String a;
            final long b;
            final hx c;

            public final void run()
            {
                hx.a(c).a(a, b);
                hx.a(c).a(((Object)this).toString());
            }

            
            {
                c = hx.this;
                a = s;
                b = l1;
                super();
            }
        });
_L9:
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
_L7:
        a.a(s, l1);
        a.a(toString());
        return;
_L5:
        long l2 = SystemClock.elapsedRealtime() - b;
        if (l2 >= 3000L)
        {
            lf.b("%d ms: %s", new Object[] {
                Long.valueOf(l2), toString()
            });
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final int c()
    {
        return l.a();
    }

    public int compareTo(Object obj)
    {
        obj = (hx)obj;
        a a1 = a.b;
        a a2 = a.b;
        if (a1 == a2)
        {
            return g.intValue() - ((hx) (obj)).g.intValue();
        } else
        {
            return a2.ordinal() - a1.ordinal();
        }
    }

    public String toString()
    {
        String s1 = (new StringBuilder("0x")).append(Integer.toHexString(e)).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (j)
        {
            s = "[X] ";
        } else
        {
            s = "[ ] ";
        }
        return stringbuilder.append(s).append(d).append(" ").append(s1).append(" ").append(a.b).append(" ").append(g).toString();
    }
}
