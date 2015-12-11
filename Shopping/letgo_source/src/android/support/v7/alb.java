// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            alh

public final class alb
{
    public static final class a
    {

        private Uri a;
        private int b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private float i;
        private float j;
        private float k;
        private boolean l;
        private List m;
        private android.graphics.Bitmap.Config n;
        private aky.e o;

        public a a(int i1, int j1)
        {
            if (i1 < 0)
            {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (j1 < 0)
            {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (j1 == 0 && i1 == 0)
            {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else
            {
                d = i1;
                e = j1;
                return this;
            }
        }

        public a a(alh alh1)
        {
            if (alh1 == null)
            {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (alh1.a() == null)
            {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
            if (m == null)
            {
                m = new ArrayList(2);
            }
            m.add(alh1);
            return this;
        }

        boolean a()
        {
            return a != null || b != 0;
        }

        boolean b()
        {
            return d != 0 || e != 0;
        }

        public a c()
        {
            if (g)
            {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            } else
            {
                f = true;
                return this;
            }
        }

        public alb d()
        {
            if (g && f)
            {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (f && d == 0 && e == 0)
            {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (g && d == 0 && e == 0)
            {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (o == null)
            {
                o = aky.e.b;
            }
            return new alb(a, b, c, m, d, e, f, g, h, i, j, k, l, n, o);
        }

        a(Uri uri, int i1, android.graphics.Bitmap.Config config)
        {
            a = uri;
            b = i1;
            n = config;
        }
    }


    private static final long s;
    int a;
    long b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final android.graphics.Bitmap.Config q;
    public final aky.e r;

    private alb(Uri uri, int i1, String s1, List list, int j1, int k1, boolean flag, 
            boolean flag1, boolean flag2, float f1, float f2, float f3, boolean flag3, android.graphics.Bitmap.Config config, 
            aky.e e1)
    {
        d = uri;
        e = i1;
        f = s1;
        if (list == null)
        {
            g = null;
        } else
        {
            g = Collections.unmodifiableList(list);
        }
        h = j1;
        i = k1;
        j = flag;
        k = flag1;
        l = flag2;
        m = f1;
        n = f2;
        o = f3;
        p = flag3;
        q = config;
        r = e1;
    }


    String a()
    {
        long l1 = System.nanoTime() - b;
        if (l1 > s)
        {
            return (new StringBuilder()).append(b()).append('+').append(TimeUnit.NANOSECONDS.toSeconds(l1)).append('s').toString();
        } else
        {
            return (new StringBuilder()).append(b()).append('+').append(TimeUnit.NANOSECONDS.toMillis(l1)).append("ms").toString();
        }
    }

    String b()
    {
        return (new StringBuilder()).append("[R").append(a).append(']').toString();
    }

    String c()
    {
        if (d != null)
        {
            return String.valueOf(d.getPath());
        } else
        {
            return Integer.toHexString(e);
        }
    }

    public boolean d()
    {
        return h != 0 || i != 0;
    }

    boolean e()
    {
        return f() || g();
    }

    boolean f()
    {
        return d() || m != 0.0F;
    }

    boolean g()
    {
        return g != null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Request{");
        if (e > 0)
        {
            stringbuilder.append(e);
        } else
        {
            stringbuilder.append(d);
        }
        if (g != null && !g.isEmpty())
        {
            alh alh1;
            for (Iterator iterator = g.iterator(); iterator.hasNext(); stringbuilder.append(' ').append(alh1.a()))
            {
                alh1 = (alh)iterator.next();
            }

        }
        if (f != null)
        {
            stringbuilder.append(" stableKey(").append(f).append(')');
        }
        if (h > 0)
        {
            stringbuilder.append(" resize(").append(h).append(',').append(i).append(')');
        }
        if (j)
        {
            stringbuilder.append(" centerCrop");
        }
        if (k)
        {
            stringbuilder.append(" centerInside");
        }
        if (m != 0.0F)
        {
            stringbuilder.append(" rotation(").append(m);
            if (p)
            {
                stringbuilder.append(" @ ").append(n).append(',').append(o);
            }
            stringbuilder.append(')');
        }
        if (q != null)
        {
            stringbuilder.append(' ').append(q);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    static 
    {
        s = TimeUnit.SECONDS.toNanos(5L);
    }
}
