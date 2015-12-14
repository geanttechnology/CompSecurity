// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import com.socialin.android.NoProGuard;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class GifInfoHandle
    implements NoProGuard
{

    static final GifInfoHandle NULL_INFO = new GifInfoHandle(0L, 0, 0, 0);
    final int frameCount;
    private volatile long gifInfoPtr;
    final int height;
    final int width;

    private GifInfoHandle(long l, int i, int j, int k)
    {
        gifInfoPtr = l;
        width = i;
        height = j;
        frameCount = k;
    }

    private static native void bindSurface(long l, Surface surface, long al[], boolean flag);

    private static native void free(long l);

    private static native long getAllocationByteCount(long l);

    private static native String getComment(long l);

    private static native int getCurrentFrameIndex(long l);

    private static native int getCurrentLoop(long l);

    private static native int getCurrentPosition(long l);

    private static native int getDuration(long l);

    private static native int getFrameDuration(long l, int i);

    private static native int getLoopCount(long l);

    private static native int getNativeErrorCode(long l);

    private static native long[] getSavedState(long l);

    private static native long getSourceLength(long l);

    private static native boolean isAnimationCompleted(long l);

    static GifInfoHandle openAssetFileDescriptor(AssetFileDescriptor assetfiledescriptor, boolean flag)
    {
        GifInfoHandle gifinfohandle = openFd(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), flag);
        assetfiledescriptor.close();
        return gifinfohandle;
        Exception exception;
        exception;
        assetfiledescriptor.close();
        throw exception;
    }

    static native GifInfoHandle openByteArray(byte abyte0[], boolean flag);

    static native GifInfoHandle openDirectByteBuffer(ByteBuffer bytebuffer, boolean flag);

    static native GifInfoHandle openFd(FileDescriptor filedescriptor, long l, boolean flag);

    static native GifInfoHandle openFile(String s, boolean flag);

    static GifInfoHandle openMarkableInputStream(InputStream inputstream, boolean flag)
    {
        if (!inputstream.markSupported())
        {
            throw new IllegalArgumentException("InputStream does not support marking");
        } else
        {
            return openStream(inputstream, flag);
        }
    }

    static native GifInfoHandle openStream(InputStream inputstream, boolean flag);

    static GifInfoHandle openUri(ContentResolver contentresolver, Uri uri, boolean flag)
    {
        if ("file".equals(uri.getScheme()))
        {
            return openFile(uri.getPath(), flag);
        } else
        {
            return openAssetFileDescriptor(contentresolver.openAssetFileDescriptor(uri, "r"), flag);
        }
    }

    private static native void postUnbindSurface(long l);

    private static native long renderFrame(long l, Bitmap bitmap);

    private static native boolean reset(long l);

    private static native long restoreRemainder(long l);

    private static native int restoreSavedState(long l, long al[], Bitmap bitmap);

    private static native void saveRemainder(long l);

    private static native void seekToFrame(long l, int i, Bitmap bitmap);

    private static native void seekToTime(long l, int i, Bitmap bitmap);

    private static native void setLoopCount(long l, int i);

    private static native void setSpeedFactor(long l, float f);

    final void bindSurface(Surface surface, long al[], boolean flag)
    {
        bindSurface(gifInfoPtr, surface, al, flag);
    }

    protected final void finalize()
    {
        recycle();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    final long getAllocationByteCount()
    {
        this;
        JVM INSTR monitorenter ;
        long l = getAllocationByteCount(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    final String getComment()
    {
        this;
        JVM INSTR monitorenter ;
        String s = getComment(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    final int getCurrentFrameIndex()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getCurrentFrameIndex(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final int getCurrentLoop()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getCurrentLoop(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final int getCurrentPosition()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getCurrentPosition(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final int getDuration()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getDuration(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final int getFrameDuration(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        if (i < frameCount)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        throw new IndexOutOfBoundsException("Frame index is out of bounds");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        i = getFrameDuration(gifInfoPtr, i);
        this;
        JVM INSTR monitorexit ;
        return i;
    }

    final int getLoopCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getLoopCount(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final int getNativeErrorCode()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getNativeErrorCode(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final long[] getSavedState()
    {
        this;
        JVM INSTR monitorenter ;
        long al[] = getSavedState(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return al;
        Exception exception;
        exception;
        throw exception;
    }

    final long getSourceLength()
    {
        this;
        JVM INSTR monitorenter ;
        long l = getSourceLength(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean isAnimationCompleted()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isAnimationCompleted(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean isRecycled()
    {
        this;
        JVM INSTR monitorenter ;
        long l = gifInfoPtr;
        boolean flag;
        if (l == 0L)
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

    final void postUnbindSurface()
    {
        this;
        JVM INSTR monitorenter ;
        postUnbindSurface(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void recycle()
    {
        this;
        JVM INSTR monitorenter ;
        free(gifInfoPtr);
        gifInfoPtr = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final long renderFrame(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        long l = renderFrame(gifInfoPtr, bitmap);
        this;
        JVM INSTR monitorexit ;
        return l;
        bitmap;
        throw bitmap;
    }

    final boolean reset()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = reset(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    final long restoreRemainder()
    {
        this;
        JVM INSTR monitorenter ;
        long l = restoreRemainder(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    final int restoreSavedState(long al[], Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        int i = restoreSavedState(gifInfoPtr, al, bitmap);
        this;
        JVM INSTR monitorexit ;
        return i;
        al;
        throw al;
    }

    final void saveRemainder()
    {
        this;
        JVM INSTR monitorenter ;
        saveRemainder(gifInfoPtr);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void seekToFrame(int i, Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        seekToFrame(gifInfoPtr, i, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    final void seekToTime(int i, Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        seekToTime(gifInfoPtr, i, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    final void setLoopCount(int i)
    {
        if (i < 0 || i > 65535)
        {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        this;
        JVM INSTR monitorenter ;
        setLoopCount(gifInfoPtr, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void setSpeedFactor(float f)
    {
        float f1;
        if (f <= 0.0F || Float.isNaN(f))
        {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        f1 = f;
        if (f < 0.0F)
        {
            f1 = 0.0F;
        }
        this;
        JVM INSTR monitorenter ;
        setSpeedFactor(gifInfoPtr, f1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        System.loadLibrary("pagif");
    }
}
