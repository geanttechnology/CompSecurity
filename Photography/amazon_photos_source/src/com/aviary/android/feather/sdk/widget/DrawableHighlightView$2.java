// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.aviary.android.feather.library.graphics.drawable.FeatherDrawable;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            DrawableHighlightView

class val.flipped
    implements com.nineoldandroids.animation.r
{

    final DrawableHighlightView this$0;
    final boolean val$flipped;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (DrawableHighlightView.access$000(DrawableHighlightView.this) != null)
        {
            animator = DrawableHighlightView.access$000(DrawableHighlightView.this);
            boolean flag;
            if (!val$flipped)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            animator.setHorizontalFlip(flag);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    awable()
    {
        this$0 = final_drawablehighlightview;
        val$flipped = Z.this;
        super();
    }
}
