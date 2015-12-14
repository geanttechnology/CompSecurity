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
//            ImageVideoModelLoader, ImageVideoWrapper

static class fileDescriptorFetcher
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

    public (DataFetcher datafetcher, DataFetcher datafetcher1)
    {
        streamFetcher = datafetcher;
        fileDescriptorFetcher = datafetcher1;
    }
}
