// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

// Referenced classes of package com.mopub.d:
//            d, m, t, p, 
//            s, i, n

public abstract class l
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
            return (a)Enum.valueOf(com/mopub/d/l$a, s);
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


    public final int a;
    public final String b;
    final int c;
    final n.a d;
    Integer e;
    m f;
    public boolean g;
    public boolean h;
    boolean i;
    public p j;
    public b.a k;
    private final t.a l;
    private long m;

    public l(int i1, String s, n.a a1)
    {
        t.a a2;
        if (t.a.a)
        {
            a2 = new t.a();
        } else
        {
            a2 = null;
        }
        l = a2;
        g = true;
        h = false;
        i = false;
        m = 0L;
        k = null;
        a = i1;
        b = s;
        d = a1;
        j = new d();
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
        c = i1;
        return;
_L2:
        i1 = 0;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected static s a(s s)
    {
        return s;
    }

    static t.a a(l l1)
    {
        return l1.l;
    }

    public static byte[] a(Map map, String s)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append('&'))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), s));
                stringbuilder.append('=');
                stringbuilder.append(URLEncoder.encode((String)entry.getValue(), s));
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException((new StringBuilder("Encoding not supported: ")).append(s).toString(), map);
        }
        map = stringbuilder.toString().getBytes(s);
        return map;
    }

    public static String c()
    {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public abstract n a(i i1);

    public Map a()
    {
        return Collections.emptyMap();
    }

    public abstract void a(Object obj);

    public final void a(String s)
    {
        if (t.a.a)
        {
            l.a(s, Thread.currentThread().getId());
        } else
        if (m == 0L)
        {
            m = SystemClock.elapsedRealtime();
            return;
        }
    }

    public Map b()
    {
        return null;
    }

    final void b(String s)
    {
        if (f == null) goto _L2; else goto _L1
_L1:
        m m1;
        m1 = f;
        synchronized (m1.c)
        {
            m1.c.remove(this);
        }
        if (!g) goto _L2; else goto _L3
_L3:
        obj = m1.b;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        Queue queue;
        s1 = b;
        queue = (Queue)m1.b.remove(s1);
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (t.b)
        {
            t.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
                Integer.valueOf(queue.size()), s1
            });
        }
        m1.d.addAll(queue);
        obj;
        JVM INSTR monitorexit ;
_L2:
        if (!t.a.a) goto _L5; else goto _L4
_L4:
        long l1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L7; else goto _L6
_L6:
        (new Handler(Looper.getMainLooper())).post(new Runnable(s, l1) {

            final String a;
            final long b;
            final l c;

            public final void run()
            {
                l.a(c).a(a, b);
                l.a(c).a(((Object)this).toString());
            }

            
            {
                c = l.this;
                a = s;
                b = l2;
                super();
            }
        });
_L9:
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L7:
        l.a(s, l1);
        l.a(toString());
        return;
_L5:
        long l2 = SystemClock.elapsedRealtime() - m;
        if (l2 >= 3000L)
        {
            t.b("%d ms: %s", new Object[] {
                Long.valueOf(l2), toString()
            });
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public int compareTo(Object obj)
    {
        obj = (l)obj;
        a a1 = d();
        a a2 = ((l) (obj)).d();
        if (a1 == a2)
        {
            return e.intValue() - ((l) (obj)).e.intValue();
        } else
        {
            return a2.ordinal() - a1.ordinal();
        }
    }

    public a d()
    {
        return a.b;
    }

    public final int e()
    {
        return j.a();
    }

    public String toString()
    {
        String s1 = (new StringBuilder("0x")).append(Integer.toHexString(c)).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (h)
        {
            s = "[X] ";
        } else
        {
            s = "[ ] ";
        }
        return stringbuilder.append(s).append(b).append(" ").append(s1).append(" ").append(d()).append(" ").append(e).toString();
    }
}
