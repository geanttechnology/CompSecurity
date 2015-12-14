// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.f;
import com.picsart.studio.editor.fragment.q;
import com.picsart.studio.editor.item.LensFlareItem;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.lensflare.a;
import com.socialin.android.util.Geom;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.gizmo:
//            Gizmo

public final class LensFlareGizmo extends Gizmo
{

    private final Drawable b;
    private final Drawable c;
    private final Drawable d;
    private PointF e;
    private PointF f;
    private boolean g;
    private float h;
    private float i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private Handle n;
    private f o;
    private boolean p;

    public LensFlareGizmo(Resources resources, LensFlareItem lensflareitem)
    {
        super(lensflareitem);
        e = new PointF();
        f = new PointF();
        l = new PointF();
        m = new PointF();
        o = new f();
        b = resources.getDrawable(0x7f020247);
        if (b != null)
        {
            b.setBounds(new Rect(-b.getIntrinsicWidth() / 2, -b.getIntrinsicHeight() / 2, b.getIntrinsicWidth() / 2, b.getIntrinsicHeight() / 2));
        }
        c = resources.getDrawable(0x7f02024d);
        if (c != null)
        {
            c.setBounds(new Rect(-c.getIntrinsicWidth() / 2, -c.getIntrinsicHeight() / 2, c.getIntrinsicWidth() / 2, c.getIntrinsicHeight() / 2));
        }
        d = resources.getDrawable(0x7f02024c);
        if (d != null)
        {
            d.setBounds(new Rect(-d.getIntrinsicWidth() / 2, -d.getIntrinsicHeight() / 2, d.getIntrinsicWidth() / 2, d.getIntrinsicHeight() / 2));
        }
    }

    public final f a(MotionEvent motionevent, Camera camera, boolean flag)
    {
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i1;
        i1 = motionevent.getActionMasked();
        f3 = motionevent.getX();
        f4 = motionevent.getY();
        flag = ((LensFlareItem)a).g;
        f1 = ((LensFlareItem)a).c.x;
        f2 = ((LensFlareItem)a).c.y;
        f5 = ((LensFlareItem)a).d.x;
        f6 = ((LensFlareItem)a).d.y;
        f7 = ((LensFlareItem)a).b;
        f.set(f3, f4);
        PointF pointf = f;
        camera.a(pointf, pointf);
        i1;
        JVM INSTR tableswitch 0 2: default 156
    //                   0 199
    //                   1 676
    //                   2 976;
           goto _L1 _L2 _L3 _L4
_L1:
        boolean flag1;
        flag = true;
        flag1 = false;
        g = false;
_L12:
        e.set(f);
        o.b = flag1;
        o.a = flag;
        return o;
_L2:
        float f8;
        float f9;
        f8 = ((LensFlareItem)a).e;
        f9 = ((LensFlareItem)a).f;
        l.set(((LensFlareItem)a).c.x, ((LensFlareItem)a).c.y);
        m.set(((LensFlareItem)a).d.x, ((LensFlareItem)a).d.y);
        camera.a(l);
        camera.a(m);
        if (Geom.a(l.x, l.y, f3, f4) >= f8) goto _L6; else goto _L5
_L5:
        motionevent = Handle.SRC;
_L17:
        n = motionevent;
        if (flag && n == null && ((LensFlareItem)a).a(camera, (a)((LensFlareItem)a).a.get(0), f.x, f.y))
        {
            n = Handle.SRC;
        }
        if (n == null) goto _L8; else goto _L7
_L7:
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Handle.values().length];
                try
                {
                    a[Handle.SCALE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Handle.ROTATE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Handle.SRC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Handle.DST.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.gizmo._cls1.a[n.ordinal()];
        JVM INSTR tableswitch 1 2: default 448
    //                   1 593
    //                   2 627;
           goto _L9 _L10 _L11
_L9:
        flag1 = true;
_L19:
        flag = true;
        g = true;
          goto _L12
_L6:
        if (!((LensFlareItem)a).g) goto _L14; else goto _L13
_L13:
        if (Geom.a(l.x + f9, l.y - f9, f3, f4) >= f8) goto _L16; else goto _L15
_L15:
        motionevent = Handle.ROTATE;
          goto _L17
_L14:
        if (Geom.a(m.x, m.y, f3, f4) >= f8) goto _L16; else goto _L18
_L18:
        motionevent = Handle.DST;
          goto _L17
_L16:
        if (Geom.a(l.x + f9, f9 + l.y, f3, f4) < f8)
        {
            motionevent = Handle.SCALE;
        } else
        {
            motionevent = null;
        }
          goto _L17
_L10:
        h = f7;
        i = Geom.b(f1, f2, f.x, f.y);
          goto _L9
_L11:
        j = Geom.c(f1, f2, f.x, f.y);
        k = Geom.c(f1, f2, f5, f6);
          goto _L9
_L8:
        flag1 = false;
          goto _L19
_L3:
        if (g && motionevent.getEventTime() - motionevent.getDownTime() <= 500L && !((LensFlareItem)a).a(camera, f.x, f.y))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (n == null) goto _L21; else goto _L20
_L20:
        com.picsart.studio.editor.gizmo._cls1.a[n.ordinal()];
        JVM INSTR tableswitch 1 4: default 776
    //                   1 922
    //                   2 868
    //                   3 814
    //                   4 814;
           goto _L21 _L22 _L23 _L24 _L24
_L21:
        n = null;
        if (p)
        {
            ((LensFlareItem)a).o();
        }
        p = false;
        flag1 = false;
          goto _L12
_L24:
        AnalyticUtils.getInstance(null).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(q.c, "point_drag", com.picsart.studio.editor.e.a().b.getWidth(), com.picsart.studio.editor.e.a().b.getHeight(), 0, ((LensFlareItem)a).a(), -1, -1, 0));
          goto _L21
_L23:
        AnalyticUtils.getInstance(null).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(q.c, "rotate_drag", com.picsart.studio.editor.e.a().b.getWidth(), com.picsart.studio.editor.e.a().b.getHeight(), 0, ((LensFlareItem)a).a(), -1, -1, 0));
          goto _L21
_L22:
        AnalyticUtils.getInstance(null).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(q.c, "size_drag", com.picsart.studio.editor.e.a().b.getWidth(), com.picsart.studio.editor.e.a().b.getHeight(), 0, ((LensFlareItem)a).a(), -1, -1, 0));
          goto _L21
