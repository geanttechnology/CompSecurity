// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.util.LogTime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.bumptech.glide.load.engine:
//            EngineKey, DiskCacheStrategy, Resource

class DecodeJob
{
    static interface DiskCacheProvider
    {

        public abstract DiskCache getDiskCache();
    }

    static class FileOpener
    {

        public OutputStream open(File file)
            throws FileNotFoundException
        {
            return new BufferedOutputStream(new FileOutputStream(file));
        }

        FileOpener()
        {
        }
    }

    class SourceWriter
        implements com.bumptech.glide.load.engine.cache.DiskCache.Writer
    {

        private final Object data;
        private final Encoder encoder;
        final DecodeJob this$0;

        public boolean write(File file)
        {
            File file1;
            File file2;
            boolean flag1;
            flag1 = false;
            file2 = null;
            file1 = null;
            file = fileOpener.open(file);
            file1 = file;
            file2 = file;
            boolean flag = encoder.encode(data, file);
            flag1 = flag;
            if (file != null)
            {
                try
                {
                    file.close();
                }
                // Misplaced declaration of an exception variable
                catch (File file)
                {
                    return flag;
                }
                flag1 = flag;
            }
            return flag1;
            file;
            file2 = file1;
            if (!Log.isLoggable("DecodeJob", 3))
            {
                continue; /* Loop/switch isn't completed */
            }
            file2 = file1;
            Log.d("DecodeJob", "Failed to find file to write to disk cache", file);
            if (file1 == null) goto _L2; else goto _L1
_L1:
            break MISSING_BLOCK_LABEL_85;
_L2:
            break MISSING_BLOCK_LABEL_55;
            try
            {
                file1.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return false;
            }
            return false;
            file;
            if (file2 != null)
            {
                try
                {
                    file2.close();
                }
                catch (IOException ioexception) { }
            }
            throw file;
        }

        public SourceWriter(Encoder encoder1, Object obj)
        {
            this$0 = DecodeJob.this;
            super();
            encoder = encoder1;
            data = obj;
        }
    }


    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher fetcher;
    private final FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public DecodeJob(EngineKey enginekey, int i, int j, DataFetcher datafetcher, DataLoadProvider dataloadprovider, Transformation transformation1, ResourceTranscoder resourcetranscoder, 
            DiskCacheProvider diskcacheprovider, DiskCacheStrategy diskcachestrategy, Priority priority1)
    {
        this(enginekey, i, j, datafetcher, dataloadprovider, transformation1, resourcetranscoder, diskcacheprovider, diskcachestrategy, priority1, DEFAULT_FILE_OPENER);
    }

    DecodeJob(EngineKey enginekey, int i, int j, DataFetcher datafetcher, DataLoadProvider dataloadprovider, Transformation transformation1, ResourceTranscoder resourcetranscoder, 
            DiskCacheProvider diskcacheprovider, DiskCacheStrategy diskcachestrategy, Priority priority1, FileOpener fileopener)
    {
        resultKey = enginekey;
        width = i;
        height = j;
        fetcher = datafetcher;
        loadProvider = dataloadprovider;
        transformation = transformation1;
        transcoder = resourcetranscoder;
        diskCacheProvider = diskcacheprovider;
        diskCacheStrategy = diskcachestrategy;
        priority = priority1;
        fileOpener = fileopener;
    }

    private Resource cacheAndDecodeSourceData(Object obj)
        throws IOException
    {
        long l = LogTime.getLogTime();
        obj = new SourceWriter(loadProvider.getSourceEncoder(), obj);
        diskCacheProvider.getDiskCache().put(resultKey.getOriginalKey(), ((com.bumptech.glide.load.engine.cache.DiskCache.Writer) (obj)));
        if (Log.isLoggable("DecodeJob", 2))
        {
            logWithTimeAndKey("Wrote source to cache", l);
        }
        l = LogTime.getLogTime();
        obj = loadFromCache(resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2) && obj != null)
        {
            logWithTimeAndKey("Decoded source from cache", l);
        }
        return ((Resource) (obj));
    }

    private Resource decodeFromSourceData(Object obj)
        throws IOException
    {
        if (diskCacheStrategy.cacheSource())
        {
            obj = cacheAndDecodeSourceData(obj);
        } else
        {
            long l = LogTime.getLogTime();
            Resource resource = loadProvider.getSourceDecoder().decode(obj, width, height);
            obj = resource;
            if (Log.isLoggable("DecodeJob", 2))
            {
                logWithTimeAndKey("Decoded from source", l);
                return resource;
            }
        }
        return ((Resource) (obj));
    }

    private Resource decodeSource()
        throws Exception
    {
        Object obj;
        boolean flag;
        long l = LogTime.getLogTime();
        obj = fetcher.loadData(priority);
        if (Log.isLoggable("DecodeJob", 2))
        {
            logWithTimeAndKey("Fetched data", l);
        }
        flag = isCancelled;
        if (flag)
        {
            fetcher.cleanup();
            return null;
        }
        obj = decodeFromSourceData(obj);
        fetcher.cleanup();
        return ((Resource) (obj));
        Exception exception;
        exception;
        fetcher.cleanup();
        throw exception;
    }

    private Resource loadFromCache(Key key)
        throws IOException
    {
        Object obj = diskCacheProvider.getDiskCache().get(key);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Resource) (obj));
