// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

class emAnimatorListener extends emAnimatorListener
{

    final ExtensibleItemAnimator this$0;
    final ViewPropertyAnimatorCompat val$animation;
    final int val$deltaX;
    final int val$deltaY;
    final android.support.v7.widget.l.holder val$holder;

    public void onAnimationCancel(View view)
    {
        if (val$deltaX != 0)
        {
            ViewCompat.setTranslationX(view, 0.0F);
        }
        if (val$deltaY != 0)
        {
            ViewCompat.setTranslationY(view, 0.0F);
        }
    }

    public void onAnimationEnd(View view)
    {
        val$animation.setListener(null);
        dispatchMoveFinished(val$holder);
        ExtensibleItemAnimator.access$1000(ExtensibleItemAnimator.this).remove(val$holder);
        ExtensibleItemAnimator.access$700(ExtensibleItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchMoveStarting(val$holder);
    }

    t()
    {
        this$0 = final_extensibleitemanimator;
        val$holder = animatorlistener;
        val$deltaX = i;
        val$deltaY = j;
        val$animation = ViewPropertyAnimatorCompat.this;
        super();
    }
}
