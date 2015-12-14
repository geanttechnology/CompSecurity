// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.gif;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import java.nio.ByteBuffer;

// Referenced classes of package com.facebook.imagepipeline.gif:
//            GifFrame

public class GifImage
    implements AnimatedImage
{

    private static volatile boolean sInitialized;
    private long mNativeContext;

    GifImage(long l)
    {
        mNativeContext = l;
    }

    public static GifImage create(long l, int i)
    {
        ensure();
        boolean flag;
        if (l != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        return nativeCreateFromNativeMemory(l, i);
    }

    public static GifImage create(byte abyte0[])
    {
        ensure();
        Preconditions.checkNotNull(abyte0);
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(abyte0.length);
        bytebuffer.put(abyte0);
        bytebuffer.rewind();
        return nativeCreateFromDirectByteBuffer(bytebuffer);
    }

    private static void ensure()
    {
        com/facebook/imagepipeline/gif/GifImage;
        JVM INSTR monitorenter ;
        if (!sInitialized)
        {
            sInitialized = true;
            SoLoaderShim.loadLibrary("gifimage");
        }
        com/facebook/imagepipeline/gif/GifImage;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int i)
    {
        if (i == 0)
        {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1)
        {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2)
        {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3)
        {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        } else
        {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
    }

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer bytebuffer);

    private static native GifImage nativeCreateFromNativeMemory(long l, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public void dispose()
    {
        nativeDispose();
    }

    public boolean doesRenderSupportScaling()
    {
        return false;
    }

    protected void finalize()
    {
        nativeFinalize();
    }

    public int getDuration()
    {
        return nativeGetDuration();
    }

    public volatile AnimatedImageFrame getFrame(int i)
    {
        return getFrame(i);
    }

    public GifFrame getFrame(int i)
    {
        return nativeGetFrame(i);
    }

    public int getFrameCount()
    {
        return nativeGetFrameCount();
    }

    public int[] getFrameDurations()
    {
        return nativeGetFrameDurations();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i)
    {
        GifFrame gifframe = getFrame(i);
        AnimatedDrawableFrameInfo animateddrawableframeinfo = new AnimatedDrawableFrameInfo(i, gifframe.getXOffset(), gifframe.getYOffset(), gifframe.getWidth(), gifframe.getHeight(), true, fromGifDisposalMethod(gifframe.getDisposalMode()));
        gifframe.dispose();
        return animateddrawableframeinfo;
        Exception exception;
        exception;
        gifframe.dispose();
        throw exception;
    }

    public int getHeight()
    {
        return nativeGetHeight();
    }

    public int getLoopCount()
    {
        return nativeGetLoopCount();
    }

    public int getSizeInBytes()
    {
        return nativeGetSizeInBytes();
    }

    public int getWidth()
    {
        return nativeGetWidth();
    }
}
