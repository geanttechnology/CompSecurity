// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import com.shazam.android.aspects.c.a.a;
import com.shazam.android.widget.b;

// Referenced classes of package com.shazam.android.aspects.activities:
//            MiniTaggingActivityAspect

private class this._cls0 extends b
{

    final MiniTaggingActivityAspect this$0;

    public void hideBottomBar(final Runnable actionToPerformOnAnimationEnd)
    {
        super.hideBottomBar(new Runnable() {

            final MiniTaggingActivityAspect.NotifyingOfHidingBottomBarLayout this$1;
            final Runnable val$actionToPerformOnAnimationEnd;

            public void run()
            {
                if (actionToPerformOnAnimationEnd != null)
                {
                    actionToPerformOnAnimationEnd.run();
                }
                MiniTaggingActivityAspect.access$000(this$0, getContext());
            }

            
            {
                this$1 = MiniTaggingActivityAspect.NotifyingOfHidingBottomBarLayout.this;
                actionToPerformOnAnimationEnd = runnable;
                super();
            }
        });
    }

    public void hideBottomBarNoAnimation()
    {
        super.hideBottomBarNoAnimation();
        MiniTaggingActivityAspect.access$000(MiniTaggingActivityAspect.this, getContext());
    }

    public _cls1.val.actionToPerformOnAnimationEnd(a a)
    {
        this$0 = MiniTaggingActivityAspect.this;
        super(a);
    }
}
