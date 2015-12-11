// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.c.a.b.a.d;
import com.c.a.b.a.g;
import com.c.a.b.a.h;
import com.c.a.b.a.j;
import com.c.a.b.a.k;
import com.c.a.b.a.l;
import com.c.a.b.e.a;
import com.c.a.b.e.b;
import com.c.a.c.c;

// Referenced classes of package com.c.a.b:
//            g, e, i, d, 
//            j, l, k

public class f
{

    public static final String a = com/c/a/b/f.getSimpleName();
    private static volatile f e;
    private com.c.a.b.g b;
    private i c;
    private final d d = new j();

    protected f()
    {
    }

    public static f a()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        com/c/a/b/f;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new f();
        }
        com/c/a/b/f;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        com/c/a/b/f;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void b()
    {
        if (b == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public Bitmap a(String s, com.c.a.b.a.f f1)
    {
        return a(s, f1, ((com.c.a.b.d) (null)));
    }

    public Bitmap a(String s, com.c.a.b.a.f f1, com.c.a.b.d d1)
    {
        Object obj = d1;
        if (d1 == null)
        {
            obj = b.t;
        }
        d1 = (new e()).(((com.c.a.b.d) (obj))).(true).c();
        obj = new k();
        a(s, f1, d1, ((d) (obj)));
        return ((k) (obj)).a();
    }

    public void a(com.c.a.b.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        if (g1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (g1.u)
        {
            com.c.a.c.c.a("Initialize ImageLoader with configuration", new Object[0]);
        }
        c = new i(g1);
        b = g1;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        com.c.a.c.c.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public void a(String s, ImageView imageview, com.c.a.b.d d1, d d2)
    {
        a(s, ((a) (new com.c.a.b.e.c(imageview))), d1, d2);
    }

    public void a(String s, d d1)
    {
        a(s, ((com.c.a.b.a.f) (null)), null, d1);
    }

    public void a(String s, com.c.a.b.a.f f1, d d1)
    {
        a(s, f1, null, d1);
    }

    public void a(String s, com.c.a.b.a.f f1, com.c.a.b.d d1, d d2)
    {
        b();
        com.c.a.b.a.f f2 = f1;
        if (f1 == null)
        {
            f2 = b.a();
        }
        f1 = d1;
        if (d1 == null)
        {
            f1 = b.t;
        }
        a(s, ((a) (new b(f2, l.b))), ((com.c.a.b.d) (f1)), d2);
    }

    public void a(String s, a a1, com.c.a.b.d d1, d d2)
    {
        b();
        if (a1 == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        if (d2 == null)
        {
            d2 = d;
        }
        if (d1 == null)
        {
            d1 = b.t;
        }
        if (TextUtils.isEmpty(s))
        {
            c.b(a1);
            d2.a(s, a1.d());
            if (d1.b())
            {
                a1.a(d1.b(b.a));
            } else
            {
                a1.a(null);
            }
            d2.a(s, a1.d(), null);
            return;
        }
        com.c.a.b.a.f f1 = com.c.a.c.a.a(a1, b.a());
        String s1 = h.a(s, f1);
        c.a(a1, s1);
        d2.a(s, a1.d());
        Bitmap bitmap = (Bitmap)b.p.a(s1);
        if (bitmap != null && !bitmap.isRecycled())
        {
            if (b.u)
            {
                com.c.a.c.c.a("Load image from memory cache [%s]", new Object[] {
                    s1
                });
            }
            if (d1.e())
            {
                s = new com.c.a.b.j(s, a1, f1, s1, d1, d2, c.a(s));
                s = new com.c.a.b.l(c, bitmap, s, d1.r());
                if (d1.s())
                {
                    s.run();
                    return;
                } else
                {
                    c.a(s);
                    return;
                }
            } else
            {
                d1 = d1.q().a(bitmap, a1, g.c);
                d2.a(s, a1.d(), d1);
                return;
            }
        }
        if (d1.a())
        {
            a1.a(d1.a(b.a));
        } else
        if (d1.g())
        {
            a1.a(null);
        }
        s = new com.c.a.b.j(s, a1, f1, s1, d1, d2, c.a(s));
        s = new com.c.a.b.k(c, s, d1.r());
        if (d1.s())
        {
            s.run();
            return;
        } else
        {
            c.a(s);
            return;
        }
    }

}
