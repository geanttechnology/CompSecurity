// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.factory;

import android.os.SystemClock;
import com.facebook.common.time.MonotonicClock;

// Referenced classes of package com.facebook.imagepipeline.animated.factory:
//            AnimatedDrawableFactory

class this._cls0
    implements MonotonicClock
{

    final AnimatedDrawableFactory this$0;

    public long now()
    {
        return SystemClock.uptimeMillis();
    }

    ()
    {
        this$0 = AnimatedDrawableFactory.this;
        super();
    }
}
