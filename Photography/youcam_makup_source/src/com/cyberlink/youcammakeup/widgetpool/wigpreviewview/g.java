// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.aa;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            c, h, WigView

public class g
{

    public static final int a;
    public static final int b;
    public static final int c = Globals.d().getResources().getDimensionPixelSize(0x7f0802ca);
    public static final int d = Globals.d().getResources().getDimensionPixelSize(0x7f0802c9);
    private Matrix A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private double O;
    private float P;
    private android.view.MotionEvent.PointerCoords Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private double V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private Bitmap o;
    private Bitmap p;
    private Paint q;
    private Paint r;
    private Paint s;
    private Paint t;
    private Paint u;
    private RectF v;
    private RectF w;
    private RectF x;
    private RectF y;
    private Matrix z;

    public g(Bitmap bitmap, Bitmap bitmap1)
    {
        n = false;
        v = new RectF();
        w = new RectF();
        x = new RectF();
        y = new RectF();
        z = new Matrix();
        A = new Matrix();
        B = false;
        C = false;
        D = false;
        E = false;
        F = 0.0F;
        G = 0.0F;
        H = 0.0F;
        I = 0.0F;
        J = 0.0F;
        K = 0.0F;
        L = 0.0F;
        M = 0.0F;
        N = 0.0F;
        O = 0.0D;
        P = 0.0F;
        Q = new android.view.MotionEvent.PointerCoords();
        R = 0.0F;
        S = 0.0F;
        T = 0.0F;
        U = 0.0F;
        V = 0.0D;
        W = 0.0F;
        X = 0.0F;
        Y = 1.0F;
        Z = 1.0F;
        o = bitmap;
        p = bitmap1;
        q = a(android.graphics.Paint.Style.STROKE);
        q.setStrokeWidth(4F);
        q.setColor(-1);
        q.setShadowLayer(1.0F, 2.0F, 2.0F, 0xff000000);
        r = aa.a();
        r.setStyle(android.graphics.Paint.Style.STROKE);
        r.setStrokeWidth(2.0F);
        r.setColor(-1);
        bitmap = new DashPathEffect(new float[] {
            5F, 5F
        }, 1.0F);
        r.setPathEffect(bitmap);
        s = aa.a();
        t = aa.a();
        t.setStrokeWidth(2.0F);
        t.setColor(-1);
        u = aa.a();
        u.setColor(0xff888888);
        u.setAlpha(128);
        a();
        a(0.0F, 0.0F);
        b(320F, 320F);
        c(320F, 320F);
        a(0.0F);
        b(0.0F);
        d();
    }

    public static float a(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        double d1 = f3 - f5;
        double d2 = f4 - f6;
        d1 = d1 * d1 + d2 * d2;
        d2 = f1 - f5;
        double d3 = f2 - f6;
        d2 = d2 * d2 + d3 * d3;
        d3 = f3 - f1;
        double d4 = f4 - f2;
        d1 = Math.toDegrees(Math.acos(((d1 + d2) - (d3 * d3 + d4 * d4)) / (2D * Math.sqrt(d1 * d2))));
        if ((f6 - f2) * (f3 - f1) - (f4 - f2) * (f5 - f1) > 0.0F)
        {
            return (float)d1;
        } else
        {
            return (float)(-d1);
        }
    }

    public static Paint a(android.graphics.Paint.Style style)
    {
        Paint paint = aa.a();
        paint.setStyle(style);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        return paint;
    }

    private void a(float f1, float f2, boolean flag)
    {
        g = f1;
        h = f2;
        b(flag);
    }

    private void b(Canvas canvas)
    {
        float f1 = v.left + v.width() / 2.0F;
        float f2 = v.top + v.height() / 2.0F;
        float f3 = Math.min(v.width(), v.height()) / 14F;
        canvas.drawLine(f1 - f3, f2, f1 + f3, f2, t);
        canvas.drawLine(f1, f2 - f3, f1, f2 + f3, t);
    }

