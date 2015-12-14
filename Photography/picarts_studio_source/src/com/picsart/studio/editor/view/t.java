// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.fragment.TiltShiftFragment;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.brushlib.input.gesture.j;
import com.socialin.android.util.Geom;
import com.socialin.android.util.l;

// Referenced classes of package com.picsart.studio.editor.view:
//            TiltShiftEditorView

final class t
    implements b, h, j
{

    private PointF a;
    private PointF b;
    private PointF c;
    private PointF d;
    private PointF e;
    private PointF f;
    private PointF g;
    private PointF h;
    private TiltShiftEditorView i;

    private t(TiltShiftEditorView tiltshifteditorview)
    {
        i = tiltshifteditorview;
        super();
        a = new PointF();
        b = new PointF();
        c = new PointF();
        d = new PointF();
        e = new PointF();
        f = new PointF();
        g = new PointF();
        h = new PointF();
    }

    t(TiltShiftEditorView tiltshifteditorview, byte byte0)
    {
        this(tiltshifteditorview);
    }

    public final void a()
    {
        if (TiltShiftEditorView.i(i) == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR && (TiltShiftEditorView.m(i) || com.picsart.studio.editor.view.TiltShiftEditorView.b(i) != 0.0F))
        {
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(i.getContext());
            String s1 = TiltShiftFragment.c;
            TiltShiftEditorView tiltshifteditorview = i;
            int k = tiltshifteditorview.l + 1;
            tiltshifteditorview.l = k;
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s1, "linear_pinch_rotate", k, i.e.getHeight(), i.e.getWidth(), com.picsart.studio.editor.view.TiltShiftEditorView.j(i)));
        }
        String s;
        if (TiltShiftEditorView.n(i) != 1.0F)
        {
            TiltShiftEditorView.o(i);
            AnalyticUtils analyticutils1 = AnalyticUtils.getInstance(i.getContext());
            String s2 = TiltShiftFragment.c;
            TiltShiftEditorView tiltshifteditorview1;
            int i1;
            if (TiltShiftEditorView.i(i) == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
            {
                s = "linear_resize";
            } else
            {
                s = "radial_resize";
            }
            tiltshifteditorview1 = i;
            i1 = tiltshifteditorview1.l + 1;
            tiltshifteditorview1.l = i1;
            analyticutils1.track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s2, s, i1, i.e.getHeight(), i.e.getWidth(), com.picsart.studio.editor.view.TiltShiftEditorView.j(i)));
        }
        analyticutils1 = AnalyticUtils.getInstance(i.getContext());
        s2 = TiltShiftFragment.c;
        if (TiltShiftEditorView.i(i) == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
        {
            s = "linear_drag";
        } else
        {
            s = "radial_drag";
        }
        tiltshifteditorview1 = i;
        i1 = tiltshifteditorview1.l + 1;
        tiltshifteditorview1.l = i1;
        analyticutils1.track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s2, s, i1, i.e.getHeight(), i.e.getWidth(), com.picsart.studio.editor.view.TiltShiftEditorView.j(i)));
        com.picsart.studio.editor.view.TiltShiftEditorView.b(i, TiltShiftEditorView.p(i));
    }

    public final void a(float f1, float f2)
    {
        a.set(f1, f2);
        b.set(a);
        Camera camera = i.c;
        PointF pointf = b;
        camera.a(pointf, pointf);
        TiltShiftEditorView.a(i, (byte)0);
        TiltShiftEditorView.a(i)[0] = b.x;
        TiltShiftEditorView.a(i)[1] = b.y;
        Geom.a(TiltShiftEditorView.a(i), -com.picsart.studio.editor.view.TiltShiftEditorView.b(i), TiltShiftEditorView.c(i).centerX(), TiltShiftEditorView.c(i).centerY());
        TiltShiftEditorView.d(i).set(TiltShiftEditorView.a(i)[0], TiltShiftEditorView.a(i)[1]);
        if (TiltShiftEditorView.d(i).y <= TiltShiftEditorView.c(i).centerY() - TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) && TiltShiftEditorView.d(i).y >= TiltShiftEditorView.c(i).centerY() - TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) - (float)TiltShiftEditorView.g(i).getHeight() - 24F || TiltShiftEditorView.c(i).height() * TiltShiftEditorView.f(i) > (float)TiltShiftEditorView.g(i).getHeight() && TiltShiftEditorView.d(i).y >= TiltShiftEditorView.c(i).centerY() - TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) && TiltShiftEditorView.d(i).y <= (TiltShiftEditorView.c(i).centerY() - TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i))) + (float)TiltShiftEditorView.g(i).getHeight())
        {
            TiltShiftEditorView.a(i, (byte)-1);
        } else
        if (TiltShiftEditorView.d(i).y >= TiltShiftEditorView.c(i).centerY() + TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) && TiltShiftEditorView.d(i).y <= TiltShiftEditorView.c(i).centerY() + TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) + (float)TiltShiftEditorView.g(i).getHeight() + 24F || TiltShiftEditorView.c(i).height() * TiltShiftEditorView.f(i) > (float)TiltShiftEditorView.g(i).getHeight() && TiltShiftEditorView.d(i).y <= TiltShiftEditorView.c(i).centerY() + TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i)) && TiltShiftEditorView.d(i).y >= (TiltShiftEditorView.c(i).centerY() + TiltShiftEditorView.c(i).height() * (TiltShiftEditorView.e(i) / 2.0F + TiltShiftEditorView.f(i))) - (float)TiltShiftEditorView.g(i).getHeight())
        {
            TiltShiftEditorView.a(i, (byte)1);
            return;
        }
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        TiltShiftEditorView.k(i);
        TiltShiftEditorView.a(i, (byte)0);
        com.picsart.studio.editor.view.TiltShiftEditorView.l(i);
        d.set(f1, f2);
        e.set(f3, f4);
        Camera camera = i.c;
        PointF pointf = d;
        camera.a(pointf, pointf);
        camera = i.c;
        pointf = e;
        camera.a(pointf, pointf);
    }

    public final void a_(float f1, float f2)
    {
        TiltShiftEditorView tiltshifteditorview = i;
        boolean flag;
        if (!com.picsart.studio.editor.view.TiltShiftEditorView.j(i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tiltshifteditorview.setShowHandlers(flag);
    }

    public final void b(float f1, float f2)
    {
        if (com.picsart.studio.editor.view.TiltShiftEditorView.h(i) == 0)
        {
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(i.getContext());
            String s2 = TiltShiftFragment.c;
            String s;
            TiltShiftEditorView tiltshifteditorview;
            int k;
            if (TiltShiftEditorView.i(i) == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
            {
                s = "linear_drag";
            } else
            {
                s = "radial_drag";
            }
            tiltshifteditorview = i;
            k = tiltshifteditorview.l + 1;
            tiltshifteditorview.l = k;
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s2, s, k, i.e.getHeight(), i.e.getWidth(), com.picsart.studio.editor.view.TiltShiftEditorView.j(i)));
        } else
        {
            AnalyticUtils analyticutils1 = AnalyticUtils.getInstance(i.getContext());
            String s3 = TiltShiftFragment.c;
            String s1;
            TiltShiftEditorView tiltshifteditorview1;
            int i1;
            if (TiltShiftEditorView.i(i) == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
            {
                s1 = "linear_hardness_change";
            } else
            {
                s1 = "radial_hardness_change";
            }
            tiltshifteditorview1 = i;
            i1 = tiltshifteditorview1.l + 1;
            tiltshifteditorview1.l = i1;
            analyticutils1.track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s3, s1, i1, i.e.getHeight(), i.e.getWidth(), com.picsart.studio.editor.view.TiltShiftEditorView.j(i)));
        }
        a.set(0.0F, 0.0F);
        b.set(a);
    }

    public final void b(float f1, float f2, float f3, float f4)
    {
        g.set(f1, f2);
        h.set(f3, f4);
        Camera camera = i.c;
        PointF pointf = g;
        camera.a(pointf, pointf);
        camera = i.c;
        pointf = h;
        camera.a(pointf, pointf);
        l.a(g, h, c);
        l.a(d, e, f);
        f1 = Geom.a(g, h) / Math.max(1.0F, Geom.a(d, e));
        f2 = (float)Math.toDegrees(Geom.b(g, h) - Geom.b(d, e));
        f3 = Math.abs(f1 - 1.0F) / 2.0F;
        f4 = Math.abs(f2) / 90F;
        if (f4 > f3 || (double)f4 > 0.029999999999999999D || f3 != 0.0F && (double)Math.abs(f4 / f3 - 1.0F) < 0.20000000000000001D)
        {
            TiltShiftEditorView.a(i, f2, c.x, c.y);
        }
        TiltShiftEditorView.a(i, c.x - f.x, c.y - f.y);
        if (f3 > f4 || (double)f3 > 0.029999999999999999D || f3 != 0.0F && (double)Math.abs(f4 / f3 - 1.0F) < 0.20000000000000001D)
        {
            TiltShiftEditorView.a(i, f1);
        }
        d.set(g);
        e.set(h);
    }

    public final void c(float f1, float f2)
    {
        if (!b.equals(0.0F, 0.0F))
        {
            g.set(f1, f2);
            Camera camera = i.c;
            PointF pointf = g;
            camera.a(pointf, pointf);
            TiltShiftEditorView.a(i, g.x - b.x, g.y - b.y);
        }
        a.set(f1, f2);
        b.set(g);
    }
}
