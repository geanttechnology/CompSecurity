// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.editor.view.CropEditorView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            f

final class a
    implements android.view..OnClickListener
{

    private f a;

    public final void onClick(View view)
    {
        view = f.e(a);
        if (!((CropEditorView) (view)).l) goto _L2; else goto _L1
_L1:
        int i = ((CropEditorView) (view)).g + 1;
        view.g = i;
        float f1 = (float)i * 90F;
        if (((CropEditorView) (view)).b == null && !((CropEditorView) (view)).a)
        {
            view.r = true;
            float f3 = view.f();
            long l = (long)((300F * Math.abs(f1 - ((CropEditorView) (view)).h)) / 90F);
            view.b = ValueAnimator.ofFloat(new float[] {
                ((CropEditorView) (view)).h, f1
            });
            ((CropEditorView) (view)).b.addUpdateListener(new com.picsart.studio.editor.view.EditorView._cls2(view, f3));
            ((CropEditorView) (view)).b.addListener(new com.picsart.studio.editor.view.EditorView._cls3(view, null));
            ((CropEditorView) (view)).b.setDuration(l);
            ((CropEditorView) (view)).b.start();
        }
_L4:
        if (!f.h(a))
        {
            f.i(a);
        }
        view = AnalyticUtils.getInstance(a.getActivity());
        String s = f.f(a);
        CropEditorView cropeditorview = f.e(a);
        int j = cropeditorview.s + 1;
        cropeditorview.s = j;
        view.track(new com.socialin.android.apiv3.events.tsFactory.ToolCropTryEvent(s, j, f.e(a).getRotation(), f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "rotate"));
        return;
_L2:
        if (((CropEditorView) (view)).b == null && !((CropEditorView) (view)).a)
        {
            view.r = true;
            float f2 = ((CropEditorView) (view)).i.width() / 2.0F;
            float f6 = ((CropEditorView) (view)).i.height() / 2.0F;
            float f4 = ((CropEditorView) (view)).i.centerX();
            float f5 = ((CropEditorView) (view)).i.centerY();
            RectF rectf = new RectF(((CropEditorView) (view)).i);
            RectF rectf1 = new RectF(f4 - f6, f5 - f2, f6 + f4, f2 + f5);
            Geom.a(rectf1, ((CropEditorView) (view)).n, com.socialin.android.util..Fit.CENTER);
            f2 = rectf1.width() / ((CropEditorView) (view)).i.height();
            f6 = rectf1.width() / 2.0F;
            float f7 = rectf1.height() / 2.0F;
            RectF rectf2 = new RectF(f4 - f7, f5 - f6, f4 + f7, f5 + f6);
            f4 = ((CropEditorView) (view)).e.width();
            f5 = ((CropEditorView) (view)).f;
            f6 = ((CropEditorView) (view)).f;
            if (((CropEditorView) (view)).j)
            {
                view.k = 1.0F / ((CropEditorView) (view)).k;
            }
            f7 = view.f();
            float f8 = ((CropEditorView) (view)).h;
            int k = ((CropEditorView) (view)).g + 1;
            view.g = k;
            view.b = ValueAnimator.ofFloat(new float[] {
                f8, (float)k * 90F
            });
            ((CropEditorView) (view)).b.addUpdateListener(new com.picsart.studio.editor.view.EditorView._cls13(view, rectf, rectf2, f4, f4 * f2, f5, f6 * f2, f7));
            ((CropEditorView) (view)).b.addListener(new com.picsart.studio.editor.view.EditorView._cls14(view, rectf1));
            ((CropEditorView) (view)).b.setDuration(300L);
            ((CropEditorView) (view)).b.start();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    orView._cls14(f f1)
    {
        a = f1;
        super();
    }
}
