// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.a.b.a.a;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.b.e;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            a, d, h

public class i
{

    public static final QueueProcessingType a;
    private Context b;
    private int c;
    private int d;
    private int e;
    private int f;
    private com.nostra13.universalimageloader.core.e.a g;
    private Executor h;
    private Executor i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private QueueProcessingType o;
    private int p;
    private long q;
    private int r;
    private com.nostra13.universalimageloader.a.b.a s;
    private com.nostra13.universalimageloader.a.a.a t;
    private com.nostra13.universalimageloader.a.a.b.a u;
    private ImageDownloader v;
    private com.nostra13.universalimageloader.core.a.d w;
    private com.nostra13.universalimageloader.core.d x;
    private boolean y;

    public i(Context context)
    {
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = null;
        h = null;
        i = null;
        j = false;
        k = false;
        l = 3;
        m = 3;
        n = false;
        o = a;
        p = 0;
        q = 0L;
        r = 0;
        s = null;
        t = null;
        u = null;
        v = null;
        x = null;
        y = false;
        b = context.getApplicationContext();
    }

    static Context a(i i1)
    {
        return i1.b;
    }

    static int b(i i1)
    {
        return i1.c;
    }

    static int c(i i1)
    {
        return i1.d;
    }

    static int d(i i1)
    {
        return i1.e;
    }

    private void d()
    {
        if (h == null)
        {
            h = com.nostra13.universalimageloader.core.a.a(l, m, o);
        } else
        {
            j = true;
        }
        if (i == null)
        {
            i = com.nostra13.universalimageloader.core.a.a(l, m, o);
        } else
        {
            k = true;
        }
        if (t == null)
        {
            if (u == null)
            {
                u = com.nostra13.universalimageloader.core.a.b();
            }
            t = com.nostra13.universalimageloader.core.a.a(b, u, q, r);
        }
        if (s == null)
        {
            s = com.nostra13.universalimageloader.core.a.a(b, p);
        }
        if (n)
        {
            s = new a(s, com.nostra13.universalimageloader.b.e.a());
        }
        if (v == null)
        {
            v = com.nostra13.universalimageloader.core.a.a(b);
        }
        if (w == null)
        {
            w = com.nostra13.universalimageloader.core.a.a(y);
        }
        if (x == null)
        {
            x = com.nostra13.universalimageloader.core.d.t();
        }
    }

    static int e(i i1)
    {
        return i1.f;
    }

    static com.nostra13.universalimageloader.core.e.a f(i i1)
    {
        return i1.g;
    }

    static Executor g(i i1)
    {
        return i1.h;
    }

    static Executor h(i i1)
    {
        return i1.i;
    }

    static int i(i i1)
    {
        return i1.l;
    }

    static int j(i i1)
    {
        return i1.m;
    }

    static QueueProcessingType k(i i1)
    {
        return i1.o;
    }

    static com.nostra13.universalimageloader.a.a.a l(i i1)
    {
        return i1.t;
    }

    static com.nostra13.universalimageloader.a.b.a m(i i1)
    {
        return i1.s;
    }

    static com.nostra13.universalimageloader.core.d n(i i1)
    {
        return i1.x;
    }

    static ImageDownloader o(i i1)
    {
        return i1.v;
    }

    static com.nostra13.universalimageloader.core.a.d p(i i1)
    {
        return i1.w;
    }

    static boolean q(i i1)
    {
        return i1.j;
    }

    static boolean r(i i1)
    {
        return i1.k;
    }

    static boolean s(i i1)
    {
        return i1.y;
    }

    public i a()
    {
        n = true;
        return this;
    }

    public i a(int i1)
    {
        if (h != null || i != null)
        {
            com.nostra13.universalimageloader.b.d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        l = i1;
        return this;
    }

    public i a(int i1, int j1, com.nostra13.universalimageloader.core.e.a a1)
    {
        e = i1;
        f = j1;
        g = a1;
        return this;
    }

    public i a(com.nostra13.universalimageloader.a.a.a a1)
    {
        if (q > 0L || r > 0)
        {
            com.nostra13.universalimageloader.b.d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        if (u != null)
        {
            com.nostra13.universalimageloader.b.d.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        t = a1;
        return this;
    }

    public i a(com.nostra13.universalimageloader.a.a.b.a a1)
    {
        if (t != null)
        {
            com.nostra13.universalimageloader.b.d.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        u = a1;
        return this;
    }

    public i a(com.nostra13.universalimageloader.core.a.d d1)
    {
        w = d1;
        return this;
    }

    public i a(QueueProcessingType queueprocessingtype)
    {
        if (h != null || i != null)
        {
            com.nostra13.universalimageloader.b.d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        o = queueprocessingtype;
        return this;
    }

    public i a(com.nostra13.universalimageloader.core.d d1)
    {
        x = d1;
        return this;
    }

    public i a(ImageDownloader imagedownloader)
    {
        v = imagedownloader;
        return this;
    }

    public i b()
    {
        y = true;
        return this;
    }

    public i b(int i1)
    {
        if (h != null || i != null)
        {
            com.nostra13.universalimageloader.b.d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        if (i1 < 1)
        {
            m = 1;
            return this;
        }
        if (i1 > 10)
        {
            m = 10;
            return this;
        } else
        {
            m = i1;
            return this;
        }
    }

    public h c()
    {
        d();
        return new h(this, null);
    }

    public i c(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }
        if (s != null)
        {
            com.nostra13.universalimageloader.b.d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        p = i1;
        return this;
    }

    public i d(int i1)
    {
        if (i1 <= 0 || i1 >= 100)
        {
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }
        if (s != null)
        {
            com.nostra13.universalimageloader.b.d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        p = (int)((float)Runtime.getRuntime().maxMemory() * ((float)i1 / 100F));
        return this;
    }

    public i e(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }
        if (t != null)
        {
            com.nostra13.universalimageloader.b.d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        q = i1;
        return this;
    }

    public i f(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }
        if (t != null)
        {
            com.nostra13.universalimageloader.b.d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        r = i1;
        return this;
    }

    static 
    {
        a = QueueProcessingType.a;
    }
}
