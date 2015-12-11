// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewConfiguration;

public final class cjs extends cja
{

    private final long c = (long)ViewConfiguration.getLongPressTimeout();
    private cju d;
    private final View e;
    private final bmi f;
    private Surface g;
    private int h;
    private int i;
    private boolean j;
    private long k;

    public cjs(Context context, View view, bmi bmi1)
    {
        super(context);
        f = bmi1;
        e = view;
        d = new cju(context, new cjt(this));
        addView(d);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setSystemUiVisibility(4096);
        }
    }

    static Surface a(cjs cjs1, Surface surface)
    {
        cjs1.g = surface;
        return surface;
    }

    public final void a(boolean flag)
    {
        d.a.a.a(flag);
    }

    public final SurfaceHolder d()
    {
        return null;
    }

    protected final void e()
    {
    }

    protected final void f()
    {
    }

    public final ckf h()
    {
        return d;
    }

    public final Surface i()
    {
        return g;
    }

    public final boolean j()
    {
        return g != null;
    }

    public final void k()
    {
    }

    public final void l()
    {
        d.a.a.d();
        d = null;
    }

    public final int m()
    {
        return 5;
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (d.a.a.e())
        {
            a(d, k1, l1);
            return;
        } else
        {
            d.layout(0, 0, k1 - i1, l1 - j1);
            return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 46
    //                   1 159
    //                   2 82
    //                   3 216;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = super.onTouchEvent(motionevent);
_L7:
        return flag;
_L2:
        h = (int)motionevent.getX();
        i = (int)motionevent.getY();
        j = false;
        k = f.b();
        return true;
_L4:
        int i1 = (int)motionevent.getX();
        int j1 = h;
        int k1 = (int)motionevent.getY();
        int l1 = i;
        d.a.a.b(i1 - j1, k1 - l1);
        h = (int)motionevent.getX();
        i = (int)motionevent.getY();
        requestDisallowInterceptTouchEvent(true);
        j = true;
        return true;
_L3:
        requestDisallowInterceptTouchEvent(false);
        if (j) goto _L7; else goto _L6
_L6:
        if (f.b() - k > c)
        {
            e.performLongClick();
        } else
        {
            e.performClick();
        }
        return super.onTouchEvent(motionevent);
_L5:
        j = false;
        if (true) goto _L1; else goto _L8
_L8:
    }
}
