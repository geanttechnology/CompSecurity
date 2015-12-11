// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.ebay.android.widget:
//            ExtensibleItemAnimator

class t
    implements ViewPropertyAnimatorListener
{

    final ExtensibleItemAnimator this$0;
    final ViewPropertyAnimatorCompat val$animation;
    final android.support.v7.widget.l.holder val$holder;

    public void onAnimationCancel(View view)
    {
        onRemoveCanceled(val$holder);
    }

    public void onAnimationEnd(View view)
    {
        val$animation.setListener(null);
        dispatchRemoveFinished(val$holder);
        ExtensibleItemAnimator.access$600(ExtensibleItemAnimator.this).remove(val$holder);
        ExtensibleItemAnimator.access$700(ExtensibleItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchRemoveStarting(val$holder);
    }

    t()
    {
        this$0 = final_extensibleitemanimator;
        val$holder = r;
        val$animation = ViewPropertyAnimatorCompat.this;
        super();
    }
}
