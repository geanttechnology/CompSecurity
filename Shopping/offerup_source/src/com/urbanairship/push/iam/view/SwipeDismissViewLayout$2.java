// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.view.ViewTreeObserver;

// Referenced classes of package com.urbanairship.push.iam.view:
//            SwipeDismissViewLayout

class val.xFraction
    implements android.view.wListener
{

    final SwipeDismissViewLayout this$0;
    final float val$xFraction;

    public boolean onPreDraw()
    {
        setXFraction(val$xFraction);
        getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    ()
    {
        this$0 = final_swipedismissviewlayout;
        val$xFraction = F.this;
        super();
    }
}
