// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import a;
import agg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import b;
import bmc;
import bmo;

public class TimeBar extends View
{

    private static final int d[] = {
        0xfefeff62
    };
    private int A;
    private String B;
    private final Rect C;
    private int D;
    public agg a;
    public boolean b;
    public boolean c;
    private final DisplayMetrics e;
    private int f;
    private final Rect g;
    private final Rect h;
    private final Rect i;
    private final Paint j;
    private final NinePatchDrawable k;
    private final NinePatchDrawable l;
    private final NinePatchDrawable m;
    private final NinePatchDrawable n;
    private final StateListDrawable o;
    private final int p;
    private final int q;
    private int r;
    private final int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public TimeBar(Context context, agg agg1)
    {
        this(context, ((AttributeSet) (null)));
        a = (agg)b.a(agg1);
    }

    public TimeBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = context.getResources().getDisplayMetrics();
        c = true;
        v = true;
        w = true;
        f = 1;
        g = new Rect();
        h = new Rect();
        i = new Rect();
        D = (int)getResources().getDimension(0x7f0a00c3);
        l = (NinePatchDrawable)getResources().getDrawable(0x7f020228);
        m = (NinePatchDrawable)getResources().getDrawable(0x7f02022a);
        n = (NinePatchDrawable)getResources().getDrawable(0x7f020229);
        k = (NinePatchDrawable)getResources().getDrawable(0x7f020229);
        float f1 = e.density;
        C = new Rect();
        j = new Paint(1);
        j.setTypeface(bmc.b.a(context));
        j.setShadowLayer(6F, 1.0F, 1.0F, Color.parseColor("#50000000"));
        j.setColor(-1);
        j.setTextSize(f1 * 14F);
        j.setTextAlign(android.graphics.Paint.Align.CENTER);
        j.getTextBounds("0:00:00", 0, 7, C);
        context = new Rect();
        j.getTextBounds(i(), 0, 2, context);
        s = context.width();
        B = a(0L);
        o = (StateListDrawable)getResources().getDrawable(0x7f020221);
        p = (int)(e.density * 13F);
        q = (int)(e.density * 12F);
        d();
    }

    private String a(long l1)
    {
        byte byte0 = 3;
        if (x < 0x36ee80) goto _L2; else goto _L1
_L1:
        byte0 = 5;
_L4:
        return a.a((int)l1 / 1000, byte0);
_L2:
        if (x >= 60000)
        {
            byte0 = 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(float f1)
    {
        int i1 = o.getIntrinsicWidth() / 2;
        int j1 = g.right;
        int k1 = g.left;
        t = (int)f1 - i1;
        t = Math.min(j1 - i1, Math.max(k1 - i1, t));
    }

    private void b()
    {
        h.set(g);
        i.set(g);
        int i1;
        if (b)
        {
            i1 = z;
        } else
        {
            i1 = y;
        }
        if (x > 0)
        {
            int j1 = (int)(((long)g.width() * (long)A) / (long)x);
            h.right = j1 + g.left;
            j1 = (int)(((long)g.width() * (long)y) / (long)x);
            i.right = j1 + g.left;
            long l1 = g.width();
            t = (int)(((long)i1 * l1) / (long)x) + (g.left - o.getIntrinsicWidth() / 2);
        } else
        {
            h.right = g.left;
            i.right = g.left;
            t = g.left - o.getIntrinsicWidth() / 2;
        }
        invalidate();
    }

    private void c()
    {
        if (b && !isEnabled())
        {
            h();
            b();
            return;
        }
        StateListDrawable statelistdrawable = o;
        int ai[];
        if (b)
        {
            ai = PRESSED_ENABLED_FOCUSED_STATE_SET;
        } else
        if (isEnabled())
        {
            ai = ENABLED_STATE_SET;
        } else
        {
            ai = d;
        }
        statelistdrawable.setState(ai);
    }

    private void d()
    {
        r = C.width() + (q << 1) + o.getIntrinsicWidth() / 2;
    }

    private boolean e()
    {
        return c && x > 0;
    }

    private int f()
    {
        long l1 = (t + o.getIntrinsicWidth() / 2) - g.left;
        return Math.min(x, Math.max((int)((l1 * (long)x) / (long)g.width()), 0));
    }

    private boolean g()
    {
        return f == 2;
    }

    private void h()
    {
        b = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        c();
        invalidate();
    }

    private String i()
    {
        return getResources().getString(0x7f0b012b, new Object[] {
            " \267 ", ""
        });
    }

    private String j()
    {
        return getContext().getResources().getString(0x7f0b01f2, new Object[] {
            a(y), a(x)
        });
    }

    public final void a()
    {
        a(0, 0, 0);
    }

    public final void a(int i1)
    {
        f = i1;
        boolean flag;
        if (!g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
    }

    public final void a(int i1, int j1, int k1)
    {
        if (y != i1 || x != j1 || A != k1)
        {
            if (x != j1)
            {
                x = j1;
                B = a(j1);
                j.getTextBounds(B, 0, B.length(), C);
                d();
                c();
            }
            y = i1;
            A = k1;
            b();
        }
    }

    public final void a(boolean flag)
    {
        v = flag;
        if (!flag && b)
        {
            if (a != null)
            {
                a.onScrubbingEnd(f());
            }
            b = false;
        }
        requestLayout();
    }

    public void draw(Canvas canvas)
    {
        bmo.a();
        super.draw(canvas);
        k.setBounds(g);
        k.draw(canvas);
        if (w)
        {
            n.setBounds(h);
            n.draw(canvas);
        }
        Object obj;
        if (g())
        {
            obj = m;
        } else
        {
            obj = l;
        }
        ((NinePatchDrawable) (obj)).setBounds(i);
        ((NinePatchDrawable) (obj)).draw(canvas);
        if (v)
        {
            o.setBounds(t, u, t + o.getIntrinsicWidth(), u + o.getIntrinsicHeight());
            o.draw(canvas);
        }
        if (e())
        {
            String s1;
            int i1;
            int j1;
            long l1;
            if (g())
            {
                obj = i();
            } else
            {
                obj = "";
            }
            obj = String.valueOf(obj);
            if (b)
            {
                l1 = z;
            } else
            {
                l1 = y;
            }
            s1 = String.valueOf(a(l1));
            if (s1.length() != 0)
            {
                obj = ((String) (obj)).concat(s1);
            } else
            {
                obj = new String(((String) (obj)));
            }
            j1 = (r * 3) / 7;
            if (g())
            {
                i1 = 0;
            } else
            {
                i1 = D;
            }
            canvas.drawText(((String) (obj)), j1 - i1, getHeight() / 2 + C.height() / 2, j);
            canvas.drawText(B, getWidth() - (r * 3) / 7, getHeight() / 2 + C.height() / 2, j);
        }
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        String s1 = getResources().getString(0x7f0b01f3, new Object[] {
            j()
        });
        if (g())
        {
            setContentDescription(s1);
        } else
        {
            setContentDescription(getResources().getString(0x7f0b01f4, new Object[] {
                s1
            }));
        }
        return super.onHoverEvent(motionevent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(com/google/android/apps/youtube/kids/ui/TimeBar.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(com/google/android/apps/youtube/kids/ui/TimeBar.getName());
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = (int)(e.density * 8F);
        if (e() || v)
        {
            k1 = (int)(40F * e.density);
        }
        int i2 = getDefaultSize(0, i1);
        i1 = resolveSize(k1, j1);
        setMeasuredDimension(i2, i1);
        if (!e() && !v)
        {
            g.set(0, 0, i2, i1);
        } else
        {
            u = i1 / 2 - o.getIntrinsicHeight() / 2;
            j1 = (int)(e.density * 8F);
            int l1 = i1 / 2 - j1 / 2;
            Rect rect = g;
            int j2 = getPaddingLeft();
            int k2 = r;
            if (g())
            {
                i1 = s;
            } else
            {
                i1 = -D;
            }
            rect.set(i1 + (k2 + j2), l1, i2 - getPaddingRight() - r, j1 + l1);
        }
        b();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled() || g()) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = (int)motionevent.getX();
        i1 = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 64
    //                   0 66
    //                   1 284
    //                   2 252
    //                   3 284;
           goto _L2 _L3 _L4 _L5 _L4
_L2:
        return false;
_L3:
        float f1 = j1;
        float f2 = i1;
        i1 = u;
        int k1 = o.getIntrinsicHeight();
        int l1 = g.left;
        int i2 = o.getIntrinsicWidth();
        int j2 = g.right;
        int k2 = o.getIntrinsicWidth();
        boolean flag;
        if ((float)(l1 - i2) < f1 && f1 < (float)(j2 + k2) && (float)(u - p) < f2 && f2 < (float)(p + (i1 + k1)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            a(j1);
            z = f();
            if (a != null)
            {
                a.onScrubbingStart();
            }
            c();
            b();
            invalidate();
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (b)
        {
            a(j1);
            z = f();
            b();
            invalidate();
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (b)
        {
            h();
            y = z;
            if (a != null)
            {
                a.onScrubbingEnd(f());
            }
            setContentDescription(j());
            sendAccessibilityEvent(32768);
            return true;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        c();
    }

}
