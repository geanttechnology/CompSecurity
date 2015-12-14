// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.picsart.studio.editor.view:
//            r, CropEditorView

final class a
    implements r
{

    private CropEditorView a;

    public final void a()
    {
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.getContext());
        String s = CropEditorView.d(a);
        CropEditorView cropeditorview = a;
        int i = cropeditorview.s + 1;
        cropeditorview.s = i;
        analyticutils.track(new com.socialin.android.apiv3.events.lCropTryEvent(s, i, a.getRotation(), "", CropEditorView.e(a), CropEditorView.f(a).getWidth(), CropEditorView.f(a).getHeight(), a.b(), a.c(), "strengthen"));
    }

    public final void a(float f)
    {
        CropEditorView.a(a, f - CropEditorView.a(a), CropEditorView.b(a).centerX(), CropEditorView.b(a).centerY(), true);
        CropEditorView.c(a);
    }

    ToolCropTryEvent(CropEditorView cropeditorview)
    {
        a = cropeditorview;
        super();
    }
}
