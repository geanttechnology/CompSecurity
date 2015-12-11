// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.player.overlay;

import a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import aw;
import b;
import bmc;
import bmo;
import cve;
import cvg;
import java.util.Map;
import s;

public class TimeBar extends View
{

    private static final int j[] = {
        0xfefeff62
    };
    private int A;
    private int B;
    private int C;
    private String D;
    private int E;
    private final Rect F;
    public s a;
    public final Paint b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public Map i;
    private final DisplayMetrics k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private final Paint p;
    private final Paint q;
    private final Paint r;
    private final Paint s;
    private final StateListDrawable t;
    private final int u;
    private final int v;
    private final int w;
    private int x;
    private int y;
    private int z;

    public TimeBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        k = context.getResources().getDisplayMetrics();
        d = true;
        e = true;
        f = true;
        l = new Rect();
        m = new Rect();
        n = new Rect();
        o = new Rect();
        p = new Paint();
        p.setColor(Color.parseColor("#B2212121"));
        q = new Paint();
        q.setColor(Color.parseColor("#B2777777"));
        b = new Paint();
        s = new Paint();
        s.setColor(Color.parseColor("#B2FFFF00"));
        float f1 = k.density;
        F = new Rect();
        r = new Paint(1);
        r.setTypeface(bmc.b.a(context));
        r.setShadowLayer(6F, 1.0F, 1.0F, Color.parseColor("#50000000"));
        r.setColor(-1);
        r.setTextSize(f1 * 12F);
        r.setTextAlign(android.graphics.Paint.Align.CENTER);
        r.getTextBounds("0:00:00", 0, 7, F);
        D = a(0L);
        t = (StateListDrawable)aw.a(context, 0x7f020220);
        u = (int)(k.density * 13F);
        v = (int)(k.density * 10F);
        w = (int)(k.density * -50F);
        d();
    }

    public TimeBar(Context context, s s1)
    {
        this(context, ((AttributeSet) (null)));
        a = (s)b.a(s1);
    }

    private String a(long l1)
    {
        byte byte0 = 3;
        if (A < 0x36ee80) goto _L2; else goto _L1
_L1:
        byte0 = 5;
_L4:
        return a.a((int)l1 / 1000, byte0);
_L2:
        if (A >= 60000)
        {
            byte0 = 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(float f1)
    {
        int i1 = t.getIntrinsicWidth() / 2;
        int j1 = l.right;
        int k1 = l.left;
        y = (int)f1 - i1;
        y = Math.min(j1 - i1, Math.max(k1 - i1, y));
    }

    private void c()
    {
        if (c && !isEnabled())
        {
            f();
            a();
            return;
        }
        StateListDrawable statelistdrawable = t;
        int ai[];
        if (c)
        {
            ai = PRESSED_ENABLED_FOCUSED_STATE_SET;
        } else
        if (isEnabled())
        {
            ai = ENABLED_STATE_SET;
        } else
        {
            ai = j;
        }
        statelistdrawable.setState(ai);
    }

    private void d()
    {
        x = F.width() + (v << 1) + t.getIntrinsicWidth() / 2;
    }

    private boolean e()
    {
        return d && A > 0;
    }

    private void f()
    {
        c = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        c();
        invalidate();
    }

    public void a()
    {
        m.set(l);
        n.set(l);
        o.set(l);
        int i1;
        if (c)
        {
            i1 = C;
        } else
        {
            i1 = B;
        }
        if (A > 0)
        {
            int j1 = (int)(((long)l.width() * (long)h) / (long)A);
            m.right = j1 + l.left;
            j1 = (int)(((long)l.width() * (long)B) / (long)A);
            n.right = j1 + l.left;
            long l1 = l.width();
            y = (int)(((long)i1 * l1) / (long)A) + (l.left - t.getIntrinsicWidth() / 2);
        } else
        {
            m.right = l.left;
            n.right = l.left;
            y = l.left - t.getIntrinsicWidth() / 2;
        }
        invalidate();
    }

    public final void a(int i1, int j1, int k1)
    {
        if (B != i1 || A != j1 || h != k1)
        {
            if (A != j1)
            {
                A = j1;
                D = a(j1);
                r.getTextBounds(D, 0, D.length(), F);
                d();
                c();
            }
            B = i1;
            h = k1;
            a();
        }
    }

    public int b()
    {
        if (l.width() <= 0)
        {
            return 0;
        } else
        {
            return (int)(((long)((y + t.getIntrinsicWidth() / 2) - l.left) * (long)A) / (long)l.width());
        }
    }

    public void draw(Canvas canvas)
    {
        bmo.a();
        super.draw(canvas);
        canvas.drawRect(l, p);
        if (f)
        {
            canvas.drawRect(m, q);
        }
        canvas.drawRect(n, b);
        if (e)
        {
            t.setBounds(y, z, y + t.getIntrinsicWidth(), z + t.getIntrinsicHeight());
            t.draw(canvas);
        }
        if (e())
        {
            cve acve[];
            cve cve1;
            int i1;
            int j1;
            int k1;
            long l1;
            if (c)
            {
                l1 = C;
            } else
            {
                l1 = B;
            }
            canvas.drawText(a(l1), (x * 3) / 7, getHeight() / 2 + F.height() / 2, r);
            canvas.drawText(D, getWidth() - (x * 3) / 7, getHeight() / 2 + F.height() / 2, r);
        }
        if (g && i != null && A > 0)
        {
            acve = (cve[])i.get(cvg.a);
            if (acve != null)
            {
                j1 = acve.length;
                for (i1 = 0; i1 < j1; i1++)
                {
                    cve1 = acve[i1];
                    k1 = (int)((Math.min(A, Math.max(0L, cve1.a)) * (long)l.width()) / (long)A - 2L);
                    o.left = k1 + l.left;
                    o.right = o.left + 4;
                    canvas.drawRect(o, s);
                }

            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = (int)(k.density * 4F);
        if (e() || e)
        {
            k1 = (int)(40F * k.density);
        }
        i1 = getDefaultSize(0, i1);
        k1 = resolveSize(k1, j1);
        setMeasuredDimension(i1, k1);
        if (!e() && !e)
        {
            l.set(0, 0, i1, k1);
        } else
        {
            z = k1 / 2 - t.getIntrinsicHeight() / 2;
            j1 = (int)(k.density * 4F);
            k1 = k1 / 2 - j1 / 2;
            l.set(getPaddingLeft() + x, k1, i1 - getPaddingRight() - x, j1 + k1);
        }
        a();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (!isEnabled()) goto _L2; else goto _L1
_L1:
        int i1;
        int k1;
        k1 = (int)motionevent.getX();
        i1 = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 60
    //                   0 66
    //                   1 325
    //                   2 248
    //                   3 325;
           goto _L2 _L3 _L4 _L5 _L4
_L2:
        flag = false;
_L9:
        return flag;
_L3:
        float f1 = k1;
        float f2 = i1;
        i1 = z;
        int l1 = t.getIntrinsicHeight();
        int j2 = l.left;
        int k2 = t.getIntrinsicWidth();
        int l2 = l.right;
        int i3 = t.getIntrinsicWidth();
        if ((float)(j2 - k2) < f1 && f1 < (float)(l2 + i3) && (float)(z - u) < f2 && f2 < (float)(u + (i1 + l1)))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L2; else goto _L6
_L6:
        c = true;
        getParent().requestDisallowInterceptTouchEvent(true);
        a(k1);
        C = b();
        if (a != null)
        {
            motionevent = a;
        }
        c();
        a();
        invalidate();
        return true;
_L5:
        if (!c) goto _L2; else goto _L7
_L7:
        if (i1 < w)
        {
            int j1 = E;
            int i2 = E;
            a((k1 - j1) / 3 + i2);
        } else
        {
            E = k1;
            a(k1);
        }
        C = b();
        a();
        invalidate();
        return true;
_L4:
        if (!c) goto _L2; else goto _L8
_L8:
        f();
        B = C;
        if (a != null)
        {
            motionevent = a;
            b();
            return true;
        }
          goto _L9
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        c();
    }

}
