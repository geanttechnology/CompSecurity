// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package w.panzoomview:
//            BaseImageView, b, i, l, 
//            k, n, ViewSetting, d, 
//            c, m, j

public class PanZoomView extends BaseImageView
{

    private ScaleGestureDetector g;
    private l h;
    private GestureDetector i;
    private k j;
    private ValueAnimator k;
    private boolean l;
    private boolean m;
    private float n;
    private ValueAnimator o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Boolean s;
    private Boolean t;
    private volatile ViewerMode u;
    private int v;
    private boolean w;
    private m x;
    private MotionEvent y;
    private boolean z;

    public PanZoomView(Context context)
    {
        super(context);
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = false;
        m = false;
        n = 0.0F;
        o = null;
        p = false;
        q = false;
        r = false;
        s = Boolean.valueOf(false);
        t = Boolean.valueOf(false);
        u = ViewerMode.a;
        v = 0;
        if (!isInEditMode())
        {
            a(context);
        }
    }

    public PanZoomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = false;
        m = false;
        n = 0.0F;
        o = null;
        p = false;
        q = false;
        r = false;
        s = Boolean.valueOf(false);
        t = Boolean.valueOf(false);
        u = ViewerMode.a;
        v = 0;
        if (!isInEditMode())
        {
            a(context);
        }
    }

    public PanZoomView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = false;
        m = false;
        n = 0.0F;
        o = null;
        p = false;
        q = false;
        r = false;
        s = Boolean.valueOf(false);
        t = Boolean.valueOf(false);
        u = ViewerMode.a;
        v = 0;
        if (!isInEditMode())
        {
            a(context);
        }
    }

    private float a(float f1)
    {
        if (f1 == 0.0F)
        {
            return 0.0F;
        }
        return f1 <= 0.0F ? 0.003F : -0.003F;
    }

    private float a(Matrix matrix)
    {
        float f1 = getWidth() / 2;
        float af[] = new float[9];
        matrix.getValues(af);
        float f2 = b.d;
        float f3 = af[0];
        float f4 = af[2];
        float f5 = af[0] * f4;
        f4 = f5 - -f1;
        f1 -= f5 + f2 * f3;
        if (f4 < 0.0F && f1 > 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return f1;
            } else
            {
                return (f1 - f4) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 < 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return -f4;
            } else
            {
                return -(f4 - f1) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 > 0.0F)
        {
            return (f1 - f4) / 2.0F;
        } else
        {
            return 0.0F;
        }
    }

    static float a(PanZoomView panzoomview, Matrix matrix)
    {
        return panzoomview.a(matrix);
    }

    private long a(float f1, float f2)
    {
        if (f1 == 0.0F)
        {
            return 0L;
        } else
        {
            return (long)(-f2 / 1000F / f1);
        }
    }

    static ValueAnimator a(PanZoomView panzoomview, ValueAnimator valueanimator)
    {
        panzoomview.o = valueanimator;
        return valueanimator;
    }

    private MotionEvent a(MotionEvent motionevent)
    {
        long l2 = motionevent.getDownTime();
        long l3 = motionevent.getEventTime();
        int k1 = motionevent.getAction();
        int l1 = motionevent.getPointerCount();
        android.view.MotionEvent.PointerProperties apointerproperties[] = new android.view.MotionEvent.PointerProperties[l1];
        for (int i1 = 0; i1 < apointerproperties.length; i1++)
        {
            android.view.MotionEvent.PointerProperties pointerproperties = new android.view.MotionEvent.PointerProperties();
            motionevent.getPointerProperties(i1, pointerproperties);
            apointerproperties[i1] = pointerproperties;
        }

        float f1 = b.i;
        android.view.MotionEvent.PointerCoords apointercoords[] = new android.view.MotionEvent.PointerCoords[l1];
        for (int j1 = 0; j1 < apointercoords.length; j1++)
        {
            android.view.MotionEvent.PointerCoords pointercoords = new android.view.MotionEvent.PointerCoords();
            motionevent.getPointerCoords(j1, pointercoords);
            pointercoords.x = pointercoords.x / f1;
            pointercoords.y = pointercoords.y / f1;
            apointercoords[j1] = pointercoords;
        }

        MotionEvent motionevent1 = MotionEvent.obtain(l2, l3, k1, l1, apointerproperties, apointercoords, motionevent.getMetaState(), motionevent.getButtonState(), motionevent.getXPrecision(), motionevent.getYPrecision(), motionevent.getDeviceId(), motionevent.getEdgeFlags(), motionevent.getSource(), motionevent.getFlags());
        motionevent = a(motionevent.getX(), motionevent.getY(), false);
        motionevent1.setLocation(((i) (motionevent)).a * (float)b.a, ((i) (motionevent)).b * (float)b.b);
        return motionevent1;
    }

    static Boolean a(PanZoomView panzoomview)
    {
        return panzoomview.t;
    }

    private ViewerMode a(PointF pointf, float f1)
    {
        return ViewerMode.b;
    }

    static ViewerMode a(PanZoomView panzoomview, ViewerMode viewermode)
    {
        panzoomview.u = viewermode;
        return viewermode;
    }

    private void a(Context context)
    {
        h = new l(this);
        g = new ScaleGestureDetector(context, h);
        j = new k(this);
        i = new GestureDetector(context, j);
    }

    private void a(PointF pointf, float f1, float f2)
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f3 = f1 / displaymetrics.density;
        float f4 = f2 / displaymetrics.density;
        if (Math.abs(f3) >= 500F || Math.abs(f4) >= 500F)
        {
            u = ViewerMode.a;
            if (!l)
            {
                r = true;
                if (b(pointf, f3, f4))
                {
                    d();
                    return;
                }
                int i1 = (int)(f1 / Math.abs(f1));
                int j1 = (int)(f2 / Math.abs(f2));
                long l1;
                long l2;
                long l3;
                if (Math.abs(f1) >= 4000F)
                {
                    f1 = i1 * 4000;
                }
                if (Math.abs(f2) >= 4000F)
                {
                    f2 = j1 * 4000;
                }
                f3 = a(f1);
                f4 = a(f2);
                l2 = a(f3, f1);
                l3 = a(f4, f2);
                if (l2 > l3)
                {
                    l1 = l2;
                } else
                {
                    l1 = l3;
                }
                u = ViewerMode.e;
                pointf = ValueAnimator.ofFloat(new float[] {
                    0.0F, 1.0F
                });
                pointf.setDuration(l1);
                pointf.setInterpolator(new LinearInterpolator());
                pointf.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(f1, f3, f2, f4, l2, l3) {

                    final float a;
                    final float b;
                    final float c;
                    final float d;
                    final long e;
                    final long f;
                    final PanZoomView g;
                    private float h;
                    private float i;

                    public void onAnimationUpdate(ValueAnimator valueanimator)
                    {
                        float f6 = 0.0F;
                        long l4 = valueanimator.getCurrentPlayTime();
                        float f5 = a / 1000F;
                        float f7 = l4;
                        f7 = (b * (float)l4 * (float)l4) / 2.0F + f5 * f7;
                        f5 = c / 1000F;
                        float f8 = l4;
                        f8 = (d * (float)l4 * (float)l4) / 2.0F + f5 * f8;
                        PanZoomView.a(g, ViewerMode.e);
                        valueanimator = new PointF((float)g.getWidth() / 2.0F, (float)g.getHeight() / 2.0F);
                        PointF pointf1 = new PointF(f7 - h, f8 - i);
                        if (l4 < e)
                        {
                            f5 = pointf1.x;
                        } else
                        {
                            f5 = 0.0F;
                        }
                        pointf1.x = f5;
                        f5 = f6;
                        if (l4 < f)
                        {
                            f5 = pointf1.y;
                        }
                        pointf1.y = f5;
                        PanZoomView.d(g, valueanimator, pointf1, 1.0F);
                        h = f7;
                        i = f8;
                    }

            
            {
                g = PanZoomView.this;
                a = f1;
                b = f2;
                c = f3;
                d = f4;
                e = l1;
                f = l2;
                super();
                h = 0.0F;
                i = 0.0F;
            }
                });
                pointf.addListener(new android.animation.Animator.AnimatorListener() {

                    final PanZoomView a;

                    public void onAnimationCancel(Animator animator)
                    {
                        PanZoomView.a(a, ViewerMode.a);
                        PanZoomView.a(a, null);
                        PanZoomView.a(a, false);
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        PanZoomView.a(a, ViewerMode.a);
                        PanZoomView.c(a, false);
                        PanZoomView.f(a);
                        PanZoomView.a(a, null);
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = PanZoomView.this;
                super();
            }
                });
                pointf.start();
                o = pointf;
                p = true;
                return;
            }
        }
    }

    static void a(PanZoomView panzoomview, PointF pointf, float f1, float f2)
    {
        panzoomview.a(pointf, f1, f2);
    }

    static void a(PanZoomView panzoomview, PointF pointf, PointF pointf1, float f1)
    {
        panzoomview.b(pointf, pointf1, f1);
    }

    static boolean a(PanZoomView panzoomview, boolean flag)
    {
        panzoomview.r = flag;
        return flag;
    }

    private float b(Matrix matrix)
    {
        float f1 = getHeight() / 2;
        float af[] = new float[9];
        matrix.getValues(af);
        float f2 = b.e;
        float f3 = af[0];
        float f4 = af[5];
        float f5 = af[0] * f4;
        f4 = f5 - -f1;
        f1 -= f5 + f2 * f3;
        if (f4 < 0.0F && f1 > 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return f1;
            } else
            {
                return (f1 - f4) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 < 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return -f4;
            } else
            {
                return -(f4 - f1) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 > 0.0F)
        {
            return (f1 - f4) / 2.0F;
        } else
        {
            return 0.0F;
        }
    }

    static float b(PanZoomView panzoomview, Matrix matrix)
    {
        return panzoomview.b(matrix);
    }

    static ValueAnimator b(PanZoomView panzoomview, ValueAnimator valueanimator)
    {
        panzoomview.k = valueanimator;
        return valueanimator;
    }

    static ViewerMode b(PanZoomView panzoomview)
    {
        return panzoomview.u;
    }

    private void b(PointF pointf, PointF pointf1, float f1)
    {
        if (u == ViewerMode.a)
        {
            u = a(pointf1, f1);
        }
        while (!b() || l) 
        {
            return;
        }
        d(pointf, pointf1, f1);
    }

    static void b(PanZoomView panzoomview, PointF pointf, PointF pointf1, float f1)
    {
        panzoomview.c(pointf, pointf1, f1);
    }

    private boolean b(PointF pointf, float f1, float f2)
    {
        pointf = new Matrix(b.j);
        float af[] = new float[9];
        pointf.getValues(af);
        float f3 = af[2] * af[0];
        float f4 = (float)b.d * af[0];
        float f5 = (float)getWidth() / 8F;
        if (!b.f && f4 > (float)getWidth())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        float f6;
        float f7;
        float f8;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (f1 > 2000F)
        {
            flag2 = true;
        } else
        if (f1 < -2000F)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        f2 = f4 / 2.0F + f3;
        if (f1 <= 0.0F || f2 <= f5) goto _L2; else goto _L1
_L1:
        flag3 = true;
_L4:
        return flag3;
_L2:
        flag3 = flag2;
        if (f1 >= 0.0F) goto _L4; else goto _L3
_L3:
        flag3 = flag2;
        if (f2 >= -f5) goto _L4; else goto _L5
_L5:
        return true;
        if (f1 < 4000F)
        {
            f2 = f1;
        } else
        {
            f2 = 4000F;
        }
        f6 = -f2 / 1000F / (float)300L;
        f2 /= 1000F;
        f7 = 300L;
        f8 = 300L;
        f2 = f3 + (f2 * f7 + ((float)300L * (f6 * f8)) / 2.0F);
        f6 = (float)(-getWidth()) / 2.0F + f5;
        f5 = (float)getHeight() / 2.0F - f5;
        if (Math.abs(n - (float)(-getWidth()) / 2.0F) < 3F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Math.abs((f4 + n) - (float)getWidth() / 2.0F) < 3F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && f1 > 0.0F && f2 > f6)
        {
            return true;
        }
        if (f1 > 0.0F && f3 > f6)
        {
            return true;
        }
        if (flag1 && f1 < 0.0F && f2 + f4 < f5)
        {
            return true;
        }
        return f1 < 0.0F && f3 + f4 < f5;
    }

    static boolean b(PanZoomView panzoomview, boolean flag)
    {
        panzoomview.l = flag;
        return flag;
    }

    static n c(PanZoomView panzoomview, PointF pointf, PointF pointf1, float f1)
    {
        return panzoomview.f(pointf, pointf1, f1);
    }

    private void c(PointF pointf, PointF pointf1, float f1)
    {
        pointf = u;
        for (u = ViewerMode.a; l || pointf != ViewerMode.b;)
        {
            return;
        }

        d();
    }

    static boolean c(PanZoomView panzoomview)
    {
        return panzoomview.l;
    }

    static boolean c(PanZoomView panzoomview, boolean flag)
    {
        panzoomview.p = flag;
        return flag;
    }

    private void d()
    {
        r = true;
        float f1 = a(b.j);
        float f2 = b(b.j);
        float f3 = getWidth() / 2;
        float f4 = getHeight() / 2;
        if (f1 != 0.0F || f2 != 0.0F)
        {
            l = true;
            p = true;
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(f1, f2, f3, f4) {

                final float a;
                final float b;
                final float c;
                final float d;
                final PanZoomView e;
                private float f;
                private float g;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    PanZoomView.a(e, ViewerMode.c);
                    float f6 = valueanimator1.getAnimatedFraction();
                    float f5 = a * f6;
                    f6 *= b;
                    valueanimator1 = new PointF(c, d);
                    PointF pointf = new PointF(f5 - f, f6 - g);
                    PanZoomView.d(e, valueanimator1, pointf, 1.0F);
                    f = f5;
                    g = f6;
                }

            
            {
                e = PanZoomView.this;
                a = f1;
                b = f2;
                c = f3;
                d = f4;
                super();
            }
            });
            valueanimator.addListener(new android.animation.Animator.AnimatorListener(f3, f4) {

                final float a;
                final float b;
                final PanZoomView c;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    float f5 = PanZoomView.a(c, c.b.j);
                    float f6 = PanZoomView.b(c, c.b.j);
                    animator = new PointF(a, b);
                    PointF pointf = new PointF(f5, f6);
                    PanZoomView.c(c, false);
                    PanZoomView.d(c, animator, pointf, 1.0F);
                    PanZoomView.a(c, ViewerMode.a);
                    PanZoomView.b(c, null);
                    PanZoomView.b(c, false);
                    PanZoomView.a(c, false);
                    c.b.k = c.c(c.b);
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                c = PanZoomView.this;
                a = f1;
                b = f2;
                super();
            }
            });
            valueanimator.start();
            k = valueanimator;
            u = ViewerMode.c;
            return;
        } else
        {
            b.k = c(b);
            r = false;
            u = ViewerMode.a;
            invalidate();
            return;
        }
    }

    private void d(PointF pointf, PointF pointf1, float f1)
    {
        if (pointf1.x == 0.0F && pointf1.y == 0.0F && f1 == 1.0F)
        {
            return;
        } else
        {
            pointf = e(pointf, pointf1, f1);
            pointf1 = new float[9];
            ((n) (pointf)).a.getValues(pointf1);
            f1 = pointf1[0];
            b.j = new Matrix(((n) (pointf)).a);
            b.i = f1;
            b.f = ((n) (pointf)).b;
            b.k = c(b);
            invalidate();
            return;
        }
    }

    static void d(PanZoomView panzoomview)
    {
        panzoomview.f();
    }

    static void d(PanZoomView panzoomview, PointF pointf, PointF pointf1, float f1)
    {
        panzoomview.d(pointf, pointf1, f1);
    }

    private n e(PointF pointf, PointF pointf1, float f1)
    {
        if (pointf1.x == 0.0F && pointf1.y == 0.0F && f1 == 1.0F)
        {
            return new n(this, b.j, b.f);
        }
        if (u == ViewerMode.b || u == ViewerMode.d || u == ViewerMode.e)
        {
            return f(pointf, pointf1, f1);
        } else
        {
            return a(pointf, pointf1, f1);
        }
    }

    private void e()
    {
        float f3 = a(b.j);
        float f5 = b(b.j);
        float f1 = getWidth() / 2;
        float f2 = getHeight() / 2;
        if (f3 != 0.0F || f5 != 0.0F)
        {
            float f4 = a(b.j);
            float f6 = b(b.j);
            d(new PointF(f1, f2), new PointF(f4, f6), 1.0F);
        }
        u = ViewerMode.a;
        b.k = c(b);
        invalidate();
    }

    static void e(PanZoomView panzoomview)
    {
        panzoomview.e();
    }

    private void e(b b1)
    {
        b1.j = new Matrix();
        b1.j.preTranslate(-b1.d / 2, -b1.e / 2);
        b1.j.preScale(b1.h, b1.h);
        float af[] = new float[9];
        b1.j.getValues(af);
        b1.i = af[0];
    }

    private n f(PointF pointf, PointF pointf1, float f1)
    {
        int j1 = b.d;
        int i1 = b.e;
        boolean flag1 = false;
        Object obj = new PointF(pointf1.x, pointf1.y);
        float af[] = new float[9];
        b.j.getValues(af);
        float f3 = af[0];
        Matrix matrix = new Matrix(b.j);
        matrix.preScale(1.0F / (f3 * f3), 1.0F / (f3 * f3));
        matrix.preTranslate(-pointf.x, -pointf.y);
        matrix.preTranslate(pointf1.x, pointf1.y);
        matrix.preScale(f1, f1);
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f3 * f3, f3 * f3);
        float af1[] = new float[9];
        matrix.getValues(af1);
        float f4 = af1[0];
        int k1 = (int)((float)j1 * f4);
        int l1 = (int)((float)i1 * f4);
        int k2 = (int)(af1[2] * f4);
        int i2 = (int)(af1[5] * f4);
        int l2 = k2 + k1;
        int j2 = i2 + l1;
        float f2;
        int i3;
        boolean flag;
        if (u != ViewerMode.d)
        {
            i1 = getWidth() / 8;
        } else
        {
            i1 = 0;
        }
        if (u != ViewerMode.d)
        {
            j1 = getHeight() / 8;
        } else
        {
            j1 = 0;
        }
        if (f4 > b.g)
        {
            f2 = b.g / b.i;
            flag = flag1;
        } else
        if (f4 <= b.h)
        {
            f2 = b.h / b.i;
            flag = true;
        } else
        {
            flag = flag1;
            f2 = f1;
            if (f4 < 1.0F)
            {
                flag = flag1;
                f2 = f1;
                if (b.f)
                {
                    flag = true;
                    f2 = f1;
                }
            }
        }
        i3 = -getWidth() / 2 + i1;
        i1 = getWidth() / 2 - i1;
        if (k2 > i3 && pointf1.x > 0.0F)
        {
            pointf1.set((int)Math.floor(pointf1.x + (float)(i3 - k2)), pointf1.y);
            i1 = 1;
        } else
        if (l2 < i1 && pointf1.x < 0.0F)
        {
            f1 = pointf1.x;
            pointf1.set((int)Math.floor((float)(i1 - l2) + f1), pointf1.y);
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        k2 = -getHeight() / 2 + j1;
        j1 = getHeight() / 2 - j1;
        if (i2 > k2 && pointf1.y > 0.0F)
        {
            f1 = pointf1.x;
            f4 = pointf1.y;
            pointf1.set(f1, (int)Math.floor((float)(k2 - i2) + f4));
            j1 = 1;
        } else
        if (j2 < j1 && pointf1.y < 0.0F)
        {
            f1 = pointf1.x;
            float f5 = pointf1.y;
            pointf1.set(f1, (int)Math.floor((float)(j1 - j2) + f5));
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (Math.floor(k1) <= (double)getWidth())
        {
            pointf1.set(0.0F, pointf1.y);
            pointf.set(0.0F, pointf.y);
        }
        if (Math.floor(l1) <= (double)getHeight())
        {
            pointf1.set(pointf1.x, 0.0F);
            pointf.set(pointf.x, 0.0F);
        }
        if (o != null)
        {
            if (flag && i1 != 0 || !flag && i1 != 0 && j1 != 0)
            {
                pointf1.set(0.0F, 0.0F);
                o.cancel();
            } else
            if (i1 != 0 && ((PointF) (obj)).y == 0.0F)
            {
                pointf1.set(0.0F, 0.0F);
                o.cancel();
            } else
            if (j1 != 0 && ((PointF) (obj)).x == 0.0F)
            {
                pointf1.set(0.0F, 0.0F);
                o.cancel();
            }
        }
        obj = new Matrix(b.j);
        ((Matrix) (obj)).preScale(1.0F / (f3 * f3), 1.0F / (f3 * f3));
        ((Matrix) (obj)).preTranslate(-pointf.x, -pointf.y);
        ((Matrix) (obj)).preTranslate(pointf1.x, pointf1.y);
        ((Matrix) (obj)).preScale(f2, f2);
        ((Matrix) (obj)).preTranslate(pointf.x, pointf.y);
        ((Matrix) (obj)).preScale(f3 * f3, f3 * f3);
        return new n(this, ((Matrix) (obj)), flag);
    }

    private void f()
    {
        if (k != null)
        {
            k.cancel();
        }
    }

    static void f(PanZoomView panzoomview)
    {
        panzoomview.d();
    }

    public n a(PointF pointf, PointF pointf1, float f1)
    {
        f1 = b.i;
        pointf = new Matrix(b.j);
        float af[] = new float[9];
        pointf.getValues(af);
        pointf.preScale(1.0F / (f1 * f1), 1.0F / (f1 * f1));
        pointf.preTranslate(pointf1.x, pointf1.y);
        pointf.preScale(f1 * f1, f1 * f1);
        pointf.getValues(af);
        return new n(this, pointf, b.f);
    }

    public void a(PointF pointf, PointF pointf1, float f1, boolean flag)
    {
        float f2 = b.i;
        Matrix matrix = new Matrix(b.j);
        matrix.preScale(1.0F / (f2 * f2), 1.0F / (f2 * f2));
        matrix.preTranslate(-pointf.x, -pointf.y);
        matrix.preTranslate(pointf1.x, pointf1.y);
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f2 * f2, f2 * f2);
        pointf1 = new Matrix(matrix);
        pointf1.preScale(1.0F / (f2 * f2), 1.0F / (f2 * f2));
        pointf1.preTranslate(-pointf.x, -pointf.y);
        pointf1.preScale(f1, f1);
        pointf1.preTranslate(pointf.x, pointf.y);
        pointf1.preScale(f2 * f2, f2 * f2);
        pointf = new float[9];
        pointf1.getValues(pointf);
        f1 = pointf[0];
        b.j = new Matrix(pointf1);
        b.i = f1;
        b.f = false;
        if (f1 <= b.h)
        {
            b.f = true;
        }
        b.k = c(b);
        if (!flag)
        {
            return;
        } else
        {
            invalidate();
            return;
        }
    }

    public void a(ScaleMode scalemode, float f1, float f2, float f3)
    {
        float f4 = b.i;
        float f5 = f3 / f4;
        float f6 = (float)getWidth() / 2.0F;
        float f7 = (float)getHeight() / 2.0F;
        PointF pointf = new PointF(0.0F, 0.0F);
        i i1 = a(f1, f2, false);
        float af[] = new float[9];
        b.j.getValues(af);
        Object obj = new PointF(-i1.a * (float)b.d, -i1.b * (float)b.e);
        Matrix matrix = new Matrix();
        matrix.postTranslate(((PointF) (obj)).x, ((PointF) (obj)).y);
        matrix.preScale(f3, f3);
        f1 = a(matrix);
        f2 = b(matrix);
        matrix.postTranslate(f1 / f3, f2 / f3);
        float af1[] = new float[9];
        matrix.getValues(af1);
        f1 = af1[2];
        f2 = af1[5];
        matrix = new Matrix(b.j);
        af1 = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        af1.setDuration(300L);
        af1.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(scalemode, f3, i1, f4, f6, f7, pointf, matrix, f1, f2, f5) {

            final ScaleMode a;
            final float b;
            final i c;
            final float d;
            final float e;
            final float f;
            final PointF g;
            final Matrix h;
            final float i;
            final float j;
            final float k;
            final PanZoomView l;
            private Matrix m;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f8 = valueanimator.getAnimatedFraction();
                PanZoomView.a(l, ViewerMode.d);
                if (a == ScaleMode.a && b == 1.0F)
                {
                    valueanimator = l.b(c.a, c.b, false);
                    f8 = (f8 * (b - d) + d) / l.b.i;
                    valueanimator = new PointF(e - ((j) (valueanimator)).a, f - ((j) (valueanimator)).b);
                    Object obj1 = PanZoomView.c(l, valueanimator, g, f8);
                    obj1 = new PointF(PanZoomView.a(l, ((n) (obj1)).a), PanZoomView.b(l, ((n) (obj1)).a));
                    PanZoomView.d(l, valueanimator, ((PointF) (obj1)), f8);
                    return;
                }
                valueanimator = new float[9];
                h.getValues(valueanimator);
                if (b != l.b.h)
                {
                    valueanimator = new PointF((i - valueanimator[2]) * f8, (j - valueanimator[5]) * f8);
                } else
                {
                    valueanimator = new PointF(((float)l.b.d * -0.5F - valueanimator[2]) * f8, ((float)l.b.e * -0.5F - valueanimator[5]) * f8);
                }
                m.set(h);
                m.postTranslate(((PointF) (valueanimator)).x, ((PointF) (valueanimator)).y);
                m.preScale((k - 1.0F) * f8 + 1.0F, f8 * (k - 1.0F) + 1.0F);
                valueanimator = new float[9];
                m.getValues(valueanimator);
                f8 = valueanimator[0];
                l.b.j = m;
                l.b.i = f8;
                l.b.f = false;
                if (f8 <= l.b.h)
                {
                    l.b.f = true;
                }
                l.b.k = l.c(l.b);
                l.invalidate();
            }

            
            {
                l = PanZoomView.this;
                a = scalemode;
                b = f1;
                c = i1;
                d = f2;
                e = f3;
                f = f4;
                g = pointf;
                h = matrix;
                i = f5;
                j = f6;
                k = f7;
                super();
                m = new Matrix();
            }

            private class ScaleMode extends Enum
            {

                public static final ScaleMode a;
                public static final ScaleMode b;
                private static final ScaleMode c[];

                public static ScaleMode valueOf(String s1)
                {
                    return (ScaleMode)Enum.valueOf(w/panzoomview/PanZoomView$ScaleMode, s1);
                }

                public static ScaleMode[] values()
                {
                    return (ScaleMode[])c.clone();
                }

                static 
                {
                    a = new ScaleMode("doubleTap", 0);
                    b = new ScaleMode("centerFocus", 1);
                    c = (new ScaleMode[] {
                        a, b
                    });
                }

                private ScaleMode(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        });
        af1.addListener(new android.animation.Animator.AnimatorListener(f3) {

            boolean a;
            final float b;
            final PanZoomView c;

            private void a()
            {
                if (b == c.b.h)
                {
                    float af2[] = new float[9];
                    c.b.j.getValues(af2);
                    float f8 = af2[0];
                    float f9 = c.b.d;
                    float f10 = c.b.e;
                    float f12 = af2[2];
                    float f11 = af2[5];
                    f9 = (f9 * f8) / 2.0F + f12 * f8;
                    f10 = f11 * f8 + (f10 * f8) / 2.0F;
                    f8 = f9;
                    if (f9 < 1.0F)
                    {
                        f8 = f9;
                        if (f9 > -1F)
                        {
                            f8 = 0.0F;
                        }
                    }
                    f9 = f10;
                    if (f10 < 1.0F)
                    {
                        f9 = f10;
                        if (f10 > -1F)
                        {
                            f9 = 0.0F;
                        }
                    }
                    PointF pointf1 = new PointF(0.0F, 0.0F);
                    PointF pointf2 = new PointF(0.0F - f8, 0.0F - f9);
                    f9 = b / c.b.i;
                    f8 = f9;
                    if (f9 > 0.0F)
                    {
                        f8 = 1.0F;
                    }
                    if (pointf2.x != 0.0F || pointf2.y != 0.0F || f8 != 1.0F)
                    {
                        c.a(pointf1, pointf2, f8, true);
                    }
                }
                PanZoomView.c(c, false);
                if (b == 1.0F)
                {
                    c.a(new PointF(0.0F, 0.0F), new PointF(0.0F, 0.0F), b, true);
                }
                PanZoomView.a(c, ViewerMode.a);
                PanZoomView.e(c);
                PanZoomView.b(c, false);
                PanZoomView.a(c, false);
            }

            public void onAnimationCancel(Animator animator)
            {
                a();
                a = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (a)
                {
                    return;
                } else
                {
                    a();
                    return;
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                c = PanZoomView.this;
                b = f1;
                super();
                a = false;
            }
        });
        p = true;
        l = true;
        af1.start();
    }

    public void a(ViewSetting viewsetting)
    {
        if (viewsetting != null)
        {
            Iterator iterator = viewsetting.d().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue;
                }
                ViewSetting.SettingAction settingaction = (ViewSetting.SettingAction)iterator.next();
                class _cls1
                {

                    static final int a[];

                    static 
                    {
                        a = new int[ViewSetting.SettingAction.values().length];
                        try
                        {
                            a[ViewSetting.SettingAction.a.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[ViewSetting.SettingAction.b.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[ViewSetting.SettingAction.c.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[ViewSetting.SettingAction.d.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1.a[settingaction.ordinal()])
                {
                case 1: // '\001'
                    w = viewsetting.a();
                    break;

                case 2: // '\002'
                    x = viewsetting.b();
                    break;

                case 3: // '\003'
                    if (e == null)
                    {
                        e = new ArrayList();
                    }
                    d d1 = viewsetting.c();
                    if (d1 != null && !e.contains(d1))
                    {
                        d1.setCallback(this);
                        e.add(d1);
                    }
                    break;

                case 4: // '\004'
                    d d2 = viewsetting.c();
                    if (e != null && e.contains(d2))
                    {
                        e.remove(d2);
                        d2.setCallback(null);
                    }
                    break;
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_196;
        while (true) 
        {
            return;
        }
    }

    public RectF getDrawRectF()
    {
        float af[] = new float[9];
        b.j.getValues(af);
        float f7 = af[2];
        float f8 = af[0];
        float f5 = af[5];
        float f6 = af[0];
        float f1 = b.d;
        float f2 = af[0];
        float f3 = b.e;
        float f4 = af[0];
        f7 = f7 * f8 + (float)getWidth() / 2.0F;
        f5 = f5 * f6 + (float)getHeight() / 2.0F;
        RectF rectf = new RectF();
        rectf.left = (float)Math.ceil(f7);
        rectf.top = (float)Math.ceil(f5);
        rectf.right = (float)Math.floor(f7 + f1 * f2);
        rectf.bottom = (float)Math.floor(f4 * f3 + f5);
        return rectf;
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        while (motionevent.getActionMasked() != 8 || !b() || l) 
        {
            return false;
        }
        if (u != ViewerMode.a) goto _L2; else goto _L1
_L1:
        u = ViewerMode.b;
_L4:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        float f3 = motionevent.getAxisValue(9);
        b(new PointF((float)getWidth() / 2.0F - f1, (float)getHeight() / 2.0F - f2), new PointF(0.0F, 0.0F), 1.0F + 0.02F * f3);
        u = ViewerMode.a;
        d();
        return true;
_L2:
        if (u == ViewerMode.c)
        {
            f();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        c c1 = a(b);
        b.h = c1.a;
        b.g = c1.b;
        if (u == ViewerMode.c)
        {
            f();
        }
        if (i1 > k1 || j1 > l1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (b.f)
        {
            e(b);
            b.k = c(b);
            return;
        }
        if (b.k != null)
        {
            b.k = c(b);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (b.f)
        {
            e(b);
            b.k = c(b);
            return;
        }
        Matrix matrix = new Matrix(b.j);
        float af[] = new float[9];
        matrix.getValues(af);
        if (af[0] <= b.h)
        {
            e(b);
            b.f = true;
            b.k = c(b);
            return;
        }
        float f1 = af[0];
        float f5 = af[2] * f1;
        float f3 = af[5] * f1;
        float f6 = (float)b.d * f1;
        float f4 = (float)b.e * f1;
        f1 = 0.0F;
        float f2 = 0.0F;
        if (f6 <= (float)i1)
        {
            f1 = 0.0F - (f5 + f6 / 2.0F);
        } else
        if (f5 > -((float)i1 / 2.0F))
        {
            f1 = -((float)i1 / 2.0F) - f5;
        } else
        if (f5 + f6 < (float)i1 / 2.0F)
        {
            f1 = (float)i1 / 2.0F - (f5 + f6);
        }
        if (f4 <= (float)j1)
        {
            f2 = 0.0F - (f4 / 2.0F + f3);
        } else
        if (f3 > -((float)j1 / 2.0F))
        {
            f2 = (float)(-j1) / 2.0F - f3;
        } else
        if (f3 + f4 < (float)j1 / 2.0F)
        {
            f2 = (float)j1 / 2.0F - (f3 + f4);
        }
        b.j = new Matrix(matrix);
        matrix = b.j;
        f1 /= af[0] * af[0];
        f3 = af[0];
        matrix.preTranslate(f1, f2 / (af[0] * f3));
        af = new float[9];
        b.j.getValues(af);
        b.i = af[0];
        b.k = c(b);
        return;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isEnabled() && !w) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        if (h == null && g == null && j == null && i == null)
        {
            h = new l(this);
            g = new ScaleGestureDetector(getContext(), h);
            j = new k(this);
            i = new GestureDetector(getContext(), j);
        }
        float f1;
        boolean flag;
        if (x != null && !z)
        {
            MotionEvent motionevent1 = a(motionevent);
            c();
            flag1 = x.a(this, motionevent1, f);
            motionevent1.recycle();
            flag = flag1;
            if (motionevent.getActionMasked() == 0)
            {
                flag = flag1;
                if (flag1)
                {
                    if (y != null)
                    {
                        y.recycle();
                    }
                    y = MotionEvent.obtain(motionevent);
                    flag = flag1;
                }
            }
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (flag) goto _L4; else goto _L3
_L3:
        z = true;
        if (x != null && y != null)
        {
            i.onTouchEvent(y);
            g.onTouchEvent(y);
            y.recycle();
            y = null;
        }
        v = motionevent.getPointerCount();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 5: default 316
    //                   0 350
    //                   1 387
    //                   2 316
    //                   3 392
    //                   4 316
    //                   5 366;
           goto _L5 _L6 _L7 _L5 _L8 _L5 _L9
_L5:
        if (!b())
        {
            q = true;
        }
        if (q)
        {
            if (motionevent.getActionMasked() == 1)
            {
                q = false;
            }
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        m = true;
        t = Boolean.valueOf(false);
        continue; /* Loop/switch isn't completed */
_L9:
        if (!s.booleanValue())
        {
            t = Boolean.valueOf(true);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        m = false;
_L8:
        m = false;
        if (true) goto _L5; else goto _L10
_L10:
        i.onTouchEvent(motionevent);
        g.onTouchEvent(motionevent);
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 464
    //                   0 466
    //                   1 512
    //                   2 464
    //                   3 512
    //                   4 464
    //                   5 464
    //                   6 528;
           goto _L11 _L12 _L13 _L11 _L13 _L11 _L11 _L14
_L11:
        return true;
_L12:
        motionevent = new float[9];
        b.j.getValues(motionevent);
        f1 = motionevent[2];
        n = motionevent[0] * f1;
        if (o != null)
        {
            o.cancel();
        }
        continue; /* Loop/switch isn't completed */
_L13:
        j.b(motionevent);
        z = false;
        continue; /* Loop/switch isn't completed */
_L14:
        j.a(motionevent);
        if (true) goto _L11; else goto _L15
_L15:
    }

    private class ViewerMode extends Enum
    {

        public static final ViewerMode a;
        public static final ViewerMode b;
        public static final ViewerMode c;
        public static final ViewerMode d;
        public static final ViewerMode e;
        private static final ViewerMode f[];

        public static ViewerMode valueOf(String s1)
        {
            return (ViewerMode)Enum.valueOf(w/panzoomview/PanZoomView$ViewerMode, s1);
        }

        public static ViewerMode[] values()
        {
            return (ViewerMode[])f.clone();
        }

        static 
        {
            a = new ViewerMode("unknown", 0);
            b = new ViewerMode("imageViewing", 1);
            c = new ViewerMode("imageBouncing", 2);
            d = new ViewerMode("imageDoubleTaping", 3);
            e = new ViewerMode("imageFling", 4);
            f = (new ViewerMode[] {
                a, b, c, d, e
            });
        }

        private ViewerMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
