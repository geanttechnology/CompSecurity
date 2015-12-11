// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.view.animation.Animation;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            AnimatedExpandableListView

class val.dummyView
    implements android.view.animation.stAdapter._cls1
{

    final val.dummyView this$0;
    final val.dummyView val$dummyView;
    final int val$groupPosition;

    public void onAnimationEnd(Animation animation)
    {
        cess._mth600(this._cls0.this, val$groupPosition);
        tifyDataSetChanged();
        val$dummyView.dummyView(Integer.valueOf(0));
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = final_;
        val$groupPosition = i;
        val$dummyView = val.dummyView.this;
        super();
    }
}
