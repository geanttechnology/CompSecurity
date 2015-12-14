// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            LocalFetchProducer

public class LocalResourceFetchProducer extends LocalFetchProducer
{

    static final String PRODUCER_NAME = "LocalResourceFetchProducer";
    private final Resources mResources;

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory, Resources resources)
    {
        super(executor, pooledbytebufferfactory);
        mResources = resources;
    }

    private int getLength(ImageRequest imagerequest)
    {
        ImageRequest imagerequest2 = null;
        ImageRequest imagerequest1 = null;
        int i;
        int j;
        long l;
        try
        {
            imagerequest = mResources.openRawResourceFd(getResourceId(imagerequest));
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            i = -1;
            if (imagerequest1 != null)
            {
                try
                {
                    imagerequest1.close();
                }
                // Misplaced declaration of an exception variable
                catch (ImageRequest imagerequest)
                {
                    return -1;
                }
                return -1;
            } else
            {
                break MISSING_BLOCK_LABEL_47;
            }
        }
        finally
        {
            if (imagerequest2 != null)
            {
                try
                {
                    imagerequest2.close();
                }
                catch (IOException ioexception) { }
            }
            throw imagerequest;
        }
        imagerequest1 = imagerequest;
        imagerequest2 = imagerequest;
        l = imagerequest.getLength();
        j = (int)l;
        i = j;
        if (imagerequest != null)
        {
            try
            {
                imagerequest.close();
            }
            // Misplaced declaration of an exception variable
            catch (ImageRequest imagerequest)
            {
                return j;
            }
            i = j;
        }
        return i;
    }

    private static int getResourceId(ImageRequest imagerequest)
    {
        return Integer.parseInt(imagerequest.getSourceUri().getPath().substring(1));
    }

    protected EncodedImage getEncodedImage(ImageRequest imagerequest)
        throws IOException
    {
        return getByteBufferBackedEncodedImage(mResources.openRawResource(getResourceId(imagerequest)), getLength(imagerequest));
    }

    protected String getProducerName()
    {
        return "LocalResourceFetchProducer";
    }
}
