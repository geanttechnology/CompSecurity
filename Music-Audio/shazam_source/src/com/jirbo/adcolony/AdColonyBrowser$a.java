// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

// Referenced classes of package com.jirbo.adcolony:
//            AdColonyBrowser, c

final class b extends View
{

    Rect a;
    Paint b;
    final AdColonyBrowser c;

    private static boolean a(c c1, int i, int j)
    {
        return i < c1.e.left + c1.f + 16 && i > c1.e.left - 16 && j < c1.e.top + c1.g + 16 && j > c1.e.top - 16;
    }

    public final void a()
    {
        c.o = false;
        c.p = false;
        c.q = false;
        c.r = false;
        invalidate();
    }

    public final void onDraw(Canvas canvas)
    {
        getDrawingRect(a);
        int i = (c.m.getHeight() - c.d.g) / 2;
        if (!AdColonyBrowser.w)
        {
            c.d.a(canvas, c.d.f, i);
        } else
        {
            c.k.a(canvas, c.d.f, i);
        }
        if (!AdColonyBrowser.x)
        {
            c.g.a(canvas, c.d.e.left + c.m.getWidth() / 10 + c.d.f, i);
        } else
        {
            c.l.a(canvas, c.d.e.left + c.m.getWidth() / 10 + c.d.f, i);
        }
        if (AdColonyBrowser.y)
        {
            c.e.a(canvas, c.g.e.left + c.g.f + c.m.getWidth() / 10, i);
        } else
        {
            c.f.a(canvas, c.g.e.left + c.g.f + c.m.getWidth() / 10, i);
        }
        c.h.a(canvas, c.m.getWidth() - c.h.f * 2, i);
        if (c.o)
        {
            c.i.b((c.d.e.left - c.i.f / 2) + c.d.f / 2, (c.d.e.top - c.i.g / 2) + c.d.g / 2);
            c.i.a(canvas);
        }
        if (c.p)
        {
            c.i.b((c.g.e.left - c.i.f / 2) + c.g.f / 2, (c.g.e.top - c.i.g / 2) + c.g.g / 2);
            c.i.a(canvas);
        }
        if (c.q)
        {
            c.i.b((c.f.e.left - c.i.f / 2) + c.f.f / 2, (c.f.e.top - c.i.g / 2) + c.f.g / 2);
            c.i.a(canvas);
        }
        if (c.r)
        {
            c.i.b((c.h.e.left - c.i.f / 2) + c.h.f / 2, (c.h.e.top - c.i.g / 2) + c.h.g / 2);
            c.i.a(canvas);
        }
        canvas = new android.widget.outParams(c.s.getWidth(), c.s.getHeight());
        canvas.topMargin = (c.m.getHeight() - c.e.g) / 2;
        canvas.leftMargin = c.m.getWidth() / 10 + c.e.e.left + c.e.f;
        if (AdColonyBrowser.A && c.e.e.left != 0)
        {
            c.n.removeView(c.s);
            c.n.addView(c.s, canvas);
            AdColonyBrowser.A = false;
        }
        if (c.s.getLayoutParams() != null)
        {
            c.s.getLayoutParams().height = c.e.g;
            c.s.getLayoutParams().width = c.e.f;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        if (i == 0)
        {
            if (a(c.d, j, k) && AdColonyBrowser.w)
            {
                c.o = true;
                invalidate();
                return true;
            }
            if (a(c.g, j, k) && AdColonyBrowser.x)
            {
                c.p = true;
                invalidate();
                return true;
            }
            if (a(c.f, j, k))
            {
                c.q = true;
                invalidate();
                return true;
            }
            if (a(c.h, j, k))
            {
                c.r = true;
                invalidate();
                return true;
            }
        }
        if (i == 1)
        {
            if (a(c.d, j, k) && AdColonyBrowser.w)
            {
                c.c.goBack();
                a();
                return true;
            }
            if (a(c.g, j, k) && AdColonyBrowser.x)
            {
                c.c.goForward();
                a();
                return true;
            }
            if (a(c.f, j, k) && AdColonyBrowser.y)
            {
                c.c.stopLoading();
                a();
                return true;
            }
            if (a(c.f, j, k) && !AdColonyBrowser.y)
            {
                c.c.reload();
                a();
                return true;
            }
            if (a(c.h, j, k))
            {
                AdColonyBrowser.D = true;
                c.c.loadData("", "text/html", "utf-8");
                AdColonyBrowser.x = false;
                AdColonyBrowser.w = false;
                AdColonyBrowser.y = false;
                a();
                c.finish();
                return true;
            }
            a();
        }
        return false;
    }

    public arams(AdColonyBrowser adcolonybrowser, Activity activity)
    {
        c = adcolonybrowser;
        super(activity);
        a = new Rect();
        b = new Paint();
    }
}
