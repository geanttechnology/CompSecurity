// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedImage, AnimatedImageResultBuilder

public class AnimatedImageResult
{

    private List mDecodedFrames;
    private final int mFrameForPreview;
    private final AnimatedImage mImage;
    private CloseableReference mPreviewBitmap;

    private AnimatedImageResult(AnimatedImage animatedimage)
    {
        mImage = (AnimatedImage)Preconditions.checkNotNull(animatedimage);
        mFrameForPreview = 0;
    }

    AnimatedImageResult(AnimatedImageResultBuilder animatedimageresultbuilder)
    {
        mImage = (AnimatedImage)Preconditions.checkNotNull(animatedimageresultbuilder.getImage());
        mFrameForPreview = animatedimageresultbuilder.getFrameForPreview();
        mPreviewBitmap = animatedimageresultbuilder.getPreviewBitmap();
        mDecodedFrames = animatedimageresultbuilder.getDecodedFrames();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedimage)
    {
        return new AnimatedImageResult(animatedimage);
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedimage)
    {
        return new AnimatedImageResultBuilder(animatedimage);
    }

    public void dispose()
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference.closeSafely(mPreviewBitmap);
        mPreviewBitmap = null;
        CloseableReference.closeSafely(mDecodedFrames);
        mDecodedFrames = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public CloseableReference getDecodedFrame(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mDecodedFrames == null) goto _L2; else goto _L1
_L1:
        CloseableReference closeablereference = CloseableReference.cloneOrNull((CloseableReference)mDecodedFrames.get(i));
_L4:
        this;
        JVM INSTR monitorexit ;
        return closeablereference;
_L2:
        closeablereference = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int getFrameForPreview()
    {
        return mFrameForPreview;
    }

    public AnimatedImage getImage()
    {
        return mImage;
    }

    public CloseableReference getPreviewBitmap()
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference closeablereference = CloseableReference.cloneOrNull(mPreviewBitmap);
        this;
        JVM INSTR monitorexit ;
        return closeablereference;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasDecodedFrame(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mDecodedFrames == null) goto _L2; else goto _L1
_L1:
        Object obj = mDecodedFrames.get(i);
        if (obj == null) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }
}
