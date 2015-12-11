// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;

import com.shazam.android.af.b.a.b;
import com.shazam.android.af.b.a.c;
import com.shazam.android.af.b.a.d;
import com.shazam.android.af.b.a.e;
import com.shazam.android.af.b.a.g;
import com.shazam.i.e.a;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.shazam.android.af.b:
//            d, a, g

public abstract class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    private static final f i[];
    protected final Map f;
    protected final Map g;
    protected final Map h;

    private f(String s, int j)
    {
        super(s, j);
        f = com.shazam.i.e.a.a(0);
        g = new EnumMap(com/shazam/android/af/b/d);
        h = new EnumMap(com/shazam/android/af/b/d);
    }

    f(String s, int j, byte byte0)
    {
        this(s, j);
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/shazam/android/af/b/f, s);
    }

    public static f[] values()
    {
        return (f[])i.clone();
    }

    protected abstract void a();

    public final void a(com.shazam.android.af.b.d d1, com.shazam.android.af.b.a a1)
    {
label0:
        {
            f f1;
label1:
            {
                if (!g.containsKey(d1))
                {
                    break label0;
                }
                f1 = (f)g.get(d1);
                if (f1 != null)
                {
                    d1 = (c)h.get(d1);
                    if (d1 != null)
                    {
                        d1.a(a1);
                    }
                    d1 = (c)f.get(f1);
                    if (d1 == null)
                    {
                        break label1;
                    }
                    a1.a(d1.a(a1));
                }
                return;
            }
            throw new com.shazam.android.af.b.g(this, f1);
        }
        throw new com.shazam.android.af.b.g(this, d1);
    }

    protected final void a(com.shazam.android.af.b.d d1, f f1)
    {
        g.put(d1, f1);
    }

    protected final void a(com.shazam.android.af.b.d d1, f f1, c c1)
    {
        a(d1, f1);
        h.put(d1, c1);
    }

    protected final void a(f f1, c c1)
    {
        f.put(f1, c1);
    }

    protected abstract void b();

    static 
    {
        int j = 0;
        a = new f("Resting") {

            protected final void a()
            {
                a(a, ((c) (new e())));
                a(b, ((c) (new g())));
            }

            protected final void b()
            {
                a(com.shazam.android.af.b.d.d, a);
                a(com.shazam.android.af.b.d.a, b);
                a(com.shazam.android.af.b.d.e, null);
            }

        };
        b = new f("Resolving") {

            protected final void a()
            {
                a(d, ((c) (new com.shazam.android.af.b.a.f())));
                a(c, ((c) (new com.shazam.android.af.b.a.a(c))));
                a(a, ((c) (new e())));
            }

            protected final void b()
            {
                a(com.shazam.android.af.b.d.a, c);
                a(com.shazam.android.af.b.d.b, d);
                a(com.shazam.android.af.b.d.e, c);
                a(com.shazam.android.af.b.d.d, a);
            }

        };
        c = new f("ResolvingPaused") {

            protected final void a()
            {
                a(b, ((c) (new com.shazam.android.af.b.a.a(b))));
                a(e, ((c) (new com.shazam.android.af.b.a.a(e))));
                a(a, ((c) (new e())));
            }

            protected final void b()
            {
                a(com.shazam.android.af.b.d.a, b);
                a(com.shazam.android.af.b.d.b, e);
                a(com.shazam.android.af.b.d.d, a);
                a(com.shazam.android.af.b.d.e, null);
            }

        };
        d = new f("Playing") {

            protected final void a()
            {
                a(e, ((c) (new b())));
                a(a, ((c) (new e())));
            }

            protected final void b()
            {
                a(com.shazam.android.af.b.d.a, e);
                a(com.shazam.android.af.b.d.c, e, new d());
                a(com.shazam.android.af.b.d.e, e);
                a(com.shazam.android.af.b.d.d, a);
            }

        };
        e = new f("Paused") {

            protected final void a()
            {
                a(d, ((c) (new com.shazam.android.af.b.a.f())));
                a(a, ((c) (new e())));
            }

            protected final void b()
            {
                a(com.shazam.android.af.b.d.a, d);
                a(com.shazam.android.af.b.d.d, a);
                a(com.shazam.android.af.b.d.e, null);
                a(com.shazam.android.af.b.d.c, a);
            }

        };
        i = (new f[] {
            a, b, c, d, e
        });
        f af[] = values();
        for (int k = af.length; j < k; j++)
        {
            f f1 = af[j];
            f1.b();
            f1.a();
        }

    }
}
