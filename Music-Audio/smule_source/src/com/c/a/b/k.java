// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.c.a.a.a.b;
import com.c.a.b.a.f;
import com.c.a.b.a.g;
import com.c.a.b.a.l;
import com.c.a.b.b.d;
import com.c.a.b.b.e;
import com.c.a.b.d.c;
import com.c.a.b.e.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.c.a.b:
//            i, g, j, d, 
//            e, c

final class k
    implements Runnable
{

    final String a;
    final a b;
    final com.c.a.b.d c;
    final com.c.a.b.a.d d;
    private final i e;
    private final j f;
    private final Handler g;
    private final com.c.a.b.g h;
    private final com.c.a.b.d.b i;
    private final com.c.a.b.d.b j;
    private final com.c.a.b.d.b k;
    private final d l;
    private final boolean m;
    private final String n;
    private final f o;
    private g p;
    private boolean q;

    public k(i i1, j j1, Handler handler)
    {
        p = g.a;
        q = false;
        e = i1;
        f = j1;
        g = handler;
        h = i1.a;
        i = h.r;
        j = h.w;
        k = h.x;
        l = h.s;
        m = h.u;
        a = j1.a;
        n = j1.b;
        b = j1.c;
        o = j1.d;
        c = j1.e;
        d = j1.f;
    }

    private Bitmap a(String s)
    {
        l l1;
        if (!e())
        {
            if ((l1 = b.c()) != null)
            {
                s = new e(n, s, o, l1, k(), c);
                return l.a(s);
            }
        }
        return null;
    }

    static com.c.a.b.g a(k k1)
    {
        return k1.h;
    }

    private String a(File file)
    {
        b("Cache image on disc [%s]");
        String s;
        int i1;
        int j1;
        boolean flag;
        try
        {
            i1 = h.d;
            j1 = h.e;
        }
        catch (IOException ioexception)
        {
            com.c.a.c.c.a(ioexception);
            if (file.exists())
            {
                file.delete();
            }
            return a;
        }
        flag = false;
        if (i1 <= 0 && j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = a(file, i1, j1);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        b(file);
        h.q.a(a, file);
        s = c.c.b(file.getAbsolutePath());
        return s;
    }

    private void a(com.c.a.b.a.b b1, Throwable throwable)
    {
label0:
        {
            if (!Thread.interrupted())
            {
                if (!c.s())
                {
                    break label0;
                }
                d.a(a, b.d(), new com.c.a.b.a.a(b1, throwable));
            }
            return;
        }
        g.post(new Runnable(b1, throwable) {

            final com.c.a.b.a.b a;
            final Throwable b;
            final k c;

            public void run()
            {
                if (c.c.())
                {
                    c.b.a(c.c.(com.c.a.b.k.a(c).a));
                }
                c.d.a(c.a, c.b.d(), new com.c.a.b.a.a(a, b));
            }

            
            {
                c = k.this;
                a = b1;
                b = throwable;
                super();
            }
        });
    }

    private transient void a(String s, Object aobj[])
    {
        if (m)
        {
            com.c.a.c.c.a(s, aobj);
        }
    }

    private boolean a(File file, int i1, int j1)
    {
        Object obj;
        obj = new f(i1, j1);
        Object obj1 = (new com.c.a.b.e()).(c).(com.c.a.b.a.e.c).c();
        obj = new e(n, a, ((f) (obj)), l.a, k(), ((com.c.a.b.d) (obj1)));
        obj1 = l.a(((e) (obj)));
        if (obj1 == null)
        {
            return false;
        }
        obj = obj1;
        if (h.h != null)
        {
            b("Process image before cache on disc [%s]");
            obj1 = h.h.a(((Bitmap) (obj1)));
            obj = obj1;
            if (obj1 == null)
            {
                com.c.a.c.c.d("Bitmap processor for disc cache returned null [%s]", new Object[] {
                    n
                });
                return false;
            }
        }
        file = new BufferedOutputStream(new FileOutputStream(file), 32768);
        boolean flag = ((Bitmap) (obj)).compress(h.f, h.g, file);
        com.c.a.c.b.a(file);
        ((Bitmap) (obj)).recycle();
        return flag;
        Exception exception;
        exception;
        com.c.a.c.b.a(file);
        throw exception;
    }

    private void b(File file)
    {
        java.io.InputStream inputstream = k().a(a, c.n());
        file = new BufferedOutputStream(new FileOutputStream(file), 32768);
        com.c.a.c.b.a(inputstream, file);
        com.c.a.c.b.a(file);
        com.c.a.c.b.a(inputstream);
        return;
        Exception exception;
        exception;
        com.c.a.c.b.a(file);
        throw exception;
        file;
        com.c.a.c.b.a(inputstream);
        throw file;
    }

    private void b(String s)
    {
        if (m)
        {
            com.c.a.c.c.a(s, new Object[] {
                n
            });
        }
    }

    private boolean b()
    {
        AtomicBoolean atomicboolean = e.a();
        atomicboolean;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_35;
        }
        b("ImageLoader is paused. Waiting...  [%s]");
        atomicboolean.wait();
        b(".. Resume loading [%s]");
        return d();
        Object obj;
        obj;
        com.c.a.c.c.d("Task was interrupted [%s]", new Object[] {
            n
        });
        atomicboolean;
        JVM INSTR monitorexit ;
        return true;
        obj;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private boolean c()
    {
        if (c.f())
        {
            a("Delay %d ms before loading...  [%s]", new Object[] {
                Integer.valueOf(c.l()), n
            });
            try
            {
                Thread.sleep(c.l());
            }
            catch (InterruptedException interruptedexception)
            {
                com.c.a.c.c.d("Task was interrupted [%s]", new Object[] {
                    n
                });
                return true;
            }
            return d();
        } else
        {
            return false;
        }
    }

    private boolean d()
    {
        return e() || f();
    }

    private boolean e()
    {
        if (b.e())
        {
            q = true;
            b("ImageAware was collected by GC. Task is cancelled. [%s]");
            j();
            return true;
        } else
        {
            return false;
        }
    }

    private boolean f()
    {
        String s = e.a(b);
        boolean flag;
        if (!n.equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b("ImageAware is reused for another image. Task is cancelled. [%s]");
            j();
        }
        return flag;
    }

    private boolean g()
    {
        boolean flag = Thread.interrupted();
        if (flag)
        {
            b("Task was interrupted [%s]");
        }
        return flag;
    }

    private Bitmap h()
    {
        File file = i();
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        Object obj1;
        b("Load image from disc cache [%s]");
        p = g.b;
        obj1 = a(c.c.b(file.getAbsolutePath()));
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        obj = obj1;
        obj2 = obj1;
        obj3 = obj1;
        obj4 = obj1;
        if (q)
        {
            return null;
        }
_L23:
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        if (((Bitmap) (obj)).getWidth() <= 0) goto _L4; else goto _L5
_L5:
        Object obj5;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        obj5 = obj;
        if (((Bitmap) (obj)).getHeight() > 0) goto _L6; else goto _L4
_L4:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        b("Load image from network [%s]");
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        p = g.a;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        if (!c.i()) goto _L8; else goto _L7
_L7:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        String s = a(file);
_L11:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        obj5 = obj;
        if (d()) goto _L6; else goto _L9
_L9:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        obj = a(s);
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        if (q)
        {
            return null;
        }
          goto _L10
_L8:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        s = a;
          goto _L11
_L10:
        if (obj == null) goto _L13; else goto _L12
_L12:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        if (((Bitmap) (obj)).getWidth() <= 0) goto _L13; else goto _L14
_L14:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        obj5 = obj;
        if (((Bitmap) (obj)).getHeight() > 0) goto _L6; else goto _L13
_L13:
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj1 = obj;
        a(com.c.a.b.a.b.b, ((Throwable) (null)));
        return ((Bitmap) (obj));
        obj;
_L21:
        a(com.c.a.b.a.b.c, ((Throwable) (null)));
        return ((Bitmap) (obj2));
        obj;
        obj1 = null;
_L20:
        com.c.a.c.c.a(((Throwable) (obj)));
        a(com.c.a.b.a.b.a, ((Throwable) (obj)));
        obj5 = obj1;
        if (file.exists())
        {
            file.delete();
            return ((Bitmap) (obj1));
        }
        break; /* Loop/switch isn't completed */
        obj;
        obj4 = null;
_L18:
        com.c.a.c.c.a(((Throwable) (obj)));
        a(com.c.a.b.a.b.d, ((Throwable) (obj)));
        return ((Bitmap) (obj4));
        obj;
        obj3 = null;
_L16:
        com.c.a.c.c.a(((Throwable) (obj)));
        a(com.c.a.b.a.b.e, ((Throwable) (obj)));
        return ((Bitmap) (obj3));
        obj;
        if (true) goto _L16; else goto _L15
_L15:
        obj;
        if (true) goto _L18; else goto _L17
_L17:
        obj;
        if (true) goto _L20; else goto _L19
_L19:
        obj;
        obj2 = null;
        if (true) goto _L21; else goto _L6
_L6:
        return ((Bitmap) (obj5));
_L2:
        obj = null;
        if (true) goto _L23; else goto _L22
_L22:
    }

    private File i()
    {
        File file;
label0:
        {
            File file1 = h.q.a(a);
            File file2 = file1.getParentFile();
            if (file2 != null)
            {
                file = file1;
                if (file2.exists())
                {
                    break label0;
                }
                file = file1;
                if (file2.mkdirs())
                {
                    break label0;
                }
            }
            file1 = h.v.a(a);
            file2 = file1.getParentFile();
            file = file1;
            if (file2 != null)
            {
                file = file1;
                if (!file2.exists())
                {
                    file2.mkdirs();
                    file = file1;
                }
            }
        }
        return file;
    }

    private void j()
    {
label0:
        {
            if (!Thread.interrupted())
            {
                if (!c.s())
                {
                    break label0;
                }
                d.b(a, b.d());
            }
            return;
        }
        g.post(new Runnable() {

            final k a;

            public void run()
            {
                a.d.b(a.a, a.b.d());
            }

            
            {
                a = k.this;
                super();
            }
        });
    }

    private com.c.a.b.d.b k()
    {
        if (e.b())
        {
            return j;
        }
        if (e.c())
        {
            return k;
        } else
        {
            return i;
        }
    }

    String a()
    {
        return a;
    }

    public void run()
    {
_L2:
        return;
        if (b() || c()) goto _L2; else goto _L1
_L1:
        ReentrantLock reentrantlock;
        reentrantlock = f.g;
        b("Start display image task [%s]");
        if (reentrantlock.isLocked())
        {
            b("Image already is loading. Waiting... [%s]");
        }
        reentrantlock.lock();
        boolean flag = d();
        if (flag)
        {
            reentrantlock.unlock();
            return;
        }
        Bitmap bitmap = (Bitmap)h.p.a(n);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_363;
        }
        bitmap = h();
        flag = q;
        if (flag)
        {
            reentrantlock.unlock();
            return;
        }
        if (bitmap == null)
        {
            reentrantlock.unlock();
            return;
        }
        if (d())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        flag = g();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        reentrantlock.unlock();
        return;
        Object obj = bitmap;
        if (!c.d())
        {
            break MISSING_BLOCK_LABEL_192;
        }
        b("PreProcess image before caching in memory [%s]");
        bitmap = c.o().a(bitmap);
        obj = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        com.c.a.c.c.d("Pre-processor returned null [%s]", new Object[0]);
        obj = bitmap;
        bitmap = ((Bitmap) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        bitmap = ((Bitmap) (obj));
        if (!c.h())
        {
            break MISSING_BLOCK_LABEL_237;
        }
        b("Cache image in memory [%s]");
        h.p.a(n, obj);
        bitmap = ((Bitmap) (obj));
_L4:
        obj = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        obj = bitmap;
        if (!c.e())
        {
            break MISSING_BLOCK_LABEL_301;
        }
        b("PostProcess image before displaying [%s]");
        bitmap = c.p().a(bitmap);
        obj = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        com.c.a.c.c.d("Pre-processor returned null [%s]", new Object[] {
            n
        });
        obj = bitmap;
        reentrantlock.unlock();
        if (d() || g()) goto _L2; else goto _L3
_L3:
        obj = new com.c.a.b.c(((Bitmap) (obj)), f, e, p);
        ((com.c.a.b.c) (obj)).a(m);
        if (c.s())
        {
            ((com.c.a.b.c) (obj)).run();
            return;
        } else
        {
            g.post(((Runnable) (obj)));
            return;
        }
        p = g.c;
        b("...Get cached bitmap from memory after waiting. [%s]");
          goto _L4
        obj;
        reentrantlock.unlock();
        throw obj;
    }
}
