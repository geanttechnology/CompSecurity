// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.socialin.android.util.Geom;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView, RulerView

public final class g
    implements android.animation.atorUpdateListener
{

    private RectF a;
    private RectF b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private CropEditorView h;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
        float f2 = valueanimator.getAnimatedFraction();
        Geom.a(CropEditorView.b(h), a, b, f2);
        float f3 = (c + (d - c) * f2) / CropEditorView.k(h).width();
        Geom.c(CropEditorView.k(h), CropEditorView.b(h).centerX(), CropEditorView.b(h).centerY(), f3);
        CropEditorView.c(h, 90F * f2);
        CropEditorView.a(h, Geom.b(e, f, f2));
        CropEditorView.a(h, f1 - CropEditorView.h(h), CropEditorView.b(h).centerX(), CropEditorView.b(h).centerY(), false);
        CropEditorView.i(h).setProgress((1.0F - f2) * g);
        h.invalidate();
    }

    public tener(CropEditorView cropeditorview, RectF rectf, RectF rectf1, float f1, float f2, float f3, float f4, 
            float f5)
    {
        h = cropeditorview;
        a = rectf;
        b = rectf1;
        c = f1;
        d = f2;
        e = f3;
        f = f4;
        g = f5;
        super();
    }
}
