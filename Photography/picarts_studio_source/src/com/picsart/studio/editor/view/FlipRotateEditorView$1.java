// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;

// Referenced classes of package com.picsart.studio.editor.view:
//            FlipRotateEditorView

final class a
    implements android.animation.pdateListener
{

    private FlipRotateEditorView a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        FlipRotateEditorView.a(a, (Matrix)valueanimator.getAnimatedValue());
        a.invalidate();
    }

    (FlipRotateEditorView fliprotateeditorview)
    {
        a = fliprotateeditorview;
        super();
    }
}
