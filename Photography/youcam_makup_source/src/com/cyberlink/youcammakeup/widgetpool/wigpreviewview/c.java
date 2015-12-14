// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ai;
import java.lang.ref.WeakReference;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            e, f, d, WigView

public class c
{

    public Paint a;
    private float b[];
    private PointF c;
    private RectF d;
    private float e;
    private float f;
    private float g;
    private float h;
    private double i;
    private double j;
    private float k;
    private RectF l;
    private boolean m;
    private e n;
    private WeakReference o;
    private Handler p;

    private c()
    {
        b = new float[9];
        c = new PointF();
        d = new RectF();
        a = aa.a();
        h = 1.0F;
        l = new RectF();
        m = false;
        n = new e(this);
        o = null;
        p = new Handler(new f(this));
    }


    private void a(RectF rectf)
    {
        ai.a(-j, n.a, n.b, c);
        rectf.left = rectf.left + c.x;
        rectf.top = rectf.top + c.y;
        float f1 = n.c;
        float f2 = rectf.right;
        float f3 = rectf.bottom;
        rectf.right = f2 * f1;
        rectf.bottom = f1 * f3;
        rectf.left = rectf.left + (f2 - rectf.right) * 0.4994949F;
        rectf.top = rectf.top + (f3 - rectf.bottom) * 0.3590517F;
    }

    private void b(RectF rectf)
    {
        float f3 = rectf.left;
        float f4 = rectf.top;
        float f5 = rectf.right;
        float f6 = rectf.bottom;
        ai.a(j, f3, f4, c);
        float f1 = c.x;
        float f2 = c.y;
        ai.a(j, f3 + f5 * 0.4994949F, f4 + 0.3590517F * f6, c);
        f3 = c.x;
        f4 = c.y;
        ai.a(k, f1 - f3, f2 - f4, c);
        f1 = c.x;
        f2 = c.y;
        ai.a(-i, f3 + f1, f4 + f2, c);
        rectf.left = c.x;
        rectf.top = c.y;
    }

    public static c h()
    {
        return com.cyberlink.youcammakeup.widgetpool.wigpreviewview.d.a();
    }

    public float a()
    {
        return f;
    }

    public RectF a(float f1, float f2)
    {
        float f4 = (float)i;
        float f5 = l.left;
        float f6 = l.top;
        float f7 = l.width();
        float f3 = l.height();
        ai.a(f4, f5 + 0.4994949F * f7, f6 + 0.3590517F * f3, c);
        f4 = (0.2858586F * f7) / 2.0F;
        f3 = (0.325F * f3) / 2.0F;
        RectF rectf = new RectF(c.x - f4, c.y - f3, f4 + c.x, f3 + c.y);
        rectf.left = rectf.left * e + f1 + f;
        rectf.top = rectf.top * e + f2 + g;
        rectf.right = rectf.right * e + f1 + f;
        rectf.bottom = rectf.bottom * e + f2 + g;
        return rectf;
    }

    public void a(float f1)
    {
        n.c = f1;
    }

    public void a(int i1)
    {
        p.removeMessages(3);
        Message message = Message.obtain(p, 3, i1, -1);
        p.sendMessage(message);
    }

    public void a(t t1)
    {
        p.removeMessages(1);
        t1 = Message.obtain(p, 1, t1);
        p.sendMessage(t1);
    }

    public void a(t t1, Bitmap bitmap, bi bi1)
    {
        t1.e.getValues(b);
        e = b[0];
        f = b[2] * e;
        g = b[5] * e;
        float f1 = bi1.b();
        h = n.c * f1;
        j = Math.toDegrees(bi1.c());
        k = n.d;
        i = j + (double)k;
        d = new RectF(bi1.d() * f1, bi1.e() * f1, (float)bitmap.getWidth() * f1, f1 * (float)bitmap.getHeight());
        a(d);
        b(d);
        l.left = d.left;
        l.top = d.top;
        l.right = l.left + d.right;
        l.bottom = l.top + d.bottom;
        a(true);
    }

    public void a(WigView wigview)
    {
        if (o != null)
        {
            o.clear();
            o = null;
        }
        if (wigview != null)
        {
            o = new WeakReference(wigview);
        }
    }

    public void a(boolean flag)
    {
        m = flag;
    }

    public float b()
    {
        return g;
    }

    public void b(float f1)
    {
        n.d = f1;
    }

    public void b(float f1, float f2)
    {
        n.a = f1;
        n.b = f2;
    }

    public float c()
    {
        return e;
    }

    public double d()
    {
        return i;
    }

    public RectF e()
    {
        return l;
    }

    public bi f()
    {
        bi bi1 = new bi();
        if (g())
        {
            bi1.c(l.left / h);
            bi1.d(l.top / h);
            bi1.a(h);
            bi1.b((float)Math.toRadians(i));
            return bi1;
        } else
        {
            return VenusHelper.a().f();
        }
    }

    public boolean g()
    {
        return m;
    }

    public float i()
    {
        return n.a;
    }

    public float j()
    {
        return n.b;
    }

    public float k()
    {
        return n.c;
    }

    public float l()
    {
        return n.d;
    }

    public void m()
    {
        n.a();
    }

    public WigView n()
    {
        if (o == null)
        {
            return null;
        } else
        {
            return (WigView)o.get();
        }
    }

    public void o()
    {
        p.removeMessages(4);
        Message message = Message.obtain(p, 4);
        p.sendMessage(message);
    }
}