    private void b(boolean flag)
    {
        com.pf.common.utility.m.b("WigRenderer", (new StringBuilder()).append("updateCache positionX =").append(e).append(" ,postionY = ").append(f).append(", bubbleScale = ").append(m).append(" , bubbleWidth = ").append(g).toString());
        float f2 = e - (g * (m - 1.0F)) / 2.0F;
        float f3 = f - (g * (m - 1.0F)) / 2.0F;
        float f4 = g * m + f2;
        float f1 = h * m + f3;
        v.set(f2, f3, f4, f1);
        w.set(f2 + 4F, f3 + 4F, f4 - 4F, f1 - 4F);
        f3 = f4 - (float)b;
        f4 = f1 - (float)b;
        float f5 = a;
        float f6 = a;
        x.set(f3, f4, f5 + f3, f6 + f4);
        f2 -= b;
        f1 -= b;
        f3 = a;
        f4 = a;
        y.set(f2, f1, f3 + f2, f4 + f1);
        f4 = (g * m) / 2.0F;
        f1 = (h * m) / 2.0F;
        f5 = e;
        f6 = m;
        f2 = f;
        f3 = m;
        f4 += f5 * f6;
        f1 += f2 * f3;
        z.reset();
        z.postTranslate(-f4, -f1);
        z.postRotate(k);
        z.postTranslate(f4, f1);
        A.reset();
        A.postTranslate(-f4, -f1);
        A.postRotate(-k);
        A.postTranslate(f4, f1);
    }

    private static float d(float f1)
    {
        float f2;
        do
        {
            f2 = f1;
            if (f1 >= 0.0F)
            {
                break;
            }
            f1 += 360F;
        } while (true);
        for (; f2 >= 360F; f2 -= 360F) { }
        return f2;
    }

    private void d()
    {
    }

    private void e()
    {
        B = false;
        C = false;
        D = false;
        E = false;
        F = 0.0F;
        G = 0.0F;
        H = 0.0F;
        I = 0.0F;
        J = 0.0F;
        K = 0.0F;
        L = 0.0F;
        M = 0.0F;
        N = 0.0F;
        O = 0.0D;
        P = 0.0F;
        W = 0.0F;
        X = 0.0F;
        Y = 1.0F;
    }

    private void f()
    {
        D = false;
        R = 0.0F;
        S = 0.0F;
        T = 0.0F;
        U = 0.0F;
        V = 0.0D;
    }

    private void g(float f1, float f2)
    {
        F = f1;
        G = f2;
        K = e;
        L = f;
        J = k;
        M = g;
        N = h;
        float f3 = g * m;
        float f4 = h * m;
        float f5 = f3 / 2.0F;
        float f6 = f4 / 2.0F;
        float f7 = e * m;
        float f8 = f * m;
        H = f7 + f5;
        I = f8 + f6;
        O = Math.sqrt(f5 * f5 + f6 * f6);
        W = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().i();
        X = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().j();
        Y = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().k();
        PointF pointf = new PointF(f3 + f7, f4 + f8);
        com.cyberlink.youcammakeup.widgetpool.wigpreviewview.h.a(A, pointf);
        P = a(pointf.x, pointf.y, f1, f2, H, I);
    }

    protected void a()
    {
        m = 1.0F;
        b(true);
    }

    public void a(float f1)
    {
        k = d(f1);
        b(false);
    }

    public void a(float f1, float f2)
    {
        e = f1;
        f = f2;
        b(false);
    }

    public void a(Canvas canvas)
    {
        canvas.save();
        canvas.concat(z);
        if (n)
        {
            com.pf.common.utility.m.b("WigRenderer", (new StringBuilder()).append("render highlightbox left = ").append(v.left).toString());
            canvas.drawRect(v, q);
            canvas.drawOval(w, r);
            b(canvas);
            if (aa.b(o))
            {
                canvas.drawBitmap(o, null, x, s);
            }
            if (aa.b(p))
            {
                canvas.drawBitmap(p, null, y, s);
            }
        }
        canvas.restore();
    }

