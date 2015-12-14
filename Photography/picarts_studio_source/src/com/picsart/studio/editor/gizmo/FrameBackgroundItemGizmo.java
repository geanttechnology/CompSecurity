// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.item.ImageItem;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.gizmo:
//            Gizmo

public final class FrameBackgroundItemGizmo extends Gizmo
{

    private final f b = new f();
    private PointF c[];
    private PointF d[];
    private final PointF e = new PointF();
    private final PointF f = new PointF();
    private final float g[] = new float[2];
    private final float h[] = new float[2];
    private final Matrix i = new Matrix();
    private boolean j;
    private GestureType k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private final PointF p = new PointF();

    private FrameBackgroundItemGizmo(ImageItem imageitem)
    {
        super(imageitem);
        c = new PointF[2];
        d = new PointF[2];
        c[0] = new PointF();
        c[1] = new PointF();
        d[0] = new PointF();
        d[1] = new PointF();
    }

    public static FrameBackgroundItemGizmo a(ImageItem imageitem)
    {
        return new FrameBackgroundItemGizmo(imageitem);
    }

    public final f a(MotionEvent motionevent, Camera camera, boolean flag)
    {
        g g1;
        int i1;
        i1 = motionevent.getActionMasked();
        g1 = ((ImageItem)a).a(camera);
        d[0].set(motionevent.getX(0), motionevent.getY(0));
        if (motionevent.getPointerCount() > 1)
        {
            d[1].set(motionevent.getX(1), motionevent.getY(1));
        }
        i1;
        JVM INSTR tableswitch 0 6: default 108
    //                   0 165
    //                   1 1256
    //                   2 238
    //                   3 108
    //                   4 108
    //                   5 185
    //                   6 1110;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        boolean flag1;
        flag = true;
        flag1 = false;
_L8:
        c[0].set(d[0]);
        c[1].set(d[1]);
        b.a = flag;
        b.b = flag1;
        return b;
_L2:
        flag = true;
        flag1 = true;
        k = GestureType.DRAG;
        j = true;
        continue; /* Loop/switch isn't completed */
_L5:
        j = false;
        boolean flag2 = true;
        boolean flag3 = true;
        k = GestureType.PINCH;
        flag = flag2;
        flag1 = flag3;
        if (motionevent.getPointerCount() == 2)
        {
            o = false;
            n = 0.0F;
            flag = flag2;
            flag1 = flag3;
        }
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
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[GestureType.PINCH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (k != null)
        {
            switch (_cls1.a[k.ordinal()])
            {
            default:
                flag1 = false;
                flag = true;
                break;

            case 1: // '\001'
                float f1 = d[0].x;
                float f3 = c[0].x;
                float f5 = d[0].y;
                float f8 = c[0].y;
                g1.a((f1 - f3) + g1.a());
                g1.b(g1.b() + (f5 - f8));
                flag1 = true;
                flag = true;
                j = false;
                break;

            case 2: // '\002'
                motionevent = ((ImageItem)a).a(camera);
                camera = ((ImageItem)a).r();
                float f4 = Geom.a(c[0], c[1]);
                float f6 = Geom.a(d[0], d[1]);
                e.set((c[0].x + c[1].x) / 2.0F, (c[0].y + c[1].y) / 2.0F);
                f.set((d[0].x + d[1].x) / 2.0F, (d[0].y + d[1].y) / 2.0F);
                float f2 = f4;
                if (f4 == 0.0F)
                {
                    f2 = 1.0F;
                }
                f2 = Geom.a(f6 / f2, l / camera.c(), m / camera.c());
                camera.b(camera.c() * f2, camera.d() * f2);
                i.setScale(f2, f2, e.x, e.y);
                g[0] = motionevent.a();
                g[1] = motionevent.b();
                i.mapPoints(h, g);
                motionevent.a(h[0], h[1]);
                double d1 = Math.atan2(c[0].y - c[1].y, c[0].x - c[1].x);
                f4 = (float)Math.toDegrees(Math.atan2(d[0].y - d[1].y, d[0].x - d[1].x) - d1);
                f2 = f4;
                if (!o)
                {
                    n = f4 + n;
                    float f7;
                    float f9;
                    if (n >= 15F)
                    {
                        o = true;
                        f2 = n - 15F;
                    } else
                    if (n <= -15F)
                    {
                        o = true;
                        f2 = n + 15F;
                    } else
                    {
                        f2 = 0.0F;
                    }
                }
                motionevent.e(motionevent.e() + f2);
                i.setRotate(f2, e.x, e.y);
                g[0] = motionevent.a();
                g[1] = motionevent.b();
                i.mapPoints(h, g);
                motionevent.a(h[0], h[1]);
                e.set((c[0].x + c[1].x) / 2.0F, (c[0].y + c[1].y) / 2.0F);
                f.set((d[0].x + d[1].x) / 2.0F, (d[0].y + d[1].y) / 2.0F);
                f2 = f.x;
                f4 = e.x;
                f7 = f.y;
                f9 = e.y;
                motionevent.a((f2 - f4) + motionevent.a(), (f7 - f9) + motionevent.b());
                flag1 = true;
                flag = true;
                break;
            }
        } else
        {
            flag = true;
            flag1 = false;
        }
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (k == GestureType.PINCH)
        {
            int j1;
            if (motionevent.getPointerCount() == 2)
            {
                k = GestureType.DRAG;
            } else
            {
                o = false;
                n = 0.0F;
            }
            j1 = 0;
            int l1;
            for (int k1 = 0; j1 < motionevent.getPointerCount() && k1 < 2; k1 = l1)
            {
                l1 = k1;
                if (j1 != motionevent.getActionIndex())
                {
                    c[k1].set(motionevent.getX(j1), motionevent.getY(j1));
                    d[k1].set(c[k1]);
                    l1 = k1 + 1;
                }
                j1++;
            }

            flag = true;
            flag1 = true;
        } else
        {
            flag = true;
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        camera.a(d[0], p);
        if (j && motionevent.getEventTime() - motionevent.getDownTime() <= 500L && !((ImageItem)a).a(camera, p.x, p.y))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = false;
        k = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(float f1, float f2)
    {
        l = f1;
        m = f2;
    }

    public final void a(Canvas canvas, Camera camera)
    {
    }

    private class GestureType extends Enum
    {

        private static final GestureType $VALUES[];
        public static final GestureType DRAG;
        public static final GestureType PINCH;

        public static GestureType valueOf(String s)
        {
            return (GestureType)Enum.valueOf(com/picsart/studio/editor/gizmo/FrameBackgroundItemGizmo$GestureType, s);
        }

        public static GestureType[] values()
        {
            return (GestureType[])$VALUES.clone();
        }

        static 
        {
            DRAG = new GestureType("DRAG", 0);
            PINCH = new GestureType("PINCH", 1);
            $VALUES = (new GestureType[] {
                DRAG, PINCH
            });
        }

        private GestureType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
