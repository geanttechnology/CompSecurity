// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.view:
//            SquareFitEditorView

public final class a extends ag
{

    private SquareFitEditorView a;

    public final void onAnimationCancel(Animator animator)
    {
        super.onAnimationCancel(animator);
        SquareFitEditorView.a(a, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        SquareFitEditorView.a(a, false);
        SquareFitEditorView.c(a).removeAllListeners();
        SquareFitEditorView.c(a).removeAllUpdateListeners();
        SquareFitEditorView.d(a);
    }

    public final void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        SquareFitEditorView.a(a, true);
    }

    public (SquareFitEditorView squarefiteditorview)
    {
        a = squarefiteditorview;
        super();
    }
}
