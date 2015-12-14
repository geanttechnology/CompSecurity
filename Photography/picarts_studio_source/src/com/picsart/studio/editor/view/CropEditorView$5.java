// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class a
    implements android.animation.matorUpdateListener
{

    private CropEditorView a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        valueanimator = (RectF)valueanimator.getAnimatedValue();
        CropEditorView.x(a).setRectToRect(CropEditorView.b(a), valueanimator, android.graphics..CENTER);
        CropEditorView.x(a).mapRect(CropEditorView.k(a));
        CropEditorView.b(a).set(valueanimator);
        CropEditorView.g(a);
        a.invalidate();
    }

    stener(CropEditorView cropeditorview)
    {
        a = cropeditorview;
        super();
    }
}
