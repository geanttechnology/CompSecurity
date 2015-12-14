// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.wantu.imagelib.decorator.sprite.ImageCanvasSurfaceView;
import com.wantu.imagelib.decorator.sprite.ImageTransformPanel;
import java.util.List;

public class bkk extends Thread
{

    final ImageCanvasSurfaceView a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private bkl i;
    private Runnable j;
    private SurfaceHolder k;
    private ImageTransformPanel l;
    private bkj m;

    public bkk(ImageCanvasSurfaceView imagecanvassurfaceview, SurfaceHolder surfaceholder, bkl bkl1)
    {
        a = imagecanvassurfaceview;
        super();
        b = false;
        g = 0;
        h = 0;
        i = bkl1;
        k = surfaceholder;
        l = new ImageTransformPanel(imagecanvassurfaceview.getContext());
        m = new bkj(null);
        i.a(m);
        l.d = false;
        i.a(l);
        setName("CanvasThread");
    }

    private boolean p()
    {
        return (c || !d || !e || f) && !b;
    }

    public Bitmap a()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = i.j();
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i1, int j1)
    {
        this;
        JVM INSTR monitorenter ;
        g = i1;
        h = j1;
        ImageCanvasSurfaceView.access$002(a, true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i1, Bitmap bitmap, int j1, int k1, int l1)
    {
        m.b(j1);
        m.c(k1);
        m.a(i1);
        m.a = bitmap;
        i.a(l1);
    }

    public void a(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        i.a(bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        this;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    public void a(Bitmap bitmap, int i1, int j1)
    {
        if (bitmap != null)
        {
            bitmap = new BitmapDrawable(bitmap);
            bitmap.setBounds(0, 0, i1, j1);
            i.a(bitmap);
            return;
        } else
        {
            i.a(null);
            return;
        }
    }

    public void a(bkd bkd, Matrix matrix, Matrix matrix1, Matrix matrix2)
    {
        this;
        JVM INSTR monitorenter ;
        bkd = new bkn(bkd);
        bkd.f(matrix);
        bkd.d(matrix1);
        bkd.b(matrix2);
        i.a(bkd);
        l.a(bkd);
        this;
        JVM INSTR monitorexit ;
        return;
        bkd;
        this;
        JVM INSTR monitorexit ;
        throw bkd;
    }

    public void a(bkt bkt)
    {
        this;
        JVM INSTR monitorenter ;
        i.a(bkt);
        this;
        JVM INSTR monitorexit ;
        return;
        bkt;
        this;
        JVM INSTR monitorexit ;
        throw bkt;
    }

    public void a(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        j = runnable;
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        d = flag;
        if (d)
        {
            notify();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a(MotionEvent motionevent)
    {
        this;
        JVM INSTR monitorenter ;
        i.a(motionevent);
        this;
        JVM INSTR monitorexit ;
        return true;
        motionevent;
        this;
        JVM INSTR monitorexit ;
        throw motionevent;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        i.e();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List c()
    {
        this;
        JVM INSTR monitorenter ;
        List list = i.a();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        i.g();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        i.h();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void f()
    {
        this;
        JVM INSTR monitorenter ;
        i.i();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int g()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = i.f();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        e = true;
        f = false;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void i()
    {
        this;
        JVM INSTR monitorenter ;
        e = false;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void j()
    {
        this;
        JVM INSTR monitorenter ;
        c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void k()
    {
        this;
        JVM INSTR monitorenter ;
        c = false;
        notify();
        i.b();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void l()
    {
        this;
        JVM INSTR monitorenter ;
        i.c();
        d = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void m()
    {
        this;
        JVM INSTR monitorenter ;
        i.d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n()
    {
        this;
        JVM INSTR monitorenter ;
        b = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            join();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
        }
        break MISSING_BLOCK_LABEL_30;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void o()
    {
        this;
        JVM INSTR monitorenter ;
        j = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
_L3:
        if (b)
        {
            break; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorenter ;
        if (j != null)
        {
            j.run();
        }
        if (!p())
        {
            break MISSING_BLOCK_LABEL_54;
        }
_L1:
        boolean flag = p();
        Exception exception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        android.graphics.Canvas canvas;
        int i1;
        int j1;
        try
        {
            wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
          goto _L1
        if (!b)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        flag = ImageCanvasSurfaceView.access$000(a);
        i1 = g;
        j1 = h;
        ImageCanvasSurfaceView.access$002(a, false);
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            i.a(i1, j1);
        }
        if (i1 <= 0 || j1 <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        canvas = k.lockCanvas();
        if (canvas == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorenter ;
        i.a(canvas);
        this;
        JVM INSTR monitorexit ;
        k.unlockCanvasAndPost(canvas);
        if (true) goto _L3; else goto _L2
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
    }
}
