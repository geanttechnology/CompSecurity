// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.gizmo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.util.Geom;

// Referenced classes of package com.socialin.android.brushlib.gizmo:
//            a

public final class SimpleTransformGizmo extends a
{

    private static final float d = (float)Math.sin(Math.toRadians(45D));
    public boolean c;
    private Drawable e;
    private Drawable f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private Paint k;
    private GestureType l;
    private boolean m;
    private PointF n;
    private PointF o;
    private final PointF p = new PointF();
    private final PointF q = new PointF();

    private SimpleTransformGizmo(Resources resources, Overlay overlay, DrawingView drawingview)
    {
        super(overlay, drawingview);
        n = new PointF();
        o = new PointF();
        k = new Paint(1);
        k.setStyle(android.graphics.Paint.Style.STROKE);
        k.setStrokeWidth(1.0F);
        e = resources.getDrawable(0x7f020249);
        e.setBounds(new Rect(0, 0, e.getIntrinsicWidth(), e.getIntrinsicHeight()));
        g = resources.getDimension(0x7f0b00c9);
        h = resources.getDimension(0x7f0b00c8);
        i = e.getIntrinsicWidth();
        j = e.getIntrinsicHeight();
        f = resources.getDrawable(0x7f02024c);
        f.setBounds(new Rect(0, 0, f.getIntrinsicWidth(), f.getIntrinsicHeight()));
        l = null;
    }

    public static SimpleTransformGizmo a(Resources resources, Overlay overlay, DrawingView drawingview)
    {
        return new SimpleTransformGizmo(resources, overlay, drawingview);
    }

