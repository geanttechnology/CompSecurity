// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.d.d;
import com.mopub.common.d.e;

// Referenced classes of package com.mopub.common:
//            m

public final class g extends FrameLayout
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a i[];
        final int h;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/common/g$a, s);
        }

        public static a[] values()
        {
            return (a[])i.clone();
        }

        static 
        {
            a = new a("TOP_LEFT", 0, 51);
            b = new a("TOP_CENTER", 1, 49);
            c = new a("TOP_RIGHT", 2, 53);
            d = new a("CENTER", 3, 17);
            e = new a("BOTTOM_LEFT", 4, 83);
            f = new a("BOTTOM_CENTER", 5, 81);
            g = new a("BOTTOM_RIGHT", 6, 85);
            i = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s, int i1, int j1)
        {
            super(s, i1);
            h = j1;
        }
    }

    public static interface b
    {

        public abstract void a();
    }

    private final class c
        implements Runnable
    {

        final g a;

        public final void run()
        {
            g.a(a);
        }

        private c()
        {
            a = g.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    public final StateListDrawable a = new StateListDrawable();
    private final int b;
    private b c;
    private a d;
    private final int e;
    private final int f;
    private final int g;
    private boolean h;
    private final Rect i = new Rect();
    private final Rect j = new Rect();
    private final Rect k = new Rect();
    private final Rect l = new Rect();
    private c m;

    public g(Context context)
    {
        super(context);
        d = a.c;
        a.addState(SELECTED_STATE_SET, e.j.a(context));
        a.addState(EMPTY_STATE_SET, e.i.a(context));
        a.setState(EMPTY_STATE_SET);
        a.setCallback(this);
        b = ViewConfiguration.get(context).getScaledTouchSlop();
        e = com.mopub.common.d.d.c(50F, context);
        f = com.mopub.common.d.d.c(30F, context);
        g = com.mopub.common.d.d.c(8F, context);
        setWillNotDraw(false);
    }

    private static void a(a a1, int i1, Rect rect, Rect rect1)
    {
        Gravity.apply(a1.h, i1, i1, rect, rect1);
    }

    static void a(g g1)
    {
        g1.setClosePressed(false);
    }

    private boolean a()
    {
        return a.getState() == SELECTED_STATE_SET;
    }

    private boolean a(int i1, int j1, int k1)
    {
        return i1 >= j.left - k1 && j1 >= j.top - k1 && i1 < j.right + k1 && j1 < j.bottom + k1;
    }

    private void setClosePressed(boolean flag)
    {
        if (flag == a())
        {
            return;
        }
        StateListDrawable statelistdrawable = a;
        int ai[];
        if (flag)
        {
            ai = SELECTED_STATE_SET;
        } else
        {
            ai = EMPTY_STATE_SET;
        }
        statelistdrawable.setState(ai);
        invalidate(j);
    }

    public final void a(a a1, Rect rect, Rect rect1)
    {
        a(a1, e, rect, rect1);
    }

    public final void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (h)
        {
            h = false;
            i.set(0, 0, getWidth(), getHeight());
            a(d, i, j);
            l.set(j);
            l.inset(g, g);
            a a1 = d;
            Rect rect = l;
            Rect rect1 = k;
            a(a1, f, rect, rect1);
            a.setBounds(k);
        }
        if (a.isVisible())
        {
            a.draw(canvas);
        }
    }

    final Rect getCloseBounds()
    {
        return j;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0)
        {
            return false;
        } else
        {
            return a((int)motionevent.getX(), (int)motionevent.getY(), 0);
        }
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        h = true;
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!a((int)motionevent.getX(), (int)motionevent.getY(), b))
        {
            setClosePressed(false);
            super.onTouchEvent(motionevent);
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 70
    //                   1 86
    //                   2 68
    //                   3 78;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        setClosePressed(true);
        continue; /* Loop/switch isn't completed */
_L4:
        setClosePressed(false);
        continue; /* Loop/switch isn't completed */
_L3:
        if (a())
        {
            if (m == null)
            {
                m = new c((byte)0);
            }
            postDelayed(m, ViewConfiguration.getPressedStateDuration());
            playSoundEffect(0);
            if (c != null)
            {
                c.a();
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    final void setCloseBoundChanged(boolean flag)
    {
        h = flag;
    }

    final void setCloseBounds(Rect rect)
    {
        j.set(rect);
    }

    public final void setClosePosition(a a1)
    {
        com.mopub.common.m.a(a1);
        d = a1;
        h = true;
        invalidate();
    }

    public final void setCloseVisible(boolean flag)
    {
        if (a.setVisible(flag, false))
        {
            invalidate(j);
        }
    }

    public final void setOnCloseListener(b b1)
    {
        c = b1;
    }
}
