// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class a
    implements android.animation.atorUpdateListener
{

    private boolean a;
    private CropEditorView b;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        CropEditorView.k(b).set((RectF)valueanimator.getAnimatedValue());
        if (!a)
        {
            CropEditorView.a(b, CropEditorView.k(b).width() / CropEditorView.n(b));
        }
        b.invalidate();
    }

    tener(CropEditorView cropeditorview, boolean flag)
    {
        b = cropeditorview;
        a = flag;
        super();
    }
}
