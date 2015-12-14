// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.view:
//            d, CropEditorView

final class c extends d
{

    private float b;
    private float c;
    private float d;
    private float e;
    private com.socialin.android.util.Geom.HorizontalSide f;
    private com.socialin.android.util.Geom.VerticalSide g;
    private CropEditorView h;

    public c(CropEditorView cropeditorview, CropEditorView cropeditorview1)
    {
        h = cropeditorview;
        super(cropeditorview1, (byte)0);
    }

    public final CropEditorView.Response a(MotionEvent motionevent)
    {
        float f1;
        float f2;
        float f3;
        int i;
        f2 = 0.0F;
        i = motionevent.getActionMasked();
        f1 = motionevent.getX();
        f3 = motionevent.getY();
        i;
        JVM INSTR tableswitch 0 6: default 64
    //                   0 68
    //                   1 306
    //                   2 233
    //                   3 64
    //                   4 64
    //                   5 276
    //                   6 291;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return CropEditorView.Response.REJECT;
_L2:
        b = f1;
        c = f3;
        g = Geom.a(CropEditorView.b(a), b, c, CropEditorView.v(a));
        f = Geom.b(CropEditorView.b(a), b, c, CropEditorView.v(a));
        if (g == null)
        {
            f1 = 0.0F;
        } else
        {
            f1 = Geom.a(CropEditorView.b(a), g) - b;
        }
        d = f1;
        if (f == null)
        {
            f1 = f2;
        } else
        {
            f1 = Geom.a(CropEditorView.b(a), f) - c;
        }
        e = f1;
        if (g == null && f == null)
        {
            return CropEditorView.Response.REJECT;
        } else
        {
            return CropEditorView.Response.ACCEPT;
        }
_L4:
        if (a())
        {
            CropEditorView.a(a, g, f, f1 + d, f3 + e);
            return CropEditorView.Response.ACCEPT;
        } else
        {
            return CropEditorView.Response.REJECT;
        }
_L5:
        if (a())
        {
            return CropEditorView.Response.ACCEPT;
        } else
        {
            return CropEditorView.Response.REJECT;
        }
_L6:
        if (a())
        {
            return CropEditorView.Response.ACCEPT;
        } else
        {
            return CropEditorView.Response.REJECT;
        }
_L3:
        CropEditorView.w(a);
        motionevent = AnalyticUtils.getInstance(a.getContext());
        String s = CropEditorView.d(h);
        CropEditorView cropeditorview = h;
        int j = cropeditorview.s + 1;
        cropeditorview.s = j;
        motionevent.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s, j, a.getRotation(), "", CropEditorView.e(a), CropEditorView.f(a).getWidth(), CropEditorView.f(a).getHeight(), a.b(), a.c(), "rectangle_resize"));
        if (true) goto _L1; else goto _L7
_L7:
    }
}
