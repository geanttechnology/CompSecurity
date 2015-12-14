// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.melnykov.fab.a;

// Referenced classes of package com.socialin.picsin.camera.view:
//            f, e

public class RightToLeftSlidingDrower extends ViewGroup
{

    View a;
    boolean b;
    private int c;
    private int d;
    private View e;
    private final Rect f;
    private final Rect g;
    private boolean h;
    private VelocityTracker i;
    private int j;
    private final Handler k;
    private float l;
    private float m;
    private float n;
    private long o;
    private long p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private final int u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    public RightToLeftSlidingDrower(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RightToLeftSlidingDrower(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        f = new Rect();
        g = new Rect();
        k = new f(this, (byte)0);
        s = true;
        t = true;
        float f1 = getResources().getDisplayMetrics().density;
        u = (int)(6F * f1 + 0.5F);
        v = (int)(100F * f1 + 0.5F);
        w = (int)(150F * f1 + 0.5F);
        x = (int)(200F * f1 + 0.5F);
        y = (int)(2000F * f1 + 0.5F);
        z = (int)(f1 * 1000F + 0.5F);
        setAlwaysDrawnWithCacheEnabled(false);
    }

    private void a(int i1, float f1, boolean flag)
    {
        n = i1;
        m = f1;
        if (!b) goto _L2; else goto _L1
_L1:
        if (!flag && f1 <= (float)x && (i1 <= j + 0 || f1 <= (float)(-x))) goto _L4; else goto _L3
_L3:
        l = y;
        if (f1 < 0.0F)
        {
            m = 0.0F;
        }
_L6:
        long l1 = SystemClock.uptimeMillis();
        o = l1;
        p = l1 + 16L;
        r = true;
        k.removeMessages(1000);
        k.sendMessageAtTime(k.obtainMessage(1000), p);
        a.setPressed(false);
        h = false;
        if (i != null)
        {
            i.recycle();
            i = null;
        }
        return;
_L4:
        l = -y;
        if (f1 > 0.0F)
        {
            m = 0.0F;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!flag && (f1 > (float)x || i1 > getWidth() / 2 && f1 > (float)(-x)))
        {
            l = y;
            if (f1 < 0.0F)
            {
                m = 0.0F;
            }
        } else
        {
            l = -y;
            if (f1 > 0.0F)
            {
                m = 0.0F;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(RightToLeftSlidingDrower righttoleftslidingdrower)
    {
        return righttoleftslidingdrower.t;
    }

    static void b(RightToLeftSlidingDrower righttoleftslidingdrower)
    {
label0:
        {
            if (righttoleftslidingdrower.r)
            {
                long l1 = SystemClock.uptimeMillis();
                float f1 = (float)(l1 - righttoleftslidingdrower.o) / 1000F;
                float f2 = righttoleftslidingdrower.n;
                float f3 = righttoleftslidingdrower.m;
                float f4 = righttoleftslidingdrower.l;
                righttoleftslidingdrower.n = f2 + f3 * f1 + 0.5F * f4 * f1 * f1;
                righttoleftslidingdrower.m = f1 * f4 + f3;
                righttoleftslidingdrower.o = l1;
                if (righttoleftslidingdrower.n < (float)((righttoleftslidingdrower.getWidth() + 0) - 1))
                {
                    break label0;
                }
                righttoleftslidingdrower.r = false;
                righttoleftslidingdrower.b();
            }
            return;
        }
        if (righttoleftslidingdrower.n < 0.0F)
        {
            righttoleftslidingdrower.r = false;
            righttoleftslidingdrower.c();
            return;
        } else
        {
            righttoleftslidingdrower.d((int)righttoleftslidingdrower.n);
            righttoleftslidingdrower.p = righttoleftslidingdrower.p + 16L;
            righttoleftslidingdrower.k.sendMessageAtTime(righttoleftslidingdrower.k.obtainMessage(1000), righttoleftslidingdrower.p);
            return;
        }
    }

    private void c(int i1)
    {
        h = true;
        i = VelocityTracker.obtain();
        boolean flag;
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l = y;
            m = x;
            n = (getWidth() - j) + 0;
            d((int)n);
            r = true;
            k.removeMessages(1000);
            long l1 = SystemClock.uptimeMillis();
            o = l1;
            p = l1 + 16L;
            r = true;
            return;
        }
        if (r)
        {
            r = false;
            k.removeMessages(1000);
        }
        d(i1);
    }

    private void d(int i1)
    {
        View view;
        int j1;
        int k1;
        view = a;
        if (i1 == -10001)
        {
            (new StringBuilder("mTopOffset: 0")).append(" handle.getLeft(): ").append(view.getLeft());
            view.offsetLeftAndRight(0 - view.getLeft());
            invalidate();
            return;
        }
        if (i1 == -10002)
        {
            (new StringBuilder("getRight() - getLeft() -mHandleWidth - handle.getLeft(): ")).append(getRight() - getLeft() - j - view.getLeft());
            view.offsetLeftAndRight((getRight() + 0) - getLeft() - j - view.getLeft());
            invalidate();
            return;
        }
        k1 = view.getLeft();
        j1 = i1 - k1;
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        i1 = 0 - k1;
_L4:
        view.offsetLeftAndRight(i1);
        Rect rect = f;
        Rect rect1 = g;
        view.getHitRect(rect);
        rect1.set(rect);
        rect1.union(rect.left - i1, rect.top, rect.right - i1, rect.bottom);
        rect1.union(rect.right - i1, 0, (rect.right - i1) + e.getWidth(), getHeight());
        invalidate(rect1);
        return;
_L2:
        i1 = j1;
        if (j1 > (getRight() + 0) - getLeft() - j - k1)
        {
            i1 = (getRight() + 0) - getLeft() - j - k1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a()
    {
        if (r)
        {
            return;
        }
        View view = e;
        if (view.isLayoutRequested())
        {
            int i1 = a.getWidth();
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec((getRight() - getLeft() - i1) + 0, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 0x40000000));
            view.layout(i1 + 0, 0, i1 + 0 + view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        view.getViewTreeObserver().dispatchOnPreDraw();
        view.buildDrawingCache();
        view.setVisibility(8);
    }

    final void a(int i1)
    {
        c(i1);
        a(i1, -y, true);
    }

    final void b()
    {
        d(-10002);
        e.setVisibility(8);
        e.destroyDrawingCache();
        if (!b)
        {
            return;
        } else
        {
            b = false;
            return;
        }
    }

    final void b(int i1)
    {
        c(i1);
        a(i1, y, true);
    }

    final void c()
    {
        d(-10001);
        e.setVisibility(0);
        if (b)
        {
            return;
        } else
        {
            b = true;
            return;
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        View view;
        long l1;
        l1 = getDrawingTime();
        view = a;
        drawChild(canvas, view, l1);
        if (!h && !r) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = e.getDrawingCache();
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        canvas.drawBitmap(bitmap, view.getLeft() - bitmap.getWidth(), 0.0F, null);
_L6:
        return;
_L4:
        canvas.save();
        canvas.translate(view.getLeft() + 0, 0.0F);
        drawChild(canvas, e, l1);
        canvas.restore();
        return;
_L2:
        if (b)
        {
            drawChild(canvas, e, l1);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onFinishInflate()
    {
        int i1 = getChildAt(0).getId();
        if (i1 == 0)
        {
            throw new IllegalArgumentException("The handle attribute is required and must refer to a valid child.");
        }
        int j1 = getChildAt(1).getId();
        if (j1 == 0)
        {
            throw new IllegalArgumentException("The content attribute is required and must refer to a valid child.");
        }
        if (i1 == j1)
        {
            throw new IllegalArgumentException("The content and handle attributes must refer to different children.");
        }
        c = i1;
        d = j1;
        a = findViewById(c);
        if (a == null)
        {
            throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
        }
        a.setOnClickListener(new e(this, (byte)0));
        e = findViewById(d);
        if (e == null)
        {
            throw new IllegalArgumentException("The content attribute is must refer to an existing child.");
        } else
        {
            e.setVisibility(8);
            return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        int i1 = motionevent.getAction();
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        Rect rect = f;
        View view = a;
        view.getHitRect(rect);
        if (!h && !rect.contains((int)f1, (int)f2))
        {
            flag = false;
        } else
        if (i1 == 0)
        {
            h = true;
            view.setPressed(true);
            a();
            int j1 = a.getRight();
            q = getWidth() - j1;
            c(j1);
            i.addMovement(motionevent);
            return true;
        }
        return flag;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (h)
        {
            return;
        }
        View view = a;
        int i2 = view.getMeasuredWidth();
        int j2 = view.getMeasuredHeight();
        View view1 = e;
        if (b)
        {
            i1 = 0;
        } else
        {
            i1 = (k1 - i1 - i2) + 0;
        }
        j1 = (l1 - j1 - j2) / 2;
        view1.layout(0, 0, view1.getMeasuredWidth() + 0, view1.getMeasuredHeight());
        view.layout(i1, j1, i1 + i2, j1 + j2);
        view.getHeight();
        j = view.getWidth();
    }

    protected void onMeasure(int i1, int j1)
    {
        int i2 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        int j2 = android.view.View.MeasureSpec.getMode(j1);
        int l1 = android.view.View.MeasureSpec.getSize(j1);
        if (i2 == 0 || j2 == 0)
        {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        } else
        {
            View view = a;
            measureChild(view, i1, j1);
            i1 = view.getMeasuredWidth();
            e.measure(android.view.View.MeasureSpec.makeMeasureSpec((k1 - i1) + 0, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000));
            setMeasuredDimension(k1, l1);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!h) goto _L2; else goto _L1
_L1:
        i.addMovement(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 44
    //                   1 85
    //                   2 68
    //                   3 85;
           goto _L3 _L4 _L5 _L4
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_85;
_L2:
        return h || r || super.onTouchEvent(motionevent);
_L5:
        d((int)motionevent.getX() - q);
          goto _L2
        VelocityTracker velocitytracker = i;
        velocitytracker.computeCurrentVelocity(z);
        float f2 = velocitytracker.getYVelocity();
        float f3 = velocitytracker.getXVelocity();
        float f1;
        int i1;
        if (f3 < 0.0F)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        f1 = f2;
        if (f2 < 0.0F)
        {
            f1 = -f2;
        }
        f2 = f1;
        if (f1 > (float)w)
        {
            f2 = w;
        }
        f2 = (float)Math.hypot(f3, f2);
        f1 = f2;
        if (i1 != 0)
        {
            f1 = -f2;
        }
        a.getTop();
        i1 = a.getRight();
        if (Math.abs(f1) < (float)v)
        {
            if (b && i1 < u + 0 || !b && i1 > (getRight() + 0) - getLeft() - j - u)
            {
                if (s)
                {
                    playSoundEffect(0);
                    if (b)
                    {
                        a(i1);
                    } else
                    {
                        b(i1);
                    }
                } else
                {
                    a(i1, f1, false);
                }
            } else
            {
                a(i1, f1, false);
            }
        } else
        {
            a(i1, f1, false);
        }
          goto _L2
    }

    public void setOnDrawerCloseListener$238ef479(a a1)
    {
    }

    public void setOnDrawerOpenListener$794fc781(a a1)
    {
    }

    public void setOnDrawerScrollListener$1bde86dc(a a1)
    {
    }
}
