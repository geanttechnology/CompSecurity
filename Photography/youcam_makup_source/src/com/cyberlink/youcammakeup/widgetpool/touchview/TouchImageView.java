// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.touchview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import java.util.Timer;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.touchview:
//            e, d, b, c

public class TouchImageView extends ImageView
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
    private android.view.View.OnTouchListener J;
    private Object K;
    private Handler L;
    private boolean M;
    private boolean N;
    Matrix a;
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
        v = 4F;
        w = 1.0F;
        x = new PointF(0.0F, 0.0F);
        y = 0.0F;
        z = 0L;
        A = 0L;
        B = false;
        L = null;
        M = false;
        N = true;
        C = false;
        D = false;
        E = false;
        F = false;
        super.setClickable(true);
        G = context;
        b();
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
        v = 4F;
        w = 1.0F;
        x = new PointF(0.0F, 0.0F);
        y = 0.0F;
        z = 0L;
        A = 0L;
        B = false;
        L = null;
        M = false;
        N = true;
        C = false;
        D = false;
        E = false;
        F = false;
        super.setClickable(true);
        G = context;
        b();
    }

    private double a(PointF pointf, PointF pointf1)
    {
        return Math.sqrt(Math.pow(pointf.x - pointf1.x, 2D) + Math.pow(pointf.y - pointf1.y, 2D));
    }

    static double a(TouchImageView touchimageview, PointF pointf, PointF pointf1)
    {
        return touchimageview.a(pointf, pointf1);
    }

    static float a(TouchImageView touchimageview, e e1)
    {
        return touchimageview.a(e1);
    }

    private float a(e e1)
    {
        float f1 = e1.a(0) - e1.a(1);
        float f2 = e1.b(0) - e1.b(1);
        return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }

    static android.view.View.OnTouchListener a(TouchImageView touchimageview)
    {
        return touchimageview.J;
    }

    static Timer a(TouchImageView touchimageview, Timer timer)
    {
        touchimageview.H = timer;
        return timer;
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

    private void a(PointF pointf, e e1)
    {
        float f1 = e1.a(0);
        float f2 = e1.a(1);
        float f3 = e1.b(0);
        float f4 = e1.b(1);
        pointf.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    }

    static void a(TouchImageView touchimageview, float f1, float f2)
    {
        touchimageview.a(f1, f2);
    }

    static void a(TouchImageView touchimageview, PointF pointf, e e1)
    {
        touchimageview.a(pointf, e1);
    }

    static boolean a(TouchImageView touchimageview, boolean flag)
    {
        touchimageview.N = flag;
        return flag;
    }

    static PointF b(TouchImageView touchimageview, e e1)
    {
        return touchimageview.b(e1);
    }

    private PointF b(e e1)
    {
        float f1 = e1.a(0);
        float f2 = e1.a(1);
        float f3 = e1.b(0);
        float f4 = e1.b(1);
        return new PointF((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    }

    static Object b(TouchImageView touchimageview)
    {
        return touchimageview.K;
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

    static void c(TouchImageView touchimageview)
    {
        touchimageview.e();
    }

    static Timer d(TouchImageView touchimageview)
    {
        return touchimageview.H;
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

    static void e(TouchImageView touchimageview)
    {
        touchimageview.d();
    }

    private void f()
    {
        if (Math.abs(r + f / 2.0F) > 0.5F)
        {
            a.postTranslate(-(r + f / 2.0F), 0.0F);
        }
        if (Math.abs(s + g / 2.0F) > 0.5F)
        {
            a.postTranslate(0.0F, -(s + g / 2.0F));
        }
    }

    static void f(TouchImageView touchimageview)
    {
        touchimageview.f();
    }

    static void g(TouchImageView touchimageview)
    {
        touchimageview.c();
    }

    static Handler h(TouchImageView touchimageview)
    {
        return touchimageview.L;
    }

    static android.view.View.OnClickListener i(TouchImageView touchimageview)
    {
        return touchimageview.I;
    }

    public void a(MotionEvent motionevent, boolean flag)
    {
        N = flag;
        super.dispatchTouchEvent(motionevent);
    }

    public boolean a()
    {
        return N;
    }

    protected void b()
    {
        L = new d(this);
        a.setTranslate(1.0F, 1.0F);
        q = new float[9];
        setImageMatrix(a);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            K = new ScaleGestureDetector(G, new b(this));
        }
        super.setOnTouchListener(new android.view.View.OnTouchListener() {

            final TouchImageView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                PointF pointf;
                if (TouchImageView.a(a) != null)
                {
                    TouchImageView.a(a).onTouch(view, motionevent);
                }
                TouchImageView.a(a, true);
                view = com.cyberlink.youcammakeup.widgetpool.touchview.e.a(motionevent);
                if (TouchImageView.b(a) != null)
                {
                    ((ScaleGestureDetector)TouchImageView.b(a)).onTouchEvent(motionevent);
                }
                TouchImageView.c(a);
                pointf = new PointF(view.b(), view.c());
                view.a() & 0xff;
                JVM INSTR tableswitch 0 6: default 140
            //                           0 156
            //                           1 298
            //                           2 718
            //                           3 140
            //                           4 140
            //                           5 227
            //                           6 667;
                   goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
                a.setImageMatrix(a.a);
                return false;
_L2:
                a.B = false;
                a.b.set(a.a);
                a.n.set(view.b(), view.c());
                a.p.set(a.n);
                a.c = 1;
                continue; /* Loop/switch isn't completed */
_L5:
                a.w = TouchImageView.a(a, view);
                if (a.w > 10F)
                {
                    a.b.set(a.a);
                    TouchImageView.a(a, a.o, view);
                    a.c = 2;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                a.B = true;
                a.c = 0;
                int i1 = (int)Math.abs(view.b() - a.p.x);
                int j1 = (int)Math.abs(view.c() - a.p.y);
                if (i1 < 10 && j1 < 10)
                {
                    long l1 = System.currentTimeMillis();
                    if (l1 - a.z <= 600L)
                    {
                        if (TouchImageView.d(a) != null)
                        {
                            TouchImageView.d(a).cancel();
                        }
                        if (a.t == 1.0F)
                        {
                            float f1 = a.v / a.t;
                            a.a.postScale(f1, f1, a.p.x, a.p.y);
                            a.t = a.v;
                        } else
                        {
                            a.a.postScale(a.u / a.t, a.u / a.t, a.l / 2.0F, a.m / 2.0F);
                            a.t = a.u;
                        }
                        TouchImageView.e(a);
                        TouchImageView.a(a, 0.0F, 0.0F);
                        a.z = 0L;
                    } else
                    {
                        a.z = l1;
                        TouchImageView.a(a, new Timer());
                        TouchImageView.d(a).schedule(new c(a), 300L);
                    }
                    if (a.t == a.u)
                    {
                        TouchImageView.f(a);
                    }
                }
                continue; /* Loop/switch isn't completed */
_L6:
                a.c = 0;
                a.y = 0.0F;
                a.b.set(a.a);
                a.w = TouchImageView.a(a, view);
                continue; /* Loop/switch isn't completed */
_L4:
                float f3;
                a.B = false;
                if (a.c == 1)
                {
                    float f2 = pointf.x - a.n.x;
                    float f4 = pointf.y - a.n.y;
                    long l2 = System.currentTimeMillis();
                    a.y = ((float)TouchImageView.a(a, pointf, a.n) / (float)(l2 - a.A)) * 0.9F;
                    a.A = l2;
                    TouchImageView.a(a, f2, f4);
                    a.x.set(f2, f4);
                    a.n.set(pointf.x, pointf.y);
                    continue; /* Loop/switch isn't completed */
                }
                if (TouchImageView.b(a) != null || a.c != 2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                float f5 = TouchImageView.a(a, view);
                if (motionevent.getPointerCount() < 2 || 10F > Math.abs(a.w - f5) || Math.abs(a.w - f5) > 50F)
                {
                    continue; /* Loop/switch isn't completed */
                }
                f3 = f5 / a.w;
                a.w = f5;
                f5 = a.t;
                motionevent = a;
                motionevent.t = ((TouchImageView) (motionevent)).t * f3;
                if (a.t > a.v)
                {
                    a.t = a.v;
                    f3 = a.v / f5;
                } else
                if (a.t < a.u)
                {
                    a.t = a.u;
                    f3 = a.u / f5;
                }
                TouchImageView.e(a);
                if (a.h * a.t > a.l && a.i * a.t > a.m)
                {
                    break; /* Loop/switch isn't completed */
                }
                a.a.postScale(f3, f3, a.l / 2.0F, a.m / 2.0F);
                if (f3 < 1.0F)
                {
                    TouchImageView.c(a);
                    if (f3 < 1.0F)
                    {
                        TouchImageView.f(a);
                    }
                }
_L8:
                TouchImageView.g(a);
                if (true) goto _L1; else goto _L7
_L7:
                view = TouchImageView.b(a, view);
                a.a.postScale(f3, f3, ((PointF) (view)).x, ((PointF) (view)).y);
                TouchImageView.c(a);
                if (f3 < 1.0F)
                {
                    if (a.r < -a.f)
                    {
                        a.a.postTranslate(-(a.r + a.f), 0.0F);
                    } else
                    if (a.r > 0.0F)
                    {
                        a.a.postTranslate(-a.r, 0.0F);
                    }
                    if (a.s < -a.g)
                    {
                        a.a.postTranslate(0.0F, -(a.s + a.g));
                    } else
                    if (a.s > 0.0F)
                    {
                        a.a.postTranslate(0.0F, -a.s);
                    }
                }
                  goto _L8
                if (true) goto _L1; else goto _L9
_L9:
            }

            
            {
                a = TouchImageView.this;
                super();
            }
        });
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

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        j = bitmap.getWidth();
        k = bitmap.getHeight();
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        I = onclicklistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        J = ontouchlistener;
    }

    public void setZoomToOriginalSize(boolean flag)
    {
        M = flag;
    }
}
