// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.b.c;
import com.nostra13.universalimageloader.core.a.d;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c.a;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            l, h, m, d, 
//            e, c

final class LoadAndDisplayImageTask
    implements c, Runnable
{

    final String a;
    final a b;
    final com.nostra13.universalimageloader.core.d c;
    final com.nostra13.universalimageloader.core.d.a d;
    final com.nostra13.universalimageloader.core.d.b e;
    private final l f;
    private final m g;
    private final Handler h;
    private final h i;
    private final ImageDownloader j;
    private final ImageDownloader k;
    private final ImageDownloader l;
    private final d m;
    private final String n;
    private final com.nostra13.universalimageloader.core.assist.c o;
    private final boolean p;
    private LoadedFrom q;

    public LoadAndDisplayImageTask(l l1, m m1, Handler handler)
    {
        q = LoadedFrom.a;
        f = l1;
        g = m1;
        h = handler;
        i = l1.a;
        j = i.p;
        k = i.s;
        l = i.t;
        m = i.q;
        a = m1.a;
        n = m1.b;
        b = m1.c;
        o = m1.d;
        c = m1.e;
        d = m1.f;
        e = m1.g;
        p = c.s();
    }

    private Bitmap a(String s)
    {
        ViewScaleType viewscaletype = b.c();
        s = new e(n, s, a, o, viewscaletype, h(), c);
        return m.a(s);
    }

    static h a(LoadAndDisplayImageTask loadanddisplayimagetask)
    {
        return loadanddisplayimagetask.i;
    }

    private void a(com.nostra13.universalimageloader.core.assist.FailReason.FailType failtype, Throwable throwable)
    {
        if (p || p() || j())
        {
            return;
        } else
        {
            a(((Runnable) (new _cls2(failtype, throwable))), false, h, f);
            return;
        }
    }

    static void a(Runnable runnable, boolean flag, Handler handler, l l1)
    {
        if (flag)
        {
            runnable.run();
            return;
        }
        if (handler == null)
        {
            l1.a(runnable);
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
        atomicboolean = f.b();
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Object obj = f.c();
        obj;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        com.nostra13.universalimageloader.b.d.a("ImageLoader is paused. Waiting...  [%s]", new Object[] {
            n
        });
        f.c().wait();
        com.nostra13.universalimageloader.b.d.a(".. Resume loading [%s]", new Object[] {
            n
        });
        return j();
        Object obj1;
        obj1;
        com.nostra13.universalimageloader.b.d.d("Task was interrupted [%s]", new Object[] {
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
    {
        Object obj = i.o.a(a);
        if (obj != null && ((File) (obj)).exists())
        {
            Object obj1 = new com.nostra13.universalimageloader.core.assist.c(i1, j1);
            com.nostra13.universalimageloader.core.d d1 = (new com.nostra13.universalimageloader.core.e()).a(c).a(ImageScaleType.d).a();
            obj = new e(n, com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.c.b(((File) (obj)).getAbsolutePath()), a, ((com.nostra13.universalimageloader.core.assist.c) (obj1)), ViewScaleType.a, h(), d1);
            obj1 = m.a(((e) (obj)));
            obj = obj1;
            if (obj1 != null)
            {
                obj = obj1;
                if (i.f != null)
                {
                    com.nostra13.universalimageloader.b.d.a("Process image before cache on disk [%s]", new Object[] {
                        n
                    });
                    obj1 = i.f.a(((Bitmap) (obj1)));
                    obj = obj1;
                    if (obj1 == null)
                    {
                        com.nostra13.universalimageloader.b.d.d("Bitmap processor for disk cache returned null [%s]", new Object[] {
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
            com.nostra13.universalimageloader.b.d.a("Delay %d ms before loading...  [%s]", new Object[] {
                Integer.valueOf(c.l()), n
            });
            try
            {
                Thread.sleep(c.l());
            }
            catch (InterruptedException interruptedexception)
            {
                com.nostra13.universalimageloader.b.d.d("Task was interrupted [%s]", new Object[] {
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
            a(new _cls1(i1, j1), false, h, f);
        }
        return true;
    }

    private Bitmap d()
    {
        Object obj = i.o.a(a);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((File) (obj)).exists()) goto _L2; else goto _L3
_L3:
        com.nostra13.universalimageloader.b.d.a("Load image from disk cache [%s]", new Object[] {
            n
        });
        q = LoadedFrom.b;
        i();
        obj = a(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.c.b(((File) (obj)).getAbsolutePath()));
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
        com.nostra13.universalimageloader.b.d.a("Load image from network [%s]", new Object[] {
            n
        });
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        obj4 = obj;
        q = LoadedFrom.a;
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
        obj5 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.c.b(file.getAbsolutePath());
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
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.b, ((Throwable) (null)));
        obj5 = obj;
        return ((Bitmap) (obj5));
        obj;
        obj4 = null;
_L10:
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.c, ((Throwable) (null)));
        return ((Bitmap) (obj4));
        obj;
        throw obj;
        obj;
        obj3 = null;
_L9:
        com.nostra13.universalimageloader.b.d.a(((Throwable) (obj)));
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.a, ((Throwable) (obj)));
        return ((Bitmap) (obj3));
        obj;
        obj2 = null;
_L7:
        com.nostra13.universalimageloader.b.d.a(((Throwable) (obj)));
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.d, ((Throwable) (obj)));
        return ((Bitmap) (obj2));
        obj;
        obj1 = null;
_L5:
        com.nostra13.universalimageloader.b.d.a(((Throwable) (obj)));
        a(com.nostra13.universalimageloader.core.assist.FailReason.FailType.e, ((Throwable) (obj)));
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
    {
        com.nostra13.universalimageloader.b.d.a("Cache image on disk [%s]", new Object[] {
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
            com.nostra13.universalimageloader.b.d.a(ioexception);
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
        com.nostra13.universalimageloader.b.d.a("Resize image in disk cache [%s]", new Object[] {
            n
        });
        b(i1, j1);
        return flag;
    }

    private boolean f()
    {
        java.io.InputStream inputstream;
        inputstream = h().a_(a, c.n());
        if (inputstream == null)
        {
            com.nostra13.universalimageloader.b.d.d("No stream for image [%s]", new Object[] {
                n
            });
            return false;
        }
        boolean flag = i.o.a(a, inputstream, this);
        com.nostra13.universalimageloader.b.b.a(inputstream);
        return flag;
        Exception exception;
        exception;
        com.nostra13.universalimageloader.b.b.a(inputstream);
        throw exception;
    }

    private void g()
    {
        if (p || p())
        {
            return;
        } else
        {
            a(new _cls3(), false, h, f);
            return;
        }
    }

    private ImageDownloader h()
    {
        if (f.d())
        {
            return k;
        }
        if (f.e())
        {
            return l;
        } else
        {
            return j;
        }
    }

    private void i()
    {
        k();
        m();
    }

    private boolean j()
    {
        return l() || n();
    }

    private void k()
    {
        if (l())
        {
            throw new TaskCancelledException();
        } else
        {
            return;
        }
    }

    private boolean l()
    {
        if (b.e())
        {
            com.nostra13.universalimageloader.b.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] {
                n
            });
            return true;
        } else
        {
            return false;
        }
    }

    private void m()
    {
        if (n())
        {
            throw new TaskCancelledException();
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
            com.nostra13.universalimageloader.b.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] {
                n
            });
            return true;
        } else
        {
            return false;
        }
    }

    private void o()
    {
        if (p())
        {
            throw new TaskCancelledException();
        } else
        {
            return;
        }
    }

    private boolean p()
    {
        if (Thread.interrupted())
        {
            com.nostra13.universalimageloader.b.d.a("Task was interrupted [%s]", new Object[] {
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
        com.nostra13.universalimageloader.b.d.a("Start display image task [%s]", new Object[] {
            n
        });
        if (reentrantlock.isLocked())
        {
            com.nostra13.universalimageloader.b.d.a("Image already is loading. Waiting... [%s]", new Object[] {
                n
            });
        }
        reentrantlock.lock();
        Bitmap bitmap1;
        i();
        bitmap1 = i.n.a(n);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (!bitmap1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_367;
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
            break MISSING_BLOCK_LABEL_190;
        }
        com.nostra13.universalimageloader.b.d.a("PreProcess image before caching in memory [%s]", new Object[] {
            n
        });
        bitmap1 = c.o().a(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        com.nostra13.universalimageloader.b.d.d("Pre-processor returned null [%s]", new Object[] {
            n
        });
        bitmap = bitmap1;
        bitmap1 = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        bitmap1 = bitmap;
        if (!c.h())
        {
            break MISSING_BLOCK_LABEL_245;
        }
        com.nostra13.universalimageloader.b.d.a("Cache image in memory [%s]", new Object[] {
            n
        });
        i.n.a(n, bitmap);
        bitmap1 = bitmap;
_L2:
        bitmap = bitmap1;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        bitmap = bitmap1;
        if (!c.e())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        com.nostra13.universalimageloader.b.d.a("PostProcess image before displaying [%s]", new Object[] {
            n
        });
        bitmap1 = c.p().a(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        com.nostra13.universalimageloader.b.d.d("Post-processor returned null [%s]", new Object[] {
            n
        });
        bitmap = bitmap1;
        i();
        o();
        reentrantlock.unlock();
        a(new com.nostra13.universalimageloader.core.c(bitmap, g, f, q), p, h, f);
        return;
        q = LoadedFrom.c;
        com.nostra13.universalimageloader.b.d.a("...Get cached bitmap from memory after waiting. [%s]", new Object[] {
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

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class TaskCancelledException {}

}
