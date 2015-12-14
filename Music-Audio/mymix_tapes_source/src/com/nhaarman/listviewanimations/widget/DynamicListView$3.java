// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.widget;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.nhaarman.listviewanimations.widget:
//            DynamicListView

class this._cls0
    implements com.nineoldandroids.animation.atorUpdateListener
{

    final DynamicListView this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        invalidate();
    }

    eListener()
    {
        this$0 = DynamicListView.this;
        super();
    }
}
