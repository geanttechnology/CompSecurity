// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.widget.Toast;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.TextOverlay;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.textart.DrawTextStyle;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.b;
import com.socialin.android.util.l;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.DummyAction;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import java.util.UUID;

public final class g extends a
    implements com.socialin.android.brushlib.view.a, b
{

    public Parcelable b;
    public DrawTextStyle c;
    public String d;
    private DrawingView e;
    private Paint f;
    private Paint g;
    private PointF h;
    private PointF i;
    private boolean j;
    private boolean k;
    private int l;
    private Stroke m;

    public g(DrawingView drawingview)
    {
        h = new PointF();
        i = new PointF();
        e = drawingview;
    }

    private void a()
    {
        if (super.a == null || !k || m == null) goto _L2; else goto _L1
_L1:
        Object obj;
        TextOverlay textoverlay = (TextOverlay)super.a;
        if (e.r)
        {
            obj = e.c.j;
        } else
        {
            obj = e.c.b;
        }
        if (c.hasGradient)
        {
            textoverlay.setGradients(c.fillColor, c.gradientColor);
        }
        textoverlay.setMode(e.b());
        textoverlay.draw(((com.socialin.android.brushlib.layer.a) (obj)).b());
        e.c.a(((com.socialin.android.brushlib.layer.a) (obj)));
        if (!(obj instanceof com.socialin.android.brushlib.layer.b)) goto _L4; else goto _L3
_L3:
        ActionCollector.a().a(new OverlayAdditionAction(super.a, UUID.fromString(((com.socialin.android.brushlib.layer.a) (obj)).f()), e.c.f.d().key));
_L2:
        m = null;
        a(((Overlay) (null)));
        return;
_L4:
        if (obj instanceof CameraMaskLayer)
        {
            ActionCollector.a().a(new DummyAction(e.c.f.d().key));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(float f1, float f2)
    {
        TextOverlay textoverlay = new TextOverlay(d, new Paint(f), new Paint(g), c.hasBorder, c.textStyleData, c.hasGradient, c.fillColor, c.gradientColor);
        String s = d;
        boolean flag = c.hasGradient;
        int i1 = c.fillColor;
        int j1 = c.gradientColor;
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.getTextBounds(s, 0, s.length(), rect);
        if (flag)
        {
            paint.setShader(new LinearGradient(f1, f2 - (float)rect.height(), f1, f2, i1, j1, android.graphics.Shader.TileMode.CLAMP));
        } else
        {
            paint.setColor(i1);
        }
        textoverlay.setStroke(m);
        a(((Overlay) (textoverlay)));
    }

    private void b(float f1, float f2)
    {
        if (m == null || super.a == null)
        {
            return;
        } else
        {
            m.addPoint(f1, f2, 0.0F, 0.0F);
            ((TextOverlay)super.a).setStroke(m);
            e.a(true);
            return;
        }
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        boolean flag;
        int l1;
        int k1 = motionevent.getActionMasked();
        l1 = motionevent.getActionIndex();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            int i1 = motionevent.getToolType(l1);
            if (i1 == 2 || i1 == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        k1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 116
    //                   1 570
    //                   2 348
    //                   3 88
    //                   4 88
    //                   5 279
    //                   6 311;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        k = false;
        j = false;
        motionevent = TouchResponse.UNDEFINED;
_L8:
        return motionevent;
_L2:
        j = false;
        if (e.c.b.g())
        {
            motionevent = TouchResponse.REJECT;
            Toast.makeText(e.getContext(), 0x7f080406, 0).show();
            return motionevent;
        }
        j = true;
        l = motionevent.getPointerId(0);
        float f1 = motionevent.getX(0);
        float f3 = motionevent.getY(0);
        i.set(f1, f3);
        e.d.a(i, h);
        if (flag)
        {
            m = Stroke.obtain();
            m.setStartPoint(h.x, h.y, 0.0F, 0.0F);
            k = true;
            a(h.x, h.y);
            return TouchResponse.ACCEPT;
        } else
        {
            return TouchResponse.UNDEFINED;
        }
_L5:
        TouchResponse touchresponse;
        touchresponse = TouchResponse.REJECT;
        k = false;
        j = false;
        motionevent = touchresponse;
        if (!k) goto _L8; else goto _L7
_L7:
        a();
        return touchresponse;
_L6:
        if (motionevent.getPointerId(l1) == l)
        {
            a();
            motionevent = TouchResponse.REJECT;
            k = false;
            j = false;
            return motionevent;
        } else
        {
            return TouchResponse.UNDEFINED;
        }
_L4:
        if (j)
        {
            int j1 = motionevent.findPointerIndex(l);
            if (j1 != -1)
            {
                float f2 = motionevent.getX(j1);
                float f4 = motionevent.getY(j1);
                PointF pointf = new PointF(f2, f4);
                e.d.a(pointf, pointf);
                if (k)
                {
                    b(pointf.x, pointf.y);
                    return TouchResponse.ACCEPT;
                }
                f2 = com.socialin.android.util.l.a(f2, f4, i.x, i.y);
                long l2 = motionevent.getEventTime();
                long l3 = motionevent.getDownTime();
                if (f2 >= DrawingView.a && l2 - l3 >= 100L)
                {
                    k = true;
                    m = Stroke.obtain();
                    m.setStartPoint(h.x, h.y, 0.0F, 0.0F);
                    a(h.x, h.y);
                    b(pointf.x, pointf.y);
                    return TouchResponse.ACCEPT;
                } else
                {
                    return TouchResponse.UNDEFINED;
                }
            } else
            {
                return TouchResponse.REJECT;
            }
        } else
        {
            return TouchResponse.REJECT;
        }
_L3:
        motionevent = new PointF(motionevent.getX(), motionevent.getY());
        e.d.a(motionevent, motionevent);
        if (k)
        {
            b(((PointF) (motionevent)).x, ((PointF) (motionevent)).y);
        }
        a();
        motionevent = TouchResponse.REJECT;
        k = false;
        j = false;
        return motionevent;
    }

    public final void a(int i1)
    {
        if (f != null)
        {
            f.setColor(i1);
            c.setFillColor(i1);
        }
    }

    public final void a(Canvas canvas)
    {
    }

    public final void a(Canvas canvas, com.socialin.android.brushlib.layer.b b1)
    {
label0:
        {
            if (e.c.b == b1 && super.a != null && b1.f)
            {
                if (!e.r)
                {
                    break label0;
                }
                canvas = e.c.j.b;
                super.a.draw(canvas);
            }
            return;
        }
        canvas.save();
        canvas.clipRect(e.j());
        e.d.a(canvas);
        super.a.draw(canvas);
        canvas.restore();
    }

    public final void a(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        if (f != null)
        {
            f.setXfermode(drawingmode.xfermode);
        }
        if (g != null)
        {
            g.setXfermode(drawingmode.xfermode);
        }
        if (super.a != null)
        {
            ((TextOverlay)super.a).setMode(drawingmode);
        }
    }

    public final void a(String s, Paint paint, Paint paint1, DrawTextStyle drawtextstyle, Parcelable parcelable)
    {
        f = paint;
        g = paint1;
        c = drawtextstyle;
        d = s;
        b = parcelable;
        paint.setXfermode(e.b().xfermode);
        if (paint1 != null)
        {
            paint1.setXfermode(e.b().xfermode);
        }
    }

    public final void d()
    {
    }
}
