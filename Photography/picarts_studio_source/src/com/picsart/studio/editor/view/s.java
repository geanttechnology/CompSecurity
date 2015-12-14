// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.picsart.studio.editor.fragment.SquareFitFragment;
import com.picsart.studio.editor.helper.SimpleTransform;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.util.Geom;
import com.socialin.android.util.l;

// Referenced classes of package com.picsart.studio.editor.view:
//            SquareFitEditorView

final class s
    implements b, h
{

    private PointF a;
    private PointF b;
    private PointF c;
    private PointF d;
    private PointF e;
    private PointF f;
    private PointF g;
    private SquareFitEditorView h;

    private s(SquareFitEditorView squarefiteditorview)
    {
        h = squarefiteditorview;
        super();
        a = new PointF();
        b = new PointF();
        c = new PointF();
        d = new PointF();
        e = new PointF();
        f = new PointF();
        g = new PointF();
    }

    s(SquareFitEditorView squarefiteditorview, byte byte0)
    {
        this(squarefiteditorview);
    }

    public final void a()
    {
        if (SquareFitEditorView.j(h) || SquareFitEditorView.a(h) != 0.0F)
        {
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(h.getContext());
            String s1 = SquareFitFragment.c;
            SquareFitEditorView squarefiteditorview = h;
            int i = squarefiteditorview.l + 1;
            squarefiteditorview.l = i;
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s1, "pinch_rotate", i, SquareFitEditorView.k(h).getHeight(), SquareFitEditorView.k(h).getWidth()));
        }
        if (com.picsart.studio.editor.view.SquareFitEditorView.l(h) != 1.0F)
        {
            SquareFitEditorView.m(h);
            AnalyticUtils analyticutils1 = AnalyticUtils.getInstance(h.getContext());
            String s2 = SquareFitFragment.c;
            SquareFitEditorView squarefiteditorview1 = h;
            int j = squarefiteditorview1.l + 1;
            squarefiteditorview1.l = j;
            analyticutils1.track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s2, "custom_size", j, SquareFitEditorView.k(h).getHeight(), SquareFitEditorView.k(h).getWidth()));
        }
        SquareFitEditorView.a(h, SquareFitEditorView.n(h));
    }

    public final void a(float f1, float f2)
    {
        a.set(f1, f2);
        SquareFitEditorView.g(h).a(a);
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        com.picsart.studio.editor.view.SquareFitEditorView.h(h);
        SquareFitEditorView.i(h);
        c.set(f1, f2);
        d.set(f3, f4);
        SquareFitEditorView.g(h).a(c);
        SquareFitEditorView.g(h).a(d);
    }

    public final void b(float f1, float f2)
    {
        a.set(0.0F, 0.0F);
    }

    public final void b(float f1, float f2, float f3, float f4)
    {
        f.set(f1, f2);
        g.set(f3, f4);
        SquareFitEditorView.g(h).a(f);
        SquareFitEditorView.g(h).a(g);
        l.a(f, g, b);
        l.a(c, d, e);
        f1 = Geom.a(f, g) / Math.max(1.0F, Geom.a(c, d));
        f2 = (float)Math.toDegrees(Geom.b(f, g) - Geom.b(c, d));
        f3 = Math.abs(f1 - 1.0F) / 2.0F;
        f4 = Math.abs(f2) / 90F;
        if (f4 > f3 || (double)f4 > 0.029999999999999999D || f3 != 0.0F && (double)Math.abs(f4 / f3 - 1.0F) < 0.20000000000000001D)
        {
            SquareFitEditorView.a(h, f2, b.x, b.y);
        }
        SquareFitEditorView.a(h, b.x - e.x, b.y - e.y);
        if (f3 > f4 || (double)f3 > 0.029999999999999999D || f3 != 0.0F && (double)Math.abs(f4 / f3 - 1.0F) < 0.20000000000000001D)
        {
            com.picsart.studio.editor.view.SquareFitEditorView.b(h, f1, b.x, b.y);
        }
        c.set(f);
        d.set(g);
    }

    public final void c(float f1, float f2)
    {
        if (!a.equals(0.0F, 0.0F))
        {
            f.set(f1, f2);
            SquareFitEditorView.g(h).a(f);
            SquareFitEditorView.a(h, f.x - a.x, f.y - a.y);
        }
        a.set(f.x, f.y);
    }
}
