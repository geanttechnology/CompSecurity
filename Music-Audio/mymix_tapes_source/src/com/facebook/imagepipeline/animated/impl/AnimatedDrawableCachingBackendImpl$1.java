// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedDrawableCachingBackendImpl

class this._cls0
    implements this._cls0
{

    final AnimatedDrawableCachingBackendImpl this$0;

    public CloseableReference getCachedBitmap(int i)
    {
        return AnimatedDrawableCachingBackendImpl.access$100(AnimatedDrawableCachingBackendImpl.this, i);
    }

    public void onIntermediateResult(int i, Bitmap bitmap)
    {
        AnimatedDrawableCachingBackendImpl.access$000(AnimatedDrawableCachingBackendImpl.this, i, bitmap);
    }

    ()
    {
        this$0 = AnimatedDrawableCachingBackendImpl.this;
        super();
    }
}
