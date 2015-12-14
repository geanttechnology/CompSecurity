// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import java.util.concurrent.Callable;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedDrawableCachingBackendImpl

class val.frameNumber
    implements Callable
{

    final AnimatedDrawableCachingBackendImpl this$0;
    final int val$frameNumber;

    public Object call()
    {
        AnimatedDrawableCachingBackendImpl.access$200(AnimatedDrawableCachingBackendImpl.this, val$frameNumber);
        return null;
    }

    ()
    {
        this$0 = final_animateddrawablecachingbackendimpl;
        val$frameNumber = I.this;
        super();
    }
}
