// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import java.util.Set;

// Referenced classes of package android.support.v7:
//            oq, lo, vg, yd, 
//            vz, tv, vw, xs

public abstract class ve
    implements Comparable
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(android/support/v7/ve$a, s1);
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

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private final yd.a a;
    private final int b;
    private final String c;
    private final int d;
    private final vw.a e;
    private Integer f;
    private vg g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private vz l;
    private mo.a m;

    public ve(int i1, String s1, vw.a a1)
    {
        yd.a a2;
        if (yd.a.a)
        {
            a2 = new yd.a();
        } else
        {
            a2 = null;
        }
        a = a2;
        h = true;
        i = false;
        j = false;
        k = 0L;
        m = null;
        b = i1;
        c = s1;
        e = a1;
        a(new oq());
        d = a(s1);
    }

    private static int a(String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            s1 = Uri.parse(s1);
            if (s1 != null)
            {
                s1 = s1.getHost();
                if (s1 != null)
                {
                    return s1.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] a(Map map, String s1)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        try
        {
            for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append('&'))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), s1));
                stringbuilder.append('=');
                stringbuilder.append(URLEncoder.encode((String)entry.getValue(), s1));
            }

        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException((new StringBuilder()).append("Encoding not supported: ").append(s1).toString(), map);
        }
        map = stringbuilder.toString().getBytes(s1);
        return map;
    }

    static yd.a b(ve ve1)
    {
        return ve1.a;
    }

    public int a(ve ve1)
    {
        a a1 = q();
        a a2 = ve1.q();
        if (a1 == a2)
        {
            return f.intValue() - ve1.f.intValue();
        } else
        {
            return a2.ordinal() - a1.ordinal();
        }
    }

    public final ve a(int i1)
    {
        f = Integer.valueOf(i1);
        return this;
    }

    public ve a(mo.a a1)
    {
        m = a1;
        return this;
    }

    public ve a(vg vg1)
    {
        g = vg1;
        return this;
    }

    public ve a(vz vz1)
    {
        l = vz1;
        return this;
    }

    protected abstract vw a(tv tv);

    protected xs a(xs xs)
    {
        return xs;
    }

    public Map a()
        throws lo
    {
        return Collections.emptyMap();
    }

    protected abstract void a(Object obj);

    public int b()
    {
        return b;
    }

    public void b(xs xs)
    {
        if (e != null)
        {
            e.a(xs);
        }
    }

    public void b(String s1)
    {
        if (yd.a.a)
        {
            a.a(s1, Thread.currentThread().getId());
        } else
        if (k == 0L)
        {
            k = SystemClock.elapsedRealtime();
            return;
        }
    }

    public int c()
    {
        return d;
    }

    void c(String s1)
    {
        if (g != null)
        {
            g.b(this);
        }
        if (!yd.a.a) goto _L2; else goto _L1
_L1:
        long l1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto _L4; else goto _L3
_L3:
        (new Handler(Looper.getMainLooper())).post(new Runnable(s1, l1) {

            final String a;
            final long b;
            final ve c;

            public void run()
            {
                ve.b(c).a(a, b);
                ve.b(c).a(((Object)this).toString());
            }

            
            {
                c = ve.this;
                a = s1;
                b = l1;
                super();
            }
        });
_L6:
        return;
_L4:
        a.a(s1, l1);
        a.a(toString());
        return;
_L2:
        long l2 = SystemClock.elapsedRealtime() - k;
        if (l2 >= 3000L)
        {
            yd.b("%d ms: %s", new Object[] {
                Long.valueOf(l2), toString()
            });
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int compareTo(Object obj)
    {
        return a((ve)obj);
    }

    public String d()
    {
        return c;
    }

    public String e()
    {
        return d();
    }

    public mo.a f()
    {
        return m;
    }

    public boolean g()
    {
        return i;
    }

    protected Map h()
        throws lo
    {
        return l();
    }

    protected String i()
    {
        return m();
    }

    public String j()
    {
        return n();
    }

    public byte[] k()
        throws lo
    {
        Map map = h();
        if (map != null && map.size() > 0)
        {
            return a(map, i());
        } else
        {
            return null;
        }
    }

    protected Map l()
        throws lo
    {
        return null;
    }

    protected String m()
    {
        return "UTF-8";
    }

    public String n()
    {
        return (new StringBuilder()).append("application/x-www-form-urlencoded; charset=").append(m()).toString();
    }

    public byte[] o()
        throws lo
    {
        Map map = l();
        if (map != null && map.size() > 0)
        {
            return a(map, m());
        } else
        {
            return null;
        }
    }

    public final boolean p()
    {
        return h;
    }

    public a q()
    {
        return a.b;
    }

    public final int r()
    {
        return l.a();
    }

    public vz s()
    {
        return l;
    }

    public void t()
    {
        j = true;
    }

    public String toString()
    {
        String s2 = (new StringBuilder()).append("0x").append(Integer.toHexString(c())).toString();
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        if (i)
        {
            s1 = "[X] ";
        } else
        {
            s1 = "[ ] ";
        }
        return stringbuilder.append(s1).append(d()).append(" ").append(s2).append(" ").append(q()).append(" ").append(f).toString();
    }

    public boolean u()
    {
        return j;
    }
}
