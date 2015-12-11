// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import java.io.InputStream;

// Referenced classes of package com.amazon.ansel.fetch:
//            UriTask, ImageRequest, LoaderException, BitmapUtil, 
//            LoaderContext

public class ImageTask extends UriTask
{

    private static final Object decodeLock = new Object();
    private final ImageRequest imageRequest;

    public ImageTask(LoaderContext loadercontext, Object obj, long l, ImageRequest imagerequest)
    {
        super(loadercontext, obj, l, imagerequest.getUriRequest());
        imageRequest = imagerequest;
    }

    public ResourceCacheValue readResponse(int i, InputStream inputstream)
        throws LoaderException
    {
        obj;
        JVM INSTR monitorenter ;
        synchronized (decodeLock)
        {
            inputstream = BitmapFactory.decodeStream(inputstream);
        }
        i = 0;
        if (inputstream != null)
        {
            int j = BitmapUtil.getBitmapByteCount(inputstream);
            i = j;
            if (imageRequest.getBitmapDensity() != 0)
            {
                inputstream.setDensity(imageRequest.getBitmapDensity());
                i = j;
            }
        }
        return new ResourceCacheValue(inputstream, i, -1L);
        inputstream;
        throw new LoaderException(inputstream);
        inputstream;
        obj;
        JVM INSTR monitorexit ;
        throw inputstream;
    }

}
