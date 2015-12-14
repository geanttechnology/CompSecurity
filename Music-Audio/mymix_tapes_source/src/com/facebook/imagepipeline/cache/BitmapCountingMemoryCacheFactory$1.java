// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.imagepipeline.image.CloseableImage;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            ValueDescriptor, BitmapCountingMemoryCacheFactory

static final class I
    implements ValueDescriptor
{

    public int getSizeInBytes(CloseableImage closeableimage)
    {
        return closeableimage.getSizeInBytes();
    }

    public volatile int getSizeInBytes(Object obj)
    {
        return getSizeInBytes((CloseableImage)obj);
    }

    I()
    {
    }
}