_L2:
        Resource resource = loadProvider.getCacheDecoder().decode(obj, width, height);
        obj = resource;
        if (resource != null) goto _L4; else goto _L3
_L3:
        diskCacheProvider.getDiskCache().delete(key);
        return resource;
        Exception exception;
        exception;
        if (true)
        {
            diskCacheProvider.getDiskCache().delete(key);
        }
        throw exception;
    }

    private void logWithTimeAndKey(String s, long l)
    {
        Log.v("DecodeJob", (new StringBuilder()).append(s).append(" in ").append(LogTime.getElapsedMillis(l)).append(resultKey).toString());
    }

    private Resource transcode(Resource resource)
    {
        if (resource == null)
        {
            return null;
        } else
        {
            return transcoder.transcode(resource);
        }
    }

    private Resource transform(Resource resource)
    {
        Resource resource1;
        if (resource == null)
        {
            resource1 = null;
        } else
        {
            Resource resource2 = transformation.transform(resource, width, height);
            resource1 = resource2;
            if (!resource.equals(resource2))
            {
                resource.recycle();
                return resource2;
            }
        }
        return resource1;
    }

    private Resource transformEncodeAndTranscode(Resource resource)
    {
        long l = LogTime.getLogTime();
        resource = transform(resource);
        if (Log.isLoggable("DecodeJob", 2))
        {
            logWithTimeAndKey("Transformed resource from source", l);
        }
        writeTransformedToCache(resource);
        l = LogTime.getLogTime();
        resource = transcode(resource);
        if (Log.isLoggable("DecodeJob", 2))
        {
            logWithTimeAndKey("Transcoded transformed from source", l);
        }
        return resource;
    }

    private void writeTransformedToCache(Resource resource)
    {
        if (resource != null && diskCacheStrategy.cacheResult())
        {
            long l = LogTime.getLogTime();
            resource = new SourceWriter(loadProvider.getEncoder(), resource);
            diskCacheProvider.getDiskCache().put(resultKey, resource);
            if (Log.isLoggable("DecodeJob", 2))
            {
                logWithTimeAndKey("Wrote transformed from source to cache", l);
                return;
            }
        }
    }

    public void cancel()
    {
        fetcher.cancel();
        isCancelled = true;
    }

    public Resource decodeFromSource()
        throws Exception
    {
        return transformEncodeAndTranscode(decodeSource());
    }

    public Resource decodeResultFromCache()
        throws Exception
    {
        Resource resource;
        if (!diskCacheStrategy.cacheResult())
        {
            resource = null;
        } else
        {
            long l = LogTime.getLogTime();
            resource = loadFromCache(resultKey);
            if (Log.isLoggable("DecodeJob", 2))
            {
                logWithTimeAndKey("Decoded transformed from cache", l);
            }
            l = LogTime.getLogTime();
            Resource resource1 = transcode(resource);
            resource = resource1;
            if (Log.isLoggable("DecodeJob", 2))
            {
                logWithTimeAndKey("Transcoded transformed from cache", l);
                return resource1;
            }
        }
        return resource;
    }

    public Resource decodeSourceFromCache()
        throws Exception
    {
        if (!diskCacheStrategy.cacheSource())
        {
            return null;
        }
        long l = LogTime.getLogTime();
        Resource resource = loadFromCache(resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2))
        {
            logWithTimeAndKey("Decoded source from cache", l);
        }
        return transformEncodeAndTranscode(resource);
    }


}
