// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

// Referenced classes of package com.facebook.imagepipeline.image:
//            ImageInfo, ImmutableQualityInfo, QualityInfo

public abstract class CloseableImage
    implements Closeable, ImageInfo
{

    private static final String TAG = "CloseableImage";

    public CloseableImage()
    {
    }

    public abstract void close();

    protected void finalize()
        throws Throwable
    {
        if (isClosed())
        {
            return;
        }
        FLog.w("CloseableImage", "finalize: %s %x still open.", new Object[] {
            getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this))
        });
        close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public QualityInfo getQualityInfo()
    {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful()
    {
        return false;
    }
}
