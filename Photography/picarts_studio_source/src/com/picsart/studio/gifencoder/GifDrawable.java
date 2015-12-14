// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import com.melnykov.fab.a;
import com.socialin.android.NoProGuard;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.picsart.studio.gifencoder:
//            GifInfoHandle, c, b, a, 
//            GifError, d

public class GifDrawable extends Drawable
    implements Animatable, android.widget.MediaController.MediaPlayerControl, NoProGuard
{

    final Bitmap mBuffer;
    private final Rect mDstRect;
    final ScheduledThreadPoolExecutor mExecutor;
    final b mInvalidationHandler;
    final boolean mIsRenderingTriggeredOnDraw;
    volatile boolean mIsRunning;
    final ConcurrentLinkedQueue mListeners;
    final GifInfoHandle mNativeInfoHandle;
    long mNextFrameRenderTime;
    protected final Paint mPaint;
    private final Runnable mRenderTask;
    private final Rect mSrcRect;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private android.graphics.PorterDuff.Mode mTintMode;

    public GifDrawable(ContentResolver contentresolver, Uri uri)
    {
        this(GifInfoHandle.openUri(contentresolver, uri, false), null, null, true);
    }

    public GifDrawable(AssetFileDescriptor assetfiledescriptor)
    {
        this(GifInfoHandle.openAssetFileDescriptor(assetfiledescriptor, false), null, null, true);
    }

    public GifDrawable(AssetManager assetmanager, String s)
    {
        this(assetmanager.openFd(s));
    }

    public GifDrawable(Resources resources, int i)
    {
        this(resources.openRawResourceFd(i));
    }

    GifDrawable(GifInfoHandle gifinfohandle, GifDrawable gifdrawable, ScheduledThreadPoolExecutor scheduledthreadpoolexecutor, boolean flag)
    {
        GifInfoHandle gifinfohandle1;
        mIsRunning = true;
        mNextFrameRenderTime = 0x8000000000000000L;
        mDstRect = new Rect();
        mPaint = new Paint(6);
        mListeners = new ConcurrentLinkedQueue();
        mRenderTask = new c(this);
        mIsRenderingTriggeredOnDraw = flag;
        if (scheduledthreadpoolexecutor == null)
        {
            scheduledthreadpoolexecutor = com.picsart.studio.gifencoder.a.a();
        }
        mExecutor = scheduledthreadpoolexecutor;
        mNativeInfoHandle = gifinfohandle;
        gifinfohandle = null;
        scheduledthreadpoolexecutor = null;
        if (gifdrawable == null) goto _L2; else goto _L1
_L1:
        gifinfohandle1 = gifdrawable.mNativeInfoHandle;
        gifinfohandle1;
        JVM INSTR monitorenter ;
        gifinfohandle = scheduledthreadpoolexecutor;
        if (gifdrawable.mNativeInfoHandle.isRecycled())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        gifinfohandle = scheduledthreadpoolexecutor;
        if (gifdrawable.mNativeInfoHandle.height < mNativeInfoHandle.height)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        gifinfohandle = scheduledthreadpoolexecutor;
        if (gifdrawable.mNativeInfoHandle.width >= mNativeInfoHandle.width)
        {
            gifdrawable.shutdown();
            gifinfohandle = gifdrawable.mBuffer;
            gifinfohandle.eraseColor(0);
        }
        gifinfohandle1;
        JVM INSTR monitorexit ;
_L2:
        if (gifinfohandle == null)
        {
            mBuffer = Bitmap.createBitmap(mNativeInfoHandle.width, mNativeInfoHandle.height, android.graphics.Bitmap.Config.ARGB_8888);
        } else
        {
            mBuffer = gifinfohandle;
        }
        mSrcRect = new Rect(0, 0, mNativeInfoHandle.width, mNativeInfoHandle.height);
        mInvalidationHandler = new b(this);
        if (mIsRenderingTriggeredOnDraw)
        {
            mNextFrameRenderTime = 0L;
            return;
        } else
        {
            mExecutor.execute(mRenderTask);
            return;
        }
        gifinfohandle;
        gifinfohandle1;
        JVM INSTR monitorexit ;
        throw gifinfohandle;
    }

    public GifDrawable(File file)
    {
        this(GifInfoHandle.openFile(file.getPath(), false), null, null, true);
    }

    public GifDrawable(FileDescriptor filedescriptor)
    {
        this(GifInfoHandle.openFd(filedescriptor, 0L, false), null, null, true);
    }

    public GifDrawable(InputStream inputstream)
    {
        this(GifInfoHandle.openMarkableInputStream(inputstream, false), null, null, true);
    }

    public GifDrawable(String s)
    {
        this(GifInfoHandle.openFile(s, false), null, null, true);
    }

    public GifDrawable(ByteBuffer bytebuffer)
    {
        this(GifInfoHandle.openDirectByteBuffer(bytebuffer, false), null, null, true);
    }

    public GifDrawable(byte abyte0[])
    {
        this(GifInfoHandle.openByteArray(abyte0, false), null, null, true);
    }

    public static GifDrawable createFromResource(Resources resources, int i)
    {
        try
        {
            resources = new GifDrawable(resources, i);
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            return null;
        }
        return resources;
    }

    private void shutdown()
    {
        mIsRunning = false;
        mInvalidationHandler.removeMessages(0);
        mNativeInfoHandle.recycle();
    }

    private PorterDuffColorFilter updateTintFilter(ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode)
    {
        if (colorstatelist == null || mode == null)
        {
            return null;
        } else
        {
            return new PorterDuffColorFilter(colorstatelist.getColorForState(getState(), 0), mode);
        }
    }

    public void addAnimationListener$188434b5(a a1)
    {
        mListeners.add(a1);
    }

    public boolean canPause()
    {
        return true;
    }

    public boolean canSeekBackward()
    {
        return getNumberOfFrames() > 1;
    }

    public boolean canSeekForward()
    {
        return getNumberOfFrames() > 1;
    }

    public void draw(Canvas canvas)
    {
        boolean flag;
        if (mTintFilter != null && mPaint.getColorFilter() == null)
        {
            mPaint.setColorFilter(mTintFilter);
            flag = true;
        } else
        {
            flag = false;
        }
        if (mPaint.getShader() == null)
        {
            canvas.drawBitmap(mBuffer, mSrcRect, mDstRect, mPaint);
        } else
        {
            canvas.drawRect(mDstRect, mPaint);
        }
        if (flag)
        {
            mPaint.setColorFilter(null);
        }
        if (mIsRenderingTriggeredOnDraw && mIsRunning && mNextFrameRenderTime != 0x8000000000000000L)
        {
            long l = Math.max(0L, mNextFrameRenderTime - SystemClock.uptimeMillis());
            mNextFrameRenderTime = 0x8000000000000000L;
            mExecutor.schedule(mRenderTask, l, TimeUnit.MILLISECONDS);
        }
    }

    public long getAllocationByteCount()
    {
        long l = mNativeInfoHandle.getAllocationByteCount();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return l + (long)mBuffer.getAllocationByteCount();
        } else
        {
            return l + (long)(mBuffer.getRowBytes() * mBuffer.getHeight());
        }
    }

    public int getAlpha()
    {
        return mPaint.getAlpha();
    }

    public int getAudioSessionId()
    {
        return 0;
    }

    public int getBufferPercentage()
    {
        return 100;
    }

    public ColorFilter getColorFilter()
    {
        return mPaint.getColorFilter();
    }

    public String getComment()
    {
        return mNativeInfoHandle.getComment();
    }

    public Bitmap getCurrentFrame()
    {
        return mBuffer.copy(mBuffer.getConfig(), mBuffer.isMutable());
    }

    public int getCurrentFrameIndex()
    {
        return mNativeInfoHandle.getCurrentFrameIndex();
    }

    public int getCurrentLoop()
    {
        return mNativeInfoHandle.getCurrentLoop();
    }

    public int getCurrentPosition()
    {
        return mNativeInfoHandle.getCurrentPosition();
    }

    public int getDuration()
    {
        return mNativeInfoHandle.getDuration();
    }

    public GifError getError()
    {
        return GifError.fromCode(mNativeInfoHandle.getNativeErrorCode());
    }

    public int getFrameByteCount()
    {
        return mBuffer.getRowBytes() * mBuffer.getHeight();
    }

    public int getFrameDuration(int i)
    {
        return mNativeInfoHandle.getFrameDuration(i);
    }

    public long getInputSourceByteCount()
    {
        return mNativeInfoHandle.getSourceLength();
    }

    public int getIntrinsicHeight()
    {
        return mNativeInfoHandle.height;
    }

    public int getIntrinsicWidth()
    {
        return mNativeInfoHandle.width;
    }

    public int getLoopCount()
    {
        return mNativeInfoHandle.getLoopCount();
    }

    public int getMinimumHeight()
    {
        return mNativeInfoHandle.height;
    }

    public int getMinimumWidth()
    {
        return mNativeInfoHandle.width;
    }

    public int getNumberOfFrames()
    {
        return mNativeInfoHandle.frameCount;
    }

    public int getOpacity()
    {
        return -2;
    }

    public final Paint getPaint()
    {
        return mPaint;
    }

    public int getPixel(int i, int j)
    {
        if (i >= mNativeInfoHandle.width)
        {
            throw new IllegalArgumentException("x must be < width");
        }
        if (j >= mNativeInfoHandle.height)
        {
            throw new IllegalArgumentException("y must be < height");
        } else
        {
            return mBuffer.getPixel(i, j);
        }
    }

    public void getPixels(int ai[])
    {
        mBuffer.getPixels(ai, 0, mNativeInfoHandle.width, 0, 0, mNativeInfoHandle.width, mNativeInfoHandle.height);
    }

    public boolean isAnimationCompleted()
    {
        return mNativeInfoHandle.isAnimationCompleted();
    }

    public boolean isPlaying()
    {
        return mIsRunning;
    }

    public boolean isRecycled()
    {
        return mNativeInfoHandle.isRecycled();
    }

    public boolean isRunning()
    {
        return mIsRunning;
    }

    public boolean isStateful()
    {
        return super.isStateful() || mTint != null && mTint.isStateful();
    }

    protected void onBoundsChange(Rect rect)
    {
        mDstRect.set(rect);
    }

    protected boolean onStateChange(int ai[])
    {
        if (mTint != null && mTintMode != null)
        {
            mTintFilter = updateTintFilter(mTint, mTintMode);
            return true;
        } else
        {
            return false;
        }
    }

    public void pause()
    {
        stop();
    }

    public void recycle()
    {
        shutdown();
        mBuffer.recycle();
    }

    public boolean removeAnimationListener$188434b9(a a1)
    {
        return mListeners.remove(a1);
    }

    public void reset()
    {
        mExecutor.execute(new d(this) {

            private GifDrawable b;

            public final void a()
            {
                if (b.mNativeInfoHandle.reset())
                {
                    b.start();
                }
            }

            
            {
                b = GifDrawable.this;
                super(gifdrawable1);
            }
        });
    }

    public void seekTo(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Position is not positive");
        } else
        {
            mExecutor.execute(new d(this, i) {

                private int b;
                private GifDrawable c;

                public final void a()
                {
                    c.mNativeInfoHandle.seekToTime(b, c.mBuffer);
                    a.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }

            
            {
                c = GifDrawable.this;
                b = i;
                super(gifdrawable1);
            }
            });
            return;
        }
    }

    public void seekToFrame(int i)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException("Frame index is not positive");
        } else
        {
            mExecutor.execute(new d(this, i) {

                private int b;
                private GifDrawable c;

                public final void a()
                {
                    c.mNativeInfoHandle.seekToFrame(b, c.mBuffer);
                    c.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }

            
            {
                c = GifDrawable.this;
                b = i;
                super(gifdrawable1);
            }
            });
            return;
        }
    }

    public Bitmap seekToFrameAndGet(int i)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException("Frame index is not positive");
        }
        Bitmap bitmap;
        synchronized (mNativeInfoHandle)
        {
            mNativeInfoHandle.seekToFrame(i, mBuffer);
            bitmap = getCurrentFrame();
        }
        mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return bitmap;
        exception;
        gifinfohandle;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap seekToPositionAndGet(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Position is not positive");
        }
        Bitmap bitmap;
        synchronized (mNativeInfoHandle)
        {
            mNativeInfoHandle.seekToTime(i, mBuffer);
            bitmap = getCurrentFrame();
        }
        mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return bitmap;
        exception;
        gifinfohandle;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }

    public void setDither(boolean flag)
    {
        mPaint.setDither(flag);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean flag)
    {
        mPaint.setFilterBitmap(flag);
        invalidateSelf();
    }

    public void setLoopCount(int i)
    {
        mNativeInfoHandle.setLoopCount(i);
    }

    public void setSpeed(float f)
    {
        mNativeInfoHandle.setSpeedFactor(f);
    }

    public void setTintList(ColorStateList colorstatelist)
    {
        mTint = colorstatelist;
        mTintFilter = updateTintFilter(colorstatelist, mTintMode);
        invalidateSelf();
    }

    public void setTintMode(android.graphics.PorterDuff.Mode mode)
    {
        mTintMode = mode;
        mTintFilter = updateTintFilter(mTint, mode);
        invalidateSelf();
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        boolean flag2 = super.setVisible(flag, flag1);
        if (flag)
        {
            if (flag1)
            {
                reset();
            }
            if (flag2)
            {
                start();
            }
        } else
        if (flag2)
        {
            stop();
            return flag2;
        }
        return flag2;
    }

    public void start()
    {
        mIsRunning = true;
        startAnimation(mNativeInfoHandle.restoreRemainder());
    }

    void startAnimation(long l)
    {
label0:
        {
            if (l >= 0L)
            {
                if (!mIsRenderingTriggeredOnDraw)
                {
                    break label0;
                }
                mNextFrameRenderTime = 0L;
                mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            }
            return;
        }
        while (mExecutor.getQueue().remove(mRenderTask)) ;
        mExecutor.schedule(mRenderTask, l, TimeUnit.MILLISECONDS);
    }

    public void stop()
    {
        mIsRunning = false;
        mInvalidationHandler.removeMessages(0);
        while (mExecutor.getQueue().remove(mRenderTask)) ;
        mNativeInfoHandle.saveRemainder();
    }

    public String toString()
    {
        return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", new Object[] {
            Integer.valueOf(mNativeInfoHandle.width), Integer.valueOf(mNativeInfoHandle.height), Integer.valueOf(mNativeInfoHandle.frameCount), Integer.valueOf(mNativeInfoHandle.getNativeErrorCode())
        });
    }
}
