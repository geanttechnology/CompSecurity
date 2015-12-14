// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.item.CalloutItem;
import com.socialin.android.util.Geom;
import myobfuscated.b.a;

// Referenced classes of package com.picsart.studio.editor.gizmo:
//            Gizmo

public final class CalloutGizmo extends Gizmo
{

    private final Drawable b;
    private final Drawable c;
    private PointF d;
    private PointF e;
    private PointF f;
    private PointF g;
    private boolean h;
    private PointF i;
    private PointF j;
    private Handle k;
    private f l;
    private boolean m;
    private long n;
    private Gizmo.Action o;

    public CalloutGizmo(Resources resources, CalloutItem calloutitem)
    {
        super(calloutitem);
        d = new PointF();
        e = new PointF();
        f = new PointF();
        g = new PointF();
        i = new PointF();
        j = new PointF();
        l = new f();
        m = false;
        n = 0L;
        b = resources.getDrawable(0x7f020248);
        if (b != null)
        {
            b.setBounds(new Rect(-b.getIntrinsicWidth() / 2, -b.getIntrinsicHeight() / 2, b.getIntrinsicWidth() / 2, b.getIntrinsicHeight() / 2));
        }
        c = resources.getDrawable(0x7f02024d);
        if (c != null)
        {
            c.setBounds(new Rect(-c.getIntrinsicWidth() / 2, -c.getIntrinsicHeight() / 2, c.getIntrinsicWidth() / 2, c.getIntrinsicHeight() / 2));
        }
    }

    public final f a(MotionEvent motionevent, Camera camera, boolean flag)
    {
        float f1;
        float f3;
        int i1;
        i1 = motionevent.getActionMasked();
        f1 = motionevent.getX();
        f3 = motionevent.getY();
        g.set(f1, f3);
        PointF pointf = g;
        camera.a(pointf, pointf);
        i1;
        JVM INSTR tableswitch 0 2: default 72
    //                   0 115
    //                   1 481
    //                   2 572;
           goto _L1 _L2 _L3 _L4
_L1:
        boolean flag1;
        flag1 = true;
        flag = false;
        h = false;
_L5:
        f.set(g);
        l.b = flag;
        l.a = flag1;
        return l;
_L2:
        i.set(((CalloutItem)a).c.x, ((CalloutItem)a).c.y);
        j.set(((CalloutItem)a).d.x, ((CalloutItem)a).d.y);
        camera.a(i);
        camera.a(j);
        float f5 = ((CalloutItem)a).a;
        f5 = camera.e * f5;
        float f6 = ((CalloutItem)a).b * camera.e;
        if ((double)Geom.a(i.x, i.y, f1, f3) < Math.pow(b.getIntrinsicWidth() / 2, 2D))
        {
            motionevent = Handle.SRC;
        } else
        if ((double)Geom.a(j.x + f5 / 2.0F, j.y + f6 / 2.0F, f1, f3) < Math.pow(c.getIntrinsicWidth() / 2, 2D))
        {
            motionevent = Handle.SCALE;
        } else
        if (Math.abs(f1 - j.x) < f5 / 2.0F && Math.abs(f3 - j.y) < f6 / 2.0F)
        {
            motionevent = Handle.DST;
        } else
        {
            motionevent = null;
        }
        k = motionevent;
        if (m && System.currentTimeMillis() - n <= 500L)
        {
            k = null;
            ((CalloutItem)a).e();
            m = false;
        } else
        {
            m = true;
            n = System.currentTimeMillis();
        }
        flag1 = true;
        if (k != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = true;
          goto _L5
_L3:
        if (h && motionevent.getEventTime() - motionevent.getDownTime() <= 500L && !((CalloutItem)a).a(camera, g.x, g.y))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        k = null;
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Handle.values().length];
                try
                {
                    a[Handle.SRC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Handle.DST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Handle.SCALE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        float f2;
        float f4;
        if (o != null)
        {
            ((CalloutItem)a).a(o);
            flag = false;
        } else
        {
            flag = false;
        }
          goto _L5
_L4:
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_814;
        }
        h = false;
        f2 = g.x - f.x;
        f4 = g.y - f.y;
        if (Math.abs(f2) > 5F || Math.abs(f4) > 5F)
        {
            m = false;
        }
        com.picsart.studio.editor.gizmo._cls1.a[k.ordinal()];
        JVM INSTR tableswitch 1 3: default 684
    //                   1 692
    //                   2 729
    //                   3 766;
           goto _L6 _L7 _L8 _L9
_L6:
        flag = true;
_L10:
        flag1 = true;
          goto _L5
_L7:
        o = Gizmo.Action.DRAG1;
        motionevent = (CalloutItem)a;
        ((CalloutItem) (motionevent)).c.offset(f2, f4);
        motionevent.o();
        motionevent.b();
          goto _L6
_L8:
        o = Gizmo.Action.SIZE_DRAG;
        motionevent = (CalloutItem)a;
        ((CalloutItem) (motionevent)).d.offset(f2, f4);
        motionevent.o();
        motionevent.b();
          goto _L6
_L9:
        o = Gizmo.Action.DRAG;
        motionevent = (CalloutItem)a;
        motionevent.a = f2 + ((CalloutItem) (motionevent)).a;
        motionevent.b = ((CalloutItem) (motionevent)).b + f4;
        motionevent.o();
        motionevent.b();
          goto _L6
        flag = false;
          goto _L10
    }

    public final void a(Canvas canvas, Camera camera)
    {
        d.set(((CalloutItem)a).c.x, ((CalloutItem)a).c.y);
        e.set(((CalloutItem)a).d.x, ((CalloutItem)a).d.y);
        camera.a(d);
        camera.a(e);
        myobfuscated.b.a.drawWithIntrinsicSize(canvas, b, d);
        Drawable drawable = c;
        float f1 = e.x;
        float f2 = (((CalloutItem)a).a * camera.e) / 2.0F;
        float f3 = e.y;
        myobfuscated.b.a.drawWithIntrinsicSize(canvas, drawable, f1 + f2, (((CalloutItem)a).b * camera.e) / 2.0F + f3);
        canvas.restore();
    }

    private class Handle extends Enum
    {

        private static final Handle $VALUES[];
        public static final Handle DST;
        public static final Handle SCALE;
        public static final Handle SRC;

        public static Handle valueOf(String s)
        {
            return (Handle)Enum.valueOf(com/picsart/studio/editor/gizmo/CalloutGizmo$Handle, s);
        }

        public static Handle[] values()
        {
            return (Handle[])$VALUES.clone();
        }

        static 
        {
            SRC = new Handle("SRC", 0);
            DST = new Handle("DST", 1);
            SCALE = new Handle("SCALE", 2);
            $VALUES = (new Handle[] {
                SRC, DST, SCALE
            });
        }

        private Handle(String s, int i1)
        {
            super(s, i1);
        }
    }

}
