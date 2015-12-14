// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.Toast;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.gizmo.Gizmo;
import com.socialin.android.brushlib.gizmo.SimpleTransformGizmo;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.overlay.ArrowOverlay;
import com.socialin.android.brushlib.overlay.LineOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.overlay.ShapeOverlay;
import com.socialin.android.brushlib.overlay.SvgClipArtOverlay;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.brushlib.svg.ClipArtSvg;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.b;
import com.socialin.android.util.Geom;
import com.socialin.android.videogenerator.ActionCollector;
import com.socialin.android.videogenerator.actions.DummyAction;
import com.socialin.android.videogenerator.actions.OverlayAdditionAction;
import java.util.UUID;

public final class ShapeOverlayController extends a
    implements com.socialin.android.brushlib.view.a, b
{

    public final DrawingView b;
    public Gizmo c;
    public String d;
    public ClipArtSvg e;
    public ShapeType f;
    public ShapeParams g;
    public ShapeEditingMode h;
    private RectF i;
    private RectF j;
    private RectF k;
    private int l;
    private float m;
    private float n;
    private float o;
    private float p;
    private PointF q;
    private boolean r;

    public ShapeOverlayController(DrawingView drawingview)
    {
        i = new RectF();
        j = new RectF();
        k = new RectF();
        q = new PointF();
        b = drawingview;
    }

    private void e()
    {
        Toast.makeText(b.getContext(), 0x7f080406, 0).show();
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        int j1;
        int k1;
        flag = false;
        i1 = motionevent.getActionMasked();
        k1 = motionevent.getActionIndex();
        j1 = motionevent.getPointerId(k1);
        if (h == null) goto _L2; else goto _L1
_L1:
        final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[ShapeEditingMode.values().length];
                try
                {
                    b[ShapeEditingMode.DRAW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[ShapeEditingMode.EDIT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                a = new int[ShapeType.values().length];
                try
                {
                    a[ShapeType.LINE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ShapeType.ARROW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ShapeType.SVG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ShapeType.CLIPART.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.socialin.android.brushlib.controller._cls1.b[h.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 76
    //                   2 620;
           goto _L3 _L4 _L5
_L3:
        motionevent = null;
_L31:
        b.a(true);
        return motionevent;
_L4:
        Object obj = TouchResponse.ACCEPT;
        i1;
        JVM INSTR tableswitch 1 6: default 120
    //                   1 126
    //                   2 192
    //                   3 120
    //                   4 120
    //                   5 599
    //                   6 481;
           goto _L6 _L7 _L8 _L6 _L6 _L9 _L10
_L6:
        motionevent = ((MotionEvent) (obj));
        continue; /* Loop/switch isn't completed */
_L7:
        if (j1 == l)
        {
            float f1;
            float f3;
            float f5;
            float f6;
            Transform transform;
            switch (com.socialin.android.brushlib.controller._cls1.a[f.ordinal()])
            {
            default:
                motionevent = ((MotionEvent) (obj));
                continue; /* Loop/switch isn't completed */

            case 1: // '\001'
            case 2: // '\002'
                b();
                motionevent = ((MotionEvent) (obj));
                continue; /* Loop/switch isn't completed */

            case 3: // '\003'
            case 4: // '\004'
                a();
                motionevent = ((MotionEvent) (obj));
                break;
            }
            break; /* Loop/switch isn't completed */
        }
          goto _L11
_L8:
        motionevent = new PointF(motionevent.getX(), motionevent.getY());
        b.d.a(motionevent, motionevent);
        switch (com.socialin.android.brushlib.controller._cls1.a[f.ordinal()])
        {
        default:
            motionevent = ((MotionEvent) (obj));
            break;

        case 1: // '\001'
        case 2: // '\002'
            ((LineOverlay)super.a).setEndPoint(((PointF) (motionevent)).x, ((PointF) (motionevent)).y);
            motionevent = ((MotionEvent) (obj));
            break;

        case 3: // '\003'
        case 4: // '\004'
            i.set(super.a.getTransformedBounds(true));
            b.d.a(i);
            transform = super.a.getTransform();
            f1 = (o + ((PointF) (motionevent)).x) - m;
            f3 = p;
            f3 = (((PointF) (motionevent)).y + f3) - n;
            f5 = o;
            f6 = p;
            transform.setScale(f1 / super.a.getOrigWidth(), f3 / super.a.getOrigHeight());
            transform.setPosition(m + (f1 - f5) / 2.0F, n + (f3 - f6) / 2.0F);
            j.set(super.a.getTransformedBounds(true));
            b.d.a(j);
            i.union(j);
            b.a(i);
            motionevent = ((MotionEvent) (obj));
            break;
        }
        break; /* Loop/switch isn't completed */
_L10:
        if (j1 == l)
        {
            switch (com.socialin.android.brushlib.controller._cls1.a[f.ordinal()])
            {
            default:
                motionevent = ((MotionEvent) (obj));
                break;

            case 1: // '\001'
            case 2: // '\002'
                super.a.draw(b.c.b.j);
                b.c.a(b.c.b);
                h = null;
                motionevent = ((MotionEvent) (obj));
                break;

            case 3: // '\003'
            case 4: // '\004'
                a();
                motionevent = ((MotionEvent) (obj));
                break;
            }
            break; /* Loop/switch isn't completed */
        }
          goto _L11
_L9:
        c();
        motionevent = TouchResponse.REJECT;
        break; /* Loop/switch isn't completed */
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (c != null)
        {
            i.set(super.a.getTransformedBounds(true));
            b.d.a(i);
            c.a(k);
            i.union(k);
            obj = c.a(motionevent);
            if (obj == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.TRANSFORMED)
            {
                j.set(super.a.getTransformedBounds(true));
                b.d.a(j);
                c.a(k);
                j.union(k);
                i.union(j);
                b.a(i);
            } else
            if (obj == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.FOCUS_OUTSIDE)
            {
label0:
                {
                    b();
                    i1 = ((flag) ? 1 : 0);
                    if (android.os.Build.VERSION.SDK_INT < 14)
                    {
                        break label0;
                    }
                    k1 = motionevent.getToolType(k1);
                    if (k1 != 2)
                    {
                        i1 = ((flag) ? 1 : 0);
                        if (k1 != 3)
                        {
                            break label0;
                        }
                    }
                    i1 = 1;
                }
                if (i1 != 0)
                {
                    q.set(motionevent.getX(), motionevent.getY());
                    l = j1;
                } else
                {
                    q.set(motionevent.getX(), motionevent.getY());
                    l = j1;
                    h = null;
                }
                c = null;
            }
            if (obj == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.TRANSFORMED || obj == com.socialin.android.brushlib.gizmo.Gizmo.TouchResponse.FOCUSED)
            {
                motionevent = TouchResponse.ACCEPT;
            } else
            {
                motionevent = TouchResponse.UNDEFINED;
            }
            continue; /* Loop/switch isn't completed */
        } else
        {
            motionevent = TouchResponse.UNDEFINED;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        i1;
        JVM INSTR tableswitch 0 5: default 960
    //                   0 967
    //                   1 1701
    //                   2 1024
    //                   3 960
    //                   4 960
    //                   5 1689;
           goto _L12 _L13 _L14 _L15 _L12 _L12 _L16
_L12:
        motionevent = TouchResponse.UNDEFINED;
        continue; /* Loop/switch isn't completed */
_L13:
        if (b.c.b.g())
        {
            e();
            return TouchResponse.REJECT;
        }
        q.set(motionevent.getX(), motionevent.getY());
        l = j1;
        motionevent = TouchResponse.UNDEFINED;
        r = true;
        continue; /* Loop/switch isn't completed */
_L15:
        if (b.c.b.g())
        {
            e();
            return TouchResponse.REJECT;
        }
        if (!r) goto _L18; else goto _L17
_L17:
        i1 = motionevent.findPointerIndex(l);
        if (i1 < 0) goto _L20; else goto _L19
_L19:
        if (Geom.b(q.x, q.y, motionevent.getX(i1), motionevent.getY(i1)) < DrawingView.a || motionevent.getEventTime() - motionevent.getDownTime() < 30L) goto _L22; else goto _L21
_L21:
        float f2;
        float f4;
        motionevent = new PointF(q.x, q.y);
        b.d.a(motionevent, motionevent);
        m = ((PointF) (motionevent)).x;
        n = ((PointF) (motionevent)).y;
        f2 = ((PointF) (motionevent)).x;
        f4 = ((PointF) (motionevent)).y;
        if (f == null) goto _L24; else goto _L23
_L23:
        com.socialin.android.brushlib.controller._cls1.a[f.ordinal()];
        JVM INSTR tableswitch 1 4: default 1232
    //                   1 1401
    //                   2 1437
    //                   3 1473
    //                   4 1525;
           goto _L25 _L26 _L27 _L28 _L29
_L25:
        motionevent = super.a;
        if (motionevent instanceof ShapeOverlay)
        {
            obj = ((ShapeOverlay)motionevent).getParams();
            if (b.r && b.c.b == b.c.j.d)
            {
                ((ShapeParams) (obj)).setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
            } else
            {
                ((ShapeParams) (obj)).setMode(b.b());
            }
            ((ShapeOverlay)motionevent).setParams(((ShapeParams) (obj)));
        } else
        if (motionevent instanceof LineOverlay)
        {
            obj = ((LineOverlay)motionevent).getParams();
            if (b.r && b.c.b == b.c.j.d)
            {
                ((ShapeParams) (obj)).setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
            } else
            {
                ((ShapeParams) (obj)).setMode(b.b());
            }
            ((LineOverlay)motionevent).setParams(((ShapeParams) (obj)));
        }
_L24:
        h = ShapeEditingMode.DRAW;
        o = super.a.getTransform().getSx() * super.a.getOrigWidth();
        p = super.a.getTransform().getSy() * super.a.getOrigHeight();
        i.set(super.a.getTransformedBounds(true));
        b.d.a(i);
        b.a(true);
        motionevent = TouchResponse.ACCEPT;
        continue; /* Loop/switch isn't completed */
_L26:
        motionevent = new LineOverlay();
        motionevent.setParams(g);
        motionevent.setStartPoint(f2, f4);
        motionevent.setEndPoint(f2, f4);
        a(((Overlay) (motionevent)));
          goto _L25
_L27:
        motionevent = new ArrowOverlay();
        motionevent.setParams(g);
        motionevent.setStartPoint(f2, f4);
        motionevent.setEndPoint(f2, f4);
        a(((Overlay) (motionevent)));
          goto _L25
_L28:
        motionevent = new ShapeOverlay(d);
        motionevent.setParams(g);
        motionevent.getTransform().setPosition(f2, f4);
        motionevent.setSizeInViewport(20F, b.d);
        a(((Overlay) (motionevent)));
          goto _L25
_L29:
        motionevent = new SvgClipArtOverlay(null);
        motionevent.getTransform().setPosition(f2, f4);
        motionevent.setSizeInViewport(20F, b.d);
        a(((Overlay) (motionevent)));
          goto _L25
_L22:
        motionevent = TouchResponse.UNDEFINED;
        continue; /* Loop/switch isn't completed */
_L20:
        motionevent = TouchResponse.UNDEFINED;
        continue; /* Loop/switch isn't completed */
_L18:
        motionevent = TouchResponse.REJECT;
        continue; /* Loop/switch isn't completed */
_L16:
        motionevent = TouchResponse.REJECT;
        r = false;
        continue; /* Loop/switch isn't completed */
_L14:
        r = false;
        motionevent = TouchResponse.REJECT;
        continue; /* Loop/switch isn't completed */
_L11:
        motionevent = ((MotionEvent) (obj));
        if (true) goto _L31; else goto _L30
_L30:
    }

    public final void a()
    {
        c = SimpleTransformGizmo.a(b.getResources(), super.a, b);
        h = ShapeEditingMode.EDIT;
        i.set(super.a.getTransformedBounds(true));
        b.d.a(i);
        c.a(k);
        i.union(k);
        b.a(true);
    }

    public final void a(int i1)
    {
        Overlay overlay = super.a;
        if (overlay == null) goto _L2; else goto _L1
_L1:
        if (!(overlay instanceof ShapeOverlay)) goto _L4; else goto _L3
_L3:
        ((ShapeOverlay)overlay).getParams().setColorRGB(i1);
_L6:
        b.a(true);
_L2:
        if (g != null)
        {
            g.setColorRGB(i1);
        }
        return;
_L4:
        if (overlay instanceof LineOverlay)
        {
            ((LineOverlay)overlay).getParams().setColorRGB(i1);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(Canvas canvas)
    {
        if (c != null)
        {
            c.a(canvas, b.d);
        }
    }

    public final void a(Canvas canvas, com.socialin.android.brushlib.layer.b b1)
    {
        if (b1 == b.c.b && b1.f)
        {
            if (b.r && b1 == b.c.j.d)
            {
                if (super.a != null)
                {
                    canvas.save();
                    canvas.clipRect(b.j());
                    b.d.a(canvas);
                    super.a.draw(canvas);
                    canvas.restore();
                }
            } else
            if (super.a != null)
            {
                canvas.save();
                canvas.clipRect(b.j());
                b.d.a(canvas);
                super.a.draw(canvas);
                canvas.restore();
                return;
            }
        }
    }

    public final void a(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        if (super.a == null) goto _L2; else goto _L1
_L1:
        Overlay overlay = super.a;
        if (!(overlay instanceof ShapeOverlay)) goto _L4; else goto _L3
_L3:
        ShapeParams shapeparams = ((ShapeOverlay)overlay).getParams();
        if (b.r)
        {
            shapeparams.setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
        } else
        {
            shapeparams.setMode(drawingmode);
        }
        ((ShapeOverlay)overlay).setParams(shapeparams);
_L6:
        b.a(true);
_L2:
        return;
_L4:
        if (overlay instanceof LineOverlay)
        {
            ShapeParams shapeparams1 = ((LineOverlay)overlay).getParams();
            if (b.r)
            {
                shapeparams1.setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode.ERASE);
            } else
            {
                shapeparams1.setMode(drawingmode);
            }
            ((LineOverlay)overlay).setParams(shapeparams1);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b()
    {
        if (super.a == null) goto _L2; else goto _L1
_L1:
        if (!b.c.b.g()) goto _L4; else goto _L3
_L3:
        e();
_L10:
        c();
        h = null;
_L2:
        return;
_L4:
        com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode;
        Object obj;
        Overlay overlay;
        overlay = super.a;
        ShapeParams shapeparams;
        if (b.r)
        {
            if (b.c.j.d == b.c.b)
            {
                drawingmode = com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW;
                obj = b.c.j;
            } else
            {
                obj = b.c.b;
                drawingmode = b.b();
            }
        } else
        {
            obj = b.c.b;
            drawingmode = b.b();
        }
        if (!(overlay instanceof ShapeOverlay)) goto _L6; else goto _L5
_L5:
        shapeparams = ((ShapeOverlay)overlay).getParams();
        shapeparams.setMode(drawingmode);
        ((ShapeOverlay)overlay).setParams(shapeparams);
_L8:
        super.a.draw(((com.socialin.android.brushlib.layer.a) (obj)).b());
        b.c.a(((com.socialin.android.brushlib.layer.a) (obj)));
        if (!(obj instanceof com.socialin.android.brushlib.layer.b))
        {
            break; /* Loop/switch isn't completed */
        }
        ActionCollector.a().a(new OverlayAdditionAction(overlay, UUID.fromString(((com.socialin.android.brushlib.layer.a) (obj)).f()), b.c.f.d().key));
        continue; /* Loop/switch isn't completed */
_L6:
        if (overlay instanceof LineOverlay)
        {
            ShapeParams shapeparams1 = ((LineOverlay)overlay).getParams();
            shapeparams1.setMode(drawingmode);
            ((LineOverlay)overlay).setParams(shapeparams1);
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (obj instanceof CameraMaskLayer)
        {
            ActionCollector.a().a(new DummyAction(b.c.f.d().key));
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final void c()
    {
        a(((Overlay) (null)));
        h = null;
        c = null;
    }

    public final void d()
    {
        if (h == ShapeEditingMode.EDIT && b.s == com.socialin.android.brushlib.view.DrawingView.State.INITIALIZED)
        {
            b();
        }
    }

    private class ShapeEditingMode extends Enum
    {

        private static final ShapeEditingMode $VALUES[];
        public static final ShapeEditingMode DRAW;
        public static final ShapeEditingMode EDIT;

        public static ShapeEditingMode valueOf(String s)
        {
            return (ShapeEditingMode)Enum.valueOf(com/socialin/android/brushlib/controller/ShapeOverlayController$ShapeEditingMode, s);
        }

        public static ShapeEditingMode[] values()
        {
            return (ShapeEditingMode[])$VALUES.clone();
        }

        static 
        {
            DRAW = new ShapeEditingMode("DRAW", 0);
            EDIT = new ShapeEditingMode("EDIT", 1);
            $VALUES = (new ShapeEditingMode[] {
                DRAW, EDIT
            });
        }

        private ShapeEditingMode(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class ShapeType extends Enum
    {

        private static final ShapeType $VALUES[];
        public static final ShapeType ARROW;
        public static final ShapeType CLIPART;
        public static final ShapeType LINE;
        public static final ShapeType SVG;

        public static ShapeType valueOf(String s)
        {
            return (ShapeType)Enum.valueOf(com/socialin/android/brushlib/controller/ShapeOverlayController$ShapeType, s);
        }

        public static ShapeType[] values()
        {
            return (ShapeType[])$VALUES.clone();
        }

        static 
        {
            LINE = new ShapeType("LINE", 0);
            ARROW = new ShapeType("ARROW", 1);
            SVG = new ShapeType("SVG", 2);
            CLIPART = new ShapeType("CLIPART", 3);
            $VALUES = (new ShapeType[] {
                LINE, ARROW, SVG, CLIPART
            });
        }

        private ShapeType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
