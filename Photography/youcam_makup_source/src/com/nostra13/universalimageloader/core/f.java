// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.b.e;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c.a;
import com.nostra13.universalimageloader.core.c.b;
import com.nostra13.universalimageloader.core.d.c;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            d, h, e, g, 
//            l, m, n, LoadAndDisplayImageTask

public class f
{

    public static final String a = com/nostra13/universalimageloader/core/f.getSimpleName();
    private static volatile f e;
    private h b;
    private l c;
    private final com.nostra13.universalimageloader.core.d.a d = new c();

    protected f()
    {
    }

    private static Handler a(com.nostra13.universalimageloader.core.d d1)
    {
        Handler handler = d1.r();
        if (d1.s())
        {
            d1 = null;
        } else
        {
            d1 = handler;
            if (handler == null)
            {
                d1 = handler;
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                    return new Handler();
                }
            }
        }
        return d1;
    }

    private void a()
    {
        if (b == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public static f b()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new f();
        }
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap a(String s, com.nostra13.universalimageloader.core.assist.c c1, com.nostra13.universalimageloader.core.d d1)
    {
        Object obj = d1;
        if (d1 == null)
        {
            obj = b.r;
        }
        d1 = (new com.nostra13.universalimageloader.core.e()).a(((com.nostra13.universalimageloader.core.d) (obj))).e(true).a();
        obj = new g();
        a(s, c1, d1, ((com.nostra13.universalimageloader.core.d.a) (obj)));
        return ((g) (obj)).a();
    }

    public Bitmap a(String s, com.nostra13.universalimageloader.core.d d1)
    {
        return a(s, ((com.nostra13.universalimageloader.core.assist.c) (null)), d1);
    }

    public void a(ImageView imageview)
    {
        c.b(new b(imageview));
    }

    public void a(h h1)
    {
        this;
        JVM INSTR monitorenter ;
        if (h1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        h1;
        this;
        JVM INSTR monitorexit ;
        throw h1;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        com.nostra13.universalimageloader.b.d.a("Initialize ImageLoader with configuration", new Object[0]);
        c = new l(h1);
        b = h1;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        com.nostra13.universalimageloader.b.d.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public void a(String s, ImageView imageview, com.nostra13.universalimageloader.core.d d1)
    {
        a(s, ((a) (new b(imageview))), d1, null, null);
    }

    public void a(String s, ImageView imageview, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a1)
    {
        a(s, imageview, d1, a1, null);
    }

    public void a(String s, ImageView imageview, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a1, com.nostra13.universalimageloader.core.d.b b1)
    {
        a(s, ((a) (new b(imageview))), d1, a1, b1);
    }

    public void a(String s, com.nostra13.universalimageloader.core.assist.c c1, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a1)
    {
        a(s, c1, d1, a1, null);
    }

    public void a(String s, com.nostra13.universalimageloader.core.assist.c c1, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a1, com.nostra13.universalimageloader.core.d.b b1)
    {
        a();
        com.nostra13.universalimageloader.core.assist.c c2 = c1;
        if (c1 == null)
        {
            c2 = b.a();
        }
        if (d1 == null)
        {
            c1 = b.r;
        } else
        {
            c1 = d1;
        }
        a(s, ((a) (new com.nostra13.universalimageloader.core.c.c(s, c2, ViewScaleType.b))), ((com.nostra13.universalimageloader.core.d) (c1)), a1, b1);
    }

    public void a(String s, a a1, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a2, com.nostra13.universalimageloader.core.d.b b1)
    {
        a();
        if (a1 == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        if (a2 == null)
        {
            a2 = d;
        }
        if (d1 == null)
        {
            d1 = b.r;
        }
        if (TextUtils.isEmpty(s))
        {
            c.b(a1);
            a2.a(s, a1.d());
            if (d1.b())
            {
                a1.a(d1.b(b.a));
            } else
            {
                a1.a(null);
            }
            a2.a(s, a1.d(), null);
            return;
        }
        com.nostra13.universalimageloader.core.assist.c c1 = com.nostra13.universalimageloader.b.a.a(a1, b.a());
        String s1 = com.nostra13.universalimageloader.b.e.a(s, c1);
        c.a(a1, s1);
        a2.a(s, a1.d());
        Bitmap bitmap = b.n.a(s1);
        if (bitmap != null && !bitmap.isRecycled())
        {
            com.nostra13.universalimageloader.b.d.a("Load image from memory cache [%s]", new Object[] {
                s1
            });
            if (d1.e())
            {
                s = new m(s, a1, c1, s1, d1, a2, b1, c.a(s));
                s = new n(c, bitmap, s, a(d1));
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
                d1.q().a(bitmap, a1, LoadedFrom.c);
                a2.a(s, a1.d(), bitmap);
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
        s = new m(s, a1, c1, s1, d1, a2, b1, c.a(s));
        s = new LoadAndDisplayImageTask(c, s, a(d1));
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

    public void a(String s, com.nostra13.universalimageloader.core.d d1, com.nostra13.universalimageloader.core.d.a a1)
    {
        a(s, ((com.nostra13.universalimageloader.core.assist.c) (null)), d1, a1, null);
    }

    public com.nostra13.universalimageloader.a.b.a c()
    {
        a();
        return b.n;
    }

    public com.nostra13.universalimageloader.a.a.a d()
    {
        a();
        return b.o;
    }

    public void e()
    {
        c.a();
    }

}
