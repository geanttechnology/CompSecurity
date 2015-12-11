// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package android.support.v7:
//            aiv, aim, ail, ain, 
//            aij, ajk, aje, ajd, 
//            ajt, aht, aiu, ait, 
//            aix, ajq, ajj, aid, 
//            aii, ajn, ajo, air

final class aio
    implements ajs.a, Runnable
{
    class a extends Exception
    {

        final aio a;

        a()
        {
            a = aio.this;
            super();
        }
    }


    final String a;
    final ajk b;
    final aij c;
    final ajn d;
    final ajo e;
    private final aim f;
    private final ain g;
    private final Handler h;
    private final ail i;
    private final ajj j;
    private final ajj k;
    private final ajj l;
    private final ajd m;
    private final String n;
    private final aiu o;
    private final boolean p;
    private aiv q;

    public aio(aim aim1, ain ain1, Handler handler)
    {
        q = aiv.a;
        f = aim1;
        g = ain1;
        h = handler;
        i = aim1.a;
        j = i.p;
        k = i.s;
        l = i.t;
        m = i.q;
        a = ain1.a;
        n = ain1.b;
        b = ain1.c;
        o = ain1.d;
        c = ain1.e;
        d = ain1.f;
        e = ain1.g;
        p = c.s();
    }

    private Bitmap a(String s)
        throws IOException
    {
        aix aix1 = b.c();
        s = new aje(n, s, a, o, aix1, h(), c);
        return m.a(s);
    }

    static ail a(aio aio1)
    {
        return aio1.i;
    }

    private void a(air.a a1, Throwable throwable)
    {
        if (p || p() || j())
        {
            return;
        } else
        {
            a(new Runnable(a1, throwable) {

                final air.a a;
                final Throwable b;
                final aio c;

                public void run()
                {
                    if (c.c.c())
                    {
                        c.b.a(c.c.c(aio.a(c).a));
                    }
                    c.d.a(c.a, c.b.d(), new air(a, b));
                }

            
            {
                c = aio.this;
                a = a1;
                b = throwable;
                super();
            }
            }, false, h, f);
            return;
        }
    }

    static void a(Runnable runnable, boolean flag, Handler handler, aim aim1)
    {
        if (flag)
        {
            runnable.run();
            return;
        }
        if (handler == null)
        {
            aim1.a(runnable);
            return;
        } else
        {
            handler.post(runnable);
            return;
        }
    }

    private boolean b()
    {
        AtomicBoolean atomicboolean;
        atomicboolean = f.a();
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Object obj = f.b();
        obj;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        ajt.a("ImageLoader is paused. Waiting...  [%s]", new Object[] {
            n
        });
        f.b().wait();
        ajt.a(".. Resume loading [%s]", new Object[] {
            n
        });
        return j();
        Object obj1;
        obj1;
        ajt.d("Task was interrupted [%s]", new Object[] {
            n
        });
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private boolean b(int i1, int j1)
        throws IOException
    {
        Object obj = i.o.a(a);
        if (obj != null && ((File) (obj)).exists())
        {
            Object obj1 = new aiu(i1, j1);
            aij aij1 = (new aij.a()).a(c).a(ait.d).a();
            obj = new aje(n, ajj.a.c.b(((File) (obj)).getAbsolutePath()), a, ((aiu) (obj1)), aix.a, h(), aij1);
            obj1 = m.a(((aje) (obj)));
            obj = obj1;
            if (obj1 != null)
            {
                obj = obj1;
                if (i.f != null)
                {
                    ajt.a("Process image before cache on disk [%s]", new Object[] {
                        n
                    });
                    obj1 = i.f.a(((Bitmap) (obj1)));
                    obj = obj1;
                    if (obj1 == null)
                    {
                        ajt.d("Bitmap processor for disk cache returned null [%s]", new Object[] {
                            n
                        });
                        obj = obj1;
                    }
                }
            }
            if (obj != null)
            {
                boolean flag = i.o.a(a, ((Bitmap) (obj)));
                ((Bitmap) (obj)).recycle();
                return flag;
            }
        }
        return false;
    }

    private boolean c()
    {
        if (c.f())
        {
            ajt.a("Delay %d ms before loading...  [%s]", new Object[] {
                Integer.valueOf(c.l()), n
            });
            try
            {
                Thread.sleep(c.l());
            }
            catch (InterruptedException interruptedexception)
            {
                ajt.d("Task was interrupted [%s]", new Object[] {
                    n
                });
                return true;
            }
            return j();
        } else
        {
            return false;
        }
    }

    private boolean c(int i1, int j1)
    {
        if (p() || j())
        {
            return false;
        }
        if (e != null)
        {
            a(new Runnable(i1, j1) {

                final int a;
                final int b;
                final aio c;

                public void run()
                {
                    c.e.a(c.a, c.b.d(), a, b);
                }

            
            {
                c = aio.this;
                a = i1;
                b = j1;
                super();
            }
            }, false, h, f);
        }
        return true;
    }

    private Bitmap d()
        throws a
    {
        Object obj = i.o.a(a);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((File) (obj)).exists()) goto _L2; else goto _L3
_L3:
        ajt.a("Load image from disk cache [%s]", new Object[] {
            n
        });
        q = aiv.b;
        i();
        obj = a(ajj.a.c.b(((File) (obj)).getAbsolutePath()));
_L12:
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (((Bitmap) (obj)).getWidth() <= 0)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        Object obj5;
        obj5 = obj;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (((Bitmap) (obj)).getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        ajt.a("Load image from network [%s]", new Object[] {
            n
        });
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        q = aiv.a;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        String s = a;
        obj5 = s;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (!c.i())
        {
            break MISSING_BLOCK_LABEL_277;
        }
        obj5 = s;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (!e())
        {
            break MISSING_BLOCK_LABEL_277;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        File file = i.o.a(a);
        obj5 = s;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj5 = ajj.a.c.b(file.getAbsolutePath());
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        i();
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        obj = a(((String) (obj5)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (((Bitmap) (obj)).getWidth() <= 0)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        obj5 = obj;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        if (((Bitmap) (obj)).getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        a(air.a.b, ((Throwable) (null)));
        obj5 = obj;
        return ((Bitmap) (obj5));
        obj;
        obj4 = null;
_L10:
        a(air.a.c, ((Throwable) (null)));
        return ((Bitmap) (obj4));
        obj;
        throw obj;
        obj;
        obj3 = null;
_L9:
        ajt.a(((Throwable) (obj)));
        a(air.a.a, ((Throwable) (obj)));
        return ((Bitmap) (obj3));
        obj;
        obj2 = null;
_L7:
        ajt.a(((Throwable) (obj)));
        a(air.a.d, ((Throwable) (obj)));
        return ((Bitmap) (obj2));
        obj;
        obj1 = null;
_L5:
        ajt.a(((Throwable) (obj)));
        a(air.a.e, ((Throwable) (obj)));
        return ((Bitmap) (obj1));
        obj;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        if (true) goto _L9; else goto _L8
_L8:
        obj;
        if (true) goto _L10; else goto _L2
_L2:
        obj = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private boolean e()
        throws a
    {
        ajt.a("Cache image on disk [%s]", new Object[] {
            n
        });
        int i1;
        int j1;
        boolean flag;
        try
        {
            flag = f();
        }
        catch (IOException ioexception)
        {
            ajt.a(ioexception);
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        i1 = i.d;
        j1 = i.e;
        if (i1 <= 0 && j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ajt.a("Resize image in disk cache [%s]", new Object[] {
            n
        });
        b(i1, j1);
        return flag;
    }

    private boolean f()
        throws IOException
    {
        java.io.InputStream inputstream = h().a(a, c.n());
        return i.o.a(a, inputstream, this);
    }

    private void g()
    {
        if (p || p())
        {
            return;
        } else
        {
            a(new Runnable() {

                final aio a;

                public void run()
                {
                    a.d.b(a.a, a.b.d());
                }

            
            {
                a = aio.this;
                super();
            }
            }, false, h, f);
            return;
        }
    }

    private ajj h()
    {
        if (f.c())
        {
            return k;
        }
        if (f.d())
        {
            return l;
        } else
        {
            return j;
        }
    }

    private void i()
        throws a
    {
        k();
        m();
    }

    private boolean j()
    {
        return l() || n();
    }

    private void k()
        throws a
    {
        if (l())
        {
            throw new a();
        } else
        {
            return;
        }
    }

    private boolean l()
    {
        if (b.e())
        {
            ajt.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] {
                n
            });
            return true;
        } else
        {
            return false;
        }
    }

    private void m()
        throws a
    {
        if (n())
        {
            throw new a();
        } else
        {
            return;
        }
    }

    private boolean n()
    {
        String s = f.a(b);
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
            ajt.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] {
                n
            });
            return true;
        } else
        {
            return false;
        }
    }

    private void o()
        throws a
    {
        if (p())
        {
            throw new a();
        } else
        {
            return;
        }
    }

    private boolean p()
    {
        if (Thread.interrupted())
        {
            ajt.a("Task was interrupted [%s]", new Object[] {
                n
            });
            return true;
        } else
        {
            return false;
        }
    }

    String a()
    {
        return a;
    }

    public boolean a(int i1, int j1)
    {
        return p || c(i1, j1);
    }

    public void run()
    {
        ReentrantLock reentrantlock;
        while (b() || c()) 
        {
            return;
        }
        reentrantlock = g.h;
        ajt.a("Start display image task [%s]", new Object[] {
            n
        });
        if (reentrantlock.isLocked())
        {
            ajt.a("Image already is loading. Waiting... [%s]", new Object[] {
                n
            });
        }
        reentrantlock.lock();
        Bitmap bitmap1;
        i();
        bitmap1 = (Bitmap)i.n.a(n);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (!bitmap1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_370;
        }
        bitmap1 = d();
        if (bitmap1 == null)
        {
            reentrantlock.unlock();
            return;
        }
        i();
        o();
        Bitmap bitmap = bitmap1;
        if (!c.d())
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ajt.a("PreProcess image before caching in memory [%s]", new Object[] {
            n
        });
        bitmap1 = c.o().a(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ajt.d("Pre-processor returned null [%s]", new Object[] {
            n
        });
        bitmap = bitmap1;
        bitmap1 = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        bitmap1 = bitmap;
        if (!c.h())
        {
            break MISSING_BLOCK_LABEL_248;
        }
        ajt.a("Cache image in memory [%s]", new Object[] {
            n
        });
        i.n.a(n, bitmap);
        bitmap1 = bitmap;
_L2:
        bitmap = bitmap1;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        bitmap = bitmap1;
        if (!c.e())
        {
            break MISSING_BLOCK_LABEL_322;
        }
        ajt.a("PostProcess image before displaying [%s]", new Object[] {
            n
        });
        bitmap1 = c.p().a(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        ajt.d("Post-processor returned null [%s]", new Object[] {
            n
        });
        bitmap = bitmap1;
        i();
        o();
        reentrantlock.unlock();
        a(new aii(bitmap, g, f, q), p, h, f);
        return;
        q = aiv.c;
        ajt.a("...Get cached bitmap from memory after waiting. [%s]", new Object[] {
            n
        });
        if (true) goto _L2; else goto _L1
_L1:
        Object obj;
        obj;
        g();
        reentrantlock.unlock();
        return;
        obj;
        reentrantlock.unlock();
        throw obj;
    }
}
