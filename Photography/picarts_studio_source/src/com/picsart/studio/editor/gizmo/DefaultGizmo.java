// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.item.a;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.gizmo:
//            a

public class DefaultGizmo extends com.picsart.studio.editor.gizmo.a
{

    private static final float b = (float)Math.sin(Math.toRadians(45D));
    private long A;
    private PointF B;
    private Gizmo.Action C;
    private final PointF D = new PointF();
    private Drawable c;
    private Drawable d;
    private Drawable e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private final float k;
    private final PointF l;
    private final PointF m;
    private final PointF n;
    private final f o = new f();
    private PointF p[];
    private PointF q[];
    private final PointF r = new PointF();
    private final PointF s = new PointF();
    private final float t[] = new float[2];
    private final float u[] = new float[2];
    private final Matrix v = new Matrix();
    private boolean w;
    private Paint x;
    private GestureType y;
    private int z;

    private DefaultGizmo(Resources resources, TransformingItem transformingitem)
    {
        super(transformingitem);
        p = new PointF[2];
        q = new PointF[2];
        B = new PointF();
        new RectF();
        x = new Paint(1);
        x.setStyle(android.graphics.Paint.Style.STROKE);
        x.setStrokeWidth(1.0F);
        c = resources.getDrawable(0x7f02024a);
        if (c != null)
        {
            c.setBounds(new Rect(0, 0, c.getIntrinsicWidth(), c.getIntrinsicHeight()));
        }
        e = resources.getDrawable(0x7f02024b);
        if (e != null)
        {
            e.setBounds(new Rect(0, 0, e.getIntrinsicWidth(), e.getIntrinsicHeight()));
        }
        d = resources.getDrawable(0x7f02024c);
        if (d != null)
        {
            d.setBounds(new Rect(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight()));
        }
        f = resources.getDimension(0x7f0b00e7);
        g = resources.getDimension(0x7f0b00e6);
        h = resources.getDimension(0x7f0b00e5);
        i = resources.getDimension(0x7f0b00e2);
        j = resources.getDimension(0x7f0b00e3);
        k = resources.getDimension(0x7f0b00e0);
        l = new PointF(c.getIntrinsicWidth(), c.getIntrinsicHeight());
        m = new PointF(d.getIntrinsicWidth(), d.getIntrinsicHeight());
        n = new PointF(e.getIntrinsicWidth(), e.getIntrinsicHeight());
        p[0] = new PointF();
        p[1] = new PointF();
        q[0] = new PointF();
        q[1] = new PointF();
    }

    private GestureType a(Camera camera, float f1, float f2)
    {
        D.set(f1, f2);
        PointF pointf = D;
        camera.a(pointf, pointf);
        f2 = D.x;
        float f3 = D.y;
        float f5 = f / camera.e;
        float f6 = g / camera.e;
        float f4 = h / camera.e;
        f1 = i / camera.e;
        float f7 = j / camera.e;
        f1 *= f1;
        float f8 = Math.abs(((TransformingItem)a).b(camera));
        float f9 = Math.abs(((TransformingItem)a).c(camera));
        boolean flag = ((TransformingItem)a).a(camera, f2, f3);
        if (f8 < k || f9 < k)
        {
            if (flag)
            {
                return GestureType.DRAG;
            }
            a(D);
            if (Geom.a(D.x, D.y, f2, f3) <= f6 * f6)
            {
                return GestureType.SCALE_PROP;
            }
        }
        a(D);
        if (Geom.a(D.x, D.y, f2, f3) <= f5 * f5)
        {
            return GestureType.SCALE_PROP;
        }
        pointf = D;
        pointf.set(0.0F, 0.0F);
        ((TransformingItem)a).r().a(pointf);
        pointf = D;
        pointf.set(-((TransformingItem)a).i() / 2.0F, 0.0F);
        ((TransformingItem)a).r().a(pointf);
        if (!flag)
        {
            f1 = f7 * f7;
        }
        if (Geom.a(D.x, D.y, f2, f3) <= f1)
        {
            return GestureType.SCALE_L;
        }
        pointf = D;
        pointf.set(0.0F, -((TransformingItem)a).j() / 2.0F);
        ((TransformingItem)a).r().a(pointf);
        if (Geom.a(D.x, D.y, f2, f3) <= f1)
        {
            return GestureType.SCALE_T;
        }
        pointf = D;
        pointf.set(((TransformingItem)a).i() / 2.0F, 0.0F);
        ((TransformingItem)a).r().a(pointf);
        if (Geom.a(D.x, D.y, f2, f3) <= f1)
        {
            return GestureType.SCALE_R;
        }
        pointf = D;
        pointf.set(0.0F, ((TransformingItem)a).j() / 2.0F);
        ((TransformingItem)a).r().a(pointf);
        if (Geom.a(D.x, D.y, f2, f3) <= f1)
        {
            return GestureType.SCALE_B;
        }
        if (flag)
        {
            return GestureType.DRAG;
        }
        pointf = D;
        f1 = ((TransformingItem)a).i();
        f5 = ((TransformingItem)a).j();
        f6 = b;
        f6 = ((f + h) * f6) / ((TransformingItem)a).a(camera).c();
        f7 = -b;
        f7 = ((f + h) * f7) / ((TransformingItem)a).a(camera).d();
        camera = ((TransformingItem)a).r();
        f8 = Geom.a(camera.c());
        f9 = Geom.a(camera.d());
        pointf.set((f1 / 2.0F) * f8 + f6, f9 * (-f5 / 2.0F) + f7);
        ((TransformingItem)a).r().a(pointf);
        if (Geom.a(D.x, D.y, f2, f3) <= f4 * f4)
        {
            return GestureType.ROTATE;
        } else
        {
            return null;
        }
    }

