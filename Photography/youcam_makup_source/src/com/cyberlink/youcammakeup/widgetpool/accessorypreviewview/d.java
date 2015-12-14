// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview:
//            AccessoryDrawingCtrl, e

public class d
{

    public static final int a;
    public static final int b;
    public static final int c = Globals.d().getResources().getDimensionPixelSize(0x7f08028b);
    public static final int d = Globals.d().getResources().getDimensionPixelSize(0x7f08028a);
    public static final int e = Globals.d().getResources().getDimensionPixelSize(0x7f080288);
    public static final int f = Globals.d().getResources().getDimensionPixelSize(0x7f080287);
    public static final int g = Globals.d().getResources().getDimensionPixelSize(0x7f080285);
    private static Matrix h = new Matrix();
    private static Matrix i = new Matrix();
    private static Matrix j = new Matrix();
    private static Paint k = new Paint(3);
    private Bitmap A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;
    private Paint F;
    private Paint G;
    private RectF H;
    private RectF I;
    private RectF J;
    private RectF K;
    private RectF L;
    private RectF M;
    private RectF N;
    private Matrix O;
    private Matrix P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private float U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private float aa;
    private float ab;
    private float ac;
    private double ad;
    private float ae;
    private android.view.MotionEvent.PointerCoords af;
    private float ag;
    private float ah;
    private float ai;
    private float aj;
    private double ak;
    private float al;
    private float am;
    private float an;
    private float ao;
    private AccessoryDrawingCtrl.AccessoryType l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private boolean x;
    private Bitmap y;
    private Bitmap z;

