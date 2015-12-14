// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView, RulerView

public final class a
    implements android.animation.matorUpdateListener
{

    private float a;
    private CropEditorView b;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        float f1 = valueanimator.getAnimatedFraction();
        CropEditorView.a(b, f - CropEditorView.h(b), CropEditorView.b(b).centerX(), CropEditorView.b(b).centerY(), false);
        CropEditorView.i(b).setProgress((1.0F - f1) * a);
        b.invalidate();
    }

    public stener(CropEditorView cropeditorview, float f)
    {
        b = cropeditorview;
        a = f;
        super();
    }
}
