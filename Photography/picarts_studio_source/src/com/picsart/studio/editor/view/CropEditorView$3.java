// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

public final class a extends ag
{

    private Runnable a;
    private CropEditorView b;

    public final void onAnimationCancel(Animator animator)
    {
        super.onAnimationCancel(animator);
        CropEditorView.a(b, false);
        CropEditorView.b(b, false);
        CropEditorView.s(b);
    }

    public final void onAnimationEnd(Animator animator)
    {
        CropEditorView.a(b, false);
        CropEditorView.j(b).removeAllListeners();
        CropEditorView.j(b).removeAllUpdateListeners();
        CropEditorView.a(b, null);
        CropEditorView.b(b, false);
        if (a != null)
        {
            a.run();
        }
        CropEditorView.g(b);
        CropEditorView.s(b);
    }

    public final void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        CropEditorView.a(b, true);
    }

    public (CropEditorView cropeditorview, Runnable runnable)
    {
        b = cropeditorview;
        a = null;
        super();
    }
}
