// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.wantu.imagelib.decorator.TGifEleDecorator;
import com.wantu.imagelib.decorator.sprite.CanvasSurfaceView;
import com.wantu.imagelib.decorator.sprite.GifTransformPanel;
import java.util.List;

public class bkf extends Thread
{

    final CanvasSurfaceView a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private bkg i;
    private Runnable j;
    private SurfaceHolder k;
    private GifTransformPanel l;

    public bkf(CanvasSurfaceView canvassurfaceview, SurfaceHolder surfaceholder, bkg bkg1)
    {
        a = canvassurfaceview;
        super();
        b = false;
        g = 0;
        h = 0;
        i = bkg1;
        k = surfaceholder;
        l = new GifTransformPanel(canvassurfaceview.getContext());
        ((bkh)i).a(l);
        setName("CanvasThread");
    }

    private boolean l()
    {
        return (c || !d || !e || f) && !b;
    }

    public List a()
    {
        this;
        JVM INSTR monitorenter ;
        List list = ((bkh)i).e();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        ((bkh)i).a(i1);
        this;
        JVM INSTR monitorexit ;
        return;
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
        CanvasSurfaceView.access$002(a, true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(bkt bkt)
    {
        this;
        JVM INSTR monitorenter ;
        ((bkh)i).a(bkt);
        this;
        JVM INSTR monitorexit ;
        return;
        bkt;
        this;
        JVM INSTR monitorexit ;
        throw bkt;
    }

    public void a(TGifEleDecorator tgifeledecorator)
    {
        this;
        JVM INSTR monitorenter ;
        tgifeledecorator = new bki(tgifeledecorator);
        ((bkh)i).a(tgifeledecorator);
        l.a(tgifeledecorator);
        this;
        JVM INSTR monitorexit ;
        return;
        tgifeledecorator;
        this;
        JVM INSTR monitorexit ;
        throw tgifeledecorator;
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
        ((bkh)i).a(flag);
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
        ((bkh)i).a(motionevent);
        this;
        JVM INSTR monitorexit ;
        return true;
        motionevent;
        this;
        JVM INSTR monitorexit ;
        throw motionevent;
    }

    public List b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        List list = ((bkh)i).b(i1);
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        ((bkh)i).b();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(boolean flag)
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

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        ((bkh)i).c();
        this;
        JVM INSTR monitorexit ;
        return;
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
        ((bkh)i).d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int e()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = ((bkh)i).a();
        this;
        JVM INSTR monitorexit ;
        return i1;
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

    public void g()
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

    public void h()
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

    public void i()
    {
        this;
        JVM INSTR monitorenter ;
        c = false;
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

    public void k()
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
        if (!l())
        {
            break MISSING_BLOCK_LABEL_54;
        }
_L1:
        boolean flag = l();
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
        flag = CanvasSurfaceView.access$000(a);
        i1 = g;
        j1 = h;
        CanvasSurfaceView.access$002(a, false);
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