    public d(Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        x = false;
        H = new RectF();
        I = new RectF();
        J = new RectF();
        K = new RectF();
        L = new RectF();
        M = new RectF();
        N = new RectF();
        O = new Matrix();
        P = new Matrix();
        Q = false;
        R = false;
        S = false;
        T = false;
        U = 0.0F;
        V = 0.0F;
        W = 0.0F;
        X = 0.0F;
        Y = 0.0F;
        Z = 0.0F;
        aa = 0.0F;
        ab = 0.0F;
        ac = 0.0F;
        ad = 0.0D;
        ae = 0.0F;
        af = new android.view.MotionEvent.PointerCoords();
        ag = 0.0F;
        ah = 0.0F;
        ai = 0.0F;
        aj = 0.0F;
        ak = 0.0D;
        al = 0.0F;
        am = 0.0F;
        an = 1.0F;
        ao = 1.0F;
        y = bitmap;
        z = bitmap1;
        A = bitmap2;
        B = com.cyberlink.youcammakeup.utility.aa.a();
        B.setStyle(android.graphics.Paint.Style.STROKE);
        B.setStrokeWidth(4F);
        B.setColor(-1);
        C = com.cyberlink.youcammakeup.utility.aa.a();
        C.setStyle(android.graphics.Paint.Style.STROKE);
        C.setStrokeWidth(1.0F);
        C.setColor(0xff000000);
        D = com.cyberlink.youcammakeup.utility.aa.a();
        D.setStyle(android.graphics.Paint.Style.STROKE);
        D.setStrokeWidth(2.0F);
        D.setColor(-1);
        bitmap = new DashPathEffect(new float[] {
            5F, 5F
        }, 1.0F);
        D.setPathEffect(bitmap);
        E = com.cyberlink.youcammakeup.utility.aa.a();
        F = com.cyberlink.youcammakeup.utility.aa.a();
        F.setStrokeWidth(2.0F);
        F.setColor(-1);
        G = com.cyberlink.youcammakeup.utility.aa.a();
        G.setColor(0xff888888);
        G.setAlpha(128);
        l = accessorytype;
        float f1;
        if (l != AccessoryDrawingCtrl.AccessoryType.d && l != AccessoryDrawingCtrl.AccessoryType.e)
        {
            f1 = c + g * 2;
        } else
        {
            f1 = e + g * 2;
        }
        v = f1;
        if (l != AccessoryDrawingCtrl.AccessoryType.d && l != AccessoryDrawingCtrl.AccessoryType.e)
        {
            f1 = d + g * 2;
        } else
        {
            f1 = f + g * 2;
        }
        w = f1;
        a();
        a(0.0F, 0.0F);
        b(320F, 320F);
        c(320F, 320F);
        a(0.0F);
        b(0.0F);
        e();
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

    private void a(float f1, float f2, boolean flag)
    {
        o = f1;
        p = f2;
        b(flag);
    }

    public static void a(Bitmap bitmap, Bitmap bitmap1, b b1)
    {
        while (!com.cyberlink.youcammakeup.utility.aa.b(bitmap) || !com.cyberlink.youcammakeup.utility.aa.b(bitmap1) || b1 == null || b1.j == null) 
        {
            return;
        }
        bitmap = new Canvas(bitmap);
        bitmap.save();
        h.reset();
        h.postRotate((float)Math.toDegrees(b1.j.c()));
        bitmap.concat(h);
        bitmap.save();
        j.reset();
        j.postScale(b1.j.b(), b1.j.b());
        bitmap.concat(j);
        bitmap.save();
        i.reset();
        i.postTranslate(b1.j.d(), b1.j.e());
        bitmap.concat(i);
        b1 = new Matrix();
        b1.setRectToRect(new RectF(0.0F, 0.0F, bitmap1.getWidth(), bitmap1.getHeight()), new RectF(0.0F, 0.0F, bitmap1.getWidth(), bitmap1.getHeight()), android.graphics.Matrix.ScaleToFit.CENTER);
        bitmap.drawBitmap(bitmap1, b1, k);
        bitmap.restore();
        bitmap.restore();
        bitmap.restore();
    }

    private void b(boolean flag)
    {
        com.pf.common.utility.m.b("AccessoryRenderer", (new StringBuilder()).append("updateCache positionX =").append(m).append(" ,postionY = ").append(n).append(", bubbleScale = ").append(u).append(" , bubbleWidth = ").append(o).toString());
        float f2 = m - (o * (u - 1.0F)) / 2.0F;
        float f1 = n - (o * (u - 1.0F)) / 2.0F;
        float f4 = o * u + f2;
        float f3 = p * u + f1;
        H.set(f2, f1, f4, f3);
        I.set(f2 + 3F, f1 + 3F, f4 - 3F, f3 - 3F);
        J.set(f2 - 3F, f1 - 3F, f4 + 3F, f3 + 3F);
        K.set(f2 + 4F, f1 + 4F, f4 - 4F, f3 - 4F);
        f4 -= b;
        float f5 = f3 - (float)b;
        float f6 = a;
        float f7 = a;
        L.set(f4, f5, f6 + f4, f7 + f5);
        f4 = f2 - (float)b;
        f3 -= b;
        f5 = a;
        f6 = a;
        M.set(f4, f3, f5 + f4, f6 + f3);
        f2 -= b;
        f1 -= b;
        f3 = a;
        f4 = a;
        N.set(f2, f1, f3 + f2, f4 + f1);
        f4 = (o * u) / 2.0F;
        f1 = (p * u) / 2.0F;
        f5 = m;
        f6 = u;
        f2 = n;
        f3 = u;
        f4 += f5 * f6;
        f1 += f2 * f3;
        O.reset();
        O.postTranslate(-f4, -f1);
        O.postRotate(s);
        O.postTranslate(f4, f1);
        P.reset();
        P.postTranslate(-f4, -f1);
        P.postRotate(-s);
        P.postTranslate(f4, f1);
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

    private void e()
    {
    }

    private void f()
    {
        Q = false;
        R = false;
        S = false;
        T = false;
        U = 0.0F;
        V = 0.0F;
        W = 0.0F;
        X = 0.0F;
        Y = 0.0F;
        Z = 0.0F;
        aa = 0.0F;
        ab = 0.0F;
        ac = 0.0F;
        ad = 0.0D;
        ae = 0.0F;
        al = 0.0F;
        am = 0.0F;
        an = 1.0F;
    }

    private void g()
    {
        S = false;
        ag = 0.0F;
        ah = 0.0F;
        ai = 0.0F;
        aj = 0.0F;
        ak = 0.0D;
    }

    private void h(float f1, float f2)
    {
        U = f1;
        V = f2;
        Z = m;
        aa = n;
        Y = s;
        ab = o;
        ac = p;
        float f3 = o * u;
        float f4 = p * u;
        float f5 = f3 / 2.0F;
        float f6 = f4 / 2.0F;
        float f7 = m * u;
        float f8 = n * u;
        W = f7 + f5;
        X = f8 + f6;
        ad = Math.sqrt(f5 * f5 + f6 * f6);
        al = AccessoryDrawingCtrl.a(l).h();
        am = AccessoryDrawingCtrl.a(l).i();
        an = AccessoryDrawingCtrl.a(l).j();
        PointF pointf = new PointF(f3 + f7, f4 + f8);
        com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.e.a(P, pointf);
        ae = a(pointf.x, pointf.y, f1, f2, W, X);
    }

    protected void a()
    {
        u = 1.0F;
        b(true);
    }

    public void a(float f1)
    {
        s = d(f1);
        b(false);
    }

    public void a(float f1, float f2)
    {
        m = f1;
        n = f2;
        b(false);
    }

    public void a(Canvas canvas)
    {
        canvas.save();
        canvas.concat(O);
        if (x)
        {
            com.pf.common.utility.m.b("AccessoryRenderer", (new StringBuilder()).append("render highlightbox left = ").append(H.left).toString());
            canvas.drawRect(I, C);
            canvas.drawRect(J, C);
            canvas.drawRect(H, B);
            if (com.cyberlink.youcammakeup.utility.aa.b(y))
            {
                canvas.drawBitmap(y, null, L, E);
            }
            if (com.cyberlink.youcammakeup.utility.aa.b(z))
            {
                canvas.drawBitmap(z, null, M, E);
            }
            if (com.cyberlink.youcammakeup.utility.aa.b(A))
            {
                canvas.drawBitmap(A, null, N, E);
            }
        }
        canvas.restore();
    }

    public void a(View view, MotionEvent motionevent, float f1, float f2, RectF rectf)
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
        R = true;
_L14:
        h(f6, f7);
_L11:
        return;
_L4:
        if (d(f6, f7))
        {
            Q = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 == 5 && motionevent.getPointerCount() == 2 && !R)
        {
            h(f6, f7);
            S = true;
            Q = false;
            motionevent.getPointerCoords(0, af);
            ag = af.x;
            ah = af.y;
            motionevent.getPointerCoords(1, af);
            ai = af.x;
            aj = af.y;
            double d1 = ai - ag;
            double d3 = aj - ah;
            ak = Math.sqrt(d1 * d1 + d3 * d3);
            return;
        }
        if (i1 == 6 && motionevent.getPointerCount() <= 2)
        {
            g();
            return;
        }
        if (i1 != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!S && !R) goto _L6; else goto _L5
_L5:
        f1 = Z;
        f1 = aa;
        f1 = ab;
        f1 = ac;
        if (!S || motionevent.getPointerCount() < 2) goto _L8; else goto _L7
_L7:
        float f8;
        motionevent.getPointerCoords(0, af);
        f1 = af.x;
        f2 = af.y;
        motionevent.getPointerCoords(1, af);
        float f3 = af.x;
        f8 = ag;
        float f9 = af.y;
        f2 = a((f8 - f1) + f3, (ah - f2) + f9, ai, aj, ag, ah);
        com.pf.common.utility.m.b("diffAngle", String.valueOf(f2));
        f1 = d(Y - f2);
        f8 = f1;
        if (f2 != 0.0F)
        {
            MotionControlHelper.e().g(true);
            f8 = f1;
        }
_L9:
        double d2;
label0:
        {
            d2 = W - f6;
            double d4 = X - f7;
            d4 = Math.sqrt(d2 * d2 + d4 * d4) / ad;
            d2 = d4;
            if (!S)
            {
                break label0;
            }
            d2 = d4;
            if (motionevent.getPointerCount() < 2)
            {
                break label0;
            }
            motionevent.getPointerCoords(0, af);
            f1 = af.x;
            f2 = af.y;
            motionevent.getPointerCoords(1, af);
            float f4 = af.x;
            f6 = af.y;
            d2 = f4 - f1;
            d4 = f6 - f2;
            d4 = Math.sqrt(d2 * d2 + d4 * d4) / ak;
            if (f1 - ag == 0.0F && f2 - ah == 0.0F && f4 - ai == 0.0F)
            {
                d2 = d4;
                if (f6 - aj == 0.0F)
                {
                    break label0;
                }
            }
            MotionControlHelper.e().g(true);
            d2 = d4;
        }
        f2 = (float)((double)ab * d2);
        f1 = (float)(d2 * (double)ac);
        if (f2 < v || f1 < w)
        {
            float f5;
            if (f2 < v && f1 >= w)
            {
                f6 = v;
                f5 = (f6 / q) * r;
            } else
            {
                f6 = f2;
                f5 = f1;
            }
            f1 = f5;
            f2 = f6;
            if (f5 < w)
            {
                f1 = f5;
                f2 = f6;
                if (f6 >= v)
                {
                    f1 = w;
                    f2 = (f1 / r) * q;
                }
            }
        }
        f5 = (f2 - ab) / 2.0F;
        f5 = (f1 - ac) / 2.0F;
        f5 = Z;
        f5 = aa;
        AccessoryDrawingCtrl.a(l).b(d(f8 - t));
        com.pf.common.utility.m.b("AccessoryRenderer", (new StringBuilder()).append("AccessoryRenderer onTouch degree = ").append(f8).toString());
        if (f2 >= v || f1 >= w)
        {
            T = true;
            f5 = (f2 / ab + f1 / ac) / 2.0F;
            f6 = an;
            AccessoryDrawingCtrl.a(l).a(f5 * f6);
        }
        com.pf.common.utility.m.b("AccessoryRenderer", (new StringBuilder()).append("AccessoryRender onTouch width = ").append(f2).append(" , height = ").append(f1).toString());
        view.invalidate();
        return;
_L8:
        f2 = a(U, V, f6, f7, W, X);
        com.pf.common.utility.m.b("diffAngle", String.valueOf(f2));
        f1 = d(Y + f2 + ae);
        f8 = f1;
        if (f2 != 0.0F)
        {
            MotionControlHelper.e().g(true);
            f8 = f1;
        }
        if (true) goto _L9; else goto _L6
_L6:
        if (!Q)
        {
            continue; /* Loop/switch isn't completed */
        }
        f5 = f6;
        f1 = f7;
        if (!rectf.contains(f6, f7))
        {
            if (!rectf.contains(U, V))
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
        f2 = f5 - U;
        f1 -= V;
        f5 = Z + f2;
        f6 = aa + f1;
        if (f2 != 0.0F || f1 != 0.0F)
        {
            com.pf.common.utility.m.b("AccessoryRenderer", (new StringBuilder()).append("AccessoryRender onTouch isStartTranslate newX = ").append(f5).append(", newY = ").append(f6).toString());
            AccessoryDrawingCtrl.a(l).b(f2 / ao + al, f1 / ao + am);
            a(f5, f6);
            view.invalidate();
            if (f2 != 0.0F || f1 != 0.0F)
            {
                MotionControlHelper.e().g(true);
                return;
            }
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (U < rectf.left)
        {
            f1 = f6;
            if (f6 < U)
            {
                f1 = U;
            }
        } else
        {
            f1 = f6;
            if (f6 < rectf.left)
            {
                f1 = rectf.left;
            }
        }
        if (U > rectf.right)
        {
            f2 = f1;
            if (f1 > U)
            {
                f2 = U;
            }
        } else
        {
            f2 = f1;
            if (f1 > rectf.right)
            {
                f2 = rectf.right;
            }
        }
        if (V < rectf.top)
        {
            f6 = f7;
            if (f7 < V)
            {
                f6 = V;
            }
        } else
        {
            f6 = f7;
            if (f7 < rectf.top)
            {
                f6 = rectf.top;
            }
        }
        if (V > rectf.bottom)
        {
            f5 = f2;
            f1 = f6;
            if (f6 > V)
            {
                f1 = V;
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
        break MISSING_BLOCK_LABEL_1162;
        if (i1 != 1) goto _L11; else goto _L12
_L12:
        if (T)
        {
            b(true);
        }
        f();
        g();
        view.invalidate();
        return;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void a(boolean flag)
    {
        x = flag;
    }

    public void b(float f1)
    {
        t = d(f1);
    }

    public void b(float f1, float f2)
    {
        a(f1, f2, true);
    }

    public boolean b()
    {
        return x;
    }

    public void c()
    {
        y = null;
    }

    public void c(float f1)
    {
        ao = f1;
    }

    public void c(float f1, float f2)
    {
        q = f1;
        r = f2;
    }

    public AccessoryDrawingCtrl.AccessoryType d()
    {
        return l;
    }

    public boolean d(float f1, float f2)
    {
        float af1[] = new float[2];
        af1[0] = f1;
        af1[1] = f2;
        P.mapPoints(af1);
        return H.contains(af1[0], af1[1]);
    }

    public boolean e(float f1, float f2)
    {
        float af1[] = new float[2];
        af1[0] = f1;
        af1[1] = f2;
        P.mapPoints(af1);
        return L.contains(af1[0], af1[1]);
    }

    public boolean f(float f1, float f2)
    {
        if (z == null)
        {
            return false;
        } else
        {
            float af1[] = new float[2];
            af1[0] = f1;
            af1[1] = f2;
            P.mapPoints(af1);
            return M.contains(af1[0], af1[1]);
        }
    }

    public boolean g(float f1, float f2)
    {
        float af1[] = new float[2];
        af1[0] = f1;
        af1[1] = f2;
        P.mapPoints(af1);
        return N.contains(af1[0], af1[1]);
    }

    static 
    {
        b = Globals.d().getResources().getDimensionPixelSize(0x7f080286);
        a = b * 2;
    }
}
