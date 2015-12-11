// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.view.ViewTreeObserver;

// Referenced classes of package com.urbanairship.push.iam.view:
//            SwipeDismissViewLayout

class val.yFraction
    implements android.view.wListener
{

    final SwipeDismissViewLayout this$0;
    final float val$yFraction;

    public boolean onPreDraw()
    {
        setYFraction(val$yFraction);
        getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    ()
    {
        this$0 = final_swipedismissviewlayout;
        val$yFraction = F.this;
        super();
    }
}
