// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.wantu.imagelib.decorator.sprite.ImageTransformPanel;
import java.util.LinkedList;
import java.util.List;

public class bkl
    implements bkg
{

    private bkj a;
    private BitmapDrawable b;
    private List c;
    private ImageTransformPanel d;
    private bkt e;
    private GestureDetector f;
    private boolean g;

    public bkl()
    {
        c = new LinkedList();
    }

    public bkn a(float f1, float f2)
    {
        for (int k = f() - 1; k >= 0; k--)
        {
            bkn bkn1 = (bkn)c.get(k);
            if (bkn1.d && bkn1.a(f1, f2))
            {
                if (e != null)
                {
                    e.spriteSelected(bkn1.a());
                }
                return bkn1;
            }
        }

        return null;
    }

    public List a()
    {
        return c;
    }

    public void a(int k)
    {
        List list = c;
        list;
        JVM INSTR monitorenter ;
        if (c == null) goto _L2; else goto _L1
_L1:
        int l = 0;
_L3:
        if (l >= c.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((bkn)c.get(l)).a().b = k;
        l++;
        if (true) goto _L3; else goto _L2
_L2:
        list;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int k, int l)
    {
        if (a != null)
        {
            a.b(k);
            a.c(l);
        }
    }

    public void a(Bitmap bitmap)
    {
        bkn bkn1 = d.a();
        bkd bkd1 = bkn1.a();
        bkd1.i = bitmap;
        bkd1.g = bitmap.getWidth();
        bkd1.h = bitmap.getHeight();
        bkn1.a = bitmap.getWidth();
        bkn1.b = bitmap.getHeight();
    }

    public void a(Canvas canvas)
    {
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        if (g) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (a != null)
        {
            a.a(canvas);
        }
        List list = c;
        list;
        JVM INSTR monitorenter ;
        if (c == null) goto _L4; else goto _L3
_L3:
        int k = 0;
_L5:
        if (k >= c.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((bkn)c.get(k)).a(canvas);
        k++;
        if (true) goto _L5; else goto _L4
_L4:
        list;
        JVM INSTR monitorexit ;
        if (d != null)
        {
            d.a(canvas);
        }
        if (b == null) goto _L1; else goto _L6
_L6:
        b.draw(canvas);
        return;
        canvas;
        list;
        JVM INSTR monitorexit ;
        throw canvas;
    }

    public void a(BitmapDrawable bitmapdrawable)
    {
        b = bitmapdrawable;
    }

    public void a(bkj bkj1)
    {
        a = bkj1;
    }

    public void a(bkn bkn1)
    {
        synchronized (c)
        {
            ((LinkedList)c).addLast(bkn1);
        }
        return;
        bkn1;
        list;
        JVM INSTR monitorexit ;
        throw bkn1;
    }

    public void a(bkt bkt1)
    {
        e = bkt1;
    }

    public void a(ImageTransformPanel imagetransformpanel)
    {
        d = imagetransformpanel;
        if (f == null)
        {
            f = new GestureDetector(d.b(), new bkm(this));
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        if (f != null)
        {
            f.onTouchEvent(motionevent);
        }
        if (motionevent.getAction() == 0)
        {
            if (d.a((int)motionevent.getX(), (int)motionevent.getY()))
            {
                return d.a(motionevent);
            }
            if (d.b((int)motionevent.getX(), (int)motionevent.getY()))
            {
                if (e != null)
                {
                    e.editButtonClicked();
                }
                return d.a(motionevent);
            }
            bkn bkn1 = a(motionevent.getX(), motionevent.getY());
            if (bkn1 != null)
            {
                d.d = true;
                d.a(bkn1);
            }
        }
        return d.a(motionevent);
    }

    public void b()
    {
        if (d != null)
        {
            d.d = false;
        }
    }

    public void b(bkn bkn1)
    {
        synchronized (c)
        {
            ((LinkedList)c).remove(bkn1);
        }
        return;
        bkn1;
        list;
        JVM INSTR monitorexit ;
        throw bkn1;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        g = true;
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
        g = false;
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
        synchronized (c)
        {
            c.clear();
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int f()
    {
        return c.size();
    }

    public void g()
    {
        bkn bkn1 = d.a();
        if (bkn1 != null)
        {
            c.remove(bkn1);
            d.a(null);
        }
    }

    public void h()
    {
        if (d.a() == null);
    }

    public void i()
    {
        bkn bkn2 = d.a();
        if (bkn2 == null) goto _L2; else goto _L1
_L1:
        bkn bkn1 = null;
        bkn2 = bkn2.b();
        bkn1 = bkn2;
_L4:
        a(bkn1);
        d.a(bkn1);
_L2:
        return;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        clonenotsupportedexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Bitmap j()
    {
        if (d != null && d.d)
        {
            d.d = false;
        }
        int k = a.a();
        int l = a.b();
        float f1 = (float)k / (float)a.a();
        float f2 = (float)l / (float)a.b();
        Bitmap bitmap = Bitmap.createBitmap(k, l, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(f1, f2);
        a(canvas);
        return bitmap;
    }
}
