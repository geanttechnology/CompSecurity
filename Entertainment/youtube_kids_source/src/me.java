// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

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

public abstract class me
    implements Comparable
{

    public final int a;
    final int b;
    Integer c;
    mh d;
    public boolean e;
    boolean f;
    boolean g;
    public mm h;
    public ls i;
    private final mr j;
    private final String k;
    private final mj l;
    private long m;

    public me(int i1, String s, mj mj1)
    {
        mr mr1;
        if (mr.a)
        {
            mr1 = new mr();
        } else
        {
            mr1 = null;
        }
        j = mr1;
        e = true;
        f = false;
        g = false;
        m = 0L;
        i = null;
        a = i1;
        k = s;
        l = mj1;
        h = new lv();
        if (TextUtils.isEmpty(s))
        {
            i1 = 0;
        } else
        {
            i1 = Uri.parse(s).getHost().hashCode();
        }
        b = i1;
    }

    protected static mp a(mp mp)
    {
        return mp;
    }

    static mr a(me me1)
    {
        return me1.j;
    }

    private static byte[] a(Map map, String s)
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

    public String a()
    {
        return k;
    }

    public abstract mi a(mb mb);

    public abstract void a(Object obj);

    public final void a(String s)
    {
        if (mr.a)
        {
            j.a(s, Thread.currentThread().getId());
        } else
        if (m == 0L)
        {
            m = SystemClock.elapsedRealtime();
            return;
        }
    }

    public String b()
    {
        return a();
    }

    final void b(String s)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        mh mh1;
        mh1 = d;
        synchronized (mh1.b)
        {
            mh1.b.remove(this);
        }
        if (!e) goto _L2; else goto _L3
_L3:
        obj = mh1.a;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        Queue queue;
        s1 = b();
        queue = (Queue)mh1.a.remove(s1);
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (mq.a)
        {
            mq.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
                Integer.valueOf(queue.size()), s1
            });
        }
        mh1.c.addAll(queue);
        obj;
        JVM INSTR monitorexit ;
_L2:
        if (!mr.a) goto _L5; else goto _L4
_L4:
        long l1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L7; else goto _L6
_L6:
        (new Handler(Looper.getMainLooper())).post(new mf(this, s, l1));
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
        j.a(s, l1);
        j.a(toString());
        return;
_L5:
        long l2 = SystemClock.elapsedRealtime() - m;
        if (l2 >= 3000L)
        {
            mq.b("%d ms: %s", new Object[] {
                Long.valueOf(l2), toString()
            });
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void b(mp mp)
    {
        if (l != null)
        {
            l.a(mp);
        }
    }

    public Map c()
    {
        return Collections.emptyMap();
    }

    public int compareTo(Object obj)
    {
        obj = (me)obj;
        mg mg1 = i();
        mg mg2 = ((me) (obj)).i();
        if (mg1 == mg2)
        {
            return c.intValue() - ((me) (obj)).c.intValue();
        } else
        {
            return mg2.ordinal() - mg1.ordinal();
        }
    }

    public final String d()
    {
        return g();
    }

    public final byte[] e()
    {
        Map map = f();
        if (map != null && map.size() > 0)
        {
            return a(map, "UTF-8");
        } else
        {
            return null;
        }
    }

    public Map f()
    {
        return null;
    }

    public final String g()
    {
        return (new StringBuilder("application/x-www-form-urlencoded; charset=")).append("UTF-8").toString();
    }

    public byte[] h()
    {
        Map map = f();
        if (map != null && map.size() > 0)
        {
            return a(map, "UTF-8");
        } else
        {
            return null;
        }
    }

    public mg i()
    {
        return mg.a;
    }

    public final int k_()
    {
        return h.a();
    }

    public String toString()
    {
        String s1 = (new StringBuilder("0x")).append(Integer.toHexString(b)).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (f)
        {
            s = "[X] ";
        } else
        {
            s = "[ ] ";
        }
        return stringbuilder.append(s).append(a()).append(" ").append(s1).append(" ").append(i()).append(" ").append(c).toString();
    }
}
