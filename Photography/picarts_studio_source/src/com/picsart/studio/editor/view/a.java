// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.brushlib.input.gesture.j;
import com.socialin.android.util.Geom;
import com.socialin.android.util.l;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class a
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
    private PointF i;
    private CropEditorView j;

    private a(CropEditorView cropeditorview)
    {
        j = cropeditorview;
        super();
        a = new PointF();
        b = new PointF();
        c = new PointF();
        d = new PointF();
        e = new PointF();
        f = new PointF();
        g = new PointF();
        h = new PointF();
        i = new PointF();
    }

    a(CropEditorView cropeditorview, byte byte0)
    {
        this(cropeditorview);
    }

    public final void a()
    {
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(j.getContext());
        String s = CropEditorView.d(j);
        CropEditorView cropeditorview = j;
        int k = cropeditorview.s + 1;
        cropeditorview.s = k;
        analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s, k, j.getRotation(), "", CropEditorView.e(j), CropEditorView.f(j).getWidth(), CropEditorView.f(j).getHeight(), j.b(), j.c(), "pinch_zoom"));
    }

    public final void a(float f1, float f2)
    {
        a.set(f1, f2);
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        c.set(f1, f2);
        d.set(f3, f4);
        e.set(f1, f2);
        f.set(f3, f4);
    }

    public final void a_(float f1, float f2)
    {
        CropEditorView cropeditorview = j;
        boolean flag;
        if (!CropEditorView.y(j))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CropEditorView.c(cropeditorview, flag);
        j.invalidate();
    }

    public final void b(float f1, float f2)
    {
        a.set(0.0F, 0.0F);
    }

    public final void b(float f1, float f2, float f3, float f4)
    {
        h.set(f1, f2);
        i.set(f3, f4);
        l.a(h, i, b);
        l.a(e, f, g);
        f1 = Geom.a(h, i) / Math.max(1.0F, Geom.a(e, f));
        CropEditorView.a(j, f1, b.x, b.y);
        CropEditorView.a(j, b.x - g.x, b.y - g.y);
        e.set(h);
        f.set(i);
    }

    public final void c(float f1, float f2)
    {
        if (!a.equals(0.0F, 0.0F))
        {
            CropEditorView.a(j, f1 - a.x, f2 - a.y);
        }
        a.set(f1, f2);
    }
}
