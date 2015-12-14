// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.picsart.studio.editor.view:
//            SquareFitEditorView

public final class a
    implements android.animation.UpdateListener
{

    private SquareFitEditorView a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        SquareFitEditorView.b(a).set((RectF)valueanimator.getAnimatedValue());
        a.invalidate();
    }

    public r(SquareFitEditorView squarefiteditorview)
    {
        a = squarefiteditorview;
        super();
    }
}