    public void a(WigView wigview, MotionEvent motionevent, float f1, float f2, RectF rectf)
    {
        float f6;
        float f7;
        int i1;
        i1 = motionevent.getActionMasked();
        f6 = motionevent.getX() - f1;
        f7 = motionevent.getY() - f2;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        if (!e(f6, f7)) goto _L4; else goto _L3
_L3:
        C = true;
_L10:
        g(f6, f7);
_L6:
        return;
_L4:
        if (d(f6, f7))
        {
            B = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 != 5 || motionevent.getPointerCount() != 2 || C)
        {
            break; /* Loop/switch isn't completed */
        }
        g(f6, f7);
        if (rectf.contains(H, I))
        {
            D = true;
            B = false;
            motionevent.getPointerCoords(0, Q);
            R = Q.x;
            S = Q.y;
            motionevent.getPointerCoords(1, Q);
            T = Q.x;
            U = Q.y;
            double d1 = T - R;
            double d3 = U - S;
            V = Math.sqrt(d1 * d1 + d3 * d3);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (i1 == 6 && motionevent.getPointerCount() <= 2)
        {
            f();
            return;
        }
        if (i1 != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (D || C)
        {
            f1 = K;
            f1 = L;
            f1 = M;
            f1 = N;
            double d2;
            double d4;
            float f8;
            if (D)
            {
                motionevent.getPointerCoords(0, Q);
                f1 = Q.x;
                f2 = Q.y;
                motionevent.getPointerCoords(1, Q);
                float f3 = Q.x;
                f8 = R;
                float f9 = Q.y;
                f1 = a((f8 - f1) + f3, (S - f2) + f9, T, U, R, S);
                com.pf.common.utility.m.b("diffAngle", String.valueOf(f1));
                f8 = d(J - f1);
            } else
            {
                f1 = a(F, G, f6, f7, H, I);
                com.pf.common.utility.m.b("diffAngle", String.valueOf(f1));
                f8 = d(f1 + J + P);
            }
            d2 = H - f6;
            d4 = I - f7;
            d2 = Math.sqrt(d2 * d2 + d4 * d4) / O;
            if (D)
            {
                motionevent.getPointerCoords(0, Q);
                f1 = Q.x;
                f2 = Q.y;
                motionevent.getPointerCoords(1, Q);
                float f4 = Q.x;
                f6 = Q.y;
                d2 = f4 - f1;
                double d5 = f6 - f2;
                d2 = Math.sqrt(d5 * d5 + d2 * d2) / V;
            }
            f2 = (float)((double)M * d2);
            f1 = (float)(d2 * (double)N);
            if (f2 < (float)c || f1 < (float)d)
            {
                float f5;
                float f10;
                if (f2 < (float)c && f1 >= (float)d)
                {
                    f6 = c;
                    f5 = (f6 / i) * j;
                } else
                {
                    f6 = f2;
                    f5 = f1;
                }
                f1 = f5;
                f2 = f6;
                if (f5 < (float)d)
                {
                    f1 = f5;
                    f2 = f6;
                    if (f6 >= (float)c)
                    {
                        f1 = d;
                        f2 = (f1 / j) * i;
                    }
                }
            }
            f5 = (f2 - M) / 2.0F;
            f6 = (f1 - N) / 2.0F;
            f7 = K;
            f10 = L;
            a(f8);
            com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().b(d(f8 - l));
            com.pf.common.utility.m.b("WigRenderer", (new StringBuilder()).append("WigRenderer onTouch degree = ").append(f8).toString());
            if (f2 >= (float)c || f1 >= (float)d)
            {
                E = true;
                a(f7 - f5, f10 - f6);
                a(f2, f1, false);
                f5 = (f2 / M + f1 / N) / 2.0F;
                f6 = Y;
                com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().a(f5 * f6);
            }
            com.pf.common.utility.m.b("WigRenderer", (new StringBuilder()).append("WigRender onTouch width = ").append(f2).append(" , height = ").append(f1).toString());
            wigview.invalidate();
            return;
        }
        if (!B)
        {
            continue; /* Loop/switch isn't completed */
        }
        f5 = f6;
        f1 = f7;
        if (!rectf.contains(f6, f7))
        {
            if (!rectf.contains(F, G))
            {
                break; /* Loop/switch isn't completed */
            }
            if (f6 < rectf.left)
            {
                f2 = rectf.left;
            } else
            {
                f2 = f6;
            }
            f1 = f2;
            if (f2 > rectf.right)
            {
                f1 = rectf.right;
            }
            if (f7 < rectf.top)
            {
                f2 = rectf.top;
            } else
            {
                f2 = f7;
            }
            if (f2 > rectf.bottom)
            {
                f2 = rectf.bottom;
                f5 = f1;
                f1 = f2;
            } else
            {
                f5 = f1;
                f1 = f2;
            }
        }
        f2 = f5 - F;
        f1 -= G;
        f5 = K + f2;
        f6 = L + f1;
        if (f2 != 0.0F || f1 != 0.0F)
        {
            com.pf.common.utility.m.b("WigRenderer", (new StringBuilder()).append("WigRender onTouch isStartTranslate newX = ").append(f5).append(", newY = ").append(f6).toString());
            com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().b(f2 / Z + W, f1 / Z + X);
            a(f5, f6);
            wigview.invalidate();
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
        if (F < rectf.left)
        {
            f1 = f6;
            if (f6 < F)
            {
                f1 = F;
            }
        } else
        {
            f1 = f6;
            if (f6 < rectf.left)
            {
                f1 = rectf.left;
            }
        }
        if (F > rectf.right)
        {
            f2 = f1;
            if (f1 > F)
            {
                f2 = F;
            }
        } else
        {
            f2 = f1;
            if (f1 > rectf.right)
            {
                f2 = rectf.right;
            }
        }
        if (G < rectf.top)
        {
            f6 = f7;
            if (f7 < G)
            {
                f6 = G;
            }
        } else
        {
            f6 = f7;
            if (f7 < rectf.top)
            {
                f6 = rectf.top;
            }
        }
        if (G > rectf.bottom)
        {
            f5 = f2;
            f1 = f6;
            if (f6 > G)
            {
                f1 = G;
                f5 = f2;
            }
        } else
        {
            f5 = f2;
            f1 = f6;
            if (f6 > rectf.bottom)
            {
                f1 = rectf.bottom;
                f5 = f2;
            }
        }
        break MISSING_BLOCK_LABEL_1068;
        if (i1 != 1) goto _L6; else goto _L8
_L8:
        if (E)
        {
            b(true);
        }
        e();
        f();
        wigview.invalidate();
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a(boolean flag)
    {
        n = flag;
    }

    public void b(float f1)
    {
        l = d(f1);
    }

    public void b(float f1, float f2)
    {
        a(f1, f2, true);
    }

    public boolean b()
    {
        return n;
    }

    public void c()
    {
        o = null;
    }

    public void c(float f1)
    {
        Z = f1;
    }

    public void c(float f1, float f2)
    {
        i = f1;
        j = f2;
    }

    public boolean d(float f1, float f2)
    {
        float af[] = new float[2];
        af[0] = f1;
        af[1] = f2;
        A.mapPoints(af);
        return v.contains(af[0], af[1]);
    }

    public boolean e(float f1, float f2)
    {
        float af[] = new float[2];
        af[0] = f1;
        af[1] = f2;
        A.mapPoints(af);
        return x.contains(af[0], af[1]);
    }

    public boolean f(float f1, float f2)
    {
        float af[] = new float[2];
        af[0] = f1;
        af[1] = f2;
        A.mapPoints(af);
        return y.contains(af[0], af[1]);
    }

    static 
    {
        b = Globals.d().getResources().getDimensionPixelSize(0x7f0802c7);
        a = b * 2;
    }
}
