// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.Toast;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.e;
import com.socialin.android.brushlib.brush.f;
import com.socialin.android.brushlib.brush.g;
import com.socialin.android.brushlib.brush.i;
import com.socialin.android.brushlib.brush.j;
import com.socialin.android.brushlib.brush.k;
import com.socialin.android.brushlib.brush.l;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.b;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.DrawPathAction;
import com.socialin.android.videogenerator.actions.DummyAction;
import com.socialin.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.socialin.android.brushlib.a
    implements com.socialin.android.brushlib.view.a, b
{

    public static boolean b = false;
    private SparseIntArray A;
    private boolean B;
    public Brush c;
    public com.socialin.android.brushlib.brush.Brush.Params d;
    public DrawingView e;
    public Map f;
    public Map g;
    public int h;
    private final float i;
    private Stroke j;
    private RectF k;
    private PointF l;
    private PointF m;
    private boolean n;
    private float o;
    private float p;
    private PointF q;
    private PointF r;
    private long s;
    private PointF t;
    private long u;
    private float v;
    private boolean w;
    private int x;
    private long y;
    private long z;

    public a(DrawingView drawingview)
    {
        k = new RectF();
        l = new PointF();
        m = new PointF();
        n = false;
        q = new PointF();
        r = new PointF();
        t = new PointF();
        w = false;
        d = new com.socialin.android.brushlib.brush.Brush.Params();
        f = new HashMap();
        g = new HashMap();
        y = 0x3b9aca00L;
        A = new SparseIntArray();
        h = 0;
        e = drawingview;
        drawingview.a(this);
        i = drawingview.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    private float a(float f1, float f2, long l1)
    {
        f1 -= r.x;
        f2 -= r.y;
        return ((float)Math.sqrt(f1 * f1 + f2 * f2) * (1000F / i)) / (float)(l1 - s);
    }

    private void a(float f1, float f2, long l1, float f3, float f4)
    {
        Canvas canvas;
        if (j == null)
        {
            return;
        }
        j.addPoint(f1, f2, f4, f3);
        if (e.r)
        {
            if (e.c.j.d == e.c.b)
            {
                canvas = e.c.j.b;
            } else
            {
                canvas = e.c.b.j;
            }
        } else
        {
            canvas = e.c.b.j;
        }
        w = true;
        c.c();
        JVM INSTR lookupswitch 11: default 184
    //                   0: 251
    //                   1: 719
    //                   2: 422
    //                   4: 484
    //                   5: 619
    //                   6: 669
    //                   7: 251
    //                   8: 529
    //                   21: 878
    //                   22: 928
    //                   28: 828;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L2 _L8 _L9 _L10 _L11
_L1:
        s = l1;
        e.d.a(k);
        e.a(k);
        return;
_L2:
        m.set((q.x + f1) / 2.0F, (q.y + f2) / 2.0F);
        k.set(l.x, l.y, q.x, q.y);
        k.sort();
        k.union(m.x, m.y);
        c.b(d);
        f2 = -Math.max(d.getThickness(), d.getThickness() * d.getHardness());
        f1 = f2;
        if (b)
        {
            f1 = f2 * c.a();
        }
        k.inset(f1, f1);
        l.set(m);
        continue; /* Loop/switch isn't completed */
_L4:
        j.computeBounds(k, true);
        c.b(d);
        f2 = -d.getThickness();
        f1 = f2;
        if (b)
        {
            f1 = f2 * c.a();
        }
        k.inset(f1, f1);
        continue; /* Loop/switch isn't completed */
_L5:
        p = j.getStrokeLength();
        c.a(o, p, j, k);
        o = p;
        continue; /* Loop/switch isn't completed */
_L8:
        p = j.getLength();
        ((e)c).a(o, p, j, canvas, k);
        o = p;
        c.b(d);
        f1 = -d.getThickness() / e.d.e;
        k.inset(f1, f1);
        continue; /* Loop/switch isn't completed */
_L6:
        p = j.getLength();
        ((g)c).a(o, p, j, canvas, k);
        o = p;
        continue; /* Loop/switch isn't completed */
_L7:
        p = j.getLength();
        ((i)c).a(o, p, j, canvas, k);
        o = p;
        continue; /* Loop/switch isn't completed */
_L3:
        p = j.getLength();
        c.a(1.0F / e.d.e);
        ((l)c).a(o, p, j, canvas, k);
        o = p;
        c.b(d);
        f1 = -d.getThickness() / e.d.e;
        k.inset(f1, f1);
        continue; /* Loop/switch isn't completed */
_L11:
        p = j.getLength();
        ((k)c).a(j, o, p, canvas, k);
        o = p;
        continue; /* Loop/switch isn't completed */
_L9:
        p = j.getLength();
        ((j)c).a(j, o, p, canvas, k);
        o = p;
        continue; /* Loop/switch isn't completed */
_L10:
        p = j.getLength();
        ((f)c).a(j, o, p, canvas, k);
        o = p;
        if (true) goto _L1; else goto _L12
_L12:
    }

    private static void a(Brush brush, float f1)
    {
        switch (brush.c())
        {
        default:
            return;

        case 0: // '\0'
        case 2: // '\002'
        case 4: // '\004'
        case 7: // '\007'
            if (b)
            {
                brush.a(1.0F / f1);
                return;
            } else
            {
                brush.a(1.0F);
                return;
            }

        case 5: // '\005'
            ((g)brush).h();
            if (b)
            {
                brush.a(1.0F / f1);
                return;
            } else
            {
                brush.a(1.0F);
                return;
            }

        case 6: // '\006'
            ((i)brush).h();
            if (b)
            {
                brush.a(f1);
                return;
            } else
            {
                brush.a(1.0F);
                return;
            }

        case 1: // '\001'
        case 8: // '\b'
        case 21: // '\025'
        case 22: // '\026'
        case 28: // '\034'
            break;
        }
        if (b)
        {
            brush.a(1.0F / f1);
            return;
        } else
        {
            brush.a(1.0F);
            return;
        }
    }

    private void a(Brush brush, boolean flag)
    {
        Object obj;
        if (e.r)
        {
            if (e.c.j.d == e.c.b)
            {
                obj = e.c.j;
            } else
            {
                obj = e.c.b;
            }
        } else
        {
            obj = e.c.b;
        }
        if (flag)
        {
            brush.a(j, ((com.socialin.android.brushlib.layer.a) (obj)).b());
        }
        e.c.a(((com.socialin.android.brushlib.layer.a) (obj)));
        if (obj instanceof com.socialin.android.brushlib.layer.b)
        {
            ActionCollector.a().a(new DrawPathAction(UUID.fromString(((com.socialin.android.brushlib.layer.a) (obj)).f()), j, brush, e.c.f.d().key, brush.a()));
        } else
        if (obj instanceof CameraMaskLayer)
        {
            ActionCollector.a().a(new DummyAction(e.c.f.d().key));
            return;
        }
    }

    private void e()
    {
        if (!w) goto _L2; else goto _L1
_L1:
        float f1;
        Object obj;
        B = false;
        w = false;
        int i1 = c.c();
        Object obj1;
        if (i1 == 5)
        {
            obj = ((g)c).i();
        } else
        if (i1 == 6)
        {
            obj = ((i)c).k();
        } else
        {
            obj = c.d();
        }
        if (b)
        {
            ((Brush) (obj)).a(1.0F / e.d.e);
        } else
        if (i1 != 1)
        {
            ((Brush) (obj)).a(1.0F);
        }
        obj1 = e.c.f;
        i1;
        JVM INSTR lookupswitch 7: default 144
    //                   1: 371
    //                   5: 371
    //                   6: 371
    //                   8: 371
    //                   21: 371
    //                   22: 371
    //                   28: 371;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        a(((Brush) (obj)), true);
_L8:
        if (b)
        {
            f1 = 1.0F / e.d.e;
        } else
        {
            f1 = 1.0F;
        }
        c.c();
        JVM INSTR tableswitch 0 7: default 224
    //                   0 380
    //                   1 224
    //                   2 380
    //                   3 224
    //                   4 430
    //                   5 224
    //                   6 224
    //                   7 380;
           goto _L5 _L6 _L5 _L6 _L5 _L7 _L5 _L5 _L6
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_430;
_L9:
        if (e.c.h == com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE)
        {
            obj = c.e();
            obj1 = g;
            float f2;
            long l1;
            if (g.containsKey(obj))
            {
                l1 = ((Long)g.get(obj)).longValue() + (System.nanoTime() - z) / y;
            } else
            {
                l1 = (System.nanoTime() - z) / y;
            }
            ((Map) (obj1)).put(obj, Long.valueOf(l1));
        } else
        {
            String s1 = c.e();
            Map map = f;
            long l2;
            if (f.containsKey(s1))
            {
                l2 = ((Long)f.get(s1)).longValue() + (System.nanoTime() - z) / y;
            } else
            {
                l2 = (System.nanoTime() - z) / y;
            }
            map.put(s1, Long.valueOf(l2));
        }
        e.a(k);
_L2:
        return;
_L4:
        a(((Brush) (obj)), false);
          goto _L8
_L6:
        j.computeBounds(k, true);
        c.b(d);
        f1 = (f1 * -d.getThickness()) / 2.0F - 1.0F;
        k.inset(f1, f1);
          goto _L9
        f2 = c.a();
        c.a(f1);
        c.a(0.0F, j.getStrokeLength(), j, k);
        c.a(f2);
          goto _L9
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        boolean flag;
        int l2;
        if (c == null)
        {
            return TouchResponse.REJECT;
        }
        int i2 = motionevent.getActionMasked();
        l2 = motionevent.getActionIndex();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            int i1 = motionevent.getToolType(l2);
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
        i2;
        JVM INSTR tableswitch 0 6: default 100
    //                   0 116
    //                   1 1410
    //                   2 560
    //                   3 100
    //                   4 100
    //                   5 504
    //                   6 535;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return TouchResponse.UNDEFINED;
_L2:
        if (e.c.b.g())
        {
            Toast.makeText(e.getContext(), 0x7f080406, 0).show();
            return TouchResponse.REJECT;
        }
        x = motionevent.getPointerId(0);
        float f4 = motionevent.getX(0);
        float f7 = motionevent.getY(0);
        long l3 = motionevent.getEventTime();
        float f1 = motionevent.getPressure(0);
        n = true;
        t.set(f4, f7);
        u = l3;
        s = l3;
        v = f1;
        z = System.nanoTime();
        int j2;
        if (c instanceof k)
        {
            j2 = ((k)c).d;
        } else
        {
            j2 = c.c();
        }
        if (A.get(j2) == 0)
        {
            h = h + 1;
            A.put(j2, 1);
        }
        if (flag)
        {
            motionevent = new PointF(f4, f7);
            e.d.a(motionevent, motionevent);
            o = 0.0F;
            PointF pointf = new PointF(t.x, t.y);
            e.d.a(pointf, pointf);
            f4 = a(f4, f7, l3);
            j = Stroke.obtain();
            j.setStartPoint(pointf.x, pointf.y, v, 0.0F);
            n = false;
            l.set(pointf.x, pointf.y);
            r.set(t.x, t.y);
            q.set(pointf);
            a(c, e.d.e);
            a(((PointF) (motionevent)).x, ((PointF) (motionevent)).y, l3, f1, f4);
            motionevent = TouchResponse.ACCEPT;
        } else
        {
            motionevent = TouchResponse.UNDEFINED;
        }
        B = true;
        return motionevent;
_L5:
        if (w)
        {
            motionevent = TouchResponse.REJECT;
            e();
            return motionevent;
        } else
        {
            B = false;
            w = false;
            return TouchResponse.REJECT;
        }
_L6:
        if (motionevent.getPointerId(l2) == x)
        {
            e();
            return TouchResponse.REJECT;
        } else
        {
            return TouchResponse.UNDEFINED;
        }
_L4:
        int k2;
        if (!B)
        {
            return TouchResponse.REJECT;
        }
        k2 = motionevent.findPointerIndex(x);
        if (k2 == -1) goto _L8; else goto _L7
_L7:
        float f2;
        float f5;
        float f8;
        float f9;
        PointF pointf1;
        long l4;
        f2 = motionevent.getX(k2);
        f5 = motionevent.getY(k2);
        l4 = motionevent.getEventTime();
        f8 = motionevent.getPressure(k2);
        pointf1 = new PointF(f2, f5);
        e.d.a(pointf1, pointf1);
        f9 = a(f2, f5, l4);
        l2 = motionevent.getHistorySize();
        if (!flag) goto _L10; else goto _L9
_L9:
        for (int j1 = 0; j1 < l2; j1++)
        {
            float f10 = motionevent.getHistoricalX(k2, j1);
            float f14 = motionevent.getHistoricalY(k2, j1);
            long l5 = motionevent.getHistoricalEventTime(j1);
            pointf1.set(f10, f14);
            e.d.a(pointf1, pointf1);
            a(pointf1.x, pointf1.y, l5, motionevent.getHistoricalPressure(k2, j1), f9);
            r.set(f10, f14);
            q.set(pointf1);
        }

        pointf1.set(f2, f5);
        e.d.a(pointf1, pointf1);
        a(pointf1.x, pointf1.y, l4, f8, f9);
        r.set(f2, f5);
        q.set(pointf1);
_L11:
        return TouchResponse.ACCEPT;
_L10:
        if (n)
        {
            float f11 = com.socialin.android.util.l.a(f2, f5, t.x, t.y);
            long l6 = u;
            if (f11 >= DrawingView.a && l4 - l6 >= 30L)
            {
                n = false;
                o = 0.0F;
                PointF pointf3 = new PointF(t.x, t.y);
                e.d.a(pointf3, pointf3);
                j = Stroke.obtain();
                j.setStartPoint(pointf3.x, pointf3.y, v, 0.0F);
                n = false;
                l.set(pointf3.x, pointf3.y);
                r.set(t.x, t.y);
                q.set(pointf3);
                a(c, e.d.e);
                for (int k1 = 0; k1 < l2; k1++)
                {
                    float f12 = motionevent.getHistoricalX(k2, k1);
                    float f15 = motionevent.getHistoricalY(k2, k1);
                    long l7 = motionevent.getHistoricalEventTime(k1);
                    float f17 = motionevent.getHistoricalPressure(k2, k1);
                    pointf1.set(f12, f15);
                    e.d.a(pointf1, pointf1);
                    a(pointf1.x, pointf1.y, l7, f17, f9);
                    r.set(f12, f15);
                    q.set(pointf1);
                }

                pointf1.set(f2, f5);
                e.d.a(pointf1, pointf1);
                a(pointf1.x, pointf1.y, l4, f8, f9);
            } else
            {
                return TouchResponse.UNDEFINED;
            }
        } else
        if (com.socialin.android.util.l.a(f2, f5, t.x, t.y) >= DrawingView.a)
        {
            for (int l1 = 0; l1 < l2; l1++)
            {
                float f13 = motionevent.getHistoricalX(k2, l1);
                float f16 = motionevent.getHistoricalY(k2, l1);
                long l8 = motionevent.getHistoricalEventTime(l1);
                pointf1.set(f13, f16);
                e.d.a(pointf1, pointf1);
                a(pointf1.x, pointf1.y, l8, f8, f9);
                r.set(f13, f16);
                q.set(pointf1);
            }

            pointf1.set(f2, f5);
            e.d.a(pointf1, pointf1);
            a(pointf1.x, pointf1.y, l4, f8, f9);
            r.set(f2, f5);
            q.set(pointf1);
        }
        if (true) goto _L11; else goto _L8
_L8:
        return TouchResponse.REJECT;
_L3:
        float f3 = motionevent.getX();
        float f6 = motionevent.getY();
        PointF pointf2 = new PointF(f3, f6);
        e.d.a(pointf2, pointf2);
        f3 = a(f3, f6, motionevent.getEventTime());
        if (w)
        {
            a(pointf2.x, pointf2.y, motionevent.getEventTime(), motionevent.getPressure(), f3);
        }
        e();
        return TouchResponse.REJECT;
    }

    public final void a()
    {
        w = false;
        B = false;
    }

    public final void a(int i1)
    {
        if (d != null)
        {
            d.setColorRGB(i1);
        }
        if (c != null)
        {
            c.a(d);
        }
    }

    public final void a(Canvas canvas)
    {
    }

    public final void a(Canvas canvas, com.socialin.android.brushlib.layer.b b1)
    {
        if (b1 != e.c.b || !b1.f) goto _L2; else goto _L1
_L1:
        if (!e.r || e.c.j == null || e.c.j.d != b1) goto _L4; else goto _L3
_L3:
        canvas = e.c.j.b;
        if (j == null || j.isRecycled() || !w) goto _L2; else goto _L5
_L5:
        c.c();
        JVM INSTR tableswitch 0 7: default 152
    //                   0 153
    //                   1 152
    //                   2 153
    //                   3 152
    //                   4 153
    //                   5 152
    //                   6 152
    //                   7 153;
           goto _L2 _L6 _L2 _L6 _L2 _L6 _L2 _L2 _L6
_L2:
        return;
_L6:
        c.a(j, canvas);
        return;
_L4:
        if (j != null && !j.isRecycled() && w)
        {
            switch (c.c())
            {
            case 1: // '\001'
            case 3: // '\003'
            case 5: // '\005'
            case 6: // '\006'
            default:
                return;

            case 0: // '\0'
            case 2: // '\002'
            case 4: // '\004'
            case 7: // '\007'
                canvas.save();
                break;
            }
            canvas.clipRect(e.j());
            e.d.a(canvas);
            c.a(j, canvas);
            canvas.restore();
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void a(Brush brush)
    {
        if (brush instanceof com.socialin.android.brushlib.brush.b)
        {
            ((com.socialin.android.brushlib.brush.b)brush).a(e.r);
        }
    }

    public final void a(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        if (w)
        {
            e();
        }
        if (c != null)
        {
            c.a(drawingmode);
        }
    }

    public final JSONObject b()
    {
        Object obj = new Gson();
        try
        {
            obj = new JSONObject(((Gson) (obj)).toJson(f));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((JSONObject) (obj));
    }

    public final JSONObject c()
    {
        Object obj = new Gson();
        try
        {
            obj = new JSONObject(((Gson) (obj)).toJson(g));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((JSONObject) (obj));
    }

    public final void d()
    {
        w = false;
    }

}
