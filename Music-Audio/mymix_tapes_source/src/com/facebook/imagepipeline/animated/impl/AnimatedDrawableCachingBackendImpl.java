// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.util.SparseArrayCompat;
import bolts.Continuation;
import bolts.Task;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedImageCompositor, WhatToKeepCachedArray

public class AnimatedDrawableCachingBackendImpl extends DelegatingAnimatedDrawableBackend
    implements AnimatedDrawableCachingBackend
{

    private static final int PREFETCH_FRAMES = 3;
    private static final Class TAG = com/facebook/imagepipeline/animated/impl/AnimatedDrawableCachingBackendImpl;
    private static final AtomicInteger sTotalBitmaps = new AtomicInteger();
    private final ActivityManager mActivityManager;
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final AnimatedDrawableOptions mAnimatedDrawableOptions;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImageCompositor mAnimatedImageCompositor;
    private final int mApproxBytesToHoldAllFrames;
    private final WhatToKeepCachedArray mBitmapsToKeepCached;
    private final SparseArrayCompat mCachedBitmaps = new SparseArrayCompat(10);
    private int mCurrentFrameIndex;
    private final SparseArrayCompat mDecodesInFlight = new SparseArrayCompat(10);
    private final SerialExecutorService mExecutorService;
    private final List mFreeBitmaps = new ArrayList();
    private final int mMaximumBytes;
    private final MonotonicClock mMonotonicClock;
    private final ResourceReleaser mResourceReleaserForBitmaps = new ResourceReleaser() {

        final AnimatedDrawableCachingBackendImpl this$0;

        public void release(Bitmap bitmap)
        {
            releaseBitmapInternal(bitmap);
        }

        public volatile void release(Object obj)
        {
            release((Bitmap)obj);
        }

            
            {
                this$0 = AnimatedDrawableCachingBackendImpl.this;
                super();
            }
    };

    public AnimatedDrawableCachingBackendImpl(SerialExecutorService serialexecutorservice, ActivityManager activitymanager, AnimatedDrawableUtil animateddrawableutil, MonotonicClock monotonicclock, AnimatedDrawableBackend animateddrawablebackend, AnimatedDrawableOptions animateddrawableoptions)
    {
        super(animateddrawablebackend);
        mExecutorService = serialexecutorservice;
        mActivityManager = activitymanager;
        mAnimatedDrawableUtil = animateddrawableutil;
        mMonotonicClock = monotonicclock;
        mAnimatedDrawableBackend = animateddrawablebackend;
        mAnimatedDrawableOptions = animateddrawableoptions;
        int i;
        if (animateddrawableoptions.maximumBytes >= 0)
        {
            i = animateddrawableoptions.maximumBytes;
        } else
        {
            i = getDefaultMaxBytes(activitymanager);
        }
        mMaximumBytes = i;
        mAnimatedImageCompositor = new AnimatedImageCompositor(animateddrawablebackend, new AnimatedImageCompositor.Callback() {

            final AnimatedDrawableCachingBackendImpl this$0;

            public CloseableReference getCachedBitmap(int j)
            {
                return getCachedOrPredecodedFrame(j);
            }

            public void onIntermediateResult(int j, Bitmap bitmap)
            {
                maybeCacheBitmapDuringRender(j, bitmap);
            }

            
            {
                this$0 = AnimatedDrawableCachingBackendImpl.this;
                super();
            }
        });
        mBitmapsToKeepCached = new WhatToKeepCachedArray(mAnimatedDrawableBackend.getFrameCount());
        mApproxBytesToHoldAllFrames = mAnimatedDrawableBackend.getFrameCount() * mAnimatedDrawableBackend.getRenderedWidth() * mAnimatedDrawableBackend.getRenderedHeight() * 4;
    }

    private void cancelFuturesOutsideOfRange(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k = 0;
_L2:
        if (k >= mDecodesInFlight.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (AnimatedDrawableUtil.isOutsideRange(i, j, mDecodesInFlight.keyAt(k)))
        {
            Task task = (Task)mDecodesInFlight.valueAt(k);
            mDecodesInFlight.removeAt(k);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        throw exception;
        k++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void copyAndCacheBitmapDuringRendering(int i, Bitmap bitmap)
    {
        CloseableReference closeablereference = obtainBitmapInternal();
        Canvas canvas = new Canvas((Bitmap)closeablereference.get());
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        maybeCacheRenderedBitmap(i, closeablereference);
        closeablereference.close();
        return;
        bitmap;
        closeablereference.close();
        throw bitmap;
    }

    private Bitmap createNewBitmap()
    {
        FLog.v(TAG, "Creating new bitmap");
        sTotalBitmaps.incrementAndGet();
        FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
        return Bitmap.createBitmap(mAnimatedDrawableBackend.getRenderedWidth(), mAnimatedDrawableBackend.getRenderedHeight(), android.graphics.Bitmap.Config.ARGB_8888);
    }

    private void doPrefetch(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k = 0;
_L3:
        if (k >= j) goto _L2; else goto _L1
_L1:
        Task task;
        final int frameNumber;
        boolean flag;
        frameNumber = (i + k) % mAnimatedDrawableBackend.getFrameCount();
        flag = hasCachedOrPredecodedFrame(frameNumber);
        task = (Task)mDecodesInFlight.get(frameNumber);
        if (flag || task != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        final Task newFuture = Task.call(new Callable() {

            final AnimatedDrawableCachingBackendImpl this$0;
            final int val$frameNumber;

            public Object call()
            {
                runPrefetch(frameNumber);
                return null;
            }

            
            {
                this$0 = AnimatedDrawableCachingBackendImpl.this;
                frameNumber = i;
                super();
            }
        }, mExecutorService);
        mDecodesInFlight.put(frameNumber, newFuture);
        newFuture.continueWith(new Continuation() {

            final AnimatedDrawableCachingBackendImpl this$0;
            final int val$frameNumber;
            final Task val$newFuture;

            public Object then(Task task1)
                throws Exception
            {
                onFutureFinished(newFuture, frameNumber);
                return null;
            }

            
            {
                this$0 = AnimatedDrawableCachingBackendImpl.this;
                newFuture = task;
                frameNumber = i;
                super();
            }
        });
        k++;
          goto _L3
_L2:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void dropBitmapsThatShouldNotBeCached()
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if (i >= mCachedBitmaps.size())
        {
            break; /* Loop/switch isn't completed */
        }
        int j = mCachedBitmaps.keyAt(i);
        if (!mBitmapsToKeepCached.get(j))
        {
            CloseableReference closeablereference = (CloseableReference)mCachedBitmaps.valueAt(i);
            mCachedBitmaps.removeAt(i);
            closeablereference.close();
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private CloseableReference getBitmapForFrameInternal(int i, boolean flag)
    {
        boolean flag2;
        long l;
        flag2 = false;
        l = mMonotonicClock.now();
        boolean flag1 = flag2;
        this;
        JVM INSTR monitorenter ;
        CloseableReference closeablereference;
        mBitmapsToKeepCached.set(i, true);
        closeablereference = getCachedOrPredecodedFrame(i);
        if (closeablereference == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        Object obj;
        l = mMonotonicClock.now() - l;
        obj = closeablereference;
        if (l > 10L)
        {
            if (false)
            {
                obj = "renderedOnCallingThread";
            } else
            if (false)
            {
                obj = "deferred";
            } else
            {
                obj = "ok";
            }
            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(l), obj);
            obj = closeablereference;
        }
_L4:
        return ((CloseableReference) (obj));
_L2:
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        flag2 = true;
        flag1 = flag2;
        obj = obtainBitmapInternal();
        mAnimatedImageCompositor.renderFrame(i, (Bitmap)((CloseableReference) (obj)).get());
        maybeCacheRenderedBitmap(i, ((CloseableReference) (obj)));
        closeablereference = ((CloseableReference) (obj)).clone();
        flag1 = flag2;
        ((CloseableReference) (obj)).close();
        l = mMonotonicClock.now() - l;
        if (l > 10L)
        {
            Exception exception;
            if (true)
            {
                obj = "renderedOnCallingThread";
            } else
            if (false)
            {
                obj = "deferred";
            } else
            {
                obj = "ok";
            }
            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(l), obj);
        }
        return closeablereference;
        obj;
        this;
        JVM INSTR monitorexit ;
        flag1 = flag2;
        throw obj;
        exception;
        l = mMonotonicClock.now() - l;
        if (l > 10L)
        {
            Exception exception1;
            if (flag1)
            {
                obj = "renderedOnCallingThread";
            } else
            if (false)
            {
                obj = "deferred";
            } else
            {
                obj = "ok";
            }
            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(l), obj);
        }
        throw exception;
        exception1;
        flag1 = flag2;
        ((CloseableReference) (obj)).close();
        flag1 = flag2;
        throw exception1;
        obj = null;
        l = mMonotonicClock.now() - l;
        if (l > 10L)
        {
            if (false)
            {
                obj = "renderedOnCallingThread";
            } else
            if (true)
            {
                obj = "deferred";
            } else
            {
                obj = "ok";
            }
            FLog.v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(l), obj);
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private CloseableReference getCachedOrPredecodedFrame(int i)
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference closeablereference1 = CloseableReference.cloneOrNull((CloseableReference)mCachedBitmaps.get(i));
        CloseableReference closeablereference;
        closeablereference = closeablereference1;
        if (closeablereference1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        closeablereference = mAnimatedDrawableBackend.getPreDecodedFrame(i);
        this;
        JVM INSTR monitorexit ;
        return closeablereference;
        Exception exception;
        exception;
        throw exception;
    }

    private static int getDefaultMaxBytes(ActivityManager activitymanager)
    {
        return activitymanager.getMemoryClass() <= 32 ? 0x300000 : 0x500000;
    }

    private boolean hasCachedOrPredecodedFrame(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mCachedBitmaps.get(i) != null) goto _L2; else goto _L1
_L1:
        boolean flag = mAnimatedDrawableBackend.hasPreDecodedFrame(i);
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private void maybeCacheBitmapDuringRender(int i, Bitmap bitmap)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (mBitmapsToKeepCached.get(i))
        {
            if (mCachedBitmaps.get(i) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            copyAndCacheBitmapDuringRendering(i, bitmap);
        }
        return;
        bitmap;
        this;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    private void maybeCacheRenderedBitmap(int i, CloseableReference closeablereference)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBitmapsToKeepCached.get(i);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j = mCachedBitmaps.indexOfKey(i);
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        ((CloseableReference)mCachedBitmaps.valueAt(j)).close();
        mCachedBitmaps.removeAt(j);
        mCachedBitmaps.put(i, closeablereference.clone());
        if (true) goto _L1; else goto _L3
_L3:
        closeablereference;
        throw closeablereference;
    }

    private CloseableReference obtainBitmapInternal()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = System.nanoTime();
        l1 = l + TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS);
_L1:
        boolean flag = mFreeBitmaps.isEmpty();
        if (!flag || l >= l1)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        TimeUnit.NANOSECONDS.timedWait(this, l1 - l);
        l = System.nanoTime();
          goto _L1
        Object obj;
        obj;
        Thread.currentThread().interrupt();
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Bitmap bitmap;
        if (!mFreeBitmaps.isEmpty())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        bitmap = createNewBitmap();
_L2:
        this;
        JVM INSTR monitorexit ;
        return CloseableReference.of(bitmap, mResourceReleaserForBitmaps);
        bitmap = (Bitmap)mFreeBitmaps.remove(mFreeBitmaps.size() - 1);
          goto _L2
    }

    private void onFutureFinished(Task task, int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mDecodesInFlight.indexOfKey(i);
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if ((Task)mDecodesInFlight.valueAt(j) == task)
        {
            mDecodesInFlight.removeAt(j);
            if (task.getError() != null)
            {
                FLog.v(TAG, task.getError(), "Failed to render frame %d", new Object[] {
                    Integer.valueOf(i)
                });
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        task;
        throw task;
    }

    private void runPrefetch(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mBitmapsToKeepCached.get(i))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!hasCachedOrPredecodedFrame(i))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        CloseableReference closeablereference = mAnimatedDrawableBackend.getPreDecodedFrame(i);
        if (closeablereference == null) goto _L2; else goto _L1
_L1:
        maybeCacheRenderedBitmap(i, closeablereference);
_L4:
        CloseableReference.closeSafely(closeablereference);
        return;
_L2:
        Object obj = obtainBitmapInternal();
        mAnimatedImageCompositor.renderFrame(i, (Bitmap)((CloseableReference) (obj)).get());
        maybeCacheRenderedBitmap(i, ((CloseableReference) (obj)));
        FLog.v(TAG, "Prefetch rendered frame %d", Integer.valueOf(i));
        ((CloseableReference) (obj)).close();
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        CloseableReference.closeSafely(closeablereference);
        throw obj;
        Exception exception1;
        exception1;
        ((CloseableReference) (obj)).close();
        throw exception1;
    }

    private void schedulePrefetches()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        int k;
        if (mAnimatedDrawableBackend.getFrameInfo(mCurrentFrameIndex).disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        k = mCurrentFrameIndex;
        if (i != 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = Math.max(0, k - j);
        if (mAnimatedDrawableOptions.allowPrefetching)
        {
            j = 3;
        } else
        {
            j = 0;
        }
          goto _L1
_L15:
        j = Math.max(j, i);
        i = (k + j) % mAnimatedDrawableBackend.getFrameCount();
        cancelFuturesOutsideOfRange(k, i);
        if (shouldKeepAllFramesInMemory()) goto _L3; else goto _L2
_L2:
        mBitmapsToKeepCached.setAll(true);
        mBitmapsToKeepCached.removeOutsideRange(k, i);
        i = k;
_L10:
        if (i < 0) goto _L5; else goto _L4
_L4:
        if (mCachedBitmaps.get(i) == null) goto _L7; else goto _L6
_L6:
        mBitmapsToKeepCached.set(i, true);
_L5:
        dropBitmapsThatShouldNotBeCached();
_L3:
        if (!mAnimatedDrawableOptions.allowPrefetching) goto _L9; else goto _L8
_L8:
        doPrefetch(k, j);
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
_L13:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L7:
        i--;
          goto _L10
_L9:
        cancelFuturesOutsideOfRange(mCurrentFrameIndex, mCurrentFrameIndex);
          goto _L11
        Exception exception;
        exception;
        throw exception;
_L1:
        if (i == 0) goto _L13; else goto _L12
_L12:
        i = ((flag) ? 1 : 0);
        if (true) goto _L15; else goto _L14
_L14:
    }

    private boolean shouldKeepAllFramesInMemory()
    {
        while (mAnimatedDrawableOptions.forceKeepAllFramesInMemory || mApproxBytesToHoldAllFrames < mMaximumBytes) 
        {
            return true;
        }
        return false;
    }

    public void appendDebugOptionString(StringBuilder stringbuilder)
    {
        if (mAnimatedDrawableOptions.forceKeepAllFramesInMemory)
        {
            stringbuilder.append("Pinned To Memory");
        } else
        {
            if (mApproxBytesToHoldAllFrames < mMaximumBytes)
            {
                stringbuilder.append("within ");
            } else
            {
                stringbuilder.append("exceeds ");
            }
            mAnimatedDrawableUtil.appendMemoryString(stringbuilder, mMaximumBytes);
        }
        if (shouldKeepAllFramesInMemory() && mAnimatedDrawableOptions.allowPrefetching)
        {
            stringbuilder.append(" MT");
        }
    }

    public void dropCaches()
    {
        this;
        JVM INSTR monitorenter ;
        mBitmapsToKeepCached.setAll(false);
        dropBitmapsThatShouldNotBeCached();
        for (Iterator iterator = mFreeBitmaps.iterator(); iterator.hasNext(); sTotalBitmaps.decrementAndGet())
        {
            ((Bitmap)iterator.next()).recycle();
        }

        break MISSING_BLOCK_LABEL_60;
        Exception exception;
        exception;
        throw exception;
        mFreeBitmaps.clear();
        mAnimatedDrawableBackend.dropCaches();
        FLog.v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
        this;
        JVM INSTR monitorexit ;
    }

    protected void finalize()
        throws Throwable
    {
        this;
        JVM INSTR monitorenter ;
        super.finalize();
        if (mCachedBitmaps.size() > 0)
        {
            FLog.d(TAG, "Finalizing with rendered bitmaps");
        }
        sTotalBitmaps.addAndGet(-mFreeBitmaps.size());
        mFreeBitmaps.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile AnimatedDrawableBackend forNewBounds(Rect rect)
    {
        return forNewBounds(rect);
    }

    public AnimatedDrawableCachingBackend forNewBounds(Rect rect)
    {
        rect = mAnimatedDrawableBackend.forNewBounds(rect);
        if (rect == mAnimatedDrawableBackend)
        {
            return this;
        } else
        {
            return new AnimatedDrawableCachingBackendImpl(mExecutorService, mActivityManager, mAnimatedDrawableUtil, mMonotonicClock, rect, mAnimatedDrawableOptions);
        }
    }

    public CloseableReference getBitmapForFrame(int i)
    {
        mCurrentFrameIndex = i;
        CloseableReference closeablereference = getBitmapForFrameInternal(i, false);
        schedulePrefetches();
        return closeablereference;
    }

    CloseableReference getBitmapForFrameBlocking(int i)
    {
        mCurrentFrameIndex = i;
        CloseableReference closeablereference = getBitmapForFrameInternal(i, true);
        schedulePrefetches();
        return closeablereference;
    }

    Map getDecodesInFlight()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = new HashMap();
        int i = 0;
_L2:
        if (i >= mDecodesInFlight.size())
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap.put(Integer.valueOf(mDecodesInFlight.keyAt(i)), mDecodesInFlight.valueAt(i));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    Set getFramesCached()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet();
        int i = 0;
_L2:
        if (i >= mCachedBitmaps.size())
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(Integer.valueOf(mCachedBitmaps.keyAt(i)));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return hashset;
        Exception exception;
        exception;
        throw exception;
    }

    public int getMemoryUsage()
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mFreeBitmaps.iterator(); iterator.hasNext();)
        {
            Bitmap bitmap = (Bitmap)iterator.next();
            i += mAnimatedDrawableUtil.getSizeOfBitmap(bitmap);
        }

          goto _L1
_L3:
        int j;
        if (j >= mCachedBitmaps.size())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        CloseableReference closeablereference = (CloseableReference)mCachedBitmaps.valueAt(j);
        i += mAnimatedDrawableUtil.getSizeOfBitmap((Bitmap)closeablereference.get());
        j++;
        continue; /* Loop/switch isn't completed */
        this;
        JVM INSTR monitorexit ;
        return i + mAnimatedDrawableBackend.getMemoryUsage();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        j = 0;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public CloseableReference getPreviewBitmap()
    {
        return getAnimatedImageResult().getPreviewBitmap();
    }

    void releaseBitmapInternal(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        mFreeBitmaps.add(bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    public void renderFrame(int i, Canvas canvas)
    {
        throw new IllegalStateException();
    }





}
