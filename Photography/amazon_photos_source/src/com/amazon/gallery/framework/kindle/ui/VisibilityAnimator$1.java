// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            VisibilityAnimator

class this._cls0 extends AnimatorListenerAdapter
{

    final VisibilityAnimator this$0;

    public void onAnimationEnd(Animator animator)
    {
        VisibilityAnimator.access$000(VisibilityAnimator.this).setVisibility(4);
        VisibilityAnimator.access$102(VisibilityAnimator.this, ate.INVISIBLE);
        VisibilityAnimator.access$202(VisibilityAnimator.this, null);
        onHidden();
    }

    ate()
    {
        this$0 = VisibilityAnimator.this;
        super();
    }
}
