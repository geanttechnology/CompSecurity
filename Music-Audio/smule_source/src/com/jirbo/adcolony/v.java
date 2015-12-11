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
//            AdColonyBrowser, m

class v extends View
{

    Rect a;
    Paint b;
    final AdColonyBrowser c;

    public v(AdColonyBrowser adcolonybrowser, Activity activity)
    {
        c = adcolonybrowser;
        super(activity);
        a = new Rect();
        b = new Paint();
    }

    public void a()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(c.s.getWidth(), c.s.getHeight());
        layoutparams.topMargin = (c.m.getHeight() - c.e.g) / 2;
        layoutparams.leftMargin = c.m.getWidth() / 10 + c.e.b() + c.e.f;
        if (AdColonyBrowser.A && c.e.b() != 0)
        {
            c.n.removeView(c.s);
            c.n.addView(c.s, layoutparams);
            AdColonyBrowser.A = false;
        }
        if (c.s.getLayoutParams() == null)
        {
            return;
        } else
        {
            c.s.getLayoutParams().height = c.e.g;
            c.s.getLayoutParams().width = c.e.f;
            return;
        }
    }

    public boolean a(m m1, int i, int j)
    {
        return i < m1.b() + m1.f + 16 && i > m1.b() - 16 && j < m1.c() + m1.g + 16 && j > m1.c() - 16;
    }

    public void b()
    {
        c.o = false;
        c.p = false;
        c.q = false;
        c.r = false;
        invalidate();
    }

    public void onDraw(Canvas canvas)
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
            c.g.a(canvas, c.d.b() + c.m.getWidth() / 10 + c.d.f, i);
        } else
        {
            c.l.a(canvas, c.d.b() + c.m.getWidth() / 10 + c.d.f, i);
        }
        if (AdColonyBrowser.y)
        {
            c.e.a(canvas, c.g.b() + c.g.f + c.m.getWidth() / 10, i);
        } else
        {
            c.f.a(canvas, c.g.b() + c.g.f + c.m.getWidth() / 10, i);
        }
        c.h.a(canvas, c.m.getWidth() - c.h.f * 2, i);
        if (c.o)
        {
            c.i.c((c.d.b() - c.i.f / 2) + c.d.f / 2, (c.d.c() - c.i.g / 2) + c.d.g / 2);
            c.i.a(canvas);
        }
        if (c.p)
        {
            c.i.c((c.g.b() - c.i.f / 2) + c.g.f / 2, (c.g.c() - c.i.g / 2) + c.g.g / 2);
            c.i.a(canvas);
        }
        if (c.q)
        {
            c.i.c((c.f.b() - c.i.f / 2) + c.f.f / 2, (c.f.c() - c.i.g / 2) + c.f.g / 2);
            c.i.a(canvas);
        }
        if (c.r)
        {
            c.i.c((c.h.b() - c.i.f / 2) + c.h.f / 2, (c.h.c() - c.i.g / 2) + c.h.g / 2);
            c.i.a(canvas);
        }
        a();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
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
                b();
                return true;
            }
            if (a(c.g, j, k) && AdColonyBrowser.x)
            {
                c.c.goForward();
                b();
                return true;
            }
            if (a(c.f, j, k) && AdColonyBrowser.y)
            {
                c.c.stopLoading();
                b();
                return true;
            }
            if (a(c.f, j, k) && !AdColonyBrowser.y)
            {
                c.c.reload();
                b();
                return true;
            }
            if (a(c.h, j, k))
            {
                AdColonyBrowser.D = true;
                c.c.loadData("", "text/html", "utf-8");
                AdColonyBrowser.x = false;
                AdColonyBrowser.w = false;
                AdColonyBrowser.y = false;
                b();
                c.finish();
                return true;
            }
            b();
        }
        return false;
    }
}