    public static DefaultGizmo a(Resources resources, TransformingItem transformingitem)
    {
        return new DefaultGizmo(resources, transformingitem);
    }

    private void a(PointF pointf)
    {
        float f1 = ((TransformingItem)a).i();
        float f2 = ((TransformingItem)a).j();
        pointf.set(f1 / 2.0F, f2 / 2.0F);
        ((TransformingItem)a).r().a(pointf);
    }

    public final f a(MotionEvent motionevent, Camera camera, boolean flag)
    {
        g g1;
        int i1;
        i1 = motionevent.getActionMasked();
        g1 = ((TransformingItem)a).a(camera);
        q[0].set(motionevent.getX(0), motionevent.getY(0));
        if (motionevent.getPointerCount() > 1)
        {
            q[1].set(motionevent.getX(1), motionevent.getY(1));
        }
        i1;
        JVM INSTR tableswitch 0 6: default 108
    //                   0 165
    //                   1 2362
    //                   2 691
    //                   3 108
    //                   4 108
    //                   5 308
    //                   6 448;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        boolean flag3;
        flag3 = true;
        flag = false;
_L21:
        p[0].set(q[0]);
        p[1].set(q[1]);
        o.a = flag3;
        o.b = flag;
        return o;
_L2:
        if (a instanceof a)
        {
            long l2 = System.nanoTime();
            if (l2 - A < 0xee6b280L)
            {
                ((a)a).e();
                A = 0L;
            } else
            {
                A = l2;
            }
        }
        if (flag)
        {
            y = GestureType.DRAG;
        } else
        {
            y = a(camera, q[0].x, q[0].y);
        }
        z = motionevent.getPointerId(0);
        if (y == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        B.set(q[0]);
        w = true;
        flag3 = true;
        continue; /* Loop/switch isn't completed */
_L5:
        w = false;
        if (y != GestureType.PINCH)
        {
            motionevent = a(camera, q[1].x, q[1].y);
            camera = a(camera, q[0].x, q[0].y);
            boolean flag1;
            boolean flag2;
            if (motionevent != null && motionevent != GestureType.ROTATE)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (camera != null && camera != GestureType.ROTATE)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1 || flag2)
            {
                y = GestureType.PINCH;
            }
        }
        if (y != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag3 = true;
        continue; /* Loop/switch isn't completed */
_L6:
        int k1 = 0;
        int l1;
        for (int j1 = 0; j1 < motionevent.getPointerCount() && k1 < 2; k1 = l1)
        {
            l1 = k1;
            if (j1 != motionevent.getActionIndex())
            {
                p[k1].set(motionevent.getX(j1), motionevent.getY(j1));
                q[k1].set(p[k1]);
                l1 = k1 + 1;
            }
            j1++;
        }

        if (z == motionevent.getPointerId(motionevent.getActionIndex()))
        {
            y = null;
        }
        if (motionevent.getPointerCount() == 2)
        {
            y = a(camera, q[0].x, q[0].y);
        } else
        if (a(camera, q[0].x, q[0].y) == GestureType.DRAG || a(camera, q[1].x, q[1].y) == GestureType.DRAG)
        {
            y = GestureType.PINCH;
        } else
        {
            y = null;
        }
        if (y != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag3 = true;
        continue; /* Loop/switch isn't completed */
_L4:
        if (y == null) goto _L8; else goto _L7
_L7:
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
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[GestureType.ROTATE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[GestureType.SCALE_PROP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[GestureType.SCALE_R.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[GestureType.SCALE_T.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[GestureType.SCALE_L.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[GestureType.SCALE_B.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GestureType.PINCH.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.gizmo._cls1.a[y.ordinal()];
        JVM INSTR tableswitch 1 8: default 756
    //                   1 764
    //                   2 862
    //                   3 975
    //                   4 1206
    //                   5 1206
    //                   6 1206
    //                   7 1206
    //                   8 1735;
           goto _L9 _L10 _L11 _L12 _L13 _L13 _L13 _L13 _L14
_L9:
        flag3 = true;
        flag = false;
        continue; /* Loop/switch isn't completed */
_L10:
        C = Gizmo.Action.DRAG;
        float f1 = q[0].x;
        float f9 = p[0].x;
        float f17 = q[0].y;
        float f24 = p[0].y;
        g1.a((f1 - f9) + g1.a());
        g1.b(g1.b() + (f17 - f24));
        w = false;
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L11:
        C = Gizmo.Action.ROTATE;
        float f2 = g1.a();
        float f10 = g1.b();
        double d1 = Math.atan2(p[0].y - f10, p[0].x - f2);
        g1.e((float)Math.toDegrees(Math.atan2(q[0].y - f10, q[0].x - f2) - d1) + g1.e());
        w = false;
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L12:
        C = Gizmo.Action.RESIZE_FREE;
        motionevent = ((TransformingItem)a).a(camera);
        motionevent.a(p[0], r);
        motionevent.a(q[0], s);
        r.set(0.0F, 0.0F);
        s.set(((TransformingItem)a).i() / 2.0F, ((TransformingItem)a).j() / 2.0F);
        motionevent.a(r);
        motionevent.a(s);
        float f11 = Math.abs(Geom.b(p[0], q[0]) - Geom.b(r, s));
        float f3 = Geom.a(p[0], q[0]);
        f11 = (float)Math.cos(f11);
        Geom.a(f11);
        float f18 = Geom.a(r, s);
        f3 = (f11 * (f3 * f11 * f11) + f18) / f18;
        motionevent.b(motionevent.c() * f3, f3 * motionevent.d());
        w = false;
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L13:
        C = Gizmo.Action.RESIZE_PROP;
        motionevent = y;
        camera = ((TransformingItem)a).a(camera);
        g1 = ((TransformingItem)a).r();
        camera.a(p[0], r);
        camera.a(q[0], s);
        com.picsart.studio.editor.gizmo._cls1.a[motionevent.ordinal()];
        JVM INSTR tableswitch 4 7: default 1308
    //                   4 1425
    //                   5 1528
    //                   6 1321
    //                   7 1632;
           goto _L15 _L16 _L17 _L18 _L19
_L15:
        w = false;
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L18:
        float f4 = r.x - s.x;
        float f12 = ((TransformingItem)a).i();
        float f19 = -f4 / 2.0F;
        r.set(f19, 0.0F);
        camera.a(r);
        camera.a(r.x, r.y);
        g1.c(((f4 + f12) / ((TransformingItem)a).i()) * g1.c());
          goto _L15
_L16:
        float f5 = s.x - r.x;
        float f13 = ((TransformingItem)a).i();
        float f20 = f5 / 2.0F;
        r.set(f20, 0.0F);
        camera.a(r);
        camera.a(r.x, r.y);
        g1.c(((f5 + f13) / ((TransformingItem)a).i()) * g1.c());
          goto _L15
_L17:
        float f6 = r.y - s.y;
        float f14 = ((TransformingItem)a).j();
        float f21 = -f6 / 2.0F;
        r.set(0.0F, f21);
        camera.a(r);
        camera.a(r.x, r.y);
        g1.d(((f6 + f14) / ((TransformingItem)a).j()) * g1.d());
          goto _L15
_L19:
        float f7 = s.y - r.y;
        float f15 = ((TransformingItem)a).j();
        float f22 = f7 / 2.0F;
        r.set(0.0F, f22);
        camera.a(r);
        camera.a(r.x, r.y);
        g1.d(((f7 + f15) / ((TransformingItem)a).j()) * g1.d());
          goto _L15
_L14:
        C = Gizmo.Action.IMAGE_ZOOM;
        motionevent = ((TransformingItem)a).a(camera);
        float f16 = Geom.a(p[0], p[1]);
        float f23 = Geom.a(q[0], q[1]);
        r.set((p[0].x + p[1].x) / 2.0F, (p[0].y + p[1].y) / 2.0F);
        s.set((q[0].x + q[1].x) / 2.0F, (q[0].y + q[1].y) / 2.0F);
        float f8 = f16;
        if (f16 == 0.0F)
        {
            f8 = 1.0F;
        }
        f8 = f23 / f8;
        motionevent.b(motionevent.c() * f8, motionevent.d() * f8);
        v.setScale(f8, f8, r.x, r.y);
        t[0] = motionevent.a();
        t[1] = motionevent.b();
        v.mapPoints(u, t);
        motionevent.a(u[0], u[1]);
        double d2 = Math.atan2(p[0].y - p[1].y, p[0].x - p[1].x);
        f8 = (float)Math.toDegrees(Math.atan2(q[0].y - q[1].y, q[0].x - q[1].x) - d2);
        motionevent.e(motionevent.e() + f8);
        v.setRotate(f8, r.x, r.y);
        t[0] = motionevent.a();
        t[1] = motionevent.b();
        v.mapPoints(u, t);
        motionevent.a(u[0], u[1]);
        r.set((p[0].x + p[1].x) / 2.0F, (p[0].y + p[1].y) / 2.0F);
        s.set((q[0].x + q[1].x) / 2.0F, (q[0].y + q[1].y) / 2.0F);
        f8 = s.x;
        f16 = r.x;
        f23 = s.y;
        float f25 = r.y;
        motionevent.a((f8 - f16) + motionevent.a(), (f23 - f25) + motionevent.b());
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L8:
        flag3 = true;
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        camera.a(q[0], D);
        if (w && motionevent.getEventTime() - motionevent.getDownTime() <= 500L && Geom.b(B.x, B.y, motionevent.getX(), motionevent.getY()) <= 100F && !((TransformingItem)a).a(camera, D.x, D.y))
        {
            flag3 = false;
        } else
        {
            flag3 = true;
        }
        y = null;
        if (C != null)
        {
            ((TransformingItem)a).a(C);
            flag = false;
        } else
        {
            flag = false;
        }
        if (true) goto _L21; else goto _L20
_L20:
    }

    public final void a(Canvas canvas, Camera camera, float f1, float f2)
    {
        camera = ((TransformingItem)a).a(camera);
        canvas.save();
        x.setColor(0xff000000);
        canvas.drawRect(-f1 / 2.0F + 2.0F, -f2 / 2.0F + 2.0F, f1 / 2.0F - 2.0F, f2 / 2.0F - 2.0F, x);
        x.setColor(-1);
        canvas.drawRect(-f1 / 2.0F + 1.0F, -f2 / 2.0F + 1.0F, f1 / 2.0F - 1.0F, f2 / 2.0F - 1.0F, x);
        float f3 = Geom.a(camera.c());
        float f4 = Geom.a(camera.d());
        canvas.save();
        canvas.translate(-f1 / 2.0F - n.x / 2.0F, -n.y / 2.0F);
        e.draw(canvas);
        canvas.translate(f1 / 2.0F, -f2 / 2.0F);
        e.draw(canvas);
        canvas.translate(f1 / 2.0F, f2 / 2.0F);
        e.draw(canvas);
        canvas.translate(-f1 / 2.0F, f2 / 2.0F);
        e.draw(canvas);
        canvas.restore();
        canvas.translate(f1 / 2.0F, -f2 / 2.0F);
        canvas.translate(b * (f + h) - m.x / 2.0F, -b * (f + h) - m.y / 2.0F);
        d.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate((f3 * f1) / 2.0F - (l.x * f3) / 2.0F, (f4 * f2) / 2.0F - (l.y * f4) / 2.0F);
        canvas.scale(f3, f4);
        c.draw(canvas);
        canvas.restore();
    }

    static 
    {
        com/picsart/studio/editor/gizmo/DefaultGizmo.getSimpleName();
    }

    private class GestureType extends Enum
    {

        private static final GestureType $VALUES[];
        public static final GestureType DRAG;
        public static final GestureType PINCH;
        public static final GestureType ROTATE;
        public static final GestureType SCALE_B;
        public static final GestureType SCALE_L;
        public static final GestureType SCALE_PROP;
        public static final GestureType SCALE_R;
        public static final GestureType SCALE_T;

        public static GestureType valueOf(String s1)
        {
            return (GestureType)Enum.valueOf(com/picsart/studio/editor/gizmo/DefaultGizmo$GestureType, s1);
        }

        public static GestureType[] values()
        {
            return (GestureType[])$VALUES.clone();
        }

        static 
        {
            DRAG = new GestureType("DRAG", 0);
            SCALE_PROP = new GestureType("SCALE_PROP", 1);
            SCALE_L = new GestureType("SCALE_L", 2);
            SCALE_T = new GestureType("SCALE_T", 3);
            SCALE_R = new GestureType("SCALE_R", 4);
            SCALE_B = new GestureType("SCALE_B", 5);
            ROTATE = new GestureType("ROTATE", 6);
            PINCH = new GestureType("PINCH", 7);
            $VALUES = (new GestureType[] {
                DRAG, SCALE_PROP, SCALE_L, SCALE_T, SCALE_R, SCALE_B, ROTATE, PINCH
            });
        }

        private GestureType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
