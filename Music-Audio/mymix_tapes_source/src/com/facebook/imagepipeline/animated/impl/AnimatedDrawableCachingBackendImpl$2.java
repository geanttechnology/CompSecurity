// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedDrawableCachingBackendImpl

class this._cls0
    implements ResourceReleaser
{

    final AnimatedDrawableCachingBackendImpl this$0;

    public void release(Bitmap bitmap)
    {
        releaseBitmapInternal(bitmap);
    }

    public volatile void release(Object obj)
    {
        release((Bitmap)obj);
    }

    ()
    {
        this$0 = AnimatedDrawableCachingBackendImpl.this;
        super();
    }
}