    public final Gizmo.TouchResponse a(MotionEvent motionevent)
    {
        float f11;
        float f12;
        Transform transform;
        int i1;
        boolean flag1;
        flag1 = true;
        f12 = -1F;
        f11 = 1.0F;
        i1 = motionevent.getActionMasked();
        transform = a.getViewportTransform(b.d);
        o.set(motionevent.getX(), motionevent.getY());
        i1;
        JVM INSTR tableswitch 0 5: default 88
    //                   0 105
    //                   1 1846
    //                   2 753
    //                   3 88
    //                   4 88
    //                   5 722;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5
_L1:
        motionevent = Gizmo.TouchResponse.FOCUSED;
_L14:
        n.set(o);
        return motionevent;
_L2:
        m = true;
        float f1 = motionevent.getX();
        float f6 = motionevent.getY();
        motionevent = b.d;
        transform = a.getViewportTransform(motionevent);
        float f15;
        RectF rectf;
        boolean flag;
        if (transform.getSx() < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (transform.getSy() >= 0.0F)
        {
            flag1 = false;
        }
        q.set(f1, f6);
        rectf = a.getTransformedBounds(false);
        rectf.right = rectf.right * ((Camera) (motionevent)).e;
        rectf.left = rectf.left * ((Camera) (motionevent)).e;
        rectf.top = rectf.top * ((Camera) (motionevent)).e;
        rectf.bottom = rectf.bottom * ((Camera) (motionevent)).e;
        rectf.offsetTo(transform.getCx() - rectf.width() / 2.0F, transform.getCy() - rectf.height() / 2.0F);
        Transform.reverseRotatePointF(q, transform.getRotation(), rectf.centerX(), rectf.centerY());
        f1 = q.x;
        f6 = q.y;
        f11 = g * g;
        f12 = h;
        f15 = h;
        if (Geom.a(rectf.left, rectf.top, f1, f6) <= f11)
        {
            if (flag)
            {
                if (flag1)
                {
                    motionevent = GestureType.SCALE_RB;
                } else
                {
                    motionevent = GestureType.SCALE_RT;
                }
            } else
            if (flag1)
            {
                motionevent = GestureType.SCALE_LB;
            } else
            {
                motionevent = GestureType.SCALE_LT;
            }
        } else
        if (Geom.a(rectf.right, rectf.top, f1, f6) <= f11)
        {
            if (flag)
            {
                if (flag1)
                {
                    motionevent = GestureType.SCALE_LB;
                } else
                {
                    motionevent = GestureType.SCALE_LT;
                }
            } else
            if (flag1)
            {
                motionevent = GestureType.SCALE_RB;
            } else
            {
                motionevent = GestureType.SCALE_RT;
            }
        } else
        if (Geom.a(rectf.right, rectf.bottom, f1, f6) <= f11)
        {
            if (flag)
            {
                if (flag1)
                {
                    motionevent = GestureType.SCALE_LT;
                } else
                {
                    motionevent = GestureType.SCALE_LB;
                }
            } else
            if (flag1)
            {
                motionevent = GestureType.SCALE_RT;
            } else
            {
                motionevent = GestureType.SCALE_RB;
            }
        } else
        if (Geom.a(rectf.left, rectf.bottom, f1, f6) <= f11)
        {
            if (flag)
            {
                if (flag1)
                {
                    motionevent = GestureType.SCALE_RT;
                } else
                {
                    motionevent = GestureType.SCALE_RB;
                }
            } else
            if (flag1)
            {
                motionevent = GestureType.SCALE_LT;
            } else
            {
                motionevent = GestureType.SCALE_LB;
            }
        } else
        if (rectf.contains(f1, f6))
        {
            motionevent = GestureType.DRAG;
        } else
        if (Geom.a(rectf.right + d * (g + h), rectf.top - d * (g + h), f1, f6) <= f12 * f15)
        {
            motionevent = GestureType.ROTATE;
        } else
        {
            motionevent = null;
        }
        l = motionevent;
        if (l == null)
        {
            motionevent = Gizmo.TouchResponse.FOCUS_OUTSIDE;
        } else
        {
            motionevent = Gizmo.TouchResponse.FOCUSED;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        m = false;
        if (l == null)
        {
            motionevent = Gizmo.TouchResponse.FOCUS_OUTSIDE;
        } else
        {
            motionevent = Gizmo.TouchResponse.FOCUSED;
        }
        l = null;
        continue; /* Loop/switch isn't completed */
_L4:
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[GestureType.values().length];
                try
                {
                    a[GestureType.DRAG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[GestureType.ROTATE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[GestureType.SCALE_LB.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[GestureType.SCALE_LT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[GestureType.SCALE_RB.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GestureType.SCALE_RT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        float f4;
        float f9;
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_1839;
        }
        switch (_cls1.a[l.ordinal()])
        {
        default:
            motionevent = Gizmo.TouchResponse.FOCUSED;
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            float f2 = o.x;
            float f7 = n.x;
            f11 = o.y;
            f12 = n.y;
            transform.setCx((f2 - f7) + transform.getCx());
            transform.setCy(transform.getCy() + (f11 - f12));
            motionevent = Gizmo.TouchResponse.TRANSFORMED;
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            float f3 = transform.getCx();
            float f8 = transform.getCy();
            double d1 = Math.atan2(n.y - f8, n.x - f3);
            transform.setRotation((float)Math.toDegrees(Math.atan2(o.y - f8, o.x - f3) - d1) + transform.getRotation());
            motionevent = Gizmo.TouchResponse.TRANSFORMED;
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            break;
        }
        if (!c)
        {
            break MISSING_BLOCK_LABEL_1591;
        }
        motionevent = l;
        transform = a.getViewportTransform(b.d);
        transform.reverseMapPoint(o, p);
        f4 = f12;
        f9 = f11;
        _cls1.a[motionevent.ordinal()];
        JVM INSTR tableswitch 3 6: default 1068
    //                   3 1075
    //                   4 1354
    //                   5 1364
    //                   6 1375;
           goto _L6 _L7 _L8 _L9 _L10
_L7:
        break; /* Loop/switch isn't completed */
_L6:
        f4 = 1.0F;
        f9 = f11;
_L11:
        f12 = Math.abs(p.x / a.getOrigWidth() / 2.0F);
        float f16 = Math.abs(p.y / a.getOrigHeight() / 2.0F);
        f11 = a.getOrigWidth() / a.getOrigHeight();
        if (f12 < f16)
        {
            f12 = ((a.getOrigWidth() * f9) / 2.0F + p.x) / 2.0F;
            float f17 = ((a.getOrigHeight() * f4) / 2.0F + (Geom.a(p.y) * Math.abs(p.x)) / f11) / 2.0F;
            p.set(f12, f17);
            transform.mapPoint(p);
            transform.setPosition(p.x, p.y);
            transform.reverseMapPoint(o, p);
            f9 = (-f9 * p.x) / (a.getOrigWidth() / 2.0F);
            f4 = (-f4 * Geom.a(p.y) * (Math.abs(p.x) / f11)) / (a.getOrigHeight() / 2.0F);
            transform.setScale(f9 * transform.getSx(), f4 * transform.getSy());
        } else
        {
            float f13 = ((a.getOrigWidth() * f9) / 2.0F + Geom.a(p.x) * f11 * Math.abs(p.y)) / 2.0F;
            float f18 = ((a.getOrigHeight() * f4) / 2.0F + p.y) / 2.0F;
            p.set(f13, f18);
            transform.mapPoint(p);
            transform.setPosition(p.x, p.y);
            transform.reverseMapPoint(o, p);
            f9 = (-f9 * Geom.a(p.x) * (Math.abs(p.y) * f11)) / (a.getOrigWidth() / 2.0F);
            f4 = (-f4 * p.y) / (a.getOrigHeight() / 2.0F);
            transform.setScale(f9 * transform.getSx(), f4 * transform.getSy());
        }
_L12:
        motionevent = Gizmo.TouchResponse.TRANSFORMED;
        continue; /* Loop/switch isn't completed */
_L8:
        f4 = 1.0F;
        f9 = f11;
          goto _L11
_L9:
        f9 = -1F;
        f4 = f12;
          goto _L11
_L10:
        f9 = -1F;
        f4 = 1.0F;
          goto _L11
        motionevent = l;
        Transform transform1 = a.getViewportTransform(b.d);
        transform1.reverseMapPoint(o, p);
        float f5;
        float f10;
        float f14;
        if (motionevent == GestureType.SCALE_RB || motionevent == GestureType.SCALE_RT)
        {
            f5 = -1F;
        } else
        {
            f5 = 1.0F;
        }
        if (motionevent == GestureType.SCALE_LB || motionevent == GestureType.SCALE_RB)
        {
            f11 = -1F;
        }
        f10 = ((a.getOrigWidth() * f5) / 2.0F + p.x) / 2.0F;
        f14 = ((a.getOrigHeight() * f11) / 2.0F + p.y) / 2.0F;
        p.set(f10, f14);
        transform1.mapPoint(p);
        transform1.setPosition(p.x, p.y);
        transform1.reverseMapPoint(o, p);
        f5 = (-f5 * p.x) / (a.getOrigWidth() / 2.0F);
        f10 = (-f11 * p.y) / (a.getOrigHeight() / 2.0F);
        transform1.setScale(f5 * transform1.getSx(), f10 * transform1.getSy());
          goto _L12
        motionevent = Gizmo.TouchResponse.FOCUS_OUTSIDE;
        continue; /* Loop/switch isn't completed */
_L3:
        if (m)
        {
            if (motionevent.getEventTime() - motionevent.getDownTime() <= 500L)
            {
                b.d.a(o, q);
                if (l == null)
                {
                    motionevent = Gizmo.TouchResponse.TAP_OUTSIDE;
                } else
                {
                    motionevent = Gizmo.TouchResponse.TRANSFORMED;
                }
            } else
            {
                motionevent = Gizmo.TouchResponse.FOCUSED;
            }
        } else
        {
            motionevent = Gizmo.TouchResponse.FOCUSED;
        }
        l = null;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public final void a(Canvas canvas, RectF rectf)
    {
        float f1 = rectf.width();
        float f2 = rectf.height();
        canvas.translate(-rectf.width() / 2.0F, -rectf.height() / 2.0F);
        canvas.save();
        k.setColor(-1);
        k.setStrokeWidth(2.0F);
        canvas.drawRect(rectf, k);
        k.setColor(0xff000000);
        k.setStrokeWidth(1.0F);
        canvas.drawRect(rectf, k);
        canvas.translate(rectf.left - i / 2.0F, rectf.top - j / 2.0F);
        e.draw(canvas);
        canvas.translate(f1, 0.0F);
        e.draw(canvas);
        canvas.translate(0.0F, f2);
        e.draw(canvas);
        canvas.translate(-f1, 0.0F);
        e.draw(canvas);
        canvas.translate(i / 2.0F, j / 2.0F);
        canvas.translate((f1 + d * (g + h)) - (float)(f.getIntrinsicWidth() / 2), -f2 - d * (g + h) - (float)f.getIntrinsicHeight() / 2.0F);
        f.draw(canvas);
        canvas.restore();
    }

    public final void a(RectF rectf)
    {
        Camera camera = b.d;
        Transform transform = a.getViewportTransform(camera);
        RectF rectf1 = a.getTransformedBounds(false);
        rectf1.right = rectf1.right * camera.e;
        rectf1.left = rectf1.left * camera.e;
        rectf1.top = rectf1.top * camera.e;
        float f1 = rectf1.bottom;
        rectf1.bottom = camera.e * f1;
        rectf1.sort();
        rectf.set(rectf1);
        rectf.inset(-i / 2.0F, -j / 2.0F);
        rectf.right = rectf.right + d * (g + h);
        rectf.top = rectf.top - d * (g + h);
        Transform.rotateRectF(rectf, rectf, transform.getRotation());
        transform.mapRect(rectf);
        rectf.sort();
    }


    private class GestureType extends Enum
    {

        private static final GestureType $VALUES[];
        public static final GestureType DRAG;
        public static final GestureType ROTATE;
        public static final GestureType SCALE_LB;
        public static final GestureType SCALE_LT;
        public static final GestureType SCALE_RB;
        public static final GestureType SCALE_RT;

        public static GestureType valueOf(String s)
        {
            return (GestureType)Enum.valueOf(com/socialin/android/brushlib/gizmo/SimpleTransformGizmo$GestureType, s);
        }

        public static GestureType[] values()
        {
            return (GestureType[])$VALUES.clone();
        }

        static 
        {
            DRAG = new GestureType("DRAG", 0);
            SCALE_LT = new GestureType("SCALE_LT", 1);
            SCALE_RT = new GestureType("SCALE_RT", 2);
            SCALE_LB = new GestureType("SCALE_LB", 3);
            SCALE_RB = new GestureType("SCALE_RB", 4);
            ROTATE = new GestureType("ROTATE", 5);
            $VALUES = (new GestureType[] {
                DRAG, SCALE_LT, SCALE_RT, SCALE_LB, SCALE_RB, ROTATE
            });
        }

        private GestureType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
