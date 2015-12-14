// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.Timer;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view:
//            c, f, e, d

public class TouchImageView extends c
{

    long A;
    boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    private Context G;
    private Timer H;
    private android.view.View.OnClickListener I;
    private Handler J;
    private boolean K;
    private int L;
    private boolean M;
    private long N;
    protected Matrix a;
    Matrix b;
    int c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    float l;
    float m;
    PointF n;
    PointF o;
    PointF p;
    float q[];
    float r;
    float s;
    float t;
    float u;
    float v;
    float w;
    PointF x;
    float y;
    long z;

    public TouchImageView(Context context)
    {
        super(context);
        a = new Matrix();
        b = new Matrix();
        c = 0;
        n = new PointF();
        o = new PointF();
        p = new PointF();
        t = 1.0F;
        u = 1.0F;
        v = 3F;
        w = 1.0F;
        x = new PointF(0.0F, 0.0F);
        y = 0.0F;
        z = 0L;
        A = 0L;
        B = false;
        J = null;
        K = false;
        L = -1;
        M = false;
        N = -1L;
        C = false;
        D = false;
        E = false;
        F = false;
        super.setClickable(true);
        G = context;
        a();
    }

    public TouchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Matrix();
        b = new Matrix();
        c = 0;
        n = new PointF();
        o = new PointF();
        p = new PointF();
        t = 1.0F;
        u = 1.0F;
        v = 3F;
        w = 1.0F;
        x = new PointF(0.0F, 0.0F);
        y = 0.0F;
        z = 0L;
        A = 0L;
        B = false;
        J = null;
        K = false;
        L = -1;
        M = false;
        N = -1L;
        C = false;
        D = false;
        E = false;
        F = false;
        super.setClickable(true);
        G = context;
        if (attributeset != null)
        {
            M = false;
        }
        a();
    }

    public TouchImageView(Context context, boolean flag)
    {
        super(context);
        a = new Matrix();
        b = new Matrix();
        c = 0;
        n = new PointF();
        o = new PointF();
        p = new PointF();
        t = 1.0F;
        u = 1.0F;
        v = 3F;
        w = 1.0F;
        x = new PointF(0.0F, 0.0F);
        y = 0.0F;
        z = 0L;
        A = 0L;
        B = false;
        J = null;
        K = false;
        L = -1;
        M = false;
        N = -1L;
        C = false;
        D = false;
        E = false;
        F = false;
        super.setClickable(true);
        G = context;
        M = flag;
        a();
    }

    private double a(PointF pointf, PointF pointf1)
    {
        return Math.sqrt(Math.pow(pointf.x - pointf1.x, 2D) + Math.pow(pointf.y - pointf1.y, 2D));
    }

    private float a(f f1)
    {
        float f2 = f1.a(0) - f1.a(1);
        float f3 = f1.b(0) - f1.b(1);
        return (float)Math.sqrt(f2 * f2 + f3 * f3);
    }

    static Handler a(TouchImageView touchimageview)
    {
        return touchimageview.J;
    }

    private void a(float f1, float f2)
    {
label0:
        {
            {
                float f3 = Math.round(h * t);
                float f4 = Math.round(i * t);
                e();
                if (f3 >= l)
                {
                    break label0;
                }
                if (s + f2 > 0.0F)
                {
                    f1 = -s;
                    f3 = 0.0F;
                } else
                if (s + f2 < -g)
                {
                    f1 = -(s + g);
                    f3 = 0.0F;
                } else
                {
                    f3 = 0.0F;
                    f1 = f2;
                }
            }
            a.postTranslate(f3, f1);
            c();
            return;
        }
        if (f4 < m)
        {
            if (r + f1 > 0.0F)
            {
                f3 = -r;
                f1 = 0.0F;
            } else
            if (r + f1 < -f)
            {
                f3 = -(r + f);
                f1 = 0.0F;
            } else
            {
                f2 = 0.0F;
                f3 = f1;
                f1 = f2;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (r + f1 <= 0.0F) goto _L2; else goto _L1
_L1:
        f4 = -r;
_L4:
        if (s + f2 <= 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        f1 = -s;
        f3 = f4;
        continue; /* Loop/switch isn't completed */
_L2:
        f4 = f1;
        if (r + f1 < -f)
        {
            f4 = -(r + f);
        }
        if (true) goto _L4; else goto _L3
_L3:
        f3 = f4;
        f1 = f2;
        if (s + f2 < -g)
        {
            f1 = -(s + g);
            f3 = f4;
        }
        if (true) goto _L6; else goto _L5
_L5:
        break MISSING_BLOCK_LABEL_280;
_L6:
        break MISSING_BLOCK_LABEL_61;
    }

    private void a(PointF pointf, f f1)
    {
        float f2 = f1.a(0);
        float f3 = f1.a(1);
        float f4 = f1.b(0);
        float f5 = f1.b(1);
        pointf.set((f2 + f3) / 2.0F, (f4 + f5) / 2.0F);
    }

    static android.view.View.OnClickListener b(TouchImageView touchimageview)
    {
        return touchimageview.I;
    }

    private void c()
    {
        e();
        float f1 = Math.round(h * t);
        float f2 = Math.round(i * t);
        F = false;
        D = false;
        E = false;
        C = false;
        if (-r < 10F)
        {
            C = true;
        }
        if (f1 >= l && (r + f1) - l < 10F || f1 <= l && f1 + -r <= l)
        {
            E = true;
        }
        if (-s < 10F)
        {
            D = true;
        }
        if (Math.abs((-s + m) - f2) < 10F)
        {
            F = true;
        }
    }

    private void d()
    {
        f = l * t - l - d * 2.0F * t;
        g = m * t - m - e * 2.0F * t;
    }

    private void e()
    {
        a.getValues(q);
        r = q[2];
        s = q[5];
    }

    protected void a()
    {
        J = new e(this);
        a.setTranslate(1.0F, 1.0F);
        q = new float[9];
        setImageMatrix(a);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    public boolean b()
    {
        while (c != 0 || t != u) 
        {
            return false;
        }
        return true;
    }

    public long getImageId()
    {
        return N;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (B)
        {
            float f1 = x.x * y;
            float f2 = x.y * y;
            if (f1 <= l && f2 <= m)
            {
                y = y * 0.9F;
                if ((double)Math.abs(f1) >= 0.10000000000000001D || (double)Math.abs(f2) >= 0.10000000000000001D)
                {
                    a(f1, f2);
                    setImageMatrix(a);
                    return;
                }
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        l = android.view.View.MeasureSpec.getSize(i1);
        m = android.view.View.MeasureSpec.getSize(j1);
        float f1 = Math.min(l / j, m / k);
        a.setScale(f1, f1);
        setImageMatrix(a);
        t = 1.0F;
        e = m - k * f1;
        d = l - f1 * j;
        e = e / 2.0F;
        d = d / 2.0F;
        a.postTranslate(d, e);
        h = l - d * 2.0F;
        i = m - e * 2.0F;
        d();
        setImageMatrix(a);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        f f3;
        PointF pointf;
        int k1;
        k1 = 0;
        f3 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.f.a(motionevent);
        e();
        pointf = new PointF(f3.b(), f3.c());
        f3.a() & 0xff;
        JVM INSTR tableswitch 0 6: default 84
    //                   0 98
    //                   1 230
    //                   2 406
    //                   3 84
    //                   4 84
    //                   5 166
    //                   6 372;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        setImageMatrix(a);
        invalidate();
        return true;
_L2:
        B = false;
        b.set(a);
        n.set(f3.b(), f3.c());
        p.set(n);
        if (!M)
        {
            c = 1;
        }
        L = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L5:
        w = a(f3);
        if (w > 10F)
        {
            b.set(a);
            a(o, f3);
            if (M)
            {
                c = 3;
            } else
            {
                c = 2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        B = true;
        c = 0;
        int i1 = (int)Math.abs(f3.b() - p.x);
        k1 = (int)Math.abs(f3.c() - p.y);
        if (i1 < 10 && k1 < 10)
        {
            long l1 = System.currentTimeMillis();
            if (l1 - z <= 600L)
            {
                if (H != null)
                {
                    H.cancel();
                }
                z = 0L;
            } else
            {
                z = l1;
                H = new Timer();
                H.schedule(new d(this), 300L);
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        c = 0;
        y = 0.0F;
        b.set(a);
        w = a(f3);
        continue; /* Loop/switch isn't completed */
_L4:
        B = false;
        int j1 = k1;
        if (c != 1)
        {
            if (c != 3)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        for (j1 = k1; j1 < motionevent.getPointerCount(); j1++)
        {
            if (motionevent.getPointerId(j1) == L)
            {
                pointf.x = motionevent.getX(j1);
                pointf.y = motionevent.getY(j1);
            }
        }

        float f1 = pointf.x - n.x;
        float f2 = pointf.y - n.y;
        long l2 = System.currentTimeMillis();
        y = ((float)a(pointf, n) / (float)(l2 - A)) * 0.9F;
        A = l2;
        a(f1, f2);
        x.set(f1, f2);
        n.set(pointf.x, pointf.y);
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        if (bitmap != null)
        {
            j = bitmap.getWidth();
            k = bitmap.getHeight();
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        super.setImageDrawable(drawable);
        if (drawable != null)
        {
            j = drawable.getMinimumWidth();
            k = drawable.getMinimumHeight();
        }
    }

    public void setImageId(long l1)
    {
        N = l1;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        I = onclicklistener;
    }

    public void setZoomToOriginalSize(boolean flag)
    {
        K = flag;
    }
}
