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
    final ViewPropertyAnimatorCompat val$oldViewAnim;

    public void onAnimationEnd(View view)
    {
        val$oldViewAnim.setListener(null);
        ViewCompat.setAlpha(view, 1.0F);
        ViewCompat.setTranslationX(view, 0.0F);
        ViewCompat.setTranslationY(view, 0.0F);
        dispatchChangeFinished(val$changeInfo.oldHolder, true);
        ExtensibleItemAnimator.access$1200(ExtensibleItemAnimator.this).remove(val$changeInfo.oldHolder);
        ExtensibleItemAnimator.access$700(ExtensibleItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchChangeStarting(val$changeInfo.oldHolder, true);
    }

    t()
    {
        this$0 = final_extensibleitemanimator;
        val$changeInfo = angeinfo;
        val$oldViewAnim = ViewPropertyAnimatorCompat.this;
        super();
    }
}
