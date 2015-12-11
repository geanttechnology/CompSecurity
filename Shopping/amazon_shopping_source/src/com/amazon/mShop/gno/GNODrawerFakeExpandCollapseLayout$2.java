// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.animation.Animation;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerFakeExpandCollapseLayout

class val.endAction
    implements android.view.animation.l.endAction
{

    final GNODrawerFakeExpandCollapseLayout this$0;
    final Runnable val$endAction;

    public void onAnimationEnd(Animation animation)
    {
        if (val$endAction != null)
        {
            val$endAction.run();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = final_gnodrawerfakeexpandcollapselayout;
        val$endAction = Runnable.this;
        super();
    }
}
