// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

final class a extends ag
{

    private Runnable a;
    private CropEditorView b;

    public final void onAnimationCancel(Animator animator)
    {
        super.onAnimationCancel(animator);
        CropEditorView.a(b, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        CropEditorView.a(b, false);
        CropEditorView.a(b, null);
        if (a != null)
        {
            a.run();
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        CropEditorView.a(b, true);
    }

    (CropEditorView cropeditorview, Runnable runnable)
    {
        b = cropeditorview;
        a = runnable;
        super();
    }
}
