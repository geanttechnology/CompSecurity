// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelLoader, ImageVideoWrapper

public class ImageVideoModelLoader
    implements ModelLoader
{
    static class ImageVideoFetcher
        implements DataFetcher
    {

        private final DataFetcher fileDescriptorFetcher;
        private final DataFetcher streamFetcher;

        public void cancel()
        {
            if (streamFetcher != null)
            {
                streamFetcher.cancel();
            }
            if (fileDescriptorFetcher != null)
            {
                fileDescriptorFetcher.cancel();
            }
        }

        public void cleanup()
        {
            if (streamFetcher != null)
            {
                streamFetcher.cleanup();
            }
            if (fileDescriptorFetcher != null)
            {
                fileDescriptorFetcher.cleanup();
            }
        }

        public String getId()
        {
            if (streamFetcher != null)
            {
                return streamFetcher.getId();
            } else
            {
                return fileDescriptorFetcher.getId();
            }
        }

        public ImageVideoWrapper loadData(Priority priority)
            throws Exception
        {
            Object obj1 = null;
            Object obj = obj1;
            Exception exception;
            if (streamFetcher != null)
            {
                try
                {
                    obj = (InputStream)streamFetcher.loadData(priority);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    if (Log.isLoggable("IVML", 2))
                    {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", exception);
                    }
                    obj = obj1;
                    if (fileDescriptorFetcher == null)
                    {
                        throw exception;
                    }
                }
            }
            exception = null;
            obj1 = exception;
            if (fileDescriptorFetcher != null)
            {
                try
                {
                    obj1 = (ParcelFileDescriptor)fileDescriptorFetcher.loadData(priority);
                }
                // Misplaced declaration of an exception variable
                catch (Priority priority)
                {
                    if (Log.isLoggable("IVML", 2))
                    {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", priority);
                    }
                    obj1 = exception;
                    if (obj == null)
                    {
                        throw priority;
                    }
                }
            }
            return new ImageVideoWrapper(((InputStream) (obj)), ((ParcelFileDescriptor) (obj1)));
        }

        public volatile Object loadData(Priority priority)
            throws Exception
        {
            return loadData(priority);
        }

        public ImageVideoFetcher(DataFetcher datafetcher, DataFetcher datafetcher1)
        {
            streamFetcher = datafetcher;
            fileDescriptorFetcher = datafetcher1;
        }
    }


    private final ModelLoader fileDescriptorLoader;
    private final ModelLoader streamLoader;

    public ImageVideoModelLoader(ModelLoader modelloader, ModelLoader modelloader1)
    {
        if (modelloader == null && modelloader1 == null)
        {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        } else
        {
            streamLoader = modelloader;
            fileDescriptorLoader = modelloader1;
            return;
        }
    }

    public DataFetcher getResourceFetcher(Object obj, int i, int j)
    {
        DataFetcher datafetcher = null;
        if (streamLoader != null)
        {
            datafetcher = streamLoader.getResourceFetcher(obj, i, j);
        }
        DataFetcher datafetcher1 = null;
        if (fileDescriptorLoader != null)
        {
            datafetcher1 = fileDescriptorLoader.getResourceFetcher(obj, i, j);
        }
        if (datafetcher != null || datafetcher1 != null)
        {
            return new ImageVideoFetcher(datafetcher, datafetcher1);
        } else
        {
            return null;
        }
    }
}
