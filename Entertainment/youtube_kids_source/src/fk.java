// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class fk
    implements android.view.View.OnTouchListener
{

    private static final int q = ViewConfiguration.getTapTimeout();
    private final fl a = new fl();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float e[] = {
        0.0F, 0.0F
    };
    private float f[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private int g;
    private int h;
    private float i[] = {
        0.0F, 0.0F
    };
    private float j[] = {
        0.0F, 0.0F
    };
    private float k[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    public fk(View view)
    {
        c = view;
        view = Resources.getSystem().getDisplayMetrics();
        int i1 = (int)(1575F * ((DisplayMetrics) (view)).density + 0.5F);
        int j1 = (int)(((DisplayMetrics) (view)).density * 315F + 0.5F);
        float f1 = i1;
        float f2 = i1;
        k[0] = f1 / 1000F;
        k[1] = f2 / 1000F;
        f1 = j1;
        f2 = j1;
        j[0] = f1 / 1000F;
        j[1] = f2 / 1000F;
        g = 1;
        f[0] = 3.402823E+38F;
        f[1] = 3.402823E+38F;
        e[0] = 0.2F;
        e[1] = 0.2F;
        i[0] = 0.001F;
        i[1] = 0.001F;
        h = q;
        a.a = 500;
        a.b = 500;
    }

    private float a(float f1, float f2)
    {
        if (f2 != 0.0F) goto _L2; else goto _L1
_L1:
        return 0.0F;
_L2:
        g;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 42
    //                   2 77;
           goto _L3 _L4 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return 0.0F;
_L4:
        if (f1 >= f2) goto _L1; else goto _L6
_L6:
        if (f1 >= 0.0F)
        {
            return 1.0F - f1 / f2;
        }
        if (!o || g != 1) goto _L1; else goto _L7
_L7:
        return 1.0F;
        if (f1 >= 0.0F) goto _L1; else goto _L8
_L8:
        return f1 / -f2;
    }

    static float a(float f1, float f2, float f3)
    {
        return b(f1, 0.0F, 1.0F);
    }

    private float a(int i1, float f1, float f2, float f3)
    {
        float f4 = b(e[i1] * f2, 0.0F, f[i1]);
        float f6 = a(f1, f4);
        f1 = a(f2 - f1, f4) - f6;
        if (f1 >= 0.0F) goto _L2; else goto _L1
_L1:
        f1 = -b.getInterpolation(-f1);
_L6:
        f1 = b(f1, -1F, 1.0F);
_L4:
        if (f1 == 0.0F)
        {
            return 0.0F;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (f1 > 0.0F)
        {
            f1 = b.getInterpolation(f1);
            continue; /* Loop/switch isn't completed */
        }
        f1 = 0.0F;
        if (true) goto _L4; else goto _L3
_L3:
        float f7 = i[i1];
        f2 = j[i1];
        float f5 = k[i1];
        f3 = f7 * f3;
        if (f1 > 0.0F)
        {
            return b(f1 * f3, f2, f5);
        }
        return -b(-f1 * f3, f2, f5);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean a()
    {
        fl fl1 = a;
        int i1 = (int)(fl1.d / Math.abs(fl1.d));
        int j1 = (int)(fl1.c / Math.abs(fl1.c));
        if (i1 == 0 || !b(i1))
        {
            if (j1 == 0);
            return false;
        } else
        {
            return true;
        }
    }

    static boolean a(fk fk1)
    {
        return fk1.o;
    }

    static boolean a(fk fk1, boolean flag)
    {
        fk1.m = false;
        return false;
    }

    private static float b(float f1, float f2, float f3)
    {
        if (f1 > f3)
        {
            return f3;
        }
        if (f1 < f2)
        {
            return f2;
        } else
        {
            return f1;
        }
    }

    private void b()
    {
        fl fl1;
        int i1;
        int j1;
        long l1;
        if (m)
        {
            o = false;
            return;
        }
        fl1 = a;
        l1 = AnimationUtils.currentAnimationTimeMillis();
        i1 = (int)(l1 - fl1.e);
        j1 = fl1.b;
        if (i1 <= j1) goto _L2; else goto _L1
_L1:
        i1 = j1;
_L4:
        fl1.k = i1;
        fl1.j = fl1.a(l1);
        fl1.i = l1;
        return;
_L2:
        if (i1 < 0)
        {
            i1 = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean b(fk fk1)
    {
        return fk1.m;
    }

    static boolean b(fk fk1, boolean flag)
    {
        fk1.o = false;
        return false;
    }

    static fl c(fk fk1)
    {
        return fk1.a;
    }

    static boolean c(fk fk1, boolean flag)
    {
        fk1.n = false;
        return false;
    }

    static boolean d(fk fk1)
    {
        return fk1.a();
    }

    static boolean e(fk fk1)
    {
        return fk1.n;
    }

    static void f(fk fk1)
    {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        fk1.c.onTouchEvent(motionevent);
        motionevent.recycle();
    }

    static View g(fk fk1)
    {
        return fk1.c;
    }

    public final fk a(boolean flag)
    {
        if (p && !flag)
        {
            b();
        }
        p = flag;
        return this;
    }

    public abstract void a(int i1);

    public abstract boolean b(int i1);

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (p) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (dw.a(motionevent))
        {
        default:
            return false;

        case 0: // '\0'
            n = true;
            l = false;
            // fall through

        case 2: // '\002'
            float f1 = a(0, motionevent.getX(), view.getWidth(), c.getWidth());
            float f2 = a(1, motionevent.getY(), view.getHeight(), c.getHeight());
            view = a;
            view.c = f1;
            view.d = f2;
            if (!o && a())
            {
                if (d == null)
                {
                    d = new fm(this);
                }
                o = true;
                m = true;
                if (!l && h > 0)
                {
                    dz.a(c, d, h);
                } else
                {
                    d.run();
                }
                l = true;
                return false;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            b();
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}
