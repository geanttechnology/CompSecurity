// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            StagingArea, ImageCacheStatsTracker

public class BufferedDiskCache
{

    private static final Class TAG = com/facebook/imagepipeline/cache/BufferedDiskCache;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache filecache, PooledByteBufferFactory pooledbytebufferfactory, PooledByteStreams pooledbytestreams, Executor executor, Executor executor1, ImageCacheStatsTracker imagecachestatstracker)
    {
        mFileCache = filecache;
        mPooledByteBufferFactory = pooledbytebufferfactory;
        mPooledByteStreams = pooledbytestreams;
        mReadExecutor = executor;
        mWriteExecutor = executor1;
        mImageCacheStatsTracker = imagecachestatstracker;
    }

    private PooledByteBuffer readFromDiskCache(CacheKey cachekey)
        throws IOException
    {
        Object obj;
        Object obj1;
        try
        {
            FLog.v(TAG, "Disk cache read for %s", cachekey.toString());
            obj1 = mFileCache.getResource(cachekey);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            FLog.w(TAG, ((Throwable) (obj)), "Exception reading from cache for %s", new Object[] {
                cachekey.toString()
            });
            mImageCacheStatsTracker.onDiskCacheGetFail();
            throw obj;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        FLog.v(TAG, "Disk cache miss for %s", cachekey.toString());
        mImageCacheStatsTracker.onDiskCacheMiss();
        return null;
        FLog.v(TAG, "Found entry in disk cache for %s", cachekey.toString());
        mImageCacheStatsTracker.onDiskCacheHit();
        obj = ((BinaryResource) (obj1)).openStream();
        obj1 = mPooledByteBufferFactory.newByteBuffer(((InputStream) (obj)), (int)((BinaryResource) (obj1)).size());
        ((InputStream) (obj)).close();
        FLog.v(TAG, "Successful read from disk cache for %s", cachekey.toString());
        return ((PooledByteBuffer) (obj1));
        Exception exception;
        exception;
        ((InputStream) (obj)).close();
        throw exception;
    }

    private void writeToDiskCache(CacheKey cachekey, final EncodedImage encodedImage)
    {
        FLog.v(TAG, "About to write to disk-cache for key %s", cachekey.toString());
        try
        {
            mFileCache.insert(cachekey, new WriterCallback() {

                final BufferedDiskCache this$0;
                final EncodedImage val$encodedImage;

                public void write(OutputStream outputstream)
                    throws IOException
                {
                    mPooledByteStreams.copy(encodedImage.getInputStream(), outputstream);
                }

            
            {
                this$0 = BufferedDiskCache.this;
                encodedImage = encodedimage;
                super();
            }
            });
            FLog.v(TAG, "Successful disk-cache write for key %s", cachekey.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final EncodedImage encodedImage)
        {
            FLog.w(TAG, encodedImage, "Failed to write to disk-cache for key %s", new Object[] {
                cachekey.toString()
            });
        }
    }

    public Task get(final CacheKey key, final AtomicBoolean isCancelled)
    {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(isCancelled);
        EncodedImage encodedimage = mStagingArea.get(key);
        if (encodedimage != null)
        {
            FLog.v(TAG, "Found image for %s in staging area", key.toString());
            mImageCacheStatsTracker.onStagingAreaHit();
            return Task.forResult(encodedimage);
        }
        try
        {
            isCancelled = Task.call(new Callable() {

                final BufferedDiskCache this$0;
                final AtomicBoolean val$isCancelled;
                final CacheKey val$key;

                public EncodedImage call()
                    throws Exception
                {
                    Object obj;
                    if (isCancelled.get())
                    {
                        throw new CancellationException();
                    }
                    obj = mStagingArea.get(key);
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", key.toString());
                    mImageCacheStatsTracker.onStagingAreaHit();
_L3:
                    CloseableReference closeablereference;
                    if (Thread.interrupted())
                    {
                        FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                        if (obj != null)
                        {
                            ((EncodedImage) (obj)).close();
                        }
                        throw new InterruptedException();
                    } else
                    {
                        return ((EncodedImage) (obj));
                    }
_L2:
                    FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", key.toString());
                    mImageCacheStatsTracker.onStagingAreaMiss();
                    closeablereference = CloseableReference.of(readFromDiskCache(key));
                    obj = new EncodedImage(closeablereference);
                    CloseableReference.closeSafely(closeablereference);
                      goto _L3
                    obj;
                    try
                    {
                        CloseableReference.closeSafely(closeablereference);
                        throw obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj) { }
_L5:
                    return null;
                    Exception exception;
                    exception;
                    if (true) goto _L5; else goto _L4
_L4:
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BufferedDiskCache.this;
                isCancelled = atomicboolean;
                key = cachekey;
                super();
            }
            }, mReadExecutor);
        }
        // Misplaced declaration of an exception variable
        catch (final AtomicBoolean isCancelled)
        {
            FLog.w(TAG, isCancelled, "Failed to schedule disk-cache read for %s", new Object[] {
                key.toString()
            });
            return Task.forError(isCancelled);
        }
        return isCancelled;
    }

    public void put(final CacheKey key, EncodedImage encodedimage)
    {
        Preconditions.checkNotNull(key);
        Preconditions.checkArgument(EncodedImage.isValid(encodedimage));
        mStagingArea.put(key, encodedimage);
        final EncodedImage finalEncodedImage = EncodedImage.cloneOrNull(encodedimage);
        try
        {
            mWriteExecutor.execute(new Runnable() {

                final BufferedDiskCache this$0;
                final EncodedImage val$finalEncodedImage;
                final CacheKey val$key;

                public void run()
                {
                    writeToDiskCache(key, finalEncodedImage);
                    mStagingArea.remove(key, finalEncodedImage);
                    EncodedImage.closeSafely(finalEncodedImage);
                    return;
                    Exception exception1;
                    exception1;
                    mStagingArea.remove(key, finalEncodedImage);
                    EncodedImage.closeSafely(finalEncodedImage);
                    throw exception1;
                }

            
            {
                this$0 = BufferedDiskCache.this;
                key = cachekey;
                finalEncodedImage = encodedimage;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            FLog.w(TAG, exception, "Failed to schedule disk-cache write for %s", new Object[] {
                key.toString()
            });
        }
        mStagingArea.remove(key, encodedimage);
        EncodedImage.closeSafely(finalEncodedImage);
    }







}