_L4:
        if (n == null) goto _L26; else goto _L25
_L25:
        g = false;
        f3 = f.x - e.x;
        f4 = f.y - e.y;
        com.picsart.studio.editor.gizmo._cls1.a[n.ordinal()];
        JVM INSTR tableswitch 1 4: default 1064
    //                   1 1140
    //                   2 1188
    //                   3 1079
    //                   4 1123;
           goto _L27 _L28 _L29 _L30 _L31
_L27:
        flag = true;
        p = true;
_L32:
        flag1 = flag;
        flag = true;
          goto _L12
_L30:
        motionevent = (LensFlareItem)a;
        ((LensFlareItem) (motionevent)).c.offset(f3, f4);
        motionevent.o();
        if (flag)
        {
            ((LensFlareItem)a).c(f3, f4);
        }
          goto _L27
_L31:
        ((LensFlareItem)a).c(f3, f4);
          goto _L27
_L28:
        f1 = Geom.b(f1, f2, f.x, f.y);
        ((LensFlareItem)a).a((f1 * h) / i);
          goto _L27
_L29:
        double d1 = Geom.c(f1, f2, f.x, f.y) - j;
        d1 = (double)k + d1;
        ((LensFlareItem)a).b(100F * (float)Math.cos(d1) + f1, (float)Math.sin(d1) * 100F + f2);
          goto _L27
_L26:
        flag = false;
          goto _L32
    }

    public final void a(Canvas canvas, Camera camera)
    {
        if (p)
        {
            return;
        }
        l.set(((LensFlareItem)a).c.x, ((LensFlareItem)a).c.y);
        m.set(((LensFlareItem)a).d.x, ((LensFlareItem)a).d.y);
        camera.a(l);
        camera.a(m);
        myobfuscated.b.a.drawWithIntrinsicSize(canvas, b, l);
        float f1;
        float f2;
        float f3;
        if (((LensFlareItem)a).g)
        {
            myobfuscated.b.a.drawWithIntrinsicSize(canvas, d, l.x + ((LensFlareItem)a).f, l.y - ((LensFlareItem)a).f);
        } else
        {
            myobfuscated.b.a.drawWithIntrinsicSize(canvas, b, m);
        }
        camera = c;
        f1 = l.x;
        f2 = ((LensFlareItem)a).f;
        f3 = l.y;
        myobfuscated.b.a.drawWithIntrinsicSize(canvas, camera, f1 + f2, ((LensFlareItem)a).f + f3);
        canvas.restore();
    }

    private class Handle extends Enum
    {

        private static final Handle $VALUES[];
        public static final Handle DST;
        public static final Handle ROTATE;
        public static final Handle SCALE;
        public static final Handle SRC;

        public static Handle valueOf(String s)
        {
            return (Handle)Enum.valueOf(com/picsart/studio/editor/gizmo/LensFlareGizmo$Handle, s);
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
            ROTATE = new Handle("ROTATE", 3);
            $VALUES = (new Handle[] {
                SRC, DST, SCALE, ROTATE
            });
        }

        private Handle(String s, int i1)
        {
            super(s, i1);
        }
    }

}
