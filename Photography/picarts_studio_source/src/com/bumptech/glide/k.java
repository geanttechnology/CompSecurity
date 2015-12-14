// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.ab.d;
import myobfuscated.ad.c;
import myobfuscated.ad.g;
import myobfuscated.ad.h;
import myobfuscated.ad.i;
import myobfuscated.ad.m;
import myobfuscated.ad.n;
import myobfuscated.ad.q;
import myobfuscated.aj.j;

// Referenced classes of package com.bumptech.glide:
//            Priority, b, d, j, 
//            l

public final class k
    implements h
{

    private static final e f;
    private static final e g;
    public final com.bumptech.glide.d a;
    final n b;
    public final m c;
    final q d;
    a e;
    private final g h;
    private final Runnable i;
    private final Handler j;
    private final h k;
    private a l;

    public k(Context context, g g1, m m1)
    {
        this(context, g1, m1, new n(), com.bumptech.glide.b.a(context).d);
    }

    private k(Context context, g g1, m m1, n n1, myobfuscated.ad.d d1)
    {
        d = new q();
        i = new Runnable() {

            private k a;

            public final void run()
            {
                com.bumptech.glide.k.a(a).a(a);
            }

            
            {
                a = k.this;
                super();
            }
        };
        j = new Handler(Looper.getMainLooper());
        a = com.bumptech.glide.b.a(context).b;
        h = g1;
        c = m1;
        b = n1;
        m1 = new c(n1);
        boolean flag;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            m1 = new myobfuscated.ad.e(context, m1);
        } else
        {
            m1 = new i();
        }
        k = m1;
        if (myobfuscated.aj.j.c())
        {
            j.post(i);
        } else
        {
            g1.a(this);
        }
        g1.a(k);
        l = a.b;
        e = l;
        g1 = com.bumptech.glide.b.a(context);
        context = ((com.bumptech.glide.b) (g1)).e;
        context;
        JVM INSTR monitorenter ;
        if (((com.bumptech.glide.b) (g1)).e.contains(this))
        {
            throw new IllegalStateException("Cannot register already registered manager");
        }
        break MISSING_BLOCK_LABEL_224;
        g1;
        context;
        JVM INSTR monitorexit ;
        throw g1;
        ((com.bumptech.glide.b) (g1)).e.add(this);
        context;
        JVM INSTR monitorexit ;
    }

    private com.bumptech.glide.j a(Class class1)
    {
        return new com.bumptech.glide.j(a, this, class1);
    }

    static g a(k k1)
    {
        return k1.h;
    }

    public final com.bumptech.glide.j a(Object obj)
    {
        return i().a(obj);
    }

    public final void a()
    {
        myobfuscated.aj.j.a();
        n n1 = b;
        n1.c = true;
        Iterator iterator = myobfuscated.aj.j.a(n1.a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (b1.e())
            {
                b1.c();
                n1.b.add(b1);
            }
        } while (true);
    }

    public final void a(View view)
    {
        a(((myobfuscated.ag.h) (new com.bumptech.glide.l(view))));
    }

    public final void a(myobfuscated.ag.h h1)
    {
        if (h1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!myobfuscated.aj.j.b())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (b(h1)) goto _L1; else goto _L3
_L3:
        Object obj = com.bumptech.glide.b.a(a);
        synchronized (((com.bumptech.glide.b) (obj)).e)
        {
            obj = ((com.bumptech.glide.b) (obj)).e.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_77;
                }
            } while (!((k)((Iterator) (obj)).next()).b(h1));
        }
        return;
        h1;
        list;
        JVM INSTR monitorexit ;
        throw h1;
        list;
        JVM INSTR monitorexit ;
        throw new IllegalStateException("Failed to remove target from managers");
        j.post(new Runnable(h1) {

            private myobfuscated.ag.h a;
            private k b;

            public final void run()
            {
                b.a(a);
            }

            
            {
                b = k.this;
                a = h1;
                super();
            }
        });
        return;
    }

    public final void b()
    {
        myobfuscated.aj.j.a();
        a();
        for (Iterator iterator = c.a().iterator(); iterator.hasNext(); ((k)iterator.next()).a()) { }
    }

    final boolean b(myobfuscated.ag.h h1)
    {
        b b1 = h1.b();
        if (b1 == null)
        {
            return true;
        }
        if (b.a(b1))
        {
            d.a.remove(h1);
            h1.a(null);
            return true;
        } else
        {
            return false;
        }
    }

    public final void c()
    {
        myobfuscated.aj.j.a();
        n n1 = b;
        n1.c = false;
        Iterator iterator = myobfuscated.aj.j.a(n1.a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (!b1.f() && !b1.h() && !b1.e())
            {
                b1.a();
            }
        } while (true);
        n1.b.clear();
    }

    public final void d()
    {
        c();
        d.d();
    }

    public final void e()
    {
        a();
        d.e();
    }

    public final void f()
    {
        Object obj;
        d.f();
        for (Iterator iterator = (new ArrayList(d.a)).iterator(); iterator.hasNext(); a((myobfuscated.ag.h)iterator.next())) { }
        d.a.clear();
        b.a();
        h.b(this);
        h.b(k);
        j.removeCallbacks(i);
        obj = com.bumptech.glide.b.a(a);
        List list = ((com.bumptech.glide.b) (obj)).e;
        list;
        JVM INSTR monitorenter ;
        if (!((com.bumptech.glide.b) (obj)).e.contains(this))
        {
            throw new IllegalStateException("Cannot register not yet registered manager");
        }
        break MISSING_BLOCK_LABEL_149;
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        ((com.bumptech.glide.b) (obj)).e.remove(this);
        list;
        JVM INSTR monitorexit ;
    }

    public final com.bumptech.glide.j g()
    {
        return a(android/graphics/Bitmap).a(new com.bumptech.glide.load.resource.bitmap.g()).a(f);
    }

    public final com.bumptech.glide.j h()
    {
        return a(myobfuscated/ab/d).a(new myobfuscated.z.b()).a(g);
    }

    public final com.bumptech.glide.j i()
    {
        return a(android/graphics/drawable/Drawable).a(new myobfuscated.z.b());
    }

    public final com.bumptech.glide.j j()
    {
        return a(java/io/File).a(com.bumptech.glide.request.e.e());
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("{tracker=").append(b).append(", treeNode=").append(c).append("}").toString();
    }

    static 
    {
        e e1 = com.bumptech.glide.request.e.a(android/graphics/Bitmap);
        e1.t = true;
        f = (e)e1;
        e1 = com.bumptech.glide.request.e.a(myobfuscated/ab/d);
        e1.t = true;
        g = (e)e1;
        ((e)com.bumptech.glide.request.e.b(l.c).a(Priority.LOW)).a(true);
    }
}
