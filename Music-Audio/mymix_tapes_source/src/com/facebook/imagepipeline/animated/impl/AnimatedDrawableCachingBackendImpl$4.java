// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedDrawableCachingBackendImpl

class val.frameNumber
    implements Continuation
{

    final AnimatedDrawableCachingBackendImpl this$0;
    final int val$frameNumber;
    final Task val$newFuture;

    public Object then(Task task)
        throws Exception
    {
        AnimatedDrawableCachingBackendImpl.access$300(AnimatedDrawableCachingBackendImpl.this, val$newFuture, val$frameNumber);
        return null;
    }

    ()
    {
        this$0 = final_animateddrawablecachingbackendimpl;
        val$newFuture = task;
        val$frameNumber = I.this;
        super();
    }
}
