// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView, RulerView

final class a
    implements android.animation.matorUpdateListener
{

    private CropEditorView a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        CropEditorView.a(a, ((Float)valueanimator.getAnimatedValue()).floatValue() - CropEditorView.h(a), CropEditorView.b(a).centerX(), CropEditorView.b(a).centerY(), true);
        CropEditorView.i(a).setProgress(CropEditorView.a(a));
    }

    stener(CropEditorView cropeditorview)
    {
        a = cropeditorview;
        super();
    }
}
