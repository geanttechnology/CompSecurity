// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

// Referenced classes of package com.facebook.imagepipeline.image:
//            CloseableBitmap, QualityInfo

public class CloseableStaticBitmap extends CloseableBitmap
{

    private volatile Bitmap mBitmap;
    private CloseableReference mBitmapReference;
    private final QualityInfo mQualityInfo;
    private final int mRotationAngle;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser resourcereleaser, QualityInfo qualityinfo, int i)
    {
        mBitmap = (Bitmap)Preconditions.checkNotNull(bitmap);
        mBitmapReference = CloseableReference.of(mBitmap, (ResourceReleaser)Preconditions.checkNotNull(resourcereleaser));
        mQualityInfo = qualityinfo;
        mRotationAngle = i;
    }

    public CloseableStaticBitmap(CloseableReference closeablereference, QualityInfo qualityinfo, int i)
    {
        mBitmapReference = (CloseableReference)Preconditions.checkNotNull(closeablereference.cloneOrNull());
        mBitmap = (Bitmap)mBitmapReference.get();
        mQualityInfo = qualityinfo;
        mRotationAngle = i;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mBitmapReference != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        CloseableReference closeablereference;
        closeablereference = mBitmapReference;
        mBitmapReference = null;
        mBitmap = null;
        this;
        JVM INSTR monitorexit ;
        closeablereference.close();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getHeight()
    {
        Bitmap bitmap = mBitmap;
        if (bitmap == null)
        {
            return 0;
        } else
        {
            return bitmap.getHeight();
        }
    }

    public QualityInfo getQualityInfo()
    {
        return mQualityInfo;
    }

    public int getRotationAngle()
    {
        return mRotationAngle;
    }

    public int getSizeInBytes()
    {
        return BitmapUtil.getSizeInBytes(mBitmap);
    }

    public Bitmap getUnderlyingBitmap()
    {
        return mBitmap;
    }

    public int getWidth()
    {
        Bitmap bitmap = mBitmap;
        if (bitmap == null)
        {
            return 0;
        } else
        {
            return bitmap.getWidth();
        }
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference closeablereference = mBitmapReference;
        boolean flag;
        if (closeablereference == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
