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
    final angeInfo val$changeInfo;
    final View val$newView;
    final ViewPropertyAnimatorCompat val$newViewAnimation;

    public void onAnimationEnd(View view)
    {
        val$newViewAnimation.setListener(null);
        ViewCompat.setAlpha(val$newView, 1.0F);
        ViewCompat.setTranslationX(val$newView, 0.0F);
        ViewCompat.setTranslationY(val$newView, 0.0F);
        dispatchChangeFinished(val$changeInfo.newHolder, false);
        ExtensibleItemAnimator.access$1200(ExtensibleItemAnimator.this).remove(val$changeInfo.newHolder);
        ExtensibleItemAnimator.access$700(ExtensibleItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchChangeStarting(val$changeInfo.newHolder, false);
    }

    t()
    {
        this$0 = final_extensibleitemanimator;
        val$changeInfo = angeinfo;
        val$newViewAnimation = viewpropertyanimatorcompat;
        val$newView = View.this;
        super();
    }
}
