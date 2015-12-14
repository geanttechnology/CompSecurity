// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

// Referenced classes of package com.facebook.imagepipeline.image:
//            CloseableImage

public class CloseableAnimatedImage extends CloseableImage
{

    private AnimatedImageResult mImageResult;

    public CloseableAnimatedImage(AnimatedImageResult animatedimageresult)
    {
        mImageResult = animatedimageresult;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mImageResult != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        AnimatedImageResult animatedimageresult;
        animatedimageresult = mImageResult;
        mImageResult = null;
        this;
        JVM INSTR monitorexit ;
        animatedimageresult.dispose();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getHeight()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isClosed();
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = mImageResult.getImage().getHeight();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public AnimatedImage getImage()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isClosed();
        if (!flag) goto _L2; else goto _L1
_L1:
        AnimatedImage animatedimage = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return animatedimage;
_L2:
        animatedimage = mImageResult.getImage();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public AnimatedImageResult getImageResult()
    {
        this;
        JVM INSTR monitorenter ;
        AnimatedImageResult animatedimageresult = mImageResult;
        this;
        JVM INSTR monitorexit ;
        return animatedimageresult;
        Exception exception;
        exception;
        throw exception;
    }

    public int getSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isClosed();
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = mImageResult.getImage().getSizeInBytes();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int getWidth()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isClosed();
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = mImageResult.getImage().getWidth();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        AnimatedImageResult animatedimageresult = mImageResult;
        boolean flag;
        if (animatedimageresult == null)
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

    public boolean isStateful()
    {
        return true;
    }
}
