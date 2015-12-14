// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.input.a;
import com.socialin.android.brushlib.input.d;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.e;
import com.socialin.android.util.Geom;

public final class b
    implements com.socialin.android.brushlib.input.b, d
{

    public boolean a;
    private a b;
    private final DrawingView c;
    private boolean d;
    private RectF e;
    private PointF f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;

    public b(DrawingView drawingview)
    {
        e = new RectF();
        b = new a(this);
        a = false;
        c = drawingview;
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        d = false;
        b.a(motionevent);
        if (d)
        {
            return TouchResponse.ACCEPT;
        } else
        {
            return TouchResponse.UNDEFINED;
        }
    }

    public final void a(RectF rectf, RectF rectf1)
    {
        float f1;
        float f2 = 5F;
        Camera camera;
        if (rectf1.width() / rectf.width() < rectf1.height() / rectf.height())
        {
            f1 = rectf1.width() / rectf.width();
        } else
        {
            f1 = rectf1.height() / rectf.height();
        }
        if (f1 <= 5F) goto _L2; else goto _L1
_L1:
        f1 = f2;
_L4:
        camera = c.d;
        camera.a(f1);
        camera.c = rectf.centerX() + (camera.a / 2.0F - rectf1.centerX()) / f1;
        camera.b();
        f2 = rectf.centerY();
        camera.d = (camera.b / 2.0F - rectf1.centerY()) / f1 + f2;
        camera.b();
        return;
_L2:
        if (f1 < 0.1F)
        {
            f1 = 0.1F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void d()
    {
    }

    public final void onLongPress(PointF pointf)
    {
    }

    public final void onPan(PointF pointf)
    {
        if (a && pointf != null && f != null)
        {
            float f1 = pointf.x;
            float f2 = f.x;
            float f3 = pointf.y;
            float f4 = f.y;
            e.set(c.j());
            pointf = c.d;
            pointf.b(g - (f1 - f2) / ((Camera) (pointf)).e, h - (f3 - f4) / ((Camera) (pointf)).e);
            e.union(c.j());
            c.a(true);
            d = true;
        }
    }

    public final void onPanEnd(PointF pointf)
    {
    }

    public final void onPanStart(PointF pointf)
    {
        if (a)
        {
            d = true;
            f = new PointF(pointf.x, pointf.y);
            g = c.d.c;
            h = c.d.d;
        }
    }

    public final void onPinch(PointF pointf, PointF pointf1)
    {
        float f1 = 0.1F;
        if (o)
        {
            if (c.o != null)
            {
                c.o.a();
            }
            o = false;
        }
        float f2 = Geom.a(pointf, pointf1);
        if (i != 0.0F)
        {
            f2 = (f2 / i) * j;
            float f3;
            float f4;
            float f5;
            float f6;
            if (f2 >= 0.1F)
            {
                if (f2 > 5F)
                {
                    f1 = 5F;
                } else
                {
                    f1 = f2;
                }
            }
            f2 = (pointf.x + pointf1.x) / 2.0F;
            f3 = m;
            f4 = (pointf.y + pointf1.y) / 2.0F;
            f5 = n;
            f6 = c.d.e;
            e.set(c.j());
            pointf = c.d;
            pointf.b(k - (f2 - f3) / f6, l - (f4 - f5) / f6);
            pointf.a(f1);
            e.union(c.j());
            c.a(true);
            d = true;
            if (c.o != null)
            {
                c.o.a((int)(f1 * 100F));
            }
            return;
        } else
        {
            d = false;
            return;
        }
    }

    public final void onPinchEnd(PointF pointf, PointF pointf1)
    {
        if (c.o != null)
        {
            c.o.b();
        }
        o = false;
    }

    public final void onPinchStart(PointF pointf, PointF pointf1)
    {
        i = Geom.a(pointf, pointf1);
        j = c.d.e;
        k = c.d.c;
        l = c.d.d;
        m = (pointf.x + pointf1.x) / 2.0F;
        n = (pointf.y + pointf1.y) / 2.0F;
        o = true;
    }

    public final void onTap(PointF pointf)
    {
    }
}
