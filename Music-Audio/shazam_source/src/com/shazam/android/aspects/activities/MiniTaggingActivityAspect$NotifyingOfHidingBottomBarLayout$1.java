// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;


// Referenced classes of package com.shazam.android.aspects.activities:
//            MiniTaggingActivityAspect

class val.actionToPerformOnAnimationEnd
    implements Runnable
{

    final tContext this$1;
    final Runnable val$actionToPerformOnAnimationEnd;

    public void run()
    {
        if (val$actionToPerformOnAnimationEnd != null)
        {
            val$actionToPerformOnAnimationEnd.run();
        }
        MiniTaggingActivityAspect.access$000(_fld0, tContext());
    }

    ()
    {
        this$1 = final_;
        val$actionToPerformOnAnimationEnd = Runnable.this;
        super();
    }
}
