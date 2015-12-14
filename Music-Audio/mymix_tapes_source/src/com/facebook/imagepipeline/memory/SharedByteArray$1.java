// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            SharedByteArray

class this._cls0
    implements ResourceReleaser
{

    final SharedByteArray this$0;

    public volatile void release(Object obj)
    {
        release((byte[])obj);
    }

    public void release(byte abyte0[])
    {
        mSemaphore.release();
    }

    _cls9()
    {
        this$0 = SharedByteArray.this;
        super();
    }
}
